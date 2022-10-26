package GameBackend.Game;

public enum Initiative{
	NONE(-2),
	PASSIVE(-1),
	ZERO(0),
	ONE(1),
	TWO(2),
	THREE(3),
	FOUR(4),
	FIVE(5),
	SIX(6),
	SEVEN(7),
	EIGHT(8),
	NINE(9),
	TEN(10);

	final int value;

	Initiative(int value){
		this.value = value;
	}

	Initiative higher(){
		if (value == 10) return Initiative.TEN;
		return values()[value+3]; // value + 1 + 2
	}

	Initiative lower(){
		if (value < 0) return Initiative.NONE;
		if (value == 0) return Initiative.ZERO;
		return values()[value+1]; // value - 1 + 2
	}
}
