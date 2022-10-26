package GameBackend.Tiles.Interfaces;

import GameBackend.Attributes.BattleAttributes.BattleAttributeAbstract;
import GameBackend.Attributes.DefenseAttributes.DefenseAttributeAbstract;
import GameBackend.Attributes.PassiveAttributes.PassiveAttributeAbstract;
import GameBackend.Direction;
import GameBackend.Game.Board;
import GameBackend.Game.Initiative;
import GameBackend.Tiles.Damage;

import java.util.ArrayList;
import java.util.Comparator;

public abstract class UnitTile extends Tile implements Placeable {

	protected Direction rotation;
	protected boolean hasInitiative;
	protected Initiative initiative;
	protected int health;
	protected ArrayList<Damage> damageTaken;

	public UnitTile(String name){
		super(name);
		health = 1;
	}

	public UnitTile(String name, Initiative initiative){
		this(name);
		this.initiative = initiative;
	}

	public boolean rotate(Direction newDirection){
		if (rotation == newDirection) return false;

		rotation = newDirection;
		return true;
	}

	public ArrayList<Damage> getDamageTaken(){
		return damageTaken;
	}

	public void dealDamage(Damage damage){
		damageTaken.add(damage);
	}

	public boolean resolveDamage(){
		defenseAttributes.sort(null); // comp: null -> use natural ordering of elements
		for (DefenseAttributeAbstract attr : defenseAttributes){
			attr.use(damageTaken);
		}

		for (Damage damage : damageTaken){
			health -= damage.melee + damage.range;
		}

		return health > 0;
	}

	public void useBattleAttributes(Board board){
		for (BattleAttributeAbstract attr : battleAttributes){
			attr.use(board);
			System.out.println("Current battle attr: " + attr);
		}
	}

	public void usePassiveAttributes(Board board){
		for (PassiveAttributeAbstract attr : passiveAttributes){
			attr.use(board);
			System.out.println("Current passive attr: " + attr);
		}
	}

	public Initiative getInitiative() {
		return initiative;
	}

	@Override
	public String toString() {
		return name + ", init=" + initiative;
	}
}