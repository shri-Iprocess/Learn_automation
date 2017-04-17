package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver ldriver){
		
		this.driver=ldriver;
		
	}
	
	@FindBy(xpath="//a[text()='My Account']")WebElement myAccount;
	
	
	
	public void clickonMyAccount(){
		
		myAccount.click();
		
	}
	
	
	public String verifyApplicationTitle(){
		
		return driver.getTitle();
		
	}
	

}
