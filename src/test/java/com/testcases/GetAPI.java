package com.testcases;

import java.io.FileInputStream;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.Api.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * Unit test for simple App.
 */
public class GetAPI extends TestBase{
	
	
	@Test(priority=0)
	public void getAPI() {
		
		// Defining base URI of API
	RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
	
	
	//Creating a request object and assigning it to Request specification
	 httprequest = RestAssured.given();
	
	
	//Sending the request and receiving response
	 response = httprequest.request(Method.GET,"/employees");
	
	
	//Printing response as string
	log.info("Printing json***************************************8");
	String APIresponse = response.getBody().asString();
	System.out.println(APIresponse);

	//Get status code
	System.out.println(response.getStatusCode());
	

//get status line
	System.out.println(response.getStatusLine());
	
	//get all headers of response
	
	//get response time of  API in milliseconds
	System.out.println(response.getTime() + "ms");
	
	// Get time in specific timeunit
	System.out.println(response.getTimeIn(TimeUnit.SECONDS)); 
	
	
	//Get a particular value from response headers
	System.out.println(response.getHeader("Content-Type"));
	
	
	//get session id from response  
	System.out.println(response.getSessionId());
	

	
	//get particular set of data from the response
	JsonPath path = response.jsonPath();
	System.out.println(path.get("[1]"));	//return First set of JSOn data
	System.out.println(path.get("[0].employee_name"));  //Return particular value from first set of JSOn data
	
	}
	
	@AfterMethod
	public void teardown() {
		
		log.warn("Get Api Test cases completed");
	}
}
