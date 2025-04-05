package chainingAPIDemo;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class chainAPICallsDemo {
	
	// Step 1: Get a post and extract its ID
    
	@Test
	public void test1() {
	int postId = given()
        .baseUri("https://jsonplaceholder.typicode.com")
        .when()
        .get("/posts/1")
        .then()
        .statusCode(200)
        .extract()
        .path("id");

    // Step 2: Use the extracted ID to fetch comments
   
    given()
        .baseUri("https://jsonplaceholder.typicode.com")
        
        .when()
        .get("/posts/{id}/comments", postId)
        .then()
        .statusCode(200)
        .body("[0].postId", equalTo(postId));
}
}