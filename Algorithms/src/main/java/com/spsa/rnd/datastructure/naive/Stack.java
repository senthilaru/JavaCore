package com.spsa.rnd.datastructure.naive;

public class Stack {

	private Node headNode = null;

	private class Node {
		String data;
		Node adjNode;
	}

	public void put(String data) {
		Node node = new Node();
		node.data = data;
		node.adjNode = this.headNode;
		this.headNode = node;
	}

	public String pop() {
		String data = headNode.data;
//		Node temp = nextNode;
		this.headNode = headNode.adjNode;
//		temp.adjNode = null;
		return data;
	}

	public static void main(String[] args) {

		Stack myStack = new Stack();
		myStack.put("SP");
		myStack.put("Senthil");
		myStack.put("Arumugam");

		System.out.println("myStack.pop():" + myStack.pop());
		System.out.println("myStack.pop():" + myStack.pop());
		System.out.println("myStack.pop():" + myStack.pop());
	}
}
