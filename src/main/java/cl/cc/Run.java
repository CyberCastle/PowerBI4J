package cl.cc;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import cl.cc.powerbi.auth.Authenticator;
import cl.cc.powerbi.client.EmbedTokenApi;
import cl.cc.powerbi.client.invoker.ApiClient;
import cl.cc.powerbi.client.model.GenerateTokenRequestV2;
import cl.cc.powerbi.client.model.GenerateTokenRequestV2Dataset;
import cl.cc.powerbi.client.model.GenerateTokenRequestV2Report;
import cl.cc.powerbi.client.model.GenerateTokenRequestV2TargetWorkspace;

/**
 *
 * @author CyberCastle
 */
public class Run {

    public static String username = "<username>@<domain>.onmicrosoft.com";
    public static String password = "<s3cr3t>";

    // Native app ID obtained from Azure Portal. More info:
    // https://docs.microsoft.com/en-us/power-bi/developer/register-app
    public static String client_id = "<Native app ID>";
    // Tenant ID (Office 365) obtained from Azure Portal. More Info:
    // https://support.office.com/en-us/article/find-your-office-365-tenant-id-6891b561-a52d-4ade-9f39-b492285e2c9b
    public static String tenant = "<Tenant ID>";
    public static String resourceURI = "https://analysis.windows.net/powerbi/api";

    public static void main(String... arg) throws Exception {

        System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "DEBUG");

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Authenticator auth = new Authenticator(client_id, tenant, username, password, executorService);
        String accessToken = auth.authenticate();
        System.out.println("token: " + accessToken);

        ApiClient apiClient = new ApiClient();
        apiClient.setBearerToken(accessToken);

        EmbedTokenApi etokena = new EmbedTokenApi(apiClient);

        GenerateTokenRequestV2 gen = new GenerateTokenRequestV2();
        gen.addTargetWorkspacesItem(new GenerateTokenRequestV2TargetWorkspace().id(UUID.fromString("<Workspace ID>")));

        GenerateTokenRequestV2Report tokenRequestV2Report = new GenerateTokenRequestV2Report();
        tokenRequestV2Report.setId(UUID.fromString("<Report ID>"));
        tokenRequestV2Report.setAllowEdit(true);
        gen.addReportsItem(tokenRequestV2Report);

        GenerateTokenRequestV2Dataset tokenRequestV2Dataset = new GenerateTokenRequestV2Dataset();
        tokenRequestV2Dataset.setId("<Dataset ID>");
        gen.addDatasetsItem(tokenRequestV2Dataset);

        // Get Token
        System.out.println(etokena.embedTokenGenerateToken(gen).getToken());

        executorService.shutdown();
    }

}
