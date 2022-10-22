package GameBackend.Tiles.Interfaces;

import GameBackend.Attributes.AttributeAbstract;
import GameBackend.Game.Board;

import java.util.ArrayList;

public abstract class Tile {
	public enum Type {
		WARRIOR,
		MODULE,
		INSTANT,
		GROUND
	}
	protected Type type;
	protected Board.Hex hex;
	protected ArrayList<AttributeAbstract> attributes;
	protected String name;

	public Tile(String name){
		this.name = name;
		this.attributes = new ArrayList<>();
	}

	public Type getType() {
		return type;
	}

	public void addAttribute(AttributeAbstract attr){
		attributes.add(attr);
		attr.setOwner(this);
	}

	public void setHex(Board.Hex hex) {
		this.hex = hex;
	}

	public Board.Hex getHex() {
		return hex;
	}
}
