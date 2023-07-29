package com.testclasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseClass;

import Utility.ReadData;
import pages.CheckOutComplete;
import pages.CheckOutPage;
import pages.CheckOutPage2;
import pages.InventoryPage;
import pages.LoginPage;
import pages.ShoppingCart;

public class CheckOutCompleteTest extends BaseClass {

	InventoryPage ip;
	LoginPage lp;
	ShoppingCart sc;
	CheckOutPage cp;
	CheckOutPage2 check2;
	CheckOutComplete cc;

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		initialization();
		lp = new LoginPage();
		ip = new InventoryPage();
		sc = new ShoppingCart();
		lp.loginToApplication();
		cp = new CheckOutPage();
		check2 = new CheckOutPage2();
		cc = new CheckOutComplete();
		ip.addAllproducts();
		ip.clickOnCart();
		sc.clickCheckout();
		cp.inputCheckOutInfo();
		check2.verifyFinishPayment();

	}

	@Test
	public void verifycheckOutPageUrl() throws IOException {
		String expectedUrl = ReadData.readExcelFile(3, 1);
		String actualurl = cc.verifycheckOutPageUrl();
		Assert.assertEquals(expectedUrl, actualurl);
		Reporter.log("Original url of webPage- " + actualurl);
	}

	@Test
	public void verifywebPagetile() throws IOException {
		String expectedTitle = ReadData.readExcelFile(3, 0);
		String actualtitle = cc.verifywebPagetile();
		Assert.assertEquals(expectedTitle, actualtitle);
		Reporter.log("Original title of webPage- " + actualtitle);
	}

	@Test
	public void verifyBackBtn() {

		Boolean rs = cc.verifyBackBtn();
		Assert.assertEquals(rs, true);
		Reporter.log("BackButton is visible- " + rs);

	}

	@Test
	public void verifySuccessMsg() throws IOException {
		String expectedtitle = ReadData.readExcelFile(3, 6);
		String actualtitle = cc.verifySuccessUMsg();
		Assert.assertEquals(expectedtitle, actualtitle);
		Reporter.log("Original title of webPage- " + actualtitle);
	}

	@Test
	public void verifySuccessImg() {
		Boolean rs = cc.verifySuccessImg();
		Assert.assertEquals(rs, true);
		Reporter.log("BackButton is visible- " + rs);
	}

	@Test
	public void verifyMsg() throws IOException {
		String expectedtitle = ReadData.readExcelFile(3, 2);
		String actualtitle = cc.verifyThanku();
		Assert.assertEquals(expectedtitle, actualtitle);
		Reporter.log("Original title of webPage- " + actualtitle);
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
