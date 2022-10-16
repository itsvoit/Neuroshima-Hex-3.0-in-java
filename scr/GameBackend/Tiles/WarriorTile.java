package GameBackend.Tiles;

import GameBackend.Tiles.Interfaces.UnitTile;

public class WarriorTile extends UnitTile {

	private WarriorTile(){
		this.type = Type.WARRIOR;
	}

	public WarriorTile(String name){
		this();
		this.name = name;
	}

}
