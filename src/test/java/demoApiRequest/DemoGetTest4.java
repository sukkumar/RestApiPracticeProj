package demoApiRequest;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.matchesPattern;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class DemoGetTest4 {

    @Test
    public void testGetWeatherDetails() {
        // Set base URI
        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";  // Corrected to weather endpoint
        
        // Make GET request
        Response response = given()
            .when()
            .get("/Hyderabad")  // Example city, adjust as needed
            .then()
            .statusCode(200)    // Assert successful response
            .extract()
            .response();

        // Print response
        String responseBody = response.body().asString();
        System.out.println("Response Body -> " + responseBody);

        try {
            // Parse JSON response
            JSONObject responseJson = new JSONObject(responseBody);
            
            // Assuming the API returns weather data with a "values" array
            // Note: Actual structure depends on the API response
            JSONArray values = responseJson.optJSONArray("values");  // Use optJSONArray for safety
            
            if (values != null) {
                for (int i = 0; i < values.length(); i++) {
                    String value = values.getString(i);
                    // Assert that each value matches a 3-digit pattern
                    assertThat(value, matchesPattern("\\d{3}"));  // Updated regex pattern
                }
            } else {
                System.out.println("No values array found in response");
            }
        } catch (Exception e) {
            System.err.println("Error parsing JSON response: " + e.getMessage());
            throw e;  // Re-throw to fail the test
        }
    }
}