package GameBackend.Attributes.AttackAttributes;

import GameBackend.Attributes.AttributeAttackAbstract;
import GameBackend.Direction;
import GameBackend.Game.Board;
import GameBackend.Tiles.Interfaces.Tile;

public class MeleeAttack extends AttributeAttackAbstract {
	public MeleeAttack(String name, String description) {
		super(name, description);
	}

	public MeleeAttack(String name, String description, Tile owner) {
		super(name, description, owner);
	}

	public MeleeAttack(String name, String description, int[] attackValues) {
		super(name, description, attackValues);
	}

	public MeleeAttack(String name, String description, int[] attackValues, Tile owner) {
		super(name, description, attackValues, owner);
	}

	// Implemented interface method
	@Override
	public void use(Board board) {
		if (owner == null || owner.getHex() == null) return;

		Board.Hex[] adjacentHexes = board.getAdjacent(owner.getHex().getIndex());

		for (int i = 0; i < Direction.DIRECTIONS; i++) {
			if (adjacentHexes[i] != null) adjacentHexes[i].dealDamage(attackValues[i]);
		}
	}
}
