
package edu.csupomona.cs.cs240.prog_assgmnt_1;

public class SimpleLinkedList<K extends Comparable<K>,V> implements List<K, V> {
	
	private Node head = null;
	private Node tail = null;

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
	@SuppressWarnings("unchecked")
	public V remove(K key) {
		Node current = head;
		while(current != null)
		{
			if(((Node)current.next.value).key == key)
			{
				Node toRemove = current.next;
				current.next = current.next.next;
				return ((Node)(toRemove.value)).value;
			}
			current = current.next;
		}

		return null;
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
			int begin = 0;
			for( Node current = head; current != null; current = current.next, begin += 1 )
			{
				if (begin == n)
				{ 
					Node toRemove = head;
					head = head.next;
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
			return ((Node)toRemove.value).value;
		}
		else {
			
			Node toRemove = head;
			head = head.next;
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
	@SuppressWarnings("unchecked")
	public V lookup(K key) {
		if (head == null)
			return null;
		
		Node current = head;
		
		while(current != null)
		{
			if(((Node)current.next.value).key == key)
			{
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
		int size = 0;
	    Node current = head;
	    
	    while(current.next != null)
		{
	        current = current.next;
	        size++;     
		}
		return size;
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
			else
			{
				int begin = 0;
				for( Node current = head; current != null; current = current.next, begin++ )
				{
					if ( begin == n)
					{ 
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
	public String toString()
	{
		if(head ==  null)
			return null;
		else
		{
			String string = "";
			Node current = head;
			
			while(current != null)
			{
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
	public Object[] toArray()
	{
		int size = size();
		int index = 0;
		
		if(head ==  null)
			return null;
		else 
		{
			Object[] arrayList = new Object[size];
			
			for(Node current = head; current != null; current = current.next)
			{
		        arrayList[index] = ((Node)current.next.value).value;
		        index++;
			
            }
			return arrayList;
		}
		
	}
	/**
	 * Creates a Node for SimpleLinkedList.
	 */
	private class Node {
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