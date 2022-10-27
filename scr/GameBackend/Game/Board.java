package GameBackend.Game;

import GameBackend.Direction;
import GameBackend.Tiles.GroundTile;
import GameBackend.Tiles.Interfaces.Tile;

import java.util.*;

public class Board {
	public static final int MAX_HEX_INDEX = 19;
	private static final int[][] adjacencyIndexes = {
	/* 1  */ 	{-1, 2, 5, 4, -1, -1},
	/* 2  */ 	{-1, 3, 6, 5, 1, -1},
	/* 3  */ 	{-1, -1, 7, 6, 2, -1},
	/* 4  */ 	{1, 5, 9, 8, -1, -1},
	/* 5  */ 	{2, 6, 10, 9, 4, 1},
	/* 6  */ 	{3, 7, 11, 10, 5, 2},
	/* 7  */ 	{-1, -1, 12, 11, 6, 3},
	/* 8  */ 	{4, 9, 13, -1, -1, -1},
	/* 9  */ 	{5, 10, 14, 13, 8, 4},
	/* 10 */ 	{6, 11, 15, 14, 9, 5},
	/* 11 */ 	{7, 12, 16, 15, 10, 6},
	/* 12 */ 	{-1, -1, -1, 16, 11, 7},
	/* 13 */ 	{9, 14, 17, -1, -1, 8},
	/* 14 */ 	{10, 15, 18, 17, 13, 9},
	/* 15 */ 	{11, 16, 19, 18, 14, 10},
	/* 16 */ 	{12, -1, -1, 19, 15, 11},
	/* 17 */ 	{14, 18, -1, -1, -1, 13},
	/* 18 */ 	{15, 19, -1, -1, 17, 14},
	/* 19 */ 	{16, -1, -1, -1, 18, 15},
	};

	private final Hex[] hexes;

	public Board(){
		hexes = new Hex[MAX_HEX_INDEX];
		for (int i = 0; i < MAX_HEX_INDEX; i++) {
			hexes[i] = new Hex(i);
		}
		for (int i = 0; i < MAX_HEX_INDEX; i++) {
			for (int j = 0; j < Direction.DIRECTIONS; j++) {
				hexes[i].adjacentHexes[j] = (adjacencyIndexes[i][j] == -1) ? null : hexes[adjacencyIndexes[i][j]-1];
			}
//			System.out.println(hexes[i]);
		}
	}

	public Hex getHex(int index){
		if (index < 0 || index > MAX_HEX_INDEX) throw new IllegalArgumentException("Hex index out of bounds");

		return hexes[index];
	}

	public boolean isAdjacent(int sourceIndex, int targetIndex){
		if (sourceIndex < 0 || sourceIndex > MAX_HEX_INDEX) return false;
		if (targetIndex < 0 || targetIndex > MAX_HEX_INDEX) return false;

		Hex[] sourceHexes = hexes[sourceIndex].adjacentHexes;
		for (int i = 0; i < Direction.DIRECTIONS; i++) {
			if (sourceHexes[i] != null && sourceHexes[i].index == targetIndex) return true;
		}
		return false;
	}

	/**
	 *
	 * @return All tiles from adjacent hexes, where index is the direction and null means there is no tile; null if index is out of bounds
	 */
	public Hex[] getAdjacent(int index){
		if (index < 0 || index > MAX_HEX_INDEX) return null;
		return hexes[index].adjacentHexes;
	}

	private Hex getAdjacent(int index, Direction direction){
		if (index < 0 || index > MAX_HEX_INDEX) return null;
		Hex adjacentHex = getHex(index).adjacentHexes[direction.getValue()];

		if (adjacentHex == null) return null;
		else if (adjacentHex.unitTile == null) return getAdjacent(adjacentHex.index, direction);
		else return adjacentHex;
	}

	public Hex[] getFirstInLine(int sourceIndex){
		if (sourceIndex < 0 || sourceIndex > MAX_HEX_INDEX) return null;

		Hex[] output = new Hex[Direction.DIRECTIONS];
		Hex source = getHex(sourceIndex);

		// Find first in line for each direction
		// if none then return null
		for (Direction direction : Direction.values()) {
			output[direction.getValue()] = getAdjacent(sourceIndex, direction);
		}

		return output;
	}

	/**
	 * Try to move the tile
	 * @param targetIndex hex to be standing on after the move
	 * @return false if target is occupied;
	 * true if move was successful
	 */
	public Boolean moveTile(int targetIndex){
		//todo Boolean moveToken(int newIndex)
		return true;
	}

	public Boolean rotateTile(int index, Direction newDirection){
		if (index < 0 || index >= MAX_HEX_INDEX) return false;
		return hexes[index].rotateTile(newDirection);
	}

	public Tile getTile(int index) {
		if (index < 0 || index >= MAX_HEX_INDEX) return null;
		return hexes[index].getUnitTile();
	}

	public GroundTile getGround(int index) {
		if (index < 0 || index >= MAX_HEX_INDEX) return null;
		return hexes[index].getGround();
	}

	public Boolean placeTile(int index, Tile tile) {
		if (index < 0 || index >= MAX_HEX_INDEX) return false;
		return hexes[index].placeTile(tile);
	}

	public void removeTile(int index){
		if (index < 0 || index >= MAX_HEX_INDEX) return;
		hexes[index].removeTile();
	}

	private ArrayList<Stack<Hex>> prepareForBattleByInitiative(){
		PriorityQueue<Hex> queue = new PriorityQueue<>(Comparator.comparing(Hex::getInitiative));
		queue.addAll(List.of(hexes));
		ArrayList<Stack<Hex>> initiatives = new ArrayList<>();
		Stack<Hex> currentInitiative = new Stack<>();

		// create ArrayList of Stacks that contain Hexes
		// each Stack represents an Initiative in Battle
		for (Hex hex = queue.poll(); hex != null && hex.getInitiative() != Initiative.NONE; hex = queue.poll()){
			if (currentInitiative.isEmpty() || hex.getInitiative() == currentInitiative.peek().getInitiative())
				currentInitiative.add(hex);
			else {
				initiatives.add(currentInitiative);
				currentInitiative = new Stack<>();
			}
		}
		if (!currentInitiative.isEmpty())
			initiatives.add(currentInitiative);

		return initiatives;
	}

	public void battle(){
		System.out.println("Battle...");

		ArrayList<Stack<Hex>> initiatives = prepareForBattleByInitiative();

		for(Stack<Hex> currentInitiative : initiatives) {
			for(Hex hex : hexes){
				if (hex.tile != null)
					hex.tile.usePassiveAttributes(this);
			}
			for (Hex hex : currentInitiative) {
				System.out.println("Using Battle attributes for " + hex);
				hex.unitTile.useBattleAttributes(this);
			}
			resolve();
		}
	}

	public void resolve(){
		for (Hex hex : hexes){
			if (hex.unitTile != null && hex.unitTile.resolveDamage())
				removeTile(hex.index);
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Board:\n");

		for (int i = 0; i < MAX_HEX_INDEX; i++) {
			if (hexes[i].unitTile == null) continue;
			builder.append(hexes[i]);
			builder.append(",\n");
		}
		builder.delete(builder.length()-2, builder.length());

		return builder.toString();
	}
}
