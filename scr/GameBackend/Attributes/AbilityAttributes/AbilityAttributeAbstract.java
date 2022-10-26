package GameBackend.Attributes.AbilityAttributes;

import GameBackend.Attributes.AttributeAbstract;
import GameBackend.Game.Board;
import GameBackend.Tiles.Interfaces.Tile;

public abstract class AbilityAttributeAbstract extends AttributeAbstract {
	public AbilityAttributeAbstract(String name, String description) {
		super(name, description);
	}

	public AbilityAttributeAbstract(String name, String description, Tile owner) {
		super(name, description, owner);
	}
}
