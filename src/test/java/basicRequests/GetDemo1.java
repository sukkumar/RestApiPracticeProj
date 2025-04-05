package basicRequests;



import org.testng.annotations.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetDemo1 {
    @Test
    public void testGetRequest() {
//    	given()
//	        .baseUri("https://jsonplaceholder.typicode.com")
//	    .when()
//	        .get("/posts/1")
//        .then()
//	        .statusCode(200)
//	        .body("userId", equalTo(1))
//	        .body("title", notNullValue());
    	
    	
       Response res =  
    		   given()
		            .when()
		            	.get("https://jsonplaceholder.typicode.com/posts/1")
		            .then()
		            	.statusCode(200)
			            .extract().response();
       
       System.out.println(res.getStatusCode());
       
       System.out.println(res.asString());
       
    }
}