package cl.cc.powerbi.client;

import java.io.File;
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
import cl.cc.powerbi.client.model.ActivityEventResponse;
import cl.cc.powerbi.client.model.AssignWorkspacesToCapacityRequest;
import cl.cc.powerbi.client.model.Capacities;
import cl.cc.powerbi.client.model.CapacityPatchRequest;
import cl.cc.powerbi.client.model.Dashboards;
import cl.cc.powerbi.client.model.Dataflows;
import cl.cc.powerbi.client.model.DatasetToDataflowLinksResponse;
import cl.cc.powerbi.client.model.Datasets;
import cl.cc.powerbi.client.model.Datasources;
import cl.cc.powerbi.client.model.DependentDataflows;
import cl.cc.powerbi.client.model.Group;
import cl.cc.powerbi.client.model.GroupRestoreRequest;
import cl.cc.powerbi.client.model.GroupUser;
import cl.cc.powerbi.client.model.Groups;
import cl.cc.powerbi.client.model.Imports;
import cl.cc.powerbi.client.model.Reports;
import cl.cc.powerbi.client.model.TenantKey;
import cl.cc.powerbi.client.model.TenantKeyCreationRequest;
import cl.cc.powerbi.client.model.TenantKeyRotationRequest;
import cl.cc.powerbi.client.model.TenantKeys;
import cl.cc.powerbi.client.model.Tiles;
import cl.cc.powerbi.client.model.UnassignWorkspacesCapacityRequest;

@Component("cl.cc.powerbi.client.AdminApi")
public class AdminApi {
    private ApiClient apiClient;

    public AdminApi() {
        this(new ApiClient());
    }

    @Autowired
    public AdminApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Adds an encryption key for Power BI workspaces assigned to a capacity.
     * **Note:** The user must have administrator rights (such as Office 365 Global
     * Administrator or Power BI Service Administrator) to call this API.
     * &lt;br/&gt;This API allows 600 requests per hour at maximum.
     * &lt;br/&gt;&lt;br/&gt;**Required scope**: Tenant.Read.All or
     * Tenant.ReadWrite.All&lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param tenantKeyCreationRequest Tenant key information (required)
     * @return TenantKey
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public TenantKey adminAddPowerBIEncryptionKey(TenantKeyCreationRequest tenantKeyCreationRequest)
            throws RestClientException {
        return adminAddPowerBIEncryptionKeyWithHttpInfo(tenantKeyCreationRequest).getBody();
    }

