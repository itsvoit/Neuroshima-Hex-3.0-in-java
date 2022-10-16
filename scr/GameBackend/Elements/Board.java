package GameBackend.Elements;

import java.util.ArrayList;

public class Board {
	private ArrayList<Hex> hexes;

	public Board(){
		hexes = new ArrayList<>();
		for (int i = 0; i < Hex.MAX_HEX_INDEX; i++) {
			hexes.add(new Hex(i));
		}
	}

	public Hex getHex(int index){
		if (index < 0 || index > Hex.MAX_HEX_INDEX) throw new IllegalArgumentException("Hex index out of bounds");

		return hexes.get(index);
	}
}
