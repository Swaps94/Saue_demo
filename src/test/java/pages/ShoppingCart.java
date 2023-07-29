package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class ShoppingCart extends BaseClass {
	
    public ShoppingCart()
    {
    	PageFactory.initElements(driver, this);
    }
      @FindBy(xpath="//button[@id='checkout']") private WebElement checkOutBtn;
      @FindBy(xpath="//span[@class='title']")private WebElement cartLabel;
//    @FindBy(xpath="")private WebElement ;
//    @FindBy(xpath="")private WebElement ;
//    @FindBy(xpath="")private WebElement ;
//    @FindBy(xpath="")private WebElement ;
//    @FindBy(xpath="")private WebElement ;
//    @FindBy(xpath="")private WebElement ;

    public String verifyCartPageUrl()
    {
     return driver.getCurrentUrl();
    }
    public String verifyCartLabel()
    {
     return cartLabel.getText();
    }
    public void clickCheckout()
    {
    	checkOutBtn.click();
    }

}
