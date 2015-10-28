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

import java.util.Arrays;
import java.io.Serializable;
/**
 *  @author Eugene Lee
 *  
 */
public class AddHash<K extends Comparable <K>, V> implements HashTable<K, V>, Serializable {

	private static final long serialVersionUID = -7491106770258950135L;
		private double loadFactor;
		private double densityFactor;
		private double chainingFactor;
		private int longestChain = 0;
		private int elements=0;
		protected int size = 10;
	
	@SuppressWarnings("unchecked")
	private SimpleLinkedList<K, V>[] theSLL = new SimpleLinkedList [size];
	
	/**
	 * This method is a Constructor for the class made to
	 * create a new Simple Linked List for use of
	 * implementing the Addititive Hash.
	 * 
	 *
	 */
	public AddHash(){
		for(int i = 0; i < size; i++){
			theSLL[i] = new SimpleLinkedList<K,V>();
		}
	}
	
	/**
	 * This method adds an element to the linkedlist
	 * using the inputted K key and V value, and alters 
	 * the numbers needing report after the add has gone 
	 * through. Might rehash if the list needs extra space.
	 * 
	 * @param K 	key of list element
	 * @param V		value of list element
	 * 
	 * 
	 */
	public void add(K key, V value) {

		int hash = (hash((String) key))%size;
			theSLL[hash].add(key, value); 

		if(longestChain < theSLL[hash].size()){
			longestChain = theSLL[hash].size();
		}
		densityFactor = findDensity();
		chainingFactor = findChain();
		loadFactor = findLoad();
		elements++;
		reHash();
		
	}
	
	/**
	 * This method removes an element from the list 
	 * using the inputted K key to determine which
	 * element needs removing. The value V of such 
	 * element is then returned.
	 * 
	 * @param K 	key of list element
	 * 
	 * @return		V value of the removed element
	 */
	public V remove(K key) {

		int remHash = hash((String)key)%size;
		V returned = theSLL[remHash].remove(key);
			elements--;
			return returned;
	}
	
	/**
	 * This method searches through the list for the element
	 * of the given key and returns the value.
	 *  
	 * @param K 	key of list element
	 * 
	 * @return		V value of the searched element
	 */
	public V lookup(K key) {

		int lookHash = hash((String)key)%size;
		V returned = theSLL[lookHash].lookup(key);
			return returned;
	}
	
	
	
	/**
	 * This method takes input of a list of V values
	 * and organizes the elements of such list and 
	 * returns it as a sorted list.
	 *  
	 * @param V[]	list of values to be sorted
	 * 
	 * @return		list of organized V values
	 */
	public V[] getSortedList(V[] toSortList ) {

		Arrays.sort(toSortList);
			return toSortList;
	}
	
	/**
	 * This method takes in no input and does not return
	 *   anything, but rather prints out the load factor,
	 *   density factor, chain length, and chain factor.
	 *  
	 * 
	 */
	public void printReport() {
		
		System.out.println("Hash Report: ");
			System.out.println("The Load Factor is " + loadFactor +
				", the Load Density Factor is " + densityFactor+
				", the Chaining Factor is " + chainingFactor +
				", the Longest Chain is: " + longestChain + ".");
	}

	/**
	 * This method takes String input of a list key and loops
	 * through the keys in order to hash the list of keys.
	 *  
	 * @param key	String of key to be hashed
	 * 
	 * @return		int of hash returns.
	 */
	protected int hash(String key){
		int returned = 0;
		int k = key.length();
		char[] cArray;	
		cArray = new char[k];
		
			for(int x = 0; x < key.length(); x++){
				cArray[x] = key.charAt(x);
				returned = cArray[x];
		}
			return returned;
	}	
	
	/**
	 * This method takes the number of buckets used
	 * and the size of the list in order to find
	 * the correct Load Factor of the hash.
	 *  
	 * 
	 * @return		double of load factor.
	 */
	private double findLoad(){
		double usedBuckets = 0;

		for(int i = 0; i < size; i++){
			if(theSLL[i].elementExists()){
				usedBuckets++;
			}
		}
			return (usedBuckets/size);
	}

	/**
	 * This method takes the average length of the
	 * chain and the size of the list in order to
	 * find the correct Chaining Factor of the
	 * hash.
	 *  
	 * 
	 * @return		double of chain factor.
	 */
	private double findChain(){
		double average = 0;
		for(int i = 0; i < size; i++){
			average = average + theSLL[i].size();
		}
		average = (double) (average/size);

		return average;
	}
	
	/**
	 * This method takes the number of elements
	 * and the size of the list in order to find
	 * density factor.
	 *  
	 * 
	 * @return		double of density factor.
	 */
	private double findDensity() {
			return elements/size;
	}
	
	/**
	 * This method creates a new list and copies over 
	 * the elements of the first list into a much bigger
	 * list when the original list gets packed.
	 *  
	 *  
	 */
	@SuppressWarnings("unchecked")
	private void reHash() {
		int adjustedSize;
		
		if(longestChain > 10){
			adjustedSize = size*2;
			SimpleLinkedList<K,V>[] createdBuckets = new SimpleLinkedList[adjustedSize];
			
			for(int i = 0; i < adjustedSize; i++){
				createdBuckets[i] = new SimpleLinkedList<K,V>();
			}
			for (int j = 0; j < theSLL[j].size(); j++){
				
				if(theSLL[j].size() != 0){
					int hash = hash((String)theSLL[j].getKKey(j));
					K key = theSLL[j].getKKey(j);
					V value = theSLL[j].get(j);
					createdBuckets[hash].add(key, value);
				}
			}
			size = adjustedSize;
			theSLL = createdBuckets;
		}
	}
	/**
	 * This method loops through the list and prints out the current 
	 * list in String format.
	 * 
	 * 
	 */
	public void printAll() {
		String printed = "";
		for(int i =0; i<size; i++){

			if (theSLL[i].size() > 0){
				printed = printed + theSLL[i].toString();
			}
		}
		System.out.println(printed);
	}
}
