package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class CheckOutPage2 extends BaseClass{
	
	public CheckOutPage2()
	{
		PageFactory.initElements(driver, this);
	}
  @FindBy(xpath="//div[@class='app_logo']")private WebElement logo;
  @FindBy(xpath="//div[normalize-space()='SauceCard #31337']")private WebElement paymentInfo;
  @FindBy(xpath="//div[normalize-space()='Free Pony Express Delivery!']")private WebElement shippingInfo;
  @FindBy(xpath="//div[@class='summary_info_label summary_total_label']")private WebElement amount;
  @FindBy(xpath="//button[@id='cancel']")private WebElement cancel;
  @FindBy(xpath="//button[@id='finish']")private WebElement finish;
  
  
  public Boolean verifyLogoPresent()
  {
	 return logo.isDisplayed();
  }
  public String verifyPaymentInfor()
  {
	 return paymentInfo.getText();
  }
  public String verifyShippingInfo()
  {
	 return shippingInfo.getText();
  }
  public String verifyAmount()
  {
	return amount.getText();
  }
  public void verifyFinishPayment()
  {
	 finish.click();
  }
}
