package test.JIRA;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import test.model.IssueFields;
import test.model.RequestCapability;
import utils.AuthenticationHandler;
import utils.ProjectInfo;

import static io.restassured.RestAssured.given;

public class JIRA_NewIssue implements RequestCapability {

    public static void main(String[] args) {

        // API Info
        String baseUri = "https://prosdet.atlassian.net";
        String path = "/rest/api/3/project";
        String projectKey = "RAT";

        String email = "ngoclieu.ng@gmail.com";
        String apiToken = "Y6Hq9X0OwahBZCRrLzeU50D7";
        String encodedCredString = AuthenticationHandler.encodedCredString(email, apiToken);

        // Request Object
        RequestSpecification request = given();
        request.baseUri(baseUri);
        request.header(defaultHeader);
        request.header(acceptJSONHeader);
        request.header(getAuthenticatedHeader.apply(encodedCredString));

        ProjectInfo projectInfo = new ProjectInfo(baseUri, projectKey);
        String taskTypeId = projectInfo.getIssueTypeId("task");
        String summary = "This is summary example";
        IssueFields.Fields.IssueType issueType = new IssueFields.Fields.IssueType("10001");
        IssueFields.Project project = new IssueFields.Project(projectKey);
        IssueFields.Fields fields = new IssueFields.Fields(fields);

        // Send request
        Response response = request.body(new Gson().toJson(issueFields)).post(path);
        response.prettyPrint();

        // Verify
    }
}
