package fr.tcpmfa.engine;

public class Game {

	private int hp;
	//private time
	private int ressource;
//	private display
	private WaveEnnemy actualWave;
	private Map map;
	
	public Game(){
		
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getRessource() {
		return ressource;
	}

	public void setRessource(int ressource) {
		this.ressource = ressource;
	}
}

