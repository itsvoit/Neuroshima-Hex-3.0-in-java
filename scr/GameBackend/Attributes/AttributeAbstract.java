package GameBackend.Attributes;

import GameBackend.Tiles.Interfaces.Tile;

public abstract class AttributeAbstract implements AttributeInterface {
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

}
