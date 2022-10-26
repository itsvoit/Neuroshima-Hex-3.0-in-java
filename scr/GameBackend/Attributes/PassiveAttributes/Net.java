package GameBackend.Attributes.PassiveAttributes;

import GameBackend.Attributes.AbilityAttributes.AbilityAttributeAbstract;
import GameBackend.Game.Board;
import GameBackend.Tiles.Interfaces.Tile;

public class Net extends AbilityAttributeAbstract {
	public Net(String name, String description) {
		super(name, description);
	}

	public Net(String name, String description, Tile owner) {
		super(name, description, owner);
	}

	@Override
	public void use(Board board) {

	}
}
