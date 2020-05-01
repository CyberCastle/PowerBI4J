package cl.cc.powerbi.client;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;

import cl.cc.powerbi.client.invoker.ApiClient;
import cl.cc.powerbi.client.model.AddDashboardRequest;
import cl.cc.powerbi.client.model.CloneTileRequest;
import cl.cc.powerbi.client.model.Dashboard;
import cl.cc.powerbi.client.model.Dashboards;
import cl.cc.powerbi.client.model.Tile;
import cl.cc.powerbi.client.model.Tiles;

@Component("cl.cc.powerbi.client.DashboardsApi")
public class DashboardsApi {
    private ApiClient apiClient;

    public DashboardsApi() {
        this(new ApiClient());
    }

    @Autowired
    public DashboardsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Creates a new empty dashboard on **\&quot;My Workspace\&quot;**.
     * &lt;br/&gt;**Required scope**: Content.Create &lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param requestParameters Add dashboard parameters (required)
     * @return Dashboard
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Dashboard dashboardsAddDashboard(AddDashboardRequest requestParameters) throws RestClientException {
        return dashboardsAddDashboardWithHttpInfo(requestParameters).getBody();
    }

    /**
     * Creates a new empty dashboard on **\&quot;My Workspace\&quot;**.
     * &lt;br/&gt;**Required scope**: Content.Create &lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param requestParameters Add dashboard parameters (required)
     * @return ResponseEntity&lt;Dashboard&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Dashboard> dashboardsAddDashboardWithHttpInfo(AddDashboardRequest requestParameters)
            throws RestClientException {
        Object postBody = requestParameters;

        // verify the required parameter 'requestParameters' is set
        if (requestParameters == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'requestParameters' when calling dashboardsAddDashboard");
        }

        String path = apiClient.expandPath("/v1.0/myorg/dashboards", Collections.<String, Object>emptyMap());

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { "application/json" };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Dashboard> returnType = new ParameterizedTypeReference<Dashboard>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Creates a new empty dashboard on the specified workspace.
     * &lt;br/&gt;**Required scope**: Content.Create &lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId           The workspace id (required)
     * @param requestParameters Add dashboard parameters (required)
     * @return Dashboard
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Dashboard dashboardsAddDashboardInGroup(UUID groupId, AddDashboardRequest requestParameters)
            throws RestClientException {
        return dashboardsAddDashboardInGroupWithHttpInfo(groupId, requestParameters).getBody();
    }

    /**
     * Creates a new empty dashboard on the specified workspace.
     * &lt;br/&gt;**Required scope**: Content.Create &lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId           The workspace id (required)
     * @param requestParameters Add dashboard parameters (required)
     * @return ResponseEntity&lt;Dashboard&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Dashboard> dashboardsAddDashboardInGroupWithHttpInfo(UUID groupId,
            AddDashboardRequest requestParameters) throws RestClientException {
        Object postBody = requestParameters;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling dashboardsAddDashboardInGroup");
        }

        // verify the required parameter 'requestParameters' is set
        if (requestParameters == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'requestParameters' when calling dashboardsAddDashboardInGroup");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        String path = apiClient.expandPath("/v1.0/myorg/groups/{groupId}/dashboards", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { "application/json" };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Dashboard> returnType = new ParameterizedTypeReference<Dashboard>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Clones the specified tile from **\&quot;My Workspace\&quot;**. &lt;br/&gt;If
     * target report id and target dataset are not specified, the following can
     * occur:&lt;li&gt;When a tile clone is performed within the same workspace, the
     * report and dataset links will be cloned from the source
     * tile.&lt;/li&gt;&lt;li&gt;When cloning a tile within a different workspace,
     * report and dataset links will be rested, and the tile will be
     * broken.&lt;/li&gt;&lt;br/&gt;**Required scope**: Dashboard.ReadWrite.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param dashboardId       The dashboard id (required)
     * @param tileId            The tile id (required)
     * @param requestParameters Clone tile parameters (required)
     * @return Tile
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Tile dashboardsCloneTile(UUID dashboardId, UUID tileId, CloneTileRequest requestParameters)
            throws RestClientException {
        return dashboardsCloneTileWithHttpInfo(dashboardId, tileId, requestParameters).getBody();
    }

    /**
     * Clones the specified tile from **\&quot;My Workspace\&quot;**. &lt;br/&gt;If
     * target report id and target dataset are not specified, the following can
     * occur:&lt;li&gt;When a tile clone is performed within the same workspace, the
     * report and dataset links will be cloned from the source
     * tile.&lt;/li&gt;&lt;li&gt;When cloning a tile within a different workspace,
     * report and dataset links will be rested, and the tile will be
     * broken.&lt;/li&gt;&lt;br/&gt;**Required scope**: Dashboard.ReadWrite.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param dashboardId       The dashboard id (required)
     * @param tileId            The tile id (required)
     * @param requestParameters Clone tile parameters (required)
     * @return ResponseEntity&lt;Tile&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Tile> dashboardsCloneTileWithHttpInfo(UUID dashboardId, UUID tileId,
            CloneTileRequest requestParameters) throws RestClientException {
        Object postBody = requestParameters;

        // verify the required parameter 'dashboardId' is set
        if (dashboardId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'dashboardId' when calling dashboardsCloneTile");
        }

        // verify the required parameter 'tileId' is set
        if (tileId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'tileId' when calling dashboardsCloneTile");
        }

        // verify the required parameter 'requestParameters' is set
        if (requestParameters == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'requestParameters' when calling dashboardsCloneTile");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("dashboardId", dashboardId);
        uriVariables.put("tileId", tileId);
        String path = apiClient.expandPath("/v1.0/myorg/dashboards/{dashboardId}/tiles/{tileId}/Clone", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { "application/json" };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Tile> returnType = new ParameterizedTypeReference<Tile>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Clones the specified tile from the specified workspace. &lt;br/&gt;If target
     * report id and target dataset are missing, the following can
     * occur:&lt;li&gt;When a tile clone is performed within the same workspace, the
     * report and dataset links will be cloned from the source
     * tile.&lt;/li&gt;&lt;li&gt;If you are cloning a tile within a different
     * workspace, report and dataset links will be rested. The tile will be
     * broken.&lt;/li&gt;&lt;br/&gt;**Required scope**: Dashboard.ReadWrite.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId           The workspace id (required)
     * @param dashboardId       The dashboard id (required)
     * @param tileId            The tile id (required)
     * @param requestParameters Clone tile parameters (required)
     * @return Tile
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Tile dashboardsCloneTileInGroup(UUID groupId, UUID dashboardId, UUID tileId,
            CloneTileRequest requestParameters) throws RestClientException {
        return dashboardsCloneTileInGroupWithHttpInfo(groupId, dashboardId, tileId, requestParameters).getBody();
    }

    /**
     * Clones the specified tile from the specified workspace. &lt;br/&gt;If target
     * report id and target dataset are missing, the following can
     * occur:&lt;li&gt;When a tile clone is performed within the same workspace, the
     * report and dataset links will be cloned from the source
     * tile.&lt;/li&gt;&lt;li&gt;If you are cloning a tile within a different
     * workspace, report and dataset links will be rested. The tile will be
     * broken.&lt;/li&gt;&lt;br/&gt;**Required scope**: Dashboard.ReadWrite.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId           The workspace id (required)
     * @param dashboardId       The dashboard id (required)
     * @param tileId            The tile id (required)
     * @param requestParameters Clone tile parameters (required)
     * @return ResponseEntity&lt;Tile&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Tile> dashboardsCloneTileInGroupWithHttpInfo(UUID groupId, UUID dashboardId, UUID tileId,
            CloneTileRequest requestParameters) throws RestClientException {
        Object postBody = requestParameters;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling dashboardsCloneTileInGroup");
        }

        // verify the required parameter 'dashboardId' is set
        if (dashboardId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'dashboardId' when calling dashboardsCloneTileInGroup");
        }

        // verify the required parameter 'tileId' is set
        if (tileId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'tileId' when calling dashboardsCloneTileInGroup");
        }

        // verify the required parameter 'requestParameters' is set
        if (requestParameters == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'requestParameters' when calling dashboardsCloneTileInGroup");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("dashboardId", dashboardId);
        uriVariables.put("tileId", tileId);
        String path = apiClient.expandPath("/v1.0/myorg/groups/{groupId}/dashboards/{dashboardId}/tiles/{tileId}/Clone",
                uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { "application/json" };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Tile> returnType = new ParameterizedTypeReference<Tile>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Returns the specified dashboard from **\&quot;My Workspace\&quot;**.
     * &lt;br/&gt;**Required scope**: Dashboard.ReadWrite.All or Dashboard.Read.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param dashboardId The dashboard id (required)
     * @return Dashboard
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Dashboard dashboardsGetDashboard(UUID dashboardId) throws RestClientException {
        return dashboardsGetDashboardWithHttpInfo(dashboardId).getBody();
    }

    /**
     * Returns the specified dashboard from **\&quot;My Workspace\&quot;**.
     * &lt;br/&gt;**Required scope**: Dashboard.ReadWrite.All or Dashboard.Read.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param dashboardId The dashboard id (required)
     * @return ResponseEntity&lt;Dashboard&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Dashboard> dashboardsGetDashboardWithHttpInfo(UUID dashboardId) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'dashboardId' is set
        if (dashboardId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'dashboardId' when calling dashboardsGetDashboard");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("dashboardId", dashboardId);
        String path = apiClient.expandPath("/v1.0/myorg/dashboards/{dashboardId}", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Dashboard> returnType = new ParameterizedTypeReference<Dashboard>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Returns the specified dashboard from the specified workspace.
     * &lt;br/&gt;**Required scope**: Dashboard.ReadWrite.All or Dashboard.Read.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId     The workspace id (required)
     * @param dashboardId The dashboard id (required)
     * @return Dashboard
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Dashboard dashboardsGetDashboardInGroup(UUID groupId, UUID dashboardId) throws RestClientException {
        return dashboardsGetDashboardInGroupWithHttpInfo(groupId, dashboardId).getBody();
    }

    /**
     * Returns the specified dashboard from the specified workspace.
     * &lt;br/&gt;**Required scope**: Dashboard.ReadWrite.All or Dashboard.Read.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId     The workspace id (required)
     * @param dashboardId The dashboard id (required)
     * @return ResponseEntity&lt;Dashboard&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Dashboard> dashboardsGetDashboardInGroupWithHttpInfo(UUID groupId, UUID dashboardId)
            throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling dashboardsGetDashboardInGroup");
        }

        // verify the required parameter 'dashboardId' is set
        if (dashboardId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'dashboardId' when calling dashboardsGetDashboardInGroup");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("dashboardId", dashboardId);
        String path = apiClient.expandPath("/v1.0/myorg/groups/{groupId}/dashboards/{dashboardId}", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Dashboard> returnType = new ParameterizedTypeReference<Dashboard>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Returns a list of dashboards from **\&quot;My Workspace\&quot;**.
     * &lt;br/&gt;**Required scope**: Dashboard.ReadWrite.All or Dashboard.Read.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @return Dashboards
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Dashboards dashboardsGetDashboards() throws RestClientException {
        return dashboardsGetDashboardsWithHttpInfo().getBody();
    }

    /**
     * Returns a list of dashboards from **\&quot;My Workspace\&quot;**.
     * &lt;br/&gt;**Required scope**: Dashboard.ReadWrite.All or Dashboard.Read.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @return ResponseEntity&lt;Dashboards&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Dashboards> dashboardsGetDashboardsWithHttpInfo() throws RestClientException {
        Object postBody = null;

        String path = apiClient.expandPath("/v1.0/myorg/dashboards", Collections.<String, Object>emptyMap());

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Dashboards> returnType = new ParameterizedTypeReference<Dashboards>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Returns a list of dashboards from the specified workspace.
     * &lt;br/&gt;**Required scope**: Dashboard.ReadWrite.All or Dashboard.Read.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId The workspace id (required)
     * @return Dashboards
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Dashboards dashboardsGetDashboardsInGroup(UUID groupId) throws RestClientException {
        return dashboardsGetDashboardsInGroupWithHttpInfo(groupId).getBody();
    }

    /**
     * Returns a list of dashboards from the specified workspace.
     * &lt;br/&gt;**Required scope**: Dashboard.ReadWrite.All or Dashboard.Read.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId The workspace id (required)
     * @return ResponseEntity&lt;Dashboards&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Dashboards> dashboardsGetDashboardsInGroupWithHttpInfo(UUID groupId)
            throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling dashboardsGetDashboardsInGroup");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        String path = apiClient.expandPath("/v1.0/myorg/groups/{groupId}/dashboards", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Dashboards> returnType = new ParameterizedTypeReference<Dashboards>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Returns the specified tile within the specified dashboard from **\&quot;My
     * Workspace\&quot;**. **Note**: All tile types are supported except for
     * \&quot;model tiles\&quot;, which include datasets and live tiles that contain
     * an entire report page. &lt;br/&gt;&lt;br/&gt;**Required scope**:
     * Dashboard.ReadWrite.All or Dashboard.Read.All &lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param dashboardId The dashboard id (required)
     * @param tileId      The tile id (required)
     * @return Tile
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Tile dashboardsGetTile(UUID dashboardId, UUID tileId) throws RestClientException {
        return dashboardsGetTileWithHttpInfo(dashboardId, tileId).getBody();
    }

    /**
     * Returns the specified tile within the specified dashboard from **\&quot;My
     * Workspace\&quot;**. **Note**: All tile types are supported except for
     * \&quot;model tiles\&quot;, which include datasets and live tiles that contain
     * an entire report page. &lt;br/&gt;&lt;br/&gt;**Required scope**:
     * Dashboard.ReadWrite.All or Dashboard.Read.All &lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param dashboardId The dashboard id (required)
     * @param tileId      The tile id (required)
     * @return ResponseEntity&lt;Tile&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Tile> dashboardsGetTileWithHttpInfo(UUID dashboardId, UUID tileId)
            throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'dashboardId' is set
        if (dashboardId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'dashboardId' when calling dashboardsGetTile");
        }

        // verify the required parameter 'tileId' is set
        if (tileId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'tileId' when calling dashboardsGetTile");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("dashboardId", dashboardId);
        uriVariables.put("tileId", tileId);
        String path = apiClient.expandPath("/v1.0/myorg/dashboards/{dashboardId}/tiles/{tileId}", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Tile> returnType = new ParameterizedTypeReference<Tile>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Returns the specified tile within the specified dashboard from the specified
     * workspace. **Note**: All tile types are supported except for \&quot;model
     * tiles\&quot;, which include datasets and live tiles that contain an entire
     * report page. &lt;br/&gt;&lt;br/&gt;**Required scope**:
     * Dashboard.ReadWrite.All or Dashboard.Read.All &lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId     The workspace id (required)
     * @param dashboardId The dashboard id (required)
     * @param tileId      The tile id (required)
     * @return Tile
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Tile dashboardsGetTileInGroup(UUID groupId, UUID dashboardId, UUID tileId) throws RestClientException {
        return dashboardsGetTileInGroupWithHttpInfo(groupId, dashboardId, tileId).getBody();
    }

    /**
     * Returns the specified tile within the specified dashboard from the specified
     * workspace. **Note**: All tile types are supported except for \&quot;model
     * tiles\&quot;, which include datasets and live tiles that contain an entire
     * report page. &lt;br/&gt;&lt;br/&gt;**Required scope**:
     * Dashboard.ReadWrite.All or Dashboard.Read.All &lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId     The workspace id (required)
     * @param dashboardId The dashboard id (required)
     * @param tileId      The tile id (required)
     * @return ResponseEntity&lt;Tile&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Tile> dashboardsGetTileInGroupWithHttpInfo(UUID groupId, UUID dashboardId, UUID tileId)
            throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling dashboardsGetTileInGroup");
        }

        // verify the required parameter 'dashboardId' is set
        if (dashboardId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'dashboardId' when calling dashboardsGetTileInGroup");
        }

        // verify the required parameter 'tileId' is set
        if (tileId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'tileId' when calling dashboardsGetTileInGroup");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("dashboardId", dashboardId);
        uriVariables.put("tileId", tileId);
        String path = apiClient.expandPath("/v1.0/myorg/groups/{groupId}/dashboards/{dashboardId}/tiles/{tileId}",
                uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Tile> returnType = new ParameterizedTypeReference<Tile>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Returns a list of tiles within the specified dashboard from **\&quot;My
     * Workspace\&quot;**. **Note**: All tile types are supported except for
     * \&quot;model tiles\&quot;, which include datasets and live tiles that contain
     * an entire report page. &lt;br/&gt;&lt;br/&gt;**Required scope**:
     * Dashboard.ReadWrite.All or Dashboard.Read.All &lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param dashboardId The dashboard id (required)
     * @return Tiles
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Tiles dashboardsGetTiles(UUID dashboardId) throws RestClientException {
        return dashboardsGetTilesWithHttpInfo(dashboardId).getBody();
    }

    /**
     * Returns a list of tiles within the specified dashboard from **\&quot;My
     * Workspace\&quot;**. **Note**: All tile types are supported except for
     * \&quot;model tiles\&quot;, which include datasets and live tiles that contain
     * an entire report page. &lt;br/&gt;&lt;br/&gt;**Required scope**:
     * Dashboard.ReadWrite.All or Dashboard.Read.All &lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param dashboardId The dashboard id (required)
     * @return ResponseEntity&lt;Tiles&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Tiles> dashboardsGetTilesWithHttpInfo(UUID dashboardId) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'dashboardId' is set
        if (dashboardId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'dashboardId' when calling dashboardsGetTiles");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("dashboardId", dashboardId);
        String path = apiClient.expandPath("/v1.0/myorg/dashboards/{dashboardId}/tiles", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Tiles> returnType = new ParameterizedTypeReference<Tiles>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Returns a list of tiles within the specified dashboard from the specified
     * workspace. **Note**: All tile types are supported except for \&quot;model
     * tiles\&quot;, which include datasets and live tiles that contain an entire
     * report page. &lt;br/&gt;&lt;br/&gt;**Required scope**:
     * Dashboard.ReadWrite.All or Dashboard.Read.All &lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId     The workspace id (required)
     * @param dashboardId The dashboard id (required)
     * @return Tiles
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Tiles dashboardsGetTilesInGroup(UUID groupId, UUID dashboardId) throws RestClientException {
        return dashboardsGetTilesInGroupWithHttpInfo(groupId, dashboardId).getBody();
    }

    /**
     * Returns a list of tiles within the specified dashboard from the specified
     * workspace. **Note**: All tile types are supported except for \&quot;model
     * tiles\&quot;, which include datasets and live tiles that contain an entire
     * report page. &lt;br/&gt;&lt;br/&gt;**Required scope**:
     * Dashboard.ReadWrite.All or Dashboard.Read.All &lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId     The workspace id (required)
     * @param dashboardId The dashboard id (required)
     * @return ResponseEntity&lt;Tiles&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Tiles> dashboardsGetTilesInGroupWithHttpInfo(UUID groupId, UUID dashboardId)
            throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling dashboardsGetTilesInGroup");
        }

        // verify the required parameter 'dashboardId' is set
        if (dashboardId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'dashboardId' when calling dashboardsGetTilesInGroup");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("dashboardId", dashboardId);
        String path = apiClient.expandPath("/v1.0/myorg/groups/{groupId}/dashboards/{dashboardId}/tiles", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Tiles> returnType = new ParameterizedTypeReference<Tiles>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }
}
