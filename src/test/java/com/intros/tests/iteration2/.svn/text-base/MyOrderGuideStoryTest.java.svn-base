package com.intros.tests.iteration2;

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
import com.intros.pages.MyOrderGuidePage;
import com.library.steps.EndUserSteps;
import com.requirements.Application.Orders;
import com.seneca.thucydides.util.ExcelTestData;
import com.seneca.thucydides.util.SenecaThucydidesParameterizedRunner;


@Story(Orders.OrderGuides.class)
@RunWith(SenecaThucydidesParameterizedRunner.class)
//@UseTestDataFrom("$DATADIR/OrderGuidelogins.csv")
public class MyOrderGuideStoryTest {
  
	private String UserName;
    private String Password;
    @TestData
    public static Collection getTestData() throws IOException {
	    return new ExcelTestData("OrderGuidelogins.xls",MyOrderGuideStoryTest.class).getData();
    }
		
	    /**
	     * @param a
	     * @param b
	     */
	    public MyOrderGuideStoryTest(String a, String b) {
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
	public void testFavoritesFromOrderGuides() throws Throwable {

	   endUser.isOnHomePage(UserName);
	   endUser.gotoLogin();
		  
		  //login
	   endUser.enterUserName(UserName);
	   endUser.enterPassword(Password);
	   endUser.clickSubmitNow();
		  
		  //confirm login
		endUser.should_see_home_page();
	    endUser.gotoOrderGuide();
		endUser.verifyOrderGuidePage();
		endUser.selectOrderGuide();
		endUser.verifySelectOrderGuidePage();
		
	    
       //test favorites	 
		endUser.addFavFromOrderGuides();
		endUser.confirmAddFavForOrderGuides();
		endUser.delFavFromOrderGuides();
		endUser.confirmDelFavFromOrderGuides();
		
		//Logout
		endUser.logOut();
		endUser.should_see_home_page();
 		
	}	
	
	@Test
	public void testFavoritesOnly() throws Throwable {

	   endUser.isOnHomePage(UserName);
	   endUser.gotoLogin();
			  
	  //login
	   endUser.enterUserName(UserName);
	   endUser.enterPassword(Password);
	   endUser.clickSubmitNow();	   
	   
	   
	   endUser.gotoOrderGuide();
	   endUser.verifyOrderGuidePage();
	   endUser.selectOrderGuide();
	   endUser.verifySelectOrderGuidePage();
		
	    
	   //select favorites only link
	   endUser.selectFavoritesOnly();
	   endUser.verifyFavoritesOnly();
	   endUser.verifyElementsinFavorites();
	   
	   
	   //logout
	   endUser.logOut();
	   endUser.should_see_home_page();
 		
	}	
	
	@Test
	public void testAddItemFromOrderGuide() throws Throwable{

	    endUser.isOnHomePage(UserName);
	    endUser.gotoLogin();
			  
		//login
	    endUser.enterUserName(UserName);
	    endUser.enterPassword(Password);
	    endUser.clickSubmitNow();
	
	    endUser.gotoOrderGuide();
		endUser.verifyOrderGuidePage();
		endUser.selectOrderGuide();
		endUser.verifySelectOrderGuidePage();
		
		//order item
		endUser.addItemFromOrderGuidelist();
		endUser.should_see_item_added();
		
		// check the order in cart
		endUser.gotoViewCart();
		endUser.reviewCart(MyOrderGuidePage.itemCode);
		
		
		//log out
		endUser.logOut();
		endUser.should_see_home_page();
 	}
}