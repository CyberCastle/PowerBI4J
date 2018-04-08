package cl.cc.powerbi;

import cl.cc.powerbi.auth.Authenticator;
import cl.cc.powerbi.api.GroupsApi;

import java.util.concurrent.Executors;

/**
 *
 * @author CyberCastle
 */
public class Run {

    public static String username = "<username>@<domain>.onmicrosoft.com";
    public static String password = "<s3cr3t>";
    
    // Native app ID obtained from Azure Portal. More info: https://docs.microsoft.com/en-us/power-bi/developer/register-app
    public static String client_id = "<Native app ID>";
    // Tenant ID (Office 365) obtained from Azure Portal. More Info: https://support.office.com/en-us/article/find-your-office-365-tenant-id-6891b561-a52d-4ade-9f39-b492285e2c9b
    public static String tenant = "<Tenant ID>";
    public static String resourceURI = "https://analysis.windows.net/powerbi/api";

    public static void main(String... arg) throws Exception {
        
        System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "WARN");

        Authenticator auth = new Authenticator(client_id, tenant, username, password, Executors.newFixedThreadPool(10));

        String token = auth.authenticate();

        System.out.println("token: " + token);



        GroupsApi gapi = new GroupsApi(token);
        
        //gapi.setDebugging(true);

        gapi.getGroups().getValue().forEach(g -> System.out.println(g));

    }

}
