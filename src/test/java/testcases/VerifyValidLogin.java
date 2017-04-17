package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Utility.TakeScreenShot;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.BrowserFactory;
import factory.DataProviderFactory;

public class VerifyValidLogin {
	
	ExtentReports report;
	ExtentTest logger;
	WebDriver driver;
	
	@BeforeMethod
	public void setUp(){
		
		report=new ExtentReports("C:\\Users\\shrid\\workspace\\com.learnautomation.hybrid\\Reports\\Report.html",true);
		
		logger=new ExtentTest("Verify Valid Login", "This will verify Valid login");
		report.startTest("Verify Valid Login");
		
		logger.log(LogStatus.INFO, "Test Started");
		
		driver=BrowserFactory.getBrowser("firefox");
		
		driver.get(DataProviderFactory.getConfig().getApplicationURL());
		
		logger.log(LogStatus.INFO, "URL OPENED");
	}

	
	@Test
	public void verifylogin(){
		
		
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		
		String title=home.verifyApplicationTitle();
		
		 Assert.assertTrue(title.contains(" Toolsqa Dummy Test site"));
		
		logger.log(LogStatus.PASS,"Title Contains");
		
		home.clickonMyAccount();
		
		logger.log(LogStatus.INFO, "Clicked on My account");
		
		
		LoginPage login=PageFactory.initElements(driver, LoginPage.class);
		
		logger.log(LogStatus.INFO, "Entered Creditianls");
		
		login.logintoApplication(DataProviderFactory.getExcel().getData(0, 0, 0),DataProviderFactory.getExcel().getData(0, 0,1));
		
		logger.log(LogStatus.INFO, "logged in to site");
		
		login.verifySignout();
		
		
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult result){
		
		if(result.getStatus()==ITestResult.FAILURE){
			
		String path=	TakeScreenShot.CaptureScreenshot(driver, result.getName());
			
		TakeScreenShot.CaptureScreenshot(driver, "Validation.png");
			logger.log(LogStatus.FAIL, logger.addScreenCapture(path));
		}
		BrowserFactory.quit();
		
		report.endTest(logger);
		report.flush();
		
	}
	
}
