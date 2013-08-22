package com.intros.tests.iteration1;

import java.io.IOException;
import java.util.Collection;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.TestData;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.library.steps.EndUserSteps;
import com.requirements.Application.Reports;
import com.seneca.thucydides.util.ExcelTestData;
import com.seneca.thucydides.util.SenecaThucydidesParameterizedRunner;
import com.util.PropLoader;


@Story(Reports.MyFavorites.class)
@RunWith(SenecaThucydidesParameterizedRunner.class)
//@UseTestDataFrom("$DATADIR/introslogins.csv")
public class MyFavoritesStoryTest {

	private String UserName;
    private String Password;
    
    String iqty=PropLoader.get("ItemQty");
    String icode=PropLoader.get("ItemCode");
    
    @TestData
    public static Collection getTestData() throws IOException {
	    return new ExcelTestData("introslogins.xls",MyFavoritesStoryTest.class).getData();
    }
		
	    /**
	     * @param a
	     * @param b
	     */
	    public MyFavoritesStoryTest(String a, String b) {
	        this.UserName = a;
	        this.Password = b;
	    }    
	
    @Managed(uniqueSession=true)
	public WebDriver driver;
	
    
	@ManagedPages
	public Pages pages;


	@Steps
	public EndUserSteps endUser;

	@Test
	public void favorites() throws Throwable {

	//login
	endUser.isOnHomePage(UserName);
	endUser.gotoLogin();
	endUser.enterUserName(UserName);
	endUser.enterPassword(Password);
	endUser.clickSubmitNow();
	endUser.should_see_home_page();

	//search for item
	endUser.searchItem();
    endUser.verifyItem();

   //test favorites
	endUser.addFavorites();
	endUser.confirmAddFavorites();
	endUser.addToCart(iqty);
	endUser.displayItemAddedConfirmation();
	endUser.deleteFavorites();
	endUser.confirmDeleteFavorites();
		    
	//test favorites from view cart
	endUser.gotoViewCart();
	endUser.reviewCart(icode);	
	endUser.selectFavoriteFromCart();
	endUser.confirmItemInFavorites();
	endUser.gotoViewCart();
	endUser.removeFavoriteFromCart();
	endUser.confirmRemoveInFavorites();  
	
	//logout	
	endUser.logOut();
	endUser.should_see_home_page();		

	}
	
}











		