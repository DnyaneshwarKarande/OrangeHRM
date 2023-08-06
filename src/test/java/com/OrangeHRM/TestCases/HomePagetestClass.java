package com.OrangeHRM.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.OrangeHRM.Pkg.Pages.OrangeHRMHomePage;
import com.OrangeHRM.Pkg.Pages.OrangeHRMLoginPage;
import com.OrangeHRM.Pkg.TestBase.TestBaseClass;

public class HomePagetestClass extends TestBaseClass{

	public HomePagetestClass() throws IOException {
		super();
		
	}
	
	OrangeHRMHomePage HomePage = new OrangeHRMHomePage();
	
	@BeforeMethod
	public void setUp() throws Exception {
		
		initialisation123(prop.getProperty("BrowserName"));//to initialize browser till enter URL
		HomePage = new OrangeHRMHomePage();
		OrangeHRMLoginPage Lg =new OrangeHRMLoginPage();
		Lg.Login(); //to pass credentials and login to application
		Thread.sleep(3000);
	}
	@Test
	public void admBtn() {
		boolean adm=HomePage.validateAdminTag();
		Assert.assertTrue(adm);
	}
	@Test
	public void serchBtn() throws InterruptedException {
		boolean serch=HomePage.validateSerchButton();
		Assert.assertTrue(serch);
	}
	@Test(dependsOnMethods = "serchBtn")
	public void Logov() throws InterruptedException {
		boolean Logo=HomePage.validateLogo();
		Assert.assertTrue(Logo);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
