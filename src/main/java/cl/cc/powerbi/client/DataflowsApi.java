package cl.cc.powerbi.client;

import java.io.File;
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
import cl.cc.powerbi.client.model.Dataflows;
import cl.cc.powerbi.client.model.Datasources;
import cl.cc.powerbi.client.model.DependentDataflows;
import cl.cc.powerbi.client.model.RefreshRequest;
import cl.cc.powerbi.client.model.RefreshScheduleRequest;

@Component("cl.cc.powerbi.client.DataflowsApi")
public class DataflowsApi {
    private ApiClient apiClient;

    public DataflowsApi() {
        this(new ApiClient());
    }

    @Autowired
    public DataflowsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Deletes a dataflow from the CDS for Analytics storage, including its
     * definition file and actual model. &lt;br/&gt;**Required scope**:
     * Dataflow.ReadWrite.All &lt;br/&gt;To set the permissions scope, see [Register
     * an app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId    The workspace id (required)
     * @param dataflowId The dataflow id (required)
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public void dataflowsDeleteDataflow(UUID groupId, UUID dataflowId) throws RestClientException {
        dataflowsDeleteDataflowWithHttpInfo(groupId, dataflowId);
    }

    /**
     * Deletes a dataflow from the CDS for Analytics storage, including its
     * definition file and actual model. &lt;br/&gt;**Required scope**:
     * Dataflow.ReadWrite.All &lt;br/&gt;To set the permissions scope, see [Register
     * an app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId    The workspace id (required)
     * @param dataflowId The dataflow id (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Void> dataflowsDeleteDataflowWithHttpInfo(UUID groupId, UUID dataflowId)
            throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling dataflowsDeleteDataflow");
        }

        // verify the required parameter 'dataflowId' is set
        if (dataflowId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'dataflowId' when calling dataflowsDeleteDataflow");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("dataflowId", dataflowId);
        String path = apiClient.expandPath("/v1.0/myorg/groups/{groupId}/dataflows/{dataflowId}", uriVariables);

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
     * Exports the specified dataflow definition to a .json file.
     * &lt;br/&gt;**Required scope**: Dataflow.ReadWrite.All or Dataflow.Read.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - Exported Json file
     * 
     * @param groupId    The workspace id (required)
     * @param dataflowId The dataflow id (required)
     * @return File
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public File dataflowsGetDataflow(UUID groupId, UUID dataflowId) throws RestClientException {
        return dataflowsGetDataflowWithHttpInfo(groupId, dataflowId).getBody();
    }

    /**
     * Exports the specified dataflow definition to a .json file.
     * &lt;br/&gt;**Required scope**: Dataflow.ReadWrite.All or Dataflow.Read.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - Exported Json file
     * 
     * @param groupId    The workspace id (required)
     * @param dataflowId The dataflow id (required)
     * @return ResponseEntity&lt;File&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<File> dataflowsGetDataflowWithHttpInfo(UUID groupId, UUID dataflowId)
            throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling dataflowsGetDataflow");
        }

        // verify the required parameter 'dataflowId' is set
        if (dataflowId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'dataflowId' when calling dataflowsGetDataflow");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("dataflowId", dataflowId);
        String path = apiClient.expandPath("/v1.0/myorg/groups/{groupId}/dataflows/{dataflowId}", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/json" };
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
     * Returns a list of datasources for the specified dataflow.
     * &lt;br/&gt;**Required scope**: Dataflow.ReadWrite.All or Dataflow.Read.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId    The workspace id (required)
     * @param dataflowId The dataflow id (required)
     * @return Datasources
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Datasources dataflowsGetDataflowDataSources(UUID groupId, UUID dataflowId) throws RestClientException {
        return dataflowsGetDataflowDataSourcesWithHttpInfo(groupId, dataflowId).getBody();
    }

    /**
     * Returns a list of datasources for the specified dataflow.
     * &lt;br/&gt;**Required scope**: Dataflow.ReadWrite.All or Dataflow.Read.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId    The workspace id (required)
     * @param dataflowId The dataflow id (required)
     * @return ResponseEntity&lt;Datasources&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Datasources> dataflowsGetDataflowDataSourcesWithHttpInfo(UUID groupId, UUID dataflowId)
            throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling dataflowsGetDataflowDataSources");
        }

        // verify the required parameter 'dataflowId' is set
        if (dataflowId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'dataflowId' when calling dataflowsGetDataflowDataSources");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("dataflowId", dataflowId);
        String path = apiClient.expandPath("/v1.0/myorg/groups/{groupId}/dataflows/{dataflowId}/datasources",
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
     * Returns a list of all dataflows from the specified workspace.
     * &lt;br/&gt;**Required scope**: Dataflow.ReadWrite.All or Dataflow.Read.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId The workspace id (required)
     * @return Dataflows
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Dataflows dataflowsGetDataflows(UUID groupId) throws RestClientException {
        return dataflowsGetDataflowsWithHttpInfo(groupId).getBody();
    }

    /**
     * Returns a list of all dataflows from the specified workspace.
     * &lt;br/&gt;**Required scope**: Dataflow.ReadWrite.All or Dataflow.Read.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId The workspace id (required)
     * @return ResponseEntity&lt;Dataflows&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Dataflows> dataflowsGetDataflowsWithHttpInfo(UUID groupId) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling dataflowsGetDataflows");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        String path = apiClient.expandPath("/v1.0/myorg/groups/{groupId}/dataflows", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Dataflows> returnType = new ParameterizedTypeReference<Dataflows>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Returns a list of upstream dataflows for the specified dataflow.
     * &lt;br/&gt;**Required scope**: Dataflow.ReadWrite.All or
     * Dataflow.Read.All&lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId    The workspace id (required)
     * @param dataflowId The dataflow id (required)
     * @return DependentDataflows
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public DependentDataflows dataflowsGetUpstreamDataflowsInGroup(UUID groupId, UUID dataflowId)
            throws RestClientException {
        return dataflowsGetUpstreamDataflowsInGroupWithHttpInfo(groupId, dataflowId).getBody();
    }

    /**
     * Returns a list of upstream dataflows for the specified dataflow.
     * &lt;br/&gt;**Required scope**: Dataflow.ReadWrite.All or
     * Dataflow.Read.All&lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId    The workspace id (required)
     * @param dataflowId The dataflow id (required)
     * @return ResponseEntity&lt;DependentDataflows&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<DependentDataflows> dataflowsGetUpstreamDataflowsInGroupWithHttpInfo(UUID groupId,
            UUID dataflowId) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling dataflowsGetUpstreamDataflowsInGroup");
        }

        // verify the required parameter 'dataflowId' is set
        if (dataflowId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'dataflowId' when calling dataflowsGetUpstreamDataflowsInGroup");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("dataflowId", dataflowId);
        String path = apiClient.expandPath("/v1.0/myorg/groups/{groupId}/dataflows/{dataflowId}/upstreamDataflows",
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

        ParameterizedTypeReference<DependentDataflows> returnType = new ParameterizedTypeReference<DependentDataflows>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Triggers a refresh for the specified dataflow. &lt;br/&gt;**Required scope**:
     * Dataflow.ReadWrite.All &lt;br/&gt;To set the permissions scope, see [Register
     * an app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId        The workspace id (required)
     * @param dataflowId     The dataflow id (required)
     * @param refreshRequest (optional)
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public void dataflowsRefreshDataflow(UUID groupId, UUID dataflowId, RefreshRequest refreshRequest)
            throws RestClientException {
        dataflowsRefreshDataflowWithHttpInfo(groupId, dataflowId, refreshRequest);
    }

    /**
     * Triggers a refresh for the specified dataflow. &lt;br/&gt;**Required scope**:
     * Dataflow.ReadWrite.All &lt;br/&gt;To set the permissions scope, see [Register
     * an app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId        The workspace id (required)
     * @param dataflowId     The dataflow id (required)
     * @param refreshRequest (optional)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Void> dataflowsRefreshDataflowWithHttpInfo(UUID groupId, UUID dataflowId,
            RefreshRequest refreshRequest) throws RestClientException {
        Object postBody = refreshRequest;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling dataflowsRefreshDataflow");
        }

        // verify the required parameter 'dataflowId' is set
        if (dataflowId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'dataflowId' when calling dataflowsRefreshDataflow");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("dataflowId", dataflowId);
        String path = apiClient.expandPath("/v1.0/myorg/groups/{groupId}/dataflows/{dataflowId}/refreshes",
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
     * Creates or updates the specified dataflow refresh schedule configuration.
     * &lt;br/&gt;**Required scope**: Dataflow.ReadWrite.All &lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId                The workspace id (required)
     * @param dataflowId             The dataflow id (required)
     * @param refreshScheduleRequest The dataflow refresh schedule to create or
     *                               update (required)
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public void dataflowsUpdateRefreshSchedule(UUID groupId, UUID dataflowId,
            RefreshScheduleRequest refreshScheduleRequest) throws RestClientException {
        dataflowsUpdateRefreshScheduleWithHttpInfo(groupId, dataflowId, refreshScheduleRequest);
    }

    /**
     * Creates or updates the specified dataflow refresh schedule configuration.
     * &lt;br/&gt;**Required scope**: Dataflow.ReadWrite.All &lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId                The workspace id (required)
     * @param dataflowId             The dataflow id (required)
     * @param refreshScheduleRequest The dataflow refresh schedule to create or
     *                               update (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Void> dataflowsUpdateRefreshScheduleWithHttpInfo(UUID groupId, UUID dataflowId,
            RefreshScheduleRequest refreshScheduleRequest) throws RestClientException {
        Object postBody = refreshScheduleRequest;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling dataflowsUpdateRefreshSchedule");
        }

        // verify the required parameter 'dataflowId' is set
        if (dataflowId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'dataflowId' when calling dataflowsUpdateRefreshSchedule");
        }

        // verify the required parameter 'refreshScheduleRequest' is set
        if (refreshScheduleRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'refreshScheduleRequest' when calling dataflowsUpdateRefreshSchedule");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("dataflowId", dataflowId);
        String path = apiClient.expandPath("/v1.0/myorg/groups/{groupId}/dataflows/{dataflowId}/refreshSchedule",
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
