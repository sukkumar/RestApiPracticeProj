package basicRequests;


import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PutDemo1 {
	
	   @Test
	    public void testPostRequest() {
	
		   String requestBody = "{ \"id\": 1, \"title\": \"updated\", \"body\": \"bar\", \"userId\": 1 }";
		   
		   Response res = given()
		        .baseUri("https://jsonplaceholder.typicode.com")
		        .header("Content-Type", "application/json")
		        .body(requestBody)
		        .when()
		        .put("/posts/1")
		        .then()
		        .statusCode(200)
		        .body("title", equalTo("updated"))
		        .extract().response();
		   
		   
		   System.out.println(res.asString());
		   
		   System.out.println("================");
		   
		   Response res1 = given()
			        .baseUri("https://jsonplaceholder.typicode.com")
			        .when()
			        .get("/posts/1")
			        .then()
			        .statusCode(200)
			        .extract().response();
			   
			   
			   System.out.println(res1.asString());
		   
		   
		   }
	}
