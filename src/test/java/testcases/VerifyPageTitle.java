package testcases;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.HomePage;
import factory.BrowserFactory;
import factory.DataProviderFactory;

public class VerifyPageTitle {
	
	
	WebDriver driver;
	
	
	@BeforeMethod
	public void setUp(){
		
		
        driver=BrowserFactory.getBrowser("firefox");
		
		
		driver.get(DataProviderFactory.getConfig().getApplicationURL());
		
	}
	
	
	
	@Test
	public void testHomePage(){
		
		
		
		
	HomePage home=	PageFactory.initElements(driver, HomePage.class);
	
	String title=home.verifyApplicationTitle();
	
	System.out.println(title);
	
	
	
	}
	
       @AfterMethod
	public void tearDown(){
		
		BrowserFactory.quit();
		
	}

}
