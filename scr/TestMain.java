import GameBackend.Attributes.BattleAttributes.MeleeAttack;
import GameBackend.Direction;
import GameBackend.Game.Board;
import GameBackend.Tiles.Interfaces.UnitTile;
import GameBackend.Tiles.WarriorTile;

public class TestMain {
	public static void main(String[] args){
		Board board = new Board();

		UnitTile warrior1 = new WarriorTile("Melas1");
		UnitTile warrior2 = new WarriorTile("Melas2");
		UnitTile warrior3 = new WarriorTile("Melas3");

		int[] attacks1 = new int[Direction.DIRECTIONS];
		int[] attacks2 = new int[Direction.DIRECTIONS];
		int[] attacks3 = new int[Direction.DIRECTIONS];

		for (int i = 0; i < Direction.DIRECTIONS; i++) {
			attacks1[i] = 0;
			attacks2[i] = 0;
			attacks3[i] = 0;
		}

		attacks1[0] = 1;
		attacks2[0] = 1;
		attacks3[0] = 1;

		warrior1.addAttribute(new MeleeAttack("Melee Attack", "Normal attack", attacks1, warrior1));
		warrior2.addAttribute(new MeleeAttack("Melee Attack", "Normal attack", attacks2, warrior2));
		warrior3.addAttribute(new MeleeAttack("Melee Attack", "Normal attack", attacks3, warrior3));

		board.placeTile(4, warrior1);
		board.placeTile(5, warrior2);
		board.placeTile(1, warrior3);
		System.out.println(board);

		board.battle();
		System.out.println(board);

		board.resolve();
		System.out.println(board);
	}
}
