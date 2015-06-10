package fr.tcpmfa.dataBase;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.tcpmfa.engine.Ennemy;
import fr.tcpmfa.engine.Point;
import fr.tcpmfa.engine.Map;
import fr.tcpmfa.util.Coordinate;





public class DBTDConnexion {
	private static String url="jdbc:mysql://10.162.129.54/projet_java";
	private static String root = "User";
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
	public void getMap(int ID_Map){
		ResultSet info = null;
		Coordinate startPoint;
		Coordinate endPoint;
		ArrayList<Point> liste ;


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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
			switch(ID_Ennemy){ 
			case 1:
				info = statement.executeQuery("SELECT * FROM Ennemy WHERE IdEnnemy="+ID_Ennemy);
				HP = info.getInt(2);
				numberDamage=info.getInt(3);
				moveSpeed=info.getInt(4);
				
				resistanceType=info.getString(6);
				loot=info.getInt(7);
				break;
			case 2:
				info = statement.executeQuery("SELECT * FROM Ennemy WHERE IdEnnemy="+ID_Ennemy);
				HP = info.getInt(2);
				numberDamage=info.getInt(3);
				moveSpeed=info.getInt(4);
				
				resistanceType=info.getString(6);
				loot=info.getInt(7);
				break;
			case 3:
				info = statement.executeQuery("SELECT * FROM Ennemy WHERE IdEnnemy="+ID_Ennemy);
				HP = info.getInt(2);
				numberDamage=info.getInt(3);
				moveSpeed=info.getInt(4);
				
				resistanceType=info.getString(6);
				loot=info.getInt(7);
				break;
			case 4:
				info = statement.executeQuery("SELECT * FROM Ennemy WHERE IdEnnemy="+ID_Ennemy);
				HP = info.getInt(2);
				numberDamage=info.getInt(3);
				moveSpeed=info.getInt(4);
				
				resistanceType=info.getString(6);
				loot=info.getInt(7);
				break;
			case 5:
				info = statement.executeQuery("SELECT * FROM Ennemy WHERE IdEnnemy="+ID_Ennemy);
				HP = info.getInt(2);
				numberDamage=info.getInt(3);
				moveSpeed=info.getInt(4);
				
				resistanceType=info.getString(6);
				loot=info.getInt(7);
				break;
			default:
				System.out.println("erreur");

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Ennemy(moveSpeed, null, loot, HP, null, numberDamage, null, null, null, null);

	}



}
