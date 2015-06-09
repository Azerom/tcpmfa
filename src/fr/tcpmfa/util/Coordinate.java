package fr.tcpmfa.util;

/**
 * Classe gerant des coordonées
 * @author Azerom
 *
 */
public class Coordinate {
	private int x;
	private int y;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * Permet de savoir si 2 coordinates sont egaux
	 * @param other : autre Coordinate
	 * @return boolean
	 */
	public boolean isEqual(Coordinate other){
		if (other.getX() == this.x && other.getY() == this.y)
			return true;
		return false;
	}
	
	public void moveInDirection(Direction direction){
		switch(direction){
		 	case NORTH :
		 		y += 1;
		 		break;
		 	case EAST :
		 		x += 1;
		 		break;
		 	case SOUTH :
		 		x -= 1;
		 		break;
		 	case WEST :
		 		y -= 1;
		 		break;
		}
	}
}
