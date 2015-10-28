
import java.util.Arrays;
import java.util.Scanner;

 /* Class that holds main, calls upon Program2 for method use. */
 public class Program1 {
 
	 
     public static void main(String[] args)	{ 	//main method, user interface.
                
        Scanner scan = new Scanner(System.in);
        
        BST bst = new BST();  	//BST object creation
        int loop = 0; 			//keep do-while loop running
        
        System.out.println("Please enter the initial sequence of values:");
        	String initial = scan.nextLine();
        	String [] initialSplit = initial.split(" ");
        	
        for (int i = 0; i < initialSplit.length; i++) {
        	bst.insert( Integer.parseInt (initialSplit[i]) ); 	//initial sequence insertion
        }
        
        Integer [] initialSplitInt = new Integer[initialSplit.length];
        
        for(int i = 0;i < initialSplit.length;i++) {
           initialSplitInt[i] = Integer.parseInt(initialSplit[i]);
        }
        	
        //BST visualization 		
		System.out.print("\nPre order : ");
		bst.preorder();
		System.out.print("\nIn order : ");
		bst.inorder();
		System.out.print("\nPost order : ");
		bst.postorder();
		System.out.println();
        
        //Commands on current BST
        do {        
            System.out.print("\nCommand? ");
            String choice = scan.nextLine();  
            String[] splitted = choice.split(" ");
                      
            switch (splitted[0]){
            
            case "I" : 	//Insertion
                bst.insert( Integer.parseInt (splitted[1]) );
                System.out.print("In order : ");
         		bst.inorder();

                break;                          
            case "D" : 	//Deletion
                bst.delete( Integer.parseInt (splitted[1]) ); 
                System.out.print("In order : ");
         		bst.inorder();
       
                break;                         
            case "P" : 	//Predecessor (incomplete)
            	int index1 = Arrays.asList(initialSplitInt).indexOf( Integer.parseInt (splitted[1]));
            	System.out.println(initialSplitInt[index1 - 1]);
                break;                                          
            case "S" : 	//Successor (incomplete)
            	int index2 = Arrays.asList(initialSplitInt).indexOf( Integer.parseInt (splitted[1]));
            	System.out.println(initialSplitInt[index2 + 1]);
                break;     
            case "E" :  //Exit
                System.out.println("Thank you for using!");
                System.exit(0);
                break;            
            case "H" :	//Help Menu
                System.out.println("I  Insert a value");
                System.out.println("D  Delete a value");
                System.out.println("P  Find predecessor");
                System.out.println("S  Find successor");
                System.out.println("E  Exit the program"); 
                System.out.println("H  Display this message"); 
                break; 
            default :	//Errors
            	System.out.println("Wrong input!");
            	break;
            	
            	
            }
            
        } while (loop == 0);
        		
    }
 }
