package com.spsa.rnd.datastructure.api.collections;

public interface List<E> {

	void add(E data);

	E get(int index);

	void remove(E data);

	boolean contains(E data);

}
