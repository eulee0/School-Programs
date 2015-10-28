
import java.util.Scanner;
import java.util.ArrayList;

public class Project3 {
	
    private static Digraph djikstra = new Digraph();
    private static double[][] djikstraGraph = djikstra.getDjikstraGraph();
    private static double[] distance;
    private static ArrayList<Integer> ArrayList;

    
    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            exit = display();
        }
    }
//displays a menu for the user to read
    public static boolean display() {
        System.out.print("Command? ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().toUpperCase();
        
        if (input.matches("\\s*[Q D I R H E]\\s*")) {
            char scInput = input.charAt(0);
            switch (scInput) {
                case 'Q': //outputs given city information 
                    System.out.print("City code: ");
                    String cityCode = sc.nextLine().toUpperCase();
                    if (cityCode.matches("\\s*[A-Z]{2}\\s*")) {
                        cityInfo(cityCode);
                    } else {
                        System.out.println("CITY CODE ERROR");
                    }
                    break;
                case 'D': //finds minimum distance between two cities given
                    System.out.print("City codes: ");
                    String cityCodes = sc.nextLine().toUpperCase();
                    if (cityCodes.matches("\\s*[A-Z]{2}\\s+[A-Z]{2}\\s*")) {
                        String[] codes = cityCodes.split("\\s+");
                        dijkstraMin(codes[0], codes[1]);
                    } else {
                        System.out.println("CITY CODE ERROR");
                    }
                    break;
                case 'I': //inserts a road between two cities with a given distance
                    System.out.print("City codes and distance: ");
                    String cityCodeDistance = sc.nextLine().toUpperCase();
                    if (cityCodeDistance.matches("\\s*[A-Z]{2}\\s+[A-Z]{2}\\s+\\d+\\s*")) {
                        String[] split = cityCodeDistance.split("\\s+");
                        insertRoad(split[0], split[1], split[2]);
                    } else {
                        System.out.println("CITY CODE ERROR");
                    }
                    break;
                case 'R'://removes a road between two cities
                    System.out.print("City codes: ");
                    cityCodes = sc.nextLine().toUpperCase();
                    if (cityCodes.matches("\\s*[A-Z]{2}\\s+[A-Z]{2}\\s*")) {
                        String[] codes = cityCodes.split("\\s+");
                        deleteRoad(codes[0], codes[1]);
                    } else {
                        System.out.println("CITY CODE ERROR");
                    }
                    break;
                case 'H': //display the menu message
                    System.out.println("   Q   Query the city information by entering the city code.");
                    System.out.println("   D   Find the minimum distance between two cities.");
                    System.out.println("   I   Insert a road by entering two city codes and distance.");
                    System.out.println("   R   Remove an existing road by entering two city codes.");
                    System.out.println("   H   Display this message.");
                    System.out.println("   E   Exit.");
                    break;
                case 'E': //program exit                  
                    System.exit(0);

            }
        } else {
            System.out.println("WRONG INPUT ERROR.");
            return false;
        }
        return false;
    }
//displays city information
    public static void cityInfo(String cityCode) {
        int current = djikstra.getCurrent(cityCode);
	        if (current == -1) {
	            System.out.println("CITY CODE ERROR.");
	        } else {
	            System.out.println(djikstra.getCityValue(current) + " "
	                    + djikstra.getCityCode(current) + " " + djikstra.getCityName(current) + " "
	                    + djikstra.getPopulation(current) + " " + djikstra.getElevation(current));
	        }
    }
    
    public static int findMinimumDistance() {
        double min = Double.MAX_VALUE;
        int mindex = 0;
	        for (Integer array1 : ArrayList) {
	            if (distance[array1] < min) {
	                min = distance[array1];
	                mindex = array1;
	            }
	        }
        return mindex;
    }
    
//uses djikstra graph and array list to find minimum distance
    public static void dijkstraMin(String start, String end) {
        int startDex = djikstra.getCurrent(start);
        int endDex = djikstra.getCurrent(end);
	        if (startDex == -1 || endDex == -1) {
	            System.out.println("CITY CODE ERROR.");
	            return;
	        }

        ArrayList = new ArrayList<>();
       
        distance = new double[djikstraGraph.length];
        int[] prev = new int[djikstraGraph.length];

        for (int i = 0; i < djikstraGraph.length; i++) {
            distance[i] = Double.MAX_VALUE;
            	prev[i] = -1;
            	ArrayList.add(i);
        }
        distance[startDex] = 0;

        while (!ArrayList.isEmpty()) {
            int minDist = findMinimumDistance();
	            if (distance[minDist] == Double.MAX_VALUE) {
	                break;
	            }
            ArrayList.remove(ArrayList.indexOf(minDist));
            for (int i = 0; i < djikstraGraph[minDist].length; i++) {
                double alt = distance[minDist] + djikstraGraph[minDist][i];
	                if (alt < distance[i]) {
	                    distance[i] = alt;
	                    prev[i] = minDist;
	                }
            }
        }

        System.out.print("The minimum distance between "
                + djikstra.getCityName(startDex) + " and " + djikstra.getCityName(endDex) + " is "
                + (int)distance[endDex] + " through the route: ");
        String between = end;
        int theEndDex = endDex;
        while (true) {
            between = djikstra.getCityCode(prev[theEndDex]) + ", " + between;
            theEndDex = prev[theEndDex];
	            if (theEndDex == startDex) {
	                break;
	            }
        }
        System.out.print(between + "\n");
    }
//inserts road between two cities of a certain distance
    public static void insertRoad(String cityCodeA, String cityCodeB, String distance) {
        int foo1 = djikstra.getCurrent(cityCodeA);
        int foo2 = djikstra.getCurrent(cityCodeB);
	        if (djikstraGraph[foo1][foo2] == Double.MAX_VALUE) {
	            djikstraGraph[foo1][foo2] = Double.parseDouble(distance);
		            System.out.println("You have inserted a road from " + djikstra.getCityName(foo1) + " to " 
		            + djikstra.getCityName(foo2) + " with a distance of " + distance);
	        } else {
	            	System.out.println("ERROR: A road already exists between "
	                + djikstra.getCityName(foo1) + " and " + djikstra.getCityName(foo2));
	        }
    }
//deletes road between two cities
    public static void deleteRoad (String cityCodeA, String cityCodeB) {
        int foo1 = djikstra.getCurrent(cityCodeA);
        int foo2 = djikstra.getCurrent(cityCodeB);
	        if (djikstraGraph[foo1][foo2] == Double.MAX_VALUE) {
	            System.out.println("The road from "
	                    + djikstra.getCityName(foo1) + " and " + djikstra.getCityName(foo2) + " doesn't exit.");
	        } else {
	            djikstraGraph[foo1][foo2] = Double.MAX_VALUE;
	            System.out.println("You have removed a road from "
	                    + djikstra.getCityName(foo1) + " to " + djikstra.getCityName(foo2));
	        }
    }
}