package GameBackend.Attributes.AttackAttributes;

import GameBackend.Attributes.AttributeAttackAbstract;
import GameBackend.Direction;
import GameBackend.Game.Board;
import GameBackend.Tiles.Interfaces.Tile;

public class RangeAttack extends AttributeAttackAbstract {
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

		Board.Hex[] firstInLine = board.getFirstInLine(owner.getHex().getIndex());

		for (int i = 0; i < Direction.DIRECTIONS; i++) {
			if (firstInLine[i] != null) firstInLine[i].dealDamage(attackValues[i]);
		}
	}
}
