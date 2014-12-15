package com.spsa.rnd.algorithm;

import com.spsa.rnd.datastructure.Stack;

public class Test {

	public static void main(String[] args) {
		
		Stack myStack = new Stack();
		myStack.put("SP");
		myStack.put("Senthil");
		myStack.put("Arumugam");
		
		System.out.println("myStack.pop():"+myStack.pop());
		System.out.println("myStack.pop():"+myStack.pop());
		System.out.println("myStack.pop():"+myStack.pop());
	}
}
