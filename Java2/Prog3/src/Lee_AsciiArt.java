
import java.io.*;
import java.util.Scanner;

public class Lee_AsciiArt {
	
	//method  : main
	//purpose : takes input of text file and alters it three different ways
	public static void main (String args[]) throws IOException {
		
		File inFile = new File("C:/Users/ELEE/Desktop/SchoolWork/AsciiArt/src/test.txt");                                 
	    Scanner sc = new Scanner(inFile);     
	    String[] size = sc.nextLine().split("\\s");         

	    char[][] array = new char[Integer.parseInt(size[0])][Integer.parseInt(size[1])];

	    for(int i=0; i < array.length; i++) {
	        array[i] = sc.nextLine().toCharArray();
	    }

	    System.out.println ("Original Text: \n");
	    
	    //original
	    for(int k = 0; k < array.length; k++){
	        for(int s = 0; s < array[k].length; s++){
	            System.out.print(array[k][s] + " ");
	        }
	        System.out.println("");
	    }
	    	System.out.println("");
	    	
	    System.out.println ("Transformations: \n");
	    
	    //vertically
	    for(int l=0; l<array.length; l++)
        {
            for(int m=0; m<array[0].length; m++)
            {
                System.out.print(array[array.length-l-1][m] + " ");
            }
        System.out.println("");
        }
        System.out.println("");
        
        //horizontally
	    for(int n=0; n<array.length; n++)
	    {
	       for(int o=0; o<array[0].length; o++)
	       {
	               System.out.print(array[n][array[0].length-o-1] + " ");

	       }
	           System.out.println("");

	      
	    }
	       System.out.println("");
	       
	     //diagonally
	    for(int p=0; p<array[0].length; p++)
	    {
	       for(int q=0; q<array.length; q++)
	       {
	               System.out.print(array[array.length-q-1][array[0].length-p-1] + " ");

	       }
	       System.out.println("");
	    }
	       System.out.println("");
            }  
 

}

   

