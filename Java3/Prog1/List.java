
package edu.csupomona.cs.cs240.prog_assgmnt_1;

public interface List<K extends Comparable<K>,V> {
	
	/** Description:
	  *   a List is a collection of objects in which order matters. 
	  *   Lists can be filled partially, even empty, but no gaps.
	  * 
	  */ 
	
	/** Description:
	  *   @precon- the value cannot be null.
	  *   @postcon- the value must be in the list  
	  */
	
	public abstract boolean add(K key,V value);
	/** Description:
	  *   @precon- key != null.
	  *   @postcon- (* Everything in the list must still hold 
	  *		  	   for \pre. If a value that wasn't added
	  *			   is in \pre, it must be in \post. *)
	  *			   \post(count) == \pre(count)++
	  */
	
	public abstract V remove(K key);	
	/** Description:
	  *   @precon- 0 <= n <= (count), =! null.
	  *   @postcon- (* Everything in the list must still hold 
	  *				for \pre. If a value that wasn't removed
	  *				is in \pre, it must be in \post. *)
	  *				\post(count) == \pre(count)--
	  */
	
	public abstract V remove(int n);	
	/** Description:
	  *   @precon- value at n must be removable. true 
	  *   @postcon- (* Everything in the list must still hold 
	  *				for \pre. If a value that wasn't removed
	  *				is in \pre, it must be in \post. *)
	  *				\post(count) == \pre(count)--
	  */
	
	public abstract V remove();	
	/** Description:
	  *   @precon- key != null
	  *   @postcon- (* Everything in the list must still hold 
	  *				for \pre. If a value that wasn't removed
	  *				is in \pre, it must be in \post. *)
	  *				\post(count) == \pre(count)--
	  */
	
	public abstract V lookup(K key);
	/** Description:
	  *   @precon- key != null, true
	  *   @postcon- \post(count) == \pre(count)
	  */
	
	public abstract int size();
	/** Description:
	  *   @precon- 0 <= n <= (count)
	  *   @postcon- (* N must still hold for \pre. *)
	  * 				n=0 == null
	  */	
	
	public abstract V get(int n);
	/** Description:
	  *   @precon- 0 <= n <= (count), true
	  *   @postcon- (* N must still hold for \pre. *)
	  * 				n=0 == null
	  */
	
	public abstract Object[] toArray();
	/** Description:
	  *   @precon- true
	  *   @postcon- (* Everything in the list at \pre
	  *				must be elements of the array in 
	  *				\post *)
	  */
	public abstract String toString (); 
	/** Description:
	  *   @precon- true
	  *   @postcon- (* Everything in the list at \pre
	  *				must be of the type String in 
	  *				\post *)
	  */
}

