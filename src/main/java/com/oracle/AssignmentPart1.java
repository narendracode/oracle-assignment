package com.oracle;

import java.util.Arrays;

public class AssignmentPart1 {
	

    public static void main(String args[]) {

    	System.out.print(Arrays.toString(fib(5)));
    	
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
