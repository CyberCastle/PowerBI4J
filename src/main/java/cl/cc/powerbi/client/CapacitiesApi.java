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
import cl.cc.powerbi.client.model.AssignToCapacityRequest;
import cl.cc.powerbi.client.model.Capacities;
import cl.cc.powerbi.client.model.PatchWorkloadRequest;
import cl.cc.powerbi.client.model.Workload;
import cl.cc.powerbi.client.model.Workloads;
import cl.cc.powerbi.client.model.WorkspaceCapacityAssignmentStatus;

@Component("cl.cc.powerbi.client.CapacitiesApi")
public class CapacitiesApi {
    private ApiClient apiClient;

    public CapacitiesApi() {
        this(new ApiClient());
    }

    @Autowired
    public CapacitiesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Returns a list of capacities the user has access to. &lt;br/&gt;**Required
     * scope**: Capacity.Read.All or Capacity.ReadWrite.All &lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @return Capacities
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Capacities capacitiesGetCapacities() throws RestClientException {
        return capacitiesGetCapacitiesWithHttpInfo().getBody();
    }

    /**
     * Returns a list of capacities the user has access to. &lt;br/&gt;**Required
     * scope**: Capacity.Read.All or Capacity.ReadWrite.All &lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @return ResponseEntity&lt;Capacities&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Capacities> capacitiesGetCapacitiesWithHttpInfo() throws RestClientException {
        Object postBody = null;

        String path = apiClient.expandPath("/v1.0/myorg/capacities", Collections.<String, Object>emptyMap());

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Capacities> returnType = new ParameterizedTypeReference<Capacities>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Returns the current state of a workload and if the workload is enabled also
     * returns the maximum memory percentage that the workload can consume.
     * &lt;br/&gt;**Required scope**: Capacity.Read.All or Capacity.ReadWrite.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param capacityId   The capacity Id (required)
     * @param workloadName The name of the workload (required)
     * @return Workload
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Workload capacitiesGetWorkload(UUID capacityId, String workloadName) throws RestClientException {
        return capacitiesGetWorkloadWithHttpInfo(capacityId, workloadName).getBody();
    }

    /**
     * Returns the current state of a workload and if the workload is enabled also
     * returns the maximum memory percentage that the workload can consume.
     * &lt;br/&gt;**Required scope**: Capacity.Read.All or Capacity.ReadWrite.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param capacityId   The capacity Id (required)
     * @param workloadName The name of the workload (required)
     * @return ResponseEntity&lt;Workload&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Workload> capacitiesGetWorkloadWithHttpInfo(UUID capacityId, String workloadName)
            throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'capacityId' is set
        if (capacityId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'capacityId' when calling capacitiesGetWorkload");
        }

        // verify the required parameter 'workloadName' is set
        if (workloadName == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'workloadName' when calling capacitiesGetWorkload");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("capacityId", capacityId);
        uriVariables.put("workloadName", workloadName);
        String path = apiClient.expandPath("/v1.0/myorg/capacities/{capacityId}/Workloads/{workloadName}",
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

        ParameterizedTypeReference<Workload> returnType = new ParameterizedTypeReference<Workload>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Returns the current state of the specified capacity workloads, if a workload
     * is enabled also returns the maximum memory percentage that the workload can
     * consume. &lt;br/&gt;**Required scope**: Capacity.Read.All or
     * Capacity.ReadWrite.All &lt;br/&gt;To set the permissions scope, see [Register
     * an app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param capacityId The capacity Id (required)
     * @return Workloads
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Workloads capacitiesGetWorkloads(UUID capacityId) throws RestClientException {
        return capacitiesGetWorkloadsWithHttpInfo(capacityId).getBody();
    }

    /**
     * Returns the current state of the specified capacity workloads, if a workload
     * is enabled also returns the maximum memory percentage that the workload can
     * consume. &lt;br/&gt;**Required scope**: Capacity.Read.All or
     * Capacity.ReadWrite.All &lt;br/&gt;To set the permissions scope, see [Register
     * an app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param capacityId The capacity Id (required)
     * @return ResponseEntity&lt;Workloads&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Workloads> capacitiesGetWorkloadsWithHttpInfo(UUID capacityId) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'capacityId' is set
        if (capacityId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'capacityId' when calling capacitiesGetWorkloads");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("capacityId", capacityId);
        String path = apiClient.expandPath("/v1.0/myorg/capacities/{capacityId}/Workloads", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Workloads> returnType = new ParameterizedTypeReference<Workloads>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Changes the state of a specific workload to Enabled or Disabled. When
     * enabling a workload the maximum memory percentage that the workload can
     * consume must be set. &lt;br/&gt;**Required scope**: Capacity.ReadWrite.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param capacityId   The capacity Id (required)
     * @param workloadName The name of the workload (required)
     * @param workload     Patch workload parameters (required)
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public void capacitiesPatchWorkload(UUID capacityId, String workloadName, PatchWorkloadRequest workload)
            throws RestClientException {
        capacitiesPatchWorkloadWithHttpInfo(capacityId, workloadName, workload);
    }

    /**
     * Changes the state of a specific workload to Enabled or Disabled. When
     * enabling a workload the maximum memory percentage that the workload can
     * consume must be set. &lt;br/&gt;**Required scope**: Capacity.ReadWrite.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param capacityId   The capacity Id (required)
     * @param workloadName The name of the workload (required)
     * @param workload     Patch workload parameters (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Void> capacitiesPatchWorkloadWithHttpInfo(UUID capacityId, String workloadName,
            PatchWorkloadRequest workload) throws RestClientException {
        Object postBody = workload;

        // verify the required parameter 'capacityId' is set
        if (capacityId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'capacityId' when calling capacitiesPatchWorkload");
        }

        // verify the required parameter 'workloadName' is set
        if (workloadName == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'workloadName' when calling capacitiesPatchWorkload");
        }

        // verify the required parameter 'workload' is set
        if (workload == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'workload' when calling capacitiesPatchWorkload");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("capacityId", capacityId);
        uriVariables.put("workloadName", workloadName);
        String path = apiClient.expandPath("/v1.0/myorg/capacities/{capacityId}/Workloads/{workloadName}",
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

    /**
     * Assigns **\&quot;My Workspace\&quot;** to the specified capacity. **Note**:
     * To perform this operation, the user must have admin or assign permissions on
     * the capacity. To unassign **\&quot;My Workspace\&quot;** from a capacity,
     * Empty Guid (00000000-0000-0000-0000-000000000000) should be provided as
     * capacityId. &lt;br/&gt;&lt;br/&gt;**Required scope**: Capacity.ReadWrite.All
     * and Workspace.ReadWrite.All &lt;br/&gt;To set the permissions scope, see
     * [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param requestParameters Assign to capacity parameters (required)
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public void groupsAssignMyWorkspaceToCapacity(AssignToCapacityRequest requestParameters)
            throws RestClientException {
        groupsAssignMyWorkspaceToCapacityWithHttpInfo(requestParameters);
    }

    /**
     * Assigns **\&quot;My Workspace\&quot;** to the specified capacity. **Note**:
     * To perform this operation, the user must have admin or assign permissions on
     * the capacity. To unassign **\&quot;My Workspace\&quot;** from a capacity,
     * Empty Guid (00000000-0000-0000-0000-000000000000) should be provided as
     * capacityId. &lt;br/&gt;&lt;br/&gt;**Required scope**: Capacity.ReadWrite.All
     * and Workspace.ReadWrite.All &lt;br/&gt;To set the permissions scope, see
     * [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param requestParameters Assign to capacity parameters (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Void> groupsAssignMyWorkspaceToCapacityWithHttpInfo(AssignToCapacityRequest requestParameters)
            throws RestClientException {
        Object postBody = requestParameters;

        // verify the required parameter 'requestParameters' is set
        if (requestParameters == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'requestParameters' when calling groupsAssignMyWorkspaceToCapacity");
        }

        String path = apiClient.expandPath("/v1.0/myorg/AssignToCapacity", Collections.<String, Object>emptyMap());

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
     * Assigns the specified workspace to the specified capacity. **Note**: To
     * perform this operation, the user must be admin on the specified workspace and
     * have admin or assign permissions on the capacity. To unassign the specified
     * workspace from a capacity, Empty Guid (00000000-0000-0000-0000-000000000000)
     * should be provided as capacityId. &lt;br/&gt;&lt;br/&gt;**Required scope**:
     * Capacity.ReadWrite.All and Workspace.ReadWrite.All &lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId           The workspace id (required)
     * @param requestParameters Assign to capacity parameters (required)
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public void groupsAssignToCapacity(UUID groupId, AssignToCapacityRequest requestParameters)
            throws RestClientException {
        groupsAssignToCapacityWithHttpInfo(groupId, requestParameters);
    }

    /**
     * Assigns the specified workspace to the specified capacity. **Note**: To
     * perform this operation, the user must be admin on the specified workspace and
     * have admin or assign permissions on the capacity. To unassign the specified
     * workspace from a capacity, Empty Guid (00000000-0000-0000-0000-000000000000)
     * should be provided as capacityId. &lt;br/&gt;&lt;br/&gt;**Required scope**:
     * Capacity.ReadWrite.All and Workspace.ReadWrite.All &lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId           The workspace id (required)
     * @param requestParameters Assign to capacity parameters (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Void> groupsAssignToCapacityWithHttpInfo(UUID groupId,
            AssignToCapacityRequest requestParameters) throws RestClientException {
        Object postBody = requestParameters;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling groupsAssignToCapacity");
        }

        // verify the required parameter 'requestParameters' is set
        if (requestParameters == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'requestParameters' when calling groupsAssignToCapacity");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        String path = apiClient.expandPath("/v1.0/myorg/groups/{groupId}/AssignToCapacity", uriVariables);

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
     * Gets the status of the assignment to capacity operation of the specified
     * workspace. **Note**: To perform this operation, the user must be admin on the
     * specified workspace. &lt;br/&gt;&lt;br/&gt;**Required scope**:
     * Workspace.Read.All and Workspace.ReadWrite.All &lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId The workspace id (required)
     * @return WorkspaceCapacityAssignmentStatus
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public WorkspaceCapacityAssignmentStatus groupsCapacityAssignmentStatus(UUID groupId) throws RestClientException {
        return groupsCapacityAssignmentStatusWithHttpInfo(groupId).getBody();
    }

    /**
     * Gets the status of the assignment to capacity operation of the specified
     * workspace. **Note**: To perform this operation, the user must be admin on the
     * specified workspace. &lt;br/&gt;&lt;br/&gt;**Required scope**:
     * Workspace.Read.All and Workspace.ReadWrite.All &lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId The workspace id (required)
     * @return ResponseEntity&lt;WorkspaceCapacityAssignmentStatus&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<WorkspaceCapacityAssignmentStatus> groupsCapacityAssignmentStatusWithHttpInfo(UUID groupId)
            throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling groupsCapacityAssignmentStatus");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        String path = apiClient.expandPath("/v1.0/myorg/groups/{groupId}/CapacityAssignmentStatus", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<WorkspaceCapacityAssignmentStatus> returnType = new ParameterizedTypeReference<WorkspaceCapacityAssignmentStatus>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Gets the status of **\&quot;My Workspace\&quot;** assignment to capacity
     * operation. **Note**: &lt;br/&gt;&lt;br/&gt;**Required scope**:
     * Workspace.Read.All and Workspace.ReadWrite.All &lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @return WorkspaceCapacityAssignmentStatus
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public WorkspaceCapacityAssignmentStatus groupsCapacityAssignmentStatusMyWorkspace() throws RestClientException {
        return groupsCapacityAssignmentStatusMyWorkspaceWithHttpInfo().getBody();
    }

    /**
     * Gets the status of **\&quot;My Workspace\&quot;** assignment to capacity
     * operation. **Note**: &lt;br/&gt;&lt;br/&gt;**Required scope**:
     * Workspace.Read.All and Workspace.ReadWrite.All &lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @return ResponseEntity&lt;WorkspaceCapacityAssignmentStatus&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<WorkspaceCapacityAssignmentStatus> groupsCapacityAssignmentStatusMyWorkspaceWithHttpInfo()
            throws RestClientException {
        Object postBody = null;

        String path = apiClient.expandPath("/v1.0/myorg/CapacityAssignmentStatus",
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

        ParameterizedTypeReference<WorkspaceCapacityAssignmentStatus> returnType = new ParameterizedTypeReference<WorkspaceCapacityAssignmentStatus>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }
}
