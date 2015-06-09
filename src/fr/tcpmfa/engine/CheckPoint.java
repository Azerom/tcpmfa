package fr.tcpmfa.engine;

import fr.tcpmfa.util.Coordinate;
import fr.tcpmfa.util.Direction;

public class CheckPoint {
	private Direction direction;
	private Point nextPoint;
	
	public CheckPoint(Direction direction, Point nextPoint){
		this.direction = direction;
		this.nextPoint = nextPoint;
	}
	
	public Direction getDirection() {
		return direction;
	}

	public Point getNextPoint() {
		return nextPoint;
	}

}
