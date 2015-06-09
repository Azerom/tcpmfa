package fr.tcpmfa.engine;

import fr.tcpmfa.util.Coordinate;

public class Tower extends Element {
	private final int cost;
	private final Type damageType;
	private int level;
	private int range;
	
	public Tower(int nmdDamage, Type typeDamage, String name, Coordinate coord, Game game){
		super(coord, nmdDamage, typeDamage, name, game);
		this.cost = 0;
		this.damageType = null;
	}

	@Override
	public void act() {
		// TODO Auto-generated method stub
		
	}
}
