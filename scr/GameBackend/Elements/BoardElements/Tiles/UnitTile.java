package GameBackend.Elements.BoardElements.Tiles;

import GameBackend.Elements.BoardElements.Direction;

public abstract class UnitTile extends Tile {

	protected Direction rotation;
	protected boolean hasInitiative;
	protected int initiative;


	public boolean turn(Direction newDirection){
		if (rotation == newDirection) return false;

		rotation = newDirection;
		return true;
	}
}
