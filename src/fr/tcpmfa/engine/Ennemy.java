package fr.tcpmfa.engine;

import java.util.Random;

import fr.tcpmfa.dataBase.DBTDConnexion;
import fr.tcpmfa.util.Coordinate;

/**
 * Ennemy
 * 
 * desing to move along a path made of Points
 * @see Points
 * @see Element
 * @author Azerom
 *
 */
public class Ennemy extends Element {
	
	/**
	 * Move speed, the fewer the better
	 */
	private int moveSpeed;
	private final Type resitance;
	private final int loot;
	private int hp;
	
	/**
	 * Actual chackpoint using by the ennemy to navigate
	 * @see CheckPoint
	 */
	private CheckPoint checkPoint;
	


	/**
	 * Default contructor</br>
	 * 
	 * @param moveSpeed
	 * @param resistance
	 * @param loot
	 * @param hp
	 * @param checkpoint
	 * @param nmdDamage
	 * @param typeDamage
	 * @param name
	 * @param coord
	 * @param game
	 */
	public Ennemy(int moveSpeed, Type resistance, int loot, int hp, CheckPoint checkpoint, int nmdDamage, Type typeDamage, String name, Coordinate coord, Game game){
		super(coord, nmdDamage, typeDamage, name, game);
		this.moveSpeed = moveSpeed;
		this.resitance = resistance;
		this.loot = loot;
		this.hp = hp;
		this.checkPoint = checkpoint;
		
		System.out.println("hello, i am " + this.name);
	}
	
	/**
	 * Make the ennemy move on is path.
	 */
	public void move(){
		this.coord.moveInDirection(checkPoint.getDirection());
		
		if(this.coord.isEqual(checkPoint.getNextPoint())){
			System.out.println(this.name + " reach a checkpoint");
			this.checkPoint = checkPoint.getNextPoint().getCheckPoint();
		}
	}
	
	/**
	 * Make the ennemie die
	 */
	public void die(){
		game.deadTakeAct(this);
		System.out.println(this.name + " die");
	}

	@Override
	public void act() {

		if(this.wait == this.moveSpeed){
			move();
			this.wait = 0;
			if (game.getMap().getCoordEnd().isEqual(this.getCoord())){
				game.decreaseHp(getNmbDamage());
				System.out.println(this.name + " suicide");
				this.die();
				return;
			}
		}
		else
			wait++;
		
		System.out.println(this.name + " = X : " + coord.getX() + ", Y : " + coord.getY());
		
	}
	
	public static Ennemy generateEnnemy(int id){
		DBTDConnexion bdd = new DBTDConnexion();
		
		bdd.open();
		
		Ennemy ennemy =  bdd.getEnnemy(id);
		
		bdd.close();
		
		return ennemy;
	}
	
	public static Ennemy generateRandomEnnemy(){
		return generateEnnemy(new Random().nextInt(4)+1);
	}
	
	public CheckPoint getCheckPoint() {
		return checkPoint;
	}

	public void setCheckPoint(CheckPoint checkPoint) {
		this.checkPoint = checkPoint;
	}
	
	public void takeDamage(int damage, Type type){
		this.hp -= damage;
		System.out.println(this.name + " take " + damage + " damage, remaing " + this.hp + " hp");
		if(hp <= 0){
			this.die();
		}
	}
}
