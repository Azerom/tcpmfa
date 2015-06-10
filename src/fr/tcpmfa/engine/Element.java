package fr.tcpmfa.engine;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import fr.tcpmfa.display.GraphicalElement;
import fr.tcpmfa.util.Coordinate;

public abstract class Element implements GraphicalElement{
	protected Coordinate coord;

	protected int nmbDamage;
	protected Type typeDamage;
	protected String name;
	protected Game game;
	protected int wait;
	protected Image image;
	
	public Element(Coordinate coord, int nmdDamage, Type typeDamage, String name, Game game){
		this.coord = coord;
		this.nmbDamage = nmdDamage;
		this.typeDamage = typeDamage;
		this.name = name;
		this.game = game;
		this.wait = 0;
	}
	
	public abstract void act();
	
	public void attack(Element cible){
		cible.takeDamage(nmbDamage, typeDamage);
	}
	
	public void takeDamage(int damage, Type type){
		
	}
	
	public Game getGame(){
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	public Coordinate getCoord() {
		return coord;
	}
	public void setCoord(Coordinate coord) {
		this.coord = coord;
	}
	public int getNmbDamage() {
		return nmbDamage;
	}
	public Type getTypeDamage() {
		return typeDamage;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Image getImage(){
		return image;
	}
	public void setImage(String image){
	       try {                
		          this.image =  ImageIO.read(new File(image));
		        } catch (IOException ex) {
		             // handle exception...
		        }
	}
}
