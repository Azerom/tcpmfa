package fr.tcpmfa.engine;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
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
	private int maxHp;
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
	public Ennemy(int id, int moveSpeed, Type resistance, int loot, int hp, CheckPoint checkpoint, int nmdDamage, Type typeDamage, String name, Coordinate coord, Game game){
		super(coord, nmdDamage, typeDamage, name, game);
		this.moveSpeed = moveSpeed;
		this.resitance = resistance;
		this.loot = loot;
		this.hp = hp;
		this.maxHp = hp;
		this.checkPoint = checkpoint;
		this.setImage("e" + Integer.toString(id) + ".png");
		
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
			game.setRessource(game.getRessource() + this.loot);
			this.die();
		}
	}
	
	@Override
	public BufferedImage getImage(){
		
		BufferedImage image = new BufferedImage(30,30,BufferedImage.TYPE_INT_ARGB);
		Graphics g = image.getGraphics();
		if( g instanceof Graphics2D ){
			Graphics2D g2d = (Graphics2D) g;
			// make sure the background is filled with transparent pixels when cleared !
			Composite original = g2d.getComposite();
			g2d.setBackground(new Color(0,0,0,0));
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_IN, 0.0f));
			g.clearRect(0, 0, 30, 30);
			g2d.setComposite(original);
			}
		g.drawImage(this.image, 0, 0, 30, 30, null);
		
		g.setColor(Color.red);
		g.fillRect(0, 0, image.getWidth(), 5 );
		
		g.setColor(Color.green);
		g.fillRect(0, 0, Math.round( ( (float)hp / (float)maxHp ) * (float)image.getWidth()), 5);
		
		return image;
	}
	
	public boolean isAlive(){
		if(hp > 0)
			return true;
		else
			return false;
	}
	
}
