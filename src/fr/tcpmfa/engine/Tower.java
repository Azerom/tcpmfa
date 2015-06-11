package fr.tcpmfa.engine;

import fr.tcpmfa.util.Coordinate;

public class Tower extends Element {
	private final int cost;
	private final Type damageType;
	private int level;
	private int range;
	private int cooldown;
	
	public Tower(int nmdDamage, Type typeDamage, String name, Coordinate coord, Game game,int level,int range,int cost,int cooldown){
		super(coord, nmdDamage, typeDamage, name, game);
		this.cost = cost;
		this.range=range;
		this.damageType = null;
		this.setImage("Images/Tour_3.png");
		this.level=level;
		this.cooldown=cooldown;
	}

	@Override
	public void act() {
		for(Ennemy e : game.getActualWave()){

			int eX = e.getCoord().getX();
			int eY = e.getCoord().getY();
			
			int tX = this.coord.getX();
			int tY = this.coord.getY();
			
			int dX = Math.abs(eX - tX);
			int dY = Math.abs(eY - tY);

			if((dX <= this.range) && 
					(dY <= this.range)){
				
				if( ( (dX * dX) + (dY * dY) ) <= (range * range) ){
					this.attack(e);
				}
				
			}
		}
		
	}
	
	public int getlevel(){
		return level;
	}
}
