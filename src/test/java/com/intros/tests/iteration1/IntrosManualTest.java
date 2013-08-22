package com.intros.tests.iteration1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;


import net.thucydides.core.annotations.Story;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.seneca.thucydides.util.ExcelTestData;
import com.seneca.thucydides.util.SenecaParameterizedTestRunner;

import com.seneca.thucydides.util.SenecaParameterizedTestRunner.Parameters;

@RunWith(SenecaParameterizedTestRunner.class)
@Story(IntrosManualTest.class)
public class IntrosManualTest {
	
	@Parameters
    public static Collection getTestData() throws IOException {
        return new ExcelTestData("Intros_Test_Cases.xls",IntrosManualTest.class).getData();
    }

	@Test
    public void introsManualTestCases(){
    } 
    
}
