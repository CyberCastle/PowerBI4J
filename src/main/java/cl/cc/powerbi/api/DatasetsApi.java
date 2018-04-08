package cl.cc.powerbi.api;


import cl.cc.powerbi.api.model.BindToGatewayRequest;
import cl.cc.powerbi.api.model.ConnectionDetails;
import cl.cc.powerbi.api.model.Dataset;
import cl.cc.powerbi.api.model.EmbedToken;
import cl.cc.powerbi.api.model.GenerateTokenRequest;
import cl.cc.powerbi.api.model.ODataResponseListDataset;
import cl.cc.powerbi.api.model.ODataResponseListDatasetParameter;
import cl.cc.powerbi.api.model.ODataResponseListDatasource;
import cl.cc.powerbi.api.model.ODataResponseListGatewayDatasource;
import cl.cc.powerbi.api.model.ODataResponseListRefresh;
import cl.cc.powerbi.api.model.ODataResponseListTable;
import cl.cc.powerbi.api.model.UpdateDatasetParametersRequest;
import cl.cc.powerbi.api.model.UpdateDatasourcesRequest;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
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
public class DatasetsApi extends BaseApiAbstract {

    public DatasetsApi(String accessToken) {
        super(accessToken);
    }

    /**
     * Bind dataset to gateway
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param datasetKey The dataset id
     * @param bindToGatewayRequest The bind to gateway request
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public Object bindToGateway(String datasetKey, BindToGatewayRequest bindToGatewayRequest) throws RestClientException {

        // Verify the required parameter 'datasetKey' is set
        if (datasetKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'datasetKey' when calling datasetsBindToGateway");
        }

        // Verify the required parameter 'bindToGatewayRequest' is set
        if (bindToGatewayRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'bindToGatewayRequest' when calling datasetsBindToGateway");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("datasetKey", datasetKey);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/datasets/{datasetKey}/Default.BindToGateway").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {
        };
        return this.invokeAPI(path, HttpMethod.POST, null, bindToGatewayRequest, null, defaultContentTypes, returnType);
    }

    /**
     * Bind dataset to gateway
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param groupId The group id
     * @param datasetKey The dataset id
     * @param bindToGatewayRequest The bind to gateway request
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public Object bindToGatewayInGroup(String groupId, String datasetKey, BindToGatewayRequest bindToGatewayRequest) throws RestClientException {

        // Verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'groupId' when calling datasetsBindToGatewayInGroup");
        }

        // Verify the required parameter 'datasetKey' is set
        if (datasetKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'datasetKey' when calling datasetsBindToGatewayInGroup");
        }

        // Verify the required parameter 'bindToGatewayRequest' is set
        if (bindToGatewayRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'bindToGatewayRequest' when calling datasetsBindToGatewayInGroup");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("datasetKey", datasetKey);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/groups/{groupId}/datasets/{datasetKey}/Default.BindToGateway").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {
        };
        return this.invokeAPI(path, HttpMethod.POST, null, bindToGatewayRequest, null, defaultContentTypes, returnType);
    }

    /**
     * Deletes the dataset with the specified id
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param datasetKey The dataset id
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public Object deleteDatasetById(String datasetKey) throws RestClientException {

        // Verify the required parameter 'datasetKey' is set
        if (datasetKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'datasetKey' when calling datasetsDeleteDatasetById");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("datasetKey", datasetKey);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/datasets/{datasetKey}").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {
        };
        return this.invokeAPI(path, HttpMethod.DELETE, null, null, null, null, returnType);
    }

    /**
     * Deletes the dataset with the specified id
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param groupId The group id
     * @param datasetKey The dataset id
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public Object deleteDatasetByIdInGroup(String groupId, String datasetKey) throws RestClientException {

        // Verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'groupId' when calling datasetsDeleteDatasetByIdInGroup");
        }

        // Verify the required parameter 'datasetKey' is set
        if (datasetKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'datasetKey' when calling datasetsDeleteDatasetByIdInGroup");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("datasetKey", datasetKey);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/groups/{groupId}/datasets/{datasetKey}").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {
        };
        return this.invokeAPI(path, HttpMethod.DELETE, null, null, null, null, returnType);
    }

    /**
     * Deletes all rows from the specified table
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param datasetKey The dataset id
     * @param tableName The table name
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public Object deleteRows(String datasetKey, String tableName) throws RestClientException {

        // Verify the required parameter 'datasetKey' is set
        if (datasetKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'datasetKey' when calling datasetsDeleteRows");
        }

        // Verify the required parameter 'tableName' is set
        if (tableName == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'tableName' when calling datasetsDeleteRows");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("datasetKey", datasetKey);
        uriVariables.put("tableName", tableName);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/datasets/{datasetKey}/tables/{tableName}/rows").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {
        };
        return this.invokeAPI(path, HttpMethod.DELETE, null, null, null, null, returnType);
    }

    /**
     * Deletes all rows from the specified table
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param groupId The group id
     * @param datasetKey The dataset id
     * @param tableName The table name
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public Object deleteRowsInGroup(String groupId, String datasetKey, String tableName) throws RestClientException {

        // Verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'groupId' when calling datasetsDeleteRowsInGroup");
        }

        // Verify the required parameter 'datasetKey' is set
        if (datasetKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'datasetKey' when calling datasetsDeleteRowsInGroup");
        }

        // Verify the required parameter 'tableName' is set
        if (tableName == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'tableName' when calling datasetsDeleteRowsInGroup");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("datasetKey", datasetKey);
        uriVariables.put("tableName", tableName);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/groups/{groupId}/datasets/{datasetKey}/tables/{tableName}/rows").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {
        };
        return this.invokeAPI(path, HttpMethod.DELETE, null, null, null, null, returnType);
    }

    /**
     * Generate token to view the specified dataset
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param groupId The group id
     * @param datasetKey The dataset id
     * @param requestParameters Generate token parameters
     * @return EmbedToken
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public EmbedToken denerateTokenInGroup(String groupId, String datasetKey, GenerateTokenRequest requestParameters) throws RestClientException {

        // Verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'groupId' when calling datasetsGenerateTokenInGroup");
        }

        // Verify the required parameter 'datasetKey' is set
        if (datasetKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'datasetKey' when calling datasetsGenerateTokenInGroup");
        }

        // Verify the required parameter 'requestParameters' is set
        if (requestParameters == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'requestParameters' when calling datasetsGenerateTokenInGroup");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("datasetKey", datasetKey);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/groups/{groupId}/datasets/{datasetKey}/GenerateToken").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<EmbedToken> returnType = new ParameterizedTypeReference<EmbedToken>() {
        };
        return this.invokeAPI(path, HttpMethod.POST, null, requestParameters, defaultAccepts, defaultContentTypes, returnType);
    }

    /**
     * Gets the dataset metadata for the specifeid dataset id
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param datasetKey The dataset id
     * @return Dataset
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public Dataset getDatasetById(String datasetKey) throws RestClientException {

        // Verify the required parameter 'datasetKey' is set
        if (datasetKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'datasetKey' when calling datasetsGetDatasetById");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("datasetKey", datasetKey);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/datasets/{datasetKey}").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<Dataset> returnType = new ParameterizedTypeReference<Dataset>() {
        };
        return this.invokeAPI(path, HttpMethod.GET, null, null, defaultAccepts, null, returnType);
    }

    /**
     * Gets the dataset metadata for the specifeid dataset id
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param groupId The group id
     * @param datasetKey The dataset id
     * @return Dataset
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public Dataset getDatasetByIdInGroup(String groupId, String datasetKey) throws RestClientException {

        // Verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'groupId' when calling datasetsGetDatasetByIdInGroup");
        }

        // Verify the required parameter 'datasetKey' is set
        if (datasetKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'datasetKey' when calling datasetsGetDatasetByIdInGroup");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("datasetKey", datasetKey);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/groups/{groupId}/datasets/{datasetKey}").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<Dataset> returnType = new ParameterizedTypeReference<Dataset>() {
        };
        return this.invokeAPI(path, HttpMethod.GET, null, null, defaultAccepts, null, returnType);
    }

    /**
     * Returns the datasets
     *
     * <p>
     * <b>200</b> - OK
     *
     * @return ODataResponseListDataset
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public ODataResponseListDataset getDatasets() throws RestClientException {

        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/datasets").build().toUriString();
        ParameterizedTypeReference<ODataResponseListDataset> returnType = new ParameterizedTypeReference<ODataResponseListDataset>() {
        };
        return this.invokeAPI(path, HttpMethod.GET, null, null, defaultAccepts, null, returnType);
    }

    /**
     * Returns the datasets
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param groupId The group id
     * @return ODataResponseListDataset
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public ODataResponseListDataset getDatasetsInGroup(String groupId) throws RestClientException {

        // Verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'groupId' when calling datasetsGetDatasetsInGroup");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("groupId", groupId);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/groups/{groupId}/datasets").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<ODataResponseListDataset> returnType = new ParameterizedTypeReference<ODataResponseListDataset>() {
        };
        return this.invokeAPI(path, HttpMethod.GET, null, null, defaultAccepts, null, returnType);
    }

    /**
     * Gets a list of datasource for the specified dataset
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param datasetKey The datasetKey parameter
     * @return ODataResponseListDatasource
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public ODataResponseListDatasource getDatasources(String datasetKey) throws RestClientException {

        // Verify the required parameter 'datasetKey' is set
        if (datasetKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'datasetKey' when calling datasetsGetDatasources");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("datasetKey", datasetKey);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/datasets/{datasetKey}/datasources").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<ODataResponseListDatasource> returnType = new ParameterizedTypeReference<ODataResponseListDatasource>() {
        };
        return this.invokeAPI(path, HttpMethod.GET, null, null, defaultAccepts, null, returnType);
    }

    /**
     * Gets a list of datasource for the specified dataset as Admin
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param datasetKey The datasetKey parameter
     * @return ODataResponseListDatasource
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public ODataResponseListDatasource getDatasourcesAsAdmin(String datasetKey) throws RestClientException {

        // Verify the required parameter 'datasetKey' is set
        if (datasetKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'datasetKey' when calling datasetsGetDatasourcesAsAdmin");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("datasetKey", datasetKey);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/admin/datasets/{datasetKey}/datasources").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<ODataResponseListDatasource> returnType = new ParameterizedTypeReference<ODataResponseListDatasource>() {
        };
        return this.invokeAPI(path, HttpMethod.GET, null, null, defaultAccepts, null, returnType);
    }

    /**
     * Gets a list of datasource for the specified dataset
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param groupId The group id
     * @param datasetKey The datasetKey parameter
     * @return ODataResponseListDatasource
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public ODataResponseListDatasource getDatasourcesInGroup(String groupId, String datasetKey) throws RestClientException {

        // Verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'groupId' when calling datasetsGetDatasourcesInGroup");
        }

        // Verify the required parameter 'datasetKey' is set
        if (datasetKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'datasetKey' when calling datasetsGetDatasourcesInGroup");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("datasetKey", datasetKey);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/groups/{groupId}/datasets/{datasetKey}/datasources").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<ODataResponseListDatasource> returnType = new ParameterizedTypeReference<ODataResponseListDatasource>() {
        };
        return this.invokeAPI(path, HttpMethod.GET, null, null, defaultAccepts, null, returnType);
    }

    /**
     * Gets a list of bound gateway datasources for the specified dataset
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param datasetKey The dataset id
     * @return ODataResponseListGatewayDatasource
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public ODataResponseListGatewayDatasource getGatewayDatasources(String datasetKey) throws RestClientException {

        // Verify the required parameter 'datasetKey' is set
        if (datasetKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'datasetKey' when calling datasetsGetGatewayDatasources");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("datasetKey", datasetKey);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/datasets/{datasetKey}/Default.GetBoundGatewayDatasources").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<ODataResponseListGatewayDatasource> returnType = new ParameterizedTypeReference<ODataResponseListGatewayDatasource>() {
        };
        return this.invokeAPI(path, HttpMethod.GET, null, null, defaultAccepts, null, returnType);
    }

    /**
     * Gets a list of bound gateway datasources for the specified dataset
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param groupId The group id
     * @param datasetKey The dataset id
     * @return ODataResponseListGatewayDatasource
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public ODataResponseListGatewayDatasource getGatewayDatasourcesInGroup(String groupId, String datasetKey) throws RestClientException {

        // Verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'groupId' when calling datasetsGetGatewayDatasourcesInGroup");
        }

        // Verify the required parameter 'datasetKey' is set
        if (datasetKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'datasetKey' when calling datasetsGetGatewayDatasourcesInGroup");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("datasetKey", datasetKey);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/groups/{groupId}/datasets/{datasetKey}/Default.GetBoundGatewayDatasources").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<ODataResponseListGatewayDatasource> returnType = new ParameterizedTypeReference<ODataResponseListGatewayDatasource>() {
        };
        return this.invokeAPI(path, HttpMethod.GET, null, null, defaultAccepts, null, returnType);
    }

    /**
     * Gets a list of parameters for the specified dataset
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param datasetKey The datasetKey parameter
     * @return ODataResponseListDatasetParameter
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public ODataResponseListDatasetParameter getParameters(String datasetKey) throws RestClientException {

        // Verify the required parameter 'datasetKey' is set
        if (datasetKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'datasetKey' when calling datasetsGetParameters");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("datasetKey", datasetKey);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/datasets/{datasetKey}/parameters").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<ODataResponseListDatasetParameter> returnType = new ParameterizedTypeReference<ODataResponseListDatasetParameter>() {
        };
        return this.invokeAPI(path, HttpMethod.GET, null, null, defaultAccepts, null, returnType);
    }

    /**
     * Gets a list of parameters for the specified dataset
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param groupId The group id
     * @param datasetKey The datasetKey parameter
     * @return ODataResponseListDatasetParameter
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public ODataResponseListDatasetParameter getParametersInGroup(String groupId, String datasetKey) throws RestClientException {

        // Verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'groupId' when calling datasetsGetParametersInGroup");
        }

        // Verify the required parameter 'datasetKey' is set
        if (datasetKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'datasetKey' when calling datasetsGetParametersInGroup");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("datasetKey", datasetKey);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/groups/{groupId}/datasets/{datasetKey}/parameters").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<ODataResponseListDatasetParameter> returnType = new ParameterizedTypeReference<ODataResponseListDatasetParameter>() {
        };
        return this.invokeAPI(path, HttpMethod.GET, null, null, defaultAccepts, null, returnType);
    }

    /**
     * Gets the dataset refresh history
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param datasetKey The dataset id
     * @param top The requested number of entries in the refresh history, if not
     * supported the default is all available entries
     * @return ODataResponseListRefresh
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public ODataResponseListRefresh getRefreshHistory(String datasetKey, Integer top) throws RestClientException {

        // Verify the required parameter 'datasetKey' is set
        if (datasetKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'datasetKey' when calling datasetsGetRefreshHistory");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("datasetKey", datasetKey);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/datasets/{datasetKey}/refreshes").buildAndExpand(uriVariables).toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.putAll(this.parameterToMultiValueMap(null, "$top", top));

        ParameterizedTypeReference<ODataResponseListRefresh> returnType = new ParameterizedTypeReference<ODataResponseListRefresh>() {
        };
        return this.invokeAPI(path, HttpMethod.GET, queryParams, null, defaultAccepts, null, returnType);
    }

    /**
     * Gets the dataset refresh history
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param groupId The group id
     * @param datasetKey The dataset id
     * @param top The requested number of entries in the refresh history, if not
     * supported the default is all available entries
     * @return ODataResponseListRefresh
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public ODataResponseListRefresh getRefreshHistoryInGroup(String groupId, String datasetKey, Integer top) throws RestClientException {

        // Verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'groupId' when calling datasetsGetRefreshHistoryInGroup");
        }

        // Verify the required parameter 'datasetKey' is set
        if (datasetKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'datasetKey' when calling datasetsGetRefreshHistoryInGroup");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("datasetKey", datasetKey);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/groups/{groupId}/datasets/{datasetKey}/refreshes").buildAndExpand(uriVariables).toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.putAll(this.parameterToMultiValueMap(null, "$top", top));

        ParameterizedTypeReference<ODataResponseListRefresh> returnType = new ParameterizedTypeReference<ODataResponseListRefresh>() {
        };
        return this.invokeAPI(path, HttpMethod.GET, queryParams, null, defaultAccepts, null, returnType);
    }

    /**
     * Gets all tables within the specified dataset
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param datasetKey The dataset id
     * @return ODataResponseListTable
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public ODataResponseListTable getTables(String datasetKey) throws RestClientException {

        // Verify the required parameter 'datasetKey' is set
        if (datasetKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'datasetKey' when calling datasetsGetTables");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("datasetKey", datasetKey);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/datasets/{datasetKey}/tables").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<ODataResponseListTable> returnType = new ParameterizedTypeReference<ODataResponseListTable>() {
        };
        return this.invokeAPI(path, HttpMethod.GET, null, null, defaultAccepts, defaultContentTypes, returnType);
    }

    /**
     * Gets all tables within the specified dataset
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param groupId The group id
     * @param datasetKey The dataset id
     * @return ODataResponseListTable
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public ODataResponseListTable getTablesInGroup(String groupId, String datasetKey) throws RestClientException {

        // Verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'groupId' when calling datasetsGetTablesInGroup");
        }

        // Verify the required parameter 'datasetKey' is set
        if (datasetKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'datasetKey' when calling datasetsGetTablesInGroup");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("datasetKey", datasetKey);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/groups/{groupId}/datasets/{datasetKey}/tables").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<ODataResponseListTable> returnType = new ParameterizedTypeReference<ODataResponseListTable>() {
        };
        return this.invokeAPI(path, HttpMethod.GET, null, null, defaultAccepts, null, returnType);
    }

    /**
     * Post a new entity to datasets
     *
     * <p>
     * <b>201</b> - Created
     * <p>
     * <b>202</b> - Accepted
     *
     * @param dataset Create dataset parameters
     * @return Dataset
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public Dataset postDataset(Dataset dataset) throws RestClientException {

        // Verify the required parameter 'dataset' is set
        if (dataset == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'dataset' when calling datasetsPostDataset");
        }

        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/datasets").build().toUriString();
        ParameterizedTypeReference<Dataset> returnType = new ParameterizedTypeReference<Dataset>() {
        };
        return this.invokeAPI(path, HttpMethod.POST, null, dataset, defaultAccepts, defaultContentTypes, returnType);
    }

    /**
     * Post a new entity to datasets
     *
     * <p>
     * <b>201</b> - Created
     * <p>
     * <b>202</b> - Accepted
     *
     * @param groupId The group id
     * @param dataset Create dataset parameters
     * @return Dataset
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public Dataset postDatasetInGroup(String groupId, Dataset dataset) throws RestClientException {

        // Verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'groupId' when calling datasetsPostDatasetInGroup");
        }

        // Verify the required parameter 'dataset' is set
        if (dataset == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'dataset' when calling datasetsPostDatasetInGroup");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("groupId", groupId);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/groups/{groupId}/datasets").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<Dataset> returnType = new ParameterizedTypeReference<Dataset>() {
        };
        return this.invokeAPI(path, HttpMethod.POST, null, dataset, defaultAccepts, defaultContentTypes, returnType);
    }

    /**
     * Posts new data rows into the specified table
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param datasetKey The dataset id
     * @param tableName The table name
     * @param requestMessage The request message
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public Object postRows(String datasetKey, String tableName, Object requestMessage) throws RestClientException {

        // Verify the required parameter 'datasetKey' is set
        if (datasetKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'datasetKey' when calling datasetsPostRows");
        }

        // Verify the required parameter 'tableName' is set
        if (tableName == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'tableName' when calling datasetsPostRows");
        }

        // Verify the required parameter 'requestMessage' is set
        if (requestMessage == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'requestMessage' when calling datasetsPostRows");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("datasetKey", datasetKey);
        uriVariables.put("tableName", tableName);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/datasets/{datasetKey}/tables/{tableName}/rows").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {
        };
        return this.invokeAPI(path, HttpMethod.POST, null, requestMessage, null, null, returnType);
    }

    /**
     * Posts new data rows into the specified table
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param groupId The group id
     * @param datasetKey The dataset id
     * @param tableName The table name
     * @param requestMessage The request message
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public Object postRowsInGroup(String groupId, String datasetKey, String tableName, Object requestMessage) throws RestClientException {

        // Verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'groupId' when calling datasetsPostRowsInGroup");
        }

        // Verify the required parameter 'datasetKey' is set
        if (datasetKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'datasetKey' when calling datasetsPostRowsInGroup");
        }

        // Verify the required parameter 'tableName' is set
        if (tableName == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'tableName' when calling datasetsPostRowsInGroup");
        }

        // Verify the required parameter 'requestMessage' is set
        if (requestMessage == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'requestMessage' when calling datasetsPostRowsInGroup");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("datasetKey", datasetKey);
        uriVariables.put("tableName", tableName);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/groups/{groupId}/datasets/{datasetKey}/tables/{tableName}/rows").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {
        };
        return this.invokeAPI(path, HttpMethod.POST, null, requestMessage, null, null, returnType);
    }

    /**
     * Updates a schema and metadata for the specified table
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param datasetKey The dataset id
     * @param tableName The table name
     * @param requestMessage The request message
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public Object putTable(String datasetKey, String tableName, Object requestMessage) throws RestClientException {

        // Verify the required parameter 'datasetKey' is set
        if (datasetKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'datasetKey' when calling datasetsPutTable");
        }

        // Verify the required parameter 'tableName' is set
        if (tableName == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'tableName' when calling datasetsPutTable");
        }

        // Verify the required parameter 'requestMessage' is set
        if (requestMessage == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'requestMessage' when calling datasetsPutTable");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("datasetKey", datasetKey);
        uriVariables.put("tableName", tableName);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/datasets/{datasetKey}/tables/{tableName}").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {
        };
        return this.invokeAPI(path, HttpMethod.PUT, null, requestMessage, null, null, returnType);
    }

    /**
     * Updates a schema and metadata for the specified table
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param groupId The group id
     * @param datasetKey The dataset id
     * @param tableName The table name
     * @param requestMessage The request message
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public Object putTableInGroup(String groupId, String datasetKey, String tableName, Object requestMessage) throws RestClientException {

        // Verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'groupId' when calling datasetsPutTableInGroup");
        }

        // Verify the required parameter 'datasetKey' is set
        if (datasetKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'datasetKey' when calling datasetsPutTableInGroup");
        }

        // Verify the required parameter 'tableName' is set
        if (tableName == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'tableName' when calling datasetsPutTableInGroup");
        }

        // Verify the required parameter 'requestMessage' is set
        if (requestMessage == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'requestMessage' when calling datasetsPutTableInGroup");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("datasetKey", datasetKey);
        uriVariables.put("tableName", tableName);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/groups/{groupId}/datasets/{datasetKey}/tables/{tableName}").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {
        };
        return this.invokeAPI(path, HttpMethod.PUT, null, requestMessage, null, null, returnType);
    }

    /**
     * Start a dataset refresh
     *
     * <p>
     * <b>202</b> - Accepted
     *
     * @param datasetKey The dataset id
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public Object refreshDataset(String datasetKey) throws RestClientException {

        // Verify the required parameter 'datasetKey' is set
        if (datasetKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'datasetKey' when calling datasetsRefreshDataset");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("datasetKey", datasetKey);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/datasets/{datasetKey}/refreshes").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {
        };
        return this.invokeAPI(path, HttpMethod.POST, null, null, null, null, returnType);
    }

    /**
     * Start a dataset refresh
     *
     * <p>
     * <b>202</b> - Accepted
     *
     * @param groupId The group id
     * @param datasetKey The dataset id
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public Object refreshDatasetInGroup(String groupId, String datasetKey) throws RestClientException {

        // Verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'groupId' when calling datasetsRefreshDatasetInGroup");
        }

        // Verify the required parameter 'datasetKey' is set
        if (datasetKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'datasetKey' when calling datasetsRefreshDatasetInGroup");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("datasetKey", datasetKey);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/groups/{groupId}/datasets/{datasetKey}/refreshes").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {
        };
        return this.invokeAPI(path, HttpMethod.POST, null, null, null, null, returnType);
    }

    /**
     * Sets all connections for the specified dataset
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param datasetKey The dataset id
     * @param parameters The body
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public Object setAllDatasetConnections(String datasetKey, ConnectionDetails parameters) throws RestClientException {

        // Verify the required parameter 'datasetKey' is set
        if (datasetKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'datasetKey' when calling datasetsSetAllDatasetConnections");
        }

        // Verify the required parameter 'parameters' is set
        if (parameters == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'parameters' when calling datasetsSetAllDatasetConnections");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("datasetKey", datasetKey);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/datasets/{datasetKey}/Default.SetAllConnections").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {
        };
        return this.invokeAPI(path, HttpMethod.POST, null, parameters, null, defaultContentTypes, returnType);
    }

    /**
     * Sets all connections for the specified dataset
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param groupId The group id
     * @param datasetKey The dataset id
     * @param parameters The body
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public Object setAllDatasetConnectionsInGroup(String groupId, String datasetKey, ConnectionDetails parameters) throws RestClientException {

        // Verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'groupId' when calling datasetsSetAllDatasetConnectionsInGroup");
        }

        // Verify the required parameter 'datasetKey' is set
        if (datasetKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'datasetKey' when calling datasetsSetAllDatasetConnectionsInGroup");
        }

        // Verify the required parameter 'parameters' is set
        if (parameters == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'parameters' when calling datasetsSetAllDatasetConnectionsInGroup");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("datasetKey", datasetKey);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/groups/{groupId}/datasets/{datasetKey}/Default.SetAllConnections").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {
        };
        return this.invokeAPI(path, HttpMethod.POST, null, parameters, null, defaultContentTypes, returnType);
    }

    /**
     * Take Over a dataset
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param groupId The group id
     * @param datasetKey The dataset id
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public Object takeOverInGroup(String groupId, String datasetKey) throws RestClientException {

        // Verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'groupId' when calling datasetsTakeOverInGroup");
        }

        // Verify the required parameter 'datasetKey' is set
        if (datasetKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'datasetKey' when calling datasetsTakeOverInGroup");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("datasetKey", datasetKey);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/groups/{groupId}/datasets/{datasetKey}/Default.TakeOver").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {
        };
        return this.invokeAPI(path, HttpMethod.POST, null, null, null, null, returnType);
    }

    /**
     * Updates the dataset datasources using the specified datasource selectors
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param datasetKey The datasetKey parameter
     * @param updateDatasourcesRequest The updateDatasourcesRequest parameter
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public Object updateDatasources(String datasetKey, UpdateDatasourcesRequest updateDatasourcesRequest) throws RestClientException {

        // Verify the required parameter 'datasetKey' is set
        if (datasetKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'datasetKey' when calling datasetsUpdateDatasources");
        }

        // Verify the required parameter 'updateDatasourcesRequest' is set
        if (updateDatasourcesRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'updateDatasourcesRequest' when calling datasetsUpdateDatasources");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("datasetKey", datasetKey);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/datasets/{datasetKey}/Default.UpdateDatasources").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {
        };
        return this.invokeAPI(path, HttpMethod.POST, null, updateDatasourcesRequest, null, defaultContentTypes, returnType);
    }

    /**
     * Updates the dataset datasources using the specified datasource selectors
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param groupId The group id
     * @param datasetKey The datasetKey parameter
     * @param updateDatasourcesRequest The updateDatasourcesRequest parameter
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public Object updateDatasourcesInGroup(String groupId, String datasetKey, UpdateDatasourcesRequest updateDatasourcesRequest) throws RestClientException {

        // Verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'groupId' when calling datasetsUpdateDatasourcesInGroup");
        }

        // Verify the required parameter 'datasetKey' is set
        if (datasetKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'datasetKey' when calling datasetsUpdateDatasourcesInGroup");
        }

        // Verify the required parameter 'updateDatasourcesRequest' is set
        if (updateDatasourcesRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'updateDatasourcesRequest' when calling datasetsUpdateDatasourcesInGroup");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("datasetKey", datasetKey);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/groups/{groupId}/datasets/{datasetKey}/Default.UpdateDatasources").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {
        };
        return this.invokeAPI(path, HttpMethod.POST, null, updateDatasourcesRequest, null, defaultContentTypes, returnType);
    }

    /**
     * Updates the dataset parameters
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param datasetKey The datasetKey parameter
     * @param updateDatasetParametersRequest The updateDatasetParametersRequest
     * parameter
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public Object updateParameters(String datasetKey, UpdateDatasetParametersRequest updateDatasetParametersRequest) throws RestClientException {

        // Verify the required parameter 'datasetKey' is set
        if (datasetKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'datasetKey' when calling datasetsUpdateParameters");
        }

        // Verify the required parameter 'updateDatasetParametersRequest' is set
        if (updateDatasetParametersRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'updateDatasetParametersRequest' when calling datasetsUpdateParameters");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("datasetKey", datasetKey);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/datasets/{datasetKey}/Default.UpdateParameters").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {
        };
        return this.invokeAPI(path, HttpMethod.POST, null, updateDatasetParametersRequest, null, defaultContentTypes, returnType);
    }

    /**
     * Updates the dataset parameters
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param groupId The group id
     * @param datasetKey The datasetKey parameter
     * @param updateDatasetParametersRequest The updateDatasetParametersRequest
     * parameter
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public Object updateParametersInGroup(String groupId, String datasetKey, UpdateDatasetParametersRequest updateDatasetParametersRequest) throws RestClientException {

        // Verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'groupId' when calling datasetsUpdateParametersInGroup");
        }

        // Verify the required parameter 'datasetKey' is set
        if (datasetKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'datasetKey' when calling datasetsUpdateParametersInGroup");
        }

        // Verify the required parameter 'updateDatasetParametersRequest' is set
        if (updateDatasetParametersRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'updateDatasetParametersRequest' when calling datasetsUpdateParametersInGroup");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("datasetKey", datasetKey);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/groups/{groupId}/datasets/{datasetKey}/Default.UpdateParameters").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {
        };
        return this.invokeAPI(path, HttpMethod.POST, null, updateDatasetParametersRequest, null, defaultContentTypes, returnType);
    }
}
