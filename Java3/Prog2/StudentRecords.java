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

import java.util.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import edu.csupomona.cs.cs240.prog_assgmnt_2.AddHash;
/**
 *  @author Eugene Lee
 *  
 */
public class StudentRecords implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -125051304333451941L;
	private static AddHash<String, String> registry = new AddHash<String, String>();
	
	/**
	 * This method is the main method that takes
	 * in scanner input to print out output that
	 * the user chooses.
	 * 
	 * @param args		main method
	 * 
	 * 
	 */		
	public static void main (String[] args){
		
		serializableLoad();
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		String id;
		String name;
		String grade;
		System.out.print("Enter the name of a user: ");
		name = sc.nextLine();
		System.out.print("Enter the ID of that person: ");
		id = sc.nextLine();
		System.out.print("Enter the grade of the user: ");
		grade = sc.nextLine();
		
		name = name+ " " +grade;

		registry.add(id,name);
		
		String input = toScan();
		

	 do {
			if(input.equals("create")){
				System.out.print("Enter the name of the user : ");
				name = sc.nextLine();			
				System.out.print("Enter the ID of the user: ");
				id = sc.nextLine();	
				System.out.print("Enter the grade of the user: ");
				grade = sc.nextLine();
				
				name = name + " " + grade;

				
				registry.add(id,name);
				serializableSave();
				input = toScan();
			}
			
			if (input.equals("remove")) {
				System.out.print(("Enter the ID of the user: "));
				id = sc.nextLine();
				
				registry.remove(id);
				input = toScan();
			}
			
			if(input.equals("display")) {
				registry.printAll();
				input = toScan();
				
			}
				
			if(input.equals("lookup")) {
				System.out.print("Enter the person's ID: ");
				id = sc.nextLine();
				try {
					String found = registry.lookup(id);
					System.out.println("Name: " + found);
					
				}
				catch(NullPointerException e) {
					System.out.print("Name for that ID doesn't exist!");
				}
				input = toScan();
					
			}
		}
	 while(input.equals("create") || input.equals("remove") || input.equals("display") || input.equals("lookup"));			
			
}
	
	/**
	 * This method loads in a file to be read for 
	 * Serializiable in order to save as a file.
	 * 
	 * 
	 */
	@SuppressWarnings("unchecked")
	public static void serializableLoad(){
		FileInputStream fis;
		ObjectInputStream ois;
		try {
			fis = new FileInputStream ( "student.stu" ) ;
			ois = new ObjectInputStream ( fis ) ;
			registry = ( AddHash<String,String> ) ois.readObject ( ) ;
		} catch (ClassNotFoundException e) {
			System.out.println("No file to save to!");
		} catch (IOException e) {
			System.out.println("No file to save to!");
		}
	}
	
	/**
	 * This method saves the file that is read
	 * in by Serializable every time the program
	 * calls for a save.
	 * 
	 * 
	 */
	public static void serializableSave() {
		FileOutputStream fos;
		
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream ( "student.stu" );
			oos = new ObjectOutputStream ( fos );
			oos . writeObject ( registry ) ;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * This method creates a scanner in order to take
	 * user input for what kind of output he/she wants
	 * 
	 * 
	 * @return		String of user answer to instructions
	 */
	public static String toScan () {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("");
		System.out.println(
				"Create a new entry by entering \"create\"\nRemove an entry by entering \"remove\"\nDisplay the names in order of student ID "
						   + "\"display\"\nGet name of person based on ID by entering \"lookup\"\nExit by typing \"exit\".");

		String input = sc.nextLine().toLowerCase();
		return input;
	}
}
