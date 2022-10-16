package GameBackend.Tiles.Interfaces;

import GameBackend.Attributes.Interfaces.Attribute;

import java.util.ArrayList;

public abstract class Tile {
	public enum Type {
		WARRIOR,
		MODULE,
		INSTANT,
		GROUND
	}
	protected Type type;
	protected ArrayList<Attribute> attributes;
	protected String name;

	public Tile(){
		attributes = new ArrayList<>();
	}

	public Type getType() {
		return type;
	}

	public void addAttribute(Attribute attr){
		attributes.add(attr);
	}
}