    /**
     * Adds an encryption key for Power BI workspaces assigned to a capacity.
     * **Note:** The user must have administrator rights (such as Office 365 Global
     * Administrator or Power BI Service Administrator) to call this API.
     * &lt;br/&gt;This API allows 600 requests per hour at maximum.
     * &lt;br/&gt;&lt;br/&gt;**Required scope**: Tenant.Read.All or
     * Tenant.ReadWrite.All&lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param tenantKeyCreationRequest Tenant key information (required)
     * @return ResponseEntity&lt;TenantKey&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<TenantKey> adminAddPowerBIEncryptionKeyWithHttpInfo(
            TenantKeyCreationRequest tenantKeyCreationRequest) throws RestClientException {
        Object postBody = tenantKeyCreationRequest;

        // verify the required parameter 'tenantKeyCreationRequest' is set
        if (tenantKeyCreationRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'tenantKeyCreationRequest' when calling adminAddPowerBIEncryptionKey");
        }

        String path = apiClient.expandPath("/v1.0/myorg/admin/tenantKeys", Collections.<String, Object>emptyMap());

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { "application/json" };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<TenantKey> returnType = new ParameterizedTypeReference<TenantKey>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Returns a list of audit activity events for a tenant. **Note:** The user must
     * have administrator rights (such as Office 365 Global Administrator or Power
     * BI Service Administrator) to call this API. &lt;br/&gt;This API allows 200
     * requests per hour at maximum. &lt;br/&gt;&lt;br/&gt;**Required scope**:
     * Tenant.Read.All or Tenant.ReadWrite.All. &lt;br/&gt;To call this API, provide
     * either a continuation token or both a start and end date time. StartDateTime
     * and EndDateTime must be in the same UTC day.
     * <p>
     * <b>200</b> - OK
     * 
     * @param startDateTime     Start date and time of the window for audit event
     *                          results. Must be in ISO 8601 compliant UTC format.
     *                          (optional)
     * @param endDateTime       End date and time of the window for audit event
     *                          results. Must be in ISO 8601 compliant UTC format.
     *                          (optional)
     * @param continuationToken Token required to get the next chunk of the result
     *                          set (optional)
     * @param $filter           Filters the results based on a boolean condition,
     *                          using &#39;Activity&#39;, &#39;UserId&#39;, or both
     *                          properties. Supports only &#39;eq&#39; and
     *                          &#39;and&#39; operators. (optional)
     * @return ActivityEventResponse
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ActivityEventResponse adminGetActivityEvents(String startDateTime, String endDateTime,
            String continuationToken, String $filter) throws RestClientException {
        return adminGetActivityEventsWithHttpInfo(startDateTime, endDateTime, continuationToken, $filter).getBody();
    }

    /**
     * Returns a list of audit activity events for a tenant. **Note:** The user must
     * have administrator rights (such as Office 365 Global Administrator or Power
     * BI Service Administrator) to call this API. &lt;br/&gt;This API allows 200
     * requests per hour at maximum. &lt;br/&gt;&lt;br/&gt;**Required scope**:
     * Tenant.Read.All or Tenant.ReadWrite.All. &lt;br/&gt;To call this API, provide
     * either a continuation token or both a start and end date time. StartDateTime
     * and EndDateTime must be in the same UTC day.
     * <p>
     * <b>200</b> - OK
     * 
     * @param startDateTime     Start date and time of the window for audit event
     *                          results. Must be in ISO 8601 compliant UTC format.
     *                          (optional)
     * @param endDateTime       End date and time of the window for audit event
     *                          results. Must be in ISO 8601 compliant UTC format.
     *                          (optional)
     * @param continuationToken Token required to get the next chunk of the result
     *                          set (optional)
     * @param $filter           Filters the results based on a boolean condition,
     *                          using &#39;Activity&#39;, &#39;UserId&#39;, or both
     *                          properties. Supports only &#39;eq&#39; and
     *                          &#39;and&#39; operators. (optional)
     * @return ResponseEntity&lt;ActivityEventResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<ActivityEventResponse> adminGetActivityEventsWithHttpInfo(String startDateTime,
            String endDateTime, String continuationToken, String $filter) throws RestClientException {
        Object postBody = null;

        String path = apiClient.expandPath("/v1.0/myorg/admin/activityevents", Collections.<String, Object>emptyMap());

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "startDateTime", startDateTime));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "endDateTime", endDateTime));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "continuationToken", continuationToken));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "$filter", $filter));

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<ActivityEventResponse> returnType = new ParameterizedTypeReference<ActivityEventResponse>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Returns a list of capacities for the organization. **Note:** The user must
     * have administrator rights (such as Office 365 Global Administrator or Power
     * BI Service Administrator) to call this API. &lt;br/&gt;&lt;br/&gt;**Required
     * scope**: Tenant.Read.All or Tenant.ReadWrite.All&lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param $expand Expands related entities inline (optional)
     * @return Capacities
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Capacities adminGetCapacitiesAsAdmin(String $expand) throws RestClientException {
        return adminGetCapacitiesAsAdminWithHttpInfo($expand).getBody();
    }

    /**
     * Returns a list of capacities for the organization. **Note:** The user must
     * have administrator rights (such as Office 365 Global Administrator or Power
     * BI Service Administrator) to call this API. &lt;br/&gt;&lt;br/&gt;**Required
     * scope**: Tenant.Read.All or Tenant.ReadWrite.All&lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param $expand Expands related entities inline (optional)
     * @return ResponseEntity&lt;Capacities&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Capacities> adminGetCapacitiesAsAdminWithHttpInfo(String $expand) throws RestClientException {
        Object postBody = null;

        String path = apiClient.expandPath("/v1.0/myorg/admin/capacities", Collections.<String, Object>emptyMap());

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "$expand", $expand));

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
     * Returns the encryption keys for the tenant. **Note:** The user must have
     * administrator rights (such as Office 365 Global Administrator or Power BI
     * Service Administrator) to call this API. &lt;br/&gt;&lt;br/&gt;**Required
     * scope**: Tenant.Read.All or Tenant.ReadWrite.All&lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @return TenantKeys
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public TenantKeys adminGetPowerBIEncryptionKeys() throws RestClientException {
        return adminGetPowerBIEncryptionKeysWithHttpInfo().getBody();
    }

    /**
     * Returns the encryption keys for the tenant. **Note:** The user must have
     * administrator rights (such as Office 365 Global Administrator or Power BI
     * Service Administrator) to call this API. &lt;br/&gt;&lt;br/&gt;**Required
     * scope**: Tenant.Read.All or Tenant.ReadWrite.All&lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @return ResponseEntity&lt;TenantKeys&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<TenantKeys> adminGetPowerBIEncryptionKeysWithHttpInfo() throws RestClientException {
        Object postBody = null;

        String path = apiClient.expandPath("/v1.0/myorg/admin/tenantKeys", Collections.<String, Object>emptyMap());

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<TenantKeys> returnType = new ParameterizedTypeReference<TenantKeys>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Changes the specific capacity information. Currently, only supports changing
     * the capacity encryption key **Note:** The user must have administrator rights
     * (such as Office 365 Global Administrator or Power BI Service Administrator)
     * to call this API. &lt;br/&gt;&lt;br/&gt;**Required scope**: Tenant.Read.All
     * or Tenant.ReadWrite.All&lt;br/&gt;To set the permissions scope, see [Register
     * an app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param capacityId           The capacity Id (required)
     * @param capacityPatchRequest Patch capacity information (required)
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public void adminPatchCapacityAsAdmin(UUID capacityId, CapacityPatchRequest capacityPatchRequest)
            throws RestClientException {
        adminPatchCapacityAsAdminWithHttpInfo(capacityId, capacityPatchRequest);
    }

    /**
     * Changes the specific capacity information. Currently, only supports changing
     * the capacity encryption key **Note:** The user must have administrator rights
     * (such as Office 365 Global Administrator or Power BI Service Administrator)
     * to call this API. &lt;br/&gt;&lt;br/&gt;**Required scope**: Tenant.Read.All
     * or Tenant.ReadWrite.All&lt;br/&gt;To set the permissions scope, see [Register
     * an app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param capacityId           The capacity Id (required)
     * @param capacityPatchRequest Patch capacity information (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Void> adminPatchCapacityAsAdminWithHttpInfo(UUID capacityId,
            CapacityPatchRequest capacityPatchRequest) throws RestClientException {
        Object postBody = capacityPatchRequest;

        // verify the required parameter 'capacityId' is set
        if (capacityId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'capacityId' when calling adminPatchCapacityAsAdmin");
        }

        // verify the required parameter 'capacityPatchRequest' is set
        if (capacityPatchRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'capacityPatchRequest' when calling adminPatchCapacityAsAdmin");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("capacityId", capacityId);
        String path = apiClient.expandPath("/v1.0/myorg/admin/capacities/{capacityId}", uriVariables);

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
     * Rotate the encryption key for Power BI workspaces assigned to a capacity.
     * **Note:** The user must have administrator rights (such as Office 365 Global
     * Administrator or Power BI Service Administrator) to call this API.
     * &lt;br/&gt;This API allows 600 requests per hour at maximum.
     * &lt;br/&gt;&lt;br/&gt;**Required scope**: Tenant.Read.All or
     * Tenant.ReadWrite.All&lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param tenantKeyId              Tenant key id (required)
     * @param tenantKeyRotationRequest Tenant key information (required)
     * @return TenantKey
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public TenantKey adminRotatePowerBIEncryptionKey(UUID tenantKeyId,
            TenantKeyRotationRequest tenantKeyRotationRequest) throws RestClientException {
        return adminRotatePowerBIEncryptionKeyWithHttpInfo(tenantKeyId, tenantKeyRotationRequest).getBody();
    }

    /**
     * Rotate the encryption key for Power BI workspaces assigned to a capacity.
     * **Note:** The user must have administrator rights (such as Office 365 Global
     * Administrator or Power BI Service Administrator) to call this API.
     * &lt;br/&gt;This API allows 600 requests per hour at maximum.
     * &lt;br/&gt;&lt;br/&gt;**Required scope**: Tenant.Read.All or
     * Tenant.ReadWrite.All&lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param tenantKeyId              Tenant key id (required)
     * @param tenantKeyRotationRequest Tenant key information (required)
     * @return ResponseEntity&lt;TenantKey&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<TenantKey> adminRotatePowerBIEncryptionKeyWithHttpInfo(UUID tenantKeyId,
            TenantKeyRotationRequest tenantKeyRotationRequest) throws RestClientException {
        Object postBody = tenantKeyRotationRequest;

        // verify the required parameter 'tenantKeyId' is set
        if (tenantKeyId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'tenantKeyId' when calling adminRotatePowerBIEncryptionKey");
        }

        // verify the required parameter 'tenantKeyRotationRequest' is set
        if (tenantKeyRotationRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'tenantKeyRotationRequest' when calling adminRotatePowerBIEncryptionKey");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("tenantKeyId", tenantKeyId);
        String path = apiClient.expandPath("/v1.0/myorg/admin/tenantKeys/{tenantKeyId}/Default.Rotate", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { "application/json" };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<TenantKey> returnType = new ParameterizedTypeReference<TenantKey>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Assigns the provided workspaces to the specified capacity. **Note:** The user
     * must have administrator rights (such as Office 365 Global Administrator or
     * Power BI Service Administrator) to call this API.
     * &lt;br/&gt;&lt;br/&gt;**Required scope**: Tenant.Read.All or
     * Tenant.ReadWrite.All&lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param requestParameters Admin assign workspaces capacity parameters
     *                          (required)
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public void capacitiesAssignWorkspacesToCapacity(AssignWorkspacesToCapacityRequest requestParameters)
            throws RestClientException {
        capacitiesAssignWorkspacesToCapacityWithHttpInfo(requestParameters);
    }

    /**
     * Assigns the provided workspaces to the specified capacity. **Note:** The user
     * must have administrator rights (such as Office 365 Global Administrator or
     * Power BI Service Administrator) to call this API.
     * &lt;br/&gt;&lt;br/&gt;**Required scope**: Tenant.Read.All or
     * Tenant.ReadWrite.All&lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param requestParameters Admin assign workspaces capacity parameters
     *                          (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Void> capacitiesAssignWorkspacesToCapacityWithHttpInfo(
            AssignWorkspacesToCapacityRequest requestParameters) throws RestClientException {
        Object postBody = requestParameters;

        // verify the required parameter 'requestParameters' is set
        if (requestParameters == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'requestParameters' when calling capacitiesAssignWorkspacesToCapacity");
        }

        String path = apiClient.expandPath("/v1.0/myorg/admin/capacities/AssignWorkspaces",
                Collections.<String, Object>emptyMap());

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
     * Unassigns the provided workspaces from capacity. **Note:** The user must have
     * administrator rights (such as Office 365 Global Administrator or Power BI
     * Service Administrator) to call this API. &lt;br/&gt;&lt;br/&gt;**Required
     * scope**: Tenant.Read.All or Tenant.ReadWrite.All&lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param requestParameters Admin assign workspaces to shared capacity
     *                          parameters (required)
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public void capacitiesUnassignWorkspacesFromCapacity(UnassignWorkspacesCapacityRequest requestParameters)
            throws RestClientException {
        capacitiesUnassignWorkspacesFromCapacityWithHttpInfo(requestParameters);
    }

    /**
     * Unassigns the provided workspaces from capacity. **Note:** The user must have
     * administrator rights (such as Office 365 Global Administrator or Power BI
     * Service Administrator) to call this API. &lt;br/&gt;&lt;br/&gt;**Required
     * scope**: Tenant.Read.All or Tenant.ReadWrite.All&lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param requestParameters Admin assign workspaces to shared capacity
     *                          parameters (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Void> capacitiesUnassignWorkspacesFromCapacityWithHttpInfo(
            UnassignWorkspacesCapacityRequest requestParameters) throws RestClientException {
        Object postBody = requestParameters;

        // verify the required parameter 'requestParameters' is set
        if (requestParameters == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'requestParameters' when calling capacitiesUnassignWorkspacesFromCapacity");
        }

        String path = apiClient.expandPath("/v1.0/myorg/admin/capacities/UnassignWorkspaces",
                Collections.<String, Object>emptyMap());

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
     * Returns a list of dashboards for the organization. **Note:** The user must
     * have administrator rights (such as Office 365 Global Administrator or Power
     * BI Service Administrator) to call this API. &lt;br/&gt;This API allows 200
     * requests per hour at maximum. &lt;br/&gt;&lt;br/&gt;**Required scope**:
     * Tenant.Read.All or Tenant.ReadWrite.All&lt;br/&gt;To set the permissions
     * scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param $expand Expands related entities inline, receives a comma-separated
     *                list of data types. Supported: tiles (optional)
     * @param $filter Filters the results, based on a boolean condition (optional)
     * @param $top    Returns only the first n results (optional)
     * @param $skip   Skips the first n results (optional)
     * @return Dashboards
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Dashboards dashboardsGetDashboardsAsAdmin(String $expand, String $filter, Integer $top, Integer $skip)
            throws RestClientException {
        return dashboardsGetDashboardsAsAdminWithHttpInfo($expand, $filter, $top, $skip).getBody();
    }

    /**
     * Returns a list of dashboards for the organization. **Note:** The user must
     * have administrator rights (such as Office 365 Global Administrator or Power
     * BI Service Administrator) to call this API. &lt;br/&gt;This API allows 200
     * requests per hour at maximum. &lt;br/&gt;&lt;br/&gt;**Required scope**:
     * Tenant.Read.All or Tenant.ReadWrite.All&lt;br/&gt;To set the permissions
     * scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param $expand Expands related entities inline, receives a comma-separated
     *                list of data types. Supported: tiles (optional)
     * @param $filter Filters the results, based on a boolean condition (optional)
     * @param $top    Returns only the first n results (optional)
     * @param $skip   Skips the first n results (optional)
     * @return ResponseEntity&lt;Dashboards&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Dashboards> dashboardsGetDashboardsAsAdminWithHttpInfo(String $expand, String $filter,
            Integer $top, Integer $skip) throws RestClientException {
        Object postBody = null;

        String path = apiClient.expandPath("/v1.0/myorg/admin/dashboards", Collections.<String, Object>emptyMap());

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "$expand", $expand));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "$filter", $filter));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "$top", $top));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "$skip", $skip));

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Dashboards> returnType = new ParameterizedTypeReference<Dashboards>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Returns a list of dashboards from the specified workspace. **Note:** The user
     * must have administrator rights (such as Office 365 Global Administrator or
     * Power BI Service Administrator) to call this API. &lt;br/&gt;This API allows
     * 200 requests per hour at maximum. &lt;br/&gt;&lt;br/&gt;**Required scope**:
     * Tenant.Read.All or Tenant.ReadWrite.All&lt;br/&gt;To set the permissions
     * scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId The workspace id (required)
     * @param $filter Filters the results, based on a boolean condition (optional)
     * @param $top    Returns only the first n results (optional)
     * @param $skip   Skips the first n results (optional)
     * @return Dashboards
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Dashboards dashboardsGetDashboardsInGroupAsAdmin(UUID groupId, String $filter, Integer $top, Integer $skip)
            throws RestClientException {
        return dashboardsGetDashboardsInGroupAsAdminWithHttpInfo(groupId, $filter, $top, $skip).getBody();
    }

    /**
     * Returns a list of dashboards from the specified workspace. **Note:** The user
     * must have administrator rights (such as Office 365 Global Administrator or
     * Power BI Service Administrator) to call this API. &lt;br/&gt;This API allows
     * 200 requests per hour at maximum. &lt;br/&gt;&lt;br/&gt;**Required scope**:
     * Tenant.Read.All or Tenant.ReadWrite.All&lt;br/&gt;To set the permissions
     * scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId The workspace id (required)
     * @param $filter Filters the results, based on a boolean condition (optional)
     * @param $top    Returns only the first n results (optional)
     * @param $skip   Skips the first n results (optional)
     * @return ResponseEntity&lt;Dashboards&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Dashboards> dashboardsGetDashboardsInGroupAsAdminWithHttpInfo(UUID groupId, String $filter,
            Integer $top, Integer $skip) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling dashboardsGetDashboardsInGroupAsAdmin");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        String path = apiClient.expandPath("/v1.0/myorg/admin/groups/{groupId}/dashboards", uriVariables);

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

        ParameterizedTypeReference<Dashboards> returnType = new ParameterizedTypeReference<Dashboards>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Returns a list of tiles within the specified dashboard. **Note:** The user
     * must have administrator rights (such as Office 365 Global Administrator or
     * Power BI Service Administrator) to call this API. &lt;br/&gt;This API allows
     * 200 requests per hour at maximum. &lt;br/&gt;&lt;br/&gt;**Required scope**:
     * Tenant.Read.All or Tenant.ReadWrite.All&lt;br/&gt;To set the permissions
     * scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param dashboardId The dashboard id (required)
     * @return Tiles
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Tiles dashboardsGetTilesAsAdmin(UUID dashboardId) throws RestClientException {
        return dashboardsGetTilesAsAdminWithHttpInfo(dashboardId).getBody();
    }

    /**
     * Returns a list of tiles within the specified dashboard. **Note:** The user
     * must have administrator rights (such as Office 365 Global Administrator or
     * Power BI Service Administrator) to call this API. &lt;br/&gt;This API allows
     * 200 requests per hour at maximum. &lt;br/&gt;&lt;br/&gt;**Required scope**:
     * Tenant.Read.All or Tenant.ReadWrite.All&lt;br/&gt;To set the permissions
     * scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param dashboardId The dashboard id (required)
     * @return ResponseEntity&lt;Tiles&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Tiles> dashboardsGetTilesAsAdminWithHttpInfo(UUID dashboardId) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'dashboardId' is set
        if (dashboardId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'dashboardId' when calling dashboardsGetTilesAsAdmin");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("dashboardId", dashboardId);
        String path = apiClient.expandPath("/v1.0/myorg/admin/dashboards/{dashboardId}/tiles", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Tiles> returnType = new ParameterizedTypeReference<Tiles>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Exports the specified dataflow definition to a .json file. **Note:** The user
     * must have administrator rights (such as Office 365 Global Administrator or
     * Power BI Service Administrator) to call this API.
     * &lt;br/&gt;&lt;br/&gt;**Required scope**:
     * Tenant.Read.All&lt;br/&gt;Application only and delegated permissions are
     * supported.&lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - Exported Json file
     * 
     * @param dataflowId The dataflow id (required)
     * @return File
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public File dataflowsExportDataflowAsAdmin(UUID dataflowId) throws RestClientException {
        return dataflowsExportDataflowAsAdminWithHttpInfo(dataflowId).getBody();
    }

    /**
     * Exports the specified dataflow definition to a .json file. **Note:** The user
     * must have administrator rights (such as Office 365 Global Administrator or
     * Power BI Service Administrator) to call this API.
     * &lt;br/&gt;&lt;br/&gt;**Required scope**:
     * Tenant.Read.All&lt;br/&gt;Application only and delegated permissions are
     * supported.&lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - Exported Json file
     * 
     * @param dataflowId The dataflow id (required)
     * @return ResponseEntity&lt;File&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<File> dataflowsExportDataflowAsAdminWithHttpInfo(UUID dataflowId) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'dataflowId' is set
        if (dataflowId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'dataflowId' when calling dataflowsExportDataflowAsAdmin");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("dataflowId", dataflowId);
        String path = apiClient.expandPath("/v1.0/myorg/admin/dataflows/{dataflowId}/export", uriVariables);

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
     * Returns a list of datasources for the specified dataflow. **Note:** The user
     * must have administrator rights (such as Office 365 Global Administrator or
     * Power BI Service Administrator) to call this API.
     * &lt;br/&gt;&lt;br/&gt;**Required scope**:
     * Tenant.Read.All&lt;br/&gt;Application only and delegated permissions are
     * supported.&lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param dataflowId The dataflow id (required)
     * @return Datasources
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Datasources dataflowsGetDataflowDatasourcesAsAdmin(UUID dataflowId) throws RestClientException {
        return dataflowsGetDataflowDatasourcesAsAdminWithHttpInfo(dataflowId).getBody();
    }

    /**
     * Returns a list of datasources for the specified dataflow. **Note:** The user
     * must have administrator rights (such as Office 365 Global Administrator or
     * Power BI Service Administrator) to call this API.
     * &lt;br/&gt;&lt;br/&gt;**Required scope**:
     * Tenant.Read.All&lt;br/&gt;Application only and delegated permissions are
     * supported.&lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param dataflowId The dataflow id (required)
     * @return ResponseEntity&lt;Datasources&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Datasources> dataflowsGetDataflowDatasourcesAsAdminWithHttpInfo(UUID dataflowId)
            throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'dataflowId' is set
        if (dataflowId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'dataflowId' when calling dataflowsGetDataflowDatasourcesAsAdmin");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("dataflowId", dataflowId);
        String path = apiClient.expandPath("/v1.0/myorg/admin/dataflows/{dataflowId}/datasources", uriVariables);

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
     * Returns a list of dataflows for the organization. **Note:** The user must
     * have administrator rights (such as Office 365 Global Administrator or Power
     * BI Service Administrator) to call this API. &lt;br/&gt;&lt;br/&gt;**Required
     * scope**: Tenant.Read.All or Tenant.ReadWrite.All&lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param $filter Filters the results, based on a boolean condition (optional)
     * @param $top    Returns only the first n results (optional)
     * @param $skip   Skips the first n results (optional)
     * @return Dataflows
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Dataflows dataflowsGetDataflowsAsAdmin(String $filter, Integer $top, Integer $skip)
            throws RestClientException {
        return dataflowsGetDataflowsAsAdminWithHttpInfo($filter, $top, $skip).getBody();
    }

    /**
     * Returns a list of dataflows for the organization. **Note:** The user must
     * have administrator rights (such as Office 365 Global Administrator or Power
     * BI Service Administrator) to call this API. &lt;br/&gt;&lt;br/&gt;**Required
     * scope**: Tenant.Read.All or Tenant.ReadWrite.All&lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param $filter Filters the results, based on a boolean condition (optional)
     * @param $top    Returns only the first n results (optional)
     * @param $skip   Skips the first n results (optional)
     * @return ResponseEntity&lt;Dataflows&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Dataflows> dataflowsGetDataflowsAsAdminWithHttpInfo(String $filter, Integer $top,
            Integer $skip) throws RestClientException {
        Object postBody = null;

        String path = apiClient.expandPath("/v1.0/myorg/admin/dataflows", Collections.<String, Object>emptyMap());

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

        ParameterizedTypeReference<Dataflows> returnType = new ParameterizedTypeReference<Dataflows>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Returns a list of dataflows from the specified workspace. **Note:** The user
     * must have administrator rights (such as Office 365 Global Administrator or
     * Power BI Service Administrator) to call this API.
     * &lt;br/&gt;&lt;br/&gt;**Required scope**: Tenant.Read.All or
     * Tenant.ReadWrite.All&lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId The workspace id (required)
     * @param $filter Filters the results, based on a boolean condition (optional)
     * @param $top    Returns only the first n results (optional)
     * @param $skip   Skips the first n results (optional)
     * @return Dataflows
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Dataflows dataflowsGetDataflowsInGroupAsAdmin(UUID groupId, String $filter, Integer $top, Integer $skip)
            throws RestClientException {
        return dataflowsGetDataflowsInGroupAsAdminWithHttpInfo(groupId, $filter, $top, $skip).getBody();
    }

    /**
     * Returns a list of dataflows from the specified workspace. **Note:** The user
     * must have administrator rights (such as Office 365 Global Administrator or
     * Power BI Service Administrator) to call this API.
     * &lt;br/&gt;&lt;br/&gt;**Required scope**: Tenant.Read.All or
     * Tenant.ReadWrite.All&lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId The workspace id (required)
     * @param $filter Filters the results, based on a boolean condition (optional)
     * @param $top    Returns only the first n results (optional)
     * @param $skip   Skips the first n results (optional)
     * @return ResponseEntity&lt;Dataflows&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Dataflows> dataflowsGetDataflowsInGroupAsAdminWithHttpInfo(UUID groupId, String $filter,
            Integer $top, Integer $skip) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling dataflowsGetDataflowsInGroupAsAdmin");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        String path = apiClient.expandPath("/v1.0/myorg/admin/groups/{groupId}/dataflows", uriVariables);

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

        ParameterizedTypeReference<Dataflows> returnType = new ParameterizedTypeReference<Dataflows>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Returns a list of upstream dataflows for the specified dataflow. **Note:**
     * The user must have administrator rights (such as Office 365 Global
     * Administrator or Power BI Service Administrator) to call this API.
     * &lt;br/&gt;&lt;br/&gt;**Required scope**: Tenant.Read.All or
     * Tenant.ReadWrite.All&lt;br/&gt;To set the permissions scope, see [Register an
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
    public DependentDataflows dataflowsGetUpstreamDataflowsInGroupAsAdmin(UUID groupId, UUID dataflowId)
            throws RestClientException {
        return dataflowsGetUpstreamDataflowsInGroupAsAdminWithHttpInfo(groupId, dataflowId).getBody();
    }

    /**
     * Returns a list of upstream dataflows for the specified dataflow. **Note:**
     * The user must have administrator rights (such as Office 365 Global
     * Administrator or Power BI Service Administrator) to call this API.
     * &lt;br/&gt;&lt;br/&gt;**Required scope**: Tenant.Read.All or
     * Tenant.ReadWrite.All&lt;br/&gt;To set the permissions scope, see [Register an
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
    public ResponseEntity<DependentDataflows> dataflowsGetUpstreamDataflowsInGroupAsAdminWithHttpInfo(UUID groupId,
            UUID dataflowId) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling dataflowsGetUpstreamDataflowsInGroupAsAdmin");
        }

        // verify the required parameter 'dataflowId' is set
        if (dataflowId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'dataflowId' when calling dataflowsGetUpstreamDataflowsInGroupAsAdmin");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("dataflowId", dataflowId);
        String path = apiClient.expandPath(
                "/v1.0/myorg/admin/groups/{groupId}/dataflows/{dataflowId}/upstreamDataflows", uriVariables);

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
     * Returns a list of upstream dataflows for datasets from the specified
     * workspace. **Note:** The user must have administrator rights (such as Office
     * 365 Global Administrator or Power BI Service Administrator) to call this API.
     * &lt;br/&gt;&lt;br/&gt;**Required scope**: Tenant.Read.All or
     * Tenant.ReadWrite.All&lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId The workspace id (required)
     * @return DatasetToDataflowLinksResponse
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public DatasetToDataflowLinksResponse datasetsGetDatasetToDataflowsLinksInGroupAsAdmin(UUID groupId)
            throws RestClientException {
        return datasetsGetDatasetToDataflowsLinksInGroupAsAdminWithHttpInfo(groupId).getBody();
    }

    /**
     * Returns a list of upstream dataflows for datasets from the specified
     * workspace. **Note:** The user must have administrator rights (such as Office
     * 365 Global Administrator or Power BI Service Administrator) to call this API.
     * &lt;br/&gt;&lt;br/&gt;**Required scope**: Tenant.Read.All or
     * Tenant.ReadWrite.All&lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId The workspace id (required)
     * @return ResponseEntity&lt;DatasetToDataflowLinksResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<DatasetToDataflowLinksResponse> datasetsGetDatasetToDataflowsLinksInGroupAsAdminWithHttpInfo(
            UUID groupId) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling datasetsGetDatasetToDataflowsLinksInGroupAsAdmin");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        String path = apiClient.expandPath("/v1.0/myorg/admin/groups/{groupId}/datasets/upstreamDataflows",
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

        ParameterizedTypeReference<DatasetToDataflowLinksResponse> returnType = new ParameterizedTypeReference<DatasetToDataflowLinksResponse>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Returns a list of datasets for the organization. **Note:** The user must have
     * administrator rights (such as Office 365 Global Administrator or Power BI
     * Service Administrator) to call this API. &lt;br/&gt;This API processes each
     * request for 2 seconds, in the mean time other requests will be queued.
     * &lt;br/&gt;&lt;br/&gt;**Required scope**: Tenant.Read.All or
     * Tenant.ReadWrite.All&lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param $filter Filters the results, based on a boolean condition (optional)
     * @param $top    Returns only the first n results (optional)
     * @param $skip   Skips the first n results (optional)
     * @return Datasets
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Datasets datasetsGetDatasetsAsAdmin(String $filter, Integer $top, Integer $skip) throws RestClientException {
        return datasetsGetDatasetsAsAdminWithHttpInfo($filter, $top, $skip).getBody();
    }

    /**
     * Returns a list of datasets for the organization. **Note:** The user must have
     * administrator rights (such as Office 365 Global Administrator or Power BI
     * Service Administrator) to call this API. &lt;br/&gt;This API processes each
     * request for 2 seconds, in the mean time other requests will be queued.
     * &lt;br/&gt;&lt;br/&gt;**Required scope**: Tenant.Read.All or
     * Tenant.ReadWrite.All&lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param $filter Filters the results, based on a boolean condition (optional)
     * @param $top    Returns only the first n results (optional)
     * @param $skip   Skips the first n results (optional)
     * @return ResponseEntity&lt;Datasets&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Datasets> datasetsGetDatasetsAsAdminWithHttpInfo(String $filter, Integer $top, Integer $skip)
            throws RestClientException {
        Object postBody = null;

        String path = apiClient.expandPath("/v1.0/myorg/admin/datasets", Collections.<String, Object>emptyMap());

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

        ParameterizedTypeReference<Datasets> returnType = new ParameterizedTypeReference<Datasets>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Returns a list of datasets from the specified workspace. **Note:** The user
     * must have administrator rights (such as Office 365 Global Administrator or
     * Power BI Service Administrator) to call this API. &lt;br/&gt;This API allows
     * 200 requests per hour at maximum. &lt;br/&gt;&lt;br/&gt;**Required scope**:
     * Tenant.Read.All or Tenant.ReadWrite.All&lt;br/&gt;To set the permissions
     * scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId The workspace id (required)
     * @param $filter Filters the results, based on a boolean condition (optional)
     * @param $top    Returns only the first n results (optional)
     * @param $skip   Skips the first n results (optional)
     * @param $expand Expands related entities inline (optional)
     * @return Datasets
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Datasets datasetsGetDatasetsInGroupAsAdmin(UUID groupId, String $filter, Integer $top, Integer $skip,
            String $expand) throws RestClientException {
        return datasetsGetDatasetsInGroupAsAdminWithHttpInfo(groupId, $filter, $top, $skip, $expand).getBody();
    }

    /**
     * Returns a list of datasets from the specified workspace. **Note:** The user
     * must have administrator rights (such as Office 365 Global Administrator or
     * Power BI Service Administrator) to call this API. &lt;br/&gt;This API allows
     * 200 requests per hour at maximum. &lt;br/&gt;&lt;br/&gt;**Required scope**:
     * Tenant.Read.All or Tenant.ReadWrite.All&lt;br/&gt;To set the permissions
     * scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId The workspace id (required)
     * @param $filter Filters the results, based on a boolean condition (optional)
     * @param $top    Returns only the first n results (optional)
     * @param $skip   Skips the first n results (optional)
     * @param $expand Expands related entities inline (optional)
     * @return ResponseEntity&lt;Datasets&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Datasets> datasetsGetDatasetsInGroupAsAdminWithHttpInfo(UUID groupId, String $filter,
            Integer $top, Integer $skip, String $expand) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling datasetsGetDatasetsInGroupAsAdmin");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        String path = apiClient.expandPath("/v1.0/myorg/admin/groups/{groupId}/datasets", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "$filter", $filter));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "$top", $top));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "$skip", $skip));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "$expand", $expand));

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
     * Returns a list of datasources for the specified dataset. **Note:** The user
     * must have administrator rights (such as Office 365 Global Administrator or
     * Power BI Service Administrator) to call this API. &lt;br/&gt;This API
     * processes each request for 0.5 seconds, in the mean time other requests will
     * be queued. &lt;br/&gt;&lt;br/&gt;**Required scope**:
     * Tenant.Read.All&lt;br/&gt;Application only and delegated permissions are
     * supported.&lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param datasetId (required)
     * @return Datasources
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Datasources datasetsGetDatasourcesAsAdmin(String datasetId) throws RestClientException {
        return datasetsGetDatasourcesAsAdminWithHttpInfo(datasetId).getBody();
    }

    /**
     * Returns a list of datasources for the specified dataset. **Note:** The user
     * must have administrator rights (such as Office 365 Global Administrator or
     * Power BI Service Administrator) to call this API. &lt;br/&gt;This API
     * processes each request for 0.5 seconds, in the mean time other requests will
     * be queued. &lt;br/&gt;&lt;br/&gt;**Required scope**:
     * Tenant.Read.All&lt;br/&gt;Application only and delegated permissions are
     * supported.&lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param datasetId (required)
     * @return ResponseEntity&lt;Datasources&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Datasources> datasetsGetDatasourcesAsAdminWithHttpInfo(String datasetId)
            throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'datasetId' is set
        if (datasetId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'datasetId' when calling datasetsGetDatasourcesAsAdmin");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("datasetId", datasetId);
        String path = apiClient.expandPath("/v1.0/myorg/admin/datasets/{datasetId}/datasources", uriVariables);

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
     * Grants user permissions to the specified workspace. **Note:** This API is
     * currently limited to updating workspaces in the new workspace experience. The
     * user must have administrator rights (such as Office 365 Global Administrator
     * or Power BI Service Administrator) to call this API. &lt;br/&gt;This API
     * allows 200 requests per hour at maximum. &lt;br/&gt;&lt;br/&gt;**Required
     * scope**: Tenant.ReadWrite.All&lt;br/&gt;To set the permissions scope, see
     * [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId     The workspace id (required)
     * @param userDetails Details of user access right (required)
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public void groupsAddUserAsAdmin(UUID groupId, GroupUser userDetails) throws RestClientException {
        groupsAddUserAsAdminWithHttpInfo(groupId, userDetails);
    }

    /**
     * Grants user permissions to the specified workspace. **Note:** This API is
     * currently limited to updating workspaces in the new workspace experience. The
     * user must have administrator rights (such as Office 365 Global Administrator
     * or Power BI Service Administrator) to call this API. &lt;br/&gt;This API
     * allows 200 requests per hour at maximum. &lt;br/&gt;&lt;br/&gt;**Required
     * scope**: Tenant.ReadWrite.All&lt;br/&gt;To set the permissions scope, see
     * [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId     The workspace id (required)
     * @param userDetails Details of user access right (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Void> groupsAddUserAsAdminWithHttpInfo(UUID groupId, GroupUser userDetails)
            throws RestClientException {
        Object postBody = userDetails;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling groupsAddUserAsAdmin");
        }

        // verify the required parameter 'userDetails' is set
        if (userDetails == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'userDetails' when calling groupsAddUserAsAdmin");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        String path = apiClient.expandPath("/v1.0/myorg/admin/groups/{groupId}/users", uriVariables);

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
     * Removes user permissions to the specified workspace. **Note:** This API is
     * currently limited to updating workspaces in the new workspace experience. The
     * user must have administrator rights (such as Office 365 Global Administrator
     * or Power BI Service Administrator) to call this API. &lt;br/&gt;This API
     * allows 200 requests per hour at maximum. &lt;br/&gt;&lt;br/&gt;**Required
     * scope**: Tenant.ReadWrite.All&lt;br/&gt;To set the permissions scope, see
     * [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId The workspace id (required)
     * @param user    The user principal name (UPN) of the user to remove (usually
     *                the user&#39;s email) (required)
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public void groupsDeleteUserAsAdmin(UUID groupId, String user) throws RestClientException {
        groupsDeleteUserAsAdminWithHttpInfo(groupId, user);
    }

    /**
     * Removes user permissions to the specified workspace. **Note:** This API is
     * currently limited to updating workspaces in the new workspace experience. The
     * user must have administrator rights (such as Office 365 Global Administrator
     * or Power BI Service Administrator) to call this API. &lt;br/&gt;This API
     * allows 200 requests per hour at maximum. &lt;br/&gt;&lt;br/&gt;**Required
     * scope**: Tenant.ReadWrite.All&lt;br/&gt;To set the permissions scope, see
     * [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId The workspace id (required)
     * @param user    The user principal name (UPN) of the user to remove (usually
     *                the user&#39;s email) (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Void> groupsDeleteUserAsAdminWithHttpInfo(UUID groupId, String user)
            throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling groupsDeleteUserAsAdmin");
        }

        // verify the required parameter 'user' is set
        if (user == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'user' when calling groupsDeleteUserAsAdmin");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("user", user);
        String path = apiClient.expandPath("/v1.0/myorg/admin/groups/{groupId}/users/{user}", uriVariables);

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
     * Returns a list of workspaces for the organization. **Note:** The user must
     * have administrator rights (such as Office 365 Global Administrator or Power
     * BI Service Administrator) to call this API. &lt;br/&gt;This API allows 200
     * requests per hour at maximum. &lt;br/&gt;&lt;br/&gt;**Required scope**:
     * Tenant.Read.All or Tenant.ReadWrite.All&lt;br/&gt;To set the permissions
     * scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param $top    Returns only the first n results. This parameter is mandatory
     *                and must be in the range of 1-5000. (required)
     * @param $expand Expands related entities inline, receives a comma-separated
     *                list of data types. Supported: users, reports, dashboards,
     *                datasets, dataflows, workbooks (optional)
     * @param $filter Filters the results based on a boolean condition (optional)
     * @param $skip   Skips the first n results. Use with top to fetch results
     *                beyond the first 5000. (optional)
     * @return Groups
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Groups groupsGetGroupsAsAdmin(Integer $top, String $expand, String $filter, Integer $skip)
            throws RestClientException {
        return groupsGetGroupsAsAdminWithHttpInfo($top, $expand, $filter, $skip).getBody();
    }

    /**
     * Returns a list of workspaces for the organization. **Note:** The user must
     * have administrator rights (such as Office 365 Global Administrator or Power
     * BI Service Administrator) to call this API. &lt;br/&gt;This API allows 200
     * requests per hour at maximum. &lt;br/&gt;&lt;br/&gt;**Required scope**:
     * Tenant.Read.All or Tenant.ReadWrite.All&lt;br/&gt;To set the permissions
     * scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param $top    Returns only the first n results. This parameter is mandatory
     *                and must be in the range of 1-5000. (required)
     * @param $expand Expands related entities inline, receives a comma-separated
     *                list of data types. Supported: users, reports, dashboards,
     *                datasets, dataflows, workbooks (optional)
     * @param $filter Filters the results based on a boolean condition (optional)
     * @param $skip   Skips the first n results. Use with top to fetch results
     *                beyond the first 5000. (optional)
     * @return ResponseEntity&lt;Groups&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Groups> groupsGetGroupsAsAdminWithHttpInfo(Integer $top, String $expand, String $filter,
            Integer $skip) throws RestClientException {
        Object postBody = null;

        // verify the required parameter '$top' is set
        if ($top == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter '$top' when calling groupsGetGroupsAsAdmin");
        }

        String path = apiClient.expandPath("/v1.0/myorg/admin/groups", Collections.<String, Object>emptyMap());

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "$expand", $expand));
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
     * Restores a deleted workspace. **Note**: This API is currently limited to
     * restoring workspaces in the new workspace experience. The user must have
     * administrator rights (such as Office 365 Global Administrator or Power BI
     * Service Administrator) to call this API. &lt;br/&gt;This API allows 200
     * requests per hour at maximum. &lt;br/&gt;This API allows 200 requests per
     * hour at maximum. &lt;br/&gt;&lt;br/&gt;**Required scope**:
     * Tenant.ReadWrite.All&lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId             The workspace id (required)
     * @param groupRestoreRequest Details of the group restore request (required)
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public void groupsRestoreDeletedGroupAsAdmin(UUID groupId, GroupRestoreRequest groupRestoreRequest)
            throws RestClientException {
        groupsRestoreDeletedGroupAsAdminWithHttpInfo(groupId, groupRestoreRequest);
    }

    /**
     * Restores a deleted workspace. **Note**: This API is currently limited to
     * restoring workspaces in the new workspace experience. The user must have
     * administrator rights (such as Office 365 Global Administrator or Power BI
     * Service Administrator) to call this API. &lt;br/&gt;This API allows 200
     * requests per hour at maximum. &lt;br/&gt;This API allows 200 requests per
     * hour at maximum. &lt;br/&gt;&lt;br/&gt;**Required scope**:
     * Tenant.ReadWrite.All&lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId             The workspace id (required)
     * @param groupRestoreRequest Details of the group restore request (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Void> groupsRestoreDeletedGroupAsAdminWithHttpInfo(UUID groupId,
            GroupRestoreRequest groupRestoreRequest) throws RestClientException {
        Object postBody = groupRestoreRequest;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling groupsRestoreDeletedGroupAsAdmin");
        }

        // verify the required parameter 'groupRestoreRequest' is set
        if (groupRestoreRequest == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupRestoreRequest' when calling groupsRestoreDeletedGroupAsAdmin");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        String path = apiClient.expandPath("/v1.0/myorg/admin/groups/{groupId}/restore", uriVariables);

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
     * Updates the specified workspace properties. **Note**: This API is currently
     * limited to updating workspaces in the new workspace experience. Only name and
     * description can be updated, and name must be unique inside an organization.
     * The user must have administrator rights (such as Office 365 Global
     * Administrator or Power BI Service Administrator) to call this API.
     * &lt;br/&gt;This API allows 200 requests per hour at maximum.
     * &lt;br/&gt;&lt;br/&gt;**Required scope**: Tenant.ReadWrite.All&lt;br/&gt;To
     * set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId         The workspace id (required)
     * @param groupProperties The properties to update (required)
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public void groupsUpdateGroupAsAdmin(UUID groupId, Group groupProperties) throws RestClientException {
        groupsUpdateGroupAsAdminWithHttpInfo(groupId, groupProperties);
    }

    /**
     * Updates the specified workspace properties. **Note**: This API is currently
     * limited to updating workspaces in the new workspace experience. Only name and
     * description can be updated, and name must be unique inside an organization.
     * The user must have administrator rights (such as Office 365 Global
     * Administrator or Power BI Service Administrator) to call this API.
     * &lt;br/&gt;This API allows 200 requests per hour at maximum.
     * &lt;br/&gt;&lt;br/&gt;**Required scope**: Tenant.ReadWrite.All&lt;br/&gt;To
     * set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId         The workspace id (required)
     * @param groupProperties The properties to update (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Void> groupsUpdateGroupAsAdminWithHttpInfo(UUID groupId, Group groupProperties)
            throws RestClientException {
        Object postBody = groupProperties;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling groupsUpdateGroupAsAdmin");
        }

        // verify the required parameter 'groupProperties' is set
        if (groupProperties == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupProperties' when calling groupsUpdateGroupAsAdmin");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        String path = apiClient.expandPath("/v1.0/myorg/admin/groups/{groupId}", uriVariables);

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

    /**
     * Returns a list of imports for the organization. **Note:** The user must have
     * administrator rights (such as Office 365 Global Administrator or Power BI
     * Service Administrator) to call this API. &lt;br/&gt;&lt;br/&gt;**Required
     * scope**: Tenant.Read.All or Tenant.ReadWrite.All&lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param $expand Expands related entities inline (optional)
     * @param $filter Filters the results, based on a boolean condition (optional)
     * @param $top    Returns only the first n results (optional)
     * @param $skip   Skips the first n results (optional)
     * @return Imports
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Imports importsGetImportsAsAdmin(String $expand, String $filter, Integer $top, Integer $skip)
            throws RestClientException {
        return importsGetImportsAsAdminWithHttpInfo($expand, $filter, $top, $skip).getBody();
    }

    /**
     * Returns a list of imports for the organization. **Note:** The user must have
     * administrator rights (such as Office 365 Global Administrator or Power BI
     * Service Administrator) to call this API. &lt;br/&gt;&lt;br/&gt;**Required
     * scope**: Tenant.Read.All or Tenant.ReadWrite.All&lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param $expand Expands related entities inline (optional)
     * @param $filter Filters the results, based on a boolean condition (optional)
     * @param $top    Returns only the first n results (optional)
     * @param $skip   Skips the first n results (optional)
     * @return ResponseEntity&lt;Imports&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Imports> importsGetImportsAsAdminWithHttpInfo(String $expand, String $filter, Integer $top,
            Integer $skip) throws RestClientException {
        Object postBody = null;

        String path = apiClient.expandPath("/v1.0/myorg/admin/imports", Collections.<String, Object>emptyMap());

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "$expand", $expand));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "$filter", $filter));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "$top", $top));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "$skip", $skip));

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<Imports> returnType = new ParameterizedTypeReference<Imports>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Returns a list of reports for the organization. **Note:** The user must have
     * administrator rights (such as Office 365 Global Administrator or Power BI
     * Service Administrator) to call this API. &lt;br/&gt;&lt;br/&gt;**Required
     * scope**: Tenant.Read.All or Tenant.ReadWrite.All&lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param $filter Filters the results, based on a boolean condition (optional)
     * @param $top    Returns only the first n results (optional)
     * @param $skip   Skips the first n results (optional)
     * @return Reports
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Reports reportsGetReportsAsAdmin(String $filter, Integer $top, Integer $skip) throws RestClientException {
        return reportsGetReportsAsAdminWithHttpInfo($filter, $top, $skip).getBody();
    }

    /**
     * Returns a list of reports for the organization. **Note:** The user must have
     * administrator rights (such as Office 365 Global Administrator or Power BI
     * Service Administrator) to call this API. &lt;br/&gt;&lt;br/&gt;**Required
     * scope**: Tenant.Read.All or Tenant.ReadWrite.All&lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param $filter Filters the results, based on a boolean condition (optional)
     * @param $top    Returns only the first n results (optional)
     * @param $skip   Skips the first n results (optional)
     * @return ResponseEntity&lt;Reports&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Reports> reportsGetReportsAsAdminWithHttpInfo(String $filter, Integer $top, Integer $skip)
            throws RestClientException {
        Object postBody = null;

        String path = apiClient.expandPath("/v1.0/myorg/admin/reports", Collections.<String, Object>emptyMap());

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

        ParameterizedTypeReference<Reports> returnType = new ParameterizedTypeReference<Reports>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Returns a list of reports from the specified workspace. **Note:** The user
     * must have administrator rights (such as Office 365 Global Administrator or
     * Power BI Service Administrator) to call this API. &lt;br/&gt;This API allows
     * 200 requests per hour at maximum. &lt;br/&gt;&lt;br/&gt;**Required scope**:
     * Tenant.Read.All or Tenant.ReadWrite.All&lt;br/&gt;To set the permissions
     * scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId The workspace id (required)
     * @param $filter Filters the results, based on a boolean condition (optional)
     * @param $top    Returns only the first n results (optional)
     * @param $skip   Skips the first n results (optional)
     * @return Reports
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Reports reportsGetReportsInGroupAsAdmin(UUID groupId, String $filter, Integer $top, Integer $skip)
            throws RestClientException {
        return reportsGetReportsInGroupAsAdminWithHttpInfo(groupId, $filter, $top, $skip).getBody();
    }

    /**
     * Returns a list of reports from the specified workspace. **Note:** The user
     * must have administrator rights (such as Office 365 Global Administrator or
     * Power BI Service Administrator) to call this API. &lt;br/&gt;This API allows
     * 200 requests per hour at maximum. &lt;br/&gt;&lt;br/&gt;**Required scope**:
     * Tenant.Read.All or Tenant.ReadWrite.All&lt;br/&gt;To set the permissions
     * scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId The workspace id (required)
     * @param $filter Filters the results, based on a boolean condition (optional)
     * @param $top    Returns only the first n results (optional)
     * @param $skip   Skips the first n results (optional)
     * @return ResponseEntity&lt;Reports&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Reports> reportsGetReportsInGroupAsAdminWithHttpInfo(UUID groupId, String $filter,
            Integer $top, Integer $skip) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling reportsGetReportsInGroupAsAdmin");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        String path = apiClient.expandPath("/v1.0/myorg/admin/groups/{groupId}/reports", uriVariables);

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

        ParameterizedTypeReference<Reports> returnType = new ParameterizedTypeReference<Reports>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }
}
