package fr.tcpmfa.display;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import fr.tcpmfa.util.Coordinate;


public interface GraphicalElement {

	public  BufferedImage getImage();
	public void setImage(String image);
	public Coordinate getCoord();
	public void setCoord(Coordinate Coordinates);
	public ArrayList<String> getPossibleAction();
	public void reactToAction(String action);
}
