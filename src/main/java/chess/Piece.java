package chess;

import chess.moves.DefaultMove;
import chess.moves.PawnMove;
import chess.moves.QueenMove;

public enum Piece{
	R("Rook", new DefaultMove()),
	H("Horse", new PawnMove()),
	B("Bishop", new DefaultMove()),
	Q("Queen", new QueenMove()),
	K("King", new DefaultMove()),
	P("Pawn", new PawnMove());
	
	private Piece(String name,BoardMove m){
		this.name = name;
		this.boardMove = m;
	}
	
	private BoardMove  boardMove;
	private String name;
	
	public BoardMove getBoardMove() {
		return boardMove;
	}
	public void setBoardMove(BoardMove boardMove) {
		this.boardMove = boardMove;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
