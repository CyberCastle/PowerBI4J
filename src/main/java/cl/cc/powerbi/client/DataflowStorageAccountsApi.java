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
import cl.cc.powerbi.client.model.AssignToDataflowStorageRequest;
import cl.cc.powerbi.client.model.DataflowStorageAccounts;

@Component("cl.cc.powerbi.client.DataflowStorageAccountsApi")
public class DataflowStorageAccountsApi {
    private ApiClient apiClient;

    public DataflowStorageAccountsApi() {
        this(new ApiClient());
    }

    @Autowired
    public DataflowStorageAccountsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Returns a list of dataflow storage accounts the user has access to.
     * &lt;br/&gt;**Required scope**: StorageAccount.Read.All or
     * StorageAccount.ReadWrite.All &lt;br/&gt;To set the permissions scope, see
     * [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @return DataflowStorageAccounts
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public DataflowStorageAccounts dataflowStorageAccountsGetDataflowStorageAccounts() throws RestClientException {
        return dataflowStorageAccountsGetDataflowStorageAccountsWithHttpInfo().getBody();
    }

    /**
     * Returns a list of dataflow storage accounts the user has access to.
     * &lt;br/&gt;**Required scope**: StorageAccount.Read.All or
     * StorageAccount.ReadWrite.All &lt;br/&gt;To set the permissions scope, see
     * [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @return ResponseEntity&lt;DataflowStorageAccounts&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<DataflowStorageAccounts> dataflowStorageAccountsGetDataflowStorageAccountsWithHttpInfo()
            throws RestClientException {
        Object postBody = null;

        String path = apiClient.expandPath("/v1.0/myorg/dataflowStorageAccounts",
                Collections.<String, Object>emptyMap());

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<DataflowStorageAccounts> returnType = new ParameterizedTypeReference<DataflowStorageAccounts>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Assigns the specified workspace to the specified dataflow storage account.
     * **Note**: To perform this operation, the user must be an admin on the
     * specified workspace and the Power BI dataflow storage account must be
     * enabled. To unassign the specified workspace from a Power BI dataflow storage
     * account, an empty GUID (00000000-0000-0000-0000-000000000000) should be
     * provided as dataflowStorageId.&lt;br/&gt;&lt;br/&gt;**Required scope**:
     * StorageAccount.ReadWrite.All and Workspace.ReadWrite.All &lt;br/&gt;To set
     * the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId           The workspace id (required)
     * @param requestParameters Assign to Power BI dataflow storage account
     *                          parameters (required)
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public void groupsAssignToDataflowStorage(UUID groupId, AssignToDataflowStorageRequest requestParameters)
            throws RestClientException {
        groupsAssignToDataflowStorageWithHttpInfo(groupId, requestParameters);
    }

    /**
     * Assigns the specified workspace to the specified dataflow storage account.
     * **Note**: To perform this operation, the user must be an admin on the
     * specified workspace and the Power BI dataflow storage account must be
     * enabled. To unassign the specified workspace from a Power BI dataflow storage
     * account, an empty GUID (00000000-0000-0000-0000-000000000000) should be
     * provided as dataflowStorageId.&lt;br/&gt;&lt;br/&gt;**Required scope**:
     * StorageAccount.ReadWrite.All and Workspace.ReadWrite.All &lt;br/&gt;To set
     * the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId           The workspace id (required)
     * @param requestParameters Assign to Power BI dataflow storage account
     *                          parameters (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Void> groupsAssignToDataflowStorageWithHttpInfo(UUID groupId,
            AssignToDataflowStorageRequest requestParameters) throws RestClientException {
        Object postBody = requestParameters;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling groupsAssignToDataflowStorage");
        }

        // verify the required parameter 'requestParameters' is set
        if (requestParameters == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'requestParameters' when calling groupsAssignToDataflowStorage");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        String path = apiClient.expandPath("/v1.0/myorg/groups/{groupId}/AssignToDataflowStorage", uriVariables);

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
}
