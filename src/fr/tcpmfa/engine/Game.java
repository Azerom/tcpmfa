package fr.tcpmfa.engine;

import fr.tcpmfa.consoleGraphic.Display;
import fr.tcpmfa.dataBase.DBTDConnexion;
import fr.tcpmfa.util.Coordinate;
import fr.tcpmfa.util.Direction;

/**
 * Represent a game of tower defense, contain all information like hp or ressources
 * @author Azerom
 *
 */
public class Game {

	private int hp;
	//private time
	private int ressource;
	private Display display;
	private WaveEnnemy actualWave;
	private Map map;
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
		this.display = new Display();
		actualWave = new WaveEnnemy(this, null);
	}
	
	//Test code around here, remove ASAP
	public Game(int hp, int ressource){
		
		DBTDConnexion bdd =new DBTDConnexion();
		bdd.open();
		
		this.hp = hp;
		this.ressource = ressource;
		this.display = new Display();
		this.map = bdd.getMap(1, this);
		bdd.close();
		System.out.println(map.getStartPoint().getCheckPoint().getDirection());
		
		actualWave = new WaveEnnemy(this, map.getStartPoint());
//		Ennemy ennemy = new Ennemy(0, null, 15, 20, new CheckPoint(Direction.NORTH, map.), 5, null, "Test Guy", new Coordinate(0,0), this);
//		actualWave.add(ennemy);
		
		
	}
	
	public void turn(){
//		display.display();
		this.actualWave.act();
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

