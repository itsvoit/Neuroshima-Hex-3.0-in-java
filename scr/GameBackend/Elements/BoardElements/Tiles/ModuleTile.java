package GameBackend.Elements.BoardElements.Tiles;

public class ModuleTile extends UnitTile {

	private ModuleTile(){
		this.type = Type.MODULE;
		this.hasInitiative = false;
		this.initiative = -1;
	}

	public ModuleTile(String name){
		this();
		this.name = name;
	}
}
