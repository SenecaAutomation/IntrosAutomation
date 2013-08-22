package com.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class Util {

	public static boolean isAlertPresent(WebDriver driver) {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException Ex) {
			return false;
		}
	}
	
	
	public static void WaitForAjax(WebDriver driver)
	{
		boolean ajaxIsComplete = false;
	    while (!ajaxIsComplete)
	    {
	        ajaxIsComplete =  (Boolean) ((JavascriptExecutor)driver).executeScript("return jQuery.active == 0");
	        try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    }
	}
	
	
	public static void waitForPageLoaded(WebDriver driver) { 

		boolean pageload = false;
	    while (!pageload)
	    {
	        pageload =  (Boolean) ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete"); 
	        try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    }
  } 
 
}
