package cl.cc.powerbi.client;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;

import cl.cc.powerbi.client.invoker.ApiClient;

@Component("cl.cc.powerbi.client.UsersApi")
public class UsersApi {
    private ApiClient apiClient;

    public UsersApi() {
        this(new ApiClient());
    }

    @Autowired
    public UsersApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Refreshes user permissions in Power BI When a user is granted permissions to
     * a workspace, app, or artifact, it might not be immediately available through
     * API calls. &lt;br/&gt;This operation refreshes user permissions and makes
     * sure the user permissions are fully updated. &lt;br/&gt;&lt;br/&gt;**Required
     * scope**: Workspace.Read.All or Workspace.ReadWrite.All&lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * &lt;h2&gt;Restrictions&lt;/h2&gt; User can call this API once per hour.
     * <p>
     * <b>200</b> - OK
     * 
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public void usersRefreshUserPermissions() throws RestClientException {
        usersRefreshUserPermissionsWithHttpInfo();
    }

    /**
     * Refreshes user permissions in Power BI When a user is granted permissions to
     * a workspace, app, or artifact, it might not be immediately available through
     * API calls. &lt;br/&gt;This operation refreshes user permissions and makes
     * sure the user permissions are fully updated. &lt;br/&gt;&lt;br/&gt;**Required
     * scope**: Workspace.Read.All or Workspace.ReadWrite.All&lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * &lt;h2&gt;Restrictions&lt;/h2&gt; User can call this API once per hour.
     * <p>
     * <b>200</b> - OK
     * 
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Void> usersRefreshUserPermissionsWithHttpInfo() throws RestClientException {
        Object postBody = null;

        String path = apiClient.expandPath("/v1.0/myorg/RefreshUserPermissions",
                Collections.<String, Object>emptyMap());

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = {};
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }
}
