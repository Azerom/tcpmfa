package fr.tcpmfa.engine;

import java.sql.Time;
import java.util.ArrayList;

import fr.tcpmfa.util.*;

public class WaveEnnemy extends ArrayList<Ennemy> {

	private static final long serialVersionUID = 3391625254887809314L;
	
	private static int count;
	
	public WaveEnnemy(Game game){
		count++;
		//Test code : remove ASAP !
		//------------------------
		this.add(new Ennemy(3, null, 15, 20, new CheckPoint(Direction.NORTH, new Point(0,10)), 5, null, "Test Guy", new Coordinate(0,0), game));
	}
	
	public int getCount(){
		return count;
	}
	
	public Time timeBetween(){
		return null;
	}

}
