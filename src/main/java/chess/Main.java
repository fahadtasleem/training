package chess;

public class Main {
	public static void main(String[] args) throws InvalidMoveException {
		Board board = new Board();
		board.printBoard();
		//Horse Move
//		board.move("BH", "71", "52");
//		board.move("BH", "52", "31");
//		board.move("BH", "31", "12");
		
		//Pawn move
		board.move("WP", "aa", "22");
//		board.move("WP", "22", "12");
		board.move("WH", "01", "11");
		board.move("WP", "11", "21");
		board.move("WH", "01", "11");
//		board.move("BQ", "73", "75");
//		board.move("BQ", "73", "78");
		
//		board.move("WQ", "13", "72");
//		board.move("WQ", "03", "30");
//		board.move("BP", "63", "64");
//		board.move("WQ", "33", "74");
		
//		board.move("WP", "22", "32");
//		board.move("BP", "51", "41");
//		board.move("BP", "41", "32");
//		board.move("WP", "22", "31");
		
		//Queen move
//		board.move("WQ", "23", "37");
//		board.move("WQ", "37", "47");
//		board.move("WQ", "47", "37");
//		board.move("WQ", "37", "23");
		//board.move("WQ", "23", "03");
	}
}
