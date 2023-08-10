package com.report.runConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

public class MethodInterceptor implements IMethodInterceptor {

	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
		// TODO Auto-generated method stub
		List<IMethodInstance> result = new ArrayList<IMethodInstance>();
		for (int i = 0; i < methods.size(); i++) {
			result.add(methods.get(i));
		}
		return result;
	}

//	@Override
//	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
//		List<IMethodInstance> result = new ArrayList<IMethodInstance>();
//		Map<String, String> test1 = new HashMap<>();
//		test1.put("name", "validateOfferesIsSelected2");
//		test1.put("count", "1");
//
//		Map<String, String> test2 = new HashMap<>();
//		test2.put("name", "validateHotelIsSelected2");
//		test2.put("count", "1");
//
//		List<Map<String, String>> list = new ArrayList<>();
//		list.add(test1);
//		list.add(test2);
//
//		for (int i = 0; i < methods.size(); i++) {
//			for (int j = 0; j < list.size(); j++) {
//				if (methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list.get(j).get("name"))) {
//					methods.get(i).getMethod().setInvocationCount(Integer.parseInt(list.get(j).get("count")));
//					result.add(methods.get(i));
//				}
//			}
//		}
//		return result;
//	}

}
