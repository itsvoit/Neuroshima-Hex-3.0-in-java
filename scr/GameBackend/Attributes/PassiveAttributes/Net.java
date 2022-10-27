package GameBackend.Attributes.PassiveAttributes;

import GameBackend.Direction;
import GameBackend.Game.Board;
import GameBackend.Game.Hex;
import GameBackend.Tiles.Interfaces.Tile;

import java.util.TreeSet;

public class Net extends PassiveAttributeAbstract {

	public Net(String name, String description) {
		super(name, description);
	}

	public Net(String name, String description, TreeSet<Direction> directions) {
		super(name, description, false, directions);
	}

	public Net(String name, String description, Tile owner) {
		super(name, description, owner);
	}

	public Net(String name, String description, Tile owner, TreeSet<Direction> directions) {
		super(name, description, owner, false, directions);
	}

	@Override
	public void use(Board board) {
		if (owner == null || owner.getHex() == null) return;

		Hex[] adjacentHexes = board.getAdjacent(owner.getHex().getIndex());

		for (int i = 0; i < Direction.DIRECTIONS; i++) {
			if (adjacentHexes[i] != null && directions.contains(Direction.getByValue(i)))
				adjacentHexes[i].getUnitTile().netted = true;
		}
	}
}
