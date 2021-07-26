package com.spsa.algo.warmup;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class DecimalFormats {

	public static void plusMinus(List<Integer> arr) {
		List<Integer> p = arr.stream().filter(a -> a > 0).collect(Collectors.toList());
        List<Integer> n = arr.stream().filter(a -> a < 0).collect(Collectors.toList());
        List<Integer> z = arr.stream().filter(a -> a == 0).collect(Collectors.toList());
        
        float total = arr.size();
        System.out.printf("%.6f%n", ((float) p.size() / total));
        System.out.printf("%.6f%n", ((float) n.size() / total));
        System.out.printf("%.6f%n", ((float) z.size() / total));
        
	}

	public static void main(String[] args) {

		List<Integer> input = Arrays.asList(-4, 3, -9, 0, 4, 1);
		plusMinus(input);
	}

}
