package GameBackend.Attributes.BattleAttributes;

import GameBackend.Direction;
import GameBackend.Game.Board;
import GameBackend.Game.Hex;
import GameBackend.Tiles.Damage;
import GameBackend.Tiles.Interfaces.Tile;
import GameBackend.Tiles.Interfaces.UnitTile;

public class MeleeAttack extends BattleAttributeAbstract {
	public MeleeAttack(String name, String description, Tile owner) {
		super(name, description, owner);
	}

	public MeleeAttack(String name, String description, int[] attackValues, Tile owner) {
		super(name, description, owner, attackValues);
	}

	// Implemented interface method
	@Override
	public void use(Board board) {
		if (owner == null || owner.getHex() == null) return;

		Hex[] adjacentHexes = board.getAdjacent(owner.getHex().getIndex());

		for (int i = 0; i < Direction.DIRECTIONS; i++) {
			if (adjacentHexes[i] != null)
				adjacentHexes[i].dealDamage(
						new Damage(
								attackValues[i] + ((UnitTile)owner).getBonusMeleeDamage(),
								0,
								Direction.getByValue(i).getOpposite()
						)
				);
		}
	}

	@Override
	public String toString() {
		return "Melee attack";
	}
}
