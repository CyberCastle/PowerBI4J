package cl.cc.powerbi.api;

import cl.cc.powerbi.api.model.ImportInfo;
import cl.cc.powerbi.api.model.Imports;
import cl.cc.powerbi.api.model.ODataResponseListImport;
import cl.cc.powerbi.api.model.TemporaryUploadLocation;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import java.util.HashMap;
import java.util.Map;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 *
 * @author CyberCastle
 */
public class ImportsApi extends BaseApiAbstract {

    public ImportsApi(String accessToken) {
        super(accessToken);
    }

    /**
     * Creates a temporary upload location for large files
     *
     * <p>
     * <b>200</b> - OK
     *
     * @return TemporaryUploadLocation
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public TemporaryUploadLocation createTemporaryUploadLocation() throws RestClientException {

        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/imports/createTemporaryUploadLocation").build().toUriString();
        ParameterizedTypeReference<TemporaryUploadLocation> returnType = new ParameterizedTypeReference<TemporaryUploadLocation>() {
        };
        return this.invokeAPI(path, HttpMethod.POST, null, null, defaultAccepts, null, returnType);
    }

    /**
     * Creates a temporary upload location for large files
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param groupId The group id
     * @return TemporaryUploadLocation
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public TemporaryUploadLocation createTemporaryUploadLocationInGroup(String groupId) throws RestClientException {

        // Verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'groupId' when calling importsCreateTemporaryUploadLocationInGroup");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("groupId", groupId);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/groups/{groupId}/imports/createTemporaryUploadLocation").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<TemporaryUploadLocation> returnType = new ParameterizedTypeReference<TemporaryUploadLocation>() {
        };
        return this.invokeAPI(path, HttpMethod.POST, null, null, defaultAccepts, null, returnType);
    }

    /**
     * Gets the import metadata for the specifed import id
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param importId The import id
     * @return Imports
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public Imports getImportById(String importId) throws RestClientException {

        // Verify the required parameter 'importId' is set
        if (importId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'importId' when calling importsGetImportById");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("importId", importId);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/imports/{importId}").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<Imports> returnType = new ParameterizedTypeReference<Imports>() {
        };
        return this.invokeAPI(path, HttpMethod.GET, null, null, defaultAccepts, null, returnType);
    }

    /**
     * Gets the import metadata for the specifed import id
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param groupId The group id
     * @param importId The import id
     * @return Imports
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public Imports getImportByIdInGroup(String groupId, String importId) throws RestClientException {

        // Verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'groupId' when calling importsGetImportByIdInGroup");
        }

        // Verify the required parameter 'importId' is set
        if (importId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'importId' when calling importsGetImportByIdInGroup");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("importId", importId);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/groups/{groupId}/imports/{importId}").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<Imports> returnType = new ParameterizedTypeReference<Imports>() {
        };
        return this.invokeAPI(path, HttpMethod.GET, null, null, defaultAccepts, null, returnType);
    }

    /**
     * Returns a list of imports
     *
     * <p>
     * <b>200</b> - OK
     *
     * @return ODataResponseListImport
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public ODataResponseListImport getImports() throws RestClientException {

        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/imports").build().toUriString();
        ParameterizedTypeReference<ODataResponseListImport> returnType = new ParameterizedTypeReference<ODataResponseListImport>() {
        };
        return this.invokeAPI(path, HttpMethod.GET, null, null, defaultAccepts, null, returnType);
    }

    /**
     * Returns a list of imports for the specified group
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param groupId The group id
     * @return ODataResponseListImport
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public ODataResponseListImport getImportsInGroup(String groupId) throws RestClientException {

        // Verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'groupId' when calling importsGetImportsInGroup");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("groupId", groupId);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/groups/{groupId}/imports").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<ODataResponseListImport> returnType = new ParameterizedTypeReference<ODataResponseListImport>() {
        };
        return this.invokeAPI(path, HttpMethod.GET, null, null, defaultAccepts, null, returnType);
    }

    /**
     * Creates a new import using the specified import info
     *
     * <p>
     * <b>200</b> - OK
     * <p>
     * <b>202</b> - Accepted
     *
     * @param datasetDisplayName The display name of the dataset
     * @param importInfo The import to post
     * @param nameConflict Determines what to do if a dataset with the same name
     * already exists
     * @return Imports
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public Imports imports(String datasetDisplayName, ImportInfo importInfo, String nameConflict) throws RestClientException {

        // Verify the required parameter 'datasetDisplayName' is set
        if (datasetDisplayName == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'datasetDisplayName' when calling importsPostImport");
        }

        // Verify the required parameter 'importInfo' is set
        if (importInfo == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'importInfo' when calling importsPostImport");
        }

        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/imports").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.putAll(this.parameterToMultiValueMap(null, "datasetDisplayName", datasetDisplayName));
        queryParams.putAll(this.parameterToMultiValueMap(null, "nameConflict", nameConflict));

        ParameterizedTypeReference<Imports> returnType = new ParameterizedTypeReference<Imports>() {
        };
        return this.invokeAPI(path, HttpMethod.POST, queryParams, importInfo, defaultAccepts, defaultContentTypes, returnType);
    }

    /**
     * Creates a new import using the specified import info
     *
     * <p>
     * <b>200</b> - OK
     * <p>
     * <b>202</b> - Accepted
     *
     * @param groupId The group id
     * @param datasetDisplayName The display name of the dataset
     * @param importInfo The import to post
     * @param nameConflict Determines what to do if a dataset with the same name
     * already exists
     * @return Imports
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public Imports importsInGroup(String groupId, String datasetDisplayName, ImportInfo importInfo, String nameConflict) throws RestClientException {

        // Verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'groupId' when calling importsPostImportInGroup");
        }

        // Verify the required parameter 'datasetDisplayName' is set
        if (datasetDisplayName == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'datasetDisplayName' when calling importsPostImportInGroup");
        }

        // Verify the required parameter 'importInfo' is set
        if (importInfo == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'importInfo' when calling importsPostImportInGroup");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("groupId", groupId);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/groups/{groupId}/imports").buildAndExpand(uriVariables).toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.putAll(this.parameterToMultiValueMap(null, "datasetDisplayName", datasetDisplayName));
        queryParams.putAll(this.parameterToMultiValueMap(null, "nameConflict", nameConflict));

        ParameterizedTypeReference<Imports> returnType = new ParameterizedTypeReference<Imports>() {
        };
        return this.invokeAPI(path, HttpMethod.POST, queryParams, importInfo, defaultAccepts, defaultContentTypes, returnType);
    }
}
