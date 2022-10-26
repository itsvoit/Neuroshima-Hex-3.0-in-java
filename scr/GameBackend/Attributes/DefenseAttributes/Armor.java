package GameBackend.Attributes.DefenseAttributes;

import GameBackend.Game.Board;
import GameBackend.Tiles.Interfaces.Tile;

public class Armor extends DefenseAttributeAbstract {
	public Armor(String name, String description) {
		super(name, description);
	}

	public Armor(String name, String description, Tile owner) {
		super(name, description, owner);
	}

	@Override
	public void use(Board board) {

	}
}
