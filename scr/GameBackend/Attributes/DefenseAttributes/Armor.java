package GameBackend.Attributes.DefenseAttributes;

import GameBackend.Tiles.Damage;
import GameBackend.Tiles.Interfaces.Tile;

import java.util.ArrayList;

public class Armor extends DefenseAttributeAbstract {
	public Armor(String name, String description) {
		super(name, description);
		resolutionWeight = -10;
	}

	public Armor(String name, String description, Tile owner) {
		super(name, description, owner);
		resolutionWeight = -10;
	}

	@Override
	public void use(ArrayList<Damage> damage) {
		for (Damage dmg : damage){
			if (directions.contains(dmg.sourceDirection)) dmg.range--;
		}
	}
}
