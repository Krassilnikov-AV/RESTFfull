
package restClient;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:DirResource [dir]<br>
 * USAGE:
 * <pre>
 *        RESTFfullClient client = new RESTFfullClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 */
public class RESTFfullClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/RESTFfull/webresources";

    public RESTFfullClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("dir");
    }

    public String altGetContent(String directory) throws ClientErrorException {
        WebTarget resource = webTarget;
        if (directory != null) {
            resource = resource.queryParam("directory", directory);
        }
        resource = resource.path("alt");
        return resource.request(javax.ws.rs.core.MediaType.TEXT_HTML).get(String.class);
    }

    public String altFindFile(String file, String directory) throws ClientErrorException {
        WebTarget resource = webTarget;
        if (file != null) {
            resource = resource.queryParam("file", file);
        }
        if (directory != null) {
            resource = resource.queryParam("directory", directory);
        }
        resource = resource.path("alt/find");
        return resource.request(javax.ws.rs.core.MediaType.TEXT_HTML).get(String.class);
    }

    public String getContent(String directory) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{directory}));
        return resource.request(javax.ws.rs.core.MediaType.TEXT_HTML).get(String.class);
    }

    public String findFile(String directory, String file) throws ClientErrorException {
        WebTarget resource = webTarget;
        if (file != null) {
            resource = resource.queryParam("file", file);
        }
        resource = resource.path(java.text.MessageFormat.format("find/{0}", new Object[]{directory}));
        return resource.request(javax.ws.rs.core.MediaType.TEXT_HTML).get(String.class);
    }

    public void close() {
        client.close();
    }
    
}
