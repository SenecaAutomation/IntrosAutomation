package com.intros.tests.iteration2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.TestData;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;



import com.library.steps.EndUserSteps;
import com.seneca.thucydides.util.ExcelTestData;
import com.seneca.thucydides.util.SenecaThucydidesParameterizedRunner;




@Story(LoginStoryTest.class)
@RunWith(SenecaThucydidesParameterizedRunner.class)
//@UseTestDataFrom("$DATADIR/introslogins.csv")
public class LoginStoryTest {
	
	private String UserName;
    private String Password;
    @TestData
    public static Collection getTestData() throws IOException {
	    return new ExcelTestData("introslogins.xls",LoginStoryTest.class).getData();
    }
		
	    /**
	     * @param a
	     * @param b
	     */
	    public LoginStoryTest(String a, String b) {
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
	public void testlogin() throws Throwable {
		  endUser.isOnHomePage(UserName);
		  endUser.gotoLogin();
		  
		  //login
		  endUser.enterUserName(UserName);
		  endUser.enterPassword(Password);
		  endUser.clickSubmitNow();
		  
		  //confirm login
		  endUser.should_see_home_page();
		  
		  //check currency
		  endUser.checkCurrency(UserName);
		
		  //Check Pages
		  endUser.checkCareerPage(UserName);
		  endUser.checkAboutUsPage(UserName);
		  
		  //logout
		  endUser.logOut();
		  endUser.should_see_home_page();
		
	}
}