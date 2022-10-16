package GameBackend.Tiles.Interfaces;

import GameBackend.Direction;

public abstract class UnitTile extends Tile implements Placeable {

	protected Direction rotation;
	protected boolean hasInitiative;
	protected int initiative;


	public boolean turn(Direction newDirection){
		if (rotation == newDirection) return false;

		rotation = newDirection;
		return true;
	}
}
