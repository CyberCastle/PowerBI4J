package cl.cc.powerbi.api;


import cl.cc.powerbi.api.model.GatewayDatasource;
import cl.cc.powerbi.api.model.ODataResponseListGatewayDatasource;
import cl.cc.powerbi.api.model.ODataResponseListUserAccessRight;
import cl.cc.powerbi.api.model.PublishDatasourceToGatewayRequest;
import cl.cc.powerbi.api.model.UpdateDatasourceRequest;
import cl.cc.powerbi.api.model.UserAccessRight;
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
public class DatasourcesApi extends BaseApiAbstract {

    public DatasourcesApi(String accessToken) {
        super(accessToken);
    }

    /**
     * Get a datasource user
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param gatewayId The gateway id
     * @param datasourceId The datasource id
     * @param addUserToDatasourceRequest The add user to datasource request
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public Object addDatasourceUser(String gatewayId, String datasourceId, UserAccessRight addUserToDatasourceRequest) throws RestClientException {

        // Verify the required parameter 'gatewayId' is set
        if (gatewayId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'gatewayId' when calling gatewaysAddDatasourceUser");
        }

        // Verify the required parameter 'datasourceId' is set
        if (datasourceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'datasourceId' when calling gatewaysAddDatasourceUser");
        }

        // Verify the required parameter 'addUserToDatasourceRequest' is set
        if (addUserToDatasourceRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'addUserToDatasourceRequest' when calling gatewaysAddDatasourceUser");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("gatewayId", gatewayId);
        uriVariables.put("datasourceId", datasourceId);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/gateways/{gatewayId}/datasources/{datasourceId}/users").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {
        };
        return this.invokeAPI(path, HttpMethod.POST, null, addUserToDatasourceRequest, null, defaultContentTypes, returnType);
    }

    /**
     * Create a datasource
     *
     * <p>
     * <b>201</b> - Created
     *
     * @param gatewayId The gateway id
     * @param datasourceToGatewayRequest The datasource requested to create
     * @return GatewayDatasource
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public GatewayDatasource createDatasource(String gatewayId, PublishDatasourceToGatewayRequest datasourceToGatewayRequest) throws RestClientException {

        // Verify the required parameter 'gatewayId' is set
        if (gatewayId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'gatewayId' when calling gatewaysCreateDatasource");
        }

        // Verify the required parameter 'datasourceToGatewayRequest' is set
        if (datasourceToGatewayRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'datasourceToGatewayRequest' when calling gatewaysCreateDatasource");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("gatewayId", gatewayId);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/gateways/{gatewayId}/datasources").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<GatewayDatasource> returnType = new ParameterizedTypeReference<GatewayDatasource>() {
        };
        return this.invokeAPI(path, HttpMethod.POST, null, datasourceToGatewayRequest, defaultAccepts, defaultContentTypes, returnType);
    }

    /**
     * Delete a datasource
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param gatewayId The gateway id
     * @param datasourceId The datasource id
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public Object deleteDatasource(String gatewayId, String datasourceId) throws RestClientException {

        // Verify the required parameter 'gatewayId' is set
        if (gatewayId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'gatewayId' when calling gatewaysDeleteDatasource");
        }

        // Verify the required parameter 'datasourceId' is set
        if (datasourceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'datasourceId' when calling gatewaysDeleteDatasource");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("gatewayId", gatewayId);
        uriVariables.put("datasourceId", datasourceId);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/gateways/{gatewayId}/datasources/{datasourceId}").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {
        };
        return this.invokeAPI(path, HttpMethod.DELETE, null, null, null, null, returnType);
    }

    /**
     * Delete a datasource user
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param gatewayId The gateway id
     * @param datasourceId The datasource id
     * @param emailAdress The user&#39;s email address
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public Object deleteDatasourceUser(String gatewayId, String datasourceId, String emailAdress) throws RestClientException {

        // Verify the required parameter 'gatewayId' is set
        if (gatewayId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'gatewayId' when calling gatewaysDeleteDatasourceUser");
        }

        // Verify the required parameter 'datasourceId' is set
        if (datasourceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'datasourceId' when calling gatewaysDeleteDatasourceUser");
        }

        // Verify the required parameter 'emailAdress' is set
        if (emailAdress == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'emailAdress' when calling gatewaysDeleteDatasourceUser");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("gatewayId", gatewayId);
        uriVariables.put("datasourceId", datasourceId);
        uriVariables.put("emailAdress", emailAdress);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/gateways/{gatewayId}/datasources/{datasourceId}/users/{emailAdress}").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {
        };
        return this.invokeAPI(path, HttpMethod.DELETE, null, null, null, defaultContentTypes, returnType);
    }

    /**
     * Get a datasource by id
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param gatewayId The gateway id
     * @param datasourceId The datasource id
     * @return GatewayDatasource
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public GatewayDatasource getDatasourceById(String gatewayId, String datasourceId) throws RestClientException {

        // Verify the required parameter 'gatewayId' is set
        if (gatewayId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'gatewayId' when calling gatewaysGetDatasourceById");
        }

        // Verify the required parameter 'datasourceId' is set
        if (datasourceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'datasourceId' when calling gatewaysGetDatasourceById");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("gatewayId", gatewayId);
        uriVariables.put("datasourceId", datasourceId);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/gateways/{gatewayId}/datasources/{datasourceId}").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<GatewayDatasource> returnType = new ParameterizedTypeReference<GatewayDatasource>() {
        };
        return this.invokeAPI(path, HttpMethod.GET, null, null, defaultAccepts, null, returnType);
    }

    /**
     * Get a datasource status by id
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param gatewayId The gateway id
     * @param datasourceId The datasource id
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public Object getDatasourceStatusById(String gatewayId, String datasourceId) throws RestClientException {

        // Verify the required parameter 'gatewayId' is set
        if (gatewayId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'gatewayId' when calling gatewaysGetDatasourceStatusById");
        }

        // Verify the required parameter 'datasourceId' is set
        if (datasourceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'datasourceId' when calling gatewaysGetDatasourceStatusById");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("gatewayId", gatewayId);
        uriVariables.put("datasourceId", datasourceId);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/gateways/{gatewayId}/datasources/{datasourceId}/status").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {
        };
        return this.invokeAPI(path, HttpMethod.GET, null, null, defaultAccepts, null, returnType);
    }

    /**
     * Get a datasource users list
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param gatewayId The gateway id
     * @param datasourceId The datasource id
     * @return ODataResponseListUserAccessRight
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public ODataResponseListUserAccessRight getDatasourceUsers(String gatewayId, String datasourceId) throws RestClientException {

        // Verify the required parameter 'gatewayId' is set
        if (gatewayId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'gatewayId' when calling gatewaysGetDatasourceUsers");
        }

        // Verify the required parameter 'datasourceId' is set
        if (datasourceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'datasourceId' when calling gatewaysGetDatasourceUsers");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("gatewayId", gatewayId);
        uriVariables.put("datasourceId", datasourceId);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/gateways/{gatewayId}/datasources/{datasourceId}/users").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<ODataResponseListUserAccessRight> returnType = new ParameterizedTypeReference<ODataResponseListUserAccessRight>() {
        };
        return this.invokeAPI(path, HttpMethod.GET, null, null, defaultAccepts, null, returnType);
    }

    /**
     * Get all datasources of specific gateway
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param gatewayId The gateway id
     * @return ODataResponseListGatewayDatasource
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public ODataResponseListGatewayDatasource getDatasources(String gatewayId) throws RestClientException {

        // Verify the required parameter 'gatewayId' is set
        if (gatewayId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'gatewayId' when calling gatewaysGetDatasources");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("gatewayId", gatewayId);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/gateways/{gatewayId}/datasources").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<ODataResponseListGatewayDatasource> returnType = new ParameterizedTypeReference<ODataResponseListGatewayDatasource>() {
        };
        return this.invokeAPI(path, HttpMethod.GET, null, null, defaultAccepts, null, returnType);
    }

    /**
     * Update a datasource credentials
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param gatewayId The gateway id
     * @param datasourceId The datasource id
     * @param updateDatasourceRequest The update datasource request
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public Object updateDatasource(String gatewayId, String datasourceId, UpdateDatasourceRequest updateDatasourceRequest) throws RestClientException {

        // Verify the required parameter 'gatewayId' is set
        if (gatewayId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'gatewayId' when calling gatewaysUpdateDatasource");
        }

        // Verify the required parameter 'datasourceId' is set
        if (datasourceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'datasourceId' when calling gatewaysUpdateDatasource");
        }

        // Verify the required parameter 'updateDatasourceRequest' is set
        if (updateDatasourceRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'updateDatasourceRequest' when calling gatewaysUpdateDatasource");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("gatewayId", gatewayId);
        uriVariables.put("datasourceId", datasourceId);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/gateways/{gatewayId}/datasources/{datasourceId}").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {
        };
        return this.invokeAPI(path, HttpMethod.PATCH, null, updateDatasourceRequest, null, null, returnType);
    }
}
