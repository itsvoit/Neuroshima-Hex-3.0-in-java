package GameBackend.Tiles;

import GameBackend.Game.Initiative;
import GameBackend.Tiles.Interfaces.UnitTile;

public class ModuleTile extends UnitTile {

	private ModuleTile(String name){
		super(name);
		this.type = Type.MODULE;
		this.hasInitiative = false;
		this.initiative = Initiative.PASSIVE;
	}
}
