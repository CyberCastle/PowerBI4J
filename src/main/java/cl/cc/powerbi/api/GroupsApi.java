package cl.cc.powerbi.api;


import cl.cc.powerbi.api.model.AssignToCapacityRequest;
import cl.cc.powerbi.api.model.Group;
import cl.cc.powerbi.api.model.GroupCreationRequest;
import cl.cc.powerbi.api.model.GroupUserAccessRight;
import cl.cc.powerbi.api.model.ODataResponseListGroup;
import cl.cc.powerbi.api.model.ODataResponseListGroupUserAccessRight;
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
public class GroupsApi extends BaseApiAbstract {

    public GroupsApi(String accessToken) {
        super(accessToken);
    }

    /**
     * Add a group user
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param groupId The group id
     * @param userDetails user access right details
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public Object addGroupUser(String groupId, GroupUserAccessRight userDetails) throws RestClientException {

        // Verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'groupId' when calling groupsAddGroupUser");
        }

        // Verify the required parameter 'userDetails' is set
        if (userDetails == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'userDetails' when calling groupsAddGroupUser");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("groupId", groupId);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/groups/{groupId}/users").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {
        };

        return this.invokeAPI(path, HttpMethod.POST, null, userDetails, null, defaultContentTypes, returnType);
    }

    /**
     * Assign My Workspace to a capacity
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param requestParameters Assign to capacity parameters
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public Object assignMyWorkspaceToCapacity(AssignToCapacityRequest requestParameters) throws RestClientException {

        // Verify the required parameter 'requestParameters' is set
        if (requestParameters == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'requestParameters' when calling groupsAssignMyWorkspaceToCapacity");
        }

        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/AssignToCapacity").build().toUriString();
        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {
        };
        return this.invokeAPI(path, HttpMethod.POST, null, requestParameters, null, defaultContentTypes, returnType);
    }

    /**
     * Assign a group to a capacity
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param groupId The group id
     * @param requestParameters Assign to capacity parameters
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public Object assignToCapacity(String groupId, AssignToCapacityRequest requestParameters) throws RestClientException {

        // Verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'groupId' when calling groupsAssignToCapacity");
        }

        // Verify the required parameter 'requestParameters' is set
        if (requestParameters == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'requestParameters' when calling groupsAssignToCapacity");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("groupId", groupId);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/groups/{groupId}/AssignToCapacity").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {
        };
        return this.invokeAPI(path, HttpMethod.POST, null, requestParameters, null, defaultContentTypes, returnType);
    }

    /**
     * Create new group
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param requestParameters Create group request parameters
     * @return Group
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public Group createGroup(GroupCreationRequest requestParameters) throws RestClientException {

        // Verify the required parameter 'requestParameters' is set
        if (requestParameters == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'requestParameters' when calling groupsCreateGroup");
        }

        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/groups").build().toUriString();
        ParameterizedTypeReference<Group> returnType = new ParameterizedTypeReference<Group>() {
        };
        return this.invokeAPI(path, HttpMethod.POST, null, requestParameters, defaultAccepts, defaultContentTypes, returnType);
    }

    /**
     * Deletes the specified group
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param groupId The group id to delete
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public Object deleteGroup(String groupId) throws RestClientException {

        // Verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'groupId' when calling groupsDeleteGroup");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("groupId", groupId);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/groups/{groupId}").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {
        };
        return this.invokeAPI(path, HttpMethod.DELETE, null, null, null, null, returnType);
    }

    /**
     * Deletes the specified group
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param groupId The group id
     * @param user The user email to delete
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public Object deleteUserInGroup(String groupId, String user) throws RestClientException {

        // Verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'groupId' when calling groupsDeleteUserInGroup");
        }

        // Verify the required parameter 'user' is set
        if (user == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'user' when calling groupsDeleteUserInGroup");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("user", user);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/groups/{groupId}/users/{user}").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {
        };
        return this.invokeAPI(path, HttpMethod.DELETE, null, null, null, null, returnType);
    }

    /**
     * Get a group users list
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param groupId The group id
     * @return ODataResponseListGroupUserAccessRight
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public ODataResponseListGroupUserAccessRight getGroupUsers(String groupId) throws RestClientException {

        // Verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'groupId' when calling groupsGetGroupUsers");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("groupId", groupId);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/groups/{groupId}/users").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<ODataResponseListGroupUserAccessRight> returnType = new ParameterizedTypeReference<ODataResponseListGroupUserAccessRight>() {
        };
        return this.invokeAPI(path, HttpMethod.GET, null, null, defaultAccepts, null, returnType);
    }

    /**
     * Returns a list of groups
     *
     * <p>
     * <b>200</b> - OK
     *
     * @return ODataResponseListGroup
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public ODataResponseListGroup getGroups() throws RestClientException {

        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/groups").build().toUriString();
        ParameterizedTypeReference<ODataResponseListGroup> returnType = new ParameterizedTypeReference<ODataResponseListGroup>() {
        };
        return this.invokeAPI(path, HttpMethod.GET, null, null, defaultAccepts, null, returnType);
    }
}
