package com.testclasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseClass;

import Utility.ReadData;
import pages.CheckOutPage;
import pages.CheckOutPage2;
import pages.InventoryPage;
import pages.LoginPage;
import pages.ShoppingCart;

public class CheckOutPage1Test extends BaseClass {
	InventoryPage ip;
	LoginPage lp;
	ShoppingCart sc;
	CheckOutPage cp;
	CheckOutPage2 check2;

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException
	{
		initialization();
		lp=new LoginPage();
		ip=new InventoryPage();
		sc=new ShoppingCart();
		lp.loginToApplication();
		cp=new CheckOutPage();
		check2=new CheckOutPage2();
		ip.addAllproducts();
		ip.clickOnCart();	
		sc.clickCheckout();
		cp.inputCheckOutInfo();
		//cp.clickContinueBtn();
	}
	@Test
	public void verifyLogoPresent()
	{
		Boolean result=check2.verifyLogoPresent();
		Assert.assertEquals(result, true);
		Reporter.log("Visibility of Logo-" + result);
		
	}
	@Test
	 public void verifyPaymentInfor() throws IOException
	  {
		String expected=ReadData.readExcelFile(2, 0);
		String actual=check2.verifyPaymentInfor();
		Assert.assertEquals(expected, actual);
		Reporter.log("Verified payment -"+actual);
	  }
	@Test
	  public void verifyShippingInfo() throws IOException
	  {
		String expected=ReadData.readExcelFile(0, 3);
		String actual=check2.verifyShippingInfo();
		Assert.assertEquals(expected, actual);
		Reporter.log("Verified shipping -"+actual);
	  }
	@Test
	  public void verifyAmount() throws IOException
	  {
		String expected=ReadData.readExcelFile(0, 5);
		String actual=check2.verifyAmount();
		Assert.assertEquals(expected, actual);
		Reporter.log("Verified shipping -"+actual);		
	  }
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
