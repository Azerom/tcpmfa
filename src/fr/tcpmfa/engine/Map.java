package fr.tcpmfa.engine;

import java.util.ArrayList;

import fr.tcpmfa.util.Coordinate;

public class Map {

	private Coordinate coordStart;
	private Coordinate coordEnd;
	private ArrayList<Point> points;
	private final Game game;
	
	private ArrayList<Tower> towers;
	
	public Map(Game game, Coordinate coordEnd, Coordinate coordStart, ArrayList<Point> points){
		this.game = game;
		this.coordEnd = coordEnd;
		this.coordStart = coordStart;
	}
	public Map(Coordinate coordEnd, Coordinate coordStart, ArrayList<Point> points){
		this(null, coordEnd, coordStart, points);
	}
	
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
	
}
