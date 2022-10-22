package GameBackend.Tiles.Interfaces;

import GameBackend.Direction;

public abstract class UnitTile extends Tile implements Placeable {

	protected Direction rotation;
	protected boolean hasInitiative;
	protected int initiative;
	protected int damageTaken;

	public boolean turn(Direction newDirection){
		if (rotation == newDirection) return false;

		rotation = newDirection;
		return true;
	}

	public void dealDamage(int attackValue){
		damageTaken += attackValue;
	}
}
