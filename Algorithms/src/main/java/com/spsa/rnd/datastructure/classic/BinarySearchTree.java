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
		while(currentNode != null){
			if (value <= currentNode.data) {
				currentNode = currentNode.left;
			} else {
				currentNode = currentNode.right;
			}
		}
		if(currentNode == null){
			currentNode = new BSTNode();
		}
		currentNode.data = value;
	}
	
	public String getPreOrderTraversal(){
		String result = toPreOrderTraversal(rootNode);
		System.out.println("result:"+result);
	}

	private String toPreOrderTraversal(BSTNode currentNode){
		String result = "";
		if(currentNode == null){
			return;
		}
		result = result + currentNode.data + ",";
		if (currentNode.left != null) {
			currentNode = currentNode.left;
		} else {
			currentNode = currentNode.right;
		}
		result = toPreOrderTraversal(currentNode);
		return result;
	}
	
	public String getPostOrderTraversal(){
		
	}
	public String getInOrderTraversal(){
		
	}
	public String getLevelOrderTraversal(){
		
	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(10);
		bst.insert(9);
		bst.insert(11);
	}
}
