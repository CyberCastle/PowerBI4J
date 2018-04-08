package cl.cc.powerbi.auth;

import com.microsoft.aad.adal4j.AuthenticationContext;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.springframework.util.StringUtils;

/**
 *
 * @author CyberCastle, Based in code obtain from here:
 * https://github.com/satalyst/powerbi-rest-java/blob/master/src/main/java/com/satalyst/powerbi/impl/Office365Authenticator.java
 *
 */
public class Authenticator {

    private static final String DEFAULT_AUTHORITY = "https://login.microsoftonline.com/";
    private static final String DEFAULT_POWER_BI_RESOURCE_ID = "https://analysis.windows.net/powerbi/api";
    private static final boolean DEFAULT_VALIDATE_AUTHORITY = false;

    // Credentials
    private final String nativeClientId;
    private final String tenant;
    private final String username;
    private final String password;
    private boolean validateAuthority = DEFAULT_VALIDATE_AUTHORITY;

    // Thread pool
    private final ExecutorService executor;

    // Concurrent locks
    private final ReadWriteLock tokenLock = new ReentrantReadWriteLock();
    private String cachedToken;

    public Authenticator(String nativeClientId, String tenant, String username, String password, ExecutorService executor) {
        this.nativeClientId = nativeClientId;
        this.tenant = tenant;
        this.username = username;
        this.password = password;
        this.executor = executor;
    }

    public Authenticator setValidateAuthority(boolean validateAuthority) {
        this.validateAuthority = validateAuthority;
        return this;
    }

    /**
     * Performs the authentication.
     *
     * Thread-safe implementation that will cache the bearer token for multiple
     * calls to ensure that we don't make repeated, unnecessary calls to the
     * authentication service.
     *
     * @return the bearer token to use for authenticating service requests.
     * @throws AuthenticationFailureException
     */
    public String authenticate() throws AuthenticationException {
        try {
            tokenLock.readLock().lock();

            if (cachedToken == null) {
                try {
                    // release the read lock and acquire the write lock to call the implementation
                    tokenLock.readLock().unlock();
                    tokenLock.writeLock().lock();

                    // check again, it may have been set in the time it took us to acquire the write lock
                    if (cachedToken == null) {
                        cachedToken = getAccessToken();
                    }

                    // Downgrade by acquiring read lock before releasing write lock
                    tokenLock.readLock().lock();
                } finally {
                    tokenLock.writeLock().unlock();
                }
            }
        } finally {
            // TODO: in theory, if there has been an exception in the authenticate method then this unlock method
            // TODO: should fail as the downgrade of the lock was never performed. Haven't seen this issue in practice yet
            // TODO: however it looks theoretically possible.
            try {
                tokenLock.readLock().unlock();
            } catch (IllegalMonitorStateException e) {
                // ignore - see TODO above for reasoning....
            }
        }

        return cachedToken;
    }

    public void reset() {
        try {
            tokenLock.writeLock().lock();
            cachedToken = null;
        } finally {
            tokenLock.writeLock().unlock();
        }
    }

    private String getAccessToken() throws AuthenticationException {
        try {
            AuthenticationContext authenticationContext = new AuthenticationContext(
                    DEFAULT_AUTHORITY + this.tenant,
                    validateAuthority,
                    executor
            );

            String result
                    = authenticationContext.acquireToken(DEFAULT_POWER_BI_RESOURCE_ID,
                            nativeClientId,
                            username,
                            password, null
                    ).get().getAccessToken();

            if (StringUtils.isEmpty(result)) {
                throw new AuthenticationException("Returned access token is null.");
            }

            return result;
        } catch (ExecutionException | InterruptedException | IOException e) {
            throw new AuthenticationException(e);
        }
    }
}
