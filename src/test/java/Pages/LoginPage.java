package Pages;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	
	WebDriver driver;
	
	public LoginPage(WebDriver ldriver){
		
		
		this.driver=ldriver;
	}
	
	
	@FindBy(xpath="//input[@id='log']") WebElement enterUserName;
	
	@FindBy(xpath="//input[@name='pwd']")WebElement enterPassword;
	
	
	@FindBy(xpath="//input[@id='login']") WebElement loginButton;
	

	@FindBy(xpath="//a[text()='Log out']")WebElement Logout;
	
	
	public void  logintoApplication(String username, String password){
		
		
		enterUserName.sendKeys(username);
		
		
		enterPassword.sendKeys(password);
		loginButton.click();
		
	}
	
	
	public void verifySignout(){
		
		String text=Logout.getText();
		
		Assert.assertEquals("Log out", text);
		
	}
	

}
