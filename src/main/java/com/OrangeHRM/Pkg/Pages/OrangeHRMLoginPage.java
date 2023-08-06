package com.OrangeHRM.Pkg.Pages;




import java.io.IOException;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.OrangeHRM.Pkg.TestBase.TestBaseClass;

public class OrangeHRMLoginPage extends TestBaseClass {



	@FindBy(xpath = "//input[@name=\"username\"]")
	private WebElement Username;

	@FindBy(xpath = "//input[@name=\"password\"]")
	WebElement Password;

	@FindBy(xpath = "//button[@type=\"submit\"]")
	WebElement Loginbutton;
	
	@FindBy (xpath="//p[contains(text(),\"Paul456466 Collings\")]")
	WebElement uName;

	//*****************************************************************************	
	public OrangeHRMLoginPage() throws IOException {

		PageFactory.initElements(driver, this);
	}
	//*******************************************************************************************
	public boolean validateUser(String name,String pass) throws InterruptedException {

		Username.sendKeys(name);
		Thread.sleep(3000);
		Password.sendKeys(pass);
		Thread.sleep(3000);
		Loginbutton.click();
		
		return uName.isDisplayed();
	
	}
	
	public void Login() throws Exception {
		Username.sendKeys("Admin");
		Thread.sleep(3000);
		Password.sendKeys("admin123");
		Thread.sleep(3000);
		Loginbutton.click();
	}

}
