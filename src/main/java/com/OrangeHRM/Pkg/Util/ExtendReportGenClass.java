package com.OrangeHRM.Pkg.Util;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportGenClass {

	static ExtentReports extent;

	public static ExtentReports getReportObject(){
		//to store report file in date format
		String dateName=new SimpleDateFormat("yyyyMMddhhmm").format(new Date());
		
		

		String path =System.getProperty("user.dir")+"/reports/ExReport"+dateName+".html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("4 Jun Framework Results");
		reporter.config().setDocumentTitle("Automation Execution Results");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("QA Automation Engineer", "Dnyaneshwar Karande");
		return extent;

	}

}

