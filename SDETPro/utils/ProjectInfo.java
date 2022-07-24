package utils;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import test.model.RequestCapability;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ProjectInfo implements RequestCapability {

    private String baseUri;
    private String projectKey;
    private List<Map<String, String>> issueTypes;
    private Map<String, List<Map<String, String>>> projectInfo;

    public ProjectInfo(String baseUri, String projectKey) {
        this.baseUri = baseUri;
        this.projectKey = projectKey;
        getProjectInfo();
    }

    public String getIssueTypeId(String issueTypeString) {
        getIssueTypes();

        String issueTypeId = null;

        for (Map<String, String> issueType : issueTypes) {
            if (issueType.get("name").equalsIgnoreCase(issueTypeString)) {
                issueTypeId = issueType.get("id");
                break;
            }
            
        }

        if (issueTypeId == null) {
            throw new RuntimeException("[ERROR] Could not find the ID for  " + issueTypeString);
        }
        return issueTypeId;
    }

    private void getIssueTypes() {
        issueTypes = projectInfo.get("issueTypes");

    }

    private void getProjectInfo() {
        String path = "/rest/api/3/project/".concat(projectKey);

        String email = "ngoclieu.ng@gmail.com";
        String apiToken = "Y6Hq9X0OwahBZCRrLzeU50D7";
        String encodedCredString = AuthenticationHandler.encodedCredString(email, apiToken);

        // RequestSpecification object
        RequestSpecification request = given();
        request.baseUri(baseUri);

        // Content-type -> Header
        request.header(defaultHeader);
        request.header(getAuthenticatedHeader.apply(encodedCredString));
        Response response = request.get(path);
        projectInfo = JsonPath.from(response.asString()).get();

    }
}
