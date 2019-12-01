package com.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerUtil implements ITestListener{

	public ExtentHtmlReporter htmlreporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		test=extent.createTest(result.getName());
		test.log(Status.PASS, "Tets case passed is " + result.getName());
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		test=extent.createTest(result.getName());
		test.log(Status.FAIL, "Tets case failed is " + result.getName());
		test.log(Status.FAIL, "Tets case failed is " + result.getThrowable());
		
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		test=extent.createTest(result.getName());
		test.log(Status.SKIP, "Tets case skipped is " + result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		htmlreporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/target/ExtentReport.html"); // file path where extent report to be created
		htmlreporter.config().setReportName("BMW Sprint 32");
		htmlreporter.config().setDocumentTitle("Automation Report");
		htmlreporter.config().setTheme(Theme.DARK);
		
		
		extent=new ExtentReports();
		extent.attachReporter(htmlreporter);            //Attaching the extenthtmlreporter which has configuration to the extent reporter
		extent.setSystemInfo("Host name", "BMW CHina");
		extent.setSystemInfo("Environment", "INT");
		extent.setSystemInfo("username", "nikhil");
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}

}
