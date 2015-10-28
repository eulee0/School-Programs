
import java.util.Scanner;

public class Lee_Driver {
	
	public static class Lee_Geometry {
		
			//method : circleArea
			//purpose : calculates area of a circle
			public static double circleArea(double radius) {
				
				if (radius < 0) {
					System.out.println ("ERROR: Radius cannot be negative.");
					return 0;
				}
				else {
					return Math.round(100 * Math.PI * radius * radius)/((double)100);
				}
			}
			
			//method : rectArea
			//purpose : calculates area of a rectangle
			public static double rectArea(double length, double width) {
				
				if (length < 0 || width < 0) {
					System.out.println ("ERROR: Length and Width cannot be negative.");
					return 0;
				}
					else {
						return Math.round(100 * length * width)/((double)100);
					}
			}
			
			//method : triArea
			//purpose : calculates area of a triangle
			public static double triArea(double base, double height) {
				
				if (base < 0 || height < 0) {
					System.out.println ("ERROR: Base and Height cannot be negative.");
					return 0;
				}
				else {
					return Math.round(100 * base * height * 0.5)/((double)100); 
				}
			}
		}
	
	//method : main
	//purpose : takes user input of integer for the menu
	public static void main (String[] args) {
		
		int selection = 0;
		
		do {
			selection = menu();
				if (selection ==1) {
					getCircleArea();
				}
				else if (selection ==2) {
					getRectArea();
				}
				else if (selection ==3) {
					getTriArea();
				}
				else if (selection ==4) {
					System.exit(0);
				}
			}
				while (selection !=4);
		}
	
	//method : menu
	//purpose : creates a menu for the user to choose which area to calculate
	public static int menu() {
		
		Scanner sc = new Scanner(System.in);
		int number = 0;
		
			System.out.println("Geometry Calculator");
			System.out.println("1. Calculate the Area of a Circle");
			System.out.println("2. Calculate the Area of a Rectangle");
			System.out.println("3. Calculate the Area of a Triangle");
			System.out.println("4. Quit\n");
			System.out.print("Enter your choice (1-4): ");
		
		number = sc.nextInt();
		System.out.println ("");
		
			while (number < 1 || number > 4) {
				System.out.print("ERROR: Selection is not between 1 and 4. ");
					number = sc.nextInt();
					System.out.println ("");
		}
			
			return number;
	}
	
	//method : getCircleArea
	//purpose : takes user input and prints out the area of the circle
	public static void getCircleArea() {
		
		double radius = 0.0;
		
		Scanner sc = new Scanner(System.in);
			System.out.print ("Enter the radius of the circle: ");
				radius = sc.nextDouble();
				System.out.println ("");
			
		System.out.println ("The area of the circle is: " + Lee_Geometry.circleArea(radius) + "\n");
		
	}
	
	//method : getRectArea
	//purpose : takes user input and prints out the area of the rectangle
	public static void getRectArea() {
		
		double length = 0.0;
		double width = 0.0;
		
		Scanner sc = new Scanner(System.in);
			System.out.print ("Enter the length of the rectangle: ");
				length = sc.nextDouble();
				System.out.println ("");
			System.out.print ("Enter the width of the rectangle: ");	
				width = sc.nextDouble();
				System.out.println ("");	
			
		System.out.println ("The area of the rectangle is: " + Lee_Geometry.rectArea(length, width)+ "\n");
			
	}
	
	//method : getTriArea
	//purpose : takes user input and prints out the area of the triangle
	public static void getTriArea() {
		
		double base = 0.0;
		double height = 0.0;
		
		Scanner sc = new Scanner(System.in);
			System.out.print("Enter the base of the triangle: ");
				base = sc.nextDouble();
				System.out.println ("");	
			System.out.print ("Enter the height of the triangle: ");
				height = sc.nextDouble();
				System.out.println ("");
				
		System.out.println ("The area of the triangle is: " + Lee_Geometry.triArea(base, height) + "\n");
		
	}
	
	
}