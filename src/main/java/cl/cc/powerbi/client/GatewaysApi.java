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
import cl.cc.powerbi.client.model.DatasourceUser;
import cl.cc.powerbi.client.model.DatasourceUsers;
import cl.cc.powerbi.client.model.Gateway;
import cl.cc.powerbi.client.model.GatewayDatasource;
import cl.cc.powerbi.client.model.GatewayDatasources;
import cl.cc.powerbi.client.model.Gateways;
import cl.cc.powerbi.client.model.PublishDatasourceToGatewayRequest;
import cl.cc.powerbi.client.model.UpdateDatasourceRequest;

@Component("cl.cc.powerbi.client.GatewaysApi")
public class GatewaysApi {
    private ApiClient apiClient;

    public GatewaysApi() {
        this(new ApiClient());
    }

    @Autowired
    public GatewaysApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Grants or updates the permissions required to use the specified datasource
     * for the specified user. &lt;br/&gt;**Required scope**: Dataset.ReadWrite.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param gatewayId                  The gateway id (required)
     * @param datasourceId               The datasource id (required)
     * @param addUserToDatasourceRequest The add user to datasource request
     *                                   (required)
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public void gatewaysAddDatasourceUser(UUID gatewayId, UUID datasourceId, DatasourceUser addUserToDatasourceRequest)
            throws RestClientException {
        gatewaysAddDatasourceUserWithHttpInfo(gatewayId, datasourceId, addUserToDatasourceRequest);
    }

