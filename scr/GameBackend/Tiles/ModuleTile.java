package GameBackend.Tiles;

import GameBackend.Game.Initiative;
import GameBackend.Tiles.Interfaces.UnitTile;

import java.util.ArrayList;
import java.util.TreeSet;

public class ModuleTile extends UnitTile {

	private ModuleTile(String name){
		super(name);
		this.type = Type.MODULE;
		this.baseInitiatives = new TreeSet<>();
		baseInitiatives.add(Initiative.PASSIVE);
	}
}
