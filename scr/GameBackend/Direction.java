package GameBackend;

public enum Direction {
	NORTH_EAST(0),
	EAST(1),
	SOUTH_EAST(2),
	SOUTH_WEST(3),
	WEST(4),
	NORTH_WEST(5);

	private int value;
	public static final int DIRECTIONS = 6;

	Direction(int value) {
		this.value = value;
	}

	public Direction turnClockwise(){
		return values()[(value+1)%DIRECTIONS];
	}

	public Direction turnCounterClockwise(){
		return values()[(value+DIRECTIONS-1)%DIRECTIONS];
	}

	public int getValue() {
		return value;
	}

	public static Direction getByValue(int value){
		if (value < 0) value = Math.abs(value);
		return values()[(value)%DIRECTIONS];
	}
}
