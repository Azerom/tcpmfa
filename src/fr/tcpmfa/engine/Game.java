package fr.tcpmfa.engine;

import java.util.ArrayList;
import java.util.Iterator;

import fr.tcpmfa.display.Display;
import fr.tcpmfa.display.GraphicalElement;
import fr.tcpmfa.dataBase.DBTDConnexion;
import fr.tcpmfa.util.Time;

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

	private ArrayList<Ennemy> dead;
	
	private ArrayList<GraphicalElement> graphicalList;
	
	private Time time;

	//	/**
	//	 * Default constructeur</br>
	//	 * </br>
	//	 * 
	//	 * @param hp : health point
	//	 * @param ressource : ressource you can use in tower upgrade
	//	 * @param map : Map link to the Game
	//	 */
	//	public Game(int hp, int ressource, Map map){
	//		this.hp = hp;
	//		this.ressource = ressource;
	//		this.map = map;
	//		this.display = new Display();
	//		actualWave = new WaveEnnemy(this, null);
	//	}

	//Test code around here, remove ASAP
	public Game(int hp, int ressource, int id_Map){
		
		this.time = new Time();
		
		dead = new ArrayList<Ennemy>();
		DBTDConnexion bdd =new DBTDConnexion();
		bdd.open();

		this.graphicalList = new ArrayList<GraphicalElement>();
		this.hp = hp;
		this.ressource = ressource;

		this.display = new Display("Test", this.graphicalList, id_Map);
		this.map = bdd.getMap(id_Map, this);

		bdd.close();

		//		Ennemy ennemy = new Ennemy(0, null, 15, 20, new CheckPoint(Direction.NORTH, map.), 5, null, "Test Guy", new Coordinate(0,0), this);
		//		actualWave.add(ennemy);
		startWave();
	}
	public Game(int hp,int ressource,int wave, Map map){
		
	}

	/**
	 * Launch a new wave
	 */
	public void startWave(){
		actualWave = new WaveEnnemy(this, map.getStartPoint());
		this.time.setStartTime();
	}
	
	/**
	 * Put the actual wave to end
	 */
	public void endWave(){
		time.setEndTime();
		
		System.out.println(time.getChrono());
		
		startWave();
	}

	/**
	 * Signal an ennemy as dead
	 * </br>We cannot remove an ennemy during a turn, </br>
	 * He will be remove as soon as the turn is over
	 * @param dead : Ennemy
	 */
	public void deadTakeAct(Ennemy dead){
		this.dead.add(dead);
		System.out.println(this.actualWave.size());
		if(this.actualWave.size() == 1){
			System.out.println("======================FIN DE VAGUE======================");
			this.endWave();
		}
		else
			System.out.println("La vague continue.");
		}
	
	/**
	 * Launch a turn
	 */
	public void turn(){
		this.graphicalList.clear();
		this.graphicalList.addAll(actualWave);
		this.graphicalList.addAll(map.getTowers());
		display.afficher();
		this.actualWave.act();
		for(Tower t : this.getMap().getTowers()){
			t.act();
		}
		
		for(Ennemy e : dead){
			this.actualWave.remove(e);
		}
		this.dead.clear();
		try {
			Thread.sleep(3);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
		System.out.println("System : Lose " + damage + " hp, " + this.hp + " remaing");
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

