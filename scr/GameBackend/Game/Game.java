package GameBackend.Game;

import java.util.ArrayList;

/**
 * Main game class. Contains all elements: Board, Players, etc.
 * Used to start the game
 */
public class Game {
	private Board board;
	private ArrayList<Player> players;

	public Game(){
		board = new Board();
		players = new ArrayList<>();
	}
}
