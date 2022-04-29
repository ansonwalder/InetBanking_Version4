package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "uid")
	WebElement eleTxtUserId;

	@FindBy(name = "password")
	WebElement eleTxtPassword;

	@FindBy(name = "btnLogin")
	WebElement eleBtnLogin;

	public void enterUserId(String userId) {
		eleTxtUserId.clear();
		eleTxtUserId.sendKeys(userId);
	}

	public void enterPassword(String password) {
		eleTxtPassword.clear();
		eleTxtPassword.sendKeys(password);
	}

	public void clickLogin() {
		eleBtnLogin.click();
	}

	public void performLogin(String userId, String password) {
		eleTxtUserId.clear();
		eleTxtUserId.sendKeys(userId);
		eleTxtPassword.clear();
		eleTxtPassword.sendKeys(password);
		eleBtnLogin.click();
	}

}
