/**
 * CS 240: Data Structures
 * Professor: Edwin Rodr&iacute;guez
 *
 * Programming Assignment #2
 *
 * <This assignment focuses on the use of hashes, with this assignment focusing on Additive and 
 * Xor Shift hashes. We use a list of students and their information to present these hashes.>
 *
 * Eugene Lee
 * 
 */
package edu.csupomona.cs.cs240.prog_assgmnt_2;

import java.io.Serializable;


public interface HashTable<K extends Comparable<K>,V> extends Serializable {
	/** Description:
	  *   a Hash Table is a data structure used to implement a function in 
	  *   which one can map keys to values.
	  * 
	  */ 
	  public void add(K key, V value);
	  /** Description:
		  *  add takes a K key and a V value in order to add an element to a 
		  *  hash table.
		  * 
		  */ 

	  public V remove(K key);
	  /** Description:
		  *   remove takes input of K key in order to remove the 
		  *   corresponding element of K key and V value from a
		  *   hash table.
		  * 
		  */ 

	  public V lookup(K key);
	  /** Description:
		  *   lookup takes input of K key in order to view the 
		  *   corresponding V value of the specific element of 
		  *   key K.
		  * 
		  */ 

	  public V[] getSortedList(V[] list);
	  /** Description:
		  *   getSortedList takes input of a list of V values
		  *   in order to organize the list of values into 
		  *   a more manageable list of the same V values.
		  * 
		  */ 

	  public void printReport();
	  /** Description:
		  *   printReport takes in no input and does not return
		  *   anything, but rather prints out the load factor,
		  *   density factor, chain length, and chain factor.
		  * 
		  */ 
	}
