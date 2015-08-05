/**
 *
 */
package com.spsa.puzzle.recurssion;

/**
 * @author SenthilArumugam SP
 *
 */
public class PascalTriangle {

	public static void main(String[] args) {
		PascalTriangle main = new PascalTriangle();
		main.printPascalTriangle(5);
	}

	public int pascal(int i, int j) {
		if (j == 0 || i == j) {
			return 1;
		}
		return pascal(i - 1, j - 1) + pascal(i - 1, j);
	}

	public void printPascalTriangle(int level) {
		for (int i = 0; i < level; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(pascal(i, j) + " ");
			}
			System.out.println();
		}
	}

}
