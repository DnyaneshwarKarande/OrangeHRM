package com.OrangeHRM.TestCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.OrangeHRM.Pkg.Pages.OrangeHRMLoginPage;
import com.OrangeHRM.Pkg.TestBase.TestBaseClass;



//@Listeners(CommonListners.class) because we pass listener inside testng.xml file at suite level
public class LoginPageTestCases extends TestBaseClass {

	OrangeHRMLoginPage LC;


	public LoginPageTestCases() throws IOException {
		super();
	}

	@BeforeMethod
	public void Setup() throws IOException {

		initialisation123(prop.getProperty("BrowserName"));  	
		LC=new OrangeHRMLoginPage();	
	}

	@Test
	public void OrangeUername() throws InterruptedException {
		boolean Correct=LC.validateUser(prop.getProperty("Username"), prop.getProperty("Password"));
		Assert.assertTrue(Correct); 
		//Assert.assertTrue(false);      //AssertionError: expected [true] but found [false]
	}

	@AfterMethod
	public void tearDown1() {
		driver.quit();
	}

}
