/**
 *
 */
package com.spsa.rnd.datastructure.classic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sarumu1
 *
 */
public class BinarySearchTree {

	private class BSTNode {
		Integer data;
		BSTNode left;
		BSTNode right;
	}

	private BSTNode rootNode;

	public void insert(Integer value) {
		BSTNode currentNode = rootNode;
		if (currentNode == null) {
			currentNode = rootNode;
		} else if (value < currentNode.left.data) {
			currentNode = currentNode.left;
		} else {
			currentNode = currentNode.right;
		}
		currentNode.data = value;
	}

	private final List<String> tree = new ArrayList<>();

	@Override
	public String toString() {
		BSTNode currentNode = rootNode;
		if (currentNode == null) {
			return "";
		}
		tree.add(String.valueOf(currentNode.data));
		if (currentNode.left != null) {
			tree.add(String.valueOf(currentNode.left.data));
		}

		return null;
	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(10);
		bst.insert(9);
		bst.insert(11);
	}
}
