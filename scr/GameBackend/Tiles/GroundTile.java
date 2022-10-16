package GameBackend.Tiles;

import GameBackend.Tiles.Interfaces.Placeable;
import GameBackend.Tiles.Interfaces.Tile;

public class GroundTile extends Tile implements Placeable {

	public GroundTile(){
		this.type = Type.GROUND;
	}
}
