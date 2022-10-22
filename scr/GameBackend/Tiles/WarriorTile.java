package GameBackend.Tiles;

import GameBackend.Tiles.Interfaces.UnitTile;

public class WarriorTile extends UnitTile {

	public WarriorTile(String name){
		super(name);
		this.type = Type.WARRIOR;
	}

}
