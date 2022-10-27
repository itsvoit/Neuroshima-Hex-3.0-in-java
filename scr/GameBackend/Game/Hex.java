package GameBackend.Game;

import GameBackend.Direction;
import GameBackend.Tiles.Damage;
import GameBackend.Tiles.GroundTile;
import GameBackend.Tiles.Interfaces.Tile;
import GameBackend.Tiles.Interfaces.UnitTile;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * Used for tiles to place tiles on
 * Board is created using these
 * Provide adjacency logic
 */
public class Hex {
	final int index;
	UnitTile unitTile;
	GroundTile ground;
	Hex[] adjacentHexes;

	public Hex(int index) {
		if (index < 0 || index > Board.MAX_HEX_INDEX) throw new IllegalArgumentException("Hex index out of bounds");

		this.index = index;
		this.unitTile = null;
		this.ground = null;
		this.adjacentHexes = new Hex[Direction.DIRECTIONS];
	}

	public Hex(int index, Tile tile) {
		this(index);

		placeTile(tile);
	}

//----------------------------------------
//              Methods

	/**
	 * Try to rotate the tile
	 *
	 * @param newDirection direction to be facing after the turn
	 * @return false if tile is null or newDirection == currentDirection;
	 * true if rotate was successful
	 */
	public Boolean rotateTile(Direction newDirection) {
		if (unitTile == null) return false;
		return unitTile.rotate(newDirection);
	}

	/**
	 * Checks whether the hex is adjacent to this
	 *
	 * @param hex hex to check for adjacency
	 * @return true if adjacent; false if not adjacent
	 */
	public Boolean isAdjacent(Hex hex) {
		for (int i = 0; i < Direction.DIRECTIONS; i++)
			if (adjacentHexes[i] == hex) return true;

		return false;
	}

	public UnitTile getUnitTile() {
		return unitTile;
	}

	public GroundTile getGround() {
		return ground;
	}

	public Boolean placeTile(Tile tile) {
		if (tile == null) return false;

		switch (tile.getType()) {
			case INSTANT -> {
				return false;
			}
			case GROUND -> this.ground = (GroundTile) tile;
			case MODULE, WARRIOR -> this.unitTile = (UnitTile) tile;
		}
		tile.setHex(this);

		return true;
	}

	public void removeTile() {
		this.unitTile = null;
	}

	public void removeGround() {
		this.ground = null;
	}

	public int getIndex() {
		return index;
	}

	public void dealDamage(Damage damage) {
		if (unitTile == null) return;
		unitTile.dealDamage(damage);
	}

	public TreeSet<Initiative> getBaseInitiatives() {
		if (unitTile == null) return null;
		return unitTile.getBaseInitiatives();
	}

	public PriorityQueue<Initiative> getBattleInitiatives() {
		if (unitTile == null) return null;
		return unitTile.getBattleInitiatives();
	}

	public ArrayList<Damage> getDamageTaken() {
		if (unitTile == null) return null;
		return unitTile.getDamageTaken();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Hex{ ").append(index + 1).append(", ");
		builder.append("tile: ").append(unitTile);
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
