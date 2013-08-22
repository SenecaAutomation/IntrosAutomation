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

import com.library.steps.EndUserSteps;
import com.requirements.Application.Orders;
import com.seneca.thucydides.util.ExcelTestData;
import com.seneca.thucydides.util.SenecaThucydidesParameterizedRunner;
import com.util.PropLoader;

@Story(Orders.UpdateOrder.class)
@RunWith(SenecaThucydidesParameterizedRunner.class)
//@UseTestDataFrom("$DATADIR/introslogins.csv")
public class UpdateOrderStoryTest {
	
	private String UserName;
    private String Password;
	 
	 String icode=PropLoader.get("ItemCode");
	 String iqty=PropLoader.get("ItemQty");
	 
	 @TestData
	    public static Collection getTestData() throws IOException {
		    return new ExcelTestData("introslogins.xls",UpdateOrderStoryTest.class).getData();
	    }
			
		    /**
		     * @param a
		     * @param b
		     */
		    public UpdateOrderStoryTest(String a, String b) {
		        this.UserName = a;
		        this.Password = b;
		    }    
	
	
    @Managed(uniqueSession = true)
	public WebDriver driver;
	
	@ManagedPages
	public Pages pages;
	
	@Steps
	public EndUserSteps endUser;

	@Test
	public void updateOrder(){
	
		//login
		endUser.isOnHomePage(UserName);
		endUser.gotoLogin();
		endUser.enterUserName(UserName);
		endUser.enterPassword(Password);
		endUser.clickSubmitNow();
		endUser.should_see_home_page();   
	    
		//add item
	    
	    endUser.searchItem();
	    endUser.verifyItem();
		endUser.addToCart(iqty);
		endUser.displayItemAddedConfirmation(); 
		
		//update quantity
		endUser.gotoViewCart();
		endUser.reviewCart(icode);
		endUser.updateQty("17");
		endUser.confirmUpdateQty();
		
		//delete item
		endUser.deleteItem();
		endUser.confirmItemDelete();
				
 
		//logout	
		endUser.logOut();
		endUser.should_see_home_page();		
		 
	}

}
