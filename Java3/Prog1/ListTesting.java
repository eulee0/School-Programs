

package edu.csupomona.cs.cs240.prog_assgmnt_1;

 import java.util.*;

public class ListTesting {

	/**
	 * This method scans in information from the user and does specific tasks
	 * based on what the user chooses.
	 */
	public static void main(String[] args)  {   
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int size = 9999;
		SimpleBoundedList<Integer, String> registry = new SimpleBoundedList<Integer, String>(size);
		
		int id;
		String name;
		System.out.print("Enter the name of a user: ");
		name = sc.nextLine();
		System.out.print("Enter the ID of that person: ");
		id = sc.nextInt();

		registry.add(id,name);
		
		String input = toScan();
		

	    do {
			if(input.equals("add")){
				System.out.print("Enter the name of the user: ");
				name = sc.nextLine();			
				name = sc.nextLine();
				System.out.print("Enter the ID of the user: ");
				id = sc.nextInt();		
				
				registry.add(id,name);
				input = toScan();
			}
			
			if(input.equals("alpha")) {
				System.out.print("Alphabetized: \n");
		            System.out.println(registry.toString());
				input = toScan();
			}
				
			if(input.equals("search")) {
				System.out.print("Enter the person's ID: ");
				id = sc.nextInt();
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
		while(input.equals("add") || input.equals("alpha") || input.equals("search"));			
		
	}
	
	/**
	 * This method provides options for the user to choose.
	 * 
	 * @return		String of user input
	 */
	public static String toScan () {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("");
		System.out.println(
				   "Add more names by entering \"add\"\nRead the names in alphabetical order by entering "
				   + "\"alpha\"\nGet name of person based on ID by entering \"search\"\nExit by typing \"exit\".");

		String input = sc.nextLine().toLowerCase();
		return input;
	}
}