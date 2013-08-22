package com.intros.pages;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.thucydides.core.pages.PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.util.PropLoader;
import com.util.Util;

public class MyOrderGuidePage extends PageObject {

 	public MyOrderGuidePage(WebDriver driver) {
		super(driver, PropLoader.getint("Timeout"));
	}

	public static String itemcode;
	public static List<WebElement> favoritesElements;
 
	
	@FindBy(linkText = "Add to all lists")
	WebElement addToAllFavoritesLists;

	@FindBy(xpath = "//a[contains(@href, 'Order/FavoritesOrder.aspx')]")
	WebElement MyFavorites;

	@FindBy(linkText = "Remove from all lists")
	WebElement removefromAllLists;

	@FindBy(id="favoritesOnly")
	WebElement favoritesonly;

	@FindBy(id = "ctl00_TopNavContentId_TopNav_OrderGuides")
	WebElement MyOrderGuide;

	@FindBy(linkText = "Intros Order Guide")
	WebElement OrderGuide;

	@FindBy(xpath = "//div[@id='rogitems_ctl00_ogitem']/div[4]/div/input")
	WebElement addFavorites;

	@FindBy(xpath = "(//span[@class='og-sku-number'])[1]")
	WebElement item;
	
	@FindBy(linkText = "Save")
	WebElement SaveFavorites;
	
	@FindBy(xpath="//input[contains(@id,'Favorites')]")
	WebElement favoritesChecked;

	@FindBy(id = "ctl00_TopNavContentId_TopNav_mnuRRMainn0")
	WebElement CreateOrder;

	@FindBy(xpath = "(//input[contains(@id,'qtyBox')])[2]")
	WebElement QtyField;
	
	public static String itemCode;
	
	public void gotoOrderGuide() {
		clickOn(MyOrderGuide);
		Util.waitForPageLoaded(getDriver());
	}

	public void verifyOrderGuidePage() {
		waitABit(4000);
		assertThat(getTitle(),
				is("Select Order Guide - Global Premier"));
	}

	public void selectOrderGuide() {
		clickOn(OrderGuide);
		Util.waitForPageLoaded(getDriver());
	}

	public void verifySelectOrderGuidePage() {
		assertThat(getTitle(), is("Order Guide - Global Premier"));
	}

	public void addFavFromOrderGuides() {
		if (!(addFavorites.isSelected())) {
			setCheckbox(addFavorites, true);
			Util.WaitForAjax(getDriver());
 			if (getDriver().findElements(By.linkText("Add to all lists"))
					.size() > 0) {
				clickOn(addToAllFavoritesLists);
				clickOn(SaveFavorites);
			}
		}

		itemcode = item.getText();
	}

	public void gotoFavorites() {
		clickOn(MyFavorites);
		Util.waitForPageLoaded(getDriver());
	}

	public void confirmAddFavForOrderGuides() {
		gotoFavorites();
		Assert.assertTrue(getDriver().getPageSource().contains(itemcode));
	}

	public void delFavFromOrderGuides() {
		gotoOrderGuide();
		selectOrderGuide();
		if ((addFavorites.isSelected())) {
			setCheckbox(addFavorites, false);
			Util.WaitForAjax(getDriver());
			if (getDriver().findElements(By.linkText("Remove from all lists"))
					.size() > 0) {
				clickOn(removefromAllLists);
				clickOn(SaveFavorites);
			}
		}
		itemcode = item.getText();
	}

	public void confirmDelFavFromOrderGuides() {
		gotoFavorites();
		shouldNotBeVisible(By.linkText(itemcode));
	}
	
	public void selectFavoritesOnly(){
		$(favoritesonly).click();
		Util.WaitForAjax(getDriver());
	}

	public void verifyFavoritesOnly() {
   	List<WebElement> allCheckboxes=getDriver().findElements(By.xpath("//input[contains(@id,'Favorites')]"));
	for(WebElement checkboxes: allCheckboxes){
		Assert.assertTrue(checkboxes.isSelected());	
		}
	}

	public void verifyElementsinFavorites() {
		List<String> linktext = new ArrayList<String>();
	  favoritesElements=getDriver().findElements(By.xpath("//span[@class='og-sku-number']"));
	 	for (WebElement test:favoritesElements){
	 		linktext.add(test.getText());		
	 		System.out.println("linkText is......................." +linktext);
	 	}
	 	gotoFavorites();
	 	for(String link: linktext ){
	 		System.out.println("link is.................."+link);
	 		Assert.assertTrue(getDriver().getPageSource().contains(link));
	 	}
	}

	public void addItemFromOrderGuidelist() {
		String browser = (String) evaluateJavascript("return navigator.userAgent;");
		Pattern p = Pattern.compile("Chrome");
		Matcher m = p.matcher(browser);
		
		
		if (!(QtyField.getAttribute("value").isEmpty())) {
			enter("0").into(QtyField);
			QtyField.sendKeys(Keys.TAB);
			waitABit(3000);
		
			if(getDriver().findElements(By.linkText("Intros Order Guide")).size()>0){
				$(OrderGuide).click();
			}
			Util.WaitForAjax(getDriver());
			}
	    
	    if (m.find()) {
			System.out.println("WITH CHROME");
			enter("50").into(QtyField);
			QtyField.sendKeys(Keys.TAB);
			waitABit(2000);
			
		}
		 else {
			 System.out.println("WITH IE OR FF");
				enter("50").into(QtyField);
				QtyField.sendKeys(Keys.TAB);
		 }
	    Util.WaitForAjax(getDriver());
		if (Util.isAlertPresent(getDriver())) {
			getAlert().accept();
			waitABit(3000);
		}
		
		if (Util.isAlertPresent(getDriver())) {
			getAlert().accept();
			waitABit(3000);
		}
		
		Util.WaitForAjax(getDriver());
			
		// Finally get item code for verification at view cart
		itemCode = getDriver()
				.findElement(By.xpath("(//span[@class='og-sku-number'])[2]"))
				.getText().substring(1);
	
	}

	public void should_see_item_added() {
		waitABit(3000);
		assertThat(
				getDriver().findElement(By.xpath("(//div[contains(@id,'divitemadded')])[2]"))
						.getText(), containsString("Item added"));
		
	}


}