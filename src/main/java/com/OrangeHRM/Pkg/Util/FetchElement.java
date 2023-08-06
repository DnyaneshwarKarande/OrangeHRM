package com.OrangeHRM.Pkg.Util;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.OrangeHRM.Pkg.TestBase.TestBaseClass;

public class FetchElement  {

	
   //To fetch single WebElement
	public WebElement getWebElement(String identifireType, String identifireValue) {

		switch(identifireType) {
		case "xpath":
			return TestBaseClass.driver.findElement(By.xpath(identifireValue));
		case "id":
			return TestBaseClass.driver.findElement(By.id(identifireValue));
		case "pLinkText":
			return TestBaseClass.driver.findElement(By.partialLinkText(identifireValue));
		case "className":
			return TestBaseClass.driver.findElement(By.className(identifireValue));
		case "name":
			return TestBaseClass.driver.findElement(By.name(identifireValue));
		case "css":
			return TestBaseClass.driver.findElement(By.cssSelector(identifireValue));

		default:
			return null;
		}
	}	
	
	
	//To fetch List of WebElement
		public List<WebElement> getWebElements(String identifireType, String identifireValue) {

			switch(identifireType) {
			case "xpath":
				return TestBaseClass.driver.findElements(By.xpath(identifireValue));
			case "id":
				return TestBaseClass.driver.findElements(By.id(identifireValue));
			case "linkText":
				return TestBaseClass.driver.findElements(By.linkText(identifireValue));
			case "className":
				return TestBaseClass.driver.findElements(By.className(identifireValue));
			case "name":
				return TestBaseClass.driver.findElements(By.name(identifireValue));
			case "css":
				return TestBaseClass.driver.findElements(By.cssSelector(identifireValue));

			default:
				return null;
			}


	}

}
