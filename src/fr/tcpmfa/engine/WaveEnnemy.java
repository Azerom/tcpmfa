package fr.tcpmfa.engine;


import java.util.ArrayList;
import java.util.Iterator;

import fr.tcpmfa.util.Coordinate;
import fr.tcpmfa.util.Time;

/**
 * Represent an ennemy wave
 * 
 *  </br>
 *  All the ennemy is first place in a resserve ArrayList, then they get place on the map once at a time
 * @author Azerom
 *
 */
public class WaveEnnemy extends ArrayList<Ennemy> {

	private static final long serialVersionUID = 3391625254887809314L;

	private static final int NBRENNEMY = 5;

	private static int count;

	private ArrayList<Ennemy> reserve;

	private int countDown;
	
	private Time time;

	public WaveEnnemy(Game game, Point startPoint){
		count++;
		this.time = new Time();
		time.setStartTime();
		this.reserve = new ArrayList<Ennemy>();
		for(int i = 0; i < NBRENNEMY ; i++){

			Ennemy ennemy = Ennemy.generateRandomEnnemy();
			ennemy.setCheckPoint(startPoint.getCheckPoint());
			ennemy.setCoord(new Coordinate(startPoint.getX(), startPoint.getY()));
			ennemy.setGame(game);
			ennemy.setName(ennemy.getName() + "-" + this.reserve.size());
			this.reserve.add(ennemy);
			this.countDown = 0;
			System.out.println("Add to resserve");
		}

	}

	public static int getCount(){
		return count;
	}

	public Time timeBetween(){
		return null;
	}

	/**
	 * Put the wave to life
	 */
	public void act(){
		System.out.println("-------------------\nNew turn\n-------------------------");


		Iterator<Ennemy> it = this.iterator();
		while (it.hasNext()) {
			Ennemy ennemy = it.next();
			ennemy.act();
		}

		if(!(this.reserve.isEmpty())){
			System.out.println("CountDown = " + this.countDown + ", nbr reserve : " + this.reserve.size());
			if(this.reserve.isEmpty())
				System.out.println("Vide !");
			if(this.countDown == 0 ){
				System.out.println("Add from reserve");
				this.add(this.reserve.remove(0));
				this.countDown = 100;
			}
			else
				this.countDown--;
		}
	}

	public static int getNbrennemy() {
		return NBRENNEMY;
	}

}
