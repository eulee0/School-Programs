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
/**
 * @author Eugene Lee
 *
 */

public class SimpleLinkedList<K extends Comparable<K>,V> implements List<K, V>, Serializable{

	private static final long serialVersionUID = -6917866912333524188L;
	private Node head = null;
	private Node tail = null;
	private int totalElements = 0;

	/**
	 * This method adds to a list based on a given key and value as 
	 * long as it isn't null.
	 * 
	 * @param K 	key of list element
	 * @param V		value of list element
	 * 
	 * @return		boolean of whether added or not
	 */
	public boolean add(K key, V value) {
		totalElements++;
		if (head == null) { 
			Node nn = new Node(key, value);

			head = nn;
		} else {
			Node node = head;

			while (node.next != null) {
				node = node.next;
			}

			node.next = new Node(key,value);

		}

		return true;
	}

	/**
	 * This method removes an element of the list by searching for 
	 * the given key as long as it isn't null.
	 *   
	 * @param K 	key of list element
	 * 
	 * @return		V , if not null
	 */
	public V remove(K key) {

		V returned = null;
		Node current = head;
		@SuppressWarnings("unused")
		Node previous = null;
		for(int i = 0; i < size(); i++){
			if(head.key.compareTo(key) == 0){
				returned = head.value;
				head = current.next;
				totalElements--;

			} else if(current.key.compareTo(key) == 0){

				returned = current.value;
				previous = current.next;

				totalElements--;
				break;
			}
			previous = current;
			current = current.next;


		}
		return returned;
	}


	/**
	 * This method searches through the list for an element 
	 * of position n and removes the value, then returns it.
	 *  
	 * @param n		int of position of list element
	 * 
	 * @return		V, if not null
	 */
	@SuppressWarnings("unchecked")
	public V remove(int n) {
		if (head == null)
			return null;
		else
		{
			int start = 0;
			for( Node current = head; current != null; current = current.next, start += 1 )
			{
				if (start == n)
				{ 
					Node toRemove = head;
					head = head.next;
					totalElements--;
					return ((Node)toRemove.value).value;
				}
			}
			return null;
		}
	}

	/**
	 * This method removes the element at the very top
	 * of the list.
	 * 
	 * @return		V, if not null
	 */
	@SuppressWarnings("unchecked")
	public V remove() {
		if(head == null)
			return null;

		else if(head == tail) {

			Node toRemove = head;
			head = null;
			tail = null;
			totalElements--;
			return ((Node)toRemove.value).value;
		}
		else {

			Node toRemove = head;
			head = head.next;
			totalElements--;
			return ((Node)toRemove.value).value;
		}
	}

	/**
	 * This method searches through the list for the element
	 * of the given key and returns the value.
	 *  *
	 * @param K 	key of list element
	 * 
	 * @return		V, if not null
	 */
	public V lookup(K key) {
		if (head == null)
			return null;

		Node current = head;

		for (int i = 0; i < totalElements; i++) {
			if((current).key.equals(key)) {
				return current.value;
			}
			current = current.next;
		}
		return null;
	}

	/**
	 * This method returns the size of the list as long
	 * as it is not null.
	 * 
	 * @return		int	size of list
	 */
	public int size() {
		return totalElements;
	}

	/**
	 * This method searches for a value at the startpoint
	 * given at position n.
	 *  
	 * @param n		position of list element
	 * 
	 * @return		V, if not null
	 */
	public V get(int n) {
		if (head == null)
			return null;
		else {
			int start = 0;
			for( Node current = head; current != null; current = current.next, start++ ) {
				if ( start == n) { 
					return current.value;
				}
			}
			return null;
		}
	}

	/**
	 * This method creates a String representation of the list.
	 *  
	 * @return		String of list
	 */
	public String toString() {
		if(head ==  null)
			return null;
		
		else {
			String string = "";
			Node current = head;

			while(current != null) {			
				string = string + "(" + current.key + "," + current.value + ") -- ";
				current = current.next;
			}
			
			return string;
		}
	}

	/**
	 * This method loops through the list and assigns each 
	 * element into an array element and returns it.
	 *  
	 * @return		Object of list => Array
	 */
	@SuppressWarnings("unchecked")
	public Object[] toArray() {
		int size = size();
		int index = 0;

		if(head ==  null)
			return null;
		else {
			Object[] arrayList = new Object[size];

			for(Node current = head; current != null; current = current.next) {
				arrayList[index] = ((Node)current.next.value).value;
				index++;

			}
			return arrayList;
		}

	}
	
	/**
	 * This method verifies that a certain element
	 * of the list exists and returns the 
	 * corresponding answer.
	 * 
	 * 
	 * 
	 * @return		boolean of true or false
	 */
	public boolean elementExists () {
		int size = size();
		if (size == 0) {
			return false;
		}
		else return true;
	}
	
	/**
	 * This method loops through the list to be able to
	 * find the key corresponding to the given position.
	 * 
	 * @param n 	position of list element
	 * 
	 * @return		K key of specified element 
	 */
	public K getKKey (int n) {
		if (head == null)
			return null;
		else {
			int start = 0;
			for( Node current = head; current != null; current = current.next, start++ ) {
				if ( start == n) { 
					return current.key;
				}

			}
			return null;
		}



	}
	/**
	 * Creates a Node for SimpleLinkedList.
	 */
	private class Node implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 663845919007794906L;
		protected K key;
		protected V value;
		protected Node next;

		Node(K k, V v) {
			key = k;
			value = v;
			next = null;
		}
	}

}