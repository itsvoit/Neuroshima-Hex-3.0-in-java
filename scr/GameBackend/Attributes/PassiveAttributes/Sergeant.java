package GameBackend.Attributes.PassiveAttributes;

import GameBackend.Direction;
import GameBackend.Game.Board;
import GameBackend.Tiles.Interfaces.Tile;

import java.util.TreeSet;

public class Sergeant extends PassiveAttributeAbstract {
	public Sergeant(String name, String description) {
		super(name, description);
	}

	public Sergeant(String name, String description, boolean self, TreeSet<Direction> directions) {
		super(name, description, self, directions);
	}

	public Sergeant(String name, String description, Tile owner) {
		super(name, description, owner);
	}

	public Sergeant(String name, String description, Tile owner, boolean self, TreeSet<Direction> directions) {
		super(name, description, owner, self, directions);
	}

	@Override
	public void use(Board board) {

	}
}
