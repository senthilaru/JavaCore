package com.msc.list;

public class LinkedList<T> {

	private Node<T> head;
	private Node<T> tail;
	

	public void addNode(T data) {
		Node<T> newNode = new Node<T>(data);
		if (null == this.head) {
			this.head = newNode;
		} else {
			if(this.head.getNext() == null){
				this.head.setNext(newNode);
			}else{
				this.tail.setNext(newNode);
			}
		}
		this.tail = newNode;
	}

	public Node<T> get() {
		return head;
	}

	@Override
	public String toString() {
		StringBuilder toString = new StringBuilder();
		Node<T> thisNode = head;
		while (thisNode != null) {
			toString.append(thisNode.toString() + ", ");
			thisNode = thisNode.getNext();
		}
		return toString.toString();
	}

	public void reverse() {
		Node<T> firstNode = head;
		Node<T> currentNode = firstNode;

		while (currentNode.getNext() != null) {

			Node<T> nextNode = currentNode.getNext();
			Node<T> nextPointer = nextNode.getNext();

			nextNode.setNext(firstNode);
			currentNode.setNext(nextPointer);
			firstNode = nextNode;
		}
		head = firstNode;

	}

	@SuppressWarnings("hiding")
	class Node<T> {
		private Node<T> next;
		private T data;

		public Node(T data) {
			this.data = data;
			this.next = null;
		}

		public Node<T> getNext() {
			return next;
		}

		public T getData() {
			return data;
		}

		public void setNext(Node<T> next) {
			this.next = next;
		}

		@Override
		public String toString() {
			return "[" + data + "]->["
					+ (null != next ? next.getData() : "null") + "]";
		}

	}
	
	public static void main(String[] args) {

		LinkedList<Integer> list = new LinkedList<Integer>();
		
		
		list.addNode(3);
		list.addNode(7);
		list.addNode(2);
		list.addNode(8);
		list.addNode(20);
		list.addNode(10);
		list.addNode(23);
		list.addNode(34);
		
		System.out.println(list.toString());
		list.reverse();
		System.out.println(list.toString());
		list.reverse();
		System.out.println(list.toString());

		LinkedList<String> newList = new LinkedList<String>();
		newList.addNode("Sarath");
		newList.addNode("Senthil");
		newList.addNode("Anand");
		newList.addNode("Kamal");
		newList.addNode("Raj");
		
		System.out.println(newList.toString());
		newList.reverse();
		System.out.println(newList.toString());
	}
}
