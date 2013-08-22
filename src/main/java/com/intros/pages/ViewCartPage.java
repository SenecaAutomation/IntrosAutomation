package com.intros.pages;

import net.thucydides.core.pages.PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.util.PropLoader;
import com.util.Util;

public class ViewCartPage extends PageObject {

	public ViewCartPage(WebDriver driver) {
		super(driver, PropLoader.getint("Timeout"));
	}
	
	@FindBy(id="ctl00_MainContentId_hlProceedToCheckout1")
	WebElement CheckOut;

	@FindBy(id="ctl00_MainContentId_btnCheckout")
	WebElement CheckOutAtDidYouForget;

	@FindBy(id="ctl00_MainContentId_hlContinue")
	WebElement ContinueCheckout;

	@FindBy(id="ctl00_MainContentId_LinkButton1")
	WebElement SubimtOrderButton;

	@FindBy(linkText="View Cart")
	WebElement ViewCart;

	@FindBy(id="ctl00_MainContentId_ddlShippingAddress")
	WebElement ShippingAddress;
 
	@FindBy(id="ctl00_MainContentId_lblOrderRef")
	WebElement OrderRef;

	@FindBy(xpath="//span[@id='ctl00_MainContentId_dlCartContents_ctl00_lblFavorite']/input")
	WebElement favoriteboxInCart;

	@FindBy(linkText="Add to all lists")
	WebElement addToAllFavoritesLists;

	@FindBy(linkText="Remove from all lists")
	WebElement removefromAllLists;

	@FindBy(linkText="Save")
	WebElement SaveFavorites;

	@FindBy(xpath="(//span[contains(@id,'Description')])[1]")
	WebElement item;

	static String itmLocation, qty;

	public static String ordNo;
	public static String favoritefromcart;

	public static String finalQty;
	static WebElement qtyField = null, itmId = null;
	public static float itemAmount;

	public void gotoViewCart() {
 		clickOn(ViewCart);
		Util.waitForPageLoaded(getDriver());
	}

	public void reviewCart(String itemCode) {
		Util.waitForPageLoaded(getDriver());
		Assert.assertTrue(getDriver().findElements(By.linkText(itemCode)).size() > 0);
		}

	public void checkoutCart() {
		itmId = getDriver().findElement(By.linkText(PropLoader.get("ItemCode")));
		itmLocation = itmId.getAttribute("id");
		qtyField = getDriver().findElement(By.id(itmLocation.replace("hlCatNumx", "cartqty")));
		finalQty = qtyField.getAttribute("value");

		clickOn(CheckOut);
		Util.waitForPageLoaded(getDriver());
		if (getDriver().findElements(By.id("ctl00_MainContentId_btnCheckout")).size() > 0) {
			clickOn(CheckOutAtDidYouForget);
			Util.waitForPageLoaded(getDriver());
		}
		clickOn(ContinueCheckout); // Address Page
		Util.waitForPageLoaded(getDriver());
		clickOn(SubimtOrderButton);
	}

	public void checkOutConfirmation() {
		ordNo = (OrderRef.getText()).split(" ")[1];
		shouldContainText("Thank you for ordering!");
	}

	
	public void updateQty(String newQty) {
		itmId = getDriver().findElement(By.linkText(PropLoader.get("ItemCode")));
		itmLocation = itmId.getAttribute("id");
		qtyField = getDriver().findElement(
				By.id(itmLocation.replace("hlCatNumx", "cartqty")));
		qty = qtyField.getAttribute("value");
	 
		enter(newQty).into(qtyField);
		getDriver().findElement(By.id(itmLocation.replace("hlCatNumx", "btnUpdateCartx"))).click();
		Util.waitForPageLoaded(getDriver());
		
		if (Util.isAlertPresent(getDriver()))
			getAlert().accept();
		Util.waitForPageLoaded(getDriver());
		if (Util.isAlertPresent(getDriver()))
			getAlert().accept();
	}

	public void confirmUpdateQty() {
		Assert.assertFalse(find(By.id(itmLocation.replace("hlCatNumx", "cartqty"))).getValue().equalsIgnoreCase(qty));
	}

	public void deleteItem() {
		enter("0").intoField(By.id(itmLocation.replace("hlCatNumx", "cartqty")));
		find(By.id(itmLocation.replace("hlCatNumx", "btnUpdateCartx"))).click();
		Util.waitForPageLoaded(getDriver());
		if (Util.isAlertPresent(getDriver()))
			getAlert().accept();
	}

	public void confirmItemDelete() {
		Util.waitForPageLoaded(getDriver());
		shouldNotBeVisible(By.linkText(PropLoader.get("ItemCode")));
	}
	
	

	public void selectFavoriteFromCart() {
		waitABit(1000);
		if (!(favoriteboxInCart.isSelected())) {
			setCheckbox(favoriteboxInCart, true);
			Util.WaitForAjax(getDriver());
			if (getDriver().findElements(By.linkText("Add to all lists"))
					.size() > 0) {
				$(addToAllFavoritesLists).click();
				$(SaveFavorites).click();
				waitABit(1000);
			}
			favoritefromcart = item.getText();
		}
	}

	public void removeFavoriteFromCart() {
		waitABit(1000);
		setCheckbox(favoriteboxInCart, false);
		Util.WaitForAjax(getDriver());
		if (getDriver().findElements(By.linkText("Remove from all lists"))
				.size() > 0) {
			$(removefromAllLists).click();
			$(SaveFavorites).click();
			waitABit(1000);
		}
		favoritefromcart = item.getText();
	}

}