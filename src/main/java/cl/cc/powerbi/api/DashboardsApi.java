package cl.cc.powerbi.api;

import cl.cc.powerbi.api.model.AddDashboardRequest;
import cl.cc.powerbi.api.model.Dashboard;
import cl.cc.powerbi.api.model.EmbedToken;
import cl.cc.powerbi.api.model.GenerateTokenRequest;
import cl.cc.powerbi.api.model.ODataResponseListDashboard;
import cl.cc.powerbi.auth.Authenticator;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author CyberCastle
 */
public class DashboardsApi extends BaseApiAbstract {

    public DashboardsApi(Authenticator auth) {
        super(auth);
    }

    public DashboardsApi(String accessToken) {
        super(accessToken);
    }

    /**
     * Add a new empty dashboard
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param requestParameters Add dashboard parameters
     * @return Dashboard
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public Dashboard addDashboard(AddDashboardRequest requestParameters) throws RestClientException {

        // Verify the required parameter 'requestParameters' is set
        if (requestParameters == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'requestParameters' when calling dashboardsAddDashboard");
        }

        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/dashboards").build().toUriString();
        ParameterizedTypeReference<Dashboard> returnType = new ParameterizedTypeReference<Dashboard>() {
        };
        return this.invokeAPI(path, HttpMethod.POST, null, requestParameters, defaultAccepts, defaultContentTypes, returnType);
    }

    /**
     * Add a new empty dashboard
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param groupId The group id
     * @param requestParameters Add dashboard parameters
     * @return Dashboard
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public Dashboard addDashboardInGroup(String groupId, AddDashboardRequest requestParameters) throws RestClientException {

        // Verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'groupId' when calling dashboardsAddDashboardInGroup");
        }

        // Verify the required parameter 'requestParameters' is set
        if (requestParameters == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'requestParameters' when calling dashboardsAddDashboardInGroup");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("groupId", groupId);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/groups/{groupId}/dashboards").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<Dashboard> returnType = new ParameterizedTypeReference<Dashboard>() {
        };
        return this.invokeAPI(path, HttpMethod.POST, null, requestParameters, defaultAccepts, defaultContentTypes, returnType);
    }

    /**
     * Generate token to view the specified dashboard
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param dashboardKey The dashboard id
     * @param requestParameters Generate token parameters
     * @return EmbedToken
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public EmbedToken generateToken(String dashboardKey, GenerateTokenRequest requestParameters) throws RestClientException {

        // Verify the required parameter 'dashboardKey' is set
        if (dashboardKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'dashboardKey' when calling dashboardsGenerateToken");
        }

        // Verify the required parameter 'requestParameters' is set
        if (requestParameters == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'requestParameters' when calling dashboardsGenerateToken");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("dashboardKey", dashboardKey);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/dashboards/{dashboardKey}/GenerateToken").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<EmbedToken> returnType = new ParameterizedTypeReference<EmbedToken>() {
        };
        return this.invokeAPI(path, HttpMethod.POST, null, requestParameters, defaultAccepts, defaultContentTypes, returnType);
    }

    /**
     * Generate token to view the specified dashboard
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param groupId The group id
     * @param dashboardKey The dashboard id
     * @param requestParameters Generate token parameters
     * @return EmbedToken
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public EmbedToken generateTokenInGroup(String groupId, String dashboardKey, GenerateTokenRequest requestParameters) throws RestClientException {

        // Verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'groupId' when calling dashboardsGenerateTokenInGroup");
        }

        // Verify the required parameter 'dashboardKey' is set
        if (dashboardKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'dashboardKey' when calling dashboardsGenerateTokenInGroup");
        }

        // Verify the required parameter 'requestParameters' is set
        if (requestParameters == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'requestParameters' when calling dashboardsGenerateTokenInGroup");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("dashboardKey", dashboardKey);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/groups/{groupId}/dashboards/{dashboardKey}/GenerateToken").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<EmbedToken> returnType = new ParameterizedTypeReference<EmbedToken>() {
        };
        return this.invokeAPI(path, HttpMethod.POST, null, requestParameters, defaultAccepts, defaultContentTypes, returnType);
    }

    /**
     * Get the specified dashboard
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param dashboardKey The dashboard id
     * @return Dashboard
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public Dashboard getDashboard(String dashboardKey) throws RestClientException {

        // Verify the required parameter 'dashboardKey' is set
        if (dashboardKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'dashboardKey' when calling dashboardsGetDashboard");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("dashboardKey", dashboardKey);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/dashboards/{dashboardKey}").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<Dashboard> returnType = new ParameterizedTypeReference<Dashboard>() {
        };
        return this.invokeAPI(path, HttpMethod.GET, null, null, defaultAccepts, defaultContentTypes, returnType);
    }

    /**
     * Get the specified dashboard in a group
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param groupId The group id
     * @param dashboardKey The dashboard id
     * @return Dashboard
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public Dashboard getDashboardInGroup(String groupId, String dashboardKey) throws RestClientException {

        // Verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'groupId' when calling dashboardsGetDashboardInGroup");
        }

        // Verify the required parameter 'dashboardKey' is set
        if (dashboardKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'dashboardKey' when calling dashboardsGetDashboardInGroup");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("dashboardKey", dashboardKey);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/groups/{groupId}/dashboards/{dashboardKey}").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<Dashboard> returnType = new ParameterizedTypeReference<Dashboard>() {
        };
        return this.invokeAPI(path, HttpMethod.GET, null, null, defaultAccepts, defaultContentTypes, returnType);
    }

    /**
     * Gets a list of dashboards
     *
     * <p>
     * <b>200</b> - OK
     *
     * @return ODataResponseListDashboard
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public ODataResponseListDashboard getDashboards() throws RestClientException {

        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/dashboards").build().toUriString();
        ParameterizedTypeReference<ODataResponseListDashboard> returnType = new ParameterizedTypeReference<ODataResponseListDashboard>() {
        };
        return this.invokeAPI(path, HttpMethod.GET, null, null, defaultAccepts, null, returnType);
    }

    /**
     * Gets a list of dashboards in a group
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param groupId The group id
     * @return ODataResponseListDashboard
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public ODataResponseListDashboard getDashboardsInGroup(String groupId) throws RestClientException {

        // Verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'groupId' when calling dashboardsGetDashboardsInGroup");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("groupId", groupId);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/groups/{groupId}/dashboards").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<ODataResponseListDashboard> returnType = new ParameterizedTypeReference<ODataResponseListDashboard>() {
        };
        return this.invokeAPI(path, HttpMethod.GET, null, null, defaultAccepts, null, returnType);
    }
}
