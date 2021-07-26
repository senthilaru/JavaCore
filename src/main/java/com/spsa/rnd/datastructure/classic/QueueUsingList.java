/**
 *
 */
package com.spsa.rnd.datastructure.classic;

/**
 * @author sarumu1
 *
 */
public class QueueUsingList implements Queue {

	private Node entryNode = null;
	private Node exitNode = null;

	private int size;

	private class Node {
		String data;
		Node nextNode;
	}

	public QueueUsingList() {

	}

	/*
	 * 
	 * Two changes in the entryNode.
	 * 1. Link the nextNode of entryNode to the newNode
	 * 2. Change the newNode as entryNode.
	 * 
	 * @see com.spsa.rnd.datastructure.classic.Queue#enQueue(java.lang.String)
	 */
	@Override
	public void enQueue(String msg) {
		Node newNode = new Node();
		newNode.data = msg;
		if (entryNode != null) {
			entryNode.nextNode = newNode;
		}
		entryNode = newNode;
		if (this.exitNode == null) {
			this.exitNode = this.entryNode;
		}
		size++;
	}

	/*
	 * One change in the exitNode,
	 * Change the nextNode of exitNode as exitNode
	 * 
	 * @see com.spsa.rnd.datastructure.classic.Queue#deQueue()
	 */
	@Override
	public String deQueue() {
		if (this.exitNode == null) {
			return null;
		}
		String result = exitNode.data;
		exitNode = exitNode.nextNode;
		size--;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.spsa.rnd.datastructure.classic.Queue#size()
	 */
	@Override
	public int size() {
		return size;
	}

	public static void main(String[] args) {
		QueueUsingList queue = new QueueUsingList();
		queue.enQueue("SP");
		queue.enQueue("Senthil");
		queue.enQueue("Aru");

		System.out.println("queue.size():" + queue.size());

		System.out.println("queue.deQueue():" + queue.deQueue());
		System.out.println("queue.deQueue():" + queue.deQueue());
		System.out.println("queue.deQueue():" + queue.deQueue());
		System.out.println("queue.deQueue():" + queue.deQueue());

	}

}
