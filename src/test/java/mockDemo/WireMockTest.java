package mockDemo;

import com.github.tomakehurst.wiremock.WireMockServer;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WireMockTest {

    private WireMockServer wireMockServer;

    @BeforeMethod
    public void setup() {
        wireMockServer = new WireMockServer(8080);
        wireMockServer.start();
    }

    @AfterMethod
    public void teardown() {
        wireMockServer.stop();
    }

    @Test
    public void testMockGetRequest() {
        // Define mock response
        stubFor(get(urlEqualTo("/mock/posts/1"))
            .willReturn(aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/json")
                .withBody("{\"id\": 1, \"userId\": 1, \"title\": \"Mock Title\", \"body\": \"Mock Body\"}")));

        given()
            .baseUri("http://localhost:8080")
            .when()
            .get("/mock/posts/1")
            .then()
            .statusCode(200)
            .body("id", equalTo(1));
        	
       
         
    }
  
}
