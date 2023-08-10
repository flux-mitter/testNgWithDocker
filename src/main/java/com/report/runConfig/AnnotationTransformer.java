package com.report.runConfig;

import java.lang.reflect.Constructor;

import java.lang.reflect.Method;
import java.util.List;

import org.testng.IAnnotationTransformer;
import org.testng.IMethodInstance;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

import com.setup.RunManager;


public class AnnotationTransformer implements IAnnotationTransformer{
	
	 @Override
	    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
	        annotation.setRetryAnalyzer((Class<? extends IRetryAnalyzer>) Retry.class);
	        
	       // if(testMethod.getName().equalsIgnoreCase(RunManager.getExcelValue().))
	       // RunManager.getExcelValue().get(testMethod.getName());
	        annotation.setDescription(RunManager.getExcelValue().get(testMethod.getName()).getTestCaseDescription());
	        if(RunManager.getExcelValue().get(testMethod.getName()).getExecute().equalsIgnoreCase("Yes"))
	        {
	        annotation.setEnabled(true);
	        }
	        else
	        {
	        	annotation.setEnabled(false);
	        }
	        annotation.setInvocationCount(RunManager.getExcelValue().get(testMethod.getName()).getInvocationCount());
	        annotation.setPriority(RunManager.getExcelValue().get(testMethod.getName()).getPriority());
	        
	    }
//	 @Override
	 

}
