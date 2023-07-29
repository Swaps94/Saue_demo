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
import pages.InventoryPage;
import pages.LoginPage;
import pages.ShoppingCart;

public class CheckOutPageTest extends BaseClass{
	
	InventoryPage ip;
	LoginPage lp;
	ShoppingCart sc;
	CheckOutPage cp;
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException
	{
		initialization();
		lp=new LoginPage();
		ip=new InventoryPage();
		sc=new ShoppingCart();
		lp.loginToApplication();
		cp=new CheckOutPage();
		ip.addAllproducts();
		ip.clickOnCart();	
		sc.clickCheckout();
	}
	@Test
	public void verifyWebPageUrl() throws IOException
	{
		String expectedUrl=ReadData.readExcelFile(2, 1);
		String actualUrl=cp.verifyWebPageUrl();
		Assert.assertEquals(expectedUrl, actualUrl);
		Reporter.log("Actual Url of Website is -" +actualUrl);
		
	}
	@Test
	public void verifyWebLabel() throws IOException
	{
		String expectedLabel=ReadData.readExcelFile(2, 2);
		String actualLabel=cp.verifyWebLabel();
		Assert.assertEquals(expectedLabel, actualLabel);
		Reporter.log("Actual Label of Website is -" +actualLabel);
		
	}
	@Test
	public void inputCheckOutInfo() throws IOException
	{
		String expectedUrl=ReadData.readExcelFile(2, 3);
		String actualurl=cp.inputCheckOutInfo();
		Assert.assertEquals(expectedUrl, actualurl);
		Reporter.log("Information is coorect -" +actualurl );

	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
