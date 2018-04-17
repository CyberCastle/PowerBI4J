package cl.cc.powerbi.api;

import cl.cc.powerbi.api.model.CloneTileRequest;
import cl.cc.powerbi.api.model.EmbedToken;
import cl.cc.powerbi.api.model.GenerateTokenRequest;
import cl.cc.powerbi.api.model.ODataResponseListTile;
import cl.cc.powerbi.api.model.Tile;
import cl.cc.powerbi.auth.Authenticator;
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
public class TilesApi extends BaseApiAbstract {

    public TilesApi(Authenticator auth) {
        super(auth);
    }

    public TilesApi(String accessToken) {
        super(accessToken);
    }

    /**
     * Clones the specified tile
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param dashboardKey The dashboard id
     * @param tileKey The tile id
     * @param requestParameters Clone tile parameters
     * @return Tile
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public Tile cloneTile(String dashboardKey, String tileKey, CloneTileRequest requestParameters) throws RestClientException {

        // Verify the required parameter 'dashboardKey' is set
        if (dashboardKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'dashboardKey' when calling dashboardsCloneTile");
        }

        // Verify the required parameter 'tileKey' is set
        if (tileKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'tileKey' when calling dashboardsCloneTile");
        }

        // Verify the required parameter 'requestParameters' is set
        if (requestParameters == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'requestParameters' when calling dashboardsCloneTile");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("dashboardKey", dashboardKey);
        uriVariables.put("tileKey", tileKey);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/dashboards/{dashboardKey}/tiles/{tileKey}/Clone").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<Tile> returnType = new ParameterizedTypeReference<Tile>() {
        };
        return this.invokeAPI(path, HttpMethod.POST, null, requestParameters, defaultAccepts, defaultContentTypes, returnType);
    }

    /**
     * Clones the specified tile
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param groupId The group id
     * @param dashboardKey The dashboard id
     * @param tileKey The tile id
     * @param requestParameters Clone tile parameters
     * @return Tile
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public Tile cloneTileInGroup(String groupId, String dashboardKey, String tileKey, CloneTileRequest requestParameters) throws RestClientException {

        // Verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'groupId' when calling dashboardsCloneTileInGroup");
        }

        // Verify the required parameter 'dashboardKey' is set
        if (dashboardKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'dashboardKey' when calling dashboardsCloneTileInGroup");
        }

        // Verify the required parameter 'tileKey' is set
        if (tileKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'tileKey' when calling dashboardsCloneTileInGroup");
        }

        // Verify the required parameter 'requestParameters' is set
        if (requestParameters == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'requestParameters' when calling dashboardsCloneTileInGroup");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("dashboardKey", dashboardKey);
        uriVariables.put("tileKey", tileKey);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/groups/{groupId}/dashboards/{dashboardKey}/tiles/{tileKey}/Clone").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<Tile> returnType = new ParameterizedTypeReference<Tile>() {
        };
        return this.invokeAPI(path, HttpMethod.POST, null, requestParameters, defaultAccepts, defaultContentTypes, returnType);
    }

    /**
     * Get a specified tile in a specified dashboard
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param dashboardKey The dashboard id
     * @param tileKey The tile id
     * @return Tile
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public Tile getTile(String dashboardKey, String tileKey) throws RestClientException {

        // Verify the required parameter 'dashboardKey' is set
        if (dashboardKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'dashboardKey' when calling dashboardsGetTile");
        }

        // Verify the required parameter 'tileKey' is set
        if (tileKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'tileKey' when calling dashboardsGetTile");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("dashboardKey", dashboardKey);
        uriVariables.put("tileKey", tileKey);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/dashboards/{dashboardKey}/tiles/{tileKey}").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<Tile> returnType = new ParameterizedTypeReference<Tile>() {
        };
        return this.invokeAPI(path, HttpMethod.GET, null, null, defaultAccepts, defaultContentTypes, returnType);
    }

    /**
     * Get a specified tile in a specified dashboard in a group
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param groupId The group id
     * @param dashboardKey The dashboard id
     * @param tileKey The tile id
     * @return Tile
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public Tile getTileInGroup(String groupId, String dashboardKey, String tileKey) throws RestClientException {

        // Verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'groupId' when calling dashboardsGetTileInGroup");
        }

        // Verify the required parameter 'dashboardKey' is set
        if (dashboardKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'dashboardKey' when calling dashboardsGetTileInGroup");
        }

        // Verify the required parameter 'tileKey' is set
        if (tileKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'tileKey' when calling dashboardsGetTileInGroup");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("dashboardKey", dashboardKey);
        uriVariables.put("tileKey", tileKey);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/groups/{groupId}/dashboards/{dashboardKey}/tiles/{tileKey}").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<Tile> returnType = new ParameterizedTypeReference<Tile>() {
        };
        return this.invokeAPI(path, HttpMethod.GET, null, null, defaultAccepts, defaultContentTypes, returnType);
    }

    /**
     * Get tiles in the specified dashboard
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param dashboardKey The dashboard id
     * @return ODataResponseListTile
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public ODataResponseListTile getTiles(String dashboardKey) throws RestClientException {

        // Verify the required parameter 'dashboardKey' is set
        if (dashboardKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'dashboardKey' when calling dashboardsGetTiles");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("dashboardKey", dashboardKey);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/dashboards/{dashboardKey}/tiles").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<ODataResponseListTile> returnType = new ParameterizedTypeReference<ODataResponseListTile>() {
        };
        return this.invokeAPI(path, HttpMethod.GET, null, null, defaultAccepts, defaultContentTypes, returnType);
    }

    /**
     * Get tiles in the specified dashboard in a group
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param groupId The group id
     * @param dashboardKey The dashboard id
     * @return ODataResponseListTile
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public ODataResponseListTile getTilesInGroup(String groupId, String dashboardKey) throws RestClientException {

        // Verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'groupId' when calling dashboardsGetTilesInGroup");
        }

        // Verify the required parameter 'dashboardKey' is set
        if (dashboardKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'dashboardKey' when calling dashboardsGetTilesInGroup");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("dashboardKey", dashboardKey);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/groups/{groupId}/dashboards/{dashboardKey}/tiles").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<ODataResponseListTile> returnType = new ParameterizedTypeReference<ODataResponseListTile>() {
        };
        return this.invokeAPI(path, HttpMethod.GET, null, null, defaultAccepts, defaultContentTypes, returnType);
    }

    /**
     * Generate token to view the specified tile
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param dashboardKey The dashboard id
     * @param tileKey The tile id
     * @param requestParameters Generate token parameters
     * @return EmbedToken
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public EmbedToken generateToken(String dashboardKey, String tileKey, GenerateTokenRequest requestParameters) throws RestClientException {

        // Verify the required parameter 'dashboardKey' is set
        if (dashboardKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'dashboardKey' when calling tilesGenerateToken");
        }

        // Verify the required parameter 'tileKey' is set
        if (tileKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'tileKey' when calling tilesGenerateToken");
        }

        // Verify the required parameter 'requestParameters' is set
        if (requestParameters == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'requestParameters' when calling tilesGenerateToken");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("dashboardKey", dashboardKey);
        uriVariables.put("tileKey", tileKey);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/dashboards/{dashboardKey}/tiles/{tileKey}/GenerateToken").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<EmbedToken> returnType = new ParameterizedTypeReference<EmbedToken>() {
        };
        return this.invokeAPI(path, HttpMethod.POST, null, requestParameters, defaultAccepts, defaultContentTypes, returnType);
    }

    /**
     * Generate token to view the specified tile
     *
     * <p>
     * <b>200</b> - OK
     *
     * @param groupId The group id
     * @param dashboardKey The dashboard id
     * @param tileKey The tile id
     * @param requestParameters Generate token parameters
     * @return EmbedToken
     * @throws RestClientException if an error occurs while attempting to invoke
     * the API
     */
    public EmbedToken generateTokenInGroup(String groupId, String dashboardKey, String tileKey, GenerateTokenRequest requestParameters) throws RestClientException {

        // Verify the required parameter 'groupId' is set
        if (groupId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'groupId' when calling tilesGenerateTokenInGroup");
        }

        // Verify the required parameter 'dashboardKey' is set
        if (dashboardKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'dashboardKey' when calling tilesGenerateTokenInGroup");
        }

        // Verify the required parameter 'tileKey' is set
        if (tileKey == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'tileKey' when calling tilesGenerateTokenInGroup");
        }

        // Verify the required parameter 'requestParameters' is set
        if (requestParameters == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'requestParameters' when calling tilesGenerateTokenInGroup");
        }

        // Create path and map variables
        final Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("groupId", groupId);
        uriVariables.put("dashboardKey", dashboardKey);
        uriVariables.put("tileKey", tileKey);
        String path = UriComponentsBuilder.fromPath("/v1.0/myorg/groups/{groupId}/dashboards/{dashboardKey}/tiles/{tileKey}/GenerateToken").buildAndExpand(uriVariables).toUriString();

        ParameterizedTypeReference<EmbedToken> returnType = new ParameterizedTypeReference<EmbedToken>() {
        };
        return this.invokeAPI(path, HttpMethod.POST, null, requestParameters, defaultAccepts, defaultContentTypes, returnType);
    }
}
