package com.Api.base;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase {

	public static RequestSpecification httprequest;
	public static  Response response;
	
	public Logger log;
		
	
	
	@BeforeClass
	public void setup() {
		
		log= Logger.getLogger("EmployeetestAPI");
		PropertyConfigurator.configure("log4j.properties");
		log.setLevel(Level.DEBUG);
		
	}
}
