
import java.util.Scanner;

public class Project1 {		//Project Driver

//Main method, contains user menu and accesses methods
	public static void main(String[] args) {  			 
  		 Scanner scan = new Scanner(System.in);
  		 int loop = 0;
  		 
  		do {        
  	            System.out.print("===========================================================================\n\n\n"
  	            				+ "Please select how to test the program:\n"
  	            				+ "(1) 20 sets of 100 randomly generated integers\n"
  	            				+ "(2) Fixed integer values 1-100\n"
  	            				+ "Enter choice:");
  	            String choice = scan.nextLine();  
  	                      
  	            switch (choice){
  	            
  	            case "1" : 	
  	            	System.out.println("\n");
  	            	Project2.randomGenSequential();
  	            	Project2.randomGenOptimal();
  	            	System.out.println("\n");
  	                break;                          
  	            
  	            case "2" :	
  	            	System.out.println("\n");
  	            	Project2.presetGenSequential();
  	            	Project2.presetGenOptimal();
  	            	System.out.println("\n");
  	                break; 
  	                
  	            case "E" :
  	            	System.out.println("\n");
  	            	System.out.println("Goodbye!");
  	            	System.out.println("\n");
  	            	System.exit(0);
  	                
  	            default :	//Errors
  	            	System.out.println("Wrong input!");
  	            	System.out.println("\n");
  	            	break;
  	            		
  	            }
  		 } while (loop  == 0);
	}
}

		 
