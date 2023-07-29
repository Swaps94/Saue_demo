package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

import Utility.ReadData;

public class CheckOutPage extends BaseClass{
	
  @FindBy(xpath="//span[@class='title']")private WebElement title ;
  @FindBy(xpath="//input[@id='first-name']")private WebElement firstName;
  @FindBy(xpath="//input[@id='last-name']")private WebElement lastName;
  @FindBy(xpath="//input[@id='postal-code']")private WebElement pinCode;
  @FindBy(xpath="//input[@id='continue']")private WebElement continueBtn;
  @FindBy(xpath="//button[@id='cancel']")private WebElement cancelBtn;
  
  public CheckOutPage()
  {
	  PageFactory.initElements(driver, this);
  }
   
  public String verifyWebPageUrl()
  {
   return driver.getCurrentUrl();
  }
  public String verifyWebLabel()
  {
   return title.getText();
  }
  public String inputCheckOutInfo() throws IOException
  {
	firstName.sendKeys(ReadData.readExcelFile(0, 0)); 
  	lastName.sendKeys(ReadData.readExcelFile(0, 1));
  	pinCode.sendKeys(ReadData.readExcelFile(0, 2));
  	continueBtn.click();
  	return driver.getCurrentUrl();
  }
  public void clickContinueBtn()
  {
	  continueBtn.click();
  }
}
