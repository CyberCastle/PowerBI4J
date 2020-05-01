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
import cl.cc.powerbi.client.model.ImportInfo;
import cl.cc.powerbi.client.model.Imports;
import cl.cc.powerbi.client.model.ModelImport;
import cl.cc.powerbi.client.model.TemporaryUploadLocation;

@Component("cl.cc.powerbi.client.ImportsApi")
public class ImportsApi {
    private ApiClient apiClient;

    public ImportsApi() {
        this(new ApiClient());
    }

    @Autowired
    public ImportsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Creates a temporary blob storage to be used to import large .pbix files
     * larger than 1 GB and up to 10 GB. To import large .pbix files, create a
     * temporary upload location and upload the .pbix file using the shared access
     * signature (SAS) url from the response, and then call [Post
     * Import](/rest/api/power-bi/imports/postimport) and specify &#39;fileUrl&#39;
     * to be the SAS url in the [Request
     * Body](/rest/api/power-bi/imports/postimport#request-body)&lt;br/&gt;&lt;br/&gt;**Note**:
     * Import large .pbix files is only available for workspaces on premium capacity
     * and for .pbix files that are between 1 GB and 10 GB.
     * &lt;br/&gt;&lt;br/&gt;**Required scope**: Dataset.ReadWrite.All &lt;br/&gt;To
     * set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @return TemporaryUploadLocation
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public TemporaryUploadLocation importsCreateTemporaryUploadLocation() throws RestClientException {
        return importsCreateTemporaryUploadLocationWithHttpInfo().getBody();
    }

    /**
     * Creates a temporary blob storage to be used to import large .pbix files
     * larger than 1 GB and up to 10 GB. To import large .pbix files, create a
     * temporary upload location and upload the .pbix file using the shared access
     * signature (SAS) url from the response, and then call [Post
     * Import](/rest/api/power-bi/imports/postimport) and specify &#39;fileUrl&#39;
     * to be the SAS url in the [Request
     * Body](/rest/api/power-bi/imports/postimport#request-body)&lt;br/&gt;&lt;br/&gt;**Note**:
     * Import large .pbix files is only available for workspaces on premium capacity
     * and for .pbix files that are between 1 GB and 10 GB.
     * &lt;br/&gt;&lt;br/&gt;**Required scope**: Dataset.ReadWrite.All &lt;br/&gt;To
     * set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @return ResponseEntity&lt;TemporaryUploadLocation&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<TemporaryUploadLocation> importsCreateTemporaryUploadLocationWithHttpInfo()
            throws RestClientException {
        Object postBody = null;

        String path = apiClient.expandPath("/v1.0/myorg/imports/createTemporaryUploadLocation",
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

        ParameterizedTypeReference<TemporaryUploadLocation> returnType = new ParameterizedTypeReference<TemporaryUploadLocation>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Creates a temporary blob storage to be used to import large .pbix files
     * larger than 1 GB and up to 10 GB. To import large .pbix files, create a
     * temporary upload location and upload the .pbix file using the shared access
     * signature (SAS) url from the response, and then call [Post Import In
     * Group](/rest/api/power-bi/imports/postimportingroup) and specify
     * &#39;fileUrl&#39; to be the SAS url in the [Request
     * Body](/rest/api/power-bi/imports/postimportingroup#request-body).&lt;br/&gt;&lt;br/&gt;**Note**:
     * Import large .pbix files is only available for workspaces on premium capacity
     * and for .pbix files that is between 1 GB and 10 GB.
     * &lt;br/&gt;&lt;br/&gt;**Required scope**: Dataset.ReadWrite.All &lt;br/&gt;To
     * set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId The workspace id (required)
     * @return TemporaryUploadLocation
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public TemporaryUploadLocation importsCreateTemporaryUploadLocationInGroup(UUID groupId)
            throws RestClientException {
        return importsCreateTemporaryUploadLocationInGroupWithHttpInfo(groupId).getBody();
    }

    /**
     * Creates a temporary blob storage to be used to import large .pbix files
     * larger than 1 GB and up to 10 GB. To import large .pbix files, create a
     * temporary upload location and upload the .pbix file using the shared access
     * signature (SAS) url from the response, and then call [Post Import In
     * Group](/rest/api/power-bi/imports/postimportingroup) and specify
     * &#39;fileUrl&#39; to be the SAS url in the [Request
     * Body](/rest/api/power-bi/imports/postimportingroup#request-body).&lt;br/&gt;&lt;br/&gt;**Note**:
     * Import large .pbix files is only available for workspaces on premium capacity
     * and for .pbix files that is between 1 GB and 10 GB.
     * &lt;br/&gt;&lt;br/&gt;**Required scope**: Dataset.ReadWrite.All &lt;br/&gt;To
     * set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId The workspace id (required)
     * @return ResponseEntity&lt;TemporaryUploadLocation&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<TemporaryUploadLocation> importsCreateTemporaryUploadLocationInGroupWithHttpInfo(UUID groupId)
            throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling importsCreateTemporaryUploadLocationInGroup");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        String path = apiClient.expandPath("/v1.0/myorg/groups/{groupId}/imports/createTemporaryUploadLocation",
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

        ParameterizedTypeReference<TemporaryUploadLocation> returnType = new ParameterizedTypeReference<TemporaryUploadLocation>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Returns the specified import from **\&quot;My Workspace\&quot;**.
     * &lt;br/&gt;**Required scope**: Dataset.ReadWrite.All or Dataset.Read.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param importId The import id (required)
     * @return ModelImport
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ModelImport importsGetImport(UUID importId) throws RestClientException {
        return importsGetImportWithHttpInfo(importId).getBody();
    }

    /**
     * Returns the specified import from **\&quot;My Workspace\&quot;**.
     * &lt;br/&gt;**Required scope**: Dataset.ReadWrite.All or Dataset.Read.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param importId The import id (required)
     * @return ResponseEntity&lt;ModelImport&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<ModelImport> importsGetImportWithHttpInfo(UUID importId) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'importId' is set
        if (importId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'importId' when calling importsGetImport");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("importId", importId);
        String path = apiClient.expandPath("/v1.0/myorg/imports/{importId}", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<ModelImport> returnType = new ParameterizedTypeReference<ModelImport>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Returns the specified import from the specified workspace.
     * &lt;br/&gt;**Required scope**: Dataset.ReadWrite.All or Dataset.Read.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId  The workspace id (required)
     * @param importId The import id (required)
     * @return ModelImport
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ModelImport importsGetImportInGroup(UUID groupId, UUID importId) throws RestClientException {
        return importsGetImportInGroupWithHttpInfo(groupId, importId).getBody();
    }

    /**
     * Returns the specified import from the specified workspace.
     * &lt;br/&gt;**Required scope**: Dataset.ReadWrite.All or Dataset.Read.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId  The workspace id (required)
     * @param importId The import id (required)
     * @return ResponseEntity&lt;ModelImport&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<ModelImport> importsGetImportInGroupWithHttpInfo(UUID groupId, UUID importId)
            throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling importsGetImportInGroup");
        }

        // verify the required parameter 'importId' is set
        if (importId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'importId' when calling importsGetImportInGroup");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("importId", importId);
        String path = apiClient.expandPath("/v1.0/myorg/groups/{groupId}/imports/{importId}", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<ModelImport> returnType = new ParameterizedTypeReference<ModelImport>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Returns a list of imports from **\&quot;My Workspace\&quot;**.
     * &lt;br/&gt;**Required scope**: Dataset.ReadWrite.All or Dataset.Read.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @return Imports
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Imports importsGetImports() throws RestClientException {
        return importsGetImportsWithHttpInfo().getBody();
    }

    /**
     * Returns a list of imports from **\&quot;My Workspace\&quot;**.
     * &lt;br/&gt;**Required scope**: Dataset.ReadWrite.All or Dataset.Read.All
     * &lt;br/&gt;To set the permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).
     * <p>
     * <b>200</b> - OK
     * 
     * @return ResponseEntity&lt;Imports&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Imports> importsGetImportsWithHttpInfo() throws RestClientException {
        Object postBody = null;

        String path = apiClient.expandPath("/v1.0/myorg/imports", Collections.<String, Object>emptyMap());

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

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
     * Returns a list of imports from the specified workspace. &lt;br/&gt;**Required
     * scope**: Dataset.ReadWrite.All or Dataset.Read.All &lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).&lt;li&gt;Import
     * .pbix file from OneDrive is not supported.&lt;/li&gt;
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId The workspace id (required)
     * @return Imports
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public Imports importsGetImportsInGroup(UUID groupId) throws RestClientException {
        return importsGetImportsInGroupWithHttpInfo(groupId).getBody();
    }

    /**
     * Returns a list of imports from the specified workspace. &lt;br/&gt;**Required
     * scope**: Dataset.ReadWrite.All or Dataset.Read.All &lt;br/&gt;To set the
     * permissions scope, see [Register an
     * app](https://docs.microsoft.com/power-bi/developer/register-app).&lt;li&gt;Import
     * .pbix file from OneDrive is not supported.&lt;/li&gt;
     * <p>
     * <b>200</b> - OK
     * 
     * @param groupId The workspace id (required)
     * @return ResponseEntity&lt;Imports&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<Imports> importsGetImportsInGroupWithHttpInfo(UUID groupId) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling importsGetImportsInGroup");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        String path = apiClient.expandPath("/v1.0/myorg/groups/{groupId}/imports", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

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
     * Creates new content on **\&quot;My Workspace\&quot;** from .pbix, Excel, Rdl
     * or file path in OneDrive for Business. &lt;br/&gt;**Required scope**:
     * Dataset.ReadWrite.All &lt;br/&gt;To set the permissions scope, see [Register
     * an app](https://docs.microsoft.com/power-bi/developer/register-app).
     * &lt;h3&gt;Notes&lt;/h3&gt;&lt;ul&gt;&lt;li&gt;To import a file, request
     * Headers should include **Content-Type: multipart/form-data** with the file
     * [encoded as form data](https://www.w3.org/TR/html401/interact/forms.html) in
     * the request body. &lt;/li&gt;&lt;li&gt;To import xlsx file from OneDrive for
     * Business, request Headers should include **Content-Type: application/json**
     * with [ImportInfo](/rest/api/power-bi/imports/postimport#importinfo) in the
     * request body.&lt;/li&gt;&lt;li&gt;Import .pbix file from OneDrive is not
     * supported.&lt;/li&gt;&lt;li&gt;To import large .pbix files between 1 GB and
     * 10 GB, see [Create Temporary Upload
     * Location](/rest/api/power-bi/imports/createtemporaryuploadlocation),
     * supported only for workspaces on premium capacity.&lt;/li&gt;&lt;/ul&gt;
     * <p>
     * <b>200</b> - OK
     * <p>
     * <b>202</b> - Accepted
     * 
     * @param datasetDisplayName The display name of the dataset, should include
     *                           file extension. Not supported when importing from
     *                           OneDrive for Business. (required)
     * @param importInfo         The import to post (required)
     * @param nameConflict       Determines what to do if a dataset with the same
     *                           name already exists. Default value is
     *                           &#39;Ignore&#39;.&lt;br/&gt;Only Abort and
     *                           Overwrite are supported with Rdl files. (optional)
     * @param skipReport         Determines whether to skip report import, if
     *                           specified value must be &#39;true&#39;. Only
     *                           supported for PBIX files. (optional)
     * @return ModelImport
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ModelImport importsPostImport(String datasetDisplayName, ImportInfo importInfo, String nameConflict,
            Boolean skipReport) throws RestClientException {
        return importsPostImportWithHttpInfo(datasetDisplayName, importInfo, nameConflict, skipReport).getBody();
    }

    /**
     * Creates new content on **\&quot;My Workspace\&quot;** from .pbix, Excel, Rdl
     * or file path in OneDrive for Business. &lt;br/&gt;**Required scope**:
     * Dataset.ReadWrite.All &lt;br/&gt;To set the permissions scope, see [Register
     * an app](https://docs.microsoft.com/power-bi/developer/register-app).
     * &lt;h3&gt;Notes&lt;/h3&gt;&lt;ul&gt;&lt;li&gt;To import a file, request
     * Headers should include **Content-Type: multipart/form-data** with the file
     * [encoded as form data](https://www.w3.org/TR/html401/interact/forms.html) in
     * the request body. &lt;/li&gt;&lt;li&gt;To import xlsx file from OneDrive for
     * Business, request Headers should include **Content-Type: application/json**
     * with [ImportInfo](/rest/api/power-bi/imports/postimport#importinfo) in the
     * request body.&lt;/li&gt;&lt;li&gt;Import .pbix file from OneDrive is not
     * supported.&lt;/li&gt;&lt;li&gt;To import large .pbix files between 1 GB and
     * 10 GB, see [Create Temporary Upload
     * Location](/rest/api/power-bi/imports/createtemporaryuploadlocation),
     * supported only for workspaces on premium capacity.&lt;/li&gt;&lt;/ul&gt;
     * <p>
     * <b>200</b> - OK
     * <p>
     * <b>202</b> - Accepted
     * 
     * @param datasetDisplayName The display name of the dataset, should include
     *                           file extension. Not supported when importing from
     *                           OneDrive for Business. (required)
     * @param importInfo         The import to post (required)
     * @param nameConflict       Determines what to do if a dataset with the same
     *                           name already exists. Default value is
     *                           &#39;Ignore&#39;.&lt;br/&gt;Only Abort and
     *                           Overwrite are supported with Rdl files. (optional)
     * @param skipReport         Determines whether to skip report import, if
     *                           specified value must be &#39;true&#39;. Only
     *                           supported for PBIX files. (optional)
     * @return ResponseEntity&lt;ModelImport&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<ModelImport> importsPostImportWithHttpInfo(String datasetDisplayName, ImportInfo importInfo,
            String nameConflict, Boolean skipReport) throws RestClientException {
        Object postBody = importInfo;

        // verify the required parameter 'datasetDisplayName' is set
        if (datasetDisplayName == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'datasetDisplayName' when calling importsPostImport");
        }

        // verify the required parameter 'importInfo' is set
        if (importInfo == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'importInfo' when calling importsPostImport");
        }

        String path = apiClient.expandPath("/v1.0/myorg/imports", Collections.<String, Object>emptyMap());

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "datasetDisplayName", datasetDisplayName));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "nameConflict", nameConflict));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "skipReport", skipReport));

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { "application/json", "multipart/form-data" };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<ModelImport> returnType = new ParameterizedTypeReference<ModelImport>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Creates new content on the specified workspace from .pbix, .json, Excel, Rdl,
     * or file path in OneDrive for Business. &lt;br/&gt;**Required scope**:
     * Dataset.ReadWrite.All &lt;br/&gt;To set the permissions scope, see [Register
     * an app](https://docs.microsoft.com/power-bi/developer/register-app).
     * &lt;h3&gt;Notes&lt;/h3&gt;&lt;ul&gt;&lt;li&gt;To import a file, request
     * Headers should include **Content-Type: multipart/form-data** with the file
     * [encoded as form data](https://www.w3.org/TR/html401/interact/forms.html) in
     * the request body &lt;/li&gt;&lt;li&gt;To import from OneDrive for Business,
     * request Headers should include **Content-Type: application/json** with
     * [ImportInfo](/rest/api/power-bi/imports/postimportingroup#importinfo) in the
     * request body.&lt;/li&gt;&lt;li&gt;To import large .pbix files between 1 GB
     * and 10 GB see [Create Temporary Upload Location In
     * Group](/rest/api/power-bi/imports/createtemporaryuploadlocationingroup),
     * supported only for workspaces on premium capacity.&lt;/li&gt;&lt;li&gt;To
     * create a dataflow from a model.json, specify the parameter datasetDisplayName
     * as described below.&lt;/li&gt;&lt;/ul&gt;
     * <p>
     * <b>200</b> - OK
     * <p>
     * <b>202</b> - Accepted
     * 
     * @param groupId            The workspace id (required)
     * @param datasetDisplayName The display name of the dataset should include file
     *                           extension. Not supported when importing from
     *                           OneDrive for Business. For importing or creating
     *                           dataflows, this parameter should be hardcoded to
     *                           model.json. (required)
     * @param importInfo         The import to post (required)
     * @param nameConflict       Determines what to do if a dataset with the same
     *                           name already exists. Default value is
     *                           &#39;Ignore&#39;.&lt;br/&gt;Only Abort and
     *                           Overwrite are supported with Rdl
     *                           files.&lt;br/&gt;Only Abort and GenerateUniqueName
     *                           are supported with dataflow model.json files.
     *                           (optional)
     * @param skipReport         Determines whether to skip report import, if
     *                           specified value must be &#39;true&#39;. Only
     *                           supported for PBIX files. (optional)
     * @return ModelImport
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ModelImport importsPostImportInGroup(UUID groupId, String datasetDisplayName, ImportInfo importInfo,
            String nameConflict, Boolean skipReport) throws RestClientException {
        return importsPostImportInGroupWithHttpInfo(groupId, datasetDisplayName, importInfo, nameConflict, skipReport)
                .getBody();
    }

    /**
     * Creates new content on the specified workspace from .pbix, .json, Excel, Rdl,
     * or file path in OneDrive for Business. &lt;br/&gt;**Required scope**:
     * Dataset.ReadWrite.All &lt;br/&gt;To set the permissions scope, see [Register
     * an app](https://docs.microsoft.com/power-bi/developer/register-app).
     * &lt;h3&gt;Notes&lt;/h3&gt;&lt;ul&gt;&lt;li&gt;To import a file, request
     * Headers should include **Content-Type: multipart/form-data** with the file
     * [encoded as form data](https://www.w3.org/TR/html401/interact/forms.html) in
     * the request body &lt;/li&gt;&lt;li&gt;To import from OneDrive for Business,
     * request Headers should include **Content-Type: application/json** with
     * [ImportInfo](/rest/api/power-bi/imports/postimportingroup#importinfo) in the
     * request body.&lt;/li&gt;&lt;li&gt;To import large .pbix files between 1 GB
     * and 10 GB see [Create Temporary Upload Location In
     * Group](/rest/api/power-bi/imports/createtemporaryuploadlocationingroup),
     * supported only for workspaces on premium capacity.&lt;/li&gt;&lt;li&gt;To
     * create a dataflow from a model.json, specify the parameter datasetDisplayName
     * as described below.&lt;/li&gt;&lt;/ul&gt;
     * <p>
     * <b>200</b> - OK
     * <p>
     * <b>202</b> - Accepted
     * 
     * @param groupId            The workspace id (required)
     * @param datasetDisplayName The display name of the dataset should include file
     *                           extension. Not supported when importing from
     *                           OneDrive for Business. For importing or creating
     *                           dataflows, this parameter should be hardcoded to
     *                           model.json. (required)
     * @param importInfo         The import to post (required)
     * @param nameConflict       Determines what to do if a dataset with the same
     *                           name already exists. Default value is
     *                           &#39;Ignore&#39;.&lt;br/&gt;Only Abort and
     *                           Overwrite are supported with Rdl
     *                           files.&lt;br/&gt;Only Abort and GenerateUniqueName
     *                           are supported with dataflow model.json files.
     *                           (optional)
     * @param skipReport         Determines whether to skip report import, if
     *                           specified value must be &#39;true&#39;. Only
     *                           supported for PBIX files. (optional)
     * @return ResponseEntity&lt;ModelImport&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<ModelImport> importsPostImportInGroupWithHttpInfo(UUID groupId, String datasetDisplayName,
            ImportInfo importInfo, String nameConflict, Boolean skipReport) throws RestClientException {
        Object postBody = importInfo;

        // verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'groupId' when calling importsPostImportInGroup");
        }

        // verify the required parameter 'datasetDisplayName' is set
        if (datasetDisplayName == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'datasetDisplayName' when calling importsPostImportInGroup");
        }

        // verify the required parameter 'importInfo' is set
        if (importInfo == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'importInfo' when calling importsPostImportInGroup");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("groupId", groupId);
        String path = apiClient.expandPath("/v1.0/myorg/groups/{groupId}/imports", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "datasetDisplayName", datasetDisplayName));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "nameConflict", nameConflict));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "skipReport", skipReport));

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { "application/json", "multipart/form-data" };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<ModelImport> returnType = new ParameterizedTypeReference<ModelImport>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }
}
