package cl.cc.powerbi.api;

import cl.cc.powerbi.api.model.CloneReportRequest;
import cl.cc.powerbi.api.model.EmbedToken;
import cl.cc.powerbi.api.model.GenerateTokenRequest;
import cl.cc.powerbi.api.model.ODataResponseListReport;
import cl.cc.powerbi.api.model.RebindReportRequest;
import cl.cc.powerbi.api.model.Report;
import cl.cc.powerbi.api.model.UpdateReportContentRequest;
import cl.cc.powerbi.auth.Authenticator;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author CyberCastle
 */
public class ReportsApi extends BaseApiAbstract {

    public ReportsApi(Authenticator auth) {
        super(auth);
    }

    public ReportsApi(String accessToken) {
        super(accessToken);
    }

    /**
     * Clones the specified report
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param reportKey The report id
     * @param requestParameters Clone report parameters
     * @return Report
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public Report cloneReport(String reportKey, CloneReportRequest requestParameters) throws RestClientException {

        // Verify the required parameter 'reportKey' is set
        if (reportKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'reportKey' when calling reportsCloneReport");
        }

        // Verify the required parameter 'requestParameters' is set
        if (requestParameters == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'requestParameters' when calling reportsCloneReport");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("reportKey", reportKey);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/reports/{reportKey}/Clone").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<Report> returnType = new ParameterizedTypeReference<Report>() {
        };
        return this.invokeAPI(path, HttpMethod.POST, null, requestParameters, defaultAccepts, defaultContentTypes, returnType);
    }

    /**
     * Clones the specified report
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param groupId The group id
     * @param reportKey The report id
     * @param requestParameters Clone report parameters
     * @return Report
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public Report cloneReportInGroup(String groupId, String reportKey, CloneReportRequest requestParameters) throws RestClientException {

        // Verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'groupId' when calling reportsCloneReportInGroup");
        }

        // Verify the required parameter 'reportKey' is set
        if (reportKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'reportKey' when calling reportsCloneReportInGroup");
        }

        // Verify the required parameter 'requestParameters' is set
        if (requestParameters == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'requestParameters' when calling reportsCloneReportInGroup");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("reportKey", reportKey);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/groups/{groupId}/reports/{reportKey}/Clone").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<Report> returnType = new ParameterizedTypeReference<Report>() {
        };
        return this.invokeAPI(path, HttpMethod.POST, null, requestParameters, defaultAccepts, defaultContentTypes, returnType);
    }

    /**
     * Deletes the specified report
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param reportKey The report id
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public Object deleteReport(String reportKey) throws RestClientException {

        // Verify the required parameter 'reportKey' is set
        if (reportKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'reportKey' when calling reportsDeleteReport");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("reportKey", reportKey);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/reports/{reportKey}").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {
        };
        return this.invokeAPI(path, HttpMethod.DELETE, null, null, null, null, returnType);
    }

    /**
     * Deletes the specified report
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param groupId The group id
     * @param reportKey The report id
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public Object deleteReportInGroup(String groupId, String reportKey) throws RestClientException {

        // Verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'groupId' when calling reportsDeleteReportInGroup");
        }

        // Verify the required parameter 'reportKey' is set
        if (reportKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'reportKey' when calling reportsDeleteReportInGroup");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("reportKey", reportKey);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/groups/{groupId}/reports/{reportKey}").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {
        };
        return this.invokeAPI(path, HttpMethod.DELETE, null, null, null, null, returnType);
    }

    /**
     * Exports the specified report
     *
     * <p>
     * <b>200</b> - Exported File
     *
     * @param reportKey The report id
     * @return ByteArrayResource
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public ByteArrayResource exportReport(String reportKey) throws RestClientException {

        // Verify the required parameter 'reportKey' is set
        if (reportKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'reportKey' when calling reportsExportReport");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("reportKey", reportKey);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/reports/{reportKey}/Export").buildAndExpand(uriVariables).toUriString();

        final MediaType[] accepts = {
            MediaType.parseMediaType("application/zip")
        };

        ParameterizedTypeReference<ByteArrayResource> returnType = new ParameterizedTypeReference<ByteArrayResource>() {
        };
        return this.invokeAPI(path, HttpMethod.GET, null, null, accepts, null, returnType);
    }

    /**
     * Exports the specified report
     *
     * <p>
     * <b>200</b> - Exported File
     *
     * @param groupId The group id
     * @param reportKey The report id
     * @return ByteArrayResource
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public ByteArrayResource exportReportInGroup(String groupId, String reportKey) throws RestClientException {

        // Verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'groupId' when calling reportsExportReportInGroup");
        }

        // Verify the required parameter 'reportKey' is set
        if (reportKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'reportKey' when calling reportsExportReportInGroup");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("reportKey", reportKey);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/groups/{groupId}/reports/{reportKey}/Export").buildAndExpand(uriVariables).toUriString();

        final MediaType[] accepts = {
            MediaType.parseMediaType("application/zip")
        };

        ParameterizedTypeReference<ByteArrayResource> returnType = new ParameterizedTypeReference<ByteArrayResource>() {
        };
        return this.invokeAPI(path, HttpMethod.GET, null, null, accepts, null, returnType);
    }

    /**
     * Generate token to view or edit the specified report
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param reportKey The report id
     * @param requestParameters Generate token parameters
     * @return EmbedToken
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public EmbedToken generateToken(String reportKey, GenerateTokenRequest requestParameters) throws RestClientException {

        // Verify the required parameter 'reportKey' is set
        if (reportKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'reportKey' when calling reportsGenerateToken");
        }

        // Verify the required parameter 'requestParameters' is set
        if (requestParameters == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'requestParameters' when calling reportsGenerateToken");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("reportKey", reportKey);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/reports/{reportKey}/GenerateToken").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<EmbedToken> returnType = new ParameterizedTypeReference<EmbedToken>() {
        };
        return this.invokeAPI(path, HttpMethod.POST, null, requestParameters, defaultAccepts, defaultContentTypes, returnType);
    }

    /**
     * Generate token to create a new report on a given dataset
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param requestParameters Generate token parameters
     * @return EmbedToken
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public EmbedToken generateTokenForCreate(GenerateTokenRequest requestParameters) throws RestClientException {

        // Verify the required parameter 'requestParameters' is set
        if (requestParameters == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'requestParameters' when calling reportsGenerateTokenForCreate");
        }

        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/reports/GenerateToken").build().toUriString();
        ParameterizedTypeReference<EmbedToken> returnType = new ParameterizedTypeReference<EmbedToken>() {
        };
        return this.invokeAPI(path, HttpMethod.POST, null, requestParameters, defaultAccepts, defaultContentTypes, returnType);
    }

    /**
     * Generate token to create a new report on a given dataset
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param groupId The group id
     * @param requestParameters Generate token parameters
     * @return EmbedToken
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public EmbedToken generateTokenForCreateInGroup(String groupId, GenerateTokenRequest requestParameters) throws RestClientException {

        // Verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'groupId' when calling reportsGenerateTokenForCreateInGroup");
        }

        // Verify the required parameter 'requestParameters' is set
        if (requestParameters == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'requestParameters' when calling reportsGenerateTokenForCreateInGroup");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("groupId", groupId);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/groups/{groupId}/reports/GenerateToken").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<EmbedToken> returnType = new ParameterizedTypeReference<EmbedToken>() {
        };
        return this.invokeAPI(path, HttpMethod.POST, null, requestParameters, defaultAccepts, defaultContentTypes, returnType);
    }

    /**
     * Generate token to view or edit the specified report
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param groupId The group id
     * @param reportKey The report id
     * @param requestParameters Generate token parameters
     * @return EmbedToken
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public EmbedToken generateTokenInGroup(String groupId, String reportKey, GenerateTokenRequest requestParameters) throws RestClientException {

        // Verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'groupId' when calling reportsGenerateTokenInGroup");
        }

        // Verify the required parameter 'reportKey' is set
        if (reportKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'reportKey' when calling reportsGenerateTokenInGroup");
        }

        // Verify the required parameter 'requestParameters' is set
        if (requestParameters == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'requestParameters' when calling reportsGenerateTokenInGroup");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("reportKey", reportKey);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/groups/{groupId}/reports/{reportKey}/GenerateToken").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<EmbedToken> returnType = new ParameterizedTypeReference<EmbedToken>() {
        };
        return this.invokeAPI(path, HttpMethod.POST, null, requestParameters, defaultAccepts, defaultContentTypes, returnType);
    }

    /**
     * Get the specified report
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param reportKey The report id
     * @return Report
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public Report getReport(String reportKey) throws RestClientException {

        // Verify the required parameter 'reportKey' is set
        if (reportKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'reportKey' when calling reportsGetReport");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("reportKey", reportKey);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/reports/{reportKey}").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<Report> returnType = new ParameterizedTypeReference<Report>() {
        };
        return this.invokeAPI(path, HttpMethod.GET, null, null, defaultAccepts, null, returnType);
    }

    /**
     * Get the specified report
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param groupId The group id
     * @param reportKey The report id
     * @return Report
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public Report getReportInGroup(String groupId, String reportKey) throws RestClientException {

        // Verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'groupId' when calling reportsGetReportInGroup");
        }

        // Verify the required parameter 'reportKey' is set
        if (reportKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'reportKey' when calling reportsGetReportInGroup");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("reportKey", reportKey);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/groups/{groupId}/reports/{reportKey}").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<Report> returnType = new ParameterizedTypeReference<Report>() {
        };
        return this.invokeAPI(path, HttpMethod.GET, null, null, defaultAccepts, null, returnType);
    }

    /**
     * Gets a list of reports
     *
     * <p>
     * <b>200</b> - OK
     *
     * @return ODataResponseListReport
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public ODataResponseListReport getReports() throws RestClientException {

        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/reports").build().toUriString();
        ParameterizedTypeReference<ODataResponseListReport> returnType = new ParameterizedTypeReference<ODataResponseListReport>() {
        };
        return this.invokeAPI(path, HttpMethod.GET, null, null, defaultAccepts, null, returnType);
    }

    /**
     * Gets a list of reports available within the specified group
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param groupId The group id
     * @return ODataResponseListReport
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public ODataResponseListReport getReportsInGroup(String groupId) throws RestClientException {

        // Verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'groupId' when calling reportsGetReportsInGroup");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("groupId", groupId);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/groups/{groupId}/reports").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<ODataResponseListReport> returnType = new ParameterizedTypeReference<ODataResponseListReport>() {
        };
        return this.invokeAPI(path, HttpMethod.GET, null, null, defaultAccepts, null, returnType);
    }

    /**
     * Rebinds the specified report to requested dataset id
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param reportKey The report id
     * @param requestParameters Rebind report parameters
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public Object rebindReport(String reportKey, RebindReportRequest requestParameters) throws RestClientException {

        // Verify the required parameter 'reportKey' is set
        if (reportKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'reportKey' when calling reportsRebindReport");
        }

        // Verify the required parameter 'requestParameters' is set
        if (requestParameters == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'requestParameters' when calling reportsRebindReport");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("reportKey", reportKey);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/reports/{reportKey}/Rebind").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {
        };
        return this.invokeAPI(path, HttpMethod.POST, null, requestParameters, null, defaultContentTypes, returnType);
    }

    /**
     * Rebinds the specified report to requested dataset id
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param groupId The group id
     * @param reportKey The report id
     * @param requestParameters Rebind report parameters
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public Object rebindReportInGroup(String groupId, String reportKey, RebindReportRequest requestParameters) throws RestClientException {

        // Verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'groupId' when calling reportsRebindReportInGroup");
        }

        // Verify the required parameter 'reportKey' is set
        if (reportKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'reportKey' when calling reportsRebindReportInGroup");
        }

        // Verify the required parameter 'requestParameters' is set
        if (requestParameters == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'requestParameters' when calling reportsRebindReportInGroup");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("reportKey", reportKey);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/groups/{groupId}/reports/{reportKey}/Rebind").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {
        };
        return this.invokeAPI(path, HttpMethod.POST, null, requestParameters, null, defaultContentTypes, returnType);
    }

    /**
     * Update the report content from a specified source
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param reportKey The report id
     * @param requestParameters UpdateReportContent parameters
     * @return Report
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public Report updateReportContent(String reportKey, UpdateReportContentRequest requestParameters) throws RestClientException {

        // Verify the required parameter 'reportKey' is set
        if (reportKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'reportKey' when calling reportsUpdateReportContent");
        }

        // Verify the required parameter 'requestParameters' is set
        if (requestParameters == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'requestParameters' when calling reportsUpdateReportContent");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("reportKey", reportKey);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/reports/{reportKey}/UpdateReportContent").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<Report> returnType = new ParameterizedTypeReference<Report>() {
        };
        return this.invokeAPI(path, HttpMethod.POST, null, requestParameters, defaultAccepts, defaultContentTypes, returnType);
    }

    /**
     * Update the report content from a specified source
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param groupId The group id
     * @param reportKey The report id
     * @param requestParameters UpdateReportContent parameters
     * @return Report
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public Report updateReportContentInGroup(String groupId, String reportKey, UpdateReportContentRequest requestParameters) throws RestClientException {

        // Verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'groupId' when calling reportsUpdateReportContentInGroup");
        }

        // Verify the required parameter 'reportKey' is set
        if (reportKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'reportKey' when calling reportsUpdateReportContentInGroup");
        }

        // Verify the required parameter 'requestParameters' is set
        if (requestParameters == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'requestParameters' when calling reportsUpdateReportContentInGroup");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("reportKey", reportKey);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/groups/{groupId}/reports/{reportKey}/UpdateReportContent").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<Report> returnType = new ParameterizedTypeReference<Report>() {
        };
        return this.invokeAPI(path, HttpMethod.POST, null, requestParameters, defaultAccepts, defaultContentTypes, returnType);
    }
}
