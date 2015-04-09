package com.spsa.rnd.datastructure.api.collections;

public class LinkedList {

	Node first;
	Node last;
	
	public LinkedList(){
		
	}
	
	public void add(String name){
		Node n = new Node(name);
		if ( first == null){
			first  = new Node(name);
		}else{
			if ( first .next == null){
				first.next = n;
			}else{
				last.next = n;
			}
		}
		last = n;
	}
	
	
	public void remove(String name){
		
		Node current = first;
		Node prev = current;
		
		while ( current !=null) {
			if ( current.name.equals(name)){
				Node next = current.next;
				if ( next == null){
					prev.next = null;
					prev = null;
					return;
				}
				current.next  = next.next;
				current.name = next.name;
				next.next  = null;
				next = null;
				return;
			}
			prev = current;
			current = current.next;
		}
		
		
	}
	
	
	
	
	public String toString(){
		String s  = "[";
		Node thisNode = first;
		while (thisNode != null) {
			if (!s.equals("[")){ s = s +"," ; 	}
			s = s + thisNode.toString();
			thisNode = thisNode.next;
		}
		s  = s + "]";
		return s;
	}
	
	
	public void reverse() {
		
		Node head = first;
		Node current = head;
		
		while( current.next !=null){
			Node second = current.next;
			Node third = second.next;
			second.next = head;
			head = second;
			current.next = third;
		}
		first = head;
		
	}
	

	public static void main(String[] args) {
		
		System.out.println(" program started ");
		
		LinkedList  l = new LinkedList();
		l.add("Kamal");
		l.add("Anand");
		l.add("Raj");
		l.add("Sarath");
		l.add("Senthil");
		System.out.println(l);
		
		l.remove("Sarath");
		System.out.println(l);
		
		l.remove("Kamal");
		System.out.println(l);
		
		l.remove("Senthil");
		System.out.println(l);
		
		l.reverse();
		System.out.println(l);
		
	}
	
	
	


	class Node{
		Node next ;
		String name ;
		Node(String name){
			this.name = name;
		}
		Node(String name,Node next){
			this.name = name; 
			this.next = next;
		}
		
		public String toString(){
			return  name;
		}
	}
	
}
