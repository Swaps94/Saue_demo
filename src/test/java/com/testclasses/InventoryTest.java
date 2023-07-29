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

public class InventoryTest extends BaseClass {

	InventoryPage ip;
	LoginPage lp;

	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		lp = new LoginPage();
		ip = new InventoryPage();
		lp.loginToApplication();

	}

	@Test
	public void verifyLogoPresent() {
		Boolean result = ip.verifyLogoPresent();
		Assert.assertEquals(result, true);
		Reporter.log("Visibility of Logo-" + result);

	}
	@Test
	public void verifyProductLabel() throws IOException
	{
		//String expectedLabel="Products";
		String expectedLabel=ReadData.readExcelFile(1, 5);
		String label=ip.verifyProductLabel();
		Assert.assertEquals(expectedLabel, label);
		Reporter.log("Original label -"+label);
	}
    @Test
	public void verifyTwitterPresent()
	{
    	Boolean result=ip.verifyFbPresent();
		Assert.assertEquals(result, true);
		Reporter.log("Visibility of Logo-" +result);
	}
    @Test
    public void verifyFbPresent()
	{
    Boolean result=ip.verifyFbPresent();
	Assert.assertEquals(result, true);
	Reporter.log("Visibility of Logo-" +result);
		
	}
    @Test
    public void verifyLinkedinPresent()
	{
    	Boolean result=ip.verifyTwitterPresent();
		Assert.assertEquals(result, true);
		Reporter.log("Visibility of Logo-" +result);
	}
    @Test
    public void addAllProducts() throws InterruptedException, IOException
    {   
    	//String expcount="5"; 
    	String expcount=ReadData.readExcelFile(1, 3);
    	String actualCount=ip.addAllproducts();
    	Assert.assertEquals(expcount, actualCount);
    	Reporter.log(" Total Products added"  + actualCount);
    }
    @Test
    public void remove2products() throws InterruptedException, IOException
    {
    //	String expected="3";
    	String expected=ReadData.readExcelFile(1, 4);
    	String actualCount=ip.remove2products();
    	Assert.assertEquals(expected, actualCount);
    	Reporter.log("Count of products after removal-" +actualCount);
    	
    }
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
