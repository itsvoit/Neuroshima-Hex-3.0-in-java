package GameBackend.Attributes.PassiveAttributes;

import GameBackend.Direction;
import GameBackend.Tiles.Interfaces.Tile;

import java.util.TreeSet;

public class ToughnessOther extends PassiveAttributeAbstract{
	public ToughnessOther(String name, String description) {
		super(name, description);
	}

	public ToughnessOther(String name, String description, boolean self, TreeSet<Direction> directions) {
		super(name, description, self, directions);
	}

	public ToughnessOther(String name, String description, Tile owner) {
		super(name, description, owner);
	}

	public ToughnessOther(String name, String description, Tile owner, boolean self, TreeSet<Direction> directions) {
		super(name, description, owner, self, directions);
	}
}
