
import java.util.Scanner;
import java.lang.Math;

public class Lee_Program2b {
	
	// method: main
	// purpose:  This method accepts input from the user 
	//  to convert kilograms into tons, pounds, and 
	//  ounces all together
	
	public static void main (String [] args){
		
		int   kilograms = 0;
			Scanner sc = new Scanner (System.in);
		
		System.out.print ("Enter kilograms: ");
			kilograms = sc.nextInt();
		
				double totalPounds = kilograms*(2.2);
				double tons = (totalPounds/2000);
				double pounds = (totalPounds%2000);
				double ounces = ((totalPounds*16)%16);
		
		System.out.println (kilograms+ " kilogram(s) converts to "+(int)tons+ " ton(s), "+(int)pounds+ " pound(s), " +(double)Math.round(ounces*10)/10+ " ounce(s).");
	}
}
