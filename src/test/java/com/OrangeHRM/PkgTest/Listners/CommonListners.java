package com.OrangeHRM.PkgTest.Listners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.OrangeHRM.Pkg.TestBase.TestBaseClass;
import com.OrangeHRM.Pkg.Util.ExtendReportGenClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class CommonListners extends TestBaseClass implements ITestListener{
	
	
	ExtentReports extent =ExtendReportGenClass.getReportObject();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>();

	public CommonListners() throws IOException {
		super();
	}

	@Override
	public void onTestStart(ITestResult result) {
		log.info("*************************Test Start************************************************");

		test=extent.createTest(result.getMethod().getMethodName());//to add name in extent-Report file
		extentTest.set(test);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		log.info("*************************"+result.getMethod().getMethodName()+"Test Succes************************************************");

		extentTest.get().log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.get().fail(result.getThrowable());//to add error/exception in extent-report file
		WebDriver driver =null;
		String FailedScreenShotTestMethodName=result.getMethod().getMethodName();
		
		
		/*try {
			driver= (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();	
		}*/
		
		try {//to add screenshot of failed test case
			extentTest.get().addScreenCaptureFromPath(takeScreenshot(FailedScreenShotTestMethodName),result.getMethod().getMethodName());
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.info("*************************"+result.getMethod().getMethodName()+"Test failed************************************************");

		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		log.info("*************************"+result.getMethod().getMethodName()+"Test Skiped************************************************");

	     extentTest.get().skip(result.getThrowable());//to add error/exception in extent-report file
	/*	WebDriver driver =null;
		String FailedScreenShotTestMethodName=result.getMethod().getMethodName();
		
		
		try {
			driver= (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();	
		}
		
		try {//to add screenshot of failed test case
			extentTest.get().addScreenCaptureFromPath(takeScreenshot(FailedScreenShotTestMethodName),result.getMethod().getMethodName());
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		
	}
	
	

}
