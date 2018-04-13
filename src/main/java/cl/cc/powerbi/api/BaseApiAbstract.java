package cl.cc.powerbi.api;

import cl.cc.utils.ISO8601Utils;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author CyberCastle
 */
public abstract class BaseApiAbstract {

    protected static final MediaType defaultContentTypes = MediaType.APPLICATION_JSON;
    protected static final MediaType[] defaultAccepts = {MediaType.APPLICATION_JSON};

    private static final String BASE_PATH = "https://api.powerbi.com";
    private final RestTemplate restTemplate;
    private HttpStatus statusCode;
    private MultiValueMap<String, String> responseHeaders;

    // Authorization token for services access
    private final String accessToken;

    public BaseApiAbstract(String accessToken) {
        this.accessToken = accessToken;
        this.restTemplate = new RestTemplate();

        List<HttpMessageConverter<?>> converters = this.restTemplate.getMessageConverters();
        converters
                .stream()
                .filter((converter) -> (converter instanceof MappingJackson2HttpMessageConverter))
                .map((converter) -> ((MappingJackson2HttpMessageConverter) converter)
                .getObjectMapper())
                .forEachOrdered((mapper) -> {
                    mapper.setSerializationInclusion(Include.NON_NULL);
                });

        converters.add(new ResourceHttpMessageConverter());

        // This allows us to read the response more than once - Necessary for debugging.
        restTemplate.setRequestFactory(new BufferingClientHttpRequestFactory(restTemplate.getRequestFactory()));
    }

    /**
     * Gets the status code of the previous request
     *
     * @return HttpStatus the status code
     */
    public HttpStatus getStatusCode() {
        return statusCode;
    }

    /**
     * Gets the response headers of the previous request
     *
     * @return MultiValueMap a map of response headers
     */
    public MultiValueMap<String, String> getResponseHeaders() {
        return responseHeaders;
    }

    public void setDebugging(boolean debugging) {
        List<ClientHttpRequestInterceptor> currentInterceptors = this.restTemplate.getInterceptors();
        if (debugging) {
            if (currentInterceptors == null) {
                currentInterceptors = new ArrayList<>();
            }
            ClientHttpRequestInterceptor interceptor = new ApiClientHttpRequestInterceptor();
            currentInterceptors.add(interceptor);
            this.restTemplate.setInterceptors(currentInterceptors);
        } else {
            if (currentInterceptors != null &&  ! currentInterceptors.isEmpty()) {
                Iterator<ClientHttpRequestInterceptor> iter = currentInterceptors.iterator();
                while (iter.hasNext()) {
                    ClientHttpRequestInterceptor interceptor = iter.next();
                    if (interceptor instanceof ApiClientHttpRequestInterceptor) {
                        iter.remove();
                    }
                }
                this.restTemplate.setInterceptors(currentInterceptors);
            }
        }
    }

    /**
     * Format the given parameter object into string.
     *
     * @param param the object to convert
     * @return String the parameter represented as a String
     */
    @SuppressWarnings("unchecked")
    protected String parameterToString(Object param) {
        if (param == null) {
            return "";
        } else if (param instanceof Date) {

            // Use RFC3339 format for date and datetime.
            // See http://xml2rfc.ietf.org/public/rfc/html/rfc3339.html#anchor14
            return ISO8601Utils.format((Date) param, true);
        } else if (param instanceof Collection) {
            StringBuilder b = new StringBuilder();
            ((Collection) param).forEach((obj) -> {
                if (b.length() > 0) {
                    b.append(",");
                }
                b.append(String.valueOf(obj));
            });
            return b.toString();
        } else {
            return String.valueOf(param);
        }
    }

    /**
     * Converts a parameter to a {@link MultiValueMap} for use in REST requests
     *
     * @param collectionFormat The format to convert to
     * @param name The name of the parameter
     * @param value The parameter's value
     * @return a Map containing the String value(s) of the input parameter
     */
    protected MultiValueMap<String, String> parameterToMultiValueMap(CollectionFormat collectionFormat, String name, Object value) {
        final MultiValueMap<String, String> params = new LinkedMultiValueMap<>();

        if (name == null || name.isEmpty() || value == null) {
            return params;
        }

        if (collectionFormat == null) {
            collectionFormat = CollectionFormat.CSV;
        }

        Collection<?> valueCollection;
        if (value instanceof Collection) {
            valueCollection = (Collection<?>) value;
        } else {
            params.add(name, parameterToString(value));
            return params;
        }

        if (valueCollection.isEmpty()) {
            return params;
        }

        if (collectionFormat.equals(CollectionFormat.MULTI)) {
            valueCollection.forEach((item) -> {
                params.add(name, parameterToString(item));
            });
            return params;
        }

        List<String> values = new ArrayList<>();
        valueCollection.forEach((o) -> {
            values.add(parameterToString(o));
        });
        params.add(name, collectionFormat.collectionToString(values));

        return params;
    }

