package fr.tcpmfa.display;

import java.awt.Image;

import fr.tcpmfa.util.Coordinate;


public interface GraphicalElement {

	public  Image getImage();
	public void setImage(Image Image);
	public Coordinate getCoordinates();
	public void setCoordinates(Coordinate Coordinates);
}
