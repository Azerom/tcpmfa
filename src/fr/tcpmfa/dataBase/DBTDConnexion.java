package fr.tcpmfa.dataBase;

import java.sql.DriverManager;
import java.sql.SQLException;



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
		
	}

	/*public Map getMap(int){

	}

	public Save getSave(int){

	}

	public */

}
