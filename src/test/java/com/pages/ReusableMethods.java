package com.pages;

import java.util.List;


public class ReusableMethods {
	
	 public <T> boolean areArrayListsEqual(List<T> list1, List<T> list2) {
	        // Check if the sizes of the two lists are the same
	        if (list1.size() != list2.size()) {
	            return false;
	        }

	        // Compare each element of the lists
	        for (int i = 0; i < list1.size(); i++) {
	            if (!list1.get(i).equals(list2.get(i))) {
	                return false;
	            }
	        }

	        return true;
	    }

}
