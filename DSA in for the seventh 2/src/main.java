
public class main {
	public static void main(String[] args) {
		//enter row
		System.out.print("Enter row" ); 
		int row = BIO.getInt(); 
		System.out.println("Enter column"); 
		int col = BIO.getInt(); 
		System.out.println("you choose:("+ row + "," + col + ")");
		chessboard board = new chessboard(col,row); 
		board.start(); 
		
	}

}
