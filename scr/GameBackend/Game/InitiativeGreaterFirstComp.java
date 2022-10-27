package GameBackend.Game;

import java.util.Comparator;

public class InitiativeGreaterFirstComp implements Comparator<Initiative> {
	@Override
	public int compare(Initiative o1, Initiative o2) {
		return o2.value - o1.value;
	}
}
