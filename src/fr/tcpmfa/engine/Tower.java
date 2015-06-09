package fr.tcpmfa.engine;

public class Tower extends Element {
	private final int cost;
	private final Type damageType;
	private int level;
	private int range;
	
	public Tower(){
		this.cost = 0;
		this.damageType = null;
	}
}
