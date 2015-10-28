
import java.io.*;
import java.util.Scanner;
public class Lee_ArrayProcessing {
	
	// method: main 
	// purpose: this method calls all other methods in order 
	//  to make the program work
	public static void main (String args[]) throws IOException{
		
		System.out.print ("Enter File Name: ");
		int[] data = inputData();
		
		printArray(data);
		reverseArray(data);
		sum(data);
			System.out.println("The sum of all elements is: " + sum(data));
		mean(data);
			System.out.printf("The mean of all elements is: %.2f\n", mean(data));
		min(data);
			System.out.println("The min of all the elements is: " + min(data));
		max(data);
			System.out.println("The max of all the elements is: " + max(data));
		evenOdd(data);
			System.out.println ("\nProgram completed, remember to inspect 'even.out' and 'odd.out' files.");
		}
	
	
	// method: inputData 
	// purpose:  this method will read in the file named and 
	//  create an array of the contents, else it will terminate
	public static int[] inputData() throws IOException {
		Scanner fileName = new Scanner (System.in);
		String inputFileName =	fileName.nextLine();
		File inputFile = new File(inputFileName);

		if (!inputFile.exists()){
            System.out.println("ERROR: File not found.");
            System.exit(0);
		}
		
		Scanner inputFileContent = new Scanner(inputFile);
		int arrayElements = inputFileContent.nextInt();
			int[] numbers = new int[arrayElements];
			for (int i=0; i<arrayElements; i++){
				if (inputFileContent.hasNextInt()){
                    int moreLines = inputFileContent.nextInt();
                    numbers[i] = moreLines;
            }
		}
			
			inputFileContent.close();
			return numbers;
	}
		
		
	
	// method: printArray 
	// purpose: this method prints out the array aligned in a
	//  column formation
	public static void printArray(int[] array) {
		System.out.println("\nPrinting array: ");
        for (int i = 1; i<array.length+1; i++){
                System.out.printf("%7d", array[i-1]);
                if (i%10==0){
                	System.out.println();
                }
        }
        System.out.println("\n");
	}
	
	
	// method: reverseArray 
	// purpose: this method prints out the array in reverse order
	//  aligned in a column formation
	public static void reverseArray(int[] array) {
		 System.out.println("Printing reversed array: ");
         int number=0;
         for (int i = array.length-1; i>=0; i--){
                 System.out.printf("%7d", array[i]);
                 number++;
                 if (number%10==0){
                         System.out.println();
                 }
         }
         System.out.println("\n");
		}
	
	// method: sum 
	// purpose: this method computes and returns the sum of the 
	//  contents of the array
	public static int sum (int[] array) {
		int total = 0;
			for(int i=0; i<array.length; i++) {
				total = total + array[i];	
			}
					return total;
		}
	
	// method: mean 
	// purpose: this method computes and returns the mean of
	//  the contents of the array
	public static double mean (int[] array) {
		
		double total = 0;
        double averageMean;
        for (int i = 0; i < array.length; i++) {
        	total = total + array[i];
        }
        averageMean = (total / array.length);
        return averageMean;
		
		}
	
	// method: min 
	// purpose: this method computes and returns the minimum
	//   of the contents of the array
	public static int min (int[] array) {
		
		int min = array[0];
		for (int i=1; i<array.length; i++) {
			if (array[i]<min){
				min = array[i];
			}
		}	
		return min;	
}

		
	// method: max 
	// purpose: this method computes and returns the maximum
	//  of the contents of the array
	public static int max (int[] array) {
		
		int max = array[0];
			for (int i=1; i<array.length; i++) {    
				if (array[i]>max){ 
					max = array[i];
				}
			}
			return max;
		}
	
	// method: evenOdd
	// purpose: this method creates two files, scans the contents
	//  of the array, and writes the elements to its correct file
	public static void evenOdd (int[] array) throws IOException{
		
		 PrintWriter outputFileEven = new PrintWriter("even.out");
         int x = 0;
         for (int i = 0; i < array.length; i++)
         {
                 x = array[i]%2;
                 if (x == 0)
                         outputFileEven.println(array[i]);
         }       
         
         PrintWriter outputFileOdd = new PrintWriter("odd.out");        
         int y = 0;       
         for (int i = 0; i < array.length; i++)
         {
                 y = array[i]%2;
                 if (y != 0)
                         outputFileOdd.println(array[i]);
         }
         outputFileEven.close();
         outputFileOdd.close();
		}
	
}
