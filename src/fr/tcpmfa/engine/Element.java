package fr.tcpmfa.engine;

import fr.tcpmfa.util.Coordinate;

public abstract class Element {
	protected Coordinate coord;
	protected int nmbDamage;
	protected Type typeDamage;
	protected String name;
	protected final Game game;
	
	public Element(Coordinate coord, int nmdDamage, Type typeDamage, String name, Game game){
		this.coord = coord;
		this.nmbDamage = nmdDamage;
		this.typeDamage = typeDamage;
		this.name = name;
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
}
