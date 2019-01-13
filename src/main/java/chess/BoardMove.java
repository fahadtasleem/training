package chess;

public interface BoardMove {
	void move(String[][] board,Direction direction,String piece,String currLocation,String lastLoc) throws InvalidMoveException ;
	
	boolean isValidMove(String[][] board,Direction direction,String piece,String currLocation,String lastLoc) throws InvalidMoveException ;
}
