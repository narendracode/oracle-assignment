package com.oracle.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.dao.MongoDaoInt;
import com.oracle.dto.Mongo;
import com.oracle.dto.TResponse;




@RestController
@RequestMapping("/assignment")
public class AssignmentController {
	
	
	@Autowired
	private MongoDaoInt mongo;
	 
	
	@RequestMapping(value="/part3/save/{key}/{value}",method = RequestMethod.GET)
	Mongo saveKeyValue(@PathVariable String key,@PathVariable String value){
		Mongo m = mongo.findByKey(key);
		if(m  != null){
			m.setValue(value);
			m.setKeyValue(key+"-"+value);
		}else{
			m = new Mongo(key,value,key+"-"+value);
		}
		
		return mongo.save(m);
	} 
	
	
	 
	@RequestMapping(value="/part3/key/{key}",method = RequestMethod.GET)
	TResponse getByKey(@PathVariable String key){
		Mongo m = mongo.findByKey(key);
		
		if(m==null){
			return new TResponse("error","Not found");
		}else{
			return new TResponse("ok","found",m);
		}
		
	}	
		
	
	@RequestMapping(value="/part1/{n}",method = RequestMethod.GET)
	String getTransaction(@PathVariable int n){
		return Arrays.toString(fib(n));
	}
	
	@RequestMapping(value="/part2/{n}", method = RequestMethod.GET)
	String getTransactions(@PathVariable int n){
    	int[] fibs = fib(n);
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
		
		return Arrays.toString(oddList.toArray());
	}

	
    private int[] fib(int length){
	    int[] series = new int[length];
	    series[0] = 1;
	    series[1] = 1;
	    for (int i = 2; i < length; i++) {
	      series[i] = series[i - 1] + series[i - 2];
	    }
	    return series;
    }
	
	
}
