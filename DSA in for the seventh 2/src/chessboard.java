 //if a board has spot 0 going to be empty if it has a spot one its going to be a queen 
public class chessboard {
 private static int board[][]; // board 2d integer array 
 private int nQueens; //the number of queens we have on the board
  public chessboard(int row, int col) {
  nQueens = 0; //when we start there will be no queens on the board 
  board = new int[8][8]; // 8 x 8 array which is then filled with zeros 	
  for (int j = 0; j < 8; j++)
  {
   for (int i = 0; i < 8; i++) {
    board[j][i] = 0; //filling the board with zeros 
   }
  }
  //handles the user input value 
  board[col][row] = 1;
  nQueens++; //increment number of queens so takes in to account users queen 
  this.printBoard();
 }
 public int getNumQueens() {
  return nQueens; //return number of queens
 }
 public void start() {
  solve(nQueens);
 }

 public boolean solve(int nQueens) {
  //if its the user selected row, increment queens and go to next row
  if (nQueens >= 8) {
   System.out.println("Solution 1:");
   this.printBoard();
   return true;
  } else {
   for (int j = 0; j < 8; j++) {
    for (int k = 0; k < 8; k++) {
     if (validMove(j, k) == 0) {
      this.placeQueen(j, k, 0);
      nQueens++;
      if (solve(nQueens)) {
       return true; //if theres a solution return true 
      } else {
       //if  cant solve remove queen at this location 
    	  	this.placeQueen(j, k, 1);
       //derement amount of queens 
        nQueens--;
      }
     }
    }

   }
  }
  //then backtrack till find right soultion 
  return false;
 }
 //only one instance of this method 
 public static int validMove(int x, int y) {
  for (int j = 0; j < 8; j++) //checking the row 
  {
   if (get(x, j) == 1) {
    return -1;//if something on x axis return invalid
   }
   if (get(j, y) == 1) {
    return -1; //if something on y axis return invalid
   }
  }
  //check diagonal 
  for (int j = 0; j < 8; j++) {
   //up left 
   if (get(x - j, y - j) == 1) {
    return -1;
   }
   //downward left 
   if (get(x - j, y + j) == 1) {
    return -1;
   }
   //up right 
   if (get(x + j, y - j) == 1) {
    return -1;
   }
   //downwards right 
   if (get(x + j, y + j) == 1) {
    return -1;
   }
  }
  return 0;
 }
 //return an integer going to take x, y and type 
 public int placeQueen(int row, int col, int type) {

  if (type == 0) //if spot 0 going to be empty 
  {
   board[row][col] = 1;
   nQueens++; // incremenet number of queens 
   return 0;
  } else if (type == 1) //if spot 1 going to be a queen 
  {
   board[row][col] = 0;
   return 0;
  }
  return -3;
 }
 public static int get(int x, int y) {
  if (x < 0 || y < 0 || x > 7 || y > 7) ///if it goes off the board 
  {
   return -1; //not valid 
  }
  return board[x][y]; //returning the board at the intergers 
 }
 public void printBoard() {
  for (int j = 0; j < 8; j++) //goes through every row
  {
   for (int i = 0; i < 8; i++) //goes throw every column  
   {
    System.out.print(this.get(j, i) + " "); //space is for formatting 
   }
   System.out.println(""); //moving it down to another line 
  }
 }
}