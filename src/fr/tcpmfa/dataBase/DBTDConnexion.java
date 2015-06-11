package fr.tcpmfa.dataBase;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.tcpmfa.engine.*;
import fr.tcpmfa.util.Coordinate;
import fr.tcpmfa.util.Direction;





public class DBTDConnexion {
	private static String url="jdbc:mysql://localhost/projet_java";
	private static String root = "root";
	private static String password = "";
	private java.sql.Connection connection;
	private static java.sql.Statement statement;

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
/**
 * Déconnection de la BDD
 */
	public void close(){
		try {
			this.connection.close();
			this.statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Permet de lier les différents points entres eux 
	 * afin de les fair correspondre au chemin 
	 * @param liste
	 * @param chekP
	 * @return
	 */
	private static Point findPoint(ArrayList<Point> liste,Coordinate chekP){
		for(Point e:liste){
			if(e.isEqual(chekP)){
				return e;
			}
		}
		return null;
	}
	/**
	 * Permet de réupérer les données lier a la Map
	 * @param ID_Map
	 * @param game
	 * @return
	 */
	public static Map getMap(int ID_Map, Game game){
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
					case 2:
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
				Tower emplacement= new Tower(10,null,null, new Coordinate(info.getInt(2),info.getInt(3)),game,0,30,0,10,0);
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
		return new Ennemy(ID_Ennemy, moveSpeed, null, loot, HP, null, numberDamage, null, null, null, null);

	}
	/**
	 * méthode servant a sauvegarder
	 */
	public void save(Game game){
		ResultSet info =null ;
		int hp=0;
		int ressource = 0;
		int wave = 0;
		int score = 0;
		int N_Map= 0;
		int saveNumber;
		int id_Tower= 0;
		int pointX=0;
		int pointY=0;
		
		
		hp=game.getHp();
		ressource=game.getRessource();
		wave = WaveEnnemy.getCount();
		score=0;
		N_Map = game.getMap().getID_Map();
		try {
			int nbSave = statement.executeUpdate("INSERT INTO `save`(`SaveNumber`, `Ressources`, `TimeSpend`, `BaseHp`, `Wave`, `N_Map`) "
						+ "VALUES ('','"+ ressource+ "','"+ score+"','"+hp+"','"+wave+"','"+N_Map+"')");
			
			
			
			
			for(Tower e : game.getMap().getTowers()){
				pointX=e.getCoord().getX();
				pointY=e.getCoord().getY();
				info=statement.executeQuery("INSERT INTO `towersave`(`IdTowerSave`, `XTower`, `YTower`, `SaveNumber`, `IdTower`) "
					+ "VALUES ('','"+pointX+"','"+pointY+"','"+nbSave+"',"+id_Tower+")");

			}		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * méthode permétant de récuperer une saugarde dans la BDD
	 * @param nbSave
	 * @return 
	 */
	public Game getSave(int nbSave){
		ResultSet info =null ;
		int hp=0;
		int ressource = 0;
		int wave = 0;
		int score = 0;
		int N_Map= 0;
		int saveNumber;
		Map map = null;
		
		try {
			info= statement.executeQuery("SELECT * FROM `save` WHERE SaveNumber="+nbSave);
			info.first();
			hp = info.getInt(4);
			ressource=info.getInt(2);
			score=info.getInt(3);
			wave=info.getInt(5);
			N_Map=info.getInt(6);
			
			map=DBTDConnexion.getMap(N_Map,null);
			info=statement.executeQuery("SELECT * FROM Towersave WHERE SaveNumber="+nbSave);
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return new Game(hp,ressource,wave,map);
	}
	/**
	 * Permet de récuperer les données des tours contenu
	 * dans la base de donnée
	 * @param ID_Tower
	 * @param game
	 * @return
	 */
	public Tower getTower(int ID_Tower,Game game){
		
		ResultSet info = null;
		int id_Tower=0;
		int level = 0;
		String DommageType;
		int HP = 0;
		int numberDamage = 0;
		int cooldown=0;
		int range=0;
		int cost = 0;
		

		try {
			info = statement.executeQuery("SELECT * FROM Tower WHERE IdTower="+ID_Tower);
			info.first();
			id_Tower=info.getInt(1);
			level =info.getInt(2);
			DommageType=info.getString(3);
			HP = info.getInt(4);
			numberDamage=info.getInt(5);
			cooldown=info.getInt(6);
			range=info.getInt(7);
			cost=info.getInt(8);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Tower(numberDamage, null,"", null ,game, level,range,cost,cooldown,id_Tower);
	}
	
	
	public Tower getTower(int level, Type type, Game game){
		ResultSet info = null;
		
		int numberDamage = 0;
		int cooldown=0;
		int range = 0;
		int cost = 0;
		int id_Tower = 0;

		try {
			info = statement.executeQuery("SELECT * FROM Tower WHERE Level="+level + " AND DamageType = \""
					+ type.toString() + "\"");
			info.first();
			id_Tower=info.getInt(1);
			numberDamage=info.getInt(5);
			cooldown=info.getInt(6);
			range=info.getInt(7);
			cost=info.getInt(8);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Tower(numberDamage, type, type.toString() + Integer.toString(level), 
				null ,game, level,range,cost,cooldown, id_Tower);
	}

	}

