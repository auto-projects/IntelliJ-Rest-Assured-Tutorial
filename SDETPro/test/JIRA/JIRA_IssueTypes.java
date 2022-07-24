package test.JIRA;

import test.model.RequestCapability;
import utils.ProjectInfo;

public class JIRA_IssueTypes implements RequestCapability {

    public static void main(String[] args) {

        String baseUri = "https://prosdet.atlassian.net";
        String projectKey = "RAT";

        ProjectInfo projectInfo = new ProjectInfo(baseUri, projectKey);
        System.out.println("Task ID: " + projectInfo.getIssueTypeId("task"));
        System.out.println("Epic ID: " + projectInfo.getIssueTypeId("epic"));

    }
}
