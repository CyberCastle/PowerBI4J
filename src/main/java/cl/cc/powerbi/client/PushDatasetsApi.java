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
import cl.cc.powerbi.client.model.CreateDatasetRequest;
import cl.cc.powerbi.client.model.Dataset;
import cl.cc.powerbi.client.model.PostRowsRequest;
import cl.cc.powerbi.client.model.Table;
import cl.cc.powerbi.client.model.Tables;

@Component("cl.cc.powerbi.client.PushDatasetsApi")
public class PushDatasetsApi {
    private ApiClient apiClient;

    public PushDatasetsApi() {
        this(new ApiClient());
    }

    @Autowired
    public PushDatasetsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Deletes all rows from the specified table within the specified dataset from
     * **\&quot;My Workspace\&quot;**. &lt;br/&gt;**Note**: this API supports only
     * Push datasets. &lt;br/&gt;&lt;br/&gt;**Required scope**:
     * Dataset.ReadWrite.All &lt;br/&gt;To set the permissions scope, see [Register
     * an app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param datasetId The dataset id (required)
     * @param tableName The table name (required)
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public void datasetsDeleteRows(String datasetId, String tableName) throws RestClientException {
        datasetsDeleteRowsWithHttpInfo(datasetId, tableName);
    }

    /**
     * Deletes all rows from the specified table within the specified dataset from
     * **\&quot;My Workspace\&quot;**. &lt;br/&gt;**Note**: this API supports only
     * Push datasets. &lt;br/&gt;&lt;br/&gt;**Required scope**:
     * Dataset.ReadWrite.All &lt;br/&gt;To set the permissions scope, see [Register
     * an app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param datasetId The dataset id (required)
     * @param tableName The table name (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Void> datasetsDeleteRowsWithHttpInfo(String datasetId, String tableName)
            throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'datasetId' is set
        if (datasetId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'datasetId' when calling datasetsDeleteRows");
        }

        // verify the required parameter 'tableName' is set
        if (tableName == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'tableName' when calling datasetsDeleteRows");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("datasetId", datasetId);
        uriVariables.put("tableName", tableName);
        String path = apiClient.expandPath("/v1.0/myorg/datasets/{datasetId}/tables/{tableName}/rows", uriVariables);

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
     * Deletes all rows from the specified table, within the specified dataset, from
     * the specified workspace. &lt;br/&gt;**Note**: This API supports only Push
     * datasets. &lt;br/&gt;&lt;br/&gt;**Required scope**: Dataset.ReadWrite.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId   The workspace id (required)
     * @param datasetId The dataset id (required)
     * @param tableName The table name (required)
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public void datasetsDeleteRowsInGroup(UUID groupId, String datasetId, String tableName) throws RestClientException {
        datasetsDeleteRowsInGroupWithHttpInfo(groupId, datasetId, tableName);
    }

    /**
     * Deletes all rows from the specified table, within the specified dataset, from
     * the specified workspace. &lt;br/&gt;**Note**: This API supports only Push
     * datasets. &lt;br/&gt;&lt;br/&gt;**Required scope**: Dataset.ReadWrite.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId   The workspace id (required)
     * @param datasetId The dataset id (required)
     * @param tableName The table name (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Void> datasetsDeleteRowsInGroupWithHttpInfo(UUID groupId, String datasetId, String tableName)
            throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling datasetsDeleteRowsInGroup");
        }

        // verify the required parameter 'datasetId' is set
        if (datasetId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'datasetId' when calling datasetsDeleteRowsInGroup");
        }

        // verify the required parameter 'tableName' is set
        if (tableName == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'tableName' when calling datasetsDeleteRowsInGroup");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("datasetId", datasetId);
        uriVariables.put("tableName", tableName);
        String path = apiClient.expandPath("/v1.0/myorg/groups/{groupId}/datasets/{datasetId}/tables/{tableName}/rows",
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
        return apiClient.invokeAPI(path, HttpMethod.DELETE, queryParams, postBody, headerParams, cookieParams,
                formParams, accept, contentType, authNames, returnType);
    }

    /**
     * Returns a list of tables tables within the specified dataset from **\&quot;My
     * Workspace\&quot;**. &lt;br/&gt;**Note**: This API supports only Push
     * datasets. &lt;br/&gt;&lt;br/&gt;**Required scope**: Dataset.ReadWrite.All or
     * Dataset.Read.All &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param datasetId The dataset id (required)
     * @return Tables
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Tables datasetsGetTables(String datasetId) throws RestClientException {
        return datasetsGetTablesWithHttpInfo(datasetId).getBody();
    }

    /**
     * Returns a list of tables tables within the specified dataset from **\&quot;My
     * Workspace\&quot;**. &lt;br/&gt;**Note**: This API supports only Push
     * datasets. &lt;br/&gt;&lt;br/&gt;**Required scope**: Dataset.ReadWrite.All or
     * Dataset.Read.All &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param datasetId The dataset id (required)
     * @return ResponseEntity&lt;Tables&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Tables> datasetsGetTablesWithHttpInfo(String datasetId) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'datasetId' is set
        if (datasetId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'datasetId' when calling datasetsGetTables");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("datasetId", datasetId);
        String path = apiClient.expandPath("/v1.0/myorg/datasets/{datasetId}/tables", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Tables> returnType = new ParameterizedTypeReference<Tables>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Returns a list of tables within the specified dataset from the specified
     * workspace. &lt;br/&gt;**Note**: This API supports only Push datasets.
     * &lt;br/&gt;&lt;br/&gt;**Required scope**: Dataset.ReadWrite.All or
     * Dataset.Read.All &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId   The workspace id (required)
     * @param datasetId The dataset id (required)
     * @return Tables
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Tables datasetsGetTablesInGroup(UUID groupId, String datasetId) throws RestClientException {
        return datasetsGetTablesInGroupWithHttpInfo(groupId, datasetId).getBody();
    }

    /**
     * Returns a list of tables within the specified dataset from the specified
     * workspace. &lt;br/&gt;**Note**: This API supports only Push datasets.
     * &lt;br/&gt;&lt;br/&gt;**Required scope**: Dataset.ReadWrite.All or
     * Dataset.Read.All &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId   The workspace id (required)
     * @param datasetId The dataset id (required)
     * @return ResponseEntity&lt;Tables&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Tables> datasetsGetTablesInGroupWithHttpInfo(UUID groupId, String datasetId)
            throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling datasetsGetTablesInGroup");
        }

        // verify the required parameter 'datasetId' is set
        if (datasetId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'datasetId' when calling datasetsGetTablesInGroup");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("datasetId", datasetId);
        String path = apiClient.expandPath("/v1.0/myorg/groups/{groupId}/datasets/{datasetId}/tables", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Tables> returnType = new ParameterizedTypeReference<Tables>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Creates a new dataset on **\&quot;My Workspace\&quot;**. &lt;br/&gt;**Note**:
     * This API supports only Push datasets.&lt;br/&gt;&lt;br/&gt;**Required
     * scope**: Dataset.ReadWrite.All &lt;br/&gt;To set the permissions scope, see
     * [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>201</b> - Created
     * <p>
     * <b>202</b> - Accepted
     * 
     * @param dataset                Dataset definition to create (required)
     * @param defaultRetentionPolicy The default retention policy (optional)
     * @return Dataset
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Dataset datasetsPostDataset(CreateDatasetRequest dataset, String defaultRetentionPolicy)
            throws RestClientException {
        return datasetsPostDatasetWithHttpInfo(dataset, defaultRetentionPolicy).getBody();
    }

    /**
     * Creates a new dataset on **\&quot;My Workspace\&quot;**. &lt;br/&gt;**Note**:
     * This API supports only Push datasets.&lt;br/&gt;&lt;br/&gt;**Required
     * scope**: Dataset.ReadWrite.All &lt;br/&gt;To set the permissions scope, see
     * [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>201</b> - Created
     * <p>
     * <b>202</b> - Accepted
     * 
     * @param dataset                Dataset definition to create (required)
     * @param defaultRetentionPolicy The default retention policy (optional)
     * @return ResponseEntity&lt;Dataset&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Dataset> datasetsPostDatasetWithHttpInfo(CreateDatasetRequest dataset,
            String defaultRetentionPolicy) throws RestClientException {
        Object postBody = dataset;

        // verify the required parameter 'dataset' is set
        if (dataset == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'dataset' when calling datasetsPostDataset");
        }

        String path = apiClient.expandPath("/v1.0/myorg/datasets", Collections.<String, Object>emptyMap());

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "defaultRetentionPolicy", defaultRetentionPolicy));

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { "application/json" };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Dataset> returnType = new ParameterizedTypeReference<Dataset>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Creates a new dataset in the specified workspace. &lt;br/&gt;**Note**: This
     * API supports only Push datasets.&lt;br/&gt;&lt;br/&gt;**Required scope**:
     * Dataset.ReadWrite.All &lt;br/&gt;To set the permissions scope, see [Register
     * an app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>201</b> - Created
     * <p>
     * <b>202</b> - Accepted
     * 
     * @param groupId                The workspace id (required)
     * @param dataset                Create dataset parameters (required)
     * @param defaultRetentionPolicy The default retention policy (optional)
     * @return Dataset
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Dataset datasetsPostDatasetInGroup(UUID groupId, CreateDatasetRequest dataset, String defaultRetentionPolicy)
            throws RestClientException {
        return datasetsPostDatasetInGroupWithHttpInfo(groupId, dataset, defaultRetentionPolicy).getBody();
    }

    /**
     * Creates a new dataset in the specified workspace. &lt;br/&gt;**Note**: This
     * API supports only Push datasets.&lt;br/&gt;&lt;br/&gt;**Required scope**:
     * Dataset.ReadWrite.All &lt;br/&gt;To set the permissions scope, see [Register
     * an app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>201</b> - Created
     * <p>
     * <b>202</b> - Accepted
     * 
     * @param groupId                The workspace id (required)
     * @param dataset                Create dataset parameters (required)
     * @param defaultRetentionPolicy The default retention policy (optional)
     * @return ResponseEntity&lt;Dataset&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Dataset> datasetsPostDatasetInGroupWithHttpInfo(UUID groupId, CreateDatasetRequest dataset,
            String defaultRetentionPolicy) throws RestClientException {
        Object postBody = dataset;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling datasetsPostDatasetInGroup");
        }

        // verify the required parameter 'dataset' is set
        if (dataset == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'dataset' when calling datasetsPostDatasetInGroup");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        String path = apiClient.expandPath("/v1.0/myorg/groups/{groupId}/datasets", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "defaultRetentionPolicy", defaultRetentionPolicy));

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { "application/json" };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Dataset> returnType = new ParameterizedTypeReference<Dataset>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Adds new data rows to the specified table within the specified dataset from
     * **\&quot;My Workspace\&quot;**. &lt;br/&gt;**Note**: This API supports only
     * Push datasets. &lt;br/&gt;&lt;br/&gt;**REST API Limitations:** See [Power BI
     * REST API limitations](https://msdn.microsoft.com/library/dn950053.aspx).
     * &lt;br/&gt;&lt;br/&gt;**Required scope**: Dataset.ReadWrite.All &lt;br/&gt;To
     * set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param datasetId      The dataset id (required)
     * @param tableName      The table name (required)
     * @param requestMessage The request message (required)
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public void datasetsPostRows(String datasetId, String tableName, PostRowsRequest requestMessage)
            throws RestClientException {
        datasetsPostRowsWithHttpInfo(datasetId, tableName, requestMessage);
    }

    /**
     * Adds new data rows to the specified table within the specified dataset from
     * **\&quot;My Workspace\&quot;**. &lt;br/&gt;**Note**: This API supports only
     * Push datasets. &lt;br/&gt;&lt;br/&gt;**REST API Limitations:** See [Power BI
     * REST API limitations](https://msdn.microsoft.com/library/dn950053.aspx).
     * &lt;br/&gt;&lt;br/&gt;**Required scope**: Dataset.ReadWrite.All &lt;br/&gt;To
     * set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param datasetId      The dataset id (required)
     * @param tableName      The table name (required)
     * @param requestMessage The request message (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Void> datasetsPostRowsWithHttpInfo(String datasetId, String tableName,
            PostRowsRequest requestMessage) throws RestClientException {
        Object postBody = requestMessage;

        // verify the required parameter 'datasetId' is set
        if (datasetId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'datasetId' when calling datasetsPostRows");
        }

        // verify the required parameter 'tableName' is set
        if (tableName == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'tableName' when calling datasetsPostRows");
        }

        // verify the required parameter 'requestMessage' is set
        if (requestMessage == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'requestMessage' when calling datasetsPostRows");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("datasetId", datasetId);
        uriVariables.put("tableName", tableName);
        String path = apiClient.expandPath("/v1.0/myorg/datasets/{datasetId}/tables/{tableName}/rows", uriVariables);

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
     * Adds new data rows to the specified table, within the specified dataset, from
     * the specified workspace. &lt;br/&gt;**Note**: This API supports only Push
     * datasets. &lt;br/&gt;&lt;br/&gt;**REST API Limitations:** See [Power BI REST
     * API limitations](https://msdn.microsoft.com/library/dn950053.aspx).
     * &lt;br/&gt;&lt;br/&gt;**Required scope**: Dataset.ReadWrite.All &lt;br/&gt;To
     * set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId        The workspace id (required)
     * @param datasetId      The dataset id (required)
     * @param tableName      The table name (required)
     * @param requestMessage The request message (required)
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public void datasetsPostRowsInGroup(UUID groupId, String datasetId, String tableName,
            PostRowsRequest requestMessage) throws RestClientException {
        datasetsPostRowsInGroupWithHttpInfo(groupId, datasetId, tableName, requestMessage);
    }

    /**
     * Adds new data rows to the specified table, within the specified dataset, from
     * the specified workspace. &lt;br/&gt;**Note**: This API supports only Push
     * datasets. &lt;br/&gt;&lt;br/&gt;**REST API Limitations:** See [Power BI REST
     * API limitations](https://msdn.microsoft.com/library/dn950053.aspx).
     * &lt;br/&gt;&lt;br/&gt;**Required scope**: Dataset.ReadWrite.All &lt;br/&gt;To
     * set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId        The workspace id (required)
     * @param datasetId      The dataset id (required)
     * @param tableName      The table name (required)
     * @param requestMessage The request message (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Void> datasetsPostRowsInGroupWithHttpInfo(UUID groupId, String datasetId, String tableName,
            PostRowsRequest requestMessage) throws RestClientException {
        Object postBody = requestMessage;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling datasetsPostRowsInGroup");
        }

        // verify the required parameter 'datasetId' is set
        if (datasetId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'datasetId' when calling datasetsPostRowsInGroup");
        }

        // verify the required parameter 'tableName' is set
        if (tableName == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'tableName' when calling datasetsPostRowsInGroup");
        }

        // verify the required parameter 'requestMessage' is set
        if (requestMessage == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'requestMessage' when calling datasetsPostRowsInGroup");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("datasetId", datasetId);
        uriVariables.put("tableName", tableName);
        String path = apiClient.expandPath("/v1.0/myorg/groups/{groupId}/datasets/{datasetId}/tables/{tableName}/rows",
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
     * Updates the metadata and schema for the specified table within the specified
     * dataset from **\&quot;My Workspace\&quot;**. &lt;br/&gt;**Note**: This API
     * supports only Push datasets. &lt;br/&gt;&lt;br/&gt;**Required scope**:
     * Dataset.ReadWrite.All &lt;br/&gt;To set the permissions scope, see [Register
     * an app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param datasetId      The dataset id (required)
     * @param tableName      The table name (required)
     * @param requestMessage Table name and columns to update existing table
     *                       (required)
     * @return Table
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Table datasetsPutTable(String datasetId, String tableName, Table requestMessage) throws RestClientException {
        return datasetsPutTableWithHttpInfo(datasetId, tableName, requestMessage).getBody();
    }

    /**
     * Updates the metadata and schema for the specified table within the specified
     * dataset from **\&quot;My Workspace\&quot;**. &lt;br/&gt;**Note**: This API
     * supports only Push datasets. &lt;br/&gt;&lt;br/&gt;**Required scope**:
     * Dataset.ReadWrite.All &lt;br/&gt;To set the permissions scope, see [Register
     * an app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param datasetId      The dataset id (required)
     * @param tableName      The table name (required)
     * @param requestMessage Table name and columns to update existing table
     *                       (required)
     * @return ResponseEntity&lt;Table&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Table> datasetsPutTableWithHttpInfo(String datasetId, String tableName, Table requestMessage)
            throws RestClientException {
        Object postBody = requestMessage;

        // verify the required parameter 'datasetId' is set
        if (datasetId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'datasetId' when calling datasetsPutTable");
        }

        // verify the required parameter 'tableName' is set
        if (tableName == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'tableName' when calling datasetsPutTable");
        }

        // verify the required parameter 'requestMessage' is set
        if (requestMessage == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'requestMessage' when calling datasetsPutTable");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("datasetId", datasetId);
        uriVariables.put("tableName", tableName);
        String path = apiClient.expandPath("/v1.0/myorg/datasets/{datasetId}/tables/{tableName}", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "*/*" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { "application/json" };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Table> returnType = new ParameterizedTypeReference<Table>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.PUT, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Updates the metadata and schema for the specified table, within the specified
     * dataset, from the specified workspace. &lt;br/&gt;**Note**: This API supports
     * only Push datasets. &lt;br/&gt;&lt;br/&gt;**Required scope**:
     * Dataset.ReadWrite.All &lt;br/&gt;To set the permissions scope, see [Register
     * an app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId        The workspace id (required)
     * @param datasetId      The dataset id (required)
     * @param tableName      The table name (required)
     * @param requestMessage The request message (required)
     * @return Table
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Table datasetsPutTableInGroup(UUID groupId, String datasetId, String tableName, Table requestMessage)
            throws RestClientException {
        return datasetsPutTableInGroupWithHttpInfo(groupId, datasetId, tableName, requestMessage).getBody();
    }

    /**
     * Updates the metadata and schema for the specified table, within the specified
     * dataset, from the specified workspace. &lt;br/&gt;**Note**: This API supports
     * only Push datasets. &lt;br/&gt;&lt;br/&gt;**Required scope**:
     * Dataset.ReadWrite.All &lt;br/&gt;To set the permissions scope, see [Register
     * an app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId        The workspace id (required)
     * @param datasetId      The dataset id (required)
     * @param tableName      The table name (required)
     * @param requestMessage The request message (required)
     * @return ResponseEntity&lt;Table&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Table> datasetsPutTableInGroupWithHttpInfo(UUID groupId, String datasetId, String tableName,
            Table requestMessage) throws RestClientException {
        Object postBody = requestMessage;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling datasetsPutTableInGroup");
        }

        // verify the required parameter 'datasetId' is set
        if (datasetId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'datasetId' when calling datasetsPutTableInGroup");
        }

        // verify the required parameter 'tableName' is set
        if (tableName == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'tableName' when calling datasetsPutTableInGroup");
        }

        // verify the required parameter 'requestMessage' is set
        if (requestMessage == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'requestMessage' when calling datasetsPutTableInGroup");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("datasetId", datasetId);
        uriVariables.put("tableName", tableName);
        String path = apiClient.expandPath("/v1.0/myorg/groups/{groupId}/datasets/{datasetId}/tables/{tableName}",
                uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "*/*" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Table> returnType = new ParameterizedTypeReference<Table>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.PUT, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }
}
