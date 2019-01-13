package chess;

public class Board {
	String[][] board;
	
	public Board() {
		board = new String[][]{
			{"WR","WH","WB","WQ","WK","WB","WH","WR"},
			{"WP","WP","WP","WP","WP","WP","WP","WP"},
			{"--","--","--","--","--","--","--","--"},
			{"--","--","--","--","--","--","--","--"},
			{"--","--","--","--","--","--","--","--"},
			{"--","--","--","--","--","--","--","--"},
			{"BP","BP","BP","BP","BP","BP","BP","BP"},
			{"BR","BH","BB","BQ","BK","BB","BH","BR"},
		};
	}
	
	void printBoard() {
		System.out.print("++++++++++++++++++++++++++++++++\n\n\n");
		
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println("");
		}
	}
	
	void move(String piece,String currLocation,String lastLocation) throws InvalidMoveException {
		PlayerType p = PlayerType.valueOf(piece.charAt(0)+"");
		Direction d = p.getDirection();
		Piece pieceType = Piece.valueOf(piece.charAt(1)+"");
		
		try {
			pieceType.getBoardMove().move(this.board, d, piece, currLocation, lastLocation);
			
			this.printBoard();
		}catch(InvalidMoveException e) {
			System.out.println("\n------ Invlaid move -------- \n");
		}
	}
}
