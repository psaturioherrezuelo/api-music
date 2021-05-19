package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	
	public void conexionLectura() throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn=DriverManager.getConnection(url, usuario, password);
		stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		
	}

	public java.sql.Statement getStmt() {
		return stmt;
	}
	
	public Connection getConn() {
		return conn;
	}
	
}
