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
 *  @author Eugene Lee
 *  
 */
public class XorShiftHash<K extends Comparable <K>, V> extends AddHash<K,V> implements Serializable{


	private static final long serialVersionUID = 6814036654013711867L;
	
	/**
	 * This method does a rotational hash that shifts elements leftt
	 * and right in order to achieve a specific hash.
	 * 
	 * @param K 	key of list element
	 * 
	 * @return		int of the rotational hash done
	 */
	protected int xorHash(K key) {
        
        String stringKey = (String)key;
       
        char curChar[] = stringKey.toCharArray();
        int xorHash = 0;
       
       for(int i = 0; i < curChar.length; i++) {
           xorHash += (((curChar[i] << 12) ^ (curChar[i] >> 3)) ^curChar[i]);
       }
        return xorHash % size;
     }

}
