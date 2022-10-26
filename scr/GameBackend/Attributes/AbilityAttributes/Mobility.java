package GameBackend.Attributes.AbilityAttributes;

import GameBackend.Game.Board;
import GameBackend.Tiles.Interfaces.Tile;

public class Mobility extends AbilityAttributeAbstract {
	public Mobility(String name, String description) {
		super(name, description);
	}

	public Mobility(String name, String description, Tile owner) {
		super(name, description, owner);
	}

	@Override
	public void use(Board board) {

	}
}
