package fr.tcpmfa.engine;

import fr.tcpmfa.util.Coordinate;
import fr.tcpmfa.util.Direction;

public class CheckPoint {
	private Direction direction;
	private Point nextPoint;
	
	public Direction getDirection() {
		return direction;
	}

	public Point getNextPoint() {
		return nextPoint;
	}

}
