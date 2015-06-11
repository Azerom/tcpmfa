package fr.tcpmfa.dataBase;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.tcpmfa.engine.Map;
import fr.tcpmfa.engine.CheckPoint;
import fr.tcpmfa.engine.Ennemy;
import fr.tcpmfa.engine.Game;
import fr.tcpmfa.engine.Point;
import fr.tcpmfa.engine.Tower;
import fr.tcpmfa.util.Coordinate;
import fr.tcpmfa.util.Direction;





public class DBTDConnexion {
	private static String url="jdbc:mysql://localhost/projet_java";
	private static String root = "root";
	private static String password = "";
	private java.sql.Connection connection;
	private java.sql.Statement statement;

	public DBTDConnexion(){
		this.connection=null;
		this.statement=null;
	}

	/**
	 * connection BDD 
	 * @return
	 * @author schouteeten
	 */
	public Boolean open() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection(DBTDConnexion.url,DBTDConnexion.root,DBTDConnexion.password);
			this.statement = this.connection.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			e.printStackTrace(); }

		return true;
	}

	public void close(){
		try {
			this.connection.close();
			this.statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	private static Point findPoint(ArrayList<Point> liste,Coordinate chekP){
		for(Point e:liste){
			if(e.isEqual(chekP)){
				return e;
			}
		}
		return null;
	}
	
	public Map getMap(int ID_Map, Game game){
		ResultSet info = null;
		Coordinate startPoint = null;
		Coordinate endPoint = null;
		ArrayList<Point> liste = null;
		ArrayList<Tower> tower = null;


		try {
			info = statement.executeQuery("SELECT * FROM map WHERE N_Map="+ID_Map);
			info.first();
			startPoint=new Coordinate(info.getInt(2), info.getInt(3));
			endPoint = new Coordinate(info.getInt(4), info.getInt(5));

			
			info = statement.executeQuery("SELECT * FROM point WHERE N_Map="+ID_Map);
			liste=new ArrayList<Point> ();
			while(info.next()){
				Point point = new Point(info.getInt(2), info.getInt(3));
				liste.add(point);
			}
			
			
			info = statement.executeQuery("SELECT * FROM `contain` "
										+ "INNER JOIN point AS point1 "
											+ "ON contain.IdPoint = point1.IdPoint "
										+ "INNER JOIN point AS point2 "
											+ "ON contain.IdPoint_1 = point2.IdPoint "
										+ "WHERE point1.N_Map = " + ID_Map);
			while(info.next()){
				
				Coordinate coord1 = new Coordinate(info.getInt(5), info.getInt(6));
				Coordinate coord2 = new Coordinate(info.getInt(9), info.getInt(10));
				
				
				Point P1= findPoint(liste, coord1);
				Point P2= findPoint(liste, coord2);
				
				Direction direction;

				switch(info.getInt(1)){
					case 0 :
						direction = Direction.NORTH;
						break;
					case 1 :
						direction = Direction.EAST;
						break;
					case 2 :
						direction = Direction.SOUTH;
						break;
					case 3 :
						direction = Direction.WEST;
						break;
					default :
						direction = null;
						break;
				}
				
				P1.addCheckPoint(new CheckPoint(direction, P2));
				
			}
			
			info = statement.executeQuery("SELECT * FROM TowerEmplacement WHERE N_Map="+ID_Map);
			tower = new ArrayList<Tower> ();
			while(info.next()){
				Tower emplacement= new Tower(0,null,null, new Coordinate(info.getInt(2),info.getInt(3)),null);
				tower.add(emplacement);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new Map(game, endPoint, startPoint, liste,tower);

	}



	/**
	 * récupère un ennemi en fonction de son ID dans la BDD
	 * @param ID_Ennemy
	 * @author schouteeten
	 */
	public Ennemy getEnnemy(int ID_Ennemy){
		ResultSet info = null;
		int HP = 0;
		int numberDamage = 0;
		int moveSpeed = 0;
		String resistanceType;
		int loot = 0;

		try {
			info = statement.executeQuery("SELECT * FROM Ennemy WHERE IdEnnemy="+ID_Ennemy);
			info.first();
			HP = info.getInt(2);
			numberDamage=info.getInt(3);
			moveSpeed=info.getInt(4);

			resistanceType=info.getString(6);
			loot=info.getInt(7);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Ennemy(moveSpeed, null, loot, HP, null, numberDamage, null, null, null, null);

	}
	/**
	 * méthode servant a sauvegarder
	 */
	public void save(){
		ResultSet info = null;
		try {
			info = statement.executeQuery("INSERT INTO `save`(`SaveNumber`, `Ressources`, `TimeSpend`, `BaseHp`, `Wave`, `N_Map`) VALUES ()");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void getSave( ){
		
		
	}

}
