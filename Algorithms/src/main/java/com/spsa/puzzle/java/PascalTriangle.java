/**
 *
 */
package com.spsa.puzzle.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SenthilArumugam SP
 *
 */
public class PascalTriangle {

	public static void main(String[] args) {
		PascalTriangle main = new PascalTriangle();
		main.printPascalTriangle(3);
	}

	public void printPascalTriangle(int level) {
		List<List<Integer>> levelArr = new ArrayList<List<Integer>>();
		for (int i = 0; i < level; i++) {
			List<Integer> rowElements = new ArrayList<Integer>();
			rowElements.add(1);
			levelArr.add(rowElements);
		}

		for (int i = 1; i < level; i++) {
			List<Integer> prevArr = levelArr.get(i - 1);
			List<Integer> currentArr = levelArr.get(i);
			for (int j = 1; j <= i; j++) {
				int sum = 0;
				if (j == level - 1 || prevArr.size() < j) {
					sum = 1;
				} else {
					sum = prevArr.get(j - 1) + prevArr.get(j);
				}
				currentArr.add(j, sum);
				// TODO: Incomplete logic
			}
		}

		for (List<Integer> list : levelArr) {
			for (Integer integer : list) {
				System.out.print(integer + " ");
			}
			System.out.println();
		}

	}
}
