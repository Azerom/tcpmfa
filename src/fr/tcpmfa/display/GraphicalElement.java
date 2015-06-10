package fr.tcpmfa.display;

import java.awt.Image;

import fr.tcpmfa.util.Coordinate;


public interface GraphicalElement {

	public  Image getImage();
	public void setImage(String image);
	public Coordinate getCoord();
	public void setCoord(Coordinate Coordinates);
}
