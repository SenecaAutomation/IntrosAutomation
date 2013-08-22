package com.seneca.thucydides.util;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.thucydides.core.ThucydidesSystemProperty;
import net.thucydides.core.model.TestOutcome;
import net.thucydides.core.model.TestTag;
import net.thucydides.core.model.TestTag.TestTagBuilder;
import net.thucydides.core.webdriver.WebdriverManager;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;

public class SenecaListener extends RunListener
{
	
	 
		
	/**
	 * Called before any tests have been run.
	 * */
	public void testRunStarted(Description description)	throws java.lang.Exception
	{
		System.out.println("Number of testcases to execute : " + description.testCount());
	}

	/**
	 *  Called when all tests have finished
	 * */
	public void testRunFinished(Result result) throws java.lang.Exception
	{
		
		System.out.println("Number of testcases executed : " + result.getRunCount());
	}

	/**
	 *  Called when an atomic test is about to be started.
	 * */
	public void testStarted(Description description) throws java.lang.Exception
	{
		 
		System.out.println("Starting execution of test case : "+ description.getMethodName());
	}

	/**
	 *  Called when an atomic test has finished, whether the test succeeds or fails.
	 * */
	public void testFinished(Description description) throws java.lang.Exception
	{
		
		System.out.println("Finished execution of test case : "+ description.getMethodName());
		/*TestOutcome testOutCome=TestOutcome.forTest(description.getMethodName(), description.getTestClass());
		//Set<TestTag> tags=testOutCome.getTags();
	   List<TestTag> tags=new ArrayList<TestTag>();
		//Iterator<TestTag> itr=tags.iterator();
		TestTag testTag=TestTag.withValue("release:Satheesh Guduru");
		//tags.add(index, testTag)
		tags.add(testTag);
        testOutCome.addTags(tags);	
		

	
		Set<TestTag> tags2=testOutCome.getTags();
		Iterator<TestTag> itr2=tags2.iterator();
		while(itr2.hasNext()){
		 TestTag testTag2=(TestTag)itr2.next();
		
		 System.out.println("Name--->"+testTag2.getName()+"Type---"+testTag2.getType()+testTag2.toString());
		}
		/*+
		//System.out.println(testOutCome.getTagValue("Requirement").or(""));
		String columns = ThucydidesSystemProperty.THUCYDIDES_EXTRA_COLUMNS.from(testOutCome.getEnvironmentVariables(),"");
		List<String> extraColumns =ImmutableList.copyOf(Splitter.on(",").omitEmptyStrings().trimResults().split(columns));
		 for(String extraColumn : extraColumns) {
			 System.out.println(testOutCome.getTagValue(extraColumn).or(""));
	        }
		// System.out.println("columns---->"+columns);
		*/
		
			
			
	}

	/**
	 *  Called when an atomic test fails.
	 * */
	public void testFailure(Failure failure) throws java.lang.Exception
	{
		
		System.out.println("Execution of test case failed : "+ failure.getMessage());
	}

	/**
	 *  Called when a test will not be run, generally because a test method is annotated with Ignore.
	 * */
	public void testIgnored(Description description) throws java.lang.Exception
	{
		System.out.println("Execution of test case ignored : "+ description.getMethodName());
	}
	
	
}