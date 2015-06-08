package fr.tcpmfa.engine;

public class Ennemy extends Element {
	private int moveSpeed;
	private final Type resitance;
	private final int loot;
	private int hp;
	
	private CheckPoint checkPoint;
	
	public Ennemy(int moveSpeed, Type resistance, int loot, int hp, CheckPoint checkpoint){
		this.moveSpeed = moveSpeed;
		this.resitance = resistance;
		this.loot = loot;
		this.hp = hp;
	}
	
	public void move(){
		
	}
	
	public void die(){
		
	}
}
