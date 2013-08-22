package com.intros.pages;
 

import java.util.List;

import net.thucydides.core.pages.PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.util.PropLoader;
import com.util.Util;

public class MyInvoicesPage extends PageObject {

 	public MyInvoicesPage(WebDriver driver) {
		super(driver,PropLoader.getint("Timeout"));

	}

	@FindBy(linkText = "My Invoices")
	WebElement MyInvoices;

	@FindBy(id="ctl00_MainContentId_cbAll")
	WebElement SeeAllInvoice;

	@FindBy(id="ctl00_MainContentId_btnSearch")
	WebElement SearchInvoice;

	@FindBy(id="ctl00_MainContentId_dgOrder_ctl02_chkOrder")
	WebElement SelectInvoiceChkBox;

	@FindBy(id="ctl00_MainContentId_btnSubmit")
	WebElement SubmitBtn;

	@FindBy(id="ctl00_MainContentId_btnSubmit")
	WebElement SubmitEmailInvoice;

	@FindBy(id="ctl00_MainContentId_txtareaEMail")
	WebElement EmailField;
	
	@FindBy(id="ctl00_MainContentId_txtAssociateName")
	WebElement AssociateName;
	
	@FindBy(id="ctl00_MainContentId_dgOrder")
	public static WebElement OrderTbl;
	
	public void gotoMyInvoices() {
		clickOn(MyInvoices);
		Util.waitForPageLoaded(getDriver());
	}

	public void verifyInvoicePage() {
		Assert.assertTrue(getDriver().getTitle().contains("Invoice Copy"));
	}

	public void viewAllInvoices() {
		setCheckbox(SeeAllInvoice, true);
		Util.waitForPageLoaded(getDriver());
		clickOn(SearchInvoice);
		Util.waitForPageLoaded(getDriver());
		}

	public void verifyInvoiceSearchResult() {
		shouldContainText("Invoices from past 60 days");
		
	}

	public void verifyViewInvoice(){
		String onClkValue=null,invoiceNo=null;
		
		List<WebElement> getRows = OrderTbl.findElements(By.tagName("tr"));
		for(int i=1;i<getRows.size();i++){
			List<WebElement> col = getRows.get(i).findElements(By.tagName("td"));
			onClkValue = getDriver().findElement(By.xpath("//tbody/tr[11]/td/table/tbody/tr["+(i+1)+"]/td[2]/a")).getAttribute("onclick");
			invoiceNo = col.get(2).getText();
			Assert.assertTrue(onClkValue.contains(invoiceNo));
		}
	}
			
	public void emailInvoice() {
		setCheckbox(SelectInvoiceChkBox, true);
		clickOn(SubmitBtn);
		Util.waitForPageLoaded(getDriver());
		enter("Test Associate").into(AssociateName);
		enter("test@gmail.com").into(EmailField);
		clickOn(SubmitEmailInvoice);
		Util.waitForPageLoaded(getDriver());
	 
	}

	public void emailConformation() {
		shouldContainText("Your invoice copy request has been processed. You will receive the invoices via email shortly.");
	}


}
