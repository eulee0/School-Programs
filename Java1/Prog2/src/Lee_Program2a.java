import java.util.Scanner;
import java.lang.Math;

public class Lee_Program2a {
	
	// method: main 
	// purpose:  This method accepts input from the user in order
	//  to convert the given units into kilograms.
	
	public static void main (String[] args){
		
		Scanner sc = new Scanner (System.in);
		double t = 0;
		double p = 0;
		double o = 0;
		
			System.out.print ("Enter tons: ");
				t = sc.nextInt();
			System.out.print ("Enter pounds: ");
				p = sc.nextInt();
			System.out.print ("Enter ounces: ");
				o = sc.nextInt();
				
		double kg = (((2000*t)+p+(o/16))/2.2);	
		
			System.out.println ((int)t+ " ton(s), "+(int)p+" pound(s), "+(int)o+" ounce(s) converts to "+((double)Math.round(kg*10)/10)+" kilogram(s).");
	
	
	}
}