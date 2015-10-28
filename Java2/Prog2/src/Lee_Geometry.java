 

public class Lee_Geometry {
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
