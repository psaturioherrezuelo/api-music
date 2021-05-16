package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import models.Artista;
import models.Cancion;
import models.Ceo;
import models.Contrato;
import models.Discografica;
import models.Lanzamiento;

public class ControllerApiMusic {
	
	private ArrayList<Artista> listaArtistas = new ArrayList<Artista>();
	private ArrayList<Cancion> listaCanciones = new ArrayList<Cancion>();
	private ArrayList<Discografica> listaDiscograficas = new ArrayList<Discografica>();
	private ArrayList<Ceo> listaCeos = new ArrayList<Ceo>();
	
	private ArrayList<Contrato> listaContratos = new ArrayList<Contrato>();
	private ArrayList<Lanzamiento> listaLanzamientos = new ArrayList<Lanzamiento>();
	
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
			leerCeos();
			leerContratos();
			leerLanzamientos();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

	private void leerCanciones() throws SQLException {
		
		String consulta = "canciones";
		
		int id;
		String titulo, genero,parse;
		LocalDate lanzamiento;
		long visualizaciones;
		float precio;
		boolean explicito;
		
		rs = rs(consulta);
		
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
		
		String consulta = "artistas";
		rs = rs(consulta);
		
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
		
		String consulta = "discograficas";
		rs = rs(consulta);
		
		while(rs.next()) {
			
			id = rs.getInt("id_discografica");
			nombre = rs.getString("discografica");
			visualizaciones = rs.getLong("vis_discografica");
			tcanciones = rs.getInt("total_canc_d");
			
			listaDiscograficas.add(new Discografica(id, nombre, visualizaciones, tcanciones));
			
		}
		
	}
	
	private void leerCeos() throws SQLException {

		int id, idDiscografica;
		String nombre;
		
		String consulta = "ceos";
		rs = rs(consulta);
		
		while(rs.next()) {
			
			id = rs.getInt("id_ceo");
			nombre = rs.getString("ceo");
			idDiscografica = rs.getInt("id_discografica");
			
			listaCeos.add(new Ceo(id,nombre,idDiscografica));
			
		}
	}
	
	private void leerContratos() throws SQLException {
		
		String consulta = "contratos";
		rs = rs(consulta);
		
		while(rs.next()) {
			
//			System.out.println(rs.getInt("id_cancion"));
//			System.out.println(rs.getInt("id_discografica"));
			
			Cancion c = getCancion(rs.getInt("id_cancion"));
			Discografica d = getDisco(rs.getInt("id_discografica"));
			
			if(!c.equals(null) || !d.equals(null)) {
				listaContratos.add(new Contrato(c, d));
			}
		
		}
		
	}
	
	private void leerLanzamientos() throws SQLException {
		
		rs = rs("lanzamientos");
		
		while(rs.next()) {
			
			Cancion c = getCancion(rs.getInt("id_cancion"));
			Artista a = getArtista(rs.getInt("id_artista"));
			
			if(!c.equals(null) || !a.equals(null)) {
				listaLanzamientos.add(new Lanzamiento(c, a));
			}
			
		}
		
	}
	
	private ResultSet rs(String tabla) throws SQLException {
		
		String consulta = "select * from " + tabla + ";";
		ResultSet rs = ((java.sql.Statement) stmt).executeQuery(consulta);
		
		return rs;
		
	}
	
	private Cancion getCancion(int id) {
		
		Cancion get = null;
		
		for(Cancion c : listaCanciones) {
			
			if(c.getId()==id) {
				get = c;
				break;
			}
			
		}
		
		return get;
		
	}
	
	private Discografica getDisco(int id) {
		
		Discografica get = null;
		
		for(Discografica d : listaDiscograficas) {
			
			if(d.getId()==id) {
				get = d;
				break;
			}
			
		}
		
		return get;
		
	}
	
	private Artista getArtista(int id) {
		
		Artista get = null;
		
		for(Artista a : listaArtistas) {
			
			if(a.getId()==id) {
				get = a;
				break;
			}
			
		}
		
		return get;
		
	}
	
	public boolean login (String user, String passw) {
		
		boolean cnd = false;
		
		String consulta = "select * from usuarios where usuario='" + user + "';";

		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn=DriverManager.getConnection(url, usuario, password);
			
			stmt = conn.createStatement();
			
			rs = ((java.sql.Statement) stmt).executeQuery(consulta);
			
			while(rs.next()) {
				
				if(rs.getString("usuario").equalsIgnoreCase(user)) {
					
					if(rs.getString("password").equals(passw)) {
						
						cnd = true;
						
					} else {
						
						cnd = false;
						
					}
					
				} else {
					
					cnd = false;
					
				}
				
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cnd;
		
	}
	
	public void register(String user, String passw) {
		
		PreparedStatement str = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn=DriverManager.getConnection(url, usuario, password);
			conn.setAutoCommit(false);
			
//			stmt = conn.createStatement();
//			
//			String consulta = "INSERT INTO usuarios VALUES ('" + user + "',AES_ENCRYPT('" + passw + "','api'));";
//			rs = ((java.sql.Statement) stmt).executeQuery(consulta);
			
			
			str = conn.prepareStatement("INSERT INTO usuarios (usuario,password,email,fregistro) VALUES (?,?,'prueba@prueba.es',?);");
//			str = conn.prepareStatement("INSERT INTO usuarios VALUES (?,AES_ENCRYPT(?,'api'));");

//			passw = (AES);	
			
			str.setString(1, user);
			str.setString(2, passw);
			str.setString(3, LocalDate.now().toString());
		
			
			str.executeUpdate();
			conn.commit();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
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
		
		System.out.println("\n\n\n");
		
		for (Ceo ceo : listaCeos) {
			
			System.out.println(ceo + "\n");
			
		}
		
		for(Contrato c : listaContratos) {
			
			System.out.println(c);
			
		}
		
		for(Lanzamiento l : listaLanzamientos) {
			System.out.println(l);
		}
		
	}
	
}
