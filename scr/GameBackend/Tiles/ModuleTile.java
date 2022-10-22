package GameBackend.Tiles;

import GameBackend.Tiles.Interfaces.UnitTile;

public class ModuleTile extends UnitTile {

	private ModuleTile(String name){
		super(name);
		this.type = Type.MODULE;
		this.hasInitiative = false;
		this.initiative = -1;
	}
}
