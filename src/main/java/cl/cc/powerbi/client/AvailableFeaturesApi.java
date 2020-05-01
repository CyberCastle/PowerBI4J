package cl.cc.powerbi.client;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import cl.cc.powerbi.client.model.AvailableFeature;
import cl.cc.powerbi.client.model.AvailableFeatures;

@Component("cl.cc.powerbi.client.AvailableFeaturesApi")
public class AvailableFeaturesApi {
    private ApiClient apiClient;

    public AvailableFeaturesApi() {
        this(new ApiClient());
    }

    @Autowired
    public AvailableFeaturesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Returns the specified available feature for user by name.
     * &lt;br/&gt;**Required scope**: None
     * <p>
     * <b>200</b> - OK
     * 
     * @param featureName The feature name (required)
     * @return AvailableFeature
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public AvailableFeature availableFeaturesGetAvailableFeatureByName(String featureName) throws RestClientException {
        return availableFeaturesGetAvailableFeatureByNameWithHttpInfo(featureName).getBody();
    }

    /**
     * Returns the specified available feature for user by name.
     * &lt;br/&gt;**Required scope**: None
     * <p>
     * <b>200</b> - OK
     * 
     * @param featureName The feature name (required)
     * @return ResponseEntity&lt;AvailableFeature&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<AvailableFeature> availableFeaturesGetAvailableFeatureByNameWithHttpInfo(String featureName)
            throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'featureName' is set
        if (featureName == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'featureName' when calling availableFeaturesGetAvailableFeatureByName");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("featureName", featureName);
        String path = apiClient.expandPath("/v1.0/myorg/availableFeatures(featureName='{featureName}')", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<AvailableFeature> returnType = new ParameterizedTypeReference<AvailableFeature>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }

    /**
     * Returns a list of available features for the user &lt;br/&gt;**Required
     * scope**: None
     * <p>
     * <b>200</b> - OK
     * 
     * @return AvailableFeatures
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public AvailableFeatures availableFeaturesGetAvailableFeatures() throws RestClientException {
        return availableFeaturesGetAvailableFeaturesWithHttpInfo().getBody();
    }

    /**
     * Returns a list of available features for the user &lt;br/&gt;**Required
     * scope**: None
     * <p>
     * <b>200</b> - OK
     * 
     * @return ResponseEntity&lt;AvailableFeatures&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the
     *                             API
     */
    public ResponseEntity<AvailableFeatures> availableFeaturesGetAvailableFeaturesWithHttpInfo()
            throws RestClientException {
        Object postBody = null;

        String path = apiClient.expandPath("/v1.0/myorg/availableFeatures", Collections.<String, Object>emptyMap());

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "bearerAuth" };

        ParameterizedTypeReference<AvailableFeatures> returnType = new ParameterizedTypeReference<AvailableFeatures>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams,
                accept, contentType, authNames, returnType);
    }
}
