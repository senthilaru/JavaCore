/**
 *
 */
package com.spsa.rnd.datastructure.classic;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {

	private class BSTNode {
		Integer data;
		BSTNode left;
		BSTNode right;

		@Override
		public String toString() {
			return "[" + left.data + "-" + data + "-" + right.data + "]";
		}
	}

	private final BSTNode rootNode = new BSTNode();

	public BSTNode getRootNode() {
		return rootNode;
	}

	public void insert(Integer value) {
		BSTNode currentNode = rootNode;

		while (currentNode.data != null) {
			if (value <= currentNode.data) {
				currentNode = currentNode.left;
			} else {
				currentNode = currentNode.right;
			}
		}
		currentNode.data = value;
		currentNode.left = new BSTNode();
		currentNode.right = new BSTNode();
//		System.out.println("currentNode:" + currentNode);
	}

	public void printPreOrderTraversal(BSTNode currentNode) {
		if (currentNode == null || currentNode.data == null) {
			return;
		}
		System.out.print(currentNode.data + ",");
		printPreOrderTraversal(currentNode.left);
		printPreOrderTraversal(currentNode.right);
	}

	public void printInOrderTraversal(BSTNode currentNode) {
		if (currentNode == null || currentNode.data == null) {
			return;
		}
		printInOrderTraversal(currentNode.left);
		System.out.print(currentNode.data + ",");
		printInOrderTraversal(currentNode.right);
	}

	public void printPostOrderTraversal(BSTNode currentNode) {
		if (currentNode == null || currentNode.data == null) {
			return;
		}
		printPostOrderTraversal(currentNode.left);
		printPostOrderTraversal(currentNode.right);
		System.out.print(currentNode.data + ",");
	}

	public void toPreOrderTraversal(BSTNode currentNode, List<Integer> result) {
		if (currentNode == null || currentNode.data == null) {
			return;
		}
		result.add(currentNode.data);
		toPreOrderTraversal(currentNode.left, result);
		toPreOrderTraversal(currentNode.right, result);
	}

	public void toInOrderTraversal(BSTNode currentNode, List<Integer> result) {
		if (currentNode == null || currentNode.data == null) {
			return;
		}
		toInOrderTraversal(currentNode.left, result);
		result.add(currentNode.data);
		toInOrderTraversal(currentNode.right, result);
	}

	public void toPostOrderTraversal(BSTNode currentNode, List<Integer> result) {
		if (currentNode == null || currentNode.data == null) {
			return;
		}
		toPostOrderTraversal(currentNode.left, result);
		toPostOrderTraversal(currentNode.right, result);
		result.add(currentNode.data);
	}

	public List<Integer> getPreOrderTraversal() {
		List<Integer> result = new ArrayList<Integer>();
		toPreOrderTraversal(rootNode, result);
		return result;
	}

	public List<Integer> getPostOrderTraversal() {
		List<Integer> result = new ArrayList<Integer>();
		toPostOrderTraversal(rootNode, result);
		return result;
	}

//
	public List<Integer> getInOrderTraversal() {
		List<Integer> result = new ArrayList<Integer>();
		toInOrderTraversal(rootNode, result);
		return result;
	}

//
//	public String getLevelOrderTraversal() {
//		return null;
//	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		String inputs = "40, 25, 10, 3, 17, 32, 30, 38, 78, 50, 78, 93";
		String[] inputArr = inputs.split(",");
		for (String input : inputArr) {
			if (input != null) {
				bst.insert(Integer.parseInt(input.trim()));
			}
		}
		System.out.println("Root Node:" + bst.getRootNode());
		System.out.print("PreOrder:");
		bst.printPreOrderTraversal(bst.rootNode);
		System.out.println();
		System.out.print("InOrder:");
		bst.printInOrderTraversal(bst.rootNode);
		System.out.println();
		System.out.print("PostOrder:");
		bst.printPostOrderTraversal(bst.rootNode);

		System.out.println();
		System.out.println();
		System.out.println("PreOrder Traversal:" + bst.getPreOrderTraversal());
		System.out.println("InOrder Traversal:" + bst.getInOrderTraversal());
		System.out.println("PostOrder Traversal:" + bst.getPostOrderTraversal());

	}
}
