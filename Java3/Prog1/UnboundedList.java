
package edu.csupomona.cs.cs240.prog_assgmnt_1;

public class UnboundedList<K extends Comparable<K>,V> extends SimpleBoundedList<K,V> {
	/**
	 * Constructor for UnboundedList.
	 */
	public UnboundedList(int bound) {
		super(bound);
	}

	/**
	 * This method calls the superclass add to add to the list.
	 *  
	 * @param K 	key of list element
	 * @param V		value of list element
	 * 
	 * @return		boolean if add succeeded
	 */
	@Override
	public boolean add(K key, V value) {
		ensureCapacity();
		super.add(key, value);
		
		return true;
	}

	/**
	 * This method creates an array to provide storage for
	 * the list.
	 */
	private void ensureCapacity() {
		if (this.size() == this.values.length) {
			Object[] array = new Object[values.length * 2];
			
			//int current = start;
			for (int i = 0; i < values.length; ++i) {
				array[i] = values[i];
				i=(i+1)%values.length;
			}
			//start=0;
			//nextEmpty = (values.length-1);
			this.values = array;
		}
		
	}

}