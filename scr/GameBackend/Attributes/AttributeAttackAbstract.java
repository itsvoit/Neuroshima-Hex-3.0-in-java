package GameBackend.Attributes;

import GameBackend.Direction;
import GameBackend.Tiles.Interfaces.Tile;

public abstract class AttributeAttackAbstract extends AttributeAbstract {
	// Fields
	protected int[] attackValues;

	// Constructors
	private AttributeAttackAbstract(){
		attackValues = new int[Direction.DIRECTIONS];
	}

	/**
	 *
	 * @param name Name of the attribute
	 * @param description Detailed description of the attribute
	 */
	public AttributeAttackAbstract(String name, String description) {
		super(name, description);
	}

	/**
	 *
	 * @param name Name of the attribute
	 * @param description Detailed description of the attribute
	 * @param owner Tile to which this attribute is attached to
	 */
	public AttributeAttackAbstract(String name, String description, Tile owner) {
		super(name, description, owner);
	}

	/**
	 *
	 * @param name Name of the attribute
	 * @param description Detailed description of the attribute
	 * @param attackValues Array of ints where index is direction and content is the amount of damage to deal to that direction. If length is different from DIRECTIONS enum constant then default with be used (no damage)
	 */
	public AttributeAttackAbstract(String name, String description, int[] attackValues){
		super(name, description);
		if (attackValues.length == Direction.DIRECTIONS)
			this.attackValues = attackValues;
		else
			this.attackValues = new int[Direction.DIRECTIONS];
	}

	/**
	 *
	 * @param name Name of the attribute
	 * @param description Detailed description of the attribute
	 * @param attackValues Array of ints where index is direction and content is the amount of damage to deal to that direction. If length is different from DIRECTIONS enum constant then default with be used (no damage)
	 * @param owner Tile to which this attribute is attached to
	 */
	public AttributeAttackAbstract(String name, String description, int[] attackValues, Tile owner){
		super(name, description, owner);
		if (attackValues.length == Direction.DIRECTIONS)
			this.attackValues = attackValues;
		else
			this.attackValues = new int[Direction.DIRECTIONS];
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
