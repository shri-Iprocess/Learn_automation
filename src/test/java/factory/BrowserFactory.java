package factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;

public class BrowserFactory {
	
	
	static WebDriver driver;
	
	@Parameters("browser")
	public static WebDriver getBrowser(String browserName){
		
		if(browserName.equalsIgnoreCase("firefox")){
			
			
			
			System.setProperty("webdriver.firefox.marionette",DataProviderFactory.getConfig().getfirefoxpath());
			
			driver=new FirefoxDriver();
			
			
		}
		else if(browserName.equalsIgnoreCase("chrome")){
			
			
			System.setProperty("webdriver.chrome.driver", DataProviderFactory.getConfig().getChromePath());
				
				
				driver=new ChromeDriver();
			}
		
		else if(browserName.equalsIgnoreCase("IE")){
			
			
			System.setProperty("webdriver.ie.driver", DataProviderFactory.getConfig().getIEPath());
			
			driver=new InternetExplorerDriver();
			
		}
			
		
		  driver.manage().window().maximize();
	       
	       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		       return driver;
		       
		     
		       
		       
		       
		}
		
		
		
	public static void quit(){
		
		driver.quit();
		
	}
	
	}
