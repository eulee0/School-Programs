
import java.util.Random;

public class Project2 {				//Class that contains the binary heap implementation methods
    private static int maxHeap[];		//creates a max heap as an array
    private static int position;		//the current position in the heap

//builds heap of 100 randomly generated integers (0-1000) sequentially
    public static void randomGenSequential() {		
        Random rand = new Random();
        int swap = 0;
        
        for (int i = 0; i < 20; i++) {		
            maxHeap = new int[100];
            for (int j = 0; j < 100;) {
                if (insert(1 + rand.nextInt(1000))) { 
                    swap = swap + upwardsReheap(); j++;		//update of swap count
                }
            }
        }
        System.out.println("Average swaps for series of insertions: " + (swap/20));
    }

//builds heap of 100 randomly generated integers (0-1000) optimally
    public static void randomGenOptimal() {		
        Random rand = new Random();
        int swap = 0;
        int swap1 = 0;
        
        for (int i = 0; i < 20; i++) { 		
            maxHeap = new int[100];
            for (int j = 0; j < 100; ) {
                if (insert(1 + rand.nextInt(1000))) { j++;
                }
            }                    
	    }
	         int index = (maxHeap.length - 1) / 2;
		        for (index=maxHeap.length; index >= 0; index--) {		//reheapification
		            swap1 = swap1 + downwardsReheap(index);
		            swap = swap + swap1;		//update of swap count
		        }
		        
        System.out.println("Average swaps for optimal method: " + (swap/20));
    }

//builds heap of integers (0-100) sequentially
    public static void presetGenSequential() {		
        int swap = 0;

        maxHeap = new int[100];
        for (int i = 0; i < 100; i++) {		
            if (insert(i + 1)) {
                swap = swap + upwardsReheap(); 		//update of swap count
            }
        }
        
        System.out.print("Heap built using series of insertions: ");
	        for (int i = 0; i < 10; i++) {
	            System.out.print(maxHeap[i] + ",");
	        }
        
        System.out.println("...");
        System.out.println("Number of swaps: " + swap);
	        for (int i = 0; i < 10; i++) {
	            delete();
	        }
        
        System.out.print("Heap after 10 removals: ");
	        for (int i = 0; i < 10; i++) {
	            System.out.print(maxHeap[i] + ",");
	        }
        
        System.out.print("...");
        System.out.println("\n");
    }
       
//builds heap of integers (0-100) optimally        
    public static void presetGenOptimal() {			
        int swap = 0;
        int swap1 = 0;
            
        maxHeap = new int[100];				
	        for (int i = 0; i < 100; i++) {
	            insert(i + 1);
	        }
	        
	        int index = (maxHeap.length - 1) / 2;
		        for (index=maxHeap.length; index >= 0; index--) {		//reheapification
		            swap1 = swap1 + downwardsReheap(index);
		        }
	        swap = swap + swap1;		//update of swap count
        
        System.out.print("Heap built using optimal method: ");
	        for (int i = 0; i < 10; i++) {
	            System.out.print(maxHeap[i] + ",");
	        }
        
        System.out.println("...\nNumber of swaps: " + swap);
	        for (int i = 0; i < 10; i++) {
	            delete();
	        }
        
        System.out.print("Heap after 10 removals: ");
	        for (int i = 0; i < 10; i++) {
	            System.out.print(maxHeap[i] + ",");
	        }
        
        System.out.print("...\n");
    }
    
/////    
    
//reheapificiation from bottom to top of the heap
    private static int upwardsReheap() {		
        int swap    = 0;
        int pos = position;
        int parent  = (position - 1) / 2;
        
        while (maxHeap[pos] > maxHeap[parent]) {
            int foo = maxHeap[parent];
            maxHeap[parent] = maxHeap[pos];
            maxHeap[pos] = foo;
            pos = parent;
            parent  = (pos - 1) / 2;
            swap++;		//update of swap count
        }
        return swap;
    }

//reheapification from top to bottom of the heap    
    private static int downwardsReheap(int number) {		
        int swap = 0;
        
        int left  = (2*number) + 1;
        int right = (2*number) + 2;
        
        int compared = number;
	        if (left < maxHeap.length && maxHeap[left] > maxHeap[compared]) {
	            compared = left;
	        }
	        if (right < maxHeap.length && maxHeap[right] > maxHeap[compared]) {
	            compared = right;
	        }
	        if (compared != number) {
	            int foo = maxHeap[number];
	            maxHeap[number] = maxHeap[compared];
	            maxHeap[compared] = foo;
	            swap= swap + 1 + downwardsReheap(compared);		//update of swap count
	        }
        return swap;
    }
    
/////

//inserts single value into the heap    
    private static boolean insert(int number) {		
        int num;
        for (num = 0; num < maxHeap.length; num++) {
            if (maxHeap[num] == number) {
                return false;
            }
            if (maxHeap[num] == 0) {
                break;
            }
        }
        maxHeap[num] = number;
        position     = num;
        return true;
    }

//extracts the max from the heap and reheapifies
    private static void delete() {		
        maxHeap[0] = maxHeap[position];
        maxHeap[position] = 0;
        downwardsReheap(0);
        position--;
    }

}