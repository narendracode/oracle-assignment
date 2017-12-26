package com.oracle;


import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;
import java.util.ArrayList;
public class AssignmentPart2 {

    public static void main(String args[]) {
    	
    	int[] fibs = fib(7);
    	List<Integer> list = Arrays.stream(fibs).boxed().collect(Collectors.toList());

    	List<Integer> oddList = new ArrayList<Integer>();
    	List<Integer> evenList = new ArrayList<Integer>();
    	list.stream().forEach((number) -> {
    		if(number % 2 ==0 )
    			evenList.add(number);
    		else
    			oddList.add(number);
    	});
    	
    	Collections.reverse(evenList);
    	Collections.reverse(oddList);
    	oddList.addAll(evenList);
    	
    	
    	System.out.println(Arrays.toString(oddList.toArray()));
    	
    	
    }
	
    
    public static int[] fib(int length){
	    int[] series = new int[length];
	    series[0] = 1;
	    series[1] = 1;
	    for (int i = 2; i < length; i++) {
	      series[i] = series[i - 1] + series[i - 2];
	    }
	    return series;
    }
}
