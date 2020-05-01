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
import cl.cc.powerbi.client.model.Group;
import cl.cc.powerbi.client.model.GroupCreationRequest;
import cl.cc.powerbi.client.model.GroupUser;
import cl.cc.powerbi.client.model.GroupUsers;
import cl.cc.powerbi.client.model.Groups;

@Component("cl.cc.powerbi.client.GroupsApi")
public class GroupsApi {
    private ApiClient apiClient;

    public GroupsApi() {
        this(new ApiClient());
    }

    @Autowired
    public GroupsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Grants the specified user permissions to the specified workspace.
     * &lt;br/&gt;**Notes**: &lt;li&gt; Users that have been recently added to a
     * group may not have their new group immediately available, see [Refresh user
     * permissions](https://docs.microsoft.com/en-us/rest/api/power-bi/users/refreshuserpermissions).
     * &lt;/li&gt;&lt;br/&gt;**Required scope**:
     * Workspace.ReadWrite.All&lt;br/&gt;To set the permissions scope, see [Register
     * an app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId     The workspace id (required)
     * @param userDetails Details of user access right (required)
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public void groupsAddGroupUser(UUID groupId, GroupUser userDetails) throws RestClientException {
        groupsAddGroupUserWithHttpInfo(groupId, userDetails);
    }

    /**
     * Grants the specified user permissions to the specified workspace.
     * &lt;br/&gt;**Notes**: &lt;li&gt; Users that have been recently added to a
     * group may not have their new group immediately available, see [Refresh user
     * permissions](https://docs.microsoft.com/en-us/rest/api/power-bi/users/refreshuserpermissions).
     * &lt;/li&gt;&lt;br/&gt;**Required scope**:
     * Workspace.ReadWrite.All&lt;br/&gt;To set the permissions scope, see [Register
     * an app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId     The workspace id (required)
     * @param userDetails Details of user access right (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Void> groupsAddGroupUserWithHttpInfo(UUID groupId, GroupUser userDetails)
            throws RestClientException {
        Object postBody = userDetails;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling groupsAddGroupUser");
        }

        // verify the required parameter 'userDetails' is set
        if (userDetails == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'userDetails' when calling groupsAddGroupUser");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        String path = apiClient.expandPath("/v1.0/myorg/groups/{groupId}/users", uriVariables);

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
     * Creates new workspace. &lt;br/&gt;**Required scope**:
     * Workspace.ReadWrite.All&lt;br/&gt;To set the permissions scope, see [Register
     * an app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param requestParameters Create group request parameters (required)
     * @param workspaceV2       Preview feature: Create a workspace V2. The only
     *                          supported value is true. (optional)
     * @return Group
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Group groupsCreateGroup(GroupCreationRequest requestParameters, Boolean workspaceV2)
            throws RestClientException {
        return groupsCreateGroupWithHttpInfo(requestParameters, workspaceV2).getBody();
    }

    /**
     * Creates new workspace. &lt;br/&gt;**Required scope**:
     * Workspace.ReadWrite.All&lt;br/&gt;To set the permissions scope, see [Register
     * an app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param requestParameters Create group request parameters (required)
     * @param workspaceV2       Preview feature: Create a workspace V2. The only
     *                          supported value is true. (optional)
     * @return ResponseEntity&lt;Group&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Group> groupsCreateGroupWithHttpInfo(GroupCreationRequest requestParameters,
            Boolean workspaceV2) throws RestClientException {
        Object postBody = requestParameters;

        // verify the required parameter 'requestParameters' is set
        if (requestParameters == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'requestParameters' when calling groupsCreateGroup");
        }

        String path = apiClient.expandPath("/v1.0/myorg/groups", Collections.<String, Object>emptyMap());

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "workspaceV2", workspaceV2));

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { "application/json" };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Group> returnType = new ParameterizedTypeReference<Group>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Deletes the specified workspace. &lt;br/&gt;**Required scope**:
     * Workspace.ReadWrite.All&lt;br/&gt;To set the permissions scope, see [Register
     * an app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId The workspace id to delete (required)
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public void groupsDeleteGroup(UUID groupId) throws RestClientException {
        groupsDeleteGroupWithHttpInfo(groupId);
    }

    /**
     * Deletes the specified workspace. &lt;br/&gt;**Required scope**:
     * Workspace.ReadWrite.All&lt;br/&gt;To set the permissions scope, see [Register
     * an app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId The workspace id to delete (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Void> groupsDeleteGroupWithHttpInfo(UUID groupId) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling groupsDeleteGroup");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        String path = apiClient.expandPath("/v1.0/myorg/groups/{groupId}", uriVariables);

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
     * Deletes the specified user permissions from the specified workspace.
     * &lt;br/&gt;**Required scope**: Workspace.ReadWrite.All&lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId The workspace id (required)
     * @param user    The email address of the user or the service principal object
     *                id to delete (required)
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public void groupsDeleteUserInGroup(UUID groupId, String user) throws RestClientException {
        groupsDeleteUserInGroupWithHttpInfo(groupId, user);
    }

    /**
     * Deletes the specified user permissions from the specified workspace.
     * &lt;br/&gt;**Required scope**: Workspace.ReadWrite.All&lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId The workspace id (required)
     * @param user    The email address of the user or the service principal object
     *                id to delete (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Void> groupsDeleteUserInGroupWithHttpInfo(UUID groupId, String user)
            throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling groupsDeleteUserInGroup");
        }

        // verify the required parameter 'user' is set
        if (user == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'user' when calling groupsDeleteUserInGroup");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("user", user);
        String path = apiClient.expandPath("/v1.0/myorg/groups/{groupId}/users/{user}", uriVariables);

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
     * Returns a list of users that have access to the specified workspace.
     * &lt;br/&gt;**Required scope**: Workspace.Read.All or
     * Workspace.ReadWrite.All&lt;br/&gt;To set the permissions scope, see [Register
     * an app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId The workspace id (required)
     * @return GroupUsers
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public GroupUsers groupsGetGroupUsers(UUID groupId) throws RestClientException {
        return groupsGetGroupUsersWithHttpInfo(groupId).getBody();
    }

    /**
     * Returns a list of users that have access to the specified workspace.
     * &lt;br/&gt;**Required scope**: Workspace.Read.All or
     * Workspace.ReadWrite.All&lt;br/&gt;To set the permissions scope, see [Register
     * an app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId The workspace id (required)
     * @return ResponseEntity&lt;GroupUsers&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<GroupUsers> groupsGetGroupUsersWithHttpInfo(UUID groupId) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling groupsGetGroupUsers");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        String path = apiClient.expandPath("/v1.0/myorg/groups/{groupId}/users", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<GroupUsers> returnType = new ParameterizedTypeReference<GroupUsers>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Returns a list of workspaces the user has access to. &lt;br/&gt;**Note**:
     * Users that have been recently added to a group may not have their new group
     * immediately available, see [Refresh user
     * permissions](https://docs.microsoft.com/en-us/rest/api/power-bi/users/refreshuserpermissions).&lt;br/&gt;&lt;br/&gt;**Required
     * scope**: Workspace.Read.All or Workspace.ReadWrite.All&lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param $filter Filters the results, based on a boolean condition (optional)
     * @param $top    Returns only the first n results (optional)
     * @param $skip   Skips the first n results (optional)
     * @return Groups
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Groups groupsGetGroups(String $filter, Integer $top, Integer $skip) throws RestClientException {
        return groupsGetGroupsWithHttpInfo($filter, $top, $skip).getBody();
    }

    /**
     * Returns a list of workspaces the user has access to. &lt;br/&gt;**Note**:
     * Users that have been recently added to a group may not have their new group
     * immediately available, see [Refresh user
     * permissions](https://docs.microsoft.com/en-us/rest/api/power-bi/users/refreshuserpermissions).&lt;br/&gt;&lt;br/&gt;**Required
     * scope**: Workspace.Read.All or Workspace.ReadWrite.All&lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param $filter Filters the results, based on a boolean condition (optional)
     * @param $top    Returns only the first n results (optional)
     * @param $skip   Skips the first n results (optional)
     * @return ResponseEntity&lt;Groups&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Groups> groupsGetGroupsWithHttpInfo(String $filter, Integer $top, Integer $skip)
            throws RestClientException {
        Object postBody = null;

        String path = apiClient.expandPath("/v1.0/myorg/groups", Collections.<String, Object>emptyMap());

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "$filter", $filter));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "$top", $top));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "$skip", $skip));

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Groups> returnType = new ParameterizedTypeReference<Groups>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Update the specified user permissions to the specified workspace.
     * &lt;br/&gt;**Notes**: &lt;li&gt; Users permissions that have been recently
     * updated may not have their new permissions immediately updated.
     * &lt;/li&gt;&lt;br/&gt;**Required scope**:
     * Workspace.ReadWrite.All&lt;br/&gt;To set the permissions scope, see [Register
     * an app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId     The workspace id (required)
     * @param userDetails Details of user access right (required)
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public void groupsUpdateGroupUser(UUID groupId, GroupUser userDetails) throws RestClientException {
        groupsUpdateGroupUserWithHttpInfo(groupId, userDetails);
    }

    /**
     * Update the specified user permissions to the specified workspace.
     * &lt;br/&gt;**Notes**: &lt;li&gt; Users permissions that have been recently
     * updated may not have their new permissions immediately updated.
     * &lt;/li&gt;&lt;br/&gt;**Required scope**:
     * Workspace.ReadWrite.All&lt;br/&gt;To set the permissions scope, see [Register
     * an app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId     The workspace id (required)
     * @param userDetails Details of user access right (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Void> groupsUpdateGroupUserWithHttpInfo(UUID groupId, GroupUser userDetails)
            throws RestClientException {
        Object postBody = userDetails;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling groupsUpdateGroupUser");
        }

        // verify the required parameter 'userDetails' is set
        if (userDetails == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'userDetails' when calling groupsUpdateGroupUser");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        String path = apiClient.expandPath("/v1.0/myorg/groups/{groupId}/users", uriVariables);

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
        return apiClient.invokeAPI(path, HttpMethod.PUT, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }
}
