package utils;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.RequestCapability;
import org.apache.commons.codec.binary.Base64;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ProjectInfo implements RequestCapability {
    private String baseUri;
    private String projectKey;
    private List<Map<String, String>> issueTypes;
    Map<String, List<Map<String, String>>> projectInfo;

    // Alt + Insert
    public ProjectInfo(String baseUri, String projectKey) {
        this.baseUri = baseUri;
        this.projectKey = projectKey;
        getProjectInfo();
    }

    public String getIssueTypeId(String issueTypeStr) {
        getIssueType();
        String issueTypeId = null;
        for (Map<String, String> issueType : issueTypes) {
            if (issueType.get("name").equalsIgnoreCase(issueTypeStr)) {
                issueTypeId = issueType.get("id");
                break;
            }
        }
        if (issueTypeId == null) {
            throw new RuntimeException("Error: Could not found the id for: " + issueTypeStr);
        }
        return issueTypeId;
    }

    private void getIssueType() {
        issueTypes = projectInfo.get("issueTypes");
    }

    private void getProjectInfo() {
        String path = "/rest/api/3/project/".concat(projectKey);
        String encodeCredStr = AuthenticationHandler.encodeCredStr(email, apiToken);
        // Request
        RequestSpecification request = given();
        request.baseUri(baseUri);
        request.header(defaultHeader);
        // Class method
        // request.header(RequestCapability.getAuthenticatedHeader(encodeCredStr));
        // Functional Interface
        request.header(getAuthenticatedHeader.apply(encodeCredStr));
        Response response = request.get(path);
        // response.prettyPrint();
        projectInfo = JsonPath.from(response.asString()).get();
    }
}
