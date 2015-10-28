import java.util.Scanner;
import java.io.IOException;

public class Decoder {
	
	
	//method:main
	//purpose: Prints the output of the Phrase.
	public static void main (String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		String secretMessage = decodePhrase (inputPhrase(sc), getCode(sc));
		System.out.println ("\nYour secret message is: " +secretMessage+ "\n");
		
	}
	
	 //method:inputPhrase
     //purpose:Takes the phrase within the first line of the text file and returns it.
	 public static String inputPhrase(Scanner s) throws IOException{
		 
		 String phrase = s.nextLine();
		return phrase;
	 }
	 
	 //method:getCode
     //purpose:Gathers all integers within the second line of the text file as an array and returns it.
	 public static int[] getCode(Scanner s) {
		
		 String codeSplit = s.nextLine();
		 	String[] codeArray = codeSplit.split(" ");

		 	int[] codeInt = new int[codeArray.length];
		 			 
		 	for (int i=0; i<codeArray.length; i++) {
		 		codeInt[i] = Integer.parseInt(codeArray[i]);
		 	}
		 	
		 	return codeInt;
		 }
		 
	
	 //method:decodePhrase
     //purpose:Takes the phrase and matches the letters to those ints in the array to decode the phrase.
	 public static String decodePhrase(String phrase, int[] codeInt) {

		 String decodedPhrase = ("");
		 for(int i = 0; i < codeInt.length; i++) {
			 char letter = phrase.charAt(codeInt[i]);
			 decodedPhrase += Character.toLowerCase(letter);
		 }
		 return decodedPhrase;
     }
	
	
}