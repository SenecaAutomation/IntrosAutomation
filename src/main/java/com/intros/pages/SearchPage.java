package com.intros.pages;


import net.thucydides.core.pages.PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.util.PropLoader;
import com.util.Util;

public class SearchPage extends PageObject {

	public SearchPage(final WebDriver driver) {
	super(driver,PropLoader.getint("Timeout"));
	}


	public static String itemname;

	@FindBy(id="txtTopNavSearch")
	WebElement SearchField;

	@FindBy(linkText = "Log Out")
	WebElement Logout;

	@FindBy(id = "btnTopFind")
	WebElement SearchButton;

	@FindBy(id = "ctl00_MainContentId_ctl00_lnkAddToCart")
	WebElement AddToCart;

	@FindBy(xpath = "//input[contains(@name,'Qty')]")
	WebElement QtyField;

	@FindBy(xpath="//img[@title='close']")
	WebElement ClosepopUp;
	
	@FindBy(xpath="//a[contains(text(),'Checkout')]")
	WebElement CheckoutFromMessage;

	@FindBy(xpath = "//input[contains(@id,'Favorites')]")
	WebElement favoriteCheckBox;

	@FindBy(linkText = "Add to all lists")
	WebElement addToAllFavoritesLists;

	@FindBy(linkText = "Remove from all lists")
	WebElement removefromAllLists;
	
	@FindBy(xpath="//img[@alt='Find Image']")
	WebElement RRSearchButton;
	
	@FindBy(linkText="1 results found")
	WebElement RRSearchResult;

	@FindBy(linkText = "Save")
	WebElement SaveFavorites;

	public void verifyDefaultPage() {
		shouldBeVisible(Logout);
	}

	public void searchItem(String item) {
		enter(item).into(SearchField);
		$(SearchButton).click();
		Util.waitForPageLoaded(getDriver());
	}


	public void verifySearchResults() {
		Assert.assertTrue((containsText(PropLoader.get("ItemCode")))
				&& (getDriver().findElements(By.xpath("//input[contains(@name,'Qty')]")).size()>0));
	}

	
	public void addToCart(String qty) {
		enter(qty).into(QtyField);
		$(AddToCart).click();
/*
		if ((AddToCart).isDisplayed())
			clickOn(AddToCart);
		else
			QtyField.sendKeys(Keys.TAB);
*/
		if (Util.isAlertPresent(getDriver())) {
			getAlert().accept();
		}

	}

	public void displayItemAddedConfirmation() {
		waitForTextToAppear("item added");
		$(ClosepopUp).click();
		waitABit(1000);
	}

	public void checkoutFromConfirmationMessage() {
		waitForTextToAppear("item added");
		$(CheckoutFromMessage).click();
		waitABit(1000);
	}	 

}

