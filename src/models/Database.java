package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/* ************************************************************

				Modelo de la Base de datos

************************************************************ */

public class Database {

	private String bd, url, usuario, password; 
	
	private Connection conn;
	private java.sql.Statement stmt;
	
	public Database() {
		
		bd = "apimusic";
		url = "jdbc:mysql://localhost:3306/" + bd;
		usuario = "root";
		password = "";
		
	}
	
	/* ************************************************************
	  
	 		Metodo encargado de conectar con la base de datos

	 ************************************************************ */
	
	public void conexion() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn=DriverManager.getConnection(url, usuario, password);
		stmt = conn.createStatement();
		
	}

	public java.sql.Statement getStmt() {
		return stmt;
	}
	
	public Connection getConn() {
		return conn;
	}
	
}
