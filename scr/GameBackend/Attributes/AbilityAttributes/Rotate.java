package GameBackend.Attributes.AbilityAttributes;

import GameBackend.Game.Board;
import GameBackend.Tiles.Interfaces.Tile;

public class Rotate extends AbilityAttributeAbstract {
	public Rotate(String name, String description) {
		super(name, description);
	}

	public Rotate(String name, String description, Tile owner) {
		super(name, description, owner);
	}

	@Override
	public void use(Board board) {

	}
}
