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
import cl.cc.powerbi.client.model.App;
import cl.cc.powerbi.client.model.Apps;
import cl.cc.powerbi.client.model.Dashboard;
import cl.cc.powerbi.client.model.Dashboards;
import cl.cc.powerbi.client.model.Report;
import cl.cc.powerbi.client.model.Reports;
import cl.cc.powerbi.client.model.Tile;
import cl.cc.powerbi.client.model.Tiles;

@Component("cl.cc.powerbi.client.AppsApi")
public class AppsApi {
    private ApiClient apiClient;

    public AppsApi() {
        this(new ApiClient());
    }

    @Autowired
    public AppsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Returns the specified installed app. &lt;br/&gt;**Required scope**:
     * App.Read.All&lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param appId The app id (required)
     * @return App
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public App appsGetApp(UUID appId) throws RestClientException {
        return appsGetAppWithHttpInfo(appId).getBody();
    }

    /**
     * Returns the specified installed app. &lt;br/&gt;**Required scope**:
     * App.Read.All&lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param appId The app id (required)
     * @return ResponseEntity&lt;App&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<App> appsGetAppWithHttpInfo(UUID appId) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'appId' is set
        if (appId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'appId' when calling appsGetApp");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("appId", appId);
        String path = apiClient.expandPath("/v1.0/myorg/apps/{appId}", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<App> returnType = new ParameterizedTypeReference<App>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Returns a list of installed apps. &lt;br/&gt;**Required scope**:
     * App.Read.All&lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @return Apps
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Apps appsGetApps() throws RestClientException {
        return appsGetAppsWithHttpInfo().getBody();
    }

    /**
     * Returns a list of installed apps. &lt;br/&gt;**Required scope**:
     * App.Read.All&lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @return ResponseEntity&lt;Apps&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Apps> appsGetAppsWithHttpInfo() throws RestClientException {
        Object postBody = null;

        String path = apiClient.expandPath("/v1.0/myorg/apps", Collections.<String, Object>emptyMap());

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Apps> returnType = new ParameterizedTypeReference<Apps>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Returns the specified dashboard from the specified app. &lt;br/&gt;**Required
     * scope**: Dashboard.ReadWrite.All or Dashboard.Read.All &lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param appId       The app id (required)
     * @param dashboardId The dashboard id (required)
     * @return Dashboard
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Dashboard appsGetDashboard(UUID appId, UUID dashboardId) throws RestClientException {
        return appsGetDashboardWithHttpInfo(appId, dashboardId).getBody();
    }

    /**
     * Returns the specified dashboard from the specified app. &lt;br/&gt;**Required
     * scope**: Dashboard.ReadWrite.All or Dashboard.Read.All &lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param appId       The app id (required)
     * @param dashboardId The dashboard id (required)
     * @return ResponseEntity&lt;Dashboard&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Dashboard> appsGetDashboardWithHttpInfo(UUID appId, UUID dashboardId)
            throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'appId' is set
        if (appId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'appId' when calling appsGetDashboard");
        }

        // verify the required parameter 'dashboardId' is set
        if (dashboardId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'dashboardId' when calling appsGetDashboard");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("appId", appId);
        uriVariables.put("dashboardId", dashboardId);
        String path = apiClient.expandPath("/v1.0/myorg/apps/{appId}/dashboards/{dashboardId}", uriVariables);

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
     * Returns a list of dashboards from the specified app. &lt;br/&gt;**Required
     * scope**: Dashboard.ReadWrite.All or Dashboard.Read.All &lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param appId The app id (required)
     * @return Dashboards
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Dashboards appsGetDashboards(UUID appId) throws RestClientException {
        return appsGetDashboardsWithHttpInfo(appId).getBody();
    }

    /**
     * Returns a list of dashboards from the specified app. &lt;br/&gt;**Required
     * scope**: Dashboard.ReadWrite.All or Dashboard.Read.All &lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param appId The app id (required)
     * @return ResponseEntity&lt;Dashboards&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Dashboards> appsGetDashboardsWithHttpInfo(UUID appId) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'appId' is set
        if (appId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'appId' when calling appsGetDashboards");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("appId", appId);
        String path = apiClient.expandPath("/v1.0/myorg/apps/{appId}/dashboards", uriVariables);

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
     * Returns the specified report from the specified app. &lt;br/&gt;**Required
     * scope**: Report.ReadWrite.All or Report.Read.All &lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param appId    The app id (required)
     * @param reportId The report id (required)
     * @return Report
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Report appsGetReport(UUID appId, UUID reportId) throws RestClientException {
        return appsGetReportWithHttpInfo(appId, reportId).getBody();
    }

    /**
     * Returns the specified report from the specified app. &lt;br/&gt;**Required
     * scope**: Report.ReadWrite.All or Report.Read.All &lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param appId    The app id (required)
     * @param reportId The report id (required)
     * @return ResponseEntity&lt;Report&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Report> appsGetReportWithHttpInfo(UUID appId, UUID reportId) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'appId' is set
        if (appId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'appId' when calling appsGetReport");
        }

        // verify the required parameter 'reportId' is set
        if (reportId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'reportId' when calling appsGetReport");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("appId", appId);
        uriVariables.put("reportId", reportId);
        String path = apiClient.expandPath("/v1.0/myorg/apps/{appId}/reports/{reportId}", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Report> returnType = new ParameterizedTypeReference<Report>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Returns a list of reports from the specified app. &lt;br/&gt;**Required
     * scope**: Report.ReadWrite.All or Report.Read.All &lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param appId The app id (required)
     * @return Reports
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Reports appsGetReports(UUID appId) throws RestClientException {
        return appsGetReportsWithHttpInfo(appId).getBody();
    }

    /**
     * Returns a list of reports from the specified app. &lt;br/&gt;**Required
     * scope**: Report.ReadWrite.All or Report.Read.All &lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param appId The app id (required)
     * @return ResponseEntity&lt;Reports&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Reports> appsGetReportsWithHttpInfo(UUID appId) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'appId' is set
        if (appId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'appId' when calling appsGetReports");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("appId", appId);
        String path = apiClient.expandPath("/v1.0/myorg/apps/{appId}/reports", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Reports> returnType = new ParameterizedTypeReference<Reports>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Returns the specified tile within the specified dashboard from the specified
     * app. **Note**: All tile types are supported except for \&quot;model
     * tiles\&quot;, which include datasets and live tiles that contain an entire
     * report page. &lt;br/&gt;&lt;br/&gt;**Required scope**:
     * Dashboard.ReadWrite.All or Dashboard.Read.All &lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param appId       The app id (required)
     * @param dashboardId The dashboard id (required)
     * @param tileId      The tile id (required)
     * @return Tile
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Tile appsGetTile(UUID appId, UUID dashboardId, UUID tileId) throws RestClientException {
        return appsGetTileWithHttpInfo(appId, dashboardId, tileId).getBody();
    }

    /**
     * Returns the specified tile within the specified dashboard from the specified
     * app. **Note**: All tile types are supported except for \&quot;model
     * tiles\&quot;, which include datasets and live tiles that contain an entire
     * report page. &lt;br/&gt;&lt;br/&gt;**Required scope**:
     * Dashboard.ReadWrite.All or Dashboard.Read.All &lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param appId       The app id (required)
     * @param dashboardId The dashboard id (required)
     * @param tileId      The tile id (required)
     * @return ResponseEntity&lt;Tile&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Tile> appsGetTileWithHttpInfo(UUID appId, UUID dashboardId, UUID tileId)
            throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'appId' is set
        if (appId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'appId' when calling appsGetTile");
        }

        // verify the required parameter 'dashboardId' is set
        if (dashboardId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'dashboardId' when calling appsGetTile");
        }

        // verify the required parameter 'tileId' is set
        if (tileId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'tileId' when calling appsGetTile");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("appId", appId);
        uriVariables.put("dashboardId", dashboardId);
        uriVariables.put("tileId", tileId);
        String path = apiClient.expandPath("/v1.0/myorg/apps/{appId}/dashboards/{dashboardId}/tiles/{tileId}",
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
     * Returns a list of tiles within the specified dashboard from the specified
     * app. &lt;br/&gt;**Required scope**: Dashboard.ReadWrite.All or
     * Dashboard.Read.All &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param appId       The app id (required)
     * @param dashboardId The dashboard id (required)
     * @return Tiles
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Tiles appsGetTiles(UUID appId, UUID dashboardId) throws RestClientException {
        return appsGetTilesWithHttpInfo(appId, dashboardId).getBody();
    }

    /**
     * Returns a list of tiles within the specified dashboard from the specified
     * app. &lt;br/&gt;**Required scope**: Dashboard.ReadWrite.All or
     * Dashboard.Read.All &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param appId       The app id (required)
     * @param dashboardId The dashboard id (required)
     * @return ResponseEntity&lt;Tiles&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Tiles> appsGetTilesWithHttpInfo(UUID appId, UUID dashboardId) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'appId' is set
        if (appId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'appId' when calling appsGetTiles");
        }

        // verify the required parameter 'dashboardId' is set
        if (dashboardId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'dashboardId' when calling appsGetTiles");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("appId", appId);
        uriVariables.put("dashboardId", dashboardId);
        String path = apiClient.expandPath("/v1.0/myorg/apps/{appId}/dashboards/{dashboardId}/tiles", uriVariables);

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
