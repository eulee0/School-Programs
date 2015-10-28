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
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
/**
 *  @author Eugene Lee
 *  
 */
public class ScrambledReverse<K extends Comparable<K>, V> extends XorShiftHash<K, V> implements Serializable {


	private static final long serialVersionUID = -6084404424819027941L;
	Queue<Character> charQueue = new LinkedList<Character>();
	String hashing = "";
	
	/**
	 * This method does a scrambled rotational hash that takes a key
	 * and rotates every three of its letters until there are none 
	 * left
	 * 
	 * @param K 	key of list element
	 * 
	 * @return		int of the hash done
	 */
	protected int xorHash(K key){
		String castedKey = (String) key;
		char[] cArray =  castedKey.toCharArray();
		Stack<Character> charStack = new Stack<Character>();
		
		int numberOfStack = cArray.length/3;
		int spot = 0;
		for(int i = 0; i < numberOfStack || spot < cArray.length; i++){
			for(int j = 0; j < 3; j++){
				
				charStack.push(cArray[spot]);
				if(spot < cArray.length)
				spot++;
				
			}
			for(int k = 0; k<3; k++){
				charQueue.add( charStack.pop() );
			}
		}
		
		for(int l = 0; l<charQueue.size(); l++){
			hashing = hashing + charQueue.remove();
		}
		
		
		return hash(hashing);
	}
}