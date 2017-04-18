package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.WeakHashMap;

public class Main {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
	    
	    List<String> list = new ArrayList<String>();
	    
	    list.add("1");
	    list.add("2");
	    
	    list.add("3");
	    list.add("1");
	    list.add("4");
	    list.add("1");
	    
	    
	    for (String string : list){
            if(string.equals("4")){
                list.remove(string);
            }
        }
	    
	    
	}
	

}
