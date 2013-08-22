package com.library.steps;

import org.junit.Assert;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;

import com.util.BaseUtilSteps;
import com.util.PropLoader;
 

public class EndUserSteps extends BaseUtilSteps {

	public EndUserSteps(Pages pages) {
		super(pages);
	}
	
	 public String UserName;
	 public String Password;
       
	private static final long serialVersionUID = 1L;

	@Step
	public void isOnHomePage(String userName) {
		getLoginPage().open();
	}
	@Step
	public void gotoLogin() {
		getLoginPage().gotoLogin();
	}

	@Step
	public void checkCareerPage(String userName) {
		getLoginPage().checkCareerPage(userName);
		
	}
	
	@Step
	public void checkAboutUsPage(String userName) {
		getLoginPage().checkAboustUsPage(userName);
		
	}
	@Step
	public void enterUserName(String uname) {
		getLoginPage().enterUserName(uname);
	}

	@Step
	public void enterPassword(String pword) {
		getLoginPage().enterPassword(pword);
	}

	@Step
	public void clickSubmitNow() {
		getLoginPage().clickSubmitNow();
  
	}
	
	@Step
	public void logOut() {
		getLoginPage().logOut();
	}
	
	
	@Step
	public void should_see_home_page() {
		getLoginPage().should_see_home_page();
	}
	
			
	@Step
	public void checkCurrency(String userName) {
		getLoginPage().checkCurrency(userName);			
	}		
		 
	//My Invoices
	@Step
	public void gotoMyInvoices() {
		 getInvoicesPage().gotoMyInvoices();
	}
	
	@Step
	public void verifyInvoicePage() {
 		getInvoicesPage().verifyInvoicePage();
	}
	@Step
	public void viewAllInvoices() {
 	    getInvoicesPage().viewAllInvoices();	
	}
	
	@Step
	public void verifyInvoiceSearchResult() {
 		getInvoicesPage().verifyInvoiceSearchResult();
	}
	@Step
	public void verifyViewInvoice() {
 		getInvoicesPage().verifyViewInvoice();
	}
	@Step
	public void emailInvoice() {
 		getInvoicesPage().emailInvoice();
	}
	@Step
	public void emailConfirmation() {
 		getInvoicesPage().emailConformation();
	}
	
	//search Item
	@Step
	public void searchItem() {
		getSearchPage().searchItem(PropLoader.get("ItemCode"));
	}

	@Step
	public void addToCart(String itmQty) {
		getSearchPage().addToCart(itmQty);
	}
	

	//my favorites
	@Step
	public void addFavorites() {
         getFavoritesPage().addFavorites();		
	}
	
	@Step
	public void confirmAddFavorites() {
		getFavoritesPage().confirmAddFavorites();
		
	}
	
	@Step
	public void deleteFavorites() {
		getFavoritesPage().deleteFavorites();
		
	}
	
	@Step
	public void confirmDeleteFavorites() {
		getFavoritesPage().confirmDeleteFavorites();
		
	}
	
	@Step
	public void selectFavoriteFromCart() {
		getViewCartPage().selectFavoriteFromCart();

	}

	@Step
	public void confirmItemInFavorites() {
		getFavoritesPage().confirmItemInFavorites();
	}
	
    @Step
	public void removeFavoriteFromCart() {
		getViewCartPage().removeFavoriteFromCart();
		
	}
   
    @Step
	public void confirmRemoveInFavorites() {
		 getFavoritesPage().confirmRemoveInFavorites();
	}
	
// submit order steps
	@Step
	public void verifyItem() {
		getSearchPage().verifySearchResults();
	}
 

	@Step
	public void displayItemAddedConfirmation() {
		getSearchPage().displayItemAddedConfirmation();
	}
	
	@Step
	public void checkoutFromConfirmationMessage() {
			getSearchPage().checkoutFromConfirmationMessage();
	}

	@Step
	public void checkOut() {
		getViewCartPage().checkoutCart();
	}

	@Step
	public void checkoutConfirm() {
		getViewCartPage().checkOutConfirmation();
	}
	
	//view cart
	@Step
	public void gotoViewCart() {
		getViewCartPage().gotoViewCart();
	}
	
	@Step
	public void reviewCart(String itemCode) {
		getViewCartPage().reviewCart(itemCode);
	}
	
	// Update Cart pages
	@Step
	public void updateQty(String qty) {
		getViewCartPage().updateQty(qty);
	}
		
	@Step
	public void confirmUpdateQty() {
		getViewCartPage().confirmUpdateQty();
	}
		
	@Step
	public void deleteItem() {
		getViewCartPage().deleteItem();
	}
	
	@Step
	public void confirmItemDelete() {
		getViewCartPage().confirmItemDelete();
	}
	
	//Order Guide
	@Step
	public void addFavFromOrderGuides() {
		getOrderGuidePage().addFavFromOrderGuides();
	}
	@Step
	public void gotoOrderGuide() {
		getOrderGuidePage(). gotoOrderGuide();
	}
	@Step
	public void verifyOrderGuidePage() {
		getOrderGuidePage().verifyOrderGuidePage();
	}
	@Step
	public void selectOrderGuide() {
		getOrderGuidePage().selectOrderGuide();
	}
	@Step
	public void verifySelectOrderGuidePage() {
		getOrderGuidePage().verifySelectOrderGuidePage();
		
	}
	@Step
	public void confirmAddFavForOrderGuides() {
		getOrderGuidePage().confirmAddFavForOrderGuides();
	}
	
    @Step
	public void confirmDelFavFromOrderGuides() {
		getOrderGuidePage().confirmDelFavFromOrderGuides();
	}
    
    @Step
 	public void delFavFromOrderGuides() {
    	getOrderGuidePage().delFavFromOrderGuides();
	}
    @Step
	public void selectFavoritesOnly() {
		getOrderGuidePage().selectFavoritesOnly();
		
	}
    @Step
	public void verifyFavoritesOnly() {
		getOrderGuidePage().verifyFavoritesOnly();
		
	}
    @Step
	public void verifyElementsinFavorites() {
    	getOrderGuidePage().verifyElementsinFavorites();
		
	}
   
   
    @Step
	public void confirmRemoveInFavorites(String accName) {
		 getFavoritesPage().confirmRemoveInFavorites();
	}
    @Step
	public void addItemFromOrderGuidelist() {
		getOrderGuidePage().addItemFromOrderGuidelist();
	}
    @Step
	public void should_see_item_added() {
		getOrderGuidePage().should_see_item_added();
		
	}
    @Step
    public void results(String str){
    
    	System.out.println("-----in user results method----->"+str);
    	if(str.contains("failed")){
    		Assert.fail(str);	
    	}
    }
	
}