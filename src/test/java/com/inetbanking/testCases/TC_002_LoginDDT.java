package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.HomePage;
import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_002_LoginDDT extends BaseSteps {

	@Test(dataProvider = "LoginData")
	public void loginDDT(String user, String pwd) {
		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = new HomePage(driver);
		loginPage.enterUserId(user);
		loginPage.enterPassword(pwd);
		loginPage.clickLogin();
		if (isAlertPresent()) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		} else {
			Assert.assertTrue(true);
			homePage.clickLogout();
			if (isAlertPresent()) {
				driver.switchTo().alert().accept();
			}
		}
	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {
		String path = "./src/test/java/com/inetbanking/testData/LoginData.xlsx";
		int rowCount = XLUtils.getRowCount(path, "Sheet1");
		int colCount = XLUtils.getCellCount(path, "Sheet1", 1);
		String loginData[][] = new String[rowCount][colCount];
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				loginData[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return loginData;
	}

}
