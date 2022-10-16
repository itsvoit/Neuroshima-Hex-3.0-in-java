package GameBackend.Elements.BoardElements.Tiles;

public class WarriorTile extends UnitTile {

	private WarriorTile(){
		this.type = Type.WARRIOR;
	}

	public WarriorTile(String name){
		this();
		this.name = name;
	}

}
