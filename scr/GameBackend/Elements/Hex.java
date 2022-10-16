package GameBackend.Elements;

import GameBackend.Elements.BoardElements.Direction;
import GameBackend.Elements.BoardElements.Tiles.GroundTile;
import GameBackend.Elements.BoardElements.Tiles.Tile;
import GameBackend.Elements.BoardElements.Tiles.UnitTile;

/**
 * Used for tiles to place tokens on
 * Board is created using these
 * Provide adjacency logic
 *
 */

public class Hex {
	public static final int MAX_HEX_INDEX = 19;

	private final int index;
	private UnitTile tile;
	private GroundTile ground;

	public Hex(int index){
		if (index < 0 || index > MAX_HEX_INDEX) throw new IllegalArgumentException("Hex index out of bounds");

		this.index = index;
		this.tile = null;
		this.ground = null;
	}

	public Hex(int index, Tile tile){
		this(index);

		placeToken(tile);
	}

//----------------------------------------
//              Methods
	/**
	 * Try to move the token
	 * @param targetIndex hex to be standing on after the move
	 * @return false if target is occupied;
	 * true if move was successful
	 */
	public Boolean moveToken(int targetIndex){
		//todo Boolean moveToken(int newIndex)
		return true;
	}

	/**
	 * Try to rotate the token
	 * @param newDirection direction to be facing after the turn
	 * @return false if token is null or newDirection == currentDirection;
	 * true if rotate was successful
	 */
	public Boolean rotateToken(Direction newDirection){
		if (tile == null) return false;
		return tile.turn(newDirection);
	}

	/**
	 * Checks whether the hex is adjacent to this
	 * @param hex hex to check for adjacency
	 * @return true if adjacent; false if not adjacent
	 */
	public Boolean isAdjacent(Hex hex){
		//todo Boolean isAdjacent(Hex hex1, Hex hex2)
		return false;
	}

//----------------------------------------
//        Getters and setters

	public Tile getToken() {
		return tile;
	}

	public GroundTile getGround() {
		return ground;
	}

	public Boolean placeToken(Tile tile) {
		if (tile == null) return false;

		switch (tile.getType()){
			case INSTANT -> {
				return false;
			}
			case GROUND -> this.ground = (GroundTile) tile;
			case MODULE, WARRIOR -> this.tile = (UnitTile) tile;
		}

		return true;
	}

	public void removeToken(){
		this.ground = null;
		this.tile = null;
	}

	public int getIndex() {
		return index;
	}

}
