/**
 *
 */
package com.spsa.rnd.datastructure.classic;

/**
 * @author sarumu1
 *
 */
public interface Queue {
	void enQueue(String msg);

	String deQueue();

	int size();

}
