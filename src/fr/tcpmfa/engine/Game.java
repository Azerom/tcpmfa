package fr.tcpmfa.engine;

import fr.tcpmfa.consoleGraphic.Display;
import fr.tcpmfa.util.Coordinate;
import fr.tcpmfa.util.Direction;

public class Game {

	private int hp;
	//private time
	private int ressource;
	private Display display;
	private WaveEnnemy actualWave;
	private Map map;
	private static int turn;
	
	public Game(int hp, int ressource, Map map){
		this.hp = hp;
		this.ressource = ressource;
		this.map = map;
		this.display = new Display();
		actualWave = new WaveEnnemy(this);
	}
	public Game(int hp, int ressource){
		this.hp = hp;
		this.ressource = ressource;
		this.map = new Map(this, new Coordinate(0, 20), new Coordinate(0,0));
		this.display = new Display();
		actualWave = new WaveEnnemy(this);
		Ennemy ennemy = new Ennemy(3, null, 15, 20, new CheckPoint(Direction.NORTH, new Point(0,10)), 5, null, "Test Guy", new Coordinate(0,0), this);
		actualWave.add(ennemy);
		display.addGraphicalElement(ennemy);
		
	}
	
	public void turn(){
		for(Ennemy e : actualWave){
			e.act();
			display.display();
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

