package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class CheckOutComplete extends BaseClass {
	
	public CheckOutComplete()
	{
		PageFactory.initElements(driver, this);
	}
	
  @FindBy(xpath="//div[@class='complete-text']")private WebElement SuccessMsg;
  @FindBy(xpath="//span[@class='title']")private WebElement webPagetile;
  @FindBy(xpath="//button[@id='back-to-products']")private WebElement BackBtn;
  @FindBy(xpath="//h2[@class='complete-header']")private WebElement thankUMsg;
  @FindBy(xpath="//img[@alt='Pony Express']")private WebElement successImg;
 // @FindBy(xpath="")private WebElement ;

  public String verifycheckOutPageUrl()
  {
	  return driver.getCurrentUrl();
  }
  public String verifywebPagetile()
  {
	  return driver.getTitle();
  }
  public Boolean verifyBackBtn()
  {
	  return BackBtn.isDisplayed();
  }
  public String verifySuccessUMsg()
  {
	  return SuccessMsg.getText();
  }
  public Boolean verifySuccessImg()
  {
	  return successImg.isDisplayed();
  }
  public String verifyThanku()
  {
	 return thankUMsg.getText();
  }
  
}
