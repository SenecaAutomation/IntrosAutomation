package com.seneca.thucydides.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DriverMethods {
	
	  public static void typeMethod(String key, String value,WebDriver driver)							
		{
			if (value.length() > 0)
			{
				WebElement element = driver.findElement(By.id(key));
			    element.clear();
			    element.sendKeys(value);
			 
			}
		}
	  public boolean isElementPresent(By by,WebDriver driver) {
		    try {
		      driver.findElement(by);
		      return true;
		    } catch (org.openqa.selenium.NoSuchElementException e) {
		      return false;
		    }
		  }  
	
}
