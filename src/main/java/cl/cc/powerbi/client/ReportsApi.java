package cl.cc.powerbi.client;

import java.io.File;
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
import cl.cc.powerbi.client.model.CloneReportRequest;
import cl.cc.powerbi.client.model.Datasources;
import cl.cc.powerbi.client.model.Export;
import cl.cc.powerbi.client.model.ExportReportRequest;
import cl.cc.powerbi.client.model.Page;
import cl.cc.powerbi.client.model.Pages;
import cl.cc.powerbi.client.model.RebindReportRequest;
import cl.cc.powerbi.client.model.Report;
import cl.cc.powerbi.client.model.Reports;
import cl.cc.powerbi.client.model.UpdateReportContentRequest;

@Component("cl.cc.powerbi.client.ReportsApi")
public class ReportsApi {
    private ApiClient apiClient;

    public ReportsApi() {
        this(new ApiClient());
    }

    @Autowired
    public ReportsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Clones the specified report from **\&quot;My Workspace\&quot;**.
     * &lt;br/&gt;If after cloning the report and its dataset reside in two
     * different upgraded workspaces or \&quot;My Workspace\&quot;, a shared dataset
     * will be created in the report&#39;s workspace. &lt;br/&gt;Reports with live
     * connection will lose the live connection when cloning, and will have a direct
     * binding to the target dataset.&lt;br/&gt;**Required scope**:
     * Content.Create&lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * &lt;br/&gt;**Required permissions**: Report - Write permissions. Target
     * dataset (if provided) - Build permissions.
     * <p>
     * <b>200</b> - OK
     * 
     * @param reportId          The report id (required)
     * @param requestParameters Clone report parameters (required)
     * @return Report
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Report reportsCloneReport(UUID reportId, CloneReportRequest requestParameters) throws RestClientException {
        return reportsCloneReportWithHttpInfo(reportId, requestParameters).getBody();
    }

