package basicRequests;



import org.testng.annotations.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetDemo2 {
    @Test
    public void testGetRequest() {
    	Response res = given()
        .baseUri("https://jsonplaceholder.typicode.com")
        .queryParam("userId", "1")
        .when()
        	.get("/posts")
        .then()
	        .statusCode(200)
	        .body("[1].id", equalTo(2))    
	    	.body("[1].title", containsString("esse"))
	        .body("[1].body", containsString("molestiae"))
	    .extract().response();
    	
    	System.out.println(res.asString());
    	
    	
        
    //	.body("userId", everyItem(equalTo(1)));
    //	.body("find { it.id == 2 }.title", equalTo("qui est esse"));
    }
    
   // @Test
    public void testGetRequest2() {
    	given()
        .baseUri("https://jsonplaceholder.typicode.com")
        .when()
        .get("/posts/1/comments") // Mocking a nested response
        .then()
        .statusCode(200)
        .body("status", equalTo("success"))              // Regular field
        .body("msg.tag", equalTo("testmsg"))        // Nested regular field
        .body("posts[0].userId", equalTo(1))            // Array field
        .body("posts[0].comments[0]", equalTo("comment1")); // Nested array;
    }
}
