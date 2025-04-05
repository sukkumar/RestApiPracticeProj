package com.restapi.tests;


import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SamplePost2 {
	
   //@Test
	 public void samplePostMethod()
	 {   
	 
	 // Specify the base URL to the RESTful web service
	 RestAssured.baseURI = "http://restapi.demoqa.com/customer/register";

	 RequestSpecification httpRequest = RestAssured.given();
	
		// JSONObject is a class that represents a Simple JSON.
		// We can add Key - Value pairs using the put method
	 JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "bujjama"); 
		requestParams.put("LastName", "mun");
		 
		requestParams.put("UserName", "bujjama12345678901");  // need to be changed everytime to get 201
		requestParams.put("Password", "password1");
		requestParams.put("Email",  "bujjipichi12345678901@gmail.com"); //need to be changed everytime to get 201
		requestParams.put("Address", "edison");
	 
		httpRequest.header("Content-Type", "application/json");  //not mandatory
		httpRequest.body(requestParams.toString());
	
	//Response response = httpRequest.post("/register");
	 Response response = httpRequest.request(Method.POST);
		
	int statusCode = response.getStatusCode();
	Assert.assertEquals(statusCode, 201);
	System.out.println(response.body().asString());
	String successCode = response.jsonPath().get("SuccessCode");
	Assert.assertEquals( successCode, "OPERATION_SUCCESS");
	 
   }

}
