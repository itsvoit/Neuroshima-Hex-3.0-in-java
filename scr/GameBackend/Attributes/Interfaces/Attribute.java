package GameBackend.Attributes.Interfaces;

import GameBackend.Direction;

import java.util.ArrayList;

public abstract class Attribute {
	private ArrayList<Direction> directions;
	
	public abstract String getName();
	public abstract String getDesc();
}
