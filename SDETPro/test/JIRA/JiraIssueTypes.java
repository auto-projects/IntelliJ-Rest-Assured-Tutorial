package test.JIRA;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.codec.binary.Base64;
import test.model.RequestCapability;

import static io.restassured.RestAssured.given;

public class JiraIssueTypes implements RequestCapability {

    public static void main(String[] args) {

        String baseUri = "https://prosdet.atlassian.net";
        String path = "/rest/api/3/project/RAT";

        String email = "ngoclieu.ng@gmail.com";
        String apiToken = "nTtJlAorbXXenr01gJfP9A7D";
        String credentials = email.concat(":").concat(apiToken);
        byte[] encodedCred = Base64.encodeBase64(credentials.getBytes());
        String encodedCredtoString = new String(encodedCred);

        // RequestSpecification object
        RequestSpecification request = given();
        request.baseUri(baseUri);

        // Content-type -> Header
        request.header(defaultHeader);
        request.header(RequestCapability.getAuthenticatedHeader(encodedCredtoString));


        Response response = request.get(path);
        response.prettyPrint();
    }
}
