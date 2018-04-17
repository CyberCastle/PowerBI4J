package cl.cc.powerbi.api;

import cl.cc.powerbi.api.model.ODataResponseListCapacity;
import cl.cc.powerbi.auth.Authenticator;
import org.springframework.web.client.RestClientException;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;

/**
 *
 * @author CyberCastle
 */
public class CapacitiesApi extends BaseApiAbstract {

    public CapacitiesApi(Authenticator auth) {
        super(auth);
    }

    public CapacitiesApi(String accessToken) {
        super(accessToken);
    }

    /**
     * Gets a list of capacities the user has access to
     *
     * <p>
     * <b>200</b> - OK
     *
     * @return ODataResponseListCapacity
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public ODataResponseListCapacity getCapacities() throws RestClientException {

        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/capacities").build().toUriString();
        ParameterizedTypeReference<ODataResponseListCapacity> returnType = new ParameterizedTypeReference<ODataResponseListCapacity>() {
        };
        return this.invokeAPI(path, HttpMethod.GET, null, null, defaultAccepts, null, returnType);
    }
}
