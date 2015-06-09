package fr.tcpmfa.engine;

import fr.tcpmfa.util.Coordinate;

public class Ennemy extends Element {
	private int moveSpeed;
	private final Type resitance;
	private final int loot;
	private int hp;
	
	private CheckPoint checkPoint;
	
	public Ennemy(int moveSpeed, Type resistance, int loot, int hp, CheckPoint checkpoint, int nmdDamage, Type typeDamage, String name, Coordinate coord, Game game){
		super(coord, nmdDamage, typeDamage, name, game);
		this.moveSpeed = moveSpeed;
		this.resitance = resistance;
		this.loot = loot;
		this.hp = hp;
		this.checkPoint = checkpoint;
		
		System.out.println("hello, i am " + this.name);
	}
	
	public void move(){
		this.coord.moveInDirection(checkPoint.getDirection());
		
		if(this.coord.isEqual(checkPoint.getNextPoint())){
			System.out.println("I reach a checkpoint");
			this.checkPoint = checkPoint.getNextPoint().getCheckPoint();
		}
	}
	
	public void die(){
		game.getActualWave().remove(this);
	}

	@Override
	public void act() {

		if(this.wait == this.moveSpeed){
			move();
			this.wait = 0;
			if (game.getMap().getCoordEnd().isEqual(this.getCoord())){
				game.decreaseHp(getNmbDamage());
				this.die();
			}
		}
		else
			wait++;
		
		System.out.println(this.name + " = X : " + coord.getX() + ", Y : " + coord.getY());
		
	}
}
