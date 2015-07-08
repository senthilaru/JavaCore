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
		
		@Override
		public String toString(){
			return "["+ left + "-" + data + "-"+ right + "]";
		}
	}

	private BSTNode rootNode = new BSTNode();

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
		System.out.println("currentNode:"+currentNode);
	}

	public String getPreOrderTraversal() {
		String result = toPreOrderTraversal(rootNode);
		System.out.println("result:" + result);
		return result;
	}

	private String toPreOrderTraversal(BSTNode currentNode) {
		String result = "";
		if (currentNode == null) {
			return result;
		}
		if (currentNode.left != null) {
//			System.out.println(currentNode.data);
			currentNode = currentNode.left;
		} else {
//			System.out.println(currentNode.data);
			currentNode = currentNode.right;
		}
		result = String.valueOf(currentNode.data);
		toPreOrderTraversal(currentNode);
		return result;
	}

	public String getPostOrderTraversal() {
		return null;
	}

	public String getInOrderTraversal() {
		return null;
	}

	public String getLevelOrderTraversal() {
		return null;
	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(10);
		bst.insert(9);
		bst.insert(11);
		System.out.println("bst.getPreOrderTraversal():" + bst.getPreOrderTraversal());

	}
}
