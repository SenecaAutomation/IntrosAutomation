package com.intros.pages;

import net.thucydides.core.pages.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.util.PropLoader;
import com.util.Util;

public class MyFavoritesPage extends PageObject {
	 
	static String itemname;
	 
	public MyFavoritesPage(WebDriver driver) {
		super(driver,PropLoader.getint("Timeout"));
	}

	@FindBy(xpath = "//input[contains(@id,'Favorites')]")
	WebElement favoriteCheckBox;

	@FindBy(linkText = "Add to all lists")
	WebElement addToAllFavoritesLists;

	@FindBy(id="ctl00_TopNavContentId_TopNav_Favorites")
	WebElement MyFavorites;
		
	@FindBy(linkText = "Remove from all lists")
	WebElement removefromAllLists;
 
	@FindBy(linkText = "Save")
	WebElement SaveFavorites;
 
	
	public void gotoFavorites() {
			$(MyFavorites).click();
			Util.waitForPageLoaded(getDriver());
	}
	
	
	public void addFavorites() {
	  itemname = getDriver().findElement(By.id("ctl00_MainContentId_ctl00_lblDescription")).getText();
		if (!(favoriteCheckBox.isSelected())) {
			setCheckbox(favoriteCheckBox, true);
			Util.WaitForAjax(getDriver());
		if (getDriver().findElements(By.linkText("Add to all lists")).size()>0){
			$(addToAllFavoritesLists).click();
			$(SaveFavorites).click();
			waitABit(1000);
			}
		}
	}

	public void confirmAddFavorites() {
		gotoFavorites();
		shouldBeVisible(By.linkText(itemname));
		getDriver().findElement(By.linkText(itemname)).click();
	}

	public void deleteFavorites() {
		waitABit(2000);
		setCheckbox(favoriteCheckBox, false);
		Util.WaitForAjax(getDriver());
		if (getDriver().findElements(By.linkText("Remove from all lists")).size()>0) {
			$(removefromAllLists).click();
			$(SaveFavorites).click();
			waitABit(1000);
		}
	}

	public void confirmDeleteFavorites() {
		gotoFavorites();
		shouldNotBeVisible(By.linkText(itemname));
	}


	public void confirmItemInFavorites() {
		gotoFavorites();
		shouldBeVisible(By.linkText(ViewCartPage.favoritefromcart));
	}


	public void confirmRemoveInFavorites() {
		gotoFavorites();
		shouldNotBeVisible(By.linkText(ViewCartPage.favoritefromcart));
		
	}	

}