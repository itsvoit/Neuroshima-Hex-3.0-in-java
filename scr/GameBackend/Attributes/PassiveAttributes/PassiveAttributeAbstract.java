package GameBackend.Attributes.PassiveAttributes;

import GameBackend.Attributes.AttributeAbstract;
import GameBackend.Direction;
import GameBackend.Tiles.Interfaces.Tile;

import java.util.TreeSet;

public abstract class PassiveAttributeAbstract extends AttributeAbstract {
	protected boolean self;
	protected TreeSet<Direction> directions;

	public PassiveAttributeAbstract(String name, String description) {
		super(name, description);
		this.self = false;
		this.directions = new TreeSet<>();
	}

	public PassiveAttributeAbstract(String name, String description, boolean self, TreeSet<Direction> directions) {
		this(name, description);
		this.self = self;
		this.directions = directions;
	}

	public PassiveAttributeAbstract(String name, String description, Tile owner) {
		super(name, description, owner);
		this.self = false;
		this.directions = new TreeSet<>();
	}

	public PassiveAttributeAbstract(String name, String description, Tile owner, boolean self, TreeSet<Direction> directions) {
		this(name, description, owner);
		this.self = self;
		this.directions = directions;
	}

	public boolean addDirection(Direction direction){
		return directions.add(direction);
	}

	public boolean removeDirection(Direction direction){
		return directions.remove(direction);
	}

	public boolean setDirections(TreeSet<Direction> directions){
		if (this.directions == directions) return false;

		this.directions = directions;
		return true;
	}
}
