package com.seneca.thucydides.util;


import java.util.Date;


import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

/**
 * @author satheesh.guduru
 *
 */
public class PageActions{
	
	public static final String TEXT = "textField";
	public static final String CLICK = "click" ;
	public static final String SUBMIT = "submit" ;
	public static final String SELECT = "select" ;
	public static final String PRESENT = "present" ;
	public static final String VERIFYTEXTINELEMET = "veryfytextinelement" ;
	public static final String PARAMETERNOTREQUIRED = "notrequired" ;
	public static String validation ="failed" ;
	public static boolean flag =false ;
	
	/**
	 * @param element
	 * @param action
	 * @param parameter
	 * @param fromTestName
	 * @param fromPage
	 * @param fromMethod
	 * @return
	 */
	public static void doAction(WebElement element,String action,String parameter,String stepDescription){
		
		long lStartTime =new Date().getTime(); // start time
		//System.out.println("lStartTime--->"+lStartTime);
		           try{
		        	  
		        	   if(element!=null && parameter!=null){
		        		   if(isElementPresent(element)){
		        			   if(action.equals(PRESENT)){
		        				   validation="passed";
		        			   }else if(action.equals(TEXT)){
		        				   element.clear();
		        				   element.sendKeys(parameter);
		        				   validation="passed";
		        			   }else if(action.equals(CLICK) || action.equals(SUBMIT) ){
		        				   element.click();
			        	    		validation="passed";
		        			   }else if(action.equals(VERIFYTEXTINELEMET)){
		        				   if(element.getText().toLowerCase().contains(parameter.toLowerCase())){
		        					   validation="passed";
		        				   }else{
		        					   validation="failed";
		        				   }
		        			   }
		        	   		}else{
		        	   			validation="failed";
		        	   		}
		        	   	}else{
		        	   		validation="failed";
		        	   	}
		        	   	
		              
		          
		           long lEndTime = new Date().getTime(); // end time
		          // System.out.println("lEndTime--->"+lEndTime);
		           int exeTime=(int)(lEndTime - lStartTime);
		         //  System.out.println("Time executed--->"+exeTime);
		   		   String exetime=getTime(exeTime);
		        //   System.out.println("Elapsed milliseconds: " + exetime);
		       
		           
		           //takeAScreenShot(parameter+":"+validation,stepDescription,exetime);
		           
		           } catch(Exception e){
			        	  e.printStackTrace();
			        	  validation ="failed";  
			           }
		           if(validation.equals("failed")){
		        	   
		   			Assert.fail(stepDescription+" failed");
		   		}
		   		
	}
	public static String getTime(int exectime){
		String str=null;
		if(exectime<100 && exectime>10){
			str="0.0"+exectime;
			
		}
		if(exectime<10){
			str="0.00"+exectime;
		}
		if(exectime<1000 && exectime>100){
			str="0."+exectime;
		}
		if(exectime>1000){
			
			String temp=new Integer(exectime).toString();
			int size=temp.length();
			
			String subStr=temp.substring(0,size-3);
			String subStr2=temp.substring(size-3,size);
			
			str=subStr+"."+subStr2;
		}
		return str;
		
	}
	
	
	/**
	 * @param element
	 * @return
	 */
	private static boolean isElementPresent(WebElement element) {
	    try {
	    	 
	    	element.getLocation();
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }
		
}


