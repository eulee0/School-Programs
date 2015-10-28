
import java.io.*;
import java.util.Scanner;

public class Lee_GameOfLife {
  private char[][] board;
  private int columns;
  private int rows;
  char[][] tempBoard;
  
  
//method  : main
//purpose : Runs the Conway's Game of Life
  public static void main(String[] args) throws FileNotFoundException {
    Lee_GameOfLife game = new Lee_GameOfLife();
    Scanner keyboard = new Scanner(System.in);
    System.out.print("Enter how many generations to compute: ");
    int gen = keyboard.nextInt();
    System.out.println ();
    System.out.println("Generation 1:");
    game.print();
    System.out.println();

    for (int i = 2; i <= gen; i++) {
      System.out.println("Generation " + i);
      game.computeNextGeneration();
      game.print();
      System.out.println();
    }
  }
  
//method  : Lee_GameOfLife
//purpose : Takes file input and creates a 2d array on which it is simulated on
  public Lee_GameOfLife() throws FileNotFoundException {
    Scanner keyboard = new Scanner(System.in);
    System.out.print("Enter file name: ");
    String filename = keyboard.nextLine();
    File file = new File(filename);
    Scanner inputFile = new Scanner(file);
    int columns = inputFile.nextInt();
    int rows = inputFile.nextInt();
    inputFile.nextLine();
    this.board = new char[rows][columns];
    this.tempBoard = new char[board.length][board[0].length];

    for (int i = 0; i < rows; i++) {
      
      for (int j = 0; j < columns; j++) {
    	  board[i][j] = inputFile.next().charAt(0);
      }
    }
  }
  
//method  : getColumns
//purpose : returns number of columns
  public int getColumns() {
    return columns;
  }
  
//method  : getRows
//purpose : returns number of rows
  public int getRows() {
    return rows;
  }
  
//method  : getCell
//purpose : returns cell value of specific cell
  public int getCell(int rows, int columns) {
    if (board[rows][columns] == 'X' || board[rows][columns] == '0') {
      return board[rows][columns];
    } else {
      return 0;
    }
  }
  
//method  : setCell
//purpose : sets the value of the specific cell
  public void setCell(int rows, int columns, char value) {
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
    	  board[rows][columns] = value;
      }
      if(value == 0)
		{
			board[rows][columns] = '0';
		}
		if(value == 1)
		{
			board[rows][columns] = 'X';
		}
    }
  }
  
//method  : cellNeighbors
//purpose : Checks the cell values around the specific cell
  public int cellNeighbors(int rows, int columns)
  {
      int count = 0;
      int i = rows;
      int j = columns;
      int left;
      int right;
      int up;
      int down;
   
      if (i > 0) {
          up = i-1;
      }
      	else {
      		up = board.length-1;
      }   
      if (i < (board.length-1)) {
          down = i+1;
      }
      	else {
      		down = 0;
      }   
      if (j > 0) {
          left = j-1;
      }
      	else {
      		left = board[i].length-1;
      }   
      if (j < (board[i].length-1)) {
          right = j+1;
      }
      	else {
      		right = 0;
      }   
      if (board[up][left] == 'X') {
          count++;
      }   
      if (board[up][j] == 'X') {
          count++;
      }   
      if (board[up][right] == 'X') {
          count++;
      }  
      if (board[i][left] == 'X') {
          count++;
      }   
      if (board[i][right] == 'X') {
          count++;
      }  
      if (board[down][left] == 'X') {
          count++;
      } 
      if (board[down][j] == 'X') {
          count++;
      }
      if (board[down][right] == 'X') {
          count++;
      }
      return count;
  }
  
//method  : computeNextGeneration
//purpose : computes the next generation of the cycle
  public void computeNextGeneration()
  {
//      char[][] tempBoard = new char[board.length][board[0].length];
   
      for(int i = 0; i < board.length; i++) {
          for(int j = 0; j < board[0].length; j++) {
              if(board[i][j] == '0' && cellNeighbors(i,j) == 3) {
                  tempBoard[i][j] = 'X';
              }
              if(board[i][j] == 'X' && cellNeighbors(i,j) < 2) {
                  tempBoard[i][j] = '0';
              }
              if(board[i][j] == 'X' && cellNeighbors(i,j) > 3) {
                  tempBoard[i][j] = '0';
              }
              if(board[i][j] == 'X' && cellNeighbors(i,j) == 2 || cellNeighbors(i,j) == 3) {
                  tempBoard[i][j] = 'X';
              }
              
             tempBoard = board;
          }
      }
          
      }
   
//method  : print
//purpose : prints the 2d array
  public void print() {
	  System.out.println();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        System.out.print( board[i][j] + " ");
      }
      System.out.println();
    }
  }
}

