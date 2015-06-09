package fr.tcpmfa.engine;

import java.sql.Time;
import java.util.ArrayList;

public class WaveEnnemy extends ArrayList<Ennemy> {

	private static final long serialVersionUID = 3391625254887809314L;
	
	private static int count;
	
	public WaveEnnemy(){
		count++;
	}
	
	public int getCount(){
		return count;
	}
	
	public Time timeBetween(){
		return null;
	}

}
