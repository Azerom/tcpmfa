package fr.tcpmfa.engine;

import java.util.ArrayList;

import fr.tcpmfa.util.Coordinate;

public class Map {
	public Coordinate getCoordStart() {
		return coordStart;
	}

	public Coordinate getCoordEnd() {
		return coordEnd;
	}

	public ArrayList<Point> getPoints() {
		return points;
	}

	public Game getGame() {
		return game;
	}

	public ArrayList<Tower> getTowers() {
		return towers;
	}

	private Coordinate coordStart;
	private Coordinate coordEnd;
	private ArrayList<Point> points;
	private final Game game;
	
	private ArrayList<Tower> towers;
	
	public Map(Game game){
		this.game = game;
	}
	
}
