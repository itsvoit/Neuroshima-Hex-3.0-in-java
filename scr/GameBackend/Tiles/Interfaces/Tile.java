package GameBackend.Tiles.Interfaces;

import GameBackend.Attributes.AbilityAttributes.AbilityAttributeAbstract;
import GameBackend.Attributes.AttributeAbstract;
import GameBackend.Attributes.BattleAttributes.BattleAttributeAbstract;
import GameBackend.Attributes.DefenseAttributes.DefenseAttributeAbstract;
import GameBackend.Attributes.PassiveAttributes.PassiveAttributeAbstract;
import GameBackend.Game.Board;

import java.util.ArrayList;

public abstract class Tile {
	public enum Type {
		WARRIOR,
		MODULE,
		INSTANT,
		GROUND
	}
	protected Type type;
	protected Board.Hex hex;
	protected ArrayList<BattleAttributeAbstract> battleAttributes;
	protected ArrayList<PassiveAttributeAbstract> passiveAttributes;
	protected ArrayList<DefenseAttributeAbstract> defenseAttributes;
	protected ArrayList<AttributeAbstract> abilityAttributes;
	protected String name;

	public Tile(String name){
		this.name = name;
		this.battleAttributes = new ArrayList<>();
	}

	public Type getType() {
		return type;
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

	public void addAbilityAttribute(AbilityAttributeAbstract attr){
		abilityAttributes.add(attr);
		attr.setOwner(this);
	}

	public void setHex(Board.Hex hex) {
		this.hex = hex;
	}

	public Board.Hex getHex() {
		return hex;
	}
}
