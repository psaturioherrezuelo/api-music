package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.mysql.cj.result.LocalDateTimeValueFactory;
import com.mysql.cj.xdevapi.Statement;

import models.Artista;
import models.Cancion;
import models.Discografica;

public class ControllerApiMusic {
	
	private ArrayList<Artista> listaArtistas = new ArrayList<Artista>();
	private ArrayList<Cancion> listaCanciones = new ArrayList<Cancion>();
	private ArrayList<Discografica> listaDiscograficas = new ArrayList<Discografica>();
	
	private String bd = "apimusic", url = "jdbc:mysql://localhost:3306/" + bd, usuario = "root", password = ""; 
	
	private Connection conn = null;
	private java.sql.Statement stmt = null;
	private ResultSet rs = null;
	
	public void conexion() {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn=DriverManager.getConnection(url, usuario, password);
			
			stmt = conn.createStatement();
			
			leerCanciones();
			leerArtistas();
			leerDiscograficas();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
	private void leerCanciones() throws SQLException {
		
		String consulta = "select * from canciones;";
		
		int id;
		String titulo, genero,parse;
		LocalDate lanzamiento;
		long visualizaciones;
		float precio;
		boolean explicito;
		
		rs = ((java.sql.Statement) stmt).executeQuery(consulta);
		
		while(rs.next()) {
			
			id = rs.getInt("id_cancion");
			titulo = rs.getString("titulo");
			genero = rs.getString("genero");
			parse = rs.getString("lanzamiento");
			lanzamiento = LocalDate.parse(parse);
			visualizaciones = rs.getLong("visualizaciones");
			precio = rs.getFloat("precio");
			explicito = rs.getBoolean("explicito");
			
			listaCanciones.add(new Cancion(id,titulo,genero,lanzamiento,visualizaciones,precio,explicito));
			
		}
		
	}
	
	private void leerArtistas() throws SQLException {
		
		int id,tcanciones;
		String nombre;
		long visualizaciones;
		
		String consulta = "select * from artistas;";
		rs = ((java.sql.Statement) stmt).executeQuery(consulta);
		
		while(rs.next()) {
		
			id = rs.getInt("id_artista");
			nombre = rs.getString("artista");
			visualizaciones = rs.getLong("vis_artista");
			tcanciones = rs.getInt("total_canc_a");
			
			listaArtistas.add(new Artista(id,nombre,visualizaciones,tcanciones));
			
		}
		
	}
	
	private void leerDiscograficas() throws SQLException {
		
		int id,tcanciones;
		String nombre;
		long visualizaciones;
		
		String consulta = "select * from discograficas;";
		rs = ((java.sql.Statement) stmt).executeQuery(consulta);
		
		while(rs.next()) {
			
			id = rs.getInt("id_discografica");
			nombre = rs.getString("discografica");
			visualizaciones = rs.getLong("vis_discografica");
			tcanciones = rs.getInt("total_canc_d");
			
			listaDiscograficas.add(new Discografica(id, nombre, visualizaciones, tcanciones));
			
		}
		
	}
	
	public void imprimir () {
		
		for(Artista a:listaArtistas) {
			
			System.out.println(a + "\n");
			
		}
		
		System.out.println("\n\n\n");
		
		for(Cancion c:listaCanciones) {
			
			System.out.println(c + "\n");
			
		}
		
		System.out.println("\n\n\n");
		
		for(Discografica d : listaDiscograficas) {
			
			System.out.println(d + "\n");
			
		}
		
	}
	
}