    /**
     * Grants or updates the permissions required to use the specified datasource
     * for the specified user. &lt;br/&gt;**Required scope**: Dataset.ReadWrite.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param gatewayId                  The gateway id (required)
     * @param datasourceId               The datasource id (required)
     * @param addUserToDatasourceRequest The add user to datasource request
     *                                   (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Void> gatewaysAddDatasourceUserWithHttpInfo(UUID gatewayId, UUID datasourceId,
            DatasourceUser addUserToDatasourceRequest) throws RestClientException {
        Object postBody = addUserToDatasourceRequest;

        // verify the required parameter 'gatewayId' is set
        if (gatewayId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'gatewayId' when calling gatewaysAddDatasourceUser");
        }

        // verify the required parameter 'datasourceId' is set
        if (datasourceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'datasourceId' when calling gatewaysAddDatasourceUser");
        }

        // verify the required parameter 'addUserToDatasourceRequest' is set
        if (addUserToDatasourceRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'addUserToDatasourceRequest' when calling gatewaysAddDatasourceUser");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("gatewayId", gatewayId);
        uriVariables.put("datasourceId", datasourceId);
        String path = apiClient.expandPath("/v1.0/myorg/gateways/{gatewayId}/datasources/{datasourceId}/users",
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
     * Creates a new datasource on the specified gateway. &lt;br/&gt;**Required
     * scope**: Dataset.ReadWrite.All&lt;li&gt;To set the permissions scope, see
     * [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app)&lt;/li&gt;&lt;li&gt;To
     * encrypt credentials, see [Encrypt
     * credentials](https://docs.microsoft.com/power-bi/developer/encrypt-credentials)&lt;/li&gt;
     * <p>
     * <b>201</b> - Created
     * 
     * @param gatewayId                  The gateway id (required)
     * @param datasourceToGatewayRequest The datasource requested to create
     *                                   (required)
     * @return GatewayDatasource
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public GatewayDatasource gatewaysCreateDatasource(UUID gatewayId,
            PublishDatasourceToGatewayRequest datasourceToGatewayRequest) throws RestClientException {
        return gatewaysCreateDatasourceWithHttpInfo(gatewayId, datasourceToGatewayRequest).getBody();
    }

    /**
     * Creates a new datasource on the specified gateway. &lt;br/&gt;**Required
     * scope**: Dataset.ReadWrite.All&lt;li&gt;To set the permissions scope, see
     * [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app)&lt;/li&gt;&lt;li&gt;To
     * encrypt credentials, see [Encrypt
     * credentials](https://docs.microsoft.com/power-bi/developer/encrypt-credentials)&lt;/li&gt;
     * <p>
     * <b>201</b> - Created
     * 
     * @param gatewayId                  The gateway id (required)
     * @param datasourceToGatewayRequest The datasource requested to create
     *                                   (required)
     * @return ResponseEntity&lt;GatewayDatasource&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<GatewayDatasource> gatewaysCreateDatasourceWithHttpInfo(UUID gatewayId,
            PublishDatasourceToGatewayRequest datasourceToGatewayRequest) throws RestClientException {
        Object postBody = datasourceToGatewayRequest;

        // verify the required parameter 'gatewayId' is set
        if (gatewayId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'gatewayId' when calling gatewaysCreateDatasource");
        }

        // verify the required parameter 'datasourceToGatewayRequest' is set
        if (datasourceToGatewayRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'datasourceToGatewayRequest' when calling gatewaysCreateDatasource");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("gatewayId", gatewayId);
        String path = apiClient.expandPath("/v1.0/myorg/gateways/{gatewayId}/datasources", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { "application/json" };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<GatewayDatasource> returnType = new ParameterizedTypeReference<GatewayDatasource>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Deletes the specified datasource from the specified gateway.
     * &lt;br/&gt;**Required scope**: Dataset.ReadWrite.All &lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param gatewayId    The gateway id (required)
     * @param datasourceId The datasource id (required)
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public void gatewaysDeleteDatasource(UUID gatewayId, UUID datasourceId) throws RestClientException {
        gatewaysDeleteDatasourceWithHttpInfo(gatewayId, datasourceId);
    }

    /**
     * Deletes the specified datasource from the specified gateway.
     * &lt;br/&gt;**Required scope**: Dataset.ReadWrite.All &lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param gatewayId    The gateway id (required)
     * @param datasourceId The datasource id (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Void> gatewaysDeleteDatasourceWithHttpInfo(UUID gatewayId, UUID datasourceId)
            throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'gatewayId' is set
        if (gatewayId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'gatewayId' when calling gatewaysDeleteDatasource");
        }

        // verify the required parameter 'datasourceId' is set
        if (datasourceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'datasourceId' when calling gatewaysDeleteDatasource");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("gatewayId", gatewayId);
        uriVariables.put("datasourceId", datasourceId);
        String path = apiClient.expandPath("/v1.0/myorg/gateways/{gatewayId}/datasources/{datasourceId}", uriVariables);

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
     * Removes the specified user from the specified datasource.
     * &lt;br/&gt;**Required scope**: Dataset.ReadWrite.All &lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param gatewayId    The gateway id (required)
     * @param datasourceId The datasource id (required)
     * @param emailAdress  The user&#39;s email address or the service principal
     *                     object id (required)
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public void gatewaysDeleteDatasourceUser(UUID gatewayId, UUID datasourceId, String emailAdress)
            throws RestClientException {
        gatewaysDeleteDatasourceUserWithHttpInfo(gatewayId, datasourceId, emailAdress);
    }

    /**
     * Removes the specified user from the specified datasource.
     * &lt;br/&gt;**Required scope**: Dataset.ReadWrite.All &lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param gatewayId    The gateway id (required)
     * @param datasourceId The datasource id (required)
     * @param emailAdress  The user&#39;s email address or the service principal
     *                     object id (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Void> gatewaysDeleteDatasourceUserWithHttpInfo(UUID gatewayId, UUID datasourceId,
            String emailAdress) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'gatewayId' is set
        if (gatewayId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'gatewayId' when calling gatewaysDeleteDatasourceUser");
        }

        // verify the required parameter 'datasourceId' is set
        if (datasourceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'datasourceId' when calling gatewaysDeleteDatasourceUser");
        }

        // verify the required parameter 'emailAdress' is set
        if (emailAdress == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'emailAdress' when calling gatewaysDeleteDatasourceUser");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("gatewayId", gatewayId);
        uriVariables.put("datasourceId", datasourceId);
        uriVariables.put("emailAdress", emailAdress);
        String path = apiClient.expandPath(
                "/v1.0/myorg/gateways/{gatewayId}/datasources/{datasourceId}/users/{emailAdress}", uriVariables);

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
     * Returns the specified datasource from the specified gateway.
     * &lt;br/&gt;**Required scope**: Dataset.ReadWrite.All or Dataset.Read.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param gatewayId    The gateway id (required)
     * @param datasourceId The datasource id (required)
     * @return GatewayDatasource
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public GatewayDatasource gatewaysGetDatasource(UUID gatewayId, UUID datasourceId) throws RestClientException {
        return gatewaysGetDatasourceWithHttpInfo(gatewayId, datasourceId).getBody();
    }

    /**
     * Returns the specified datasource from the specified gateway.
     * &lt;br/&gt;**Required scope**: Dataset.ReadWrite.All or Dataset.Read.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param gatewayId    The gateway id (required)
     * @param datasourceId The datasource id (required)
     * @return ResponseEntity&lt;GatewayDatasource&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<GatewayDatasource> gatewaysGetDatasourceWithHttpInfo(UUID gatewayId, UUID datasourceId)
            throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'gatewayId' is set
        if (gatewayId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'gatewayId' when calling gatewaysGetDatasource");
        }

        // verify the required parameter 'datasourceId' is set
        if (datasourceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'datasourceId' when calling gatewaysGetDatasource");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("gatewayId", gatewayId);
        uriVariables.put("datasourceId", datasourceId);
        String path = apiClient.expandPath("/v1.0/myorg/gateways/{gatewayId}/datasources/{datasourceId}", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<GatewayDatasource> returnType = new ParameterizedTypeReference<GatewayDatasource>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Checks the connectivity status of the specified datasource from the specified
     * gateway. &lt;br/&gt;**Required scope**: Dataset.ReadWrite.All &lt;br/&gt;To
     * set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param gatewayId    The gateway id (required)
     * @param datasourceId The datasource id (required)
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public void gatewaysGetDatasourceStatus(UUID gatewayId, UUID datasourceId) throws RestClientException {
        gatewaysGetDatasourceStatusWithHttpInfo(gatewayId, datasourceId);
    }

    /**
     * Checks the connectivity status of the specified datasource from the specified
     * gateway. &lt;br/&gt;**Required scope**: Dataset.ReadWrite.All &lt;br/&gt;To
     * set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param gatewayId    The gateway id (required)
     * @param datasourceId The datasource id (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Void> gatewaysGetDatasourceStatusWithHttpInfo(UUID gatewayId, UUID datasourceId)
            throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'gatewayId' is set
        if (gatewayId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'gatewayId' when calling gatewaysGetDatasourceStatus");
        }

        // verify the required parameter 'datasourceId' is set
        if (datasourceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'datasourceId' when calling gatewaysGetDatasourceStatus");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("gatewayId", gatewayId);
        uriVariables.put("datasourceId", datasourceId);
        String path = apiClient.expandPath("/v1.0/myorg/gateways/{gatewayId}/datasources/{datasourceId}/status",
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
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Returns a list of users who have access to the specified datasource.
     * &lt;br/&gt;**Required scope**: Dataset.ReadWrite.All or
     * Dataset.Read.All&lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param gatewayId    The gateway id (required)
     * @param datasourceId The datasource id (required)
     * @return DatasourceUsers
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public DatasourceUsers gatewaysGetDatasourceUsers(UUID gatewayId, UUID datasourceId) throws RestClientException {
        return gatewaysGetDatasourceUsersWithHttpInfo(gatewayId, datasourceId).getBody();
    }

    /**
     * Returns a list of users who have access to the specified datasource.
     * &lt;br/&gt;**Required scope**: Dataset.ReadWrite.All or
     * Dataset.Read.All&lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param gatewayId    The gateway id (required)
     * @param datasourceId The datasource id (required)
     * @return ResponseEntity&lt;DatasourceUsers&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<DatasourceUsers> gatewaysGetDatasourceUsersWithHttpInfo(UUID gatewayId, UUID datasourceId)
            throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'gatewayId' is set
        if (gatewayId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'gatewayId' when calling gatewaysGetDatasourceUsers");
        }

        // verify the required parameter 'datasourceId' is set
        if (datasourceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'datasourceId' when calling gatewaysGetDatasourceUsers");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("gatewayId", gatewayId);
        uriVariables.put("datasourceId", datasourceId);
        String path = apiClient.expandPath("/v1.0/myorg/gateways/{gatewayId}/datasources/{datasourceId}/users",
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

        ParameterizedTypeReference<DatasourceUsers> returnType = new ParameterizedTypeReference<DatasourceUsers>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Returns a list of datasources from the specified gateway.
     * &lt;br/&gt;**Required scope**: Dataset.ReadWrite.All or Dataset.Read.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param gatewayId The gateway id (required)
     * @return GatewayDatasources
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public GatewayDatasources gatewaysGetDatasources(UUID gatewayId) throws RestClientException {
        return gatewaysGetDatasourcesWithHttpInfo(gatewayId).getBody();
    }

    /**
     * Returns a list of datasources from the specified gateway.
     * &lt;br/&gt;**Required scope**: Dataset.ReadWrite.All or Dataset.Read.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param gatewayId The gateway id (required)
     * @return ResponseEntity&lt;GatewayDatasources&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<GatewayDatasources> gatewaysGetDatasourcesWithHttpInfo(UUID gatewayId)
            throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'gatewayId' is set
        if (gatewayId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'gatewayId' when calling gatewaysGetDatasources");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("gatewayId", gatewayId);
        String path = apiClient.expandPath("/v1.0/myorg/gateways/{gatewayId}/datasources", uriVariables);

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
     * Returns the specified gateway. &lt;br/&gt;**Required scope**:
     * Dataset.ReadWrite.All or Dataset.Read.All &lt;br/&gt;To set the permissions
     * scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param gatewayId The gateway id (required)
     * @return Gateway
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Gateway gatewaysGetGateway(UUID gatewayId) throws RestClientException {
        return gatewaysGetGatewayWithHttpInfo(gatewayId).getBody();
    }

    /**
     * Returns the specified gateway. &lt;br/&gt;**Required scope**:
     * Dataset.ReadWrite.All or Dataset.Read.All &lt;br/&gt;To set the permissions
     * scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param gatewayId The gateway id (required)
     * @return ResponseEntity&lt;Gateway&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Gateway> gatewaysGetGatewayWithHttpInfo(UUID gatewayId) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'gatewayId' is set
        if (gatewayId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'gatewayId' when calling gatewaysGetGateway");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("gatewayId", gatewayId);
        String path = apiClient.expandPath("/v1.0/myorg/gateways/{gatewayId}", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Gateway> returnType = new ParameterizedTypeReference<Gateway>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Returns a list of gateways for which the user is an admin.
     * &lt;br/&gt;**Required scope**: Dataset.ReadWrite.All or Dataset.Read.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @return Gateways
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Gateways gatewaysGetGateways() throws RestClientException {
        return gatewaysGetGatewaysWithHttpInfo().getBody();
    }

    /**
     * Returns a list of gateways for which the user is an admin.
     * &lt;br/&gt;**Required scope**: Dataset.ReadWrite.All or Dataset.Read.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @return ResponseEntity&lt;Gateways&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Gateways> gatewaysGetGatewaysWithHttpInfo() throws RestClientException {
        Object postBody = null;

        String path = apiClient.expandPath("/v1.0/myorg/gateways", Collections.<String, Object>emptyMap());

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
     * Updates the credentials of the specified datasource from the specified
     * gateway. &lt;br/&gt;**Required scope**: Dataset.ReadWrite.All&lt;li&gt;To set
     * the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app)&lt;/li&gt;&lt;li&gt;To
     * encrypt credentials, see [Encrypt
     * credentials](https://docs.microsoft.com/power-bi/developer/encrypt-credentials)&lt;/li&gt;
     * <p>
     * <b>200</b> - OK
     * 
     * @param gatewayId               The gateway id (required)
     * @param datasourceId            The datasource id (required)
     * @param updateDatasourceRequest The update datasource request (required)
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public void gatewaysUpdateDatasource(UUID gatewayId, UUID datasourceId,
            UpdateDatasourceRequest updateDatasourceRequest) throws RestClientException {
        gatewaysUpdateDatasourceWithHttpInfo(gatewayId, datasourceId, updateDatasourceRequest);
    }

    /**
     * Updates the credentials of the specified datasource from the specified
     * gateway. &lt;br/&gt;**Required scope**: Dataset.ReadWrite.All&lt;li&gt;To set
     * the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app)&lt;/li&gt;&lt;li&gt;To
     * encrypt credentials, see [Encrypt
     * credentials](https://docs.microsoft.com/power-bi/developer/encrypt-credentials)&lt;/li&gt;
     * <p>
     * <b>200</b> - OK
     * 
     * @param gatewayId               The gateway id (required)
     * @param datasourceId            The datasource id (required)
     * @param updateDatasourceRequest The update datasource request (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Void> gatewaysUpdateDatasourceWithHttpInfo(UUID gatewayId, UUID datasourceId,
            UpdateDatasourceRequest updateDatasourceRequest) throws RestClientException {
        Object postBody = updateDatasourceRequest;

        // verify the required parameter 'gatewayId' is set
        if (gatewayId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'gatewayId' when calling gatewaysUpdateDatasource");
        }

        // verify the required parameter 'datasourceId' is set
        if (datasourceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'datasourceId' when calling gatewaysUpdateDatasource");
        }

        // verify the required parameter 'updateDatasourceRequest' is set
        if (updateDatasourceRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'updateDatasourceRequest' when calling gatewaysUpdateDatasource");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("gatewayId", gatewayId);
        uriVariables.put("datasourceId", datasourceId);
        String path = apiClient.expandPath("/v1.0/myorg/gateways/{gatewayId}/datasources/{datasourceId}", uriVariables);

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
        return apiClient.invokeAPI(path, HttpMethod.PATCH, queryParams, postBody, headerParams, cookieParams,
                formParams, accept, contentType, authNames, returnType);
    }
}
