package GameBackend.Tiles.Interfaces;

import GameBackend.Attributes.BattleAttributes.BattleAttributeAbstract;
import GameBackend.Attributes.DefenseAttributes.DefenseAttributeAbstract;
import GameBackend.Attributes.PassiveAttributes.PassiveAttributeAbstract;
import GameBackend.Direction;
import GameBackend.Game.Board;
import GameBackend.Game.Initiative;
import GameBackend.Game.InitiativeGreaterFirstComp;
import GameBackend.Tiles.Damage;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.TreeSet;

public abstract class UnitTile extends Tile implements Placeable {

	protected int health;
	protected Direction rotation;
	protected TreeSet<Initiative> baseInitiatives;

	protected ArrayList<BattleAttributeAbstract> battleAttributes;
	protected ArrayList<PassiveAttributeAbstract> passiveAttributes;
	protected ArrayList<DefenseAttributeAbstract> defenseAttributes;

	// sorted by the highest Initiative first
	protected PriorityQueue<Initiative> battleInitiatives;
	protected ArrayList<Damage> damageTaken;
	protected int bonusMeleeDamage;
	protected int bonusRangeDamage;
	public boolean netted;

	public UnitTile(String name){
		super(name);
		health = 1;
		this.battleAttributes = new ArrayList<>();

		this.passiveAttributes = new ArrayList<>();
		this.defenseAttributes = new ArrayList<>();
		this.baseInitiatives = new TreeSet<>();
		this.battleInitiatives = new PriorityQueue<>(new InitiativeGreaterFirstComp());
	}

	public UnitTile(String name, TreeSet<Initiative> baseInitiatives){
		this(name);
		this.baseInitiatives = baseInitiatives;
	}

	public void addBattleAttribute(BattleAttributeAbstract attr){
		battleAttributes.add(attr);
		attr.setOwner(this);
	}

	public void addPassiveAttribute(PassiveAttributeAbstract attr){
		passiveAttributes.add(attr);
		attr.setOwner(this);
	}

	public void addDefenseAttribute(DefenseAttributeAbstract attr){
		defenseAttributes.add(attr);
		attr.setOwner(this);
	}

	public boolean rotate(Direction newDirection){
		if (rotation == newDirection) return false;

		rotation = newDirection;
		return true;
	}

	public void setBonusMeleeDamage(int bonusMeleeDamage) {
		this.bonusMeleeDamage = bonusMeleeDamage;
	}

	public void setBonusRangeDamage(int bonusRangeDamage) {
		this.bonusRangeDamage = bonusRangeDamage;
	}

	public int getBonusMeleeDamage() {
		return bonusMeleeDamage;
	}

	public int getBonusRangeDamage() {
		return bonusRangeDamage;
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

	public void prepareTileForBattle(){
		battleInitiatives.clear();
		battleInitiatives.addAll(baseInitiatives);
		bonusMeleeDamage = 0;
		bonusRangeDamage = 0;
		// todo : clear other bonuses (additional damage, nets, etc.)
	}

	public TreeSet<Initiative> getBaseInitiatives() {
		return baseInitiatives;
	}

	public void setBaseInitiatives(TreeSet<Initiative> baseInitiatives) {
		this.baseInitiatives = baseInitiatives;
	}

	public PriorityQueue<Initiative> getBattleInitiatives() {
		return battleInitiatives;
	}

	public void setBattleInitiatives(PriorityQueue<Initiative> battleInitiatives) {
		this.battleInitiatives = battleInitiatives;
	}

	@Override
	public String toString() {
		return name + ", init=" + baseInitiatives;
	}

}