package GameBackend.Game;

public enum Initiative{
	/*  0 */NONE(-2),
	/*  1 */PASSIVE(-1),
	/*  2 */ZERO(0),
	/*  3 */ONE(1),
	/*  4 */TWO(2),
	/*  5 */THREE(3),
	/*  6 */FOUR(4),
	/*  7 */FIVE(5),
	/*  8 */SIX(6),
	/*  9 */SEVEN(7),
	/* 10 */EIGHT(8),
	/* 11 */NINE(9),
	/* 12 */TEN(10);

	final int value;
	final int index;

	Initiative(int value){
		this.value = value;
		this.index = value+2;
	}

	Initiative higher(){
		if (value == -2) return NONE;
		if (value == -1) return PASSIVE;
		if (value == 10) return TEN;
		return values()[index+1];
	}

	Initiative lower(){
		if (value < 0) return NONE;
		if (value == 0) return ZERO;
		return values()[index-1];
	}

	Initiative decrease(){
		if (value == -2) return NONE;
		return values()[value-1];
	}

	Initiative increase(){
		if (value == 10) return TEN;
		return values()[index+1];
	}
}
