package com.restapi.tests;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SamplePut {

	@Test
	public void UpdateRecords(){
		 int empid = 15410;
		 
		 RestAssured.baseURI ="http://dummy.restapiexample.com/api/v1";
		 RequestSpecification request = RestAssured.given();
		 
		 JSONObject requestParams = new JSONObject();
		 requestParams.put("name", "Zion"); // Cast
		 requestParams.put("age", 23);
		 requestParams.put("salary", 12000);
		 
		 request.body(requestParams.toString());
		 Response response = request.put("/update/"+ empid);
		 
		 int statusCode = response.getStatusCode();
		 System.out.println(response.asString());
		 Assert.assertEquals(statusCode, 200); 
		 
		
//		  Response response = request.request(Method.GET, "/Mumbai");
//		  
//		  String responseBody = response.getBody().asString();
//		  System.out.println(responseBody);
//		 
		 
		 
	
		 
		 }		
}
