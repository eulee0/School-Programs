
package edu.csupomona.cs.cs240.prog_assgmnt_1;


public class SimpleBoundedList<K extends Comparable<K>,V> implements List<K, V> {

	protected Object[] values;

	private int start = 0;
	private int nextEmpty = 0;
	private int index = 0;

	/**
	 * Constructor of the SimpleBoundedList class.
	 */
	public SimpleBoundedList(int bound) {
		values = new Object[bound];
	}
	
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
		boolean modify = false;
		int nextIndex = nextEmpty;

		if (((nextEmpty + 1) % values.length) != start) {
			nextEmpty = (nextEmpty + 1) % values.length;
			modify = true;
		} else if (values[nextEmpty] == null) {
			modify = true;
		}
		
		if (modify)
			values[nextIndex] = new Entry(key,value);

		return modify;
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
		V value = lookup(key);
		
			if(value == null)
				return null;
			else {
				values[index] = null;
				start =(start + 1) % values.length;
			return value;
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
	@SuppressWarnings({ "unchecked" })
	public V lookup(K key) {		
		if (start == nextEmpty && values[start] == null)
			return null;
		else {
			int end = (nextEmpty+1)% values.length;
			for (index=start; index != end; index = (index+1)%values.length){
				if(((Entry)values[index]).key.compareTo(key) == 0){
					V toReturn = get(index);
					return toReturn;
				}
			}
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
	public V remove(int n) {
		V toReturn = get(n);
		values[n] = null;
		start = (start+1)%values.length;
		
		return toReturn;
	}

	/**
	 * This method returns the size of the list as long
	 * as it is not null.
	 * 
	 * @return		int	size of list
	 */
	public int size() {
		int size = 0;
		if (start ==  nextEmpty && values[start] == null)
			return size;
		else {
			int count = 1;
			int begin = start;
			while (begin != nextEmpty) {
				count++;
				begin = (begin+1)%values.length;
			}
			size = count;
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
	@SuppressWarnings("unchecked")
	public V get(int n) {
		if (start == nextEmpty && values[start]==null)
			return null;
		else {
			V toReturn = (V) ((Entry)values[n]).value;
			return toReturn;
		}
	}
	
	/**
	 * This method removes the element at the very top
	 * of the list.
	 * 
	 * @return		V, if not null
	 */
	public V remove() {
		if(start == nextEmpty && values[start] ==null)
			return null;
		else {
			@SuppressWarnings({ "unchecked" })
			V toReturn = (V) ((Entry)values[start]).value;
			values[start]=null;
			start=(start+1)%values.length;
			return toReturn;
		}
	}
	
	/**
	 * This method creates a String representation of the list.
	 *  
	 * @return		String of list
	 */
	public String toString() {
		String s = "";
		int curSize = size();
		int curIndex = start;
		
		for(int i = 1; i < curSize; i++)
		{
			s = s + "(" + ((Entry)values[curIndex]).key + "," + ((Entry)values[curIndex]).value + ") ";
			curIndex++;
		}
		return s;
	}

	/**
	 * This method loops through the list and assigns each 
	 * element into an array element and returns it.
	 *  
	 * @return		Object of list => Array
	 */
	public Object[] toArray() {	
		int curSize = size();
		Object[] arrayList = new Object[curSize];
		
		if(start == nextEmpty && values[start] == null)
			return null;
		else 
		{
			int curIndex = start;
			for(int i = 0; i < curSize; ++i)
			{
				arrayList[i] = ((Entry)values[curIndex]).value;
				curIndex = (curIndex + 1) % values.length;
				
			}
			return arrayList;
		}
		
	}
	
	/**
	 * Creates an Entry for SimpleBoundedList.
	 */

	private class Entry {
		
		protected K key;
		protected V value;
		
		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
			

		}

	}


}
