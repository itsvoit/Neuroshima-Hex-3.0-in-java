package GameBackend.Attributes.DefenseAttributes;

import GameBackend.Tiles.Damage;
import GameBackend.Tiles.Interfaces.Tile;

import java.util.ArrayList;

public class ToughnessSelf extends DefenseAttributeAbstract {
	private int value;
	private int damageAbsorbed;

	public ToughnessSelf(String name, String description) {
		super(name, description);
		value = 0;
		damageAbsorbed = 0;
		resolutionWeight = 10;
	}

	public ToughnessSelf(String name, String description, Tile owner) {
		super(name, description, owner);
		value = 0;
		damageAbsorbed = 0;
		resolutionWeight = 10;
	}

	public ToughnessSelf(String name, String description, int value) {
		this(name, description);
		this.value = value;
	}

	public ToughnessSelf(String name, String description, Tile owner, int value) {
		this(name, description, owner);
		this.value = value;
	}

	@Override
	public void use(ArrayList<Damage> damage) {
		for (Damage dmg : damage){
			if (damageAbsorbed >= value) break;
			// damage to be taken is greater than what can be absorbed
			if ((dmg.damage()) > (value - damageAbsorbed)){
				int tempDamageAbsorbed = value - damageAbsorbed;
				if (tempDamageAbsorbed > dmg.melee){
					tempDamageAbsorbed -= dmg.melee;
					dmg.melee = 0;
					dmg.range -= tempDamageAbsorbed;
				} else {
					dmg.melee -= tempDamageAbsorbed;
				}
			}
			// damage to be taken can be fully absorbed
			else {
				damageAbsorbed += dmg.damage();
				dmg.melee = 0;
				dmg.range = 0;
			}
		}
	}
}
