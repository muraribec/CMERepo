package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.hubspot.base.BasePage;

public class LoginPage extends BasePage {
	// 1.PageFactory---->PageObject-->DataMembers
	@FindBy(id = "username")
	WebElement emailId;
	@FindBy(id = "password")
	WebElement password;
	@FindBy(id = "loginBtn")
	WebElement loginButton;
	@FindBy(linkText = "Sign up")
	WebElement sigpUpLinkText;

	//2.Constructor(Single argumented Constructor)
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//3.Member Function----PageActions
	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean verifySignupLinkDisplayed() {
		return sigpUpLinkText.isDisplayed();
	}

	public HomePage doLogin(String username, String pwd) {
		emailId.sendKeys(username);
		password.sendKeys(pwd);
		loginButton.click();
		return new HomePage(driver);
	}

}
