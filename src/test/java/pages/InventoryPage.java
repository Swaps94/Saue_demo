package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.base.BaseClass;

public class InventoryPage extends BaseClass {

	public InventoryPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='app_logo']")
	private WebElement logo;
	@FindBy(xpath = "//button[@id='react-burger-menu-btn']")
	private WebElement dropDown;
	@FindBy(xpath = "//span[@class='title']")
	private WebElement productLabel;
	@FindBy(xpath = "//a[normalize-space()='Twitter']")
	private WebElement twitterlabel;
	@FindBy(xpath = "//a[normalize-space()='Facebook']")
	private WebElement fblabel;
	@FindBy(xpath = "//a[normalize-space()='LinkedIn']")
	private WebElement linkedinlabel;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
	private WebElement bagpackproduct;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']")
	private WebElement bikelight;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")
	private WebElement blackTshirt;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-fleece-jacket']")
	private WebElement jacket;
	@FindBy(xpath = "//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")
	private WebElement redTshirt;
	@FindBy(xpath = "//select[@class='product_sort_container']")
	private WebElement filter;
	@FindBy(xpath = "//span[@class='shopping_cart_badge']")
	private WebElement shoppingCart;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-backpack']")
	private WebElement removebagpackproduct;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-bike-light']")
	private WebElement removebikelight;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-bolt-t-shirt']")
	private WebElement removeblackTshirt;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-fleece-jacket']")
	private WebElement removejacket;
	@FindBy(xpath = "//button[@id='remove-test.allthethings()-t-shirt-(red)']")
	private WebElement removeredTshirt;

	public Boolean verifyLogoPresent() {
		return logo.isDisplayed();
	}

	public String verifyProductLabel() {
		return productLabel.getText();
	}

	public Boolean verifyTwitterPresent() {
		return twitterlabel.isEnabled();
	}

	public Boolean verifyFbPresent() {
		return fblabel.isEnabled();
	}

	public Boolean verifyLinkedinPresent() {
		return linkedinlabel.isEnabled();
	}

	public String addAllproducts() throws InterruptedException {
		Select s = new Select(filter);
		s.selectByVisibleText("Price (low to high)");
		Thread.sleep(3000);
		bagpackproduct.click();
		Thread.sleep(3000);
		blackTshirt.click();
		Thread.sleep(3000);
		redTshirt.click();
		Thread.sleep(3000);
		bikelight.click();
		Thread.sleep(3000);
		jacket.click();
		return shoppingCart.getText();
	}
	public String remove2products() throws InterruptedException
	{
		addAllproducts();
		Thread.sleep(3000);
		removebagpackproduct.click();
		Thread.sleep(3000);
		removeblackTshirt.click();
		return shoppingCart.getText();
	}
	public void clickOnCart()
	{
		shoppingCart.click();
	}

}
