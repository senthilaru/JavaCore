/**
 *
 */
package com.spsa.rnd.datastructure.classic;

/**
 * @author sarumu1
 *
 */
public class PreOrderTraversal {

	public static void main(String[] args) {
		Integer[] input = { 3, 2, 1, 5, 4, 6 };
		isPreorderTraversal(input);
	}

	public static boolean isPreorderTraversal(Integer[] treeElements) {
		Integer rootNode = null;
		if (treeElements != null && treeElements.length > 0) {
			rootNode = treeElements[0];
		}
		for (int i = 1; i < treeElements.length - 1; i++) {
			int currentElement = treeElements[i];

			// Left Tree
			if (rootNode >= currentElement && treeElements[i + 1] <= currentElement) {

			} else {
				System.out.println("Left Tree:  Left Traversal is completed at" + currentElement);
			}
			if (rootNode >= currentElement && treeElements[i + 1] > currentElement) {
				//System.out.println("Left Tree:  Right Traversal Started at" + currentElement);
			} else {

			}

			// Right Tree 3,2,1,5,4,6
			if (rootNode < currentElement && treeElements[i + 1] <= currentElement) {

			} else {
				System.out.println("Right Tree:  Left Traversal is completed at" + currentElement);
			}

			if (rootNode < currentElement && treeElements[i + 1] > currentElement) {
				//System.out.println("Right Tree:  Right Traversal Started at" + currentElement);
			} else {

			}

		}
		return false;
	}
}
