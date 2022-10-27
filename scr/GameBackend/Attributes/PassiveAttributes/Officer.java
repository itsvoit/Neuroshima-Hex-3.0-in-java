package GameBackend.Attributes.PassiveAttributes;

import GameBackend.Direction;
import GameBackend.Game.Board;
import GameBackend.Game.Hex;
import GameBackend.Tiles.Interfaces.Tile;

import java.util.TreeSet;

// Add damage
public class Officer extends PassiveAttributeAbstract {
	private int meleeDamage;
	private int rangeDamage;

	public Officer(String name, String description) {
		super(name, description);
	}

	public Officer(String name, String description, TreeSet<Direction> directions, int meleeDamage, int rangeDamage) {
		super(name, description, false, directions);
		setMeleeDamage(meleeDamage);
		setRangeDamage(rangeDamage);
	}

	public Officer(String name, String description, Tile owner) {
		super(name, description, owner);
	}

	public Officer(String name, String description, Tile owner, TreeSet<Direction> directions, int meleeDamage, int rangeDamage) {
		super(name, description, owner, false, directions);
		setMeleeDamage(meleeDamage);
		setRangeDamage(rangeDamage);
	}

	public void setMeleeDamage(int meleeDamage) {
		if (meleeDamage < 0) return;
		this.meleeDamage = meleeDamage;
	}

	public void setRangeDamage(int rangeDamage) {
		if (rangeDamage < 0) return;
		this.rangeDamage = rangeDamage;
	}

	@Override
	public void use(Board board) {
		if (owner == null || owner.getHex() == null) return;

		Hex[] adjacentHexes = board.getAdjacent(owner.getHex().getIndex());

		for (int i = 0; i < Direction.DIRECTIONS; i++) {
			if (adjacentHexes[i] != null && directions.contains(Direction.getByValue(i))) {
				adjacentHexes[i].getUnitTile().setBonusMeleeDamage(meleeDamage);
				adjacentHexes[i].getUnitTile().setBonusRangeDamage(rangeDamage);
			}
		}
	}
}
