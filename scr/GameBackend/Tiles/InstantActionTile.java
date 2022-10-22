package GameBackend.Tiles;

import GameBackend.Game.Board;
import GameBackend.Tiles.Interfaces.Tile;
import GameBackend.Tiles.Interfaces.Usable;

public class InstantActionTile extends Tile implements Usable {

	public InstantActionTile(String name){
		super(name);
		this.type = Type.INSTANT;
	}

	@Override
	public void use(Board board) {

	}
}
