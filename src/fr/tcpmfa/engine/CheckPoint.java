package fr.tcpmfa.engine;

import fr.tcpmfa.util.Coordinate;
import fr.tcpmfa.util.Direction;

/**
 * Represent navigation data used by the ennemy between two Points,
 * </br>A CheckPoint is linked to the next point and have the direction to use to go to this point.
 * @author Azerom
 *
 */
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
