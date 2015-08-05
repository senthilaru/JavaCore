/**
 *
 */
package com.spsa.puzzle.classic;

/**
 * @author SenthilArumugam SP
 *
 */
public class PascalTriangle {

	public static void main(String[] args) {
		PascalTriangle main = new PascalTriangle();
		main.printPascalTriangle(5);
	}

	public void printPascalTriangle(int level) {
		int[][] arr = new int[level][level];
		arr[0][0] = 1;
		for (int i = 0; i < level; i++) {
			arr[i][0] = 1;
			arr[i][i] = 1;
			for (int j = 1; j <= i; j++) {
				arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
			}
		}

		for (int[] element : arr) {
			for (int j = 0; j < arr.length; j++) {
				if (element[j] != 0) {
					System.out.print(element[j] + " ");
				}
			}
			System.out.println();
		}
	}
}
