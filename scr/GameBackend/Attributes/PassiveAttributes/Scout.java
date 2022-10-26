package GameBackend.Attributes.PassiveAttributes;

import GameBackend.Direction;
import GameBackend.Game.Board;
import GameBackend.Tiles.Interfaces.Tile;

import java.util.TreeSet;

public class Scout extends PassiveAttributeAbstract {
	public Scout(String name, String description) {
		super(name, description);
	}

	public Scout(String name, String description, boolean self, TreeSet<Direction> directions) {
		super(name, description, self, directions);
	}

	public Scout(String name, String description, Tile owner) {
		super(name, description, owner);
	}

	public Scout(String name, String description, Tile owner, boolean self, TreeSet<Direction> directions) {
		super(name, description, owner, self, directions);
	}

	@Override
	public void use(Board board) {

	}
}
