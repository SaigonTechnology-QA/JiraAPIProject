package test;

import api_flow.IssueFlows;
import org.testng.annotations.Test;

public class JiraIssueCRUD extends BaseTest {

    @Test
    public void TestCreatingIssue() {
        IssueFlows issueFlows = new IssueFlows(request, baseUri, projectKey, "task");
        System.out.println("=== Create ===");
        issueFlows.createIssue();

        System.out.println("=== Read ===");
        issueFlows.verifyIssueDetails();

        System.out.println("=== Delete ===");
        issueFlows.deleteIssue();
    }

    @Test
    public void TestUpdatingIssue() {
        IssueFlows issueFlows = new IssueFlows(request, baseUri, projectKey, "task");
        System.out.println("=== Create ===");
        issueFlows.createIssue();

        System.out.println("=== Update ===");
        issueFlows.updateIssue("Done");
        issueFlows.verifyIssueDetails();

        System.out.println("=== Delete ===");
        issueFlows.deleteIssue();
    }

    @Test
    public void TestDeletingIssue() {
        IssueFlows issueFlows = new IssueFlows(request, baseUri, projectKey, "task");
        System.out.println("=== Create ===");
        issueFlows.createIssue();

        System.out.println("=== Delete ===");
        issueFlows.deleteIssue();
    }

    @Test
    public void TestE2EFlow() {
        IssueFlows issueFlows = new IssueFlows(request, baseUri, projectKey, "task");
        System.out.println("=== Create ===");
        issueFlows.createIssue();

        System.out.println("=== Read ===");
        issueFlows.verifyIssueDetails();

        System.out.println("=== Update ===");
        issueFlows.updateIssue("Done");
        issueFlows.verifyIssueDetails();

        System.out.println("=== Delete ===");
        issueFlows.deleteIssue();
    }
}
