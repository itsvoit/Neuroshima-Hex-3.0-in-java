package GameBackend.Game;

import GameBackend.Direction;
import GameBackend.Tiles.GroundTile;
import GameBackend.Tiles.Interfaces.Tile;
import GameBackend.Tiles.Interfaces.UnitTile;

public class Board {
	public static final int MAX_HEX_INDEX = 19;
	private static final int[][] adjacencyIndexes = {
	/* 1  */ 	{-1, 2, 5, 4, -1, -1},
	/* 2  */ 	{-1, 3, 6, 5, 1, -1},
	/* 3  */ 	{-1, -1, 7, 6, 2, -1},
	/* 4  */ 	{1, 5, 9, 8, -1, -1},
	/* 5  */ 	{2, 6, 10, 9, 4, 1},
	/* 6  */ 	{3, 7, 11, 10, 5, 2},
	/* 7  */ 	{-1, -1, 12, 11, 6, 3},
	/* 8  */ 	{4, 9, 13, -1, -1, -1},
	/* 9  */ 	{5, 10, 14, 13, 8, 4},
	/* 10 */ 	{6, 11, 15, 14, 9, 5},
	/* 11 */ 	{7, 12, 16, 15, 10, 6},
	/* 12 */ 	{-1, -1, -1, 16, 11, 7},
	/* 13 */ 	{9, 14, 17, -1, -1, 8},
	/* 14 */ 	{10, 15, 18, 17, 13, 9},
	/* 15 */ 	{11, 16, 19, 18, 14, 10},
	/* 16 */ 	{12, -1, -1, 19, 15, 11},
	/* 17 */ 	{14, 18, -1, -1, -1, 13},
	/* 18 */ 	{15, 19, -1, -1, 17, 14},
	/* 19 */ 	{16, -1, -1, -1, 18, 15},
	};

	/**
	 * Used for tiles to place tiles on
	 * Board is created using these
	 * Provide adjacency logic
	 *
	 */
	public static class Hex {

		final int index;
		UnitTile tile;
		GroundTile ground;
		Hex[] adjacentHexes;

		public Hex(int index){
			if (index < 0 || index > MAX_HEX_INDEX) throw new IllegalArgumentException("Hex index out of bounds");

			this.index = index;
			this.tile = null;
			this.ground = null;
			this.adjacentHexes = new Hex[Direction.DIRECTIONS];
		}

		public Hex(int index, Tile tile){
			this(index);

			placeTile(tile);
		}

//----------------------------------------
//              Methods

		/**
		 * Try to rotate the tile
		 * @param newDirection direction to be facing after the turn
		 * @return false if tile is null or newDirection == currentDirection;
		 * true if rotate was successful
		 */
		public Boolean rotateTile(Direction newDirection){
			if (tile == null) return false;
			return tile.rotate(newDirection);
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

		public Tile getTile() {
			return tile;
		}

		public GroundTile getGround() {
			return ground;
		}

		public Boolean placeTile(Tile tile) {
			if (tile == null) return false;

			switch (tile.getType()){
				case INSTANT -> {
					return false;
				}
				case GROUND -> this.ground = (GroundTile) tile;
				case MODULE, WARRIOR -> this.tile = (UnitTile) tile;
			}
			tile.setHex(this);

			return true;
		}

		public void removeTile(){
			this.ground = null;
			this.tile = null;
		}

		public int getIndex() {
			return index;
		}

		public void dealDamage(int attackValue){
			if (tile == null) return;
			tile.dealDamage(attackValue);
			System.out.println("dealt " + attackValue + " damage to " + tile);
		}



		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Hex{ ").append(index+1).append(", ");
			builder.append("tile: ").append(tile);
//			builder.append(", adjacentHexes: ");
//			for (int i = 0; i < Direction.DIRECTIONS; i++) {
//				if (adjacentHexes[i] == null) builder.append("null");
////				if (adjacentHexes[i] == null) continue;
//				else builder.append(adjacentHexes[i].index+1);
//				builder.append(", ");
//			}
//			builder.delete(builder.length()-2, builder.length());
			builder.append("}");
			return builder.toString();
		}
	}

	private final Hex[] hexes;

