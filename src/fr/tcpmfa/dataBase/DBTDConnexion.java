package fr.tcpmfa.dataBase;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.tcpmfa.engine.Point;
import fr.tcpmfa.engine.Map;
import fr.tcpmfa.util.Coordinate;





public class DBTDConnexion {
	private static String url="jdbc:mysql://localhost/DBTDJava";
	private static String root = "root";
	private static String password = "";
	private java.sql.Connection connection;
	private java.sql.Statement statement;

	public DBTDConnexion(){
		this.connection=null;
		this.statement=null;
	}

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
		ArrayList<Point> point ;
		
		
		try {
			info = statement.executeQuery("SELECT * FROM map WHERE N_Map="+ID_Map);

			info.first();
			startPoint=new Coordinate(info.getInt(2), info.getInt(3));
			endPoint = new Coordinate(info.getInt(4), info.getInt(5));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}



}
