package com.inetbanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_001_LoginTest extends BaseSteps {

	@Test
	public void loginTest() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserId(userId);
//		logger.info("Entered User Id");
		loginPage.enterPassword(password);
//		logger.info("Entered Password");
		loginPage.clickLogin();
//		logger.info("Clicked login button");
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
		} else {
			captureScreenshot(driver, "loginTest");
			Assert.assertTrue(false);
		}
//		Assert.assertEquals(driver.getTitle(), "Guru99 Bank Manager HomePage");
//		logger.info("Login Test Passed");
	}

}
