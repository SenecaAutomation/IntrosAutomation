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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.library.steps.EndUserSteps;
import com.requirements.Application.Reports;
import com.seneca.thucydides.util.ExcelTestData;
import com.seneca.thucydides.util.SenecaThucydidesParameterizedRunner;


@Story(Reports.MyInvoices.class)
@RunWith(SenecaThucydidesParameterizedRunner.class)
//@UseTestDataFrom("$DATADIR/introslogins.csv")
public class MyInvoicesStoryTest {

    Logger logger = LoggerFactory.getLogger(MyInvoicesStoryTest.class);
    
    private String UserName;
    private String Password;
    @TestData
    public static Collection getTestData() throws IOException {
	    return new ExcelTestData("introslogins.xls",MyInvoicesStoryTest.class).getData();
    }
		
	    /**
	     * @param a
	     * @param b
	     */
	    public MyInvoicesStoryTest(String a, String b) {
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
	public void invoices() throws Throwable {
		//login
		endUser.isOnHomePage(UserName);
		endUser.gotoLogin();
		endUser.enterUserName(UserName);
		endUser.enterPassword(Password);
		endUser.clickSubmitNow();
		endUser.should_see_home_page();

       //test invoices
		endUser.gotoMyInvoices();
		endUser.verifyInvoicePage();
	  	endUser.viewAllInvoices ();
	 	endUser.verifyInvoiceSearchResult();
	 	
	 	if(!(driver.getPageSource().contains("no invoices"))){
	 		endUser.verifyViewInvoice();
	 		endUser.emailInvoice();
	 		endUser.emailConfirmation();
	 	}
		 
	  //logout	
	 	  endUser.logOut();
		  endUser.should_see_home_page();		
	}	
} 