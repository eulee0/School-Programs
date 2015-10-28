
/* Class that holds constructors and methods in use for BST. Methods used in Program1. 
 * Was called BST before, but due to Eclipse refactoring, the code looks a little different*/
 public class Program2{
     Program2 left, right;
     int data;
     
     public Program2(){ //Constructor    
         left = null;
         right = null;
         data = 0;
     }
     public Program2(int n){ //Constructor   
         left = null;
         right = null;
         data = n;
     } 
     public void setLeft(Program2 node){ //sets left node   
         left = node;
     }
     public void setRight(Program2 node){ //sets right node   
         right = node;
     } 
     public Program2 getLeft(){ //gets left node     
         return left;
     } 
     public Program2 getRight(){ //gets right node     
         return right;
     }     
     public void addData(int num){ //adds info. to a node     
         data = num;
     }  
     public int getData(){ //gathers info on a node    
         return data;
     }     
 }
 
 /* Class that holds methods directly involved in user commands in Program1. */
  class BST {
     private Program2 root;   //creates BST root for future reference
     public BST(){   //Constructor     
         root = null;
     }
  
     public boolean isEmpty(){ //Check if BST is empty, therefore no root    
         return root == null;
     }

     public void insert(int number){ //Inserts a given integer into BST   
         root = insert(root, number);
     }

     private Program2 insert(Program2 node, int var){ //Inserts integer recursively    
         if (node == null) {						//If the node doesn't exist, place new node.
             node = new Program2(var);
         }
         else if (var < node.getData()) { 			//If it is less than, go left.
                 node.left = insert(node.left, var);             		
         }
         else if (var == node.getData()) {		//If it is equal to existing node, no duplicates allowed
            	 System.out.println (var + " already exists, ignore.");
            }
         else {									//If it is greater than, go right.
                 node.right = insert(node.right, var);             		
             }
         return node;
     }

     public void delete(int var){ //Removes given integer from BST     
         if (isEmpty())			// Nothing to remove if tree is empty
             System.out.println("The tree is currently empty.");
         else if (search(var) == false) // Nothing to remove if given integer does not exist in BST
             System.out.println( var + " doesn't exist!");
         else{					//removes specified variable        
             root = delete(root, var);
         }
     }
     
     private Program2 delete(Program2 root, int var){ //Removes given integer recursively     
         Program2 point1;
         Program2 point2;
         Program2 node;
         
         if (root.getData() == var){					//Remove root if selected
         
             Program2 lNode, rNode;
             lNode = root.getLeft();
             rNode = root.getRight();
             if (lNode == null && rNode == null)	//Return nothing if no children
                 return null;
             else if (lNode == null){			//Only right child exists            
                 point1 = rNode;
                 return point1;
             }
             else if (rNode == null){				//Only left child exists            
                 point1 = lNode;
                 return point1;
             }
             else{									//Both children exist           
                 point2 = rNode;
                 point1 = rNode;
                 while (point1.getLeft() != null)
                     point1 = point1.getLeft();
                 point1.setLeft(lNode);
                 return point2;
             }
         }
         if (var < root.getData()){					//If variable is less than, go left after deletion         
             node = delete(root.getLeft(), var);
             root.setLeft(node);
         }
         else{        
             node = delete(root.getRight(), var);	//If variable is greater than, go right after deletion
             root.setRight(node);             
         }
         return root;
     }
     
     public int predecessor(int var){ //Finds predecessor of a given variable     
         root = predecessor(root, var);
		return var;
     }
     private Program2 predecessor(Program2 node, int number) { //Finds predecessor recursively (incomplete)
    		if ((node.left == null) && (node.right==null)) {
    			return predecessor(node, number);
    		}
    		if (node.right != null) {
    			node = node.right;
    			return predecessor(node, number);
    		}
    		if (node.left != null) {
    			node = node.left;
    			return predecessor(node, number);
    		}
			return node;
    	}
     
     public int successor(int var){	//Finds successor of a given variable    
         root = successor(root, var);
		return var;
     }
     private Program2 successor(Program2 node, int number) {	//Finds successor recursively (incomplete)
    		if ((node.left == null) && (node.right==null)) {
    			return successor(node, number);
    		}
    		if (node.right != null) {
    			node = node.right;
    			return successor(node, number);
    		}
    		if (node.left != null) {
    			node = node.left;
    			return successor(node, number);
    		}
			return node;
    	}

     public boolean search(int var){ //Search for a given variable in the BST     
         return search(root, var);
     }

     private boolean search(Program2 node, int var){	//Search recursively for a BST variable    
         boolean found = false;
         while ((node != null) && !found){	//if variable exists, boolean true, else false
         
             int nodeVar = node.getData();
             if (var < nodeVar)				
                 node = node.getLeft();
             else if (var > nodeVar)
                 node = node.getRight();
             else{            
                 found = true;
                 break;
             }
             found = search(node, var);
         }
         return found;
     }
 
     public void inorder(){ //In order traversal for a BST    
         inorder(root);
     }
     private void inorder(Program2 node){ //using given node   	   	 
         if (node != null){
         
             inorder(node.getLeft());
             System.out.print(node.getData() +" ");
             inorder(node.getRight());            
         }        	 
     } 

     public void preorder(){ //Pre order traversal for a BST    
         preorder(root);
     }
     private void preorder(Program2 node){ //using given node    
         if (node != null){         
             System.out.print(node.getData() +" ");
             preorder(node.getLeft());             
             preorder(node.getRight());
         }
     }
 
     public void postorder(){ //Post order traversal for a BST    
         postorder(root);
     }
     private void postorder(Program2 node){ //using given node    
         if (node != null){        
             postorder(node.getLeft());             
             postorder(node.getRight());
             System.out.print(node.getData() +" ");
         }
     }     
 }
 
