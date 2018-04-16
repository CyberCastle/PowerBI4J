package cl.cc.powerbi.api;

import cl.cc.powerbi.api.model.Gateway;
import cl.cc.powerbi.api.model.ODataResponseListGateway;
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
public class GatewaysApi extends BaseApiAbstract {

    public GatewaysApi(String accessToken) {
        super(accessToken);
    }

    /**
     * Gets a list of gateways to bind
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param datasetKey The dataset id
     * @return ODataResponseListGateway
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public ODataResponseListGateway discoverGateways(String datasetKey) throws RestClientException {

        // Verify the required parameter 'datasetKey' is set
        if (datasetKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'datasetKey' when calling datasetsDiscoverGateways");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("datasetKey", datasetKey);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/datasets/{datasetKey}/Default.DiscoverGateways").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<ODataResponseListGateway> returnType = new ParameterizedTypeReference<ODataResponseListGateway>() {
        };
        return this.invokeAPI(path, HttpMethod.GET, null, null, null, null, returnType);
    }

    /**
     * Gets a list of gateways to bind
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param groupId The group id
     * @param datasetKey The dataset id
     * @return ODataResponseListGateway
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public ODataResponseListGateway discoverGatewaysInGroup(String groupId, String datasetKey) throws RestClientException {

        // Verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'groupId' when calling datasetsDiscoverGatewaysInGroup");
        }

        // Verify the required parameter 'datasetKey' is set
        if (datasetKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'datasetKey' when calling datasetsDiscoverGatewaysInGroup");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("datasetKey", datasetKey);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/groups/{groupId}/datasets/{datasetKey}/Default.DiscoverGateways").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<ODataResponseListGateway> returnType = new ParameterizedTypeReference<ODataResponseListGateway>() {
        };
        return this.invokeAPI(path, HttpMethod.GET, null, null, defaultAccepts, null, returnType);
    }

    /**
     * Returns the specified gateway
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param gatewayId The gateway id
     * @return Gateway
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public Gateway getGatewayById(String gatewayId) throws RestClientException {

        // Verify the required parameter 'gatewayId' is set
        if (gatewayId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'gatewayId' when calling gatewaysGetGatewayById");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("gatewayId", gatewayId);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/gateways/{gatewayId}").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<Gateway> returnType = new ParameterizedTypeReference<Gateway>() {
        };
        return this.invokeAPI(path, HttpMethod.GET, null, null, defaultAccepts, null, returnType);
    }

    /**
     * Returns a list of gateways
     *
     * <p>
     * <b>200</b> - OK
     *
     * @return ODataResponseListGateway
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public ODataResponseListGateway getGateways() throws RestClientException {

        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/gateways").build().toUriString();
        ParameterizedTypeReference<ODataResponseListGateway> returnType = new ParameterizedTypeReference<ODataResponseListGateway>() {
        };
        return this.invokeAPI(path, HttpMethod.GET, null, null, defaultAccepts, null, returnType);
    }
}
