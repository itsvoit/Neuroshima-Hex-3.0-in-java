package GameBackend.Tiles.Interfaces;

import GameBackend.Attributes.AttributeInterface;
import GameBackend.Direction;
import GameBackend.Game.Board;

public abstract class UnitTile extends Tile implements Placeable {

	protected Direction rotation;
	protected boolean hasInitiative;
	protected int initiative;
	protected int damageTaken;
	protected int health;

	public UnitTile(String name){
		super(name);
		health = 1;
	}

	public UnitTile(String name, int health){
		this(name);
		this.health = health;
	}

	public boolean rotate(Direction newDirection){
		if (rotation == newDirection) return false;

		rotation = newDirection;
		return true;
	}

	public void dealDamage(int attackValue){
		damageTaken += attackValue;
	}

	public boolean isDead(){
		return damageTaken >= health;
	}

	public void useAttributes(Board board){
		for (AttributeInterface attr : attributes){
			attr.use(board);
			System.out.println("Current attr: " + attr);
		}
	}

	@Override
	public String toString() {
		return name + ", init=" + initiative;
	}
}
