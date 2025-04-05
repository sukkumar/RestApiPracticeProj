package basicRequests;


import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostDemo1 {
	
	   @Test
	    public void testPostRequest() {
	
		String requestBody = "{ \"title\": \"repellat\", \"body\": \"bar\", \"userId\": 1 }";
	   
		Response res =   given()
	        .baseUri("https://jsonplaceholder.typicode.com")
	        .header("Content-Type", "application/json")
	        .body(requestBody)
	     .when()
	        .post("/posts")
	     .then()
	        .statusCode(201) // 201 = Created
	        .body("title", containsString("repellat"))
	        
	      .extract().response();
		
		System.out.println(res.asString());
		  
		   }
	}
