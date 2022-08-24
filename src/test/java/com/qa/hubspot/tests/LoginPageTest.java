package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.LoginPage;

public class LoginPageTest {
	WebDriver driver;
	Properties prop;
	BasePage basepage;
	LoginPage loginpage;
	
	@BeforeMethod
	public void setup(){
		basepage = new BasePage();
		prop = basepage.initialize_Properties();
		driver = basepage.initialize_driver(prop);
		loginpage = new LoginPage(driver);	
	}
	@Test
	public void loginTestWithCorrectCredentilsTest(){
		loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
