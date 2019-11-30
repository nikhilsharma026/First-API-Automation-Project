	package com.testcases;

	import java.io.FileInputStream;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.testng.Assert;
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


public class PostTest extends TestBase {

	
		@Test(priority=1)
		public void PostAPI() {
			
			// Defining base URI of API
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		
		
		//Creating a request object and assigning it to Request specification
		 httprequest = RestAssured.given();
		

		 
		 
		 JSONObject obj = new JSONObject();
		 obj.put("name","gfhgdfh");
		 obj.put("salary",23445);
		 obj.put("age",45);
		 
		 httprequest.header("Content-Type","application/json");
		 
		 httprequest.body(obj.toJSONString());

		 
		//Sending the request and receiving response
		 response = httprequest.request(Method.POST,"/create");
		
		
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
		
		Assert.assertTrue(false);
	
	}
		
		@AfterMethod
		public void teardown() {
			
			log.warn("Get Api Test cases completed");
		}
	}

