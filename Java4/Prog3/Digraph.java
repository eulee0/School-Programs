
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Digraph {
    private int[]      value; 		//Value of City
    private String[]   theCityName;	//Name of City
    private String[]   theCityCode; //Code of City
    private int[]      population;  //Population of City
    private int[]      elevation;   //Elevation of City
    private double[][] djikstra;
      
    Digraph() {       //Class Constructor, runs findCityData()
    	findCityData();
    	}
 //Attempts to find data of city given by given files, then returned to user [Q].
    public void findCityData() {
        try {
            String readCity = "";
            String readRoad = "";
            String current;

            FileReader frCity = new FileReader ("city.dat"); //file containing cities used within program
    		BufferedReader brCity = new BufferedReader (frCity);
            while ((current = brCity.readLine()) != null && !current.equals("")) {
                readCity += current.trim() + "\n";
            }
            readCity = readCity.trim();
            String[] cityArray = readCity.substring(0, readCity.length()).split("\n");

            FileReader frRoad = new FileReader ("road.dat"); //file containing distances between cities
    		BufferedReader brRoad = new BufferedReader (frRoad);
            while ((current = brRoad.readLine()) != null && !current.equals("")) {
                readRoad += current.trim() + "\n";
            }
            readRoad = readRoad.trim();
            String[] roadArray = readRoad.substring(0, readRoad.length()).split("\n");

            frCity.close();
            frRoad.close();

            value =        new int[cityArray.length];		//update arrays with length from array created from FileReader
            theCityName =  new String[cityArray.length];
            theCityCode =  new String[cityArray.length];
            population =   new int[cityArray.length];
            elevation =    new int[cityArray.length];

            for (int i = 0; i < cityArray.length; i++) {		//insert values into updated arrays 
                String[] foo = cityArray[i].split("\\s{2,}");
	                value[i] = Integer.parseInt(foo[0]);
	                theCityCode[i] = foo[1];
	                theCityName[i] = foo[2];
	                population[i] = Integer.parseInt(foo[3]);
	                elevation[i] = Integer.parseInt(foo[4]);
            }

            djikstra = new double[cityArray.length][cityArray.length];
            for (int i = 0; i < djikstra.length; i++) {
                for (int j = 0; j < djikstra[i].length; j++) {
                    if (i == j) {
                        djikstra[i][j] = 0;
                    } else {
                        djikstra[i][j] = Double.MAX_VALUE;
                    }
                }
            }

            for (String aRoadDat : roadArray) {
                String[] temp = aRoadDat.split("\\s+");
                djikstra[Integer.parseInt(temp[0]) - 1][Integer.parseInt(temp[1]) - 1] = Integer.parseInt(temp[2]);
            }
        } catch (FileNotFoundException fileNotFound) { 
            System.out.println("FILE ERROR");
            
        } catch (IOException ioerror) {
            ioerror.printStackTrace();
        }
    }
//returns the djikstra graph of the cities/distances
    public double[][] getDjikstraGraph() {
        return djikstra;
    }   
//returns the name of the city within the correct array
    public String getCityName(int i) {
        return theCityName[i];
    }
  //returns the code of the city within the correct array
    public String getCityCode(int i) {
        return theCityCode[i];
    }
  //returns the value of the city within the correct array   
    public int getCityValue(int i) {
        return value[i];
    }
  //returns the population of the city within the correct array   
    public int getPopulation(int i) {
        return population[i];
    }
  //returns the elevation of the city within the correct array
    public int getElevation(int i) {
        return elevation[i];
    }
//returns current index of city code
    public int getCurrent (String cityCode) {
        for (int i = 0; i < theCityCode.length; i++) {
            if (theCityCode[i].equals(cityCode)) {
                return i;
            }
        }
        return 0;
    }
}
    
    
