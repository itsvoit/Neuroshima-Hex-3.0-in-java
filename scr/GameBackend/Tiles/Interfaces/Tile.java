package GameBackend.Tiles.Interfaces;

import GameBackend.Attributes.AbilityAttributes.AbilityAttributeAbstract;
import GameBackend.Game.Hex;

import java.util.ArrayList;

public abstract class Tile {
	public enum Type {
		WARRIOR,
		MODULE,
		INSTANT,
		GROUND
	}
	protected Type type;
	protected Hex hex;
	protected ArrayList<AbilityAttributeAbstract> abilityAttributes;
	protected String name;

	public Tile(String name){
		this.name = name;
	}

	public Type getType() {
		return type;
	}

	public void addAbilityAttribute(AbilityAttributeAbstract attr){
		abilityAttributes.add(attr);
		attr.setOwner(this);
	}

	public void setHex(Hex hex) {
		this.hex = hex;
	}

	public Hex getHex() {
		return hex;
	}
}
