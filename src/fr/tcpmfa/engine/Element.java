package fr.tcpmfa.engine;

import fr.tcpmfa.util.Coordinate;

public abstract class Element {
	private Coordinate coord;
	private int nmbDamage;
	private Type typeDamage;
	
	public void act(){
		
	}
	
	public void attack(Element cible){
		cible.takeDamage(nmbDamage, typeDamage);
	}
	
	public void takeDamage(int damage, Type type){
		
	}
}
