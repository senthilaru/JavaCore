package com.spsa.rnd.datastructure.api.collections;

public class SinglyLinkedList<E> implements List<E> {

	Node<E> firstNode;
	Node<E> lastNode;

	public SinglyLinkedList() {

	}

	@Override
	public void add(E data) {
		Node<E> newNode = new Node<E>(data);
		if (lastNode == null) {
			firstNode = newNode;
			lastNode = newNode;
		} else {
			lastNode.next = newNode;
		}
		lastNode = newNode;
	}

	@Override
	public void remove(E data) {

		Node<E> current = firstNode;
		Node<E> prev = current;

		while (current != null) {
			if (current.data.equals(data)) {
				Node<E> next = current.next;
				if (next == null) {
					prev.next = null;
					prev = null;
					return;
				}
				current.next = next.next;
				current.data = next.data;
				next.next = null;
				next = null;
				return;
			}
			prev = current;
			current = current.next;
		}

	}

	@Override
	public E get(int index) {
		//TODO: Need to implement
		return null;
	}

	@SuppressWarnings("hiding")
	private class Node<E> {
		Node<E> next;
		E data;

		Node(E data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return data.toString();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.spsa.rnd.datastructure.api.collections.List#contains(java.lang.Object
	 * )
	 */
	@Override
	public boolean contains(E data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {

		Node<E> current = firstNode;
		StringBuilder b = new StringBuilder("[");

		while (current != null) {
			b.append(current);
			b.append(",");
			current = current.next;

		}
		b.deleteCharAt(b.length() - 1);
		b.append("]");
		return b.toString();

	}

	public static void main(String[] args) {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");

		System.out.println(list);

		list.remove("A");
		list.remove("D");
		list.add("F");
		System.out.println(list);

	}

}
