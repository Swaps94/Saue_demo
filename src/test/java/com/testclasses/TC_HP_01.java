package com.testclasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseClass;

import Utility.CaptureScreenShot;
import Utility.ReadData;
import pages.LoginPage;

public class TC_HP_01 extends BaseClass{
    
	LoginPage lp;
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		initialization();
		lp=new LoginPage();
	}
	
	@Test(priority = 1,dependsOnMethods = "verifyUrlTest")
	public void verifyTitleTest() throws IOException
	{
		//String expected="Swag Labs";
		String expected=ReadData.readExcelFile(1, 0);
		String actual=lp.verifyTitleOfApp();
	    Assert.assertEquals(expected, actual);
	    Reporter.log("tile  of Application-" +actual);
	}
	@Test(priority = 0)
	public void verifyUrlTest() throws IOException
	{
		//String expectedUrl="https://www.saucedemo.com/";
		String expectedUrl=ReadData.readExcelFile(1, 1);
        String actualUrl=lp.verifyUrlOfApp();
	    Assert.assertEquals(expectedUrl, actualUrl);
	    Reporter.log("Original Url of Application-" +actualUrl);
	}
	@Test(priority = 2,dependsOnMethods = "verifyUrlTest")
	public void verifyLogo()
	{
		Boolean result=lp.verifyLogo();
		Assert.assertEquals(result, true);
		Reporter.log("Visibility of Logo-" +result);
	}
	@Test(priority = 3/*, dependsOnMethods = "verifyUrlTest"*/)
	public void loginToAppTest() throws IOException
	{   
		String ExpectedUrl="https://www.saucedemo.com/inventory.html";
		String ActualUrl=lp.loginToApplication();
		Assert.assertEquals(ExpectedUrl, ActualUrl);
		Reporter.log("Current Url of Application-" +ActualUrl);
	}
	@AfterMethod
	public void tearDown(ITestResult it) throws IOException
	{
		if(ITestResult.FAILURE==it.getStatus())
		{
			CaptureScreenShot.ScreenShot(it.getName());
		}
		report.flush();
		driver.close();
	}
	
	

}
