package GameBackend.Attributes;

import GameBackend.Game.Board;
import GameBackend.Tiles.Interfaces.Tile;

public abstract class AttributeAbstract{
	protected String name;
	protected String description;
	protected Tile owner;

	public AttributeAbstract(String name, String description){
		this.name = name;
		this.description = description;
	}

	public AttributeAbstract(String name, String description, Tile owner){
		this(name, description);
		this.owner = owner;
	}

	public void setOwner(Tile owner){
		this.owner = owner;
	}

	public void use(Board board){

	}

}
