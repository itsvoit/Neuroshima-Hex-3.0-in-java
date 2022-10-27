package GameBackend.Attributes.PassiveAttributes;

import GameBackend.Direction;
import GameBackend.Game.Board;
import GameBackend.Game.Hex;
import GameBackend.Game.Initiative;
import GameBackend.Game.InitiativeGreaterFirstComp;
import GameBackend.Tiles.Interfaces.Tile;

import java.util.PriorityQueue;
import java.util.TreeSet;

public class Sergeant extends PassiveAttributeAbstract {
	public Sergeant(String name, String description) {
		super(name, description);
	}

	public Sergeant(String name, String description, boolean self, TreeSet<Direction> directions) {
		super(name, description, self, directions);
	}

	public Sergeant(String name, String description, Tile owner) {
		super(name, description, owner);
	}

	public Sergeant(String name, String description, Tile owner, boolean self, TreeSet<Direction> directions) {
		super(name, description, owner, self, directions);
	}

	@Override
	public void use(Board board) {
		if (owner == null || owner.getHex() == null) return;

		Hex[] adjacentHexes = board.getAdjacent(owner.getHex().getIndex());

		for (int i = 0; i < Direction.DIRECTIONS; i++) {
			if (adjacentHexes[i] != null && directions.contains(Direction.getByValue(i))){
				PriorityQueue<Initiative> inits = adjacentHexes[i].getUnitTile().getBattleInitiatives();
				if (inits.isEmpty()) return;

				PriorityQueue<Initiative> newInits = new PriorityQueue<>(new InitiativeGreaterFirstComp());
				newInits.addAll(inits);

				while (inits.size() > 1){
					inits.poll();
				}

				if (inits.peek().getValue() > 0)
					newInits.add(inits.poll().lower());

				adjacentHexes[i].getUnitTile().setBattleInitiatives(newInits);
			}
		}
	}
}
