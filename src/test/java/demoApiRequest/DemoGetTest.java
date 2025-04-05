package demoApiRequest;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class DemoGetTest {
	
	@Test
    public void testGetRequest() {
        given()
            .when()
            .get("https://jsonplaceholder.typicode.com/posts/")
            .then()
            .statusCode(200);
            //.body("id", equalTo(1));
        
        Response res = given().when().get("https://jsonplaceholder.typicode.com/posts/");
        
        System.out.println(res.asString());
    }

}
