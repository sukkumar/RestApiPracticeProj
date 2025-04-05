package com.restapi.tests;


import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;

public class SampleGetArray {
	
   @Test
	 public void GetWeatherDetails()
	 {   
	   
	   RestAssured.baseURI = "http://restapi.demoqa.com/utilities/books/getallbooks";
	   RequestSpecification request = RestAssured.given();
	   
	   Response response = request.get();
	   System.out.println("Response Body -> " + response.body().asString());
	   
	   /// temp code
	   JSONObject responseJson = new JSONObject(response.getBody().asString());
	   JSONArray values = responseJson.getJSONArray("values");

			   for(int i = 0; i < values.length(); i++) {
			     String value = values.getString(i);
			      Assert.assertEquals(values, matchesPattern("[0-9][0-9][0-9]"));
			   }
	 }		   
	   // We can convert the Json Response directly into a Java Array by using
	   // JsonPath.getObject method. Here we have to specify that we want to
	   // deserialize the Json into an Array of Book. This can be done by specifying
	   // Book[].class as the second argument to the getObject method.
	
//	   String[] books = response.jsonPath().g
//	   
//	   for(Book book : books)
//	   {
//	   System.out.println("Book title " + book.title);
//	   }
	 
  

}
