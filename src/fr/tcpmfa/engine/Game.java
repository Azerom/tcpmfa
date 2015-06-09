package fr.tcpmfa.engine;

public class Game {

	private int hp;
	//private time
	private int ressource;
//	private display
	private WaveEnnemy actualWave;
	private Map map;
	private static int turn;
	
	public Game(int hp, int ressource, Map map){
		this.hp = hp;
		this.ressource = ressource;
		this.map = map;
		
		actualWave = new WaveEnnemy();
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

