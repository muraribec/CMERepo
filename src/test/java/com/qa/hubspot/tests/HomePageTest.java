package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.scanner.Constant;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;

public class HomePageTest {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LoginPage loginPage;
	HomePage homePage;
	@BeforeMethod
	public void setUp(){
		basePage=new BasePage();
		prop = basePage.initialize_Properties();
		driver = basePage.initialize_driver(prop);
		loginPage = new LoginPage(driver);
		homePage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String title = homePage.getHomePageTitle();
		System.out.println("homepage title is " + title);
		Assert.assertEquals(title, com.qa.hubspot.Constants.Constants.HOME_PAGE_TITLE);
	}
	@Test(priority=2)
	public void verifyHomePaheHeaderTest(){
		Assert.assertTrue(homePage.verifyHomePageHeader());
		Assert.assertEquals(homePage.getHomePageHeaderText(), com.qa.hubspot.Constants.Constants.HOME_PAGE_HEADER);
		
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
