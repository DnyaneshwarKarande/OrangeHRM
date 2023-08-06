package com.OrangeHRM.Pkg.TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.OrangeHRM.Pkg.Util.Utility;

import net.bytebuddy.utility.RandomString;

public class TestBaseClass {

	public static WebDriver driver;
	public static Properties prop;
	public static Logger log=Logger.getLogger(TestBaseClass.class);

	public TestBaseClass() throws IOException {

		prop=new Properties();

		FileInputStream fis =new FileInputStream("C:\\Users\\Dnyaneshwar Karande\\eclipse-workspace54\\COM.OrangeHRMProject\\src\\main\\resources\\ConfigurationFile\\Conf.properties");

		prop.load(fis);
	}


	@SuppressWarnings("deprecation")
	public void initialisation123(String BrowserName) {
		log.info("*************************Browser Start************************************************");

		if(BrowserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Dnyaneshwar Karande\\eclipse-workspace54\\COM.OrangeHRMProject\\Browsers\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(BrowserName.equals("Edge")) {
			System.setProperty("webdriver.Edge.driver", "C:\\Users\\Dnyaneshwar Karande\\eclipse-workspace54\\COM.OrangeHRMProject\\Browsers\\msedgedriver.exe");
			driver=new EdgeDriver(); 
		}
		else if (BrowserName.equals("FireFox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Dnyaneshwar Karande\\eclipse-workspace54\\COM.OrangeHRMProject\\Browsers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("BrowserName not found");
		}
			
		



		/*System.setProperty("webdriver.chrome.driver","C:\\Users\\Dnyaneshwar Karande\\eclipse-workspace54\\COM.OrangeHRMProject\\Browsers\\chromedriver.exe");

		driver=new ChromeDriver();*/

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Utility.IMPLICIT_WAIT,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Utility.PAGELOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		log.info("*************************URL Enter************************************************");

	}
	
	public String takeScreenshot(String testCaseName) throws IOException {
		//dateFormat
		String dateName=new SimpleDateFormat("yyyyMMddhhmm").format(new Date());

		
	
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		File source =ts.getScreenshotAs(OutputType.FILE);
		//String Random = RandomString.make(5);	
		
		String destination = System.getProperty("user.dir")+"/Screenshot/"+testCaseName+""+dateName+".png";
		
		FileUtils.copyFile(source, new File(destination));
		
		return destination;


	}

}
