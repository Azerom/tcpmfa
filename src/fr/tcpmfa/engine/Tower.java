package fr.tcpmfa.engine;

import fr.tcpmfa.util.Coordinate;

public class Tower extends Element {
	private final int cost;
	private final Type damageType;
	private int level;
	private int range;
	private int cooldown;
	private Ennemy focus;

	public Tower(int nmdDamage, Type typeDamage, String name, Coordinate coord, Game game,int level,int range,int cost,int cooldown){
		super(coord, nmdDamage, typeDamage, name, game);
		this.cost = cost;
		this.range=range;
		this.damageType = null;
		this.setImage("Images/Tour_3.png");
		this.level=level;
		this.cooldown=cooldown;
		this.focus = null;
	}

	@Override
	public void act() {


		if(focus != null){
			if(isAtRange(focus) && focus.isAlive()){
				attack(focus);
			}
			else
				focus = null;
		}
		else{
			for(Ennemy e : game.getActualWave()){
				if(isAtRange(e)){
					focus = e;
				}
			}
		}

	}

	private boolean isAtRange(Ennemy e){
		int eX = e.getCoord().getX();
		int eY = e.getCoord().getY();

		int tX = this.coord.getX();
		int tY = this.coord.getY();

		int dX = Math.abs(eX - tX);
		int dY = Math.abs(eY - tY);

		if((dX <= this.range) && 
				(dY <= this.range)){

			if( ( (dX * dX) + (dY * dY) ) <= (range * range) ){
				return true;
			}

		}

		return false;
	}

	public int getlevel(){
		return level;
	}
}
