package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.hubspot.base.BasePage;

public class HomePage extends BasePage{
	//1.PageFactory--PageObject
		@FindBy(xpath="//h1[@class='private-page__title']")
		WebElement homepageHeader;
		@FindBy(xpath="//span[@class='account-name ']")
		WebElement accountName;
		
		@FindBy(id="nav-primary-contacts-branch")
		WebElement parentContactsMenu;	
		@FindBy(id="nav-secondary-contacts")
		WebElement childContactsMenu;
		//2.Constructor of the HomePage
		public HomePage(WebDriver driver){
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		//3.Page Actions::
		public String getHomePageTitle(){
		   return	driver.getTitle();
		}
		public String getHomePageHeaderText(){
			return homepageHeader.getText();
		}
		public boolean verifyHomePageHeader(){
			return homepageHeader.isDisplayed();
		}
		public String getAccountNameValue(){
			return accountName.getText();
		}
		public boolean verifyAccount(){
			return accountName.isDisplayed();
		}
//		public void clickOnContacts(){
//			parentContactsMenu.click();
//			TimeUtil.shotWait();
//			childContactsMenu.click();
//		}
//		public ContactsPage goToContactsPage(){
//			clickOnContacts();
//			return new ContactsPage(driver);
//		}
}