	public Board(){
		hexes = new Hex[MAX_HEX_INDEX];
		for (int i = 0; i < MAX_HEX_INDEX; i++) {
			hexes[i] = new Hex(i);
		}
		for (int i = 0; i < MAX_HEX_INDEX; i++) {
			for (int j = 0; j < Direction.DIRECTIONS; j++) {
				hexes[i].adjacentHexes[j] = (adjacencyIndexes[i][j] == -1) ? null : hexes[adjacencyIndexes[i][j]-1];
			}
//			System.out.println(hexes[i]);
		}
	}

	public Hex getHex(int index){
		if (index < 0 || index > MAX_HEX_INDEX) throw new IllegalArgumentException("Hex index out of bounds");

		return hexes[index];
	}

	public boolean isAdjacent(int sourceIndex, int targetIndex){
		if (sourceIndex < 0 || sourceIndex > MAX_HEX_INDEX) return false;
		if (targetIndex < 0 || targetIndex > MAX_HEX_INDEX) return false;

		Hex[] sourceHexes = hexes[sourceIndex].adjacentHexes;
		for (int i = 0; i < Direction.DIRECTIONS; i++) {
			if (sourceHexes[i] != null && sourceHexes[i].index == targetIndex) return true;
		}
		return false;
	}

	/**
	 *
	 * @return All tiles from adjacent hexes, where index is the direction and null means there is no tile; null if index is out of bounds
	 */
	public Hex[] getAdjacent(int index){
		if (index < 0 || index > MAX_HEX_INDEX) return null;
		return hexes[index].adjacentHexes;
	}

	private Hex getAdjacent(int index, Direction direction){
		if (index < 0 || index > MAX_HEX_INDEX) return null;
		Hex adjacentHex = getHex(index).adjacentHexes[direction.getValue()];

		if (adjacentHex == null) return null;
		else if (adjacentHex.tile == null) return getAdjacent(adjacentHex.index, direction);
		else return adjacentHex;
	}

	public Hex[] getFirstInLine(int sourceIndex){
		if (sourceIndex < 0 || sourceIndex > MAX_HEX_INDEX) return null;

		Hex[] output = new Hex[Direction.DIRECTIONS];
		Hex source = getHex(sourceIndex);

		// Find first in line for each direction
		// if none then return null
		for (Direction direction : Direction.values()) {
			output[direction.getValue()] = getAdjacent(sourceIndex, direction);
		}

		return output;
	}

	/**
	 * Try to move the tile
	 * @param targetIndex hex to be standing on after the move
	 * @return false if target is occupied;
	 * true if move was successful
	 */
	public Boolean moveTile(int targetIndex){
		//todo Boolean moveToken(int newIndex)
		return true;
	}

	public Boolean rotateTile(int index, Direction newDirection){
		if (index < 0 || index >= MAX_HEX_INDEX) return false;
		return hexes[index].rotateTile(newDirection);
	}

	public Tile getTile(int index) {
		if (index < 0 || index >= MAX_HEX_INDEX) return null;
		return hexes[index].getTile();
	}

	public GroundTile getGround(int index) {
		if (index < 0 || index >= MAX_HEX_INDEX) return null;
		return hexes[index].getGround();
	}

	public Boolean placeTile(int index, Tile tile) {
		if (index < 0 || index >= MAX_HEX_INDEX) return false;
		return hexes[index].placeTile(tile);
	}

	public void removeTile(int index){
		if (index < 0 || index >= MAX_HEX_INDEX) return;
		hexes[index].removeTile();
	}

	public void battle(){
		System.out.println("Battle...");
		for (Hex hex : hexes){
			if (hex.tile == null) continue;
			System.out.println("Using attributes for " + hex);
			hex.tile.useAttributes(this);
		}
	}

	public void resolve(){
		for (Hex hex : hexes){
			if (hex.tile != null && hex.tile.isDead()) removeTile(hex.index);
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Board:\n");

		for (int i = 0; i < MAX_HEX_INDEX; i++) {
			if (hexes[i].tile == null) continue;
			builder.append(hexes[i]);
			builder.append(",\n");
		}
		builder.delete(builder.length()-2, builder.length());

		return builder.toString();
	}
}
