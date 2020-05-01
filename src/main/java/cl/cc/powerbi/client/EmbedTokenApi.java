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
import cl.cc.powerbi.client.model.EmbedToken;
import cl.cc.powerbi.client.model.GenerateTokenRequest;
import cl.cc.powerbi.client.model.GenerateTokenRequestV2;

@Component("cl.cc.powerbi.client.EmbedTokenApi")
public class EmbedTokenApi {
    private ApiClient apiClient;

    public EmbedTokenApi() {
        this(new ApiClient());
    }

    @Autowired
    public EmbedTokenApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Generates an embed token to view the specified dashboard from the specified
     * workspace.&lt;br/&gt;This API is relevant only to [&#39;App owns data&#39;
     * embed
     * scenario](https://docs.microsoft.com/power-bi/developer/embed-sample-for-customers).
     * &lt;br/&gt;**Required scope**: (all of the below)
     * &lt;ul&gt;&lt;li&gt;Dashboard.ReadWrite.All or
     * Dashboard.Read.All&lt;/li&gt;&lt;li&gt;Report.ReadWrite.All or
     * Report.Read.All &lt;/li&gt;&lt;li&gt;Dataset.ReadWrite.All or
     * Dataset.Read.All&lt;/li&gt;&lt;/ul&gt;To set the permissions scope, see
     * [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).&lt;/br&gt;&lt;/br&gt;When
     * using service principal for authentication, refer to [Service Principal with
     * Power
     * BI](https://docs.microsoft.com/power-bi/developer/embed-service-principal)
     * document along with considerations and limitations section.
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId           The workspace id (required)
     * @param dashboardId       The dashboard id (required)
     * @param requestParameters Generate token parameters (required)
     * @return EmbedToken
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public EmbedToken dashboardsGenerateTokenInGroup(UUID groupId, UUID dashboardId,
            GenerateTokenRequest requestParameters) throws RestClientException {
        return dashboardsGenerateTokenInGroupWithHttpInfo(groupId, dashboardId, requestParameters).getBody();
    }

    /**
     * Generates an embed token to view the specified dashboard from the specified
     * workspace.&lt;br/&gt;This API is relevant only to [&#39;App owns data&#39;
     * embed
     * scenario](https://docs.microsoft.com/power-bi/developer/embed-sample-for-customers).
     * &lt;br/&gt;**Required scope**: (all of the below)
     * &lt;ul&gt;&lt;li&gt;Dashboard.ReadWrite.All or
     * Dashboard.Read.All&lt;/li&gt;&lt;li&gt;Report.ReadWrite.All or
     * Report.Read.All &lt;/li&gt;&lt;li&gt;Dataset.ReadWrite.All or
     * Dataset.Read.All&lt;/li&gt;&lt;/ul&gt;To set the permissions scope, see
     * [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).&lt;/br&gt;&lt;/br&gt;When
     * using service principal for authentication, refer to [Service Principal with
     * Power
     * BI](https://docs.microsoft.com/power-bi/developer/embed-service-principal)
     * document along with considerations and limitations section.
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId           The workspace id (required)
     * @param dashboardId       The dashboard id (required)
     * @param requestParameters Generate token parameters (required)
     * @return ResponseEntity&lt;EmbedToken&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<EmbedToken> dashboardsGenerateTokenInGroupWithHttpInfo(UUID groupId, UUID dashboardId,
            GenerateTokenRequest requestParameters) throws RestClientException {
        Object postBody = requestParameters;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling dashboardsGenerateTokenInGroup");
        }

        // verify the required parameter 'dashboardId' is set
        if (dashboardId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'dashboardId' when calling dashboardsGenerateTokenInGroup");
        }

        // verify the required parameter 'requestParameters' is set
        if (requestParameters == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'requestParameters' when calling dashboardsGenerateTokenInGroup");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("dashboardId", dashboardId);
        String path = apiClient.expandPath("/v1.0/myorg/groups/{groupId}/dashboards/{dashboardId}/GenerateToken",
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

        ParameterizedTypeReference<EmbedToken> returnType = new ParameterizedTypeReference<EmbedToken>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Generates an embed token to [Embed
     * Q&amp;A](https://docs.microsoft.com/power-bi/developer/qanda) based on the
     * specified dataset from the specified workspace.&lt;br/&gt;This API is
     * relevant only to [&#39;App owns data&#39; embed
     * scenario](https://docs.microsoft.com/power-bi/developer/embed-sample-for-customers).
     * &lt;br/&gt;**Required scope**: Dataset.ReadWrite.All or Dataset.Read.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).&lt;/br&gt;&lt;/br&gt;When
     * using service principal for authentication, refer to [Service Principal with
     * Power
     * BI](https://docs.microsoft.com/power-bi/developer/embed-service-principal)
     * document along with considerations and limitations section.
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId           The workspace id (required)
     * @param datasetId         The dataset id (required)
     * @param requestParameters Generate token parameters (required)
     * @return EmbedToken
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public EmbedToken datasetsGenerateTokenInGroup(UUID groupId, String datasetId,
            GenerateTokenRequest requestParameters) throws RestClientException {
        return datasetsGenerateTokenInGroupWithHttpInfo(groupId, datasetId, requestParameters).getBody();
    }

    /**
     * Generates an embed token to [Embed
     * Q&amp;A](https://docs.microsoft.com/power-bi/developer/qanda) based on the
     * specified dataset from the specified workspace.&lt;br/&gt;This API is
     * relevant only to [&#39;App owns data&#39; embed
     * scenario](https://docs.microsoft.com/power-bi/developer/embed-sample-for-customers).
     * &lt;br/&gt;**Required scope**: Dataset.ReadWrite.All or Dataset.Read.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).&lt;/br&gt;&lt;/br&gt;When
     * using service principal for authentication, refer to [Service Principal with
     * Power
     * BI](https://docs.microsoft.com/power-bi/developer/embed-service-principal)
     * document along with considerations and limitations section.
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId           The workspace id (required)
     * @param datasetId         The dataset id (required)
     * @param requestParameters Generate token parameters (required)
     * @return ResponseEntity&lt;EmbedToken&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<EmbedToken> datasetsGenerateTokenInGroupWithHttpInfo(UUID groupId, String datasetId,
            GenerateTokenRequest requestParameters) throws RestClientException {
        Object postBody = requestParameters;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling datasetsGenerateTokenInGroup");
        }

        // verify the required parameter 'datasetId' is set
        if (datasetId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'datasetId' when calling datasetsGenerateTokenInGroup");
        }

        // verify the required parameter 'requestParameters' is set
        if (requestParameters == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'requestParameters' when calling datasetsGenerateTokenInGroup");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("datasetId", datasetId);
        String path = apiClient.expandPath("/v1.0/myorg/groups/{groupId}/datasets/{datasetId}/GenerateToken",
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

        ParameterizedTypeReference<EmbedToken> returnType = new ParameterizedTypeReference<EmbedToken>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Generates an embed token for multiple reports, datasets and target
     * workspaces. Reports and datasets do not have to be related. The binding of a
     * report to a dataset can be done during embedding. Target workspaces are
     * workspaces where creation of reports is allowed.&lt;br/&gt;This API is
     * relevant only to [&#39;App owns data&#39; embed
     * scenario](https://docs.microsoft.com/power-bi/developer/embed-sample-for-customers).
     * &lt;br/&gt;**Required scope**: &lt;ul&gt;&lt;li&gt;Content.Create - required
     * only if a target workspace is specified in
     * [GenerateTokenRequestV2](/rest/api/power-bi/embedtoken/generatetoken#generatetokenrequestv2)&lt;/li&gt;&lt;li&gt;Report.ReadWrite.All
     * or Report.Read.All - required only if a report is specified in
     * [GenerateTokenRequestV2](/rest/api/power-bi/embedtoken/generatetoken#generatetokenrequestv2)&lt;/li&gt;&lt;li&gt;Report.ReadWrite.All
     * - required if allowEdit flag is specified for at least one report in
     * [GenerateTokenRequestV2](/rest/api/power-bi/embedtoken/generatetoken#generatetokenrequestv2)&lt;/li&gt;&lt;li&gt;Dataset.ReadWrite.All
     * or Dataset.Read.All&lt;/li&gt;&lt;/ul&gt;To set the permissions scope, see
     * [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).&lt;/br&gt;&lt;/br&gt;When
     * using service principal for authentication, refer to [Service Principal with
     * Power
     * BI](https://docs.microsoft.com/power-bi/developer/embed-service-principal)
     * document along with considerations and limitations section.
     * &lt;h2&gt;Restrictions&lt;/h2&gt;&lt;li&gt;All the reports and datasets must
     * reside in workspace V2. All the target workpaces must be workspace
     * V2.&lt;/li&gt;&lt;li&gt;Maximum number of reports, datasets and target
     * workspaces is 50 each.&lt;/li&gt;&lt;li&gt;Generating Embed Token with RLS
     * may not work for AS Azure or AS OnPrem live connection reports for several
     * minutes after a
     * [Rebind](/rest/api/power-bi/reports/RebindReport).&lt;/li&gt;&lt;br/&gt;
     * <p>
     * <b>200</b> - OK
     * 
     * @param requestParameters Generate token parameters (required)
     * @return EmbedToken
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public EmbedToken embedTokenGenerateToken(GenerateTokenRequestV2 requestParameters) throws RestClientException {
        return embedTokenGenerateTokenWithHttpInfo(requestParameters).getBody();
    }

    /**
     * Generates an embed token for multiple reports, datasets and target
     * workspaces. Reports and datasets do not have to be related. The binding of a
     * report to a dataset can be done during embedding. Target workspaces are
     * workspaces where creation of reports is allowed.&lt;br/&gt;This API is
     * relevant only to [&#39;App owns data&#39; embed
     * scenario](https://docs.microsoft.com/power-bi/developer/embed-sample-for-customers).
     * &lt;br/&gt;**Required scope**: &lt;ul&gt;&lt;li&gt;Content.Create - required
     * only if a target workspace is specified in
     * [GenerateTokenRequestV2](/rest/api/power-bi/embedtoken/generatetoken#generatetokenrequestv2)&lt;/li&gt;&lt;li&gt;Report.ReadWrite.All
     * or Report.Read.All - required only if a report is specified in
     * [GenerateTokenRequestV2](/rest/api/power-bi/embedtoken/generatetoken#generatetokenrequestv2)&lt;/li&gt;&lt;li&gt;Report.ReadWrite.All
     * - required if allowEdit flag is specified for at least one report in
     * [GenerateTokenRequestV2](/rest/api/power-bi/embedtoken/generatetoken#generatetokenrequestv2)&lt;/li&gt;&lt;li&gt;Dataset.ReadWrite.All
     * or Dataset.Read.All&lt;/li&gt;&lt;/ul&gt;To set the permissions scope, see
     * [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).&lt;/br&gt;&lt;/br&gt;When
     * using service principal for authentication, refer to [Service Principal with
     * Power
     * BI](https://docs.microsoft.com/power-bi/developer/embed-service-principal)
     * document along with considerations and limitations section.
     * &lt;h2&gt;Restrictions&lt;/h2&gt;&lt;li&gt;All the reports and datasets must
     * reside in workspace V2. All the target workpaces must be workspace
     * V2.&lt;/li&gt;&lt;li&gt;Maximum number of reports, datasets and target
     * workspaces is 50 each.&lt;/li&gt;&lt;li&gt;Generating Embed Token with RLS
     * may not work for AS Azure or AS OnPrem live connection reports for several
     * minutes after a
     * [Rebind](/rest/api/power-bi/reports/RebindReport).&lt;/li&gt;&lt;br/&gt;
     * <p>
     * <b>200</b> - OK
     * 
     * @param requestParameters Generate token parameters (required)
     * @return ResponseEntity&lt;EmbedToken&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<EmbedToken> embedTokenGenerateTokenWithHttpInfo(GenerateTokenRequestV2 requestParameters)
            throws RestClientException {
        Object postBody = requestParameters;

        // verify the required parameter 'requestParameters' is set
        if (requestParameters == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'requestParameters' when calling embedTokenGenerateToken");
        }

        String path = apiClient.expandPath("/v1.0/myorg/GenerateToken", Collections.<String, Object>emptyMap());

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { "application/json" };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<EmbedToken> returnType = new ParameterizedTypeReference<EmbedToken>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Generates an embed token to allow report creation on the specified workspace
     * based on the specified dataset.&lt;br/&gt;This API is relevant only to
     * [&#39;App owns data&#39; embed
     * scenario](https://docs.microsoft.com/power-bi/developer/embed-sample-for-customers).
     * &lt;br/&gt;**Required scope**: (all of the below)
     * &lt;ul&gt;&lt;li&gt;Content.Create&lt;/li&gt;&lt;li&gt;Report.ReadWrite.All
     * or Report.Read.All&lt;/li&gt;&lt;li&gt;Dataset.ReadWrite.All or
     * Dataset.Read.All&lt;/li&gt;&lt;/ul&gt;To set the permissions scope, see
     * [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).&lt;/br&gt;&lt;/br&gt;When
     * using service principal for authentication, refer to [Service Principal with
     * Power
     * BI](https://docs.microsoft.com/power-bi/developer/embed-service-principal)
     * document along with considerations and limitations section.
     * &lt;h2&gt;Restrictions&lt;/h2&gt;Generating Embed Token with RLS may not work
     * for AS Azure or AS OnPrem live connection reports for several minutes after a
     * [Rebind](/rest/api/power-bi/reports/RebindReport).&lt;br/&gt;
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId           The workspace id (required)
     * @param requestParameters Generate token parameters (required)
     * @return EmbedToken
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public EmbedToken reportsGenerateTokenForCreateInGroup(UUID groupId, GenerateTokenRequest requestParameters)
            throws RestClientException {
        return reportsGenerateTokenForCreateInGroupWithHttpInfo(groupId, requestParameters).getBody();
    }

    /**
     * Generates an embed token to allow report creation on the specified workspace
     * based on the specified dataset.&lt;br/&gt;This API is relevant only to
     * [&#39;App owns data&#39; embed
     * scenario](https://docs.microsoft.com/power-bi/developer/embed-sample-for-customers).
     * &lt;br/&gt;**Required scope**: (all of the below)
     * &lt;ul&gt;&lt;li&gt;Content.Create&lt;/li&gt;&lt;li&gt;Report.ReadWrite.All
     * or Report.Read.All&lt;/li&gt;&lt;li&gt;Dataset.ReadWrite.All or
     * Dataset.Read.All&lt;/li&gt;&lt;/ul&gt;To set the permissions scope, see
     * [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).&lt;/br&gt;&lt;/br&gt;When
     * using service principal for authentication, refer to [Service Principal with
     * Power
     * BI](https://docs.microsoft.com/power-bi/developer/embed-service-principal)
     * document along with considerations and limitations section.
     * &lt;h2&gt;Restrictions&lt;/h2&gt;Generating Embed Token with RLS may not work
     * for AS Azure or AS OnPrem live connection reports for several minutes after a
     * [Rebind](/rest/api/power-bi/reports/RebindReport).&lt;br/&gt;
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId           The workspace id (required)
     * @param requestParameters Generate token parameters (required)
     * @return ResponseEntity&lt;EmbedToken&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<EmbedToken> reportsGenerateTokenForCreateInGroupWithHttpInfo(UUID groupId,
            GenerateTokenRequest requestParameters) throws RestClientException {
        Object postBody = requestParameters;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling reportsGenerateTokenForCreateInGroup");
        }

        // verify the required parameter 'requestParameters' is set
        if (requestParameters == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'requestParameters' when calling reportsGenerateTokenForCreateInGroup");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        String path = apiClient.expandPath("/v1.0/myorg/groups/{groupId}/reports/GenerateToken", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { "application/json" };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<EmbedToken> returnType = new ParameterizedTypeReference<EmbedToken>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Generates an embed token to view or edit the specified report from the
     * specified workspace.&lt;br/&gt;This API is relevant only to [&#39;App owns
     * data&#39; embed
     * scenario](https://docs.microsoft.com/power-bi/developer/embed-sample-for-customers).
     * &lt;br/&gt;**Required scope**: (all of the below)
     * &lt;ul&gt;&lt;li&gt;Report.ReadWrite.All or
     * Report.Read.All&lt;/li&gt;&lt;li&gt;Dataset.ReadWrite.All or
     * Dataset.Read.All&lt;/li&gt;&lt;li&gt;Content.Create - required only if
     * allowSaveAs specified in
     * [GenerateTokenRequest](/rest/api/power-bi/embedtoken/reports_generatetokeningroup#GenerateTokenRequest)&lt;/li&gt;&lt;/ul&gt;To
     * set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).&lt;/br&gt;&lt;/br&gt;When
     * using service principal for authentication, refer to [Service Principal with
     * Power
     * BI](https://docs.microsoft.com/power-bi/developer/embed-service-principal)
     * document along with considerations and limitations section.
     * &lt;h2&gt;Restrictions&lt;/h2&gt;Generating Embed Token with RLS may not work
     * for AS Azure or AS OnPrem live connection reports for several minutes after a
     * [Rebind](/rest/api/power-bi/reports/RebindReport).&lt;br/&gt;
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId           The workspace id (required)
     * @param reportId          The report id (required)
     * @param requestParameters Generate token parameters (required)
     * @return EmbedToken
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public EmbedToken reportsGenerateTokenInGroup(UUID groupId, UUID reportId, GenerateTokenRequest requestParameters)
            throws RestClientException {
        return reportsGenerateTokenInGroupWithHttpInfo(groupId, reportId, requestParameters).getBody();
    }

    /**
     * Generates an embed token to view or edit the specified report from the
     * specified workspace.&lt;br/&gt;This API is relevant only to [&#39;App owns
     * data&#39; embed
     * scenario](https://docs.microsoft.com/power-bi/developer/embed-sample-for-customers).
     * &lt;br/&gt;**Required scope**: (all of the below)
     * &lt;ul&gt;&lt;li&gt;Report.ReadWrite.All or
     * Report.Read.All&lt;/li&gt;&lt;li&gt;Dataset.ReadWrite.All or
     * Dataset.Read.All&lt;/li&gt;&lt;li&gt;Content.Create - required only if
     * allowSaveAs specified in
     * [GenerateTokenRequest](/rest/api/power-bi/embedtoken/reports_generatetokeningroup#GenerateTokenRequest)&lt;/li&gt;&lt;/ul&gt;To
     * set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).&lt;/br&gt;&lt;/br&gt;When
     * using service principal for authentication, refer to [Service Principal with
     * Power
     * BI](https://docs.microsoft.com/power-bi/developer/embed-service-principal)
     * document along with considerations and limitations section.
     * &lt;h2&gt;Restrictions&lt;/h2&gt;Generating Embed Token with RLS may not work
     * for AS Azure or AS OnPrem live connection reports for several minutes after a
     * [Rebind](/rest/api/power-bi/reports/RebindReport).&lt;br/&gt;
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId           The workspace id (required)
     * @param reportId          The report id (required)
     * @param requestParameters Generate token parameters (required)
     * @return ResponseEntity&lt;EmbedToken&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<EmbedToken> reportsGenerateTokenInGroupWithHttpInfo(UUID groupId, UUID reportId,
            GenerateTokenRequest requestParameters) throws RestClientException {
        Object postBody = requestParameters;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling reportsGenerateTokenInGroup");
        }

        // verify the required parameter 'reportId' is set
        if (reportId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'reportId' when calling reportsGenerateTokenInGroup");
        }

        // verify the required parameter 'requestParameters' is set
        if (requestParameters == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'requestParameters' when calling reportsGenerateTokenInGroup");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("reportId", reportId);
        String path = apiClient.expandPath("/v1.0/myorg/groups/{groupId}/reports/{reportId}/GenerateToken",
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

        ParameterizedTypeReference<EmbedToken> returnType = new ParameterizedTypeReference<EmbedToken>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Generates an embed token to view the specified tile from the specified
     * workspace.&lt;br/&gt;This API is relevant only to [&#39;App owns data&#39;
     * embed
     * scenario](https://docs.microsoft.com/power-bi/developer/embed-sample-for-customers).
     * &lt;br/&gt;**Required scope**: (all of the below)
     * &lt;ul&gt;&lt;li&gt;Dashboard.ReadWrite.All or
     * Dashboard.Read.All&lt;/li&gt;&lt;li&gt;Report.ReadWrite.All or
     * Report.Read.All &lt;/li&gt;&lt;li&gt;Dataset.ReadWrite.All or
     * Dataset.Read.All&lt;/li&gt;&lt;/ul&gt;To set the permissions scope, see
     * [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).&lt;/br&gt;&lt;/br&gt;When
     * using service principal for authentication, refer to [Service Principal with
     * Power
     * BI](https://docs.microsoft.com/power-bi/developer/embed-service-principal)
     * document along with considerations and limitations section.
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId           The workspace id (required)
     * @param dashboardId       The dashboard id (required)
     * @param tileId            The tile id (required)
     * @param requestParameters Generate token parameters (required)
     * @return EmbedToken
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public EmbedToken tilesGenerateTokenInGroup(UUID groupId, UUID dashboardId, UUID tileId,
            GenerateTokenRequest requestParameters) throws RestClientException {
        return tilesGenerateTokenInGroupWithHttpInfo(groupId, dashboardId, tileId, requestParameters).getBody();
    }

    /**
     * Generates an embed token to view the specified tile from the specified
     * workspace.&lt;br/&gt;This API is relevant only to [&#39;App owns data&#39;
     * embed
     * scenario](https://docs.microsoft.com/power-bi/developer/embed-sample-for-customers).
     * &lt;br/&gt;**Required scope**: (all of the below)
     * &lt;ul&gt;&lt;li&gt;Dashboard.ReadWrite.All or
     * Dashboard.Read.All&lt;/li&gt;&lt;li&gt;Report.ReadWrite.All or
     * Report.Read.All &lt;/li&gt;&lt;li&gt;Dataset.ReadWrite.All or
     * Dataset.Read.All&lt;/li&gt;&lt;/ul&gt;To set the permissions scope, see
     * [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).&lt;/br&gt;&lt;/br&gt;When
     * using service principal for authentication, refer to [Service Principal with
     * Power
     * BI](https://docs.microsoft.com/power-bi/developer/embed-service-principal)
     * document along with considerations and limitations section.
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId           The workspace id (required)
     * @param dashboardId       The dashboard id (required)
     * @param tileId            The tile id (required)
     * @param requestParameters Generate token parameters (required)
     * @return ResponseEntity&lt;EmbedToken&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<EmbedToken> tilesGenerateTokenInGroupWithHttpInfo(UUID groupId, UUID dashboardId, UUID tileId,
            GenerateTokenRequest requestParameters) throws RestClientException {
        Object postBody = requestParameters;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling tilesGenerateTokenInGroup");
        }

        // verify the required parameter 'dashboardId' is set
        if (dashboardId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'dashboardId' when calling tilesGenerateTokenInGroup");
        }

        // verify the required parameter 'tileId' is set
        if (tileId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'tileId' when calling tilesGenerateTokenInGroup");
        }

        // verify the required parameter 'requestParameters' is set
        if (requestParameters == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'requestParameters' when calling tilesGenerateTokenInGroup");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("dashboardId", dashboardId);
        uriVariables.put("tileId", tileId);
        String path = apiClient.expandPath(
                "/v1.0/myorg/groups/{groupId}/dashboards/{dashboardId}/tiles/{tileId}/GenerateToken", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { "application/json" };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<EmbedToken> returnType = new ParameterizedTypeReference<EmbedToken>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }
}
