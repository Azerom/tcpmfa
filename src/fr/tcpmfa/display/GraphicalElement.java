package fr.tcpmfa.display;

import java.awt.Image;

import fr.tcpmfa.util.Coordinate;


public interface GraphicalElement {

	public  Image getImage(Image){
		return Image;
	}
	
	public void setImage(Image Image){
		this.Image = Image;
	}
	
	public Coordinate getCoordinates(){
		return Coordinate;
	}
	
	public void setCoordinates(Coordinate Coordinates){
		this.Coordinates = Coordinates;
	}
	
}
