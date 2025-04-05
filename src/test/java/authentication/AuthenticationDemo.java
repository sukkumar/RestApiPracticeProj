package authentication;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

public class AuthenticationDemo {

	@Test
	public void testExternalApi() {
	    String apiKey = "your-api-key-here";
	    given()
	        .baseUri("https://api.openweathermap.org")
	        .queryParam("q", "London")
	        .queryParam("appid", apiKey)
	        .when()
	        .get("/data/2.5/weather")
	        .then()
	        .statusCode(200)
	        .body("name", equalTo("London"))
	        .body("main.temp", notNullValue());
	}
	
	@Test
	public void testBasicAuth() {
	    given()
	    	.baseUri("https://api.example.com")
	        .auth().basic("username", "password")
	        .when()
	        .get("/protected")
	        .then()
	        .statusCode(200);
	}
	
	@Test
	public void testOAuth() {
	    String token = "your-bearer-token";
	    given()
	        .header("Authorization", "Bearer " + token)
	        .when()
	        .get("https://api.example.com/secure")
	        .then()
	        .statusCode(200);
	}
	
	
//	@Test
//	public void testFileUpload() {
//	    given()
//	        .baseUri("https://api.example.com")
//	        .multiPart("file", new File("src/test/resources/sample.txt"))
//	        .when()
//	        .post("/upload")
//	        .then()
//	        .statusCode(200);
//	}
	
}
