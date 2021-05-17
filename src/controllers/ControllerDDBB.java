package controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import models.Artista;
import models.Cancion;
import models.Ceo;
import models.Contrato;
import models.Database;
import models.Discografica;
import models.Lanzamiento;

public class ControllerDDBB {
	
	private Database bd = new Database();
	
	private ResultSet rs = null;
	
	private ResultSet rs(String tabla) throws SQLException {
	
		String consulta = "select * from " + tabla + ";";
		ResultSet rs = ((java.sql.Statement) bd.getStmt()).executeQuery(consulta);
		
		return rs;
		
	}
	
	public void leerLanzamientos(ArrayList<Cancion>listaCanciones, ArrayList<Artista>listaArtistas, ArrayList<Lanzamiento>listaLanzamientos) throws SQLException {
		
		rs = rs("lanzamientos");
		
		while(rs.next()) {
			
			Cancion c = getCancion(rs.getInt("id_cancion"), listaCanciones);
			Artista a = getArtista(rs.getInt("id_artista"), listaArtistas);
			
			if(!c.equals(null) || !a.equals(null)) {
				listaLanzamientos.add(new Lanzamiento(c, a));
			}
			
		}
		
	}

	public void leerContratos(ArrayList<Cancion>listaCanciones, ArrayList<Discografica>listaDiscograficas,ArrayList<Contrato>listaContratos) throws SQLException {
	
	String consulta = "contratos";
	rs = rs(consulta);
	
	while(rs.next()) {
		
		Cancion c = getCancion(rs.getInt("id_cancion"), listaCanciones);
		Discografica d = getDisco(rs.getInt("id_discografica"), listaDiscograficas);
		
		if(!c.equals(null) || !d.equals(null)) {
			listaContratos.add(new Contrato(c, d));
		}
	
	}
	
}

	public void leerCeos(ArrayList<Ceo>listaCeos) throws SQLException {

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

	public void leerDiscograficas(ArrayList<Discografica>listaDiscograficas) throws SQLException {
		
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

	public void leerArtistas(ArrayList<Artista>listaArtistas) throws SQLException {
		
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

	public void leerCanciones(ArrayList<Cancion>listaCanciones) throws SQLException {
		
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

	private Cancion getCancion(int id, ArrayList<Cancion>listaCanciones) {
		
		Cancion get = null;
		
		for(Cancion c : listaCanciones) {
			
			if(c.getId()==id) {
				get = c;
				break;
			}
			
		}
		
		return get;
		
	}
	
	private Discografica getDisco(int id, ArrayList<Discografica>listaDiscograficas) {
		
		Discografica get = null;
		
		for(Discografica d : listaDiscograficas) {
			
			if(d.getId()==id) {
				get = d;
				break;
			}
			
		}
		
		return get;
		
	}
	
	private Artista getArtista(int id, ArrayList<Artista>listaArtistas) {
		
		Artista get = null;
		
		for(Artista a : listaArtistas) {
			
			if(a.getId()==id) {
				get = a;
				break;
			}
			
		}
		
		return get;
		
	}

	public boolean login (String user, String passw) throws SQLException {
		
		boolean cnd = false;
		
		String consulta = "usuarios where usuario ='" + user + "'";
		
		rs = rs(consulta);
			
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
				
		return cnd;
		
	}
	
	public void register(String user, String passw, String nombre, String apellidos, String email, String direccion) throws SQLException, ClassNotFoundException {
		
		PreparedStatement str = null;
		
		bd.getConn().setAutoCommit(false);
		
		
			
//		stmt = conn.createStatement();
//			
//		String consulta = "INSERT INTO usuarios VALUES ('" + user + "',AES_ENCRYPT('" + passw + "','api'));";
//		rs = ((java.sql.Statement) stmt).executeQuery(consulta);
			
			
			
		str = bd.getConn().prepareStatement("INSERT INTO usuarios (usuario,password,nombre,apellidos,email,direccion,fregistro,administrador) VALUES (?,?,?,?,?,?,?,?);");
//		str = conn.prepareStatement("INSERT INTO usuarios VALUES (?,AES_ENCRYPT(?,'api'));");

//		passw = (AES);	
			
		str.setString(1, user);
		str.setString(2, passw);
		str.setString(3, nombre);
		str.setString(4, apellidos);
		str.setString(5, email);
		str.setString(6, direccion);
		str.setString(7, LocalDate.now().toString());
		str.setInt(8, 0);
			
		str.executeUpdate();
		
		bd.getConn().commit();
		
	}
	
	public void open() { // Abrir conexion con la BBDD
		
		bd.conexion();
		
	}
	
	public void close() throws SQLException { // Cerrar Conexion con la BBDD
		
		bd.getConn().close();
		
	}
	
}
