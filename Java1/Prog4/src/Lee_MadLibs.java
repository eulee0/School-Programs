
import java.io.*;
import java.util.Scanner;
public class Lee_MadLibs {
	
	// method: main 
	// purpose: this method  reads in a pre existing text file and gathers user input
	// and uses both to create a short short in a Mad Libs form.
	public static void main (String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("\nEnter a file name:");
			String fileName = sc.nextLine();
			
			File myFile = new File(fileName); 
			Scanner inputFile = new Scanner(myFile);
			int numberOfTimes = inputFile.nextInt();
			
			System.out.print("\nPlease provide a word for each of the following:");
				PrintWriter outputFile = new PrintWriter("UserInput.txt"); 
				
			inputFile.nextLine();
			for(int i = 0; i < numberOfTimes && inputFile.hasNextLine(); i++)
			{ 
				System.out.println("\n" +inputFile.nextLine());
					String userInput = sc.nextLine();
						outputFile.println(userInput);
			} 
				outputFile.close();
				System.out.println ();
				 
			Scanner userInput = new Scanner(new File("UserInput.txt"));
				
			while(inputFile.hasNextLine() && userInput.hasNextLine())

			{ 
				System.out.print(inputFile.nextLine() + userInput.nextLine());
			}
				
			System.out.println(".\n");
	}

}
