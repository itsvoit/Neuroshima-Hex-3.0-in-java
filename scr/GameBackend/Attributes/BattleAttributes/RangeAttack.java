package GameBackend.Attributes.BattleAttributes;

import GameBackend.Direction;
import GameBackend.Game.Board;
import GameBackend.Game.Hex;
import GameBackend.Tiles.Damage;
import GameBackend.Tiles.Interfaces.Tile;
import GameBackend.Tiles.Interfaces.UnitTile;

public class RangeAttack extends BattleAttributeAbstract {
	public RangeAttack(String name, String description, Tile owner) {
		super(name, description, owner);
	}

	public RangeAttack(String name, String description, int[] attackValues, Tile owner) {
		super(name, description, owner, attackValues);
	}

	// Implemented interface method
	@Override
	public void use(Board board) {
		if (owner == null || owner.getHex() == null) return;

		Hex[] firstInLine = board.getFirstInLine(owner.getHex().getIndex());

		for (int i = 0; i < Direction.DIRECTIONS; i++) {
			if (firstInLine[i] != null)
				firstInLine[i].dealDamage(
						new Damage(
								0,
								attackValues[i] + ((UnitTile)owner).getBonusRangeDamage(),
								Direction.getByValue(i).getOpposite()
						)
				);
		}
	}
}
