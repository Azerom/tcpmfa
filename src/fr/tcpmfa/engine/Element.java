package fr.tcpmfa.engine;

import fr.tcpmfa.consoleGraphic.GraphicalElement;
import fr.tcpmfa.util.Coordinate;

public abstract class Element implements GraphicalElement{
	protected Coordinate coord;
	public void setCoord(Coordinate coord) {
		this.coord = coord;
	}
	protected int nmbDamage;
	protected Type typeDamage;
	protected String name;
	protected Game game;
	public void setName(String name) {
		this.name = name;
	}
	protected int wait;
	
	public Element(Coordinate coord, int nmdDamage, Type typeDamage, String name, Game game){
		this.coord = coord;
		this.nmbDamage = nmdDamage;
		this.typeDamage = typeDamage;
		this.name = name;
		this.game = game;
		this.wait = 0;
	}
	public void setGame(Game game) {
		this.game = game;
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
	public Coordinate getCoord() {
		return coord;
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
	
	public char getImage(){
		return 'X';
	}
	public void setImage(char image){
		
	}
}
