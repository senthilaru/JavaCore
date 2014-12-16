package com.spsa.rnd.datastructure.classic;

public class Stack {

	private Node nextNode = null;

	private class Node {
		String data;
		Node adjNode;
	}

	public void put(String data) {
		Node node = new Node();
		node.data = data;
		node.adjNode = this.nextNode;
		this.nextNode = node;
	}

	public String pop() {
		String data = nextNode.data;
		this.nextNode = nextNode.adjNode;
		return data;
	}

	public static void main(String[] args) {

		Stack myStack = new Stack();
		for (int i = 0; i < Long.MAX_VALUE; i++) {
			myStack.put("Arumugam");
			System.out.println("myStack.pop():" + myStack.pop());
		}
//		myStack.put("SP");
//		myStack.put("Senthil");
//		myStack.put("Arumugam");
//
//		System.out.println("myStack.pop():" + myStack.pop());
//		System.out.println("myStack.pop():" + myStack.pop());
//		System.out.println("myStack.pop():" + myStack.pop());
	}
}
