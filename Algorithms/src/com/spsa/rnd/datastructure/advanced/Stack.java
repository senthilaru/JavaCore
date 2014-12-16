package com.spsa.rnd.datastructure.advanced;

public class Stack<T> {

	private Node<T> nextNode = null;

	private class Node<T> {
		T data;
		Node<T> adjNode;
	}

	public void put(T data) {
		Node<T> node = new Node<T>();
		node.data = data;
		node.adjNode = this.nextNode;
		this.nextNode = node;
	}

	public T pop() {
		T data = nextNode.data;
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
