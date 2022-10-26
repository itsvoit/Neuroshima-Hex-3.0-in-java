package GameBackend.Attributes.DefenseAttributes;

import GameBackend.Tiles.Damage;
import GameBackend.Tiles.Interfaces.Tile;

import java.util.ArrayList;

public class ToughnessSelf extends DefenseAttributeAbstract {
	private int value;
	private int damageAbsorbed;

	public ToughnessSelf(String name, String description) {
		super(name, description);
	}

	public ToughnessSelf(String name, String description, Tile owner) {
		super(name, description, owner);
	}

	public ToughnessSelf(String name, String description, int value) {
		this(name, description);
		this.value = value;
	}

	public ToughnessSelf(String name, String description, Tile owner, int value) {
		this(name, description, owner);
		this.value = value;
	}

	@Override
	public void use(Board board) {

	}
}
