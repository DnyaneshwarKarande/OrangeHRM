package com.OrangeHRM.Pkg.Pages;



import java.io.IOException;
import java.util.List;

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
	
	@FindBy(xpath="//span[contains(text(),\"Job\")]")
     WebElement JobTag;
	
	@FindBy (xpath="//ul[@class=\"oxd-dropdown-menu\"]//li")
	List<WebElement> JBList;
	
	@FindBy (xpath="//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary\"]")
	WebElement addButton;
	
	
	
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
	
	public boolean JobListVarification() {
  
		admtag.click();
		
		JobTag.click();
		
		for(int i=0;i<JBList.size();i++) {
			System.out.println(i);
			if(JBList.get(i).getText().equals("Employment Status")) {
				JBList.get(i).click();
				break;
			}
		}
		boolean addButtonValidation=addButton.isDisplayed();
		return addButtonValidation;
		
	}

}
