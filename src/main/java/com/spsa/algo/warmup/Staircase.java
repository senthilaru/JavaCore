package com.spsa.algo.warmup;

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

	public static void main(String[] args) {
		staircase(6);
	}
}
