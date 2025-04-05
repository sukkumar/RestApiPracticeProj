package demoApiRequest;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.List;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class DemoGetTest2 {
	
	@Test
    public void testGetRequest() {
		ApiResponse response = given()
		        .baseUri("https://jsonplaceholder.typicode.com")
		        .queryParam("userId", "1")
		        .when()
		        .get("/posts") // Assuming wrapped response
		        .then()
		        .statusCode(200)
		        .extract()
		        .as(ApiResponse.class);

		    System.out.println(response.toString());
		    // Validate regular fields
		    assertEquals("success", response.getStatus());
		    assertEquals(10, response.getTotalCount());

		    // Validate array fields
		    List<Post> posts = response.getPosts();
		    assertEquals(1, posts.get(0).getUserId());
		    assertEquals("qui est esse", posts.get(1).getTitle());
    }

}
