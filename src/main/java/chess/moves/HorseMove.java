package chess.moves;

import chess.Direction;
import chess.InvalidMoveException;

public class HorseMove extends DefaultMove{

	@Override
	public boolean isValidMove(String[][] board, Direction direction, String piece, String currLocation,String lastLoc) throws InvalidMoveException {
		int[] currentL = super.getIndexesFromString(currLocation);
		int[] lastL = super.getIndexesFromString(lastLoc);
		
		int colDiff = lastL[1] -currentL[1];
		int rowDiff = lastL[0] - currentL[0];
		char pirceColor = piece.charAt(0);
		if(pirceColor ==board[lastL[0]][lastL[1]].charAt(0) ) {
			throw new InvalidMoveException();
		}
		if((colDiff == -2 || colDiff == 2) && (rowDiff == -1 || rowDiff == 1)) {
			
		}else if((rowDiff == -2 || rowDiff == 2) && (colDiff == -1 || colDiff == 1)){
			
		}
		else{
			return false;
		}

		return true;
	}
}
