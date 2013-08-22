package com.seneca.thucydides.util;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.thucydides.core.model.TestOutcome;
import net.thucydides.core.model.TestResult;
import net.thucydides.core.model.TestTag;




public class CommonUtil {
	
	private static Map <String,TestOutcomeDetails> testOutcomeDetails;

	  private static final Logger logger = LoggerFactory.getLogger(CommonUtil.class);
	public static Map<String, TestOutcomeDetails> getTestOutcomeDetails() {
		return testOutcomeDetails;
	}


	public static void setTestOutcomeDetails(Map<String, TestOutcomeDetails> testOutcomeDetails) {
		CommonUtil.testOutcomeDetails = testOutcomeDetails;
	}


	public static void setTestoutComeTags(TestOutcome testoutcome){
		
		//logger.info("Method Name------>"+testoutcome.getMethodName());
		
		List<TestTag> tags=new ArrayList<TestTag>();
		Map <String,TestOutcomeDetails> testOutcomes =CommonUtil.getTestOutcomeDetails();
		String test_type="";
		if(testOutcomes.size()==1){
			Iterator itr=testOutcomes.keySet().iterator();
			 test_type=testOutcomes.get(itr.next()).getTestType();
		}
		TestOutcomeDetails testOutcomeDetails;
		if(test_type.toLowerCase().contains("automation")){
//			logger.info("test_type--->"+test_type);
			testOutcomeDetails=testOutcomes.get(testoutcome.getTestCase().getSimpleName());
		    String reqId=testOutcomeDetails.getRequirementId();
		    if(!reqId.toLowerCase().contains("no")){
		    	String requirement="requirementid:"+reqId;
		    	TestTag testTag=TestTag.withValue(requirement);
		    	tags.add(testTag);
		    	logger.info("Set RequiremenId:"+reqId+" for test case-->"+testoutcome.getMethodName());
		    }
		    String testType=testOutcomeDetails.getTestType();
		    if(!testType.toLowerCase().contains("no")){
		    	String tetType="test_type:"+testType;
				TestTag testTag2=TestTag.withValue(tetType);
				tags.add(testTag2);
				logger.info("Set Testtype:"+testType+" for test case-->"+testoutcome.getMethodName());
		    }
	    	testoutcome.addTags(tags);
	    }else{
             Object[] arr=	testOutcomes.keySet().toArray();
             String key=null;
            for(int i=0;i<arr.length;i++){
              if(testoutcome.getMethodName().contains(arr[i].toString())){
            	  key=arr[i].toString();
              }
            }
            testOutcomeDetails=testOutcomes.get(key);
            testoutcome=testoutcome.asManualTest();
            
            String reqId=testOutcomeDetails.getRequirementId();
		    if(!reqId.toLowerCase().contains("no")){
		    	String requirement="requirementid:"+reqId;
		    	TestTag testTag=TestTag.withValue(requirement);
		    	tags.add(testTag);
		    	logger.info("Set RequiremenId: "+reqId+" for test case: "+testOutcomeDetails.getTestDescription());
		    }
		    String testType=testOutcomeDetails.getTestType();
		    if(!testType.toLowerCase().contains("no")){
		    	String tetType="test_type:"+testType;
				TestTag testTag2=TestTag.withValue(tetType);
				tags.add(testTag2);
				logger.info("Set Testtype: "+testType+" for test case: "+testOutcomeDetails.getTestDescription());
		    }
		    testoutcome.addTags(tags);
		    String testResult=testOutcomeDetails.getTestResult();
		    if(testResult.toLowerCase().contains("failed")){
		    	testoutcome.setTestFailureCause( new AssertionError(testOutcomeDetails.getTestDescription()+" failed"));
		    	logger.info(testOutcomeDetails.getTestDescription()+" is  FAILED");
		    	testoutcome.setAnnotatedResult(TestResult.FAILURE);
		    }else if(testResult.toLowerCase().contains("passed")){
		    	testoutcome.setAnnotatedResult(TestResult.SUCCESS);
		    	logger.info(testOutcomeDetails.getTestDescription()+" is  PASSED");
		    }else if(testResult.toLowerCase().contains("pending")){
		    	
		    }else if(testResult.toLowerCase().contains("ignored")){
		    	
		    }
	    	testoutcome.setTitle(testOutcomeDetails.getTestDescription());
		}
	}


	
		
}
