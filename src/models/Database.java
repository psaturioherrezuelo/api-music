package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
	
	public void conexion() {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn=DriverManager.getConnection(url, usuario, password);
			
			stmt = conn.createStatement();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public java.sql.Statement getStmt() {
		return stmt;
	}

//	private void setStmt(java.sql.Statement stmt) {
//		this.stmt = stmt;
//	}
	
	public Connection getConn() {
		return conn;
	}
	
}
