package GameBackend.Tiles;

import GameBackend.Direction;

public class Damage {
	public int melee;
	public int range;
	public Direction sourceDirection;

	public Damage(int melee, int range, Direction sourceDirection){
		this.melee = melee;
		this.range = range;
		this.sourceDirection = sourceDirection;
	}

	public int damage(){
		return melee + range;
	}

}
