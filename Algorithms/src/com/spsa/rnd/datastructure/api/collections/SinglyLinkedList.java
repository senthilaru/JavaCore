package com.spsa.rnd.datastructure.api.collections;


public class SinglyLinkedList<E> implements List<E>{

	Node<E> first;
	Node<E> last;
	
	public SinglyLinkedList(){
		
	}
	
	public void add(E e){
		Node<E> n = new Node<E>(e);
		if ( first == null){
			first  = new Node<E>(e);
		}else{
			if ( first .next == null){
				first.next = n;
			}else{
				last.next = n;
			}
		}
		last = n;
	}
	
	
	public void remove(E e){
		
		Node<E> current = first;
		Node<E> prev = current;
		
		while ( current !=null) {
			if ( current.e.equals(e)){
				Node<E> next = current.next;
				if ( next == null){
					prev.next = null;
					prev = null;
					return;
				}
				current.next  = next.next;
				current.e = next.e;
				next.next  = null;
				next = null;
				return;
			}
			prev = current;
			current = current.next;
		}
		
	}
	

	@Override
	public E get(int index) {
		return null;
	}


	@SuppressWarnings("hiding")
	class Node<E>{
		Node<E> next ;
		E e ;
		
		Node(E e){
			this.e = e;
		}
		Node(E e,Node<E> next){
			this.e = e; 
			this.next = next;
		}
		
		public String toString(){
			return e.toString();
		}
	}
	
	
	
	public static void main(String[] args) {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		list.add("A");
		
	}

}
