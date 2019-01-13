package chess.moves;

import chess.Direction;
import chess.InvalidMoveException;

public class QueenMove extends DefaultMove{
	@Override
	public boolean isValidMove(String[][] board, Direction direction, String piece, String currLocation, String lastLoc)
			throws InvalidMoveException {
		int[] currentL = super.getIndexesFromString(currLocation);
		int[] lastL = super.getIndexesFromString(lastLoc);
		int colDiff = lastL[1] -currentL[1];
		int rowDiff = lastL[0] - currentL[0];
		
		int colDiffAbs = Math.abs(colDiff);
		int rowDiffAbs = Math.abs(rowDiff);
		
		if((colDiff>0 || colDiff <0) && rowDiff == 0) {
			//Move horizontal
			moveHorizontal(board, piece, currentL, lastL);
		}else if(colDiff == 0 && (Math.abs(rowDiff)>0)) {
			//Move vertical
			moveVertical(board, piece, currentL, lastL);
		}else if(colDiffAbs == rowDiffAbs) {
			//Move Diagonal
		}
		// TODO Auto-generated method stub
		return true;
	}
}
