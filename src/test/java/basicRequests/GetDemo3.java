package basicRequests;



import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetDemo3 {
  //  @Test
    public void testGetRequest1() {
    	String title = given()
    	        .baseUri("https://jsonplaceholder.typicode.com")
    	        .when()
    	        .get("/posts/1")
    	        .then()
    	        .extract()
    	        .path("title");
      
    	System.out.println("Title: " + title);
   
    }
    
    @Test
    public void testGetRequest2() {
  	    
    	Response response = given()
    	        .baseUri("https://jsonplaceholder.typicode.com")
    	        .when()
    	        .get("/posts/1")
    	        .then()
    	        .extract()
    	        .response();
    	
      String userID  = response.jsonPath().getString("userId");
      String id = response.jsonPath().getString("id");
      String title = response.jsonPath().getString("title");
      String body = response.jsonPath().getString("body");
      
      System.out.println(userID);
      System.out.println(id);
      System.out.println(title);      
      System.out.println(body);
      
    //  Assert.assertEquals("sunt aut facere repellat provident occaecati excepturi optio reprehenderit", title);
    	    
        
        
    }
}