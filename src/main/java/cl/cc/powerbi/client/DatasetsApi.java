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
import cl.cc.powerbi.client.model.BindToGatewayRequest;
import cl.cc.powerbi.client.model.ConnectionDetails;
import cl.cc.powerbi.client.model.Dataset;
import cl.cc.powerbi.client.model.DatasetToDataflowLinksResponse;
import cl.cc.powerbi.client.model.Datasets;
import cl.cc.powerbi.client.model.Datasources;
import cl.cc.powerbi.client.model.DirectQueryRefreshSchedule;
import cl.cc.powerbi.client.model.DirectQueryRefreshScheduleRequest;
import cl.cc.powerbi.client.model.GatewayDatasources;
import cl.cc.powerbi.client.model.Gateways;
import cl.cc.powerbi.client.model.MashupParameters;
import cl.cc.powerbi.client.model.RefreshRequest;
import cl.cc.powerbi.client.model.RefreshSchedule;
import cl.cc.powerbi.client.model.RefreshScheduleRequest;
import cl.cc.powerbi.client.model.Refreshes;
import cl.cc.powerbi.client.model.UpdateDatasourcesRequest;
import cl.cc.powerbi.client.model.UpdateMashupParametersRequest;

@Component("cl.cc.powerbi.client.DatasetsApi")
public class DatasetsApi {
    private ApiClient apiClient;

    public DatasetsApi() {
        this(new ApiClient());
    }

    @Autowired
    public DatasetsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Binds the specified dataset from **\&quot;My Workspace\&quot;** to the
     * specified gateway with (optional) given set of datasource Ids. This only
     * supports the On-Premises Data Gateway. &lt;br/&gt;**Required scope**:
     * Dataset.ReadWrite.All &lt;br/&gt;To set the permissions scope, see [Register
     * an app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param datasetId            The dataset id (required)
     * @param bindToGatewayRequest The bind to gateway request (required)
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public void datasetsBindToGateway(String datasetId, BindToGatewayRequest bindToGatewayRequest)
            throws RestClientException {
        datasetsBindToGatewayWithHttpInfo(datasetId, bindToGatewayRequest);
    }

    /**
     * Binds the specified dataset from **\&quot;My Workspace\&quot;** to the
     * specified gateway with (optional) given set of datasource Ids. This only
     * supports the On-Premises Data Gateway. &lt;br/&gt;**Required scope**:
     * Dataset.ReadWrite.All &lt;br/&gt;To set the permissions scope, see [Register
     * an app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param datasetId            The dataset id (required)
     * @param bindToGatewayRequest The bind to gateway request (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Void> datasetsBindToGatewayWithHttpInfo(String datasetId,
            BindToGatewayRequest bindToGatewayRequest) throws RestClientException {
        Object postBody = bindToGatewayRequest;

        // verify the required parameter 'datasetId' is set
        if (datasetId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'datasetId' when calling datasetsBindToGateway");
        }

        // verify the required parameter 'bindToGatewayRequest' is set
        if (bindToGatewayRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'bindToGatewayRequest' when calling datasetsBindToGateway");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("datasetId", datasetId);
        String path = apiClient.expandPath("/v1.0/myorg/datasets/{datasetId}/Default.BindToGateway", uriVariables);

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
     * Binds the specified dataset from the specified workspace to the specified
     * gateway with (optional) given set of datasource Ids. This only supports the
     * On-Premises Data Gateway. &lt;br/&gt;**Required scope**:
     * Dataset.ReadWrite.All &lt;br/&gt;To set the permissions scope, see [Register
     * an app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId              The workspace id (required)
     * @param datasetId            The dataset id (required)
     * @param bindToGatewayRequest The bind to gateway request (required)
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public void datasetsBindToGatewayInGroup(UUID groupId, String datasetId, BindToGatewayRequest bindToGatewayRequest)
            throws RestClientException {
        datasetsBindToGatewayInGroupWithHttpInfo(groupId, datasetId, bindToGatewayRequest);
    }

    /**
     * Binds the specified dataset from the specified workspace to the specified
     * gateway with (optional) given set of datasource Ids. This only supports the
     * On-Premises Data Gateway. &lt;br/&gt;**Required scope**:
     * Dataset.ReadWrite.All &lt;br/&gt;To set the permissions scope, see [Register
     * an app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId              The workspace id (required)
     * @param datasetId            The dataset id (required)
     * @param bindToGatewayRequest The bind to gateway request (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Void> datasetsBindToGatewayInGroupWithHttpInfo(UUID groupId, String datasetId,
            BindToGatewayRequest bindToGatewayRequest) throws RestClientException {
        Object postBody = bindToGatewayRequest;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling datasetsBindToGatewayInGroup");
        }

        // verify the required parameter 'datasetId' is set
        if (datasetId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'datasetId' when calling datasetsBindToGatewayInGroup");
        }

        // verify the required parameter 'bindToGatewayRequest' is set
        if (bindToGatewayRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'bindToGatewayRequest' when calling datasetsBindToGatewayInGroup");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("datasetId", datasetId);
        String path = apiClient.expandPath("/v1.0/myorg/groups/{groupId}/datasets/{datasetId}/Default.BindToGateway",
                uriVariables);

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
     * Deletes the specified dataset from **\&quot;My Workspace\&quot;**.
     * &lt;br/&gt;**Required scope**: Dataset.ReadWrite.All &lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param datasetId The dataset id (required)
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public void datasetsDeleteDataset(String datasetId) throws RestClientException {
        datasetsDeleteDatasetWithHttpInfo(datasetId);
    }

    /**
     * Deletes the specified dataset from **\&quot;My Workspace\&quot;**.
     * &lt;br/&gt;**Required scope**: Dataset.ReadWrite.All &lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param datasetId The dataset id (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Void> datasetsDeleteDatasetWithHttpInfo(String datasetId) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'datasetId' is set
        if (datasetId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'datasetId' when calling datasetsDeleteDataset");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("datasetId", datasetId);
        String path = apiClient.expandPath("/v1.0/myorg/datasets/{datasetId}", uriVariables);

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
     * Deletes the specified dataset from the specified workspace.
     * &lt;br/&gt;**Required scope**: Dataset.ReadWrite.All &lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId   The workspace id (required)
     * @param datasetId The dataset id (required)
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public void datasetsDeleteDatasetInGroup(UUID groupId, String datasetId) throws RestClientException {
        datasetsDeleteDatasetInGroupWithHttpInfo(groupId, datasetId);
    }

    /**
     * Deletes the specified dataset from the specified workspace.
     * &lt;br/&gt;**Required scope**: Dataset.ReadWrite.All &lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId   The workspace id (required)
     * @param datasetId The dataset id (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Void> datasetsDeleteDatasetInGroupWithHttpInfo(UUID groupId, String datasetId)
            throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling datasetsDeleteDatasetInGroup");
        }

        // verify the required parameter 'datasetId' is set
        if (datasetId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'datasetId' when calling datasetsDeleteDatasetInGroup");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("datasetId", datasetId);
        String path = apiClient.expandPath("/v1.0/myorg/groups/{groupId}/datasets/{datasetId}", uriVariables);

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
     * Returns a list of gateways which the specified dataset from **\&quot;My
     * Workspace\&quot;** can be bound to. This API is relevant only for datasets
     * that have at least one on-premises connection. &lt;br/&gt;For datasets with
     * cloud-only connections, it will return an empty list.
     * &lt;br/&gt;&lt;br/&gt;**Required scope**: Dataset.Read.All &lt;br/&gt;To set
     * the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param datasetId The dataset id (required)
     * @return Gateways
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Gateways datasetsDiscoverGateways(String datasetId) throws RestClientException {
        return datasetsDiscoverGatewaysWithHttpInfo(datasetId).getBody();
    }

    /**
     * Returns a list of gateways which the specified dataset from **\&quot;My
     * Workspace\&quot;** can be bound to. This API is relevant only for datasets
     * that have at least one on-premises connection. &lt;br/&gt;For datasets with
     * cloud-only connections, it will return an empty list.
     * &lt;br/&gt;&lt;br/&gt;**Required scope**: Dataset.Read.All &lt;br/&gt;To set
     * the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param datasetId The dataset id (required)
     * @return ResponseEntity&lt;Gateways&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Gateways> datasetsDiscoverGatewaysWithHttpInfo(String datasetId) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'datasetId' is set
        if (datasetId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'datasetId' when calling datasetsDiscoverGateways");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("datasetId", datasetId);
        String path = apiClient.expandPath("/v1.0/myorg/datasets/{datasetId}/Default.DiscoverGateways", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Gateways> returnType = new ParameterizedTypeReference<Gateways>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Returns a list of gateways that the specified dataset from the specified
     * workspace can be bound to. This API is relevant only for datasets that have
     * at least one on-premises connection. &lt;br/&gt;For datasets with cloud-only
     * connections, it will return an empty list. &lt;br/&gt;&lt;br/&gt;**Required
     * scope**: Dataset.Read.All &lt;br/&gt;To set the permissions scope, see
     * [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId   The workspace id (required)
     * @param datasetId The dataset id (required)
     * @return Gateways
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Gateways datasetsDiscoverGatewaysInGroup(UUID groupId, String datasetId) throws RestClientException {
        return datasetsDiscoverGatewaysInGroupWithHttpInfo(groupId, datasetId).getBody();
    }

    /**
     * Returns a list of gateways that the specified dataset from the specified
     * workspace can be bound to. This API is relevant only for datasets that have
     * at least one on-premises connection. &lt;br/&gt;For datasets with cloud-only
     * connections, it will return an empty list. &lt;br/&gt;&lt;br/&gt;**Required
     * scope**: Dataset.Read.All &lt;br/&gt;To set the permissions scope, see
     * [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId   The workspace id (required)
     * @param datasetId The dataset id (required)
     * @return ResponseEntity&lt;Gateways&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Gateways> datasetsDiscoverGatewaysInGroupWithHttpInfo(UUID groupId, String datasetId)
            throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling datasetsDiscoverGatewaysInGroup");
        }

        // verify the required parameter 'datasetId' is set
        if (datasetId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'datasetId' when calling datasetsDiscoverGatewaysInGroup");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("datasetId", datasetId);
        String path = apiClient.expandPath("/v1.0/myorg/groups/{groupId}/datasets/{datasetId}/Default.DiscoverGateways",
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

        ParameterizedTypeReference<Gateways> returnType = new ParameterizedTypeReference<Gateways>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Returns the specified dataset from **\&quot;My Workspace\&quot;**.
     * &lt;br/&gt;**Required scope**: Dataset.ReadWrite.All or Dataset.Read.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param datasetId The dataset id (required)
     * @return Dataset
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Dataset datasetsGetDataset(String datasetId) throws RestClientException {
        return datasetsGetDatasetWithHttpInfo(datasetId).getBody();
    }

    /**
     * Returns the specified dataset from **\&quot;My Workspace\&quot;**.
     * &lt;br/&gt;**Required scope**: Dataset.ReadWrite.All or Dataset.Read.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param datasetId The dataset id (required)
     * @return ResponseEntity&lt;Dataset&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Dataset> datasetsGetDatasetWithHttpInfo(String datasetId) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'datasetId' is set
        if (datasetId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'datasetId' when calling datasetsGetDataset");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("datasetId", datasetId);
        String path = apiClient.expandPath("/v1.0/myorg/datasets/{datasetId}", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Dataset> returnType = new ParameterizedTypeReference<Dataset>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Returns the specified dataset from the specified workspace.
     * &lt;br/&gt;**Required scope**: Dataset.ReadWrite.All or Dataset.Read.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId   The workspace id (required)
     * @param datasetId The dataset id (required)
     * @return Dataset
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Dataset datasetsGetDatasetInGroup(UUID groupId, String datasetId) throws RestClientException {
        return datasetsGetDatasetInGroupWithHttpInfo(groupId, datasetId).getBody();
    }

    /**
     * Returns the specified dataset from the specified workspace.
     * &lt;br/&gt;**Required scope**: Dataset.ReadWrite.All or Dataset.Read.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId   The workspace id (required)
     * @param datasetId The dataset id (required)
     * @return ResponseEntity&lt;Dataset&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Dataset> datasetsGetDatasetInGroupWithHttpInfo(UUID groupId, String datasetId)
            throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling datasetsGetDatasetInGroup");
        }

        // verify the required parameter 'datasetId' is set
        if (datasetId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'datasetId' when calling datasetsGetDatasetInGroup");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("datasetId", datasetId);
        String path = apiClient.expandPath("/v1.0/myorg/groups/{groupId}/datasets/{datasetId}", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Dataset> returnType = new ParameterizedTypeReference<Dataset>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Returns a list of upstream dataflows for datasets from the specified
     * workspace. &lt;br/&gt;**Required scope**: Dataset.ReadWrite.All or
     * Dataset.Read.All &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId The workspace id (required)
     * @return DatasetToDataflowLinksResponse
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public DatasetToDataflowLinksResponse datasetsGetDatasetToDataflowsLinksInGroup(UUID groupId)
            throws RestClientException {
        return datasetsGetDatasetToDataflowsLinksInGroupWithHttpInfo(groupId).getBody();
    }

    /**
     * Returns a list of upstream dataflows for datasets from the specified
     * workspace. &lt;br/&gt;**Required scope**: Dataset.ReadWrite.All or
     * Dataset.Read.All &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId The workspace id (required)
     * @return ResponseEntity&lt;DatasetToDataflowLinksResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<DatasetToDataflowLinksResponse> datasetsGetDatasetToDataflowsLinksInGroupWithHttpInfo(
            UUID groupId) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling datasetsGetDatasetToDataflowsLinksInGroup");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        String path = apiClient.expandPath("/v1.0/myorg/groups/{groupId}/datasets/upstreamDataflows", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<DatasetToDataflowLinksResponse> returnType = new ParameterizedTypeReference<DatasetToDataflowLinksResponse>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Returns a list of datasets from **\&quot;My Workspace\&quot;**.
     * &lt;br/&gt;**Required scope**: Dataset.ReadWrite.All or Dataset.Read.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @return Datasets
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Datasets datasetsGetDatasets() throws RestClientException {
        return datasetsGetDatasetsWithHttpInfo().getBody();
    }

    /**
     * Returns a list of datasets from **\&quot;My Workspace\&quot;**.
     * &lt;br/&gt;**Required scope**: Dataset.ReadWrite.All or Dataset.Read.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @return ResponseEntity&lt;Datasets&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Datasets> datasetsGetDatasetsWithHttpInfo() throws RestClientException {
        Object postBody = null;

        String path = apiClient.expandPath("/v1.0/myorg/datasets", Collections.<String, Object>emptyMap());

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Datasets> returnType = new ParameterizedTypeReference<Datasets>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Returns a list of datasets from the specified workspace.
     * &lt;br/&gt;**Required scope**: Dataset.ReadWrite.All or Dataset.Read.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId The workspace id (required)
     * @return Datasets
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Datasets datasetsGetDatasetsInGroup(UUID groupId) throws RestClientException {
        return datasetsGetDatasetsInGroupWithHttpInfo(groupId).getBody();
    }

    /**
     * Returns a list of datasets from the specified workspace.
     * &lt;br/&gt;**Required scope**: Dataset.ReadWrite.All or Dataset.Read.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId The workspace id (required)
     * @return ResponseEntity&lt;Datasets&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Datasets> datasetsGetDatasetsInGroupWithHttpInfo(UUID groupId) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling datasetsGetDatasetsInGroup");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        String path = apiClient.expandPath("/v1.0/myorg/groups/{groupId}/datasets", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Datasets> returnType = new ParameterizedTypeReference<Datasets>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Returns a list of datasources for the specified dataset from **\&quot;My
     * Workspace\&quot;**. &lt;br/&gt;**Required scope**: Dataset.ReadWrite.All or
     * Dataset.Read.All &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param datasetId The dataset id (required)
     * @return Datasources
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Datasources datasetsGetDatasources(String datasetId) throws RestClientException {
        return datasetsGetDatasourcesWithHttpInfo(datasetId).getBody();
    }

    /**
     * Returns a list of datasources for the specified dataset from **\&quot;My
     * Workspace\&quot;**. &lt;br/&gt;**Required scope**: Dataset.ReadWrite.All or
     * Dataset.Read.All &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param datasetId The dataset id (required)
     * @return ResponseEntity&lt;Datasources&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Datasources> datasetsGetDatasourcesWithHttpInfo(String datasetId) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'datasetId' is set
        if (datasetId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'datasetId' when calling datasetsGetDatasources");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("datasetId", datasetId);
        String path = apiClient.expandPath("/v1.0/myorg/datasets/{datasetId}/datasources", uriVariables);

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
     * Returns a list of datasources for the specified dataset from the specified
     * workspace. &lt;br/&gt;**Required scope**: Dataset.ReadWrite.All or
     * Dataset.Read.All &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId   The workspace id (required)
     * @param datasetId (required)
     * @return Datasources
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Datasources datasetsGetDatasourcesInGroup(UUID groupId, String datasetId) throws RestClientException {
        return datasetsGetDatasourcesInGroupWithHttpInfo(groupId, datasetId).getBody();
    }

    /**
     * Returns a list of datasources for the specified dataset from the specified
     * workspace. &lt;br/&gt;**Required scope**: Dataset.ReadWrite.All or
     * Dataset.Read.All &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId   The workspace id (required)
     * @param datasetId (required)
     * @return ResponseEntity&lt;Datasources&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Datasources> datasetsGetDatasourcesInGroupWithHttpInfo(UUID groupId, String datasetId)
            throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling datasetsGetDatasourcesInGroup");
        }

        // verify the required parameter 'datasetId' is set
        if (datasetId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'datasetId' when calling datasetsGetDatasourcesInGroup");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("datasetId", datasetId);
        String path = apiClient.expandPath("/v1.0/myorg/groups/{groupId}/datasets/{datasetId}/datasources",
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

        ParameterizedTypeReference<Datasources> returnType = new ParameterizedTypeReference<Datasources>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Returns the refresh schedule of a specified DirectQuery or LiveConnection
     * dataset from **\&quot;My Workspace\&quot;**. &lt;br/&gt;**Required scope**:
     * Dataset.ReadWrite.All or Dataset.Read.All &lt;br/&gt;To set the permissions
     * scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param datasetId The dataset id (required)
     * @return DirectQueryRefreshSchedule
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public DirectQueryRefreshSchedule datasetsGetDirectQueryRefreshSchedule(String datasetId)
            throws RestClientException {
        return datasetsGetDirectQueryRefreshScheduleWithHttpInfo(datasetId).getBody();
    }

    /**
     * Returns the refresh schedule of a specified DirectQuery or LiveConnection
     * dataset from **\&quot;My Workspace\&quot;**. &lt;br/&gt;**Required scope**:
     * Dataset.ReadWrite.All or Dataset.Read.All &lt;br/&gt;To set the permissions
     * scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param datasetId The dataset id (required)
     * @return ResponseEntity&lt;DirectQueryRefreshSchedule&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<DirectQueryRefreshSchedule> datasetsGetDirectQueryRefreshScheduleWithHttpInfo(
            String datasetId) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'datasetId' is set
        if (datasetId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'datasetId' when calling datasetsGetDirectQueryRefreshSchedule");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("datasetId", datasetId);
        String path = apiClient.expandPath("/v1.0/myorg/datasets/{datasetId}/directQueryRefreshSchedule", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<DirectQueryRefreshSchedule> returnType = new ParameterizedTypeReference<DirectQueryRefreshSchedule>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Returns the refresh schedule of a specified DirectQuery or LiveConnection
     * dataset from the specified workspace. &lt;br/&gt;**Required scope**:
     * Dataset.ReadWrite.All or Dataset.Read.All &lt;br/&gt;To set the permissions
     * scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId   The workspace id (required)
     * @param datasetId The dataset id (required)
     * @return DirectQueryRefreshSchedule
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public DirectQueryRefreshSchedule datasetsGetDirectQueryRefreshScheduleInGroup(UUID groupId, String datasetId)
            throws RestClientException {
        return datasetsGetDirectQueryRefreshScheduleInGroupWithHttpInfo(groupId, datasetId).getBody();
    }

    /**
     * Returns the refresh schedule of a specified DirectQuery or LiveConnection
     * dataset from the specified workspace. &lt;br/&gt;**Required scope**:
     * Dataset.ReadWrite.All or Dataset.Read.All &lt;br/&gt;To set the permissions
     * scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId   The workspace id (required)
     * @param datasetId The dataset id (required)
     * @return ResponseEntity&lt;DirectQueryRefreshSchedule&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<DirectQueryRefreshSchedule> datasetsGetDirectQueryRefreshScheduleInGroupWithHttpInfo(
            UUID groupId, String datasetId) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling datasetsGetDirectQueryRefreshScheduleInGroup");
        }

        // verify the required parameter 'datasetId' is set
        if (datasetId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'datasetId' when calling datasetsGetDirectQueryRefreshScheduleInGroup");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("datasetId", datasetId);
        String path = apiClient.expandPath(
                "/v1.0/myorg/groups/{groupId}/datasets/{datasetId}/directQueryRefreshSchedule", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<DirectQueryRefreshSchedule> returnType = new ParameterizedTypeReference<DirectQueryRefreshSchedule>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Returns a list of gateway datasources for the specified dataset from
     * **\&quot;My Workspace\&quot;**. &lt;br/&gt;**Note**: Use the new [Dataset -
     * Get Datasources](/rest/api/power-bi/datasets/getdatasources) API
     * instead.&lt;br/&gt;&lt;br/&gt;**Required scope**: Dataset.ReadWrite.All or
     * Dataset.Read.All &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param datasetId The dataset id (required)
     * @return GatewayDatasources
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public GatewayDatasources datasetsGetGatewayDatasources(String datasetId) throws RestClientException {
        return datasetsGetGatewayDatasourcesWithHttpInfo(datasetId).getBody();
    }

    /**
     * Returns a list of gateway datasources for the specified dataset from
     * **\&quot;My Workspace\&quot;**. &lt;br/&gt;**Note**: Use the new [Dataset -
     * Get Datasources](/rest/api/power-bi/datasets/getdatasources) API
     * instead.&lt;br/&gt;&lt;br/&gt;**Required scope**: Dataset.ReadWrite.All or
     * Dataset.Read.All &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param datasetId The dataset id (required)
     * @return ResponseEntity&lt;GatewayDatasources&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<GatewayDatasources> datasetsGetGatewayDatasourcesWithHttpInfo(String datasetId)
            throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'datasetId' is set
        if (datasetId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'datasetId' when calling datasetsGetGatewayDatasources");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("datasetId", datasetId);
        String path = apiClient.expandPath("/v1.0/myorg/datasets/{datasetId}/Default.GetBoundGatewayDatasources",
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

        ParameterizedTypeReference<GatewayDatasources> returnType = new ParameterizedTypeReference<GatewayDatasources>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Returns a list of gateway datasources for the specified dataset from the
     * specified workspace. &lt;br/&gt;**Note**: Use the [Dataset - Get Datasources
     * In Group](/rest/api/power-bi/datasets/getdatasourcesingroup) API
     * instead.&lt;br/&gt;&lt;br/&gt;**Required scope**: Dataset.ReadWrite.All or
     * Dataset.Read.All &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId   The workspace id (required)
     * @param datasetId The dataset id (required)
     * @return GatewayDatasources
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public GatewayDatasources datasetsGetGatewayDatasourcesInGroup(UUID groupId, String datasetId)
            throws RestClientException {
        return datasetsGetGatewayDatasourcesInGroupWithHttpInfo(groupId, datasetId).getBody();
    }

    /**
     * Returns a list of gateway datasources for the specified dataset from the
     * specified workspace. &lt;br/&gt;**Note**: Use the [Dataset - Get Datasources
     * In Group](/rest/api/power-bi/datasets/getdatasourcesingroup) API
     * instead.&lt;br/&gt;&lt;br/&gt;**Required scope**: Dataset.ReadWrite.All or
     * Dataset.Read.All &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId   The workspace id (required)
     * @param datasetId The dataset id (required)
     * @return ResponseEntity&lt;GatewayDatasources&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<GatewayDatasources> datasetsGetGatewayDatasourcesInGroupWithHttpInfo(UUID groupId,
            String datasetId) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling datasetsGetGatewayDatasourcesInGroup");
        }

        // verify the required parameter 'datasetId' is set
        if (datasetId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'datasetId' when calling datasetsGetGatewayDatasourcesInGroup");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("datasetId", datasetId);
        String path = apiClient.expandPath(
                "/v1.0/myorg/groups/{groupId}/datasets/{datasetId}/Default.GetBoundGatewayDatasources", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<GatewayDatasources> returnType = new ParameterizedTypeReference<GatewayDatasources>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Returns a list of parameters for the specified dataset from **\&quot;My
     * Workspace\&quot;**. &lt;br/&gt;**Required scope**: Dataset.ReadWrite.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).&lt;h2&gt;Restrictions&lt;/h2&gt;Datasets
     * with SQL, Oracle, Teradata &amp; SapHana Direct Query connections are not
     * supported.&lt;br/&gt;
     * <p>
     * <b>200</b> - OK
     * 
     * @param datasetId The dataset id (required)
     * @return MashupParameters
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public MashupParameters datasetsGetParameters(String datasetId) throws RestClientException {
        return datasetsGetParametersWithHttpInfo(datasetId).getBody();
    }

    /**
     * Returns a list of parameters for the specified dataset from **\&quot;My
     * Workspace\&quot;**. &lt;br/&gt;**Required scope**: Dataset.ReadWrite.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).&lt;h2&gt;Restrictions&lt;/h2&gt;Datasets
     * with SQL, Oracle, Teradata &amp; SapHana Direct Query connections are not
     * supported.&lt;br/&gt;
     * <p>
     * <b>200</b> - OK
     * 
     * @param datasetId The dataset id (required)
     * @return ResponseEntity&lt;MashupParameters&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<MashupParameters> datasetsGetParametersWithHttpInfo(String datasetId)
            throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'datasetId' is set
        if (datasetId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'datasetId' when calling datasetsGetParameters");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("datasetId", datasetId);
        String path = apiClient.expandPath("/v1.0/myorg/datasets/{datasetId}/parameters", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<MashupParameters> returnType = new ParameterizedTypeReference<MashupParameters>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Returns a list of parameters for the specified dataset from the specified
     * workspace. &lt;br/&gt;**Required scope**: Dataset.ReadWrite.All &lt;br/&gt;To
     * set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).&lt;h2&gt;Restrictions&lt;/h2&gt;Datasets
     * with SQL, Oracle, Teradata &amp; SapHana Direct Query connections are not
     * supported.&lt;br/&gt;
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId   The workspace id (required)
     * @param datasetId (required)
     * @return MashupParameters
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public MashupParameters datasetsGetParametersInGroup(UUID groupId, String datasetId) throws RestClientException {
        return datasetsGetParametersInGroupWithHttpInfo(groupId, datasetId).getBody();
    }

    /**
     * Returns a list of parameters for the specified dataset from the specified
     * workspace. &lt;br/&gt;**Required scope**: Dataset.ReadWrite.All &lt;br/&gt;To
     * set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).&lt;h2&gt;Restrictions&lt;/h2&gt;Datasets
     * with SQL, Oracle, Teradata &amp; SapHana Direct Query connections are not
     * supported.&lt;br/&gt;
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId   The workspace id (required)
     * @param datasetId (required)
     * @return ResponseEntity&lt;MashupParameters&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<MashupParameters> datasetsGetParametersInGroupWithHttpInfo(UUID groupId, String datasetId)
            throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling datasetsGetParametersInGroup");
        }

        // verify the required parameter 'datasetId' is set
        if (datasetId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'datasetId' when calling datasetsGetParametersInGroup");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("datasetId", datasetId);
        String path = apiClient.expandPath("/v1.0/myorg/groups/{groupId}/datasets/{datasetId}/parameters",
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

        ParameterizedTypeReference<MashupParameters> returnType = new ParameterizedTypeReference<MashupParameters>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Returns the refresh history of the specified dataset from **\&quot;My
     * Workspace\&quot;**. &lt;br/&gt;**Required scope**: Dataset.ReadWrite.All or
     * Dataset.Read.All &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param datasetId The dataset id (required)
     * @param $top      The requested number of entries in the refresh history. If
     *                  not provided, the default is all available entries.
     *                  (optional)
     * @return Refreshes
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Refreshes datasetsGetRefreshHistory(String datasetId, Integer $top) throws RestClientException {
        return datasetsGetRefreshHistoryWithHttpInfo(datasetId, $top).getBody();
    }

    /**
     * Returns the refresh history of the specified dataset from **\&quot;My
     * Workspace\&quot;**. &lt;br/&gt;**Required scope**: Dataset.ReadWrite.All or
     * Dataset.Read.All &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param datasetId The dataset id (required)
     * @param $top      The requested number of entries in the refresh history. If
     *                  not provided, the default is all available entries.
     *                  (optional)
     * @return ResponseEntity&lt;Refreshes&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Refreshes> datasetsGetRefreshHistoryWithHttpInfo(String datasetId, Integer $top)
            throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'datasetId' is set
        if (datasetId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'datasetId' when calling datasetsGetRefreshHistory");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("datasetId", datasetId);
        String path = apiClient.expandPath("/v1.0/myorg/datasets/{datasetId}/refreshes", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "$top", $top));

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Refreshes> returnType = new ParameterizedTypeReference<Refreshes>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Returns the refresh history of the specified dataset from the specified
     * workspace. &lt;br/&gt;**Required scope**: Dataset.ReadWrite.All or
     * Dataset.Read.All &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId   The workspace id (required)
     * @param datasetId The dataset id (required)
     * @param $top      The requested number of entries in the refresh history. If
     *                  not provided, the default is all available entries.
     *                  (optional)
     * @return Refreshes
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Refreshes datasetsGetRefreshHistoryInGroup(UUID groupId, String datasetId, Integer $top)
            throws RestClientException {
        return datasetsGetRefreshHistoryInGroupWithHttpInfo(groupId, datasetId, $top).getBody();
    }

    /**
     * Returns the refresh history of the specified dataset from the specified
     * workspace. &lt;br/&gt;**Required scope**: Dataset.ReadWrite.All or
     * Dataset.Read.All &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId   The workspace id (required)
     * @param datasetId The dataset id (required)
     * @param $top      The requested number of entries in the refresh history. If
     *                  not provided, the default is all available entries.
     *                  (optional)
     * @return ResponseEntity&lt;Refreshes&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Refreshes> datasetsGetRefreshHistoryInGroupWithHttpInfo(UUID groupId, String datasetId,
            Integer $top) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling datasetsGetRefreshHistoryInGroup");
        }

        // verify the required parameter 'datasetId' is set
        if (datasetId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'datasetId' when calling datasetsGetRefreshHistoryInGroup");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("datasetId", datasetId);
        String path = apiClient.expandPath("/v1.0/myorg/groups/{groupId}/datasets/{datasetId}/refreshes", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "$top", $top));

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Refreshes> returnType = new ParameterizedTypeReference<Refreshes>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Returns the refresh schedule of the specified dataset from **\&quot;My
     * Workspace\&quot;**. &lt;br/&gt;**Required scope**: Dataset.ReadWrite.All or
     * Dataset.Read.All &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param datasetId The dataset id (required)
     * @return RefreshSchedule
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public RefreshSchedule datasetsGetRefreshSchedule(String datasetId) throws RestClientException {
        return datasetsGetRefreshScheduleWithHttpInfo(datasetId).getBody();
    }

    /**
     * Returns the refresh schedule of the specified dataset from **\&quot;My
     * Workspace\&quot;**. &lt;br/&gt;**Required scope**: Dataset.ReadWrite.All or
     * Dataset.Read.All &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param datasetId The dataset id (required)
     * @return ResponseEntity&lt;RefreshSchedule&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<RefreshSchedule> datasetsGetRefreshScheduleWithHttpInfo(String datasetId)
            throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'datasetId' is set
        if (datasetId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'datasetId' when calling datasetsGetRefreshSchedule");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("datasetId", datasetId);
        String path = apiClient.expandPath("/v1.0/myorg/datasets/{datasetId}/refreshSchedule", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<RefreshSchedule> returnType = new ParameterizedTypeReference<RefreshSchedule>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Returns the refresh schedule of the specified dataset from the specified
     * workspace. &lt;br/&gt;**Required scope**: Dataset.ReadWrite.All or
     * Dataset.Read.All &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId   The workspace id (required)
     * @param datasetId The dataset id (required)
     * @return RefreshSchedule
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public RefreshSchedule datasetsGetRefreshScheduleInGroup(UUID groupId, String datasetId)
            throws RestClientException {
        return datasetsGetRefreshScheduleInGroupWithHttpInfo(groupId, datasetId).getBody();
    }

    /**
     * Returns the refresh schedule of the specified dataset from the specified
     * workspace. &lt;br/&gt;**Required scope**: Dataset.ReadWrite.All or
     * Dataset.Read.All &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId   The workspace id (required)
     * @param datasetId The dataset id (required)
     * @return ResponseEntity&lt;RefreshSchedule&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<RefreshSchedule> datasetsGetRefreshScheduleInGroupWithHttpInfo(UUID groupId, String datasetId)
            throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling datasetsGetRefreshScheduleInGroup");
        }

        // verify the required parameter 'datasetId' is set
        if (datasetId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'datasetId' when calling datasetsGetRefreshScheduleInGroup");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("datasetId", datasetId);
        String path = apiClient.expandPath("/v1.0/myorg/groups/{groupId}/datasets/{datasetId}/refreshSchedule",
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

        ParameterizedTypeReference<RefreshSchedule> returnType = new ParameterizedTypeReference<RefreshSchedule>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Triggers a refresh for the specified dataset from **\&quot;My
     * Workspace\&quot;**. &lt;br/&gt;In Shared capacities this call is limited to
     * eight times per day (including refreshes executed via Scheduled
     * Refresh)&lt;br/&gt;In Premium capacities this call is not limited in number
     * of times per day, but only by the available resources in the capacity, hence
     * if overloaded, the refresh execution may be throttled until the load is
     * reduced. If this throttling exceeds 1 hour, the refresh will
     * fail.&lt;br/&gt;&lt;br/&gt;**Required scope**:
     * Dataset.ReadWrite.All&lt;br/&gt;To set the permissions scope, see [Register
     * an app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>202</b> - Accepted
     * 
     * @param datasetId      The dataset id (required)
     * @param refreshRequest (optional)
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public void datasetsRefreshDataset(String datasetId, RefreshRequest refreshRequest) throws RestClientException {
        datasetsRefreshDatasetWithHttpInfo(datasetId, refreshRequest);
    }

    /**
     * Triggers a refresh for the specified dataset from **\&quot;My
     * Workspace\&quot;**. &lt;br/&gt;In Shared capacities this call is limited to
     * eight times per day (including refreshes executed via Scheduled
     * Refresh)&lt;br/&gt;In Premium capacities this call is not limited in number
     * of times per day, but only by the available resources in the capacity, hence
     * if overloaded, the refresh execution may be throttled until the load is
     * reduced. If this throttling exceeds 1 hour, the refresh will
     * fail.&lt;br/&gt;&lt;br/&gt;**Required scope**:
     * Dataset.ReadWrite.All&lt;br/&gt;To set the permissions scope, see [Register
     * an app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>202</b> - Accepted
     * 
     * @param datasetId      The dataset id (required)
     * @param refreshRequest (optional)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Void> datasetsRefreshDatasetWithHttpInfo(String datasetId, RefreshRequest refreshRequest)
            throws RestClientException {
        Object postBody = refreshRequest;

        // verify the required parameter 'datasetId' is set
        if (datasetId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'datasetId' when calling datasetsRefreshDataset");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("datasetId", datasetId);
        String path = apiClient.expandPath("/v1.0/myorg/datasets/{datasetId}/refreshes", uriVariables);

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
     * Triggers a refresh for the specified dataset from the specified workspace.
     * &lt;br/&gt;In Shared capacities this call is limited to eight times per day
     * (including refreshes executed via Scheduled Refresh)&lt;br/&gt;In Premium
     * capacities this call is not limited in number of times per day, but only by
     * the available resources in the capacity, hence if overloaded, the refresh
     * execution may be throttled until the load is reduced. If this throttling
     * exceeds 1 hour, the refresh will fail.&lt;br/&gt;&lt;br/&gt;**Required
     * scope**: Dataset.ReadWrite.All&lt;br/&gt;To set the permissions scope, see
     * [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>202</b> - Accepted
     * 
     * @param groupId        The workspace id (required)
     * @param datasetId      The dataset id (required)
     * @param refreshRequest (optional)
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public void datasetsRefreshDatasetInGroup(UUID groupId, String datasetId, RefreshRequest refreshRequest)
            throws RestClientException {
        datasetsRefreshDatasetInGroupWithHttpInfo(groupId, datasetId, refreshRequest);
    }

    /**
     * Triggers a refresh for the specified dataset from the specified workspace.
     * &lt;br/&gt;In Shared capacities this call is limited to eight times per day
     * (including refreshes executed via Scheduled Refresh)&lt;br/&gt;In Premium
     * capacities this call is not limited in number of times per day, but only by
     * the available resources in the capacity, hence if overloaded, the refresh
     * execution may be throttled until the load is reduced. If this throttling
     * exceeds 1 hour, the refresh will fail.&lt;br/&gt;&lt;br/&gt;**Required
     * scope**: Dataset.ReadWrite.All&lt;br/&gt;To set the permissions scope, see
     * [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>202</b> - Accepted
     * 
     * @param groupId        The workspace id (required)
     * @param datasetId      The dataset id (required)
     * @param refreshRequest (optional)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Void> datasetsRefreshDatasetInGroupWithHttpInfo(UUID groupId, String datasetId,
            RefreshRequest refreshRequest) throws RestClientException {
        Object postBody = refreshRequest;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling datasetsRefreshDatasetInGroup");
        }

        // verify the required parameter 'datasetId' is set
        if (datasetId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'datasetId' when calling datasetsRefreshDatasetInGroup");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("datasetId", datasetId);
        String path = apiClient.expandPath("/v1.0/myorg/groups/{groupId}/datasets/{datasetId}/refreshes", uriVariables);

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
     * **Note: This API is deprecated and no longer supported.**&lt;/br&gt;Updates
     * all connections for the specified dataset from **\&quot;My
     * Workspace\&quot;**. &lt;br/&gt;**Notes**:&lt;ul&gt;&lt;li&gt;To update
     * connection details for SQL, AS, OData Feed, and SharePoint, use [Update
     * Datasources](/rest/api/power-bi/datasets/updatedatasources). For other
     * datasource types, use [Update
     * Parameters](/rest/api/power-bi/datasets/updateparameters).&lt;/li&gt;&lt;li&gt;This
     * API only supports SQL DirectQuery
     * datasets.&lt;/li&gt;&lt;/ul&gt;&lt;br/&gt;&lt;br/&gt;**Required scope**:
     * Dataset.ReadWrite.All &lt;br/&gt;To set the permissions scope, see [Register
     * an app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param datasetId  The dataset id (required)
     * @param parameters The body (required)
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    @Deprecated
    public void datasetsSetAllDatasetConnections(String datasetId, ConnectionDetails parameters)
            throws RestClientException {
        datasetsSetAllDatasetConnectionsWithHttpInfo(datasetId, parameters);
    }

    /**
     * **Note: This API is deprecated and no longer supported.**&lt;/br&gt;Updates
     * all connections for the specified dataset from **\&quot;My
     * Workspace\&quot;**. &lt;br/&gt;**Notes**:&lt;ul&gt;&lt;li&gt;To update
     * connection details for SQL, AS, OData Feed, and SharePoint, use [Update
     * Datasources](/rest/api/power-bi/datasets/updatedatasources). For other
     * datasource types, use [Update
     * Parameters](/rest/api/power-bi/datasets/updateparameters).&lt;/li&gt;&lt;li&gt;This
     * API only supports SQL DirectQuery
     * datasets.&lt;/li&gt;&lt;/ul&gt;&lt;br/&gt;&lt;br/&gt;**Required scope**:
     * Dataset.ReadWrite.All &lt;br/&gt;To set the permissions scope, see [Register
     * an app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param datasetId  The dataset id (required)
     * @param parameters The body (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    @Deprecated
    public ResponseEntity<Void> datasetsSetAllDatasetConnectionsWithHttpInfo(String datasetId,
            ConnectionDetails parameters) throws RestClientException {
        Object postBody = parameters;

        // verify the required parameter 'datasetId' is set
        if (datasetId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'datasetId' when calling datasetsSetAllDatasetConnections");
        }

        // verify the required parameter 'parameters' is set
        if (parameters == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'parameters' when calling datasetsSetAllDatasetConnections");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("datasetId", datasetId);
        String path = apiClient.expandPath("/v1.0/myorg/datasets/{datasetId}/Default.SetAllConnections", uriVariables);

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
     * **Note: This API is deprecated and no longer supported.**&lt;/br&gt;Updates
     * all connections for the specified dataset from the specified workspace.
     * &lt;br/&gt;**Notes**:&lt;ul&gt;&lt;li&gt;To update connection details for
     * SQL, AS, OData Feed, and SharePoint, use [Update Datasources In
     * Group](/rest/api/power-bi/datasets/updatedatasourcesingroup). For other
     * datasource types, use [Update Parameters In
     * Group](/rest/api/power-bi/datasets/updateparametersingroup).&lt;/li&gt;&lt;li&gt;This
     * API only supports SQL DirectQuery datasets.&lt;/li&gt;&lt;/ul&gt;
     * &lt;br/&gt;&lt;br/&gt;**Required scope**: Dataset.ReadWrite.All &lt;br/&gt;To
     * set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId    The workspace id (required)
     * @param datasetId  The dataset id (required)
     * @param parameters The body (required)
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    @Deprecated
    public void datasetsSetAllDatasetConnectionsInGroup(UUID groupId, String datasetId, ConnectionDetails parameters)
            throws RestClientException {
        datasetsSetAllDatasetConnectionsInGroupWithHttpInfo(groupId, datasetId, parameters);
    }

    /**
     * **Note: This API is deprecated and no longer supported.**&lt;/br&gt;Updates
     * all connections for the specified dataset from the specified workspace.
     * &lt;br/&gt;**Notes**:&lt;ul&gt;&lt;li&gt;To update connection details for
     * SQL, AS, OData Feed, and SharePoint, use [Update Datasources In
     * Group](/rest/api/power-bi/datasets/updatedatasourcesingroup). For other
     * datasource types, use [Update Parameters In
     * Group](/rest/api/power-bi/datasets/updateparametersingroup).&lt;/li&gt;&lt;li&gt;This
     * API only supports SQL DirectQuery datasets.&lt;/li&gt;&lt;/ul&gt;
     * &lt;br/&gt;&lt;br/&gt;**Required scope**: Dataset.ReadWrite.All &lt;br/&gt;To
     * set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId    The workspace id (required)
     * @param datasetId  The dataset id (required)
     * @param parameters The body (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    @Deprecated
    public ResponseEntity<Void> datasetsSetAllDatasetConnectionsInGroupWithHttpInfo(UUID groupId, String datasetId,
            ConnectionDetails parameters) throws RestClientException {
        Object postBody = parameters;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling datasetsSetAllDatasetConnectionsInGroup");
        }

        // verify the required parameter 'datasetId' is set
        if (datasetId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'datasetId' when calling datasetsSetAllDatasetConnectionsInGroup");
        }

        // verify the required parameter 'parameters' is set
        if (parameters == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'parameters' when calling datasetsSetAllDatasetConnectionsInGroup");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("datasetId", datasetId);
        String path = apiClient.expandPath(
                "/v1.0/myorg/groups/{groupId}/datasets/{datasetId}/Default.SetAllConnections", uriVariables);

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
     * Transfers ownership over the specified dataset to the current authorized
     * user. &lt;br/&gt;**Required scope**: Dataset.ReadWrite.All &lt;br/&gt;To set
     * the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId   The workspace id (required)
     * @param datasetId The dataset id (required)
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public void datasetsTakeOverInGroup(UUID groupId, String datasetId) throws RestClientException {
        datasetsTakeOverInGroupWithHttpInfo(groupId, datasetId);
    }

    /**
     * Transfers ownership over the specified dataset to the current authorized
     * user. &lt;br/&gt;**Required scope**: Dataset.ReadWrite.All &lt;br/&gt;To set
     * the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId   The workspace id (required)
     * @param datasetId The dataset id (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Void> datasetsTakeOverInGroupWithHttpInfo(UUID groupId, String datasetId)
            throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling datasetsTakeOverInGroup");
        }

        // verify the required parameter 'datasetId' is set
        if (datasetId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'datasetId' when calling datasetsTakeOverInGroup");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("datasetId", datasetId);
        String path = apiClient.expandPath("/v1.0/myorg/groups/{groupId}/datasets/{datasetId}/Default.TakeOver",
                uriVariables);

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

    /**
     * Updates the datasources of the specified dataset from **\&quot;My
     * Workspace\&quot;**. &lt;br/&gt;**Important**:&lt;ul&gt;&lt;li&gt;The original
     * datasource and the new datasource must have the exact same
     * schema.&lt;/li&gt;&lt;li&gt;For cached models, the dataset must be refreshed
     * to get the data from the new data sources. Wait 30 minutes for the update
     * datasources operation to complete before
     * refreshing.&lt;/li&gt;&lt;/ul&gt;&lt;br/&gt;&lt;br/&gt;**Required scope**:
     * Dataset.ReadWrite.All &lt;br/&gt;To set the permissions scope, see [Register
     * an app](https://docs.microsoft.com/power-bi/developer/register-app).
     * &lt;h2&gt;Restrictions&lt;/h2&gt;&lt;ul&gt;&lt;li&gt;Update datasources
     * supports the following datasource types: &lt;ul&gt;&lt;li&gt;SQL Server
     * &lt;/li&gt;&lt;li&gt;Azure SQL Server &lt;/li&gt;&lt;li&gt;Analysis Services
     * &lt;/li&gt;&lt;li&gt;Azure Analysis Services &lt;/li&gt;&lt;li&gt;OData Feed
     * &lt;/li&gt;&lt;li&gt;SharePoint &lt;/li&gt;&lt;li&gt;Oracle
     * &lt;/li&gt;&lt;li&gt;Teradata &lt;/li&gt;&lt;li&gt;SapHana
     * &lt;/li&gt;&lt;/ul&gt;For other datasource types, use [Update
     * Parameters](/rest/api/power-bi/datasets/updateparameters)
     * &lt;/li&gt;&lt;li&gt;Changing datasource type is not supported.
     * &lt;/li&gt;&lt;li&gt;Datasources that contain parameters on the connection
     * string are not supported. &lt;/li&gt;&lt;li&gt;Datasources which are part of
     * Merged or Joined tables are not supported. &lt;/li&gt;&lt;/ul&gt;
     * <p>
     * <b>200</b> - OK
     * 
     * @param datasetId                The dataset id (required)
     * @param updateDatasourcesRequest (required)
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public void datasetsUpdateDatasources(String datasetId, UpdateDatasourcesRequest updateDatasourcesRequest)
            throws RestClientException {
        datasetsUpdateDatasourcesWithHttpInfo(datasetId, updateDatasourcesRequest);
    }

    /**
     * Updates the datasources of the specified dataset from **\&quot;My
     * Workspace\&quot;**. &lt;br/&gt;**Important**:&lt;ul&gt;&lt;li&gt;The original
     * datasource and the new datasource must have the exact same
     * schema.&lt;/li&gt;&lt;li&gt;For cached models, the dataset must be refreshed
     * to get the data from the new data sources. Wait 30 minutes for the update
     * datasources operation to complete before
     * refreshing.&lt;/li&gt;&lt;/ul&gt;&lt;br/&gt;&lt;br/&gt;**Required scope**:
     * Dataset.ReadWrite.All &lt;br/&gt;To set the permissions scope, see [Register
     * an app](https://docs.microsoft.com/power-bi/developer/register-app).
     * &lt;h2&gt;Restrictions&lt;/h2&gt;&lt;ul&gt;&lt;li&gt;Update datasources
     * supports the following datasource types: &lt;ul&gt;&lt;li&gt;SQL Server
     * &lt;/li&gt;&lt;li&gt;Azure SQL Server &lt;/li&gt;&lt;li&gt;Analysis Services
     * &lt;/li&gt;&lt;li&gt;Azure Analysis Services &lt;/li&gt;&lt;li&gt;OData Feed
     * &lt;/li&gt;&lt;li&gt;SharePoint &lt;/li&gt;&lt;li&gt;Oracle
     * &lt;/li&gt;&lt;li&gt;Teradata &lt;/li&gt;&lt;li&gt;SapHana
     * &lt;/li&gt;&lt;/ul&gt;For other datasource types, use [Update
     * Parameters](/rest/api/power-bi/datasets/updateparameters)
     * &lt;/li&gt;&lt;li&gt;Changing datasource type is not supported.
     * &lt;/li&gt;&lt;li&gt;Datasources that contain parameters on the connection
     * string are not supported. &lt;/li&gt;&lt;li&gt;Datasources which are part of
     * Merged or Joined tables are not supported. &lt;/li&gt;&lt;/ul&gt;
     * <p>
     * <b>200</b> - OK
     * 
     * @param datasetId                The dataset id (required)
     * @param updateDatasourcesRequest (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Void> datasetsUpdateDatasourcesWithHttpInfo(String datasetId,
            UpdateDatasourcesRequest updateDatasourcesRequest) throws RestClientException {
        Object postBody = updateDatasourcesRequest;

        // verify the required parameter 'datasetId' is set
        if (datasetId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'datasetId' when calling datasetsUpdateDatasources");
        }

        // verify the required parameter 'updateDatasourcesRequest' is set
        if (updateDatasourcesRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'updateDatasourcesRequest' when calling datasetsUpdateDatasources");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("datasetId", datasetId);
        String path = apiClient.expandPath("/v1.0/myorg/datasets/{datasetId}/Default.UpdateDatasources", uriVariables);

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
     * Updates the datasources of the specified dataset from the specified
     * workspace. &lt;br/&gt;**Important**:&lt;ul&gt;&lt;li&gt;The original
     * datasource and the new datasource must have the exact same
     * schema.&lt;/li&gt;&lt;li&gt;For cached models, the dataset must be refreshed
     * to get the data from the new datasources. Wait 30 minutes for the update
     * datasources operation to complete before
     * refreshing.&lt;/li&gt;&lt;/ul&gt;&lt;br/&gt;&lt;br/&gt;**Required scope**:
     * Dataset.ReadWrite.All &lt;br/&gt;To set the permissions scope, see [Register
     * an app](https://docs.microsoft.com/power-bi/developer/register-app).
     * &lt;h2&gt;Restrictions&lt;/h2&gt;&lt;ul&gt;&lt;li&gt;Update datasources
     * supports the following datasource types: &lt;ul&gt;&lt;li&gt;SQL Server
     * &lt;/li&gt;&lt;li&gt;Azure SQL Server &lt;/li&gt;&lt;li&gt;Analysis Services
     * &lt;/li&gt;&lt;li&gt;Azure Analysis Services &lt;/li&gt;&lt;li&gt;OData Feed
     * &lt;/li&gt;&lt;li&gt;SharePoint &lt;/li&gt;&lt;li&gt;Oracle
     * &lt;/li&gt;&lt;li&gt;Teradata &lt;/li&gt;&lt;li&gt;SapHana
     * &lt;/li&gt;&lt;/ul&gt;For other datasource types, use [Update Parameters In
     * Group](/rest/api/power-bi/datasets/updateparametersingroup).
     * &lt;/li&gt;&lt;li&gt;Changing datasource type is not supported.
     * &lt;/li&gt;&lt;li&gt;Datasources that contain parameters on the connection
     * string are not supported. &lt;/li&gt;&lt;li&gt;Datasources which are part of
     * Merged or Joined tables are not supported. &lt;/li&gt;&lt;/ul&gt;
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId                  The workspace id (required)
     * @param datasetId                (required)
     * @param updateDatasourcesRequest (required)
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public void datasetsUpdateDatasourcesInGroup(UUID groupId, String datasetId,
            UpdateDatasourcesRequest updateDatasourcesRequest) throws RestClientException {
        datasetsUpdateDatasourcesInGroupWithHttpInfo(groupId, datasetId, updateDatasourcesRequest);
    }

    /**
     * Updates the datasources of the specified dataset from the specified
     * workspace. &lt;br/&gt;**Important**:&lt;ul&gt;&lt;li&gt;The original
     * datasource and the new datasource must have the exact same
     * schema.&lt;/li&gt;&lt;li&gt;For cached models, the dataset must be refreshed
     * to get the data from the new datasources. Wait 30 minutes for the update
     * datasources operation to complete before
     * refreshing.&lt;/li&gt;&lt;/ul&gt;&lt;br/&gt;&lt;br/&gt;**Required scope**:
     * Dataset.ReadWrite.All &lt;br/&gt;To set the permissions scope, see [Register
     * an app](https://docs.microsoft.com/power-bi/developer/register-app).
     * &lt;h2&gt;Restrictions&lt;/h2&gt;&lt;ul&gt;&lt;li&gt;Update datasources
     * supports the following datasource types: &lt;ul&gt;&lt;li&gt;SQL Server
     * &lt;/li&gt;&lt;li&gt;Azure SQL Server &lt;/li&gt;&lt;li&gt;Analysis Services
     * &lt;/li&gt;&lt;li&gt;Azure Analysis Services &lt;/li&gt;&lt;li&gt;OData Feed
     * &lt;/li&gt;&lt;li&gt;SharePoint &lt;/li&gt;&lt;li&gt;Oracle
     * &lt;/li&gt;&lt;li&gt;Teradata &lt;/li&gt;&lt;li&gt;SapHana
     * &lt;/li&gt;&lt;/ul&gt;For other datasource types, use [Update Parameters In
     * Group](/rest/api/power-bi/datasets/updateparametersingroup).
     * &lt;/li&gt;&lt;li&gt;Changing datasource type is not supported.
     * &lt;/li&gt;&lt;li&gt;Datasources that contain parameters on the connection
     * string are not supported. &lt;/li&gt;&lt;li&gt;Datasources which are part of
     * Merged or Joined tables are not supported. &lt;/li&gt;&lt;/ul&gt;
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId                  The workspace id (required)
     * @param datasetId                (required)
     * @param updateDatasourcesRequest (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Void> datasetsUpdateDatasourcesInGroupWithHttpInfo(UUID groupId, String datasetId,
            UpdateDatasourcesRequest updateDatasourcesRequest) throws RestClientException {
        Object postBody = updateDatasourcesRequest;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling datasetsUpdateDatasourcesInGroup");
        }

        // verify the required parameter 'datasetId' is set
        if (datasetId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'datasetId' when calling datasetsUpdateDatasourcesInGroup");
        }

        // verify the required parameter 'updateDatasourcesRequest' is set
        if (updateDatasourcesRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'updateDatasourcesRequest' when calling datasetsUpdateDatasourcesInGroup");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("datasetId", datasetId);
        String path = apiClient.expandPath(
                "/v1.0/myorg/groups/{groupId}/datasets/{datasetId}/Default.UpdateDatasources", uriVariables);

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
     * Updates the refresh schedule for the specified DirectQuery or LiveConnection
     * dataset from **\&quot;My Workspace\&quot;**. &lt;br/&gt;This operation is
     * only supported for the dataset owner.&lt;br/&gt;A request should contain
     * either a combination of days and times (setting times is optional, otherwise
     * a default single time per day is used) or a valid frequency, but not
     * both.&lt;br/&gt;Setting frequency will automatically truncate the days and
     * times arrays.&lt;br/&gt;&lt;br/&gt;**Required scope**: Dataset.ReadWrite.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param datasetId                       The dataset id (required)
     * @param datasetDQRefreshScheduleRequest Patch DirectQuery or LiveConnection
     *                                        Refresh Schedule parameters, by
     *                                        specifying all or some of the
     *                                        parameters (required)
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public void datasetsUpdateDirectQueryRefreshSchedule(String datasetId,
            DirectQueryRefreshScheduleRequest datasetDQRefreshScheduleRequest) throws RestClientException {
        datasetsUpdateDirectQueryRefreshScheduleWithHttpInfo(datasetId, datasetDQRefreshScheduleRequest);
    }

    /**
     * Updates the refresh schedule for the specified DirectQuery or LiveConnection
     * dataset from **\&quot;My Workspace\&quot;**. &lt;br/&gt;This operation is
     * only supported for the dataset owner.&lt;br/&gt;A request should contain
     * either a combination of days and times (setting times is optional, otherwise
     * a default single time per day is used) or a valid frequency, but not
     * both.&lt;br/&gt;Setting frequency will automatically truncate the days and
     * times arrays.&lt;br/&gt;&lt;br/&gt;**Required scope**: Dataset.ReadWrite.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param datasetId                       The dataset id (required)
     * @param datasetDQRefreshScheduleRequest Patch DirectQuery or LiveConnection
     *                                        Refresh Schedule parameters, by
     *                                        specifying all or some of the
     *                                        parameters (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Void> datasetsUpdateDirectQueryRefreshScheduleWithHttpInfo(String datasetId,
            DirectQueryRefreshScheduleRequest datasetDQRefreshScheduleRequest) throws RestClientException {
        Object postBody = datasetDQRefreshScheduleRequest;

        // verify the required parameter 'datasetId' is set
        if (datasetId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'datasetId' when calling datasetsUpdateDirectQueryRefreshSchedule");
        }

        // verify the required parameter 'datasetDQRefreshScheduleRequest' is set
        if (datasetDQRefreshScheduleRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'datasetDQRefreshScheduleRequest' when calling datasetsUpdateDirectQueryRefreshSchedule");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("datasetId", datasetId);
        String path = apiClient.expandPath("/v1.0/myorg/datasets/{datasetId}/directQueryRefreshSchedule", uriVariables);

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
        return apiClient.invokeAPI(path, HttpMethod.PATCH, queryParams, postBody, headerParams, cookieParams,
                formParams, accept, contentType, authNames, returnType);
    }

    /**
     * Updates the refresh schedule for the specified DirectQuery or LiveConnection
     * dataset from the specified workspace. &lt;br/&gt;This operation is only
     * supported for the dataset owner.&lt;br/&gt;A request should contain either a
     * combination of days and times (setting times is optional, otherwise a default
     * single time per day is used) or a valid frequency, but not
     * both.&lt;br/&gt;Setting frequency will automatically truncate the days and
     * times arrays.&lt;br/&gt;&lt;br/&gt;**Required scope**: Dataset.ReadWrite.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId                         The workspace id (required)
     * @param datasetId                       The dataset id (required)
     * @param datasetDQRefreshScheduleRequest Patch DirectQuery or LiveConnection
     *                                        Refresh Schedule parameters, by
     *                                        specifying all or some of the
     *                                        parameters (required)
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public void datasetsUpdateDirectQueryRefreshScheduleInGroup(UUID groupId, String datasetId,
            DirectQueryRefreshScheduleRequest datasetDQRefreshScheduleRequest) throws RestClientException {
        datasetsUpdateDirectQueryRefreshScheduleInGroupWithHttpInfo(groupId, datasetId,
                datasetDQRefreshScheduleRequest);
    }

    /**
     * Updates the refresh schedule for the specified DirectQuery or LiveConnection
     * dataset from the specified workspace. &lt;br/&gt;This operation is only
     * supported for the dataset owner.&lt;br/&gt;A request should contain either a
     * combination of days and times (setting times is optional, otherwise a default
     * single time per day is used) or a valid frequency, but not
     * both.&lt;br/&gt;Setting frequency will automatically truncate the days and
     * times arrays.&lt;br/&gt;&lt;br/&gt;**Required scope**: Dataset.ReadWrite.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId                         The workspace id (required)
     * @param datasetId                       The dataset id (required)
     * @param datasetDQRefreshScheduleRequest Patch DirectQuery or LiveConnection
     *                                        Refresh Schedule parameters, by
     *                                        specifying all or some of the
     *                                        parameters (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Void> datasetsUpdateDirectQueryRefreshScheduleInGroupWithHttpInfo(UUID groupId,
            String datasetId, DirectQueryRefreshScheduleRequest datasetDQRefreshScheduleRequest)
            throws RestClientException {
        Object postBody = datasetDQRefreshScheduleRequest;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling datasetsUpdateDirectQueryRefreshScheduleInGroup");
        }

        // verify the required parameter 'datasetId' is set
        if (datasetId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'datasetId' when calling datasetsUpdateDirectQueryRefreshScheduleInGroup");
        }

        // verify the required parameter 'datasetDQRefreshScheduleRequest' is set
        if (datasetDQRefreshScheduleRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'datasetDQRefreshScheduleRequest' when calling datasetsUpdateDirectQueryRefreshScheduleInGroup");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("datasetId", datasetId);
        String path = apiClient.expandPath(
                "/v1.0/myorg/groups/{groupId}/datasets/{datasetId}/directQueryRefreshSchedule", uriVariables);

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
        return apiClient.invokeAPI(path, HttpMethod.PATCH, queryParams, postBody, headerParams, cookieParams,
                formParams, accept, contentType, authNames, returnType);
    }

    /**
     * Updates the parameters values for the specified dataset from **\&quot;My
     * Workspace\&quot;**. &lt;br/&gt;**Important**: The dataset must be refreshed
     * for new parameters values to be applied. Wait 30 minutes for the update
     * parameters operation to complete before
     * refreshing.&lt;br/&gt;&lt;br/&gt;**Required scope**: Dataset.ReadWrite.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * &lt;h2&gt;Restrictions&lt;/h2&gt;&lt;ul&gt;&lt;li&gt;All parameters must
     * exist in the dataset. Names are case-sensitive. &lt;/li&gt;&lt;li&gt;Datasets
     * with SQL, Oracle, Teradata &amp; SapHana Direct Query connections are not
     * supported. &lt;/li&gt;&lt;li&gt;Datasets with Analysis Services Live
     * connections are not supported. &lt;/li&gt;&lt;li&gt; Maximum of a 100
     * parameters in request is allowed. &lt;/li&gt;&lt;li&gt; Values should be of
     * expected Type. &lt;/li&gt;&lt;li&gt; Cannot pass empty value to an IsRequired
     * parameter. &lt;/li&gt;&lt;li&gt; List cannot be empty or include multiple
     * occurrences of same parameter. &lt;/li&gt;&lt;li&gt; Parameters of types
     * &#39;Any&#39; or &#39;Binary&#39; cannot be set. &lt;/li&gt;&lt;/ul&gt;
     * <p>
     * <b>200</b> - OK
     * 
     * @param datasetId                     The dataset id (required)
     * @param updateMashupParametersRequest (required)
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public void datasetsUpdateParameters(String datasetId, UpdateMashupParametersRequest updateMashupParametersRequest)
            throws RestClientException {
        datasetsUpdateParametersWithHttpInfo(datasetId, updateMashupParametersRequest);
    }

    /**
     * Updates the parameters values for the specified dataset from **\&quot;My
     * Workspace\&quot;**. &lt;br/&gt;**Important**: The dataset must be refreshed
     * for new parameters values to be applied. Wait 30 minutes for the update
     * parameters operation to complete before
     * refreshing.&lt;br/&gt;&lt;br/&gt;**Required scope**: Dataset.ReadWrite.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * &lt;h2&gt;Restrictions&lt;/h2&gt;&lt;ul&gt;&lt;li&gt;All parameters must
     * exist in the dataset. Names are case-sensitive. &lt;/li&gt;&lt;li&gt;Datasets
     * with SQL, Oracle, Teradata &amp; SapHana Direct Query connections are not
     * supported. &lt;/li&gt;&lt;li&gt;Datasets with Analysis Services Live
     * connections are not supported. &lt;/li&gt;&lt;li&gt; Maximum of a 100
     * parameters in request is allowed. &lt;/li&gt;&lt;li&gt; Values should be of
     * expected Type. &lt;/li&gt;&lt;li&gt; Cannot pass empty value to an IsRequired
     * parameter. &lt;/li&gt;&lt;li&gt; List cannot be empty or include multiple
     * occurrences of same parameter. &lt;/li&gt;&lt;li&gt; Parameters of types
     * &#39;Any&#39; or &#39;Binary&#39; cannot be set. &lt;/li&gt;&lt;/ul&gt;
     * <p>
     * <b>200</b> - OK
     * 
     * @param datasetId                     The dataset id (required)
     * @param updateMashupParametersRequest (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Void> datasetsUpdateParametersWithHttpInfo(String datasetId,
            UpdateMashupParametersRequest updateMashupParametersRequest) throws RestClientException {
        Object postBody = updateMashupParametersRequest;

        // verify the required parameter 'datasetId' is set
        if (datasetId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'datasetId' when calling datasetsUpdateParameters");
        }

        // verify the required parameter 'updateMashupParametersRequest' is set
        if (updateMashupParametersRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'updateMashupParametersRequest' when calling datasetsUpdateParameters");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("datasetId", datasetId);
        String path = apiClient.expandPath("/v1.0/myorg/datasets/{datasetId}/Default.UpdateParameters", uriVariables);

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
     * Updates the parameters values for the specified dataset from the specified
     * workspace. &lt;br/&gt;**Important**: The dataset must be refreshed for the
     * new parameter values to be applied. Wait 30 minutes for the update parameters
     * operation to complete before refreshing.&lt;br/&gt;&lt;br/&gt;**Required
     * scope**: Dataset.ReadWrite.All &lt;br/&gt;To set the permissions scope, see
     * [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * &lt;h2&gt;Restrictions&lt;/h2&gt;&lt;ul&gt;&lt;li&gt;All parameters must
     * exist in the dataset. Names are case-sensitive. &lt;/li&gt;&lt;li&gt;Datasets
     * with SQL, Oracle, Teradata &amp; SapHana Direct Query connections are not
     * supported. &lt;/li&gt;&lt;li&gt;Datasets with Analysis Services Live
     * connections are not supported. &lt;/li&gt;&lt;li&gt; Maximum of 100
     * parameters in request is allowed. &lt;/li&gt;&lt;li&gt; Values should be of
     * expected type. &lt;/li&gt;&lt;li&gt; An empty value is not permitted for the
     * IsRequired parameter. &lt;/li&gt;&lt;li&gt; List cannot be empty or include
     * multiple occurrences of same parameter. &lt;/li&gt;&lt;li&gt; Parameters of
     * types &#39;Any&#39; or &#39;Binary&#39; cannot be set. &lt;/li&gt;&lt;/ul&gt;
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId                       The workspace id (required)
     * @param datasetId                     (required)
     * @param updateMashupParametersRequest (required)
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public void datasetsUpdateParametersInGroup(UUID groupId, String datasetId,
            UpdateMashupParametersRequest updateMashupParametersRequest) throws RestClientException {
        datasetsUpdateParametersInGroupWithHttpInfo(groupId, datasetId, updateMashupParametersRequest);
    }

    /**
     * Updates the parameters values for the specified dataset from the specified
     * workspace. &lt;br/&gt;**Important**: The dataset must be refreshed for the
     * new parameter values to be applied. Wait 30 minutes for the update parameters
     * operation to complete before refreshing.&lt;br/&gt;&lt;br/&gt;**Required
     * scope**: Dataset.ReadWrite.All &lt;br/&gt;To set the permissions scope, see
     * [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * &lt;h2&gt;Restrictions&lt;/h2&gt;&lt;ul&gt;&lt;li&gt;All parameters must
     * exist in the dataset. Names are case-sensitive. &lt;/li&gt;&lt;li&gt;Datasets
     * with SQL, Oracle, Teradata &amp; SapHana Direct Query connections are not
     * supported. &lt;/li&gt;&lt;li&gt;Datasets with Analysis Services Live
     * connections are not supported. &lt;/li&gt;&lt;li&gt; Maximum of 100
     * parameters in request is allowed. &lt;/li&gt;&lt;li&gt; Values should be of
     * expected type. &lt;/li&gt;&lt;li&gt; An empty value is not permitted for the
     * IsRequired parameter. &lt;/li&gt;&lt;li&gt; List cannot be empty or include
     * multiple occurrences of same parameter. &lt;/li&gt;&lt;li&gt; Parameters of
     * types &#39;Any&#39; or &#39;Binary&#39; cannot be set. &lt;/li&gt;&lt;/ul&gt;
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId                       The workspace id (required)
     * @param datasetId                     (required)
     * @param updateMashupParametersRequest (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Void> datasetsUpdateParametersInGroupWithHttpInfo(UUID groupId, String datasetId,
            UpdateMashupParametersRequest updateMashupParametersRequest) throws RestClientException {
        Object postBody = updateMashupParametersRequest;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling datasetsUpdateParametersInGroup");
        }

        // verify the required parameter 'datasetId' is set
        if (datasetId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'datasetId' when calling datasetsUpdateParametersInGroup");
        }

        // verify the required parameter 'updateMashupParametersRequest' is set
        if (updateMashupParametersRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'updateMashupParametersRequest' when calling datasetsUpdateParametersInGroup");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("datasetId", datasetId);
        String path = apiClient.expandPath("/v1.0/myorg/groups/{groupId}/datasets/{datasetId}/Default.UpdateParameters",
                uriVariables);

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
     * Updates the refresh schedule for the specified dataset from **\&quot;My
     * Workspace\&quot;**. &lt;br/&gt;This operation is only supported for the
     * dataset owner.&lt;br/&gt;A request that disables the refresh schedule should
     * contain no other changes.&lt;br/&gt;The days array should not be set to empty
     * array.&lt;br/&gt;The times may be set to empty array (in which case Power BI
     * will use a default single time per day).&lt;br/&gt;The limit on number of
     * time slots per day depends on the type of capacity used (Premium or Shared),
     * see [What is Microsoft Power BI
     * Premium](https://docs.microsoft.com/en-us/power-bi/service-premium).&lt;br/&gt;&lt;br/&gt;**Required
     * scope**: Dataset.ReadWrite.All &lt;br/&gt;To set the permissions scope, see
     * [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param datasetId                          The dataset id (required)
     * @param datasetModelRefreshScheduleRequest Update Refresh Schedule parameters,
     *                                           by specifying all or some of the
     *                                           parameters (required)
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public void datasetsUpdateRefreshSchedule(String datasetId,
            RefreshScheduleRequest datasetModelRefreshScheduleRequest) throws RestClientException {
        datasetsUpdateRefreshScheduleWithHttpInfo(datasetId, datasetModelRefreshScheduleRequest);
    }

    /**
     * Updates the refresh schedule for the specified dataset from **\&quot;My
     * Workspace\&quot;**. &lt;br/&gt;This operation is only supported for the
     * dataset owner.&lt;br/&gt;A request that disables the refresh schedule should
     * contain no other changes.&lt;br/&gt;The days array should not be set to empty
     * array.&lt;br/&gt;The times may be set to empty array (in which case Power BI
     * will use a default single time per day).&lt;br/&gt;The limit on number of
     * time slots per day depends on the type of capacity used (Premium or Shared),
     * see [What is Microsoft Power BI
     * Premium](https://docs.microsoft.com/en-us/power-bi/service-premium).&lt;br/&gt;&lt;br/&gt;**Required
     * scope**: Dataset.ReadWrite.All &lt;br/&gt;To set the permissions scope, see
     * [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param datasetId                          The dataset id (required)
     * @param datasetModelRefreshScheduleRequest Update Refresh Schedule parameters,
     *                                           by specifying all or some of the
     *                                           parameters (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Void> datasetsUpdateRefreshScheduleWithHttpInfo(String datasetId,
            RefreshScheduleRequest datasetModelRefreshScheduleRequest) throws RestClientException {
        Object postBody = datasetModelRefreshScheduleRequest;

        // verify the required parameter 'datasetId' is set
        if (datasetId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'datasetId' when calling datasetsUpdateRefreshSchedule");
        }

        // verify the required parameter 'datasetModelRefreshScheduleRequest' is set
        if (datasetModelRefreshScheduleRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'datasetModelRefreshScheduleRequest' when calling datasetsUpdateRefreshSchedule");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("datasetId", datasetId);
        String path = apiClient.expandPath("/v1.0/myorg/datasets/{datasetId}/refreshSchedule", uriVariables);

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
        return apiClient.invokeAPI(path, HttpMethod.PATCH, queryParams, postBody, headerParams, cookieParams,
                formParams, accept, contentType, authNames, returnType);
    }

    /**
     * Updates the refresh schedule for the specified dataset from the specified
     * workspace. &lt;br/&gt;This operation is only supported for the dataset
     * owner.&lt;br/&gt;A request that disables the refresh schedule should contain
     * no other changes.&lt;br/&gt;The days array should not be set to empty
     * array.&lt;br/&gt;The times may be set to empty array (in which case Power BI
     * will use a default single time per day).&lt;br/&gt;The limit on number of
     * time slots per day depends on the type of capacity used (Premium or Shared),
     * see [What is Microsoft Power BI
     * Premium](https://docs.microsoft.com/en-us/power-bi/service-premium).&lt;br/&gt;&lt;br/&gt;**Required
     * scope**: Dataset.ReadWrite.All &lt;br/&gt;To set the permissions scope, see
     * [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId                            The workspace id (required)
     * @param datasetId                          The dataset id (required)
     * @param datasetModelRefreshScheduleRequest Update Refresh Schedule parameters,
     *                                           by specifying all or some of the
     *                                           parameters (required)
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public void datasetsUpdateRefreshScheduleInGroup(UUID groupId, String datasetId,
            RefreshScheduleRequest datasetModelRefreshScheduleRequest) throws RestClientException {
        datasetsUpdateRefreshScheduleInGroupWithHttpInfo(groupId, datasetId, datasetModelRefreshScheduleRequest);
    }

    /**
     * Updates the refresh schedule for the specified dataset from the specified
     * workspace. &lt;br/&gt;This operation is only supported for the dataset
     * owner.&lt;br/&gt;A request that disables the refresh schedule should contain
     * no other changes.&lt;br/&gt;The days array should not be set to empty
     * array.&lt;br/&gt;The times may be set to empty array (in which case Power BI
     * will use a default single time per day).&lt;br/&gt;The limit on number of
     * time slots per day depends on the type of capacity used (Premium or Shared),
     * see [What is Microsoft Power BI
     * Premium](https://docs.microsoft.com/en-us/power-bi/service-premium).&lt;br/&gt;&lt;br/&gt;**Required
     * scope**: Dataset.ReadWrite.All &lt;br/&gt;To set the permissions scope, see
     * [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId                            The workspace id (required)
     * @param datasetId                          The dataset id (required)
     * @param datasetModelRefreshScheduleRequest Update Refresh Schedule parameters,
     *                                           by specifying all or some of the
     *                                           parameters (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Void> datasetsUpdateRefreshScheduleInGroupWithHttpInfo(UUID groupId, String datasetId,
            RefreshScheduleRequest datasetModelRefreshScheduleRequest) throws RestClientException {
        Object postBody = datasetModelRefreshScheduleRequest;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling datasetsUpdateRefreshScheduleInGroup");
        }

        // verify the required parameter 'datasetId' is set
        if (datasetId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'datasetId' when calling datasetsUpdateRefreshScheduleInGroup");
        }

        // verify the required parameter 'datasetModelRefreshScheduleRequest' is set
        if (datasetModelRefreshScheduleRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'datasetModelRefreshScheduleRequest' when calling datasetsUpdateRefreshScheduleInGroup");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("datasetId", datasetId);
        String path = apiClient.expandPath("/v1.0/myorg/groups/{groupId}/datasets/{datasetId}/refreshSchedule",
                uriVariables);

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
        return apiClient.invokeAPI(path, HttpMethod.PATCH, queryParams, postBody, headerParams, cookieParams,
                formParams, accept, contentType, authNames, returnType);
    }
}
