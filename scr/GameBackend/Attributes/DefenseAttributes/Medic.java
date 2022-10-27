package GameBackend.Attributes.DefenseAttributes;

import GameBackend.Direction;
import GameBackend.Game.Board;
import GameBackend.Game.Hex;
import GameBackend.Tiles.Damage;
import GameBackend.Tiles.Interfaces.Tile;

import java.util.ArrayList;

public class Medic extends DefenseAttributeAbstract {
	public Medic(String name, String description) {
		super(name, description);
	}

	public Medic(String name, String description, Tile owner) {
		super(name, description, owner);
	}

	@Override
	public void use(Board board) {
		Hex[] adjacentHexes = board.getAdjacent(owner.getHex().getIndex());
		ArrayList<Damage> damageTakenByAdjacent = new ArrayList<>();

		for (Direction direction : directions){
			ArrayList<Damage> unitsDamage = adjacentHexes[direction.getValue()].getDamageTaken();
			if (unitsDamage == null) continue;
			damageTakenByAdjacent.addAll(unitsDamage);
		}

		use(damageTakenByAdjacent);
	}

	@Override
	public void use(ArrayList<Damage> damage) {
		if (damage.size() == 0) return;
		if (damage.size() == 1){
			damage.get(0).range = 0;
			damage.get(0).melee = 0;
			return;
		}
		// todo medic corner cases:
		// two medics heal one tile (player chooses which one dies)
		// chain: tile -> medic -> medic (this guy takes the damage)
		// two medics connected to one another (player chooses which one dies)
		//
		// todo: notify Player to choose a source of Damage to be taken by the Medic
		for (Damage dmg : damage){

		}
	}
}
