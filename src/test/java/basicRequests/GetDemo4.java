package basicRequests;

import org.testng.Assert;
import org.testng.annotations.Test;


import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

public class GetDemo4 {
    @Test
    public void testGetSerialization() {
    	PostPojoDemo post = new PostPojoDemo();
        post.setUserId(1);
        post.setTitle("foo");
        post.setBody("bar");

        given()
            .baseUri("https://jsonplaceholder.typicode.com")
            .header("Content-Type", "application/json")
            .body(post) // Automatically serialized to JSON
            .when()
            .post("/posts")
            .then()
            .statusCode(201)
            .body("title", equalTo("foo"));
             
        
    }
    
    @Test
    public void testGetDeSerialization() {
    	PostPojoDemo post = given()
    	        .baseUri("https://jsonplaceholder.typicode.com")
    	        .when()
    	        .get("/posts/1")
    	        .then()
    	        .extract()
    	        .as(PostPojoDemo.class); // Deserialize to POJO
    	    Assert.assertEquals(1, post.getId());
    	    Assert.assertEquals("sunt aut facere repellat provident occaecati excepturi optio reprehenderit", post.getTitle());
        
    }
    
    
    @Test
    public void testGetArrayvalidation() {
    	List<PostPojoDemo> posts = given()
    	        .baseUri("https://jsonplaceholder.typicode.com")
    	        .when()
    	        .get("/posts")
    	        .then()
    	        .statusCode(200)
    	        .extract()
    	        .jsonPath()
    	        .getList(".", PostPojoDemo.class); 

    	    // Validate specific items
    	    Assert.assertEquals(1, posts.get(0).getId());          
    	    Assert.assertEquals("qui est esse", posts.get(1).getTitle());
    }
    
    
   
}