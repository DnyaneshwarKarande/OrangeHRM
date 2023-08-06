package com.OrangeHRM.Pkg.Pages;



import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.OrangeHRM.Pkg.PageElements.HomePageElements;
import com.OrangeHRM.Pkg.TestBase.TestBaseClass;
import com.OrangeHRM.Pkg.Util.FetchElement;

public class OrangeHRMHomePage extends TestBaseClass {
	
	
	@FindBy (xpath="//div[@class=\"oxd-brand-banner\"]")
	WebElement ll;
	
	@FindBy(partialLinkText="Admin")
	WebElement admtag;
	
	public OrangeHRMHomePage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	
	
	//to fetch WebElements we call fetchElement method for that we creting object of that class where we created method
	
	FetchElement FE=new FetchElement();
	
	public boolean validateLogo() throws InterruptedException  {
		
		boolean LogoIsAvailableOrNot=ll.isDisplayed();
		Thread.sleep(3000);
		return LogoIsAvailableOrNot;
	}
	
	public boolean validateSerchButton() throws InterruptedException {
		boolean SerchBtnIsAvailableOrNot=FE.getWebElement("Xpath", HomePageElements.searchButton).isDisplayed();
		Thread.sleep(3000);
		return SerchBtnIsAvailableOrNot;
	}
	
	/*public boolean validateAdminTag() {
		boolean ADMPgIsAvailableOrNot=FE.getWebElement("Xpath", HomePageElements.AdminPage).isDisplayed();
		return ADMPgIsAvailableOrNot;
	}*/
	

	public boolean validateAdminTag() {
		boolean ADMPgIsAvailableOrNot=admtag.isDisplayed();
		return ADMPgIsAvailableOrNot;
	}

}
