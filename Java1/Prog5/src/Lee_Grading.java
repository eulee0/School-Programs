
import java.io.*;
import java.util.Scanner;
public class Lee_Grading {
	
	// method: main 
	// purpose: this method calls the other methods in order 
	// to get the program to run correctly.
	public static void main (String args[]) throws IOException{
		
		validateFile (new File("gradeInput.txt"));
		validateData (new File("gradeInput.txt"));
		Boolean earned = null;
		mean (earned);
		mode (earned);
		min (earned);
		max (earned);
		printData (); 
	}
	
	// method: validateFile 
	// purpose: this method validates whether or not the 
	// 	file given exists to be used
	public static void validateFile(File inputFile) {
	
		if (inputFile.exists()){
			System.out.println ("File exists.");
		}
		else {
			System.out.println ("ERROR: File does not exist.");
			System.exit (0);
		}
	}
	
	// method: validateData 
	// purpose: this method looks at each set of info on
	//   each line and removes any flaws
	public static void validateData(File inputFile) throws IOException{
		
		Scanner validateLine = new Scanner("gradeInput.txt"); 
		FileWriter fw = new FileWriter("SaveInput.txt",true);
	    PrintWriter outputFile = new PrintWriter(fw);
	    
		for (int i = 0; i <= 11 && validateLine.hasNextLine(); i++) {
			if(validateLine.hasNextInt() == true) {
	          
				int studentID = validateLine.nextInt();

	            if(studentID >= 00000 && studentID <= 99999)
	            {
	            outputFile.print(studentID);
	            validateLine.nextInt();               
	            }
	            else
	            {
	                System.out.println("Ignoring Student with invalid ID number " + studentID);
	            }
	            
	            				
	            if(validateLine.hasNextInt() == true){
	                
	            	int extraCredit = validateLine.nextByte();
	                if(extraCredit >= 0 && extraCredit <= 5)
	                {
	                    outputFile.print(" " + extraCredit + " ");
	                    validateLine.nextDouble();
	                }       
	                else
	                {
	                    System.out.println("Ignoring student " + studentID + " with invalid extra credit " + extraCredit); 
	                }   
	            }
					
	            if(validateLine.hasNextDouble() == true) {
	               
	            	double grades = validateLine.nextDouble();

	                if(grades >= 00.00 && grades <= 100.00)
	                {
	                    outputFile.println(grades); 
	                }       
	                else
	                {
	                    System.out.println("Ignoring student " + studentID + " with invalid grade " + grades);
	                }
	            }
	        	}
		}
		validateLine.close();
		outputFile.close();
	}
	

	// method: mean 
	// purpose: this method takes the grade info from each line 
	//  	and finds the mean  of the total numbers.
	public static double mean (Boolean gradeType) {
		double sum = 0;
		Scanner calcMean = new Scanner("gradeInput.txt");
	
			for (int i = 0; i <= 11 && calcMean.hasNextLine(); i++) {					 
					double nextDouble = calcMean.nextDouble();          
						Boolean earned = null;
						if (gradeType == earned) {
				        System.out.println(nextDouble);             
				        sum =  sum + nextDouble;
				        i++;   
						}
						else {
							 System.out.println(nextDouble);             
						        sum =  sum + nextDouble + calcMean.nextByte();
						        i++;
						}
				 }
			calcMean.close();
				return sum/11;
		}

		
	
	// method: mode 
	// purpose: this method takes the grade info from each line 
	//  and finds the mode  of the total numbers.
	public static double mode(Boolean gradeType) {
		double totalMode = 0;
		Scanner calcMode = new Scanner("gradeInput.txt");
		
		for (int i = 0; i <= 11 && calcMode.hasNextLine(); i++) {
				double nextDouble = calcMode.nextDouble();          
				Boolean earned = null;
				if (gradeType == earned) {   
					if (nextDouble == nextDouble) {
						totalMode = nextDouble;
			        }
			        else {
						 System.out.println(nextDouble);             
					        totalMode =  totalMode + nextDouble + calcMode.nextByte();
					        i++;
			        }
		}
		calcMode.close();
		}
		return totalMode;
	}
		
	
	// method: min 
	// purpose: this method takes the grade info from each line 
	// and finds the minimum value of the total numbers
	public static double min(Boolean gradeType) {
		double minimum =0;
		Boolean earned = null;
		Scanner calcMin = new Scanner("gradeInput.txt");
			for (int i = 0; i <= 11 && calcMin.hasNextLine(); i++) {
				double minTotal = calcMin.nextDouble();
				if (gradeType == earned) {
					if (minTotal < minTotal) {
						minimum = minTotal;
					}
					else {
						minimum = minTotal + calcMin.nextByte();
					}
				}
				calcMin.close();
			}
			return minimum;
	}
	
	// method: max 
	// purpose: this method takes the grade info from each line
	// and finds the maximum value of the total numbers
	public static double max(Boolean gradeType) {
		double maximum = 0;
		Boolean earned = null;
		Scanner calcMax = new Scanner("gradeInput.txt");		
			for (int i = 0; i <= 11 && calcMax.hasNextLine(); i++) {
				double maxTotal = calcMax.nextDouble();
				if (gradeType == earned) {
					if (maxTotal < maxTotal) {
						maximum = maxTotal;
					}
					else {
						maximum = maxTotal + calcMax.nextByte();
					}
				
			}
				calcMax.close();
			}
			return maximum;
		}
	
	// method: printData 
	// purpose: this method prints out the data found by previous
	// methods.
	public static void printData() {
		System.out.printf ("\n\tMean Earned Grade: %2f", mean(null));
		System.out.printf ("\n\tMean Enhanced Grade: %2f", mean(null));
		System.out.printf ("\n\n\tMode Earned Grade: %2f", mode(null));
		System.out.printf ("\n\tMode Enhanced Grade: %2f", mode(null));
		System.out.printf ("\n\n\tMinimum Earned Grade: %2f (student FileID)", min(null));
		System.out.printf ("\n\tMinimum Enhanced Grade: %2f (student FileID)", min(null));
		System.out.printf ("\n\n\tMaximum Earned Grade: %2f (student FileID)", max(null));
		System.out.printf ("\n\tMaximum Enhanced Grade: %2f (student FileID)", max(null)); 
	}
	}
	
	



