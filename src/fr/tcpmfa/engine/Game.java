package fr.tcpmfa.engine;

import fr.tcpmfa.util.Coordinate;

/**
 * Represent a game of tower defense, contain all information like hp or ressources
 * @author Azerom
 *
 */
public class Game {

	private int hp;
	//private time
	private int ressource;
//	private display
	private WaveEnnemy actualWave;
	private Map map;
	private static int turn;
	
	/**
	 * Default constructeur</br>
	 * </br>
	 * 
	 * @param hp : health point
	 * @param ressource : ressource you can use in tower upgrade
	 * @param map : Map link to the Game
	 */
	public Game(int hp, int ressource, Map map){
		this.hp = hp;
		this.ressource = ressource;
		this.map = map;
		
		actualWave = new WaveEnnemy(this);
	}
	
	//Test code around here, remove ASAP
	public Game(int hp, int ressource){
		this.hp = hp;
		this.ressource = ressource;
		
		this.map = new Map(this, new Coordinate(0, 20), new Coordinate(0,0), null);
		actualWave = new WaveEnnemy(this);
	}
	
	public void turn(){
		for(Ennemy e : actualWave){
			e.act();
		}
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public void decreaseHp(int damage){
		this.hp -= damage;
	}

	public int getRessource() {
		return ressource;
	}

	public void setRessource(int ressource) {
		this.ressource = ressource;
	}
	
	public Map getMap(){
		return map;
	}
	
	public WaveEnnemy getActualWave(){
		return this.actualWave;
	}
}

