package com.report.runConfig;

import java.lang.reflect.Constructor;

import java.lang.reflect.Method;
import java.util.List;

import org.testng.IAnnotationTransformer;
import org.testng.IMethodInstance;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;


public class AnnotationTransformer implements IAnnotationTransformer{
	
	 @Override
	    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
	        annotation.setRetryAnalyzer((Class<? extends IRetryAnalyzer>) Retry.class);
	        
	    }
//	 @Override
	 

}
