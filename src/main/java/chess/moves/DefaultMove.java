package chess.moves;

import chess.BoardMove;
import chess.Direction;
import chess.InvalidMoveException;

public class DefaultMove extends AbstractMove{

	@Override
	public void move(String[][] board, Direction direction, String piece, String currLocation, String lastLoc) throws InvalidMoveException {
		int[] currentL = super.getIndexesFromString(currLocation);
		int[] lastL = super.getIndexesFromString(lastLoc);
		boolean isValid = this.isValidMove(board, direction, piece, currLocation, lastLoc);
		if(isValid) {
			board[currentL[0]][currentL[1]] = "--";
			board[lastL[0]][lastL[1]] = piece;
		}else {
			throw new InvalidMoveException("Invalid move");
		}
//		switch(direction) {
//		case Top:
//			moveUp(board, piece, currentL, lastL);
//			break;
//		case Bottom:
//			break;
//		}
	}
	@Override
	public boolean isValidMove(String[][] board, Direction direction, String piece, String currLocation,
			String lastLoc) throws InvalidMoveException {
		return false;
	}
	
	
	
}
