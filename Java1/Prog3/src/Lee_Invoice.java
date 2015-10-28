
import java.util.Scanner;

public class Lee_Invoice {

	// method: main 
	// purpose: this method takes user input about gas sold and
	// prints out a certain invoice for total charge, given if
	// the user is a member or not
	public static void main (String [] args) {
		
		String membership;
		int gasQuality;
		int galSold;
		double unleaded = 3.87;
		double unleadedPlus = 3.98;
		double premium = 4.01;
		double uDiscount = 3.77;
		double uPDiscount = 3.88;
		double pDiscount = 3.91;
		Scanner sc = new Scanner(System.in);
		
		System.out.print ("\nAre you a member? ");
			 membership = sc.nextLine();
		System.out.print ("\tQuality of gas: ");
			 gasQuality = sc.nextInt();
		System.out.print ("\t  Gallons sold: ");
			 galSold = sc.nextInt();
			 
			 
		if (gasQuality == 87) {
						System.out.println("\nINVOICE FOR GASOLINE");
						System.out.println("\tMember Status: "+membership);
				if (membership.equals ("yes")) {
						System.out.println(" Gasoline Sold/Price: "+galSold+ " @ $" +(uDiscount));
				}
				else {
						System.out.println(" Gasoline Sold/Price: "+galSold+ " @ " +unleaded);
				}
						System.out.printf("\n%15s $%7.2f", ("Subtotal:"), (galSold*uDiscount));
						System.out.printf("\n%15s $%7.2f", ("County Tax:"), ((galSold*uDiscount*0.07)));
						System.out.printf("\n%15s $%7.2f", ("City tax:"), ((galSold*uDiscount*0.0375)));
						System.out.printf(("\n%28s"), ("--------------"));
						System.out.printf("\n%15s $%7.2f", ("Total:"), (((galSold*uDiscount)+(galSold*uDiscount*0.07)+(galSold*uDiscount*0.0375))));
			}
	
	else{
		
			if (gasQuality == 89) {
					System.out.println("\nINVOICE FOR GASOLINE");
					System.out.println("\tMember Status: "+membership);
				if (membership.equals ("yes")) {
					System.out.println(" Gasoline Sold/Price: "+galSold+ " @ $" +(uPDiscount));
				}
				else {
					System.out.println(" Gasoline Sold/Price: "+galSold+ " @ " +unleadedPlus);
				}
					System.out.printf("\n%15s $%7.2f", ("Subtotal:"), (galSold*uPDiscount));
					System.out.printf("\n%15s $%7.2f", ("County Tax:"), ((galSold*uPDiscount*0.07)));
					System.out.printf("\n%15s $%7.2f", ("City tax:"), ((galSold*uPDiscount*0.0375)));
					System.out.printf(("\n%28s"), ("--------------"));
					System.out.printf("\n%15s $%7.2f", ("Total:"), (((galSold*uPDiscount)+(galSold*uPDiscount*0.07)+(galSold*uPDiscount*0.0375))));
			}
		}	
	
			if (gasQuality == 91) {
					System.out.println("\nINVOICE FOR GASOLINE");
					System.out.println("\tMember Status: "+membership);
				if (membership.equals ("yes")) {
					System.out.println(" Gasoline Sold/Price: "+galSold+ " @ $" +(pDiscount));
				}
				else {
					System.out.println(" Gasoline Sold/Price: "+galSold+ " @ " +premium);
				}
					System.out.printf("\n%15s $%7.2f", ("Subtotal:"), (galSold*pDiscount));
					System.out.printf("\n%15s $%7.2f", ("County Tax:"), ((galSold*pDiscount*0.07)));
					System.out.printf("\n%15s $%7.2f", ("City tax:"), ((galSold*pDiscount*0.0375)));
					System.out.printf(("\n%28s"), ("--------------"));
					System.out.printf("\n%15s $%7.2f", ("Total:"), (((galSold*pDiscount)+(galSold*pDiscount*0.07)+(galSold*pDiscount*0.0375))));
					
			}
		System.out.println("\n");	
}
	
}
	
