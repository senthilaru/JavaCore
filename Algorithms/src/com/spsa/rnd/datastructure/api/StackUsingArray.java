package com.spsa.rnd.datastructure.api;

import java.lang.reflect.Array;

public class StackUsingArray<T> implements Stack<T> {
	T[] stack;
	int currentIndex = 0;

	@SuppressWarnings("unchecked")
	public StackUsingArray(Class<T> clazz, int size) {
		stack = (T[]) Array.newInstance(clazz, size);
	}

	@Override
	public void push(T msg) {
		if (currentIndex <= stack.length) {
			stack[currentIndex] = msg;
		}
		currentIndex++;
	}

	@Override
	public T pop() {
		T msg = stack[currentIndex];
		stack[currentIndex] = null; // This leads to Memory Leak (Loitering) if not nullify.
		currentIndex--;
		return msg;
	}

}
