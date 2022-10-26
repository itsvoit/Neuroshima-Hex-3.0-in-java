package GameBackend.Attributes.DefenseAttributes;

import GameBackend.Attributes.AttributeAbstract;
import GameBackend.Tiles.Damage;
import GameBackend.Tiles.Interfaces.Tile;

import java.util.ArrayList;

public abstract class DefenseAttributeAbstract extends AttributeAbstract {
	public DefenseAttributeAbstract(String name, String description) {
		super(name, description);
	}

	public DefenseAttributeAbstract(String name, String description, Tile owner) {
		super(name, description, owner);
	}

	public void use(ArrayList<Damage> damage){

	}
}
