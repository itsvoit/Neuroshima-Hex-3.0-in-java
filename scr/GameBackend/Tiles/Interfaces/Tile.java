package GameBackend.Tiles.Interfaces;

import GameBackend.Attributes.AttributeInterface;
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

	public Board.Hex getHex() {
		return hex;
	}
}
