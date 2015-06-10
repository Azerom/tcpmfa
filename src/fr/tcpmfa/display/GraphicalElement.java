package fr.tcpmfa.display;


public interface GraphicalElement {

	public default Image getImage(java.awt.Image Image){
		return Image;
	}
	
	public default void setImage(java.awt.Image newImage){
		
	}
	
	public Coordonnees getCoordinates(){
		return Coordonnees;
	}
	
	public Coordonnees setCoordinates(){
		
	}
	
}
