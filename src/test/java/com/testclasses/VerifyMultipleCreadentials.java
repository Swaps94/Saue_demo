package com.testclasses;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass;

import Utility.CaptureScreenShot;
import pages.LoginPage;

public class VerifyMultipleCreadentials extends BaseClass {
	LoginPage lp;

	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		lp = new LoginPage();
	}

	@Test(dataProvider = "creadentials")
	public void LoginAppWithMultipleCreadTest(String un, String pass) throws IOException {
		SoftAssert s = new SoftAssert();
		String expectedUrl = "https://www.saucedemo.com/inventory.html";
		String actualUrl = lp.LoginAppWithMultipleCreadTest(un, pass);
		s.assertEquals(expectedUrl, actualUrl);
		s.assertAll();
	}

	@DataProvider(name = "creadentials")
	public Object[][] getData() {
		return new Object[][] { { "standard_user", "secret_sauce" }, { "standard_user1", "secret_sauce" },
				{ "standard_user1", "standard_user1" }, { "standard_user", "standard_user" } };
	}

	@AfterMethod
	public void tearDown(ITestResult it) throws IOException {
		if (ITestResult.FAILURE == it.getStatus()) {
			CaptureScreenShot.ScreenShot(it.getName());
		}

		driver.close();
	}
}
