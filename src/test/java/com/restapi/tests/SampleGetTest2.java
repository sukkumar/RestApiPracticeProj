package com.restapi.tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleGetTest2 {
	
   @Test
	 public void GetWeatherDetails()
	 {   
	 
	 // Specify the base URL to the RESTful web service
	 RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

	 // Get the RequestSpecification of the request that you want to sent
	 // to the server. The server is specified by the BaseURI that we have
	 // specified in the above step.
	 RequestSpecification httpRequest = RestAssured.given();
	 
	 	 
	 // Make a request to the server by specifying the method Type and the method URL.
	 // This will return the Response from the server. Store the response in a variable.
	
	  Response response = httpRequest.request(Method.GET, "/Mumbai");
	 //Response response = httpRequest.get("http://restapi.demoqa.com/utilities/weather/city/Mumbai");
			 
	 System.out.println(response.getBody().asString());
	 String city = response.jsonPath().get("City");
	 System.out.println(city);
	 
	 }

}
