package GameBackend.Attributes.DefenseAttributes;

import GameBackend.Attributes.AttributeAbstract;
import GameBackend.Direction;
import GameBackend.Tiles.Damage;
import GameBackend.Tiles.Interfaces.Tile;

import java.util.ArrayList;
import java.util.TreeSet;

public abstract class DefenseAttributeAbstract extends AttributeAbstract implements Comparable<DefenseAttributeAbstract>{
	protected TreeSet<Direction> directions;
	protected int resolutionWeight; // lower value -> earlier resolution

	public DefenseAttributeAbstract(String name, String description) {
		super(name, description);
		resolutionWeight = 0;
	}

	public DefenseAttributeAbstract(String name, String description, Tile owner) {
		super(name, description, owner);
		resolutionWeight = 0;
	}

	public abstract void use(ArrayList<Damage> damage);

	public boolean addDirection(Direction direction){
		return directions.add(direction);
	}

	public boolean removeDirection(Direction direction){
		return directions.remove(direction);
	}

	public boolean setDirectionValues(TreeSet<Direction> directions){
		if (directions == null || directions == this.directions) return false;
		this.directions = directions;

		return true;
	}

	@Override
	public int compareTo(DefenseAttributeAbstract o) {
		return Integer.compare(resolutionWeight, o.resolutionWeight);
	}
}
