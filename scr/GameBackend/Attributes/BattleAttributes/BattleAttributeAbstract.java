package GameBackend.Attributes.BattleAttributes;

import GameBackend.Attributes.AttributeAbstract;
import GameBackend.Direction;
import GameBackend.Tiles.Interfaces.Tile;

public abstract class BattleAttributeAbstract extends AttributeAbstract {
	// Fields
	protected int[] attackValues;

	public BattleAttributeAbstract(String name, String description){
		super(name, description);
	}

	public BattleAttributeAbstract(String name, String description, int[] attackValues){
		this(name, description);
		setAttackValues(attackValues);
	}

	public BattleAttributeAbstract(String name, String description, Tile owner) {
		super(name, description, owner);
		attackValues = new int[Direction.DIRECTIONS];
	}

	public BattleAttributeAbstract(String name, String description, Tile owner, int[] attackValues){
		this(name, description, owner);
		setAttackValues(attackValues);
	}

	// Methods
	public boolean addAttack(Direction direction, int attackValue){
		if (attackValues[direction.getValue()] == 0) return false;
		attackValues[direction.getValue()] = attackValue;
		return true;
	}

	public boolean removeAttack(Direction direction){
		if (attackValues[direction.getValue()] == 0) return false;
		attackValues[direction.getValue()] = 0;
		return true;
	}

	/**
	 *
	 * @param attackValues Array of ints where index is direction and content is the amount of damage to deal to that direction. Has to have length equal to DIRECTIONS enum constant
	 * @return true if length is equal to DIRECTION enum constant; false otherwise
	 */
	public boolean setAttackValues(int[] attackValues){
		if (attackValues.length != Direction.DIRECTIONS) return false;
		this.attackValues = attackValues;
		return true;
	}

}
