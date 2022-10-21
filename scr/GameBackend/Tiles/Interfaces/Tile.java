package GameBackend.Tiles.Interfaces;

import GameBackend.Attributes.AttributeInterface;

import java.util.ArrayList;

public abstract class Tile {
	public enum Type {
		WARRIOR,
		MODULE,
		INSTANT,
		GROUND
	}
	protected Type type;
	protected ArrayList<AttributeInterface> attributes;
	protected String name;

	public Tile(){
		attributes = new ArrayList<>();
	}

	public Type getType() {
		return type;
	}

	public void addAttribute(AttributeInterface attr){
		attributes.add(attr);
	}
}
