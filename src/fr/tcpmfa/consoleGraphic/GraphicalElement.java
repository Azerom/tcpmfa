package fr.tcpmfa.consoleGraphic;

import fr.tcpmfa.util.Coordinate;


public interface GraphicalElement {
	public char getImage();
	public void setImage(char image);
	public Coordinate getCoordinates();
	public void setCoordinates(Coordinate coordinates);
	
}