    /**
     * Clones the specified report from **\&quot;My Workspace\&quot;**.
     * &lt;br/&gt;If after cloning the report and its dataset reside in two
     * different upgraded workspaces or \&quot;My Workspace\&quot;, a shared dataset
     * will be created in the report&#39;s workspace. &lt;br/&gt;Reports with live
     * connection will lose the live connection when cloning, and will have a direct
     * binding to the target dataset.&lt;br/&gt;**Required scope**:
     * Content.Create&lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * &lt;br/&gt;**Required permissions**: Report - Write permissions. Target
     * dataset (if provided) - Build permissions.
     * <p>
     * <b>200</b> - OK
     * 
     * @param reportId          The report id (required)
     * @param requestParameters Clone report parameters (required)
     * @return ResponseEntity&lt;Report&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Report> reportsCloneReportWithHttpInfo(UUID reportId, CloneReportRequest requestParameters)
            throws RestClientException {
        Object postBody = requestParameters;

        // verify the required parameter 'reportId' is set
        if (reportId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'reportId' when calling reportsCloneReport");
        }

        // verify the required parameter 'requestParameters' is set
        if (requestParameters == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'requestParameters' when calling reportsCloneReport");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("reportId", reportId);
        String path = apiClient.expandPath("/v1.0/myorg/reports/{reportId}/Clone", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { "application/json" };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Report> returnType = new ParameterizedTypeReference<Report>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Clones the specified report from the specified workspace. &lt;br/&gt;If after
     * cloning the report and its dataset reside in two different upgraded
     * workspaces or \&quot;My Workspace\&quot;, a shared dataset will be created in
     * the report&#39;s workspace. &lt;br/&gt;Reports with live connection will lose
     * the live connection when cloning, and will have a direct binding to the
     * target dataset.&lt;br/&gt;**Required scope**: Content.Create &lt;br/&gt;To
     * set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * &lt;br/&gt;**Required permissions**: Report - Write permissions. Target
     * dataset (if provided) - Build permissions
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId           The workspace id (required)
     * @param reportId          The report id (required)
     * @param requestParameters Clone report parameters (required)
     * @return Report
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Report reportsCloneReportInGroup(UUID groupId, UUID reportId, CloneReportRequest requestParameters)
            throws RestClientException {
        return reportsCloneReportInGroupWithHttpInfo(groupId, reportId, requestParameters).getBody();
    }

    /**
     * Clones the specified report from the specified workspace. &lt;br/&gt;If after
     * cloning the report and its dataset reside in two different upgraded
     * workspaces or \&quot;My Workspace\&quot;, a shared dataset will be created in
     * the report&#39;s workspace. &lt;br/&gt;Reports with live connection will lose
     * the live connection when cloning, and will have a direct binding to the
     * target dataset.&lt;br/&gt;**Required scope**: Content.Create &lt;br/&gt;To
     * set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * &lt;br/&gt;**Required permissions**: Report - Write permissions. Target
     * dataset (if provided) - Build permissions
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId           The workspace id (required)
     * @param reportId          The report id (required)
     * @param requestParameters Clone report parameters (required)
     * @return ResponseEntity&lt;Report&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Report> reportsCloneReportInGroupWithHttpInfo(UUID groupId, UUID reportId,
            CloneReportRequest requestParameters) throws RestClientException {
        Object postBody = requestParameters;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling reportsCloneReportInGroup");
        }

        // verify the required parameter 'reportId' is set
        if (reportId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'reportId' when calling reportsCloneReportInGroup");
        }

        // verify the required parameter 'requestParameters' is set
        if (requestParameters == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'requestParameters' when calling reportsCloneReportInGroup");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("reportId", reportId);
        String path = apiClient.expandPath("/v1.0/myorg/groups/{groupId}/reports/{reportId}/Clone", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { "application/json" };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Report> returnType = new ParameterizedTypeReference<Report>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Deletes the specified report from **\&quot;My Workspace\&quot;**.
     * &lt;br/&gt;**Required scope**: Report.ReadWrite.All &lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param reportId The report id (required)
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public void reportsDeleteReport(UUID reportId) throws RestClientException {
        reportsDeleteReportWithHttpInfo(reportId);
    }

    /**
     * Deletes the specified report from **\&quot;My Workspace\&quot;**.
     * &lt;br/&gt;**Required scope**: Report.ReadWrite.All &lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param reportId The report id (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Void> reportsDeleteReportWithHttpInfo(UUID reportId) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'reportId' is set
        if (reportId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'reportId' when calling reportsDeleteReport");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("reportId", reportId);
        String path = apiClient.expandPath("/v1.0/myorg/reports/{reportId}", uriVariables);

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
        return apiClient.invokeAPI(path, HttpMethod.DELETE, queryParams, postBody, headerParams, cookieParams,
                formParams, accept, contentType, authNames, returnType);
    }

    /**
     * Deletes the specified report from the specified workspace.
     * &lt;br/&gt;**Required scope**: Report.ReadWrite.All &lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId  The workspace id (required)
     * @param reportId The report id (required)
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public void reportsDeleteReportInGroup(UUID groupId, UUID reportId) throws RestClientException {
        reportsDeleteReportInGroupWithHttpInfo(groupId, reportId);
    }

    /**
     * Deletes the specified report from the specified workspace.
     * &lt;br/&gt;**Required scope**: Report.ReadWrite.All &lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId  The workspace id (required)
     * @param reportId The report id (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Void> reportsDeleteReportInGroupWithHttpInfo(UUID groupId, UUID reportId)
            throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling reportsDeleteReportInGroup");
        }

        // verify the required parameter 'reportId' is set
        if (reportId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'reportId' when calling reportsDeleteReportInGroup");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("reportId", reportId);
        String path = apiClient.expandPath("/v1.0/myorg/groups/{groupId}/reports/{reportId}", uriVariables);

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
        return apiClient.invokeAPI(path, HttpMethod.DELETE, queryParams, postBody, headerParams, cookieParams,
                formParams, accept, contentType, authNames, returnType);
    }

    /**
     * Exports the specified report from **\&quot;My Workspace\&quot;** to a .pbix
     * file. &lt;br/&gt;**Required scope**: Report.ReadWrite.All or Report.Read.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * &lt;h2&gt;Restrictions&lt;/h2&gt;Export of a report with [Power BI service
     * live
     * connection](https://docs.microsoft.com/en-us/power-bi/desktop-report-lifecycle-datasets)
     * after calling [rebind report](/rest/api/power-bi/reports/RebindReport) is not
     * supported.&lt;br/&gt;
     * <p>
     * <b>200</b> - Exported File
     * 
     * @param reportId The report id (required)
     * @return File
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public File reportsExportReport(UUID reportId) throws RestClientException {
        return reportsExportReportWithHttpInfo(reportId).getBody();
    }

    /**
     * Exports the specified report from **\&quot;My Workspace\&quot;** to a .pbix
     * file. &lt;br/&gt;**Required scope**: Report.ReadWrite.All or Report.Read.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * &lt;h2&gt;Restrictions&lt;/h2&gt;Export of a report with [Power BI service
     * live
     * connection](https://docs.microsoft.com/en-us/power-bi/desktop-report-lifecycle-datasets)
     * after calling [rebind report](/rest/api/power-bi/reports/RebindReport) is not
     * supported.&lt;br/&gt;
     * <p>
     * <b>200</b> - Exported File
     * 
     * @param reportId The report id (required)
     * @return ResponseEntity&lt;File&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<File> reportsExportReportWithHttpInfo(UUID reportId) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'reportId' is set
        if (reportId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'reportId' when calling reportsExportReport");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("reportId", reportId);
        String path = apiClient.expandPath("/v1.0/myorg/reports/{reportId}/Export", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/zip" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<File> returnType = new ParameterizedTypeReference<File>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Exports the specified report from the specified workspace to a .pbix file.
     * &lt;br/&gt;**Required scope**: Report.ReadWrite.All or Report.Read.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * &lt;h2&gt;Restrictions&lt;/h2&gt;Export of a report with [Power BI service
     * live
     * connection](https://docs.microsoft.com/en-us/power-bi/desktop-report-lifecycle-datasets)
     * after calling [rebind report](/rest/api/power-bi/reports/RebindReport) is not
     * supported.&lt;br/&gt;
     * <p>
     * <b>200</b> - Exported File
     * 
     * @param groupId  The workspace id (required)
     * @param reportId The report id (required)
     * @return File
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public File reportsExportReportInGroup(UUID groupId, UUID reportId) throws RestClientException {
        return reportsExportReportInGroupWithHttpInfo(groupId, reportId).getBody();
    }

    /**
     * Exports the specified report from the specified workspace to a .pbix file.
     * &lt;br/&gt;**Required scope**: Report.ReadWrite.All or Report.Read.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * &lt;h2&gt;Restrictions&lt;/h2&gt;Export of a report with [Power BI service
     * live
     * connection](https://docs.microsoft.com/en-us/power-bi/desktop-report-lifecycle-datasets)
     * after calling [rebind report](/rest/api/power-bi/reports/RebindReport) is not
     * supported.&lt;br/&gt;
     * <p>
     * <b>200</b> - Exported File
     * 
     * @param groupId  The workspace id (required)
     * @param reportId The report id (required)
     * @return ResponseEntity&lt;File&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<File> reportsExportReportInGroupWithHttpInfo(UUID groupId, UUID reportId)
            throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling reportsExportReportInGroup");
        }

        // verify the required parameter 'reportId' is set
        if (reportId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'reportId' when calling reportsExportReportInGroup");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("reportId", reportId);
        String path = apiClient.expandPath("/v1.0/myorg/groups/{groupId}/reports/{reportId}/Export", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/zip" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<File> returnType = new ParameterizedTypeReference<File>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Exports the specified report from **\&quot;My Workspace\&quot;** to the
     * requested format. &lt;br/&gt;**Required scope**: (all of the below)
     * &lt;ul&gt;&lt;li&gt;Report.ReadWrite.All or
     * Report.Read.All&lt;/li&gt;&lt;li&gt;Dataset.ReadWrite.All or
     * Dataset.Read.All&lt;/li&gt;&lt;/ul&gt;&lt;br/&gt;To set the permissions
     * scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).&lt;br/&gt;
     * <p>
     * <b>202</b> - Accepted
     * 
     * @param reportId          The report id (required)
     * @param requestParameters Export to file request parameters (required)
     * @return Export
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Export reportsExportToFile(UUID reportId, ExportReportRequest requestParameters) throws RestClientException {
        return reportsExportToFileWithHttpInfo(reportId, requestParameters).getBody();
    }

    /**
     * Exports the specified report from **\&quot;My Workspace\&quot;** to the
     * requested format. &lt;br/&gt;**Required scope**: (all of the below)
     * &lt;ul&gt;&lt;li&gt;Report.ReadWrite.All or
     * Report.Read.All&lt;/li&gt;&lt;li&gt;Dataset.ReadWrite.All or
     * Dataset.Read.All&lt;/li&gt;&lt;/ul&gt;&lt;br/&gt;To set the permissions
     * scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).&lt;br/&gt;
     * <p>
     * <b>202</b> - Accepted
     * 
     * @param reportId          The report id (required)
     * @param requestParameters Export to file request parameters (required)
     * @return ResponseEntity&lt;Export&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Export> reportsExportToFileWithHttpInfo(UUID reportId, ExportReportRequest requestParameters)
            throws RestClientException {
        Object postBody = requestParameters;

        // verify the required parameter 'reportId' is set
        if (reportId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'reportId' when calling reportsExportToFile");
        }

        // verify the required parameter 'requestParameters' is set
        if (requestParameters == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'requestParameters' when calling reportsExportToFile");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("reportId", reportId);
        String path = apiClient.expandPath("/v1.0/myorg/reports/{reportId}/ExportTo", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { "application/json" };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Export> returnType = new ParameterizedTypeReference<Export>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Exports the specified report from the specified workspace to the requested
     * format. &lt;br/&gt;**Required scope**: (all of the below)
     * &lt;ul&gt;&lt;li&gt;Report.ReadWrite.All or
     * Report.Read.All&lt;/li&gt;&lt;li&gt;Dataset.ReadWrite.All or
     * Dataset.Read.All&lt;/li&gt;&lt;/ul&gt;&lt;br/&gt;To set the permissions
     * scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).&lt;br/&gt;
     * <p>
     * <b>202</b> - Accepted
     * 
     * @param groupId           The workspace id (required)
     * @param reportId          The report id (required)
     * @param requestParameters Export to file request parameters (required)
     * @return Export
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Export reportsExportToFileInGroup(UUID groupId, UUID reportId, ExportReportRequest requestParameters)
            throws RestClientException {
        return reportsExportToFileInGroupWithHttpInfo(groupId, reportId, requestParameters).getBody();
    }

    /**
     * Exports the specified report from the specified workspace to the requested
     * format. &lt;br/&gt;**Required scope**: (all of the below)
     * &lt;ul&gt;&lt;li&gt;Report.ReadWrite.All or
     * Report.Read.All&lt;/li&gt;&lt;li&gt;Dataset.ReadWrite.All or
     * Dataset.Read.All&lt;/li&gt;&lt;/ul&gt;&lt;br/&gt;To set the permissions
     * scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).&lt;br/&gt;
     * <p>
     * <b>202</b> - Accepted
     * 
     * @param groupId           The workspace id (required)
     * @param reportId          The report id (required)
     * @param requestParameters Export to file request parameters (required)
     * @return ResponseEntity&lt;Export&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Export> reportsExportToFileInGroupWithHttpInfo(UUID groupId, UUID reportId,
            ExportReportRequest requestParameters) throws RestClientException {
        Object postBody = requestParameters;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling reportsExportToFileInGroup");
        }

        // verify the required parameter 'reportId' is set
        if (reportId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'reportId' when calling reportsExportToFileInGroup");
        }

        // verify the required parameter 'requestParameters' is set
        if (requestParameters == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'requestParameters' when calling reportsExportToFileInGroup");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("reportId", reportId);
        String path = apiClient.expandPath("/v1.0/myorg/groups/{groupId}/reports/{reportId}/ExportTo", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { "application/json" };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Export> returnType = new ParameterizedTypeReference<Export>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Returns a list of datasources for the specified RDL report from **\&quot;My
     * Workspace\&quot;**. &lt;br/&gt;**Required scope**: Report.ReadWrite.All or
     * Report.Read.All &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param reportId The report id (required)
     * @return Datasources
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Datasources reportsGetDatasources(UUID reportId) throws RestClientException {
        return reportsGetDatasourcesWithHttpInfo(reportId).getBody();
    }

    /**
     * Returns a list of datasources for the specified RDL report from **\&quot;My
     * Workspace\&quot;**. &lt;br/&gt;**Required scope**: Report.ReadWrite.All or
     * Report.Read.All &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param reportId The report id (required)
     * @return ResponseEntity&lt;Datasources&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Datasources> reportsGetDatasourcesWithHttpInfo(UUID reportId) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'reportId' is set
        if (reportId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'reportId' when calling reportsGetDatasources");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("reportId", reportId);
        String path = apiClient.expandPath("/v1.0/myorg/reports/{reportId}/datasources", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Datasources> returnType = new ParameterizedTypeReference<Datasources>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Returns a list of datasources for the specified RDL report from the specified
     * workspace. &lt;br/&gt;**Required scope**: Report.ReadWrite.All or
     * Reportt.Read.All &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId  The workspace id (required)
     * @param reportId (required)
     * @return Datasources
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Datasources reportsGetDatasourcesInGroup(UUID groupId, UUID reportId) throws RestClientException {
        return reportsGetDatasourcesInGroupWithHttpInfo(groupId, reportId).getBody();
    }

    /**
     * Returns a list of datasources for the specified RDL report from the specified
     * workspace. &lt;br/&gt;**Required scope**: Report.ReadWrite.All or
     * Reportt.Read.All &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId  The workspace id (required)
     * @param reportId (required)
     * @return ResponseEntity&lt;Datasources&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Datasources> reportsGetDatasourcesInGroupWithHttpInfo(UUID groupId, UUID reportId)
            throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling reportsGetDatasourcesInGroup");
        }

        // verify the required parameter 'reportId' is set
        if (reportId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'reportId' when calling reportsGetDatasourcesInGroup");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("reportId", reportId);
        String path = apiClient.expandPath("/v1.0/myorg/groups/{groupId}/reports/{reportId}/datasources", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Datasources> returnType = new ParameterizedTypeReference<Datasources>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Returns the status of the Export to file job from **\&quot;My
     * Workspace\&quot;**. &lt;br/&gt;**Required scope**: Report.ReadWrite.All or
     * Report.Read.All &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * <p>
     * <b>202</b> - Accepted
     * 
     * @param reportId The report id (required)
     * @param exportId The export id (required)
     * @return Export
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Export reportsGetExportToFileStatus(UUID reportId, String exportId) throws RestClientException {
        return reportsGetExportToFileStatusWithHttpInfo(reportId, exportId).getBody();
    }

    /**
     * Returns the status of the Export to file job from **\&quot;My
     * Workspace\&quot;**. &lt;br/&gt;**Required scope**: Report.ReadWrite.All or
     * Report.Read.All &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * <p>
     * <b>202</b> - Accepted
     * 
     * @param reportId The report id (required)
     * @param exportId The export id (required)
     * @return ResponseEntity&lt;Export&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Export> reportsGetExportToFileStatusWithHttpInfo(UUID reportId, String exportId)
            throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'reportId' is set
        if (reportId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'reportId' when calling reportsGetExportToFileStatus");
        }

        // verify the required parameter 'exportId' is set
        if (exportId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'exportId' when calling reportsGetExportToFileStatus");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("reportId", reportId);
        uriVariables.put("exportId", exportId);
        String path = apiClient.expandPath("/v1.0/myorg/reports/{reportId}/exports/{exportId}", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Export> returnType = new ParameterizedTypeReference<Export>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Returns the status of the Export to file job from the specified workspace.
     * &lt;br/&gt;**Required scope**: Report.ReadWrite.All or Report.Read.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * <p>
     * <b>202</b> - Accepted
     * 
     * @param groupId  The workspace id (required)
     * @param reportId The report id (required)
     * @param exportId The export id (required)
     * @return Export
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Export reportsGetExportToFileStatusInGroup(UUID groupId, UUID reportId, String exportId)
            throws RestClientException {
        return reportsGetExportToFileStatusInGroupWithHttpInfo(groupId, reportId, exportId).getBody();
    }

    /**
     * Returns the status of the Export to file job from the specified workspace.
     * &lt;br/&gt;**Required scope**: Report.ReadWrite.All or Report.Read.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * <p>
     * <b>202</b> - Accepted
     * 
     * @param groupId  The workspace id (required)
     * @param reportId The report id (required)
     * @param exportId The export id (required)
     * @return ResponseEntity&lt;Export&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Export> reportsGetExportToFileStatusInGroupWithHttpInfo(UUID groupId, UUID reportId,
            String exportId) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling reportsGetExportToFileStatusInGroup");
        }

        // verify the required parameter 'reportId' is set
        if (reportId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'reportId' when calling reportsGetExportToFileStatusInGroup");
        }

        // verify the required parameter 'exportId' is set
        if (exportId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'exportId' when calling reportsGetExportToFileStatusInGroup");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("reportId", reportId);
        uriVariables.put("exportId", exportId);
        String path = apiClient.expandPath("/v1.0/myorg/groups/{groupId}/reports/{reportId}/exports/{exportId}",
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

        ParameterizedTypeReference<Export> returnType = new ParameterizedTypeReference<Export>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Returns the file of the Export to file job of the specified report from
     * **\&quot;My Workspace\&quot;**. &lt;br/&gt;**Required scope**:
     * Report.ReadWrite.All or Report.Read.All &lt;br/&gt;To set the permissions
     * scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - The exported file
     * 
     * @param reportId The report id (required)
     * @param exportId The export id (required)
     * @return File
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public File reportsGetFileOfExportToFile(UUID reportId, String exportId) throws RestClientException {
        return reportsGetFileOfExportToFileWithHttpInfo(reportId, exportId).getBody();
    }

    /**
     * Returns the file of the Export to file job of the specified report from
     * **\&quot;My Workspace\&quot;**. &lt;br/&gt;**Required scope**:
     * Report.ReadWrite.All or Report.Read.All &lt;br/&gt;To set the permissions
     * scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - The exported file
     * 
     * @param reportId The report id (required)
     * @param exportId The export id (required)
     * @return ResponseEntity&lt;File&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<File> reportsGetFileOfExportToFileWithHttpInfo(UUID reportId, String exportId)
            throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'reportId' is set
        if (reportId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'reportId' when calling reportsGetFileOfExportToFile");
        }

        // verify the required parameter 'exportId' is set
        if (exportId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'exportId' when calling reportsGetFileOfExportToFile");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("reportId", reportId);
        uriVariables.put("exportId", exportId);
        String path = apiClient.expandPath("/v1.0/myorg/reports/{reportId}/exports/{exportId}/file", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/_*", "image/_*", "text/csv", "text/xml", "multipart/related" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<File> returnType = new ParameterizedTypeReference<File>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Returns the file of the Export to file job of the specified report from the
     * specified group. &lt;br/&gt;**Required scope**: Report.ReadWrite.All or
     * Report.Read.All &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - The exported file
     * 
     * @param groupId  The workspace id (required)
     * @param reportId The report id (required)
     * @param exportId The export id (required)
     * @return File
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public File reportsGetFileOfExportToFileInGroup(UUID groupId, UUID reportId, String exportId)
            throws RestClientException {
        return reportsGetFileOfExportToFileInGroupWithHttpInfo(groupId, reportId, exportId).getBody();
    }

    /**
     * Returns the file of the Export to file job of the specified report from the
     * specified group. &lt;br/&gt;**Required scope**: Report.ReadWrite.All or
     * Report.Read.All &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - The exported file
     * 
     * @param groupId  The workspace id (required)
     * @param reportId The report id (required)
     * @param exportId The export id (required)
     * @return ResponseEntity&lt;File&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<File> reportsGetFileOfExportToFileInGroupWithHttpInfo(UUID groupId, UUID reportId,
            String exportId) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling reportsGetFileOfExportToFileInGroup");
        }

        // verify the required parameter 'reportId' is set
        if (reportId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'reportId' when calling reportsGetFileOfExportToFileInGroup");
        }

        // verify the required parameter 'exportId' is set
        if (exportId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'exportId' when calling reportsGetFileOfExportToFileInGroup");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("reportId", reportId);
        uriVariables.put("exportId", exportId);
        String path = apiClient.expandPath("/v1.0/myorg/groups/{groupId}/reports/{reportId}/exports/{exportId}/file",
                uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/_*", "image/_*", "text/csv", "text/xml", "multipart/related" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<File> returnType = new ParameterizedTypeReference<File>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Returns the specified page within the specified report from **\&quot;My
     * Workspace\&quot;**. &lt;br/&gt;**Required scope**: Report.ReadWrite.All or
     * Report.Read.All &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param reportId The report id (required)
     * @param pageName The page name (required)
     * @return Page
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Page reportsGetPage(UUID reportId, String pageName) throws RestClientException {
        return reportsGetPageWithHttpInfo(reportId, pageName).getBody();
    }

    /**
     * Returns the specified page within the specified report from **\&quot;My
     * Workspace\&quot;**. &lt;br/&gt;**Required scope**: Report.ReadWrite.All or
     * Report.Read.All &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param reportId The report id (required)
     * @param pageName The page name (required)
     * @return ResponseEntity&lt;Page&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Page> reportsGetPageWithHttpInfo(UUID reportId, String pageName) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'reportId' is set
        if (reportId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'reportId' when calling reportsGetPage");
        }

        // verify the required parameter 'pageName' is set
        if (pageName == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'pageName' when calling reportsGetPage");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("reportId", reportId);
        uriVariables.put("pageName", pageName);
        String path = apiClient.expandPath("/v1.0/myorg/reports/{reportId}/pages/{pageName}", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Page> returnType = new ParameterizedTypeReference<Page>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Returns the specified page within the specified report from the specified
     * workspace. &lt;br/&gt;**Required scope**: Report.ReadWrite.All or
     * Report.Read.All &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId  The workspace id (required)
     * @param reportId The report id (required)
     * @param pageName The page name (required)
     * @return Page
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Page reportsGetPageInGroup(UUID groupId, UUID reportId, String pageName) throws RestClientException {
        return reportsGetPageInGroupWithHttpInfo(groupId, reportId, pageName).getBody();
    }

    /**
     * Returns the specified page within the specified report from the specified
     * workspace. &lt;br/&gt;**Required scope**: Report.ReadWrite.All or
     * Report.Read.All &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId  The workspace id (required)
     * @param reportId The report id (required)
     * @param pageName The page name (required)
     * @return ResponseEntity&lt;Page&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Page> reportsGetPageInGroupWithHttpInfo(UUID groupId, UUID reportId, String pageName)
            throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling reportsGetPageInGroup");
        }

        // verify the required parameter 'reportId' is set
        if (reportId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'reportId' when calling reportsGetPageInGroup");
        }

        // verify the required parameter 'pageName' is set
        if (pageName == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'pageName' when calling reportsGetPageInGroup");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("reportId", reportId);
        uriVariables.put("pageName", pageName);
        String path = apiClient.expandPath("/v1.0/myorg/groups/{groupId}/reports/{reportId}/pages/{pageName}",
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

        ParameterizedTypeReference<Page> returnType = new ParameterizedTypeReference<Page>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Returns a list of pages within the specified report from **\&quot;My
     * Workspace\&quot;**. &lt;br/&gt;**Required scope**: Report.ReadWrite.All or
     * Report.Read.All &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param reportId The report id (required)
     * @return Pages
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Pages reportsGetPages(UUID reportId) throws RestClientException {
        return reportsGetPagesWithHttpInfo(reportId).getBody();
    }

    /**
     * Returns a list of pages within the specified report from **\&quot;My
     * Workspace\&quot;**. &lt;br/&gt;**Required scope**: Report.ReadWrite.All or
     * Report.Read.All &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param reportId The report id (required)
     * @return ResponseEntity&lt;Pages&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Pages> reportsGetPagesWithHttpInfo(UUID reportId) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'reportId' is set
        if (reportId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'reportId' when calling reportsGetPages");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("reportId", reportId);
        String path = apiClient.expandPath("/v1.0/myorg/reports/{reportId}/pages", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Pages> returnType = new ParameterizedTypeReference<Pages>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Returns a list of pages within the specified report from the specified
     * workspace. &lt;br/&gt;**Required scope**: Report.ReadWrite.All or
     * Report.Read.All &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId  The workspace id (required)
     * @param reportId The report id (required)
     * @return Pages
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Pages reportsGetPagesInGroup(UUID groupId, UUID reportId) throws RestClientException {
        return reportsGetPagesInGroupWithHttpInfo(groupId, reportId).getBody();
    }

    /**
     * Returns a list of pages within the specified report from the specified
     * workspace. &lt;br/&gt;**Required scope**: Report.ReadWrite.All or
     * Report.Read.All &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId  The workspace id (required)
     * @param reportId The report id (required)
     * @return ResponseEntity&lt;Pages&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Pages> reportsGetPagesInGroupWithHttpInfo(UUID groupId, UUID reportId)
            throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling reportsGetPagesInGroup");
        }

        // verify the required parameter 'reportId' is set
        if (reportId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'reportId' when calling reportsGetPagesInGroup");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("reportId", reportId);
        String path = apiClient.expandPath("/v1.0/myorg/groups/{groupId}/reports/{reportId}/pages", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Pages> returnType = new ParameterizedTypeReference<Pages>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Returns the specified report from **\&quot;My Workspace\&quot;**.
     * &lt;br/&gt;**Required scope**: Report.ReadWrite.All or Report.Read.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param reportId The report id (required)
     * @return Report
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Report reportsGetReport(UUID reportId) throws RestClientException {
        return reportsGetReportWithHttpInfo(reportId).getBody();
    }

    /**
     * Returns the specified report from **\&quot;My Workspace\&quot;**.
     * &lt;br/&gt;**Required scope**: Report.ReadWrite.All or Report.Read.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param reportId The report id (required)
     * @return ResponseEntity&lt;Report&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Report> reportsGetReportWithHttpInfo(UUID reportId) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'reportId' is set
        if (reportId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'reportId' when calling reportsGetReport");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("reportId", reportId);
        String path = apiClient.expandPath("/v1.0/myorg/reports/{reportId}", uriVariables);

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
     * Returns the specified report from the specified workspace.
     * &lt;br/&gt;**Required scope**: Report.ReadWrite.All or Report.Read.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId  The workspace id (required)
     * @param reportId The report id (required)
     * @return Report
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Report reportsGetReportInGroup(UUID groupId, UUID reportId) throws RestClientException {
        return reportsGetReportInGroupWithHttpInfo(groupId, reportId).getBody();
    }

    /**
     * Returns the specified report from the specified workspace.
     * &lt;br/&gt;**Required scope**: Report.ReadWrite.All or Report.Read.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId  The workspace id (required)
     * @param reportId The report id (required)
     * @return ResponseEntity&lt;Report&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Report> reportsGetReportInGroupWithHttpInfo(UUID groupId, UUID reportId)
            throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling reportsGetReportInGroup");
        }

        // verify the required parameter 'reportId' is set
        if (reportId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'reportId' when calling reportsGetReportInGroup");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("reportId", reportId);
        String path = apiClient.expandPath("/v1.0/myorg/groups/{groupId}/reports/{reportId}", uriVariables);

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
     * Returns a list of reports from **\&quot;My Workspace\&quot;**.
     * &lt;br/&gt;**Required scope**: Report.ReadWrite.All or Report.Read.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @return Reports
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Reports reportsGetReports() throws RestClientException {
        return reportsGetReportsWithHttpInfo().getBody();
    }

    /**
     * Returns a list of reports from **\&quot;My Workspace\&quot;**.
     * &lt;br/&gt;**Required scope**: Report.ReadWrite.All or Report.Read.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @return ResponseEntity&lt;Reports&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Reports> reportsGetReportsWithHttpInfo() throws RestClientException {
        Object postBody = null;

        String path = apiClient.expandPath("/v1.0/myorg/reports", Collections.<String, Object>emptyMap());

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
     * Returns a list of reports from the specified workspace. &lt;br/&gt;**Required
     * scope**: Report.ReadWrite.All or Report.Read.All &lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId The workspace id (required)
     * @return Reports
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Reports reportsGetReportsInGroup(UUID groupId) throws RestClientException {
        return reportsGetReportsInGroupWithHttpInfo(groupId).getBody();
    }

    /**
     * Returns a list of reports from the specified workspace. &lt;br/&gt;**Required
     * scope**: Report.ReadWrite.All or Report.Read.All &lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId The workspace id (required)
     * @return ResponseEntity&lt;Reports&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Reports> reportsGetReportsInGroupWithHttpInfo(UUID groupId) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling reportsGetReportsInGroup");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        String path = apiClient.expandPath("/v1.0/myorg/groups/{groupId}/reports", uriVariables);

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
     * Rebinds the specified report from **\&quot;My Workspace\&quot;** to the
     * requested dataset. &lt;br/&gt;If the dataset resides in a different upgraded
     * workspace, a shared dataset will be created in \&quot;My
     * Workspace\&quot;.&lt;br/&gt;Reports with live connection will lose the live
     * connection when rebinding, and will have a direct binding to the target
     * dataset.&lt;br/&gt;**Required scope**: Report.ReadWrite.All &lt;br/&gt;To set
     * the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * &lt;br/&gt;**Required permissions**: Report - Write permissions. Target
     * dataset - Build permissions.
     * <p>
     * <b>200</b> - OK
     * 
     * @param reportId          The report id (required)
     * @param requestParameters Rebind report parameters (required)
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public void reportsRebindReport(UUID reportId, RebindReportRequest requestParameters) throws RestClientException {
        reportsRebindReportWithHttpInfo(reportId, requestParameters);
    }

    /**
     * Rebinds the specified report from **\&quot;My Workspace\&quot;** to the
     * requested dataset. &lt;br/&gt;If the dataset resides in a different upgraded
     * workspace, a shared dataset will be created in \&quot;My
     * Workspace\&quot;.&lt;br/&gt;Reports with live connection will lose the live
     * connection when rebinding, and will have a direct binding to the target
     * dataset.&lt;br/&gt;**Required scope**: Report.ReadWrite.All &lt;br/&gt;To set
     * the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * &lt;br/&gt;**Required permissions**: Report - Write permissions. Target
     * dataset - Build permissions.
     * <p>
     * <b>200</b> - OK
     * 
     * @param reportId          The report id (required)
     * @param requestParameters Rebind report parameters (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Void> reportsRebindReportWithHttpInfo(UUID reportId, RebindReportRequest requestParameters)
            throws RestClientException {
        Object postBody = requestParameters;

        // verify the required parameter 'reportId' is set
        if (reportId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'reportId' when calling reportsRebindReport");
        }

        // verify the required parameter 'requestParameters' is set
        if (requestParameters == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'requestParameters' when calling reportsRebindReport");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("reportId", reportId);
        String path = apiClient.expandPath("/v1.0/myorg/reports/{reportId}/Rebind", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = {};
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { "application/json" };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Rebinds the specified report from the specified workspace to the requested
     * dataset. &lt;br/&gt;If the dataset resides in a different upgraded workspace
     * or in \&quot;My Workspace\&quot;, a shared dataset will be created in the
     * report&#39;s workspace.&lt;br/&gt;Reports with live connection will lose the
     * live connection when rebinding, and will have a direct binding to the target
     * dataset.&lt;br/&gt;**Required scope**: Report.ReadWrite.All &lt;br/&gt;To set
     * the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * &lt;br/&gt;**Required permissions**: Report - Write permissions. Target
     * dataset - Build permissions
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId           The workspace id (required)
     * @param reportId          The report id (required)
     * @param requestParameters Rebind report parameters (required)
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public void reportsRebindReportInGroup(UUID groupId, UUID reportId, RebindReportRequest requestParameters)
            throws RestClientException {
        reportsRebindReportInGroupWithHttpInfo(groupId, reportId, requestParameters);
    }

    /**
     * Rebinds the specified report from the specified workspace to the requested
     * dataset. &lt;br/&gt;If the dataset resides in a different upgraded workspace
     * or in \&quot;My Workspace\&quot;, a shared dataset will be created in the
     * report&#39;s workspace.&lt;br/&gt;Reports with live connection will lose the
     * live connection when rebinding, and will have a direct binding to the target
     * dataset.&lt;br/&gt;**Required scope**: Report.ReadWrite.All &lt;br/&gt;To set
     * the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * &lt;br/&gt;**Required permissions**: Report - Write permissions. Target
     * dataset - Build permissions
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId           The workspace id (required)
     * @param reportId          The report id (required)
     * @param requestParameters Rebind report parameters (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Void> reportsRebindReportInGroupWithHttpInfo(UUID groupId, UUID reportId,
            RebindReportRequest requestParameters) throws RestClientException {
        Object postBody = requestParameters;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling reportsRebindReportInGroup");
        }

        // verify the required parameter 'reportId' is set
        if (reportId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'reportId' when calling reportsRebindReportInGroup");
        }

        // verify the required parameter 'requestParameters' is set
        if (requestParameters == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'requestParameters' when calling reportsRebindReportInGroup");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("reportId", reportId);
        String path = apiClient.expandPath("/v1.0/myorg/groups/{groupId}/reports/{reportId}/Rebind", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = {};
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { "application/json" };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Updates the specified report from **\&quot;My Workspace\&quot;** to have the
     * same content as the report in the request body. &lt;br/&gt;**Required
     * scope**: Report.ReadWrite.All &lt;br/&gt;To set the permissions scope, see
     * [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param reportId          The report id (required)
     * @param requestParameters UpdateReportContent parameters (required)
     * @return Report
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Report reportsUpdateReportContent(UUID reportId, UpdateReportContentRequest requestParameters)
            throws RestClientException {
        return reportsUpdateReportContentWithHttpInfo(reportId, requestParameters).getBody();
    }

    /**
     * Updates the specified report from **\&quot;My Workspace\&quot;** to have the
     * same content as the report in the request body. &lt;br/&gt;**Required
     * scope**: Report.ReadWrite.All &lt;br/&gt;To set the permissions scope, see
     * [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param reportId          The report id (required)
     * @param requestParameters UpdateReportContent parameters (required)
     * @return ResponseEntity&lt;Report&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Report> reportsUpdateReportContentWithHttpInfo(UUID reportId,
            UpdateReportContentRequest requestParameters) throws RestClientException {
        Object postBody = requestParameters;

        // verify the required parameter 'reportId' is set
        if (reportId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'reportId' when calling reportsUpdateReportContent");
        }

        // verify the required parameter 'requestParameters' is set
        if (requestParameters == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'requestParameters' when calling reportsUpdateReportContent");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("reportId", reportId);
        String path = apiClient.expandPath("/v1.0/myorg/reports/{reportId}/UpdateReportContent", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { "application/json" };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Report> returnType = new ParameterizedTypeReference<Report>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Updates the specified report from the specified workspace to have the same
     * content as the specified report in the request body. &lt;br/&gt;**Required
     * scope**: Report.ReadWrite.All &lt;br/&gt;To set the permissions scope, see
     * [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId           The workspace id (required)
     * @param reportId          The report id (required)
     * @param requestParameters UpdateReportContent parameters (required)
     * @return Report
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Report reportsUpdateReportContentInGroup(UUID groupId, UUID reportId,
            UpdateReportContentRequest requestParameters) throws RestClientException {
        return reportsUpdateReportContentInGroupWithHttpInfo(groupId, reportId, requestParameters).getBody();
    }

    /**
     * Updates the specified report from the specified workspace to have the same
     * content as the specified report in the request body. &lt;br/&gt;**Required
     * scope**: Report.ReadWrite.All &lt;br/&gt;To set the permissions scope, see
     * [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId           The workspace id (required)
     * @param reportId          The report id (required)
     * @param requestParameters UpdateReportContent parameters (required)
     * @return ResponseEntity&lt;Report&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Report> reportsUpdateReportContentInGroupWithHttpInfo(UUID groupId, UUID reportId,
            UpdateReportContentRequest requestParameters) throws RestClientException {
        Object postBody = requestParameters;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling reportsUpdateReportContentInGroup");
        }

        // verify the required parameter 'reportId' is set
        if (reportId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'reportId' when calling reportsUpdateReportContentInGroup");
        }

        // verify the required parameter 'requestParameters' is set
        if (requestParameters == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'requestParameters' when calling reportsUpdateReportContentInGroup");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("reportId", reportId);
        String path = apiClient.expandPath("/v1.0/myorg/groups/{groupId}/reports/{reportId}/UpdateReportContent",
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

        ParameterizedTypeReference<Report> returnType = new ParameterizedTypeReference<Report>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }
}
