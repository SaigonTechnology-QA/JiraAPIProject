package test;

import io.restassured.specification.RequestSpecification;
import model.RequestCapability;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import utils.AuthenticationHandler;

import static io.restassured.RestAssured.given;

public class BaseTest implements RequestCapability {
    protected String encodeCredStr;
    protected String baseUri;
    protected String projectKey;
    protected RequestSpecification request;

    @BeforeSuite
    public void beforeSuite(){
        encodeCredStr = AuthenticationHandler.encodeCredStr(email, apiToken);
        baseUri = "<Base_URI>";
        projectKey = "<Project_Key>";
    }

    @BeforeTest
    public void beforeTest(){
        request = given();
        request.baseUri(baseUri);
        request.header(defaultHeader);
        request.header(acceptJSONHeader);
        request.header(getAuthenticatedHeader.apply(encodeCredStr));
    }
}
