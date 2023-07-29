package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.base.BaseClass;

import Utility.ReadData;

public class LoginPage extends BaseClass{
	//constructor to initialize webelements (current class members)
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//object Repository
	@FindBy(xpath="//input[@id='user-name']")private WebElement username;
	@FindBy(xpath="//input[@id='password']")private WebElement password;
	@FindBy(xpath="//input[@id='login-button']")private WebElement loginBtn;
	@FindBy(xpath="//div[@class='login_logo']") private WebElement logo;
	
	
	public String loginToApplication() throws IOException
	{
		logger=report.createTest("Login to Sauce Lab Web Application");
		username.sendKeys(ReadData.readPropertyFile("username"));
		logger.log(Status.INFO, "username is entered");
		password.sendKeys(ReadData.readPropertyFile("password"));
		logger.log(Status.INFO, "password is entered");
		loginBtn.click();
		logger.log(Status.INFO, "Button is clicked");
		logger.log(Status.INFO, "Login Successfully!");


		return driver.getCurrentUrl();
	}
	public Boolean verifyLogo()
	{
		return logo.isDisplayed();
	}
	
	public String verifyTitleOfApp()
	{
		return driver.getTitle();
	}
	
	public String verifyUrlOfApp()
	{
		return driver.getCurrentUrl();
	}
	public String LoginAppWithMultipleCreadTest(String un,String pass) throws IOException
	{
		
		username.sendKeys(un);
		
		password.sendKeys(pass);
		
		loginBtn.click();
		
		return driver.getCurrentUrl();
	}
   
}