    /**
     * Invoke API by sending HTTP request with the given options.
     *
     * @param <T> the return type to use
     * @param path The sub-path of the HTTP URL
     * @param method The request method
     * @param queryParams The query parameters
     * @param body The request body object
     * @param accept The request's Accept header
     * @param contentType The request's Content-Type header
     * @param returnType The return type into which to deserialize the response
     * @return The response body in chosen type
     */
    public <T> T invokeAPI(String path,
            HttpMethod method,
            MultiValueMap<String, String> queryParams,
            Object body,
            MediaType[] accept,
            MediaType contentType,
            ParameterizedTypeReference<T> returnType) throws RestClientException {

        final UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(BASE_PATH).path(path);
        if (queryParams != null) {
            builder.queryParams(queryParams);
        }

        final RequestEntity.BodyBuilder requestBuilder = RequestEntity.method(method, builder.build().toUri());

        if (accept != null) {
            requestBuilder.accept(accept);
        }

        if (contentType != null) {
            requestBuilder.contentType(contentType);
        }

        // Set header parameters with authentication settings.
        requestBuilder.header(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken);

        // Set header parameters with default User-Agent.
        requestBuilder.header("User-Agent", "Power BI Rest Client");

        RequestEntity<Object> requestEntity = requestBuilder.body(body);
        ResponseEntity<T> responseEntity = restTemplate.exchange(requestEntity, returnType);

        statusCode = responseEntity.getStatusCode();
        responseHeaders = responseEntity.getHeaders();

        if (responseEntity.getStatusCode() == HttpStatus.NO_CONTENT) {
            return null;
        } else if (responseEntity.getStatusCode().is2xxSuccessful()) {
            if (returnType == null) {
                return null;
            }
            return responseEntity.getBody();
        } else {
            // The error handler built into the RestTemplate should handle 400 and 500 series errors.
            throw new RestClientException("API returned " + statusCode + " and it wasn't handled by the RestTemplate error handler");
        }
    }

    public enum CollectionFormat {
        CSV(","), TSV("\t"), SSV(" "), PIPES("|"), MULTI(null);

        private final String separator;

        private CollectionFormat(String separator) {
            this.separator = separator;
        }

        private String collectionToString(Collection<? extends CharSequence> collection) {
            return StringUtils.collectionToDelimitedString(collection, separator);
        }
    }

    private class ApiClientHttpRequestInterceptor implements ClientHttpRequestInterceptor {

        private final Logger log = LoggerFactory.getLogger(this.getClass());

        @Override
        public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
            logRequest(request, body);
            ClientHttpResponse response = execution.execute(request, body);
            logResponse(response);
            return response;
        }

        private void logRequest(HttpRequest request, byte[] body) throws UnsupportedEncodingException {
            log.debug("URI: " + request.getURI());
            log.debug("HTTP Method: " + request.getMethod());
            log.debug("HTTP Headers: " + headersToString(request.getHeaders()));
            log.debug("Request Body: " + new String(body, StandardCharsets.UTF_8));
        }

        private void logResponse(ClientHttpResponse response) throws IOException {
            log.debug("HTTP Status Code: " + response.getRawStatusCode());
            log.debug("Status Text: " + response.getStatusText());
            log.debug("HTTP Headers: " + headersToString(response.getHeaders()));
            log.debug("Response Body: " + bodyToString(response.getBody()));
        }

        private String headersToString(HttpHeaders headers) {
            StringBuilder builder = new StringBuilder();
            headers.entrySet().stream().map((entry) -> {
                builder.append(entry.getKey()).append("=[");
                return entry;
            }).map((entry) -> {
                entry.getValue().forEach((value) -> {
                    builder.append(value).append(",");
                });
                return entry;
            }).map((_item) -> {
                builder.setLength(builder.length() - 1); // Get rid of trailing comma
                return _item;
            }).forEachOrdered((_item) -> {
                builder.append("],");
            });
            builder.setLength(builder.length() - 1); // Get rid of trailing comma
            return builder.toString();
        }

        private String bodyToString(InputStream body) throws IOException {
            StringBuilder builder = new StringBuilder();
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(body, StandardCharsets.UTF_8))) {
                String line = bufferedReader.readLine();
                while (line != null) {
                    builder.append(line).append(System.lineSeparator());
                    line = bufferedReader.readLine();
                }
            }
            return builder.toString();
        }
    }
}
