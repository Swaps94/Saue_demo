package com.testclasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseClass;

import Utility.ReadData;
import pages.InventoryPage;
import pages.LoginPage;
import pages.ShoppingCart;

public class ShoppingCartTest extends BaseClass {
	
	InventoryPage ip;
	LoginPage lp;
	ShoppingCart sc;
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException
	{
		initialization();
		lp=new LoginPage();
		ip=new InventoryPage();
		sc=new ShoppingCart();
		lp.loginToApplication();
		ip.addAllproducts();
		ip.clickOnCart();	
	}
	
	@Test
	public void verifyCartPageUrl() throws IOException
	{
		String expectedUrl=ReadData.readExcelFile(1, 6);
		String actualUrl=sc.verifyCartPageUrl();
		Assert.assertEquals(expectedUrl, actualUrl);
		Reporter.log("Actual Url of Website is -" +actualUrl);
		
	}
	@Test
	public void verifyCartLabel() throws IOException
	{
		String expectedLabel=ReadData.readExcelFile(1, 7);
		String actualLabel=sc.verifyCartLabel();
		Assert.assertEquals(expectedLabel, actualLabel);
		Reporter.log("Actual Label of Website is -" +actualLabel);
		
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}
