package chess;

public enum PlayerType {
	B(Direction.Top),
	W(Direction.Bottom);
	
	private PlayerType(Direction directon) {
		this.direction = directon;
	}
	
	public Direction getDirection() {
		return this.direction;
	}
	
	Direction direction;
}
