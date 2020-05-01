package cl.cc.powerbi.auth;

/**
 * @author CyberCastle
 */
public class AuthenticationException extends Exception {

    private static final long serialVersionUID = 1324311672110976990L;

    public AuthenticationException() {
        super();
    }

    public AuthenticationException(String message) {
        super(message);
    }

    public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthenticationException(Throwable cause) {
        super(cause);
    }

    protected AuthenticationException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
