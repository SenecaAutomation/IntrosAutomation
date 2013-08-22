package com.intros.pages;

import net.thucydides.core.pages.PageObject;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.util.Util;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
 
public class LoginPage extends PageObject {

	public LoginPage(WebDriver driver) {
		super(driver,30000);

	}
	 public enum CURR {
	     HKD,CHF,CNY,GBP,HUF,EUR,SGD,USD,STA;
	 }

	@FindBy(id="ctl00_TopNavContentId_TopNav_LogIn")
	WebElement LoginButton;
	
	@FindBy(id = "ctl00_MainContentId_txtUserName")
	WebElement Username;

	@FindBy(id = "ctl00_MainContentId_txtPassword")
	WebElement Password;

	@FindBy(id = "ctl00_MainContentId_btnSubmit")
	WebElement SubmitButton;
	
	@FindBy(linkText="Log Out")
	WebElement Logout;
	
	@FindBy(linkText="About Us")
	WebElement AboutUs;

	@FindBy(xpath="//a[contains(text(),'Career Opportunities')]")
	WebElement CareerOpp;
	
	@FindBy(id="ctl00_TopNavContentId_TopNav_lblCartValue")
	WebElement CurrencySymbol;
 	   
	  
	public void gotoLogin() {
		$(LoginButton).click();		
	}
	
	public void enterUserName(String uname){ 
		enter(uname).into(Username);
	}

	public void enterPassword(String pword) {
		enter(pword).into(Password);
	}

	public void clickSubmitNow() {
		clickOn(SubmitButton);
		Util.waitForPageLoaded(getDriver());
	}
	
	public void logOut() {
		clickOn(Logout);
		Util.waitForPageLoaded(getDriver());
	}
	
	public void should_see_home_page() {
		Util.waitForPageLoaded(getDriver());
 		assertThat(getDriver().getTitle(),is("Hotel Supplies, Hotel Products, Amenities, Linens & More -Intros Hotel Supplies"));
	}
	
	public void checkCareerPage(String userName) {
		$(CareerOpp).click();
		Util.waitForPageLoaded(getDriver());
		assertThat(getDriver().getTitle(),is("Careers - INTROS Hotel Supplies"));
	 
	}
		
	public void checkAboustUsPage(String userName) {
		$(AboutUs).click();
		Util.waitForPageLoaded(getDriver());
		assertThat(getDriver().getTitle(),is("About Us - INTROS Hotel Supplies"));
		 
	}
	

	public void checkCurrency(String userName) {
		
		String str = userName.substring(0,3);
	
		switch(CURR.valueOf(str)){
		
		case HKD:Assert.assertTrue(CurrencySymbol.getText().contains("HK$"));
		break;
		case CHF:Assert.assertTrue(CurrencySymbol.getText().contains("fr"));
		break;
		case CNY:Assert.assertTrue(CurrencySymbol.getText().contains("¥"));
		break;
		case GBP:Assert.assertTrue(CurrencySymbol.getText().contains("£"));
		break;
		case HUF:Assert.assertTrue(CurrencySymbol.getText().contains("Ft"));
		break;
		case EUR:Assert.assertTrue(CurrencySymbol.getText().contains("€"));
		break;
		case SGD:Assert.assertTrue(CurrencySymbol.getText().contains("$"));
		break;
		case USD:Assert.assertTrue(CurrencySymbol.getText().contains("$"));
		break;
		case STA:Assert.assertTrue(CurrencySymbol.getText().contains("€"));
		break;
		}
	}

}
