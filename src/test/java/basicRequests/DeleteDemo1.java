package basicRequests;


import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class DeleteDemo1 {
	
	   @Test
	    public void testPostRequest() {
	
		 Response res =   given()
	        .baseUri("https://jsonplaceholder.typicode.com")
	        .when()
	        .delete("/posts/1")
	        .then()
	        .statusCode(200)
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
