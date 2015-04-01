package com.spsa.rnd.datastructure.api;

public class StackUsingLinkedList<T> implements Stack<T> {

	private Node<T> nextNode = null;

	private class Node<T> {
		T data;
		Node<T> adjNode;
	}

	@Override
	public void push(T data) {
		Node<T> node = new Node<T>();
		node.data = data;
		node.adjNode = this.nextNode;
		this.nextNode = node;
	}

	@Override
	public T pop() {
		T data = nextNode.data;
		this.nextNode = nextNode.adjNode;
		return data;
	}

	public static void main(String[] args) {

		StackUsingLinkedList<String> myStack = new StackUsingLinkedList<>();
		myStack.push("SP");
		myStack.push("Senthil");
		myStack.push("Arumugam");

		System.out.println("myStack.pop():" + myStack.pop());
		System.out.println("myStack.pop():" + myStack.pop());
		System.out.println("myStack.pop():" + myStack.pop());
	}

}
