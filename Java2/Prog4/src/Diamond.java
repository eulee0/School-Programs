
public class Diamond implements Comparable <Diamond> {
	
    String stockNumber;
    double carot;
    String clarity;
    char color;
    String cut;
    
    //method  : Diamond
  	//purpose : initializes instance variables
    public Diamond(String sNum, double sCarot, String sClarity, char sColor, String sCut) {
    stockNumber = sNum;
    carot = sCarot;
    clarity = sClarity;
    color = sColor;
    cut = sCut;
    }
    
    //method  : getStock
  	//purpose : returns the stock number
    public String getStock() {
        return this.stockNumber;
    	}
    
    //method  : getCarot
  	//purpose : returns the carot
    public double getCarot() {
        return this.carot;
    	}
    
    //method  : getClarity
  	//purpose : returns the clarity
    public String getClarity() {
        return this.clarity;
    	}
    
    //method  : getColor
  	//purpose : returns the color
    public char getColor(){
        return this.color;
    	}
    
    //method  : getCut
  	//purpose : returns the cut
    public String getCut() {
        return this.cut;
    	}
    
    //method  : toString
  	//purpose : returns each list element of a diamond
    public String toString(){
    	 return "stockNumber : " +getStock() + " carot : " +getCarot() + " clarity : " +getClarity()+ " color : " +getColor() + " cut : " +getCut()+"";
    	}
    
    //method  : compareTo
  	//purpose : compares each diamond to each other to determine its rank
    public int compareTo(Diamond other) {
    	if (this.carot < other.getCarot()){
    		return -1;
        }   		
        else if (this.carot > other.getCarot()){
            return 1;            
        }
    	
        if (this.color < other.getColor()) {
        	return -1;
        }
    	else if (this.color > other.getColor()) {
    		return 1;
        }
    	
		if (this.clarity.compareTo(other.getClarity()) < 1) {
			return 1;
		}
		else if (this.clarity.compareTo(other.getClarity()) > 1) {
			return -1;
		}
		return 0;
    }
}
