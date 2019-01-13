package chess.moves;

import chess.Direction;
import chess.InvalidMoveException;

public class PawnMove extends DefaultMove{
	
	
	@Override
	public boolean isValidMove(String[][] board, Direction direction, String piece, String currLocation,String lastLoc) throws InvalidMoveException {
		int[] currentL = super.getIndexesFromString(currLocation);
		int[] lastL = super.getIndexesFromString(lastLoc);
		boolean isRowCorrect = checkForOneCellMove(lastL[0],currentL[0]);
		boolean isColCorrect = checkForOneCellMove(lastL[1],currentL[1]);
		
		if(!isRowCorrect || !isColCorrect) {
			throw new InvalidMoveException();
		}
		
		int colDiff = lastL[1] -currentL[1];
		boolean isDiagonal = false;
		if(colDiff !=0 ) {
			isDiagonal = true;	
		}
		if(direction != null) {
			switch(direction) {
			case Top:
				if(lastL[0]<currentL[0]) {
					if(isDiagonal) {
						String pieceAtPresent = board[lastL[0]][lastL[1]];
						if(!pieceAtPresent.startsWith("W")) {
							throw new InvalidMoveException();
						}
						//piece.startsWith("W")
					}
				}
				else
					return false;
				break;
			case Bottom:
				if(lastL[0]>currentL[0]) {
					if(isDiagonal) {
						String pieceAtPresent = board[lastL[0]][lastL[1]];
						if(!pieceAtPresent.startsWith("B")) {
							throw new InvalidMoveException();
						}
					}
				}else
					return false;
				break;
			default:
				throw new InvalidMoveException("Direction is not correct");
			}
		}
		return true;
	}
}
