package chess.moves;

import chess.BoardMove;
import chess.InvalidMoveException;

public abstract class AbstractMove implements BoardMove{
	protected BoardMove move;
	
	public AbstractMove() {
		
	}
	
	public AbstractMove(BoardMove m) {
		this.move = m;
	}

	public BoardMove getMove() {
		return move;
	}

	public void setMove(BoardMove move) {
		this.move = move;
	}
	
	protected int[] getIndexesFromString(String location) {
		int[] locations = new int[2];
		if(location.length() ==2) {
			locations[0] = Integer.parseInt(location.charAt(0)+"");
			locations[1] = Integer.parseInt(location.charAt(1)+"");
		}
		return locations;
	}
	
	public void moveUp(String[][] board,String piece,int[] currLoc,int[] lastLoc) throws InvalidMoveException {
		char pirceColor = piece.charAt(0);
		boolean isPieceFoundOnPath = false;
		for(int i=currLoc[0];i>=lastLoc[0];i--) {
			char present = board[i][lastLoc[1]].charAt(0);
			if(isPieceFoundOnPath) {
				throw new InvalidMoveException("A piece found on path");
			}
			if(present == pirceColor) {
				throw new InvalidMoveException("Similar piece found on path");
			}else if(present != '-') {
				System.out.println("Opposite item found in path");
				isPieceFoundOnPath = true;
			}
		}
	}
	
	public void moveDown(String[][] board,String piece,int[] currLoc,int[] lastLoc) throws InvalidMoveException {
		char pirceColor = piece.charAt(0);
		boolean isPieceFoundOnPath = false;
		for(int i=currLoc[0];i<=lastLoc[0];i++) {
			char present = board[i][lastLoc[1]].charAt(0);
			if(isPieceFoundOnPath) {
				throw new InvalidMoveException("A piece found on path");
			}
			if(present == pirceColor) {
				throw new InvalidMoveException("Similar piece found on path");
			}else if(present != '-') {
				System.out.println("Opposite item found in path");
				isPieceFoundOnPath = true;
			}
		}
	}
	
	public void moveHorizontal(String[][] board,String piece,int[] currLoc,int[] lastLoc) throws InvalidMoveException {
		int colDiff = lastLoc[1] - currLoc[1];
		if(colDiff < 0) {
			moveLeft(board, piece, currLoc, lastLoc);
		}else {
			moveRight(board, piece, currLoc, lastLoc);
		}
	}
	
	public void moveVertical(String[][] board,String piece,int[] currLoc,int[] lastLoc) throws InvalidMoveException {
		int rowDiff = lastLoc[0] - currLoc[0];
		if(rowDiff < 0) {
			moveUp(board, piece, currLoc, lastLoc);
		}else {
			moveDown(board, piece, currLoc, lastLoc);
		}
	}
	
	public void moveLeft(String[][] board,String piece,int[] currLoc,int[] lastLoc) throws InvalidMoveException {
		char pirceColor = piece.charAt(0);
		boolean isPieceFoundOnPath = false;
		for(int i=currLoc[1];i>=lastLoc[1];i--) {
			char present = board[lastLoc[0]][i].charAt(0);
			if(isPieceFoundOnPath) {
				throw new InvalidMoveException("A piece found on path");
			}
			if(present == pirceColor) {
				throw new InvalidMoveException("Similar piece found on path");
			}else if(present != '-') {
				System.out.println("Opposite item found in path");
				isPieceFoundOnPath = true;
			}
		}
	}
	
	public void moveRight(String[][] board,String piece,int[] currLoc,int[] lastLoc) throws InvalidMoveException {
		char pirceColor = piece.charAt(0);
		boolean isPieceFoundOnPath = false;
		for(int i=currLoc[1];i<=lastLoc[1];i++) {
			char present = board[lastLoc[0]][i].charAt(0);
			if(isPieceFoundOnPath) {
				throw new InvalidMoveException("A piece found on path");
			}
			if(present == pirceColor) {
				throw new InvalidMoveException("Similar piece found on path");
			}else if(present != '-') {
				System.out.println("Opposite item found in path");
				isPieceFoundOnPath = true;
			}
		}
	}
	
	protected boolean checkForOneCellMove(int a,int b) {
		int diff = a - b;
		if(diff>=-1 && diff <=1) {
			return true;
		}
		return false;
	}
	
}
