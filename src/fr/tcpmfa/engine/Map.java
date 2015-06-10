package fr.tcpmfa.engine;

import java.util.ArrayList;

import fr.tcpmfa.util.Coordinate;

/**
 * Représente la map de jeu, avec les tours et les chemins
 * @author Azerom
 *
 */
public class Map {

	/**
	 * Emplacement de départ des monstres
	 */
	private Coordinate coordStart;
	/**
	 * Fin des chemins
	 */
	private Coordinate coordEnd;
	/**
	 * Listes des points de navigations formant le chemin
	 */
	private ArrayList<Point> points;
	/**
	 * Partie liée a cette map
	 */
	private final Game game;
	
	/**
	 * Liste des tours présentent sur la map
	 */
	private ArrayList<Tower> towers;
	
	/**
	 * Constructeur complet de la map
	 * @param game : Partie lié
	 * @param coordEnd 
	 * @param coordStart
	 * @param points: Points de navigations
	 */
	public Map(Game game, Coordinate coordEnd, Coordinate coordStart, ArrayList<Point> points, ArrayList<Tower> towers){
		this.game = game;
		this.coordEnd = coordEnd;
		this.coordStart = coordStart;
		this.points = points;

//		this.towers= towers;

		
		//Test code remove ASAP
		this.towers = new ArrayList<Tower>();
		this.towers.add(new Tower(1, null, "Tour", new Coordinate(80, 80), game));
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
	
	public Point getStartPoint(){
		for( Point e : points){
			if(e.isEqual(coordStart))
				return e;
		}
		return null;
	}
	
}
