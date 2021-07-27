package com.spsa.algo.warmup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Staircase {

	/*
	 * Complete the 'staircase' function below.
	 *
	 * The function accepts INTEGER n as parameter.
	 */

	public static void staircase(int n) {
		for (int i = 1; i <= n; i++) {
			String l = "%" + n + "s";
			System.out.printf(l, "#".repeat(i));
			System.out.println();
		}
	}
	
	public static void miniMaxSum(List<Integer> arr) {
	    	List<Integer> streams = new ArrayList<>();
	        for(int i =1; i< arr.size(); i++) {
	        	int sum = arr.stream().skip(i).mapToInt(p -> {
	        		System.out.println("p :"+p);
	        		return p;}).sum();
				streams.add(sum);
				System.out.println("sum:"+sum);
	        }
	        Integer min = streams.stream().min(Comparator.comparing(p -> p)).get();
	        Integer max = streams.stream().max(Comparator.comparing(p -> p)).get();
	        System.out.println(min + " " + max);
	    }

	public static void main(String[] args) {
//		staircase(6);
		miniMaxSum(Arrays.asList(1,2,3,4,5));
	}
}
