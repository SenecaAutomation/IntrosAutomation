package com.util;

import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import com.intros.pages.LoginPage;
import com.intros.pages.MyFavoritesPage;
import com.intros.pages.MyInvoicesPage;
import com.intros.pages.MyOrderGuidePage;
import com.intros.pages.SearchPage;
import com.intros.pages.ViewCartPage;

 
public class BaseUtilSteps extends ScenarioSteps {

	/**
	 * This  class returns all the pages
	 */
	private static final long serialVersionUID = 1L;

	public BaseUtilSteps(Pages pages) {
		super(pages);
	}
	
	public LoginPage getLoginPage() {
		return getPages().currentPageAt(LoginPage.class);
	}

	public MyInvoicesPage getInvoicesPage(){
		   return new MyInvoicesPage(getDriver());
	   }

	public MyFavoritesPage getFavoritesPage() {
		return new MyFavoritesPage(getDriver());
	}

	public ViewCartPage getViewCartPage() {
		return new ViewCartPage(getDriver());
	}

	public SearchPage getSearchPage() {
		return new SearchPage(getDriver());
	}
		
	public MyOrderGuidePage getOrderGuidePage(){
	   return new MyOrderGuidePage(getDriver());
	}
		
}
