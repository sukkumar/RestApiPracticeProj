package basicRequests;

import static org.testng.Assert.*;
import org.testng.annotations.Test;


import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

public class GetDemo5 {
    @Test
    public void testGetSerialization() {
    	PostRespPojoDemo response = given()
    	        .baseUri("https://jsonplaceholder.typicode.com")
    	        .queryParam("userId", "1")
    	        .when()
    	        .get("/posts") 
    	        .then()
    	        .statusCode(200)
    	        .extract()
    	        .as(PostRespPojoDemo.class);
    	
    	assertEquals("success", response.getStatus());
	    assertEquals(10, response.getTotalCount());

    	    List<PostPojoDemo> posts = response.getPosts();
    	    
    	    for(PostPojoDemo temp : posts) {
    	    	System.out.println(temp.getId());
    	    	System.out.println(temp.getUserId());
    	    	System.out.println(temp.getTitle());
    	    	System.out.println(temp.getBody());      	
    	    	
    	    }
    	    assertEquals(1, posts.get(0).getUserId());
    	    assertEquals("qui est esse", posts.get(1).getTitle());
             
        
    	    List<PostPojoDemo> posts2 = given()
    	    	    .baseUri("https://jsonplaceholder.typicode.com")
    	    	    .queryParam("userId", "1")
    	    	    .when()
    	    	    .get("/posts")
    	    	    .then()
    	    	    .extract()
    	    	    .jsonPath()
    	    	    .getList(".", PostPojoDemo.class);

    	    	assertEquals(1, posts2.get(0).getUserId());
    	    	assertEquals("qui est esse", posts2.get(1).getTitle());
    }
   
}