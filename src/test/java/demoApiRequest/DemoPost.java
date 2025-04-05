package demoApiRequest;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

class DemoPost {

	@Test
	public void testPostRequest() {
	    String requestBody = "{ \"title\": \"foolish\", \"body\": \"bar\", \"userId\": 1 }";
	    
	    Response res = given()
	        .baseUri("https://jsonplaceholder.typicode.com")
	        .header("Content-Type", "application/json")
	        .body(requestBody)
	        .when()
	        .post("/posts")
	        .then()
	        .statusCode(201) // 201 = Created
	        .body("title", equalTo("foolish"))
	        .extract().response();
	        
	    
	    System.out.println(res.asString());
	}
}
