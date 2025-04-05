package demoApiRequest;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.List;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class DemoGetTest3 {
	
	@Test
    public void testGetRequest() {
		Response res = given()
		        .baseUri("https://jsonplaceholder.typicode.com")
		        .queryParam("userId", "1")
		        .when()
		        .get("/posts") // Assuming wrapped response
		        .then()
		        .statusCode(200)
		        .extract()
		        .response();

		String status = res.jsonPath().getString("status");
		int firstId = res.jsonPath().getInt("posts[0].id");
		
		
    }

}
