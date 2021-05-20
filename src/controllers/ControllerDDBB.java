package controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import models.Artista;
import models.Cancion;
import models.Ceo;
import models.Contrato;
import models.Database;
import models.Discografica;
import models.Lanzamiento;


/* ************************************************************

		Clase encargada de controlar la BBDD

************************************************************ */

public class ControllerDDBB {
	
	private Database bd;
	private ResultSet rs;
	
	public ControllerDDBB() {
		
		bd = new Database();
		rs = null;
		
	}
	
	/* ************************************************************
	  
		 ResultSet general para todos los metodos

	 ************************************************************ */
	
	private ResultSet rs(String tabla) throws SQLException {
	
		String consulta = "select * from " + tabla + ";";
		rs = ((java.sql.Statement) bd.getStmt()).executeQuery(consulta);
		
		return rs;
		
	}
	
	/* ************************************************************
	  
	  		Metodos de carga desde la BBDD a los modelos
	  
	 ************************************************************ */
	
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
	
	rs = rs("contratos");
	
	while(rs.next()) {
		
		Cancion c = getCancion(rs.getInt("id_cancion"), listaCanciones);
		Discografica d = getDisco(rs.getInt("id_discografica"), listaDiscograficas);
		
		if(!c.equals(null) || !d.equals(null)) {
			listaContratos.add(new Contrato(c, d));
		}
	
	}
	
}

	public void leerCeos(ArrayList<Ceo>listaCeos) throws SQLException {
		
		rs = rs("ceos");
		
		while(rs.next()) {
			
			listaCeos.add(new Ceo(rs.getInt("id_ceo"),rs.getString("ceo"),rs.getInt("id_discografica")));
			
		}
		
	}

	public void leerDiscograficas(ArrayList<Discografica>listaDiscograficas) throws SQLException {
		
		rs = rs("discograficas");
		
		while(rs.next()) {
			
			listaDiscograficas.add(new Discografica(rs.getInt("id_discografica"), rs.getString("discografica"), rs.getLong("vis_discografica"), rs.getInt("total_canc_d")));
			
		}
		
	}

	public void leerArtistas(ArrayList<Artista>listaArtistas) throws SQLException {
		
		rs = rs("artistas");
		
		while(rs.next()) {
			
			listaArtistas.add(new Artista(rs.getInt("id_artista"), rs.getString("artista"), rs.getLong("vis_artista"), rs.getInt("total_canc_a")));
			
		}
		
	}

	public void leerCanciones(ArrayList<Cancion>listaCanciones) throws SQLException {
		
		rs = rs("canciones");
		
		while(rs.next()) {
			
			listaCanciones.add(new Cancion(rs.getInt("id_cancion"), rs.getString("titulo"), rs.getString("genero"), LocalDate.parse(rs.getString("lanzamiento")),
					rs.getLong("visualizaciones"), rs.getFloat("precio"), rs.getBoolean("explicito")));
			
		}
		
	}
	
	/* ************************************************************
	  
		Metodos de carga desde la BBDD a las tablas

	 ************************************************************ */
	
	public void tablaCanciones(String columnas[], String tabla[][]) throws SQLException, ClassNotFoundException {
		
		int pos=0;
		Statement stmt = bd.conexionLectura();
		
		rs = rs("canciones");
		
		columnas = new String[rs.getMetaData().getColumnCount()];
		
		for (int i=0; i<columnas.length; i++) {
			
			columnas[i] = rs.getMetaData().getColumnName(i+1);
			System.out.println(columnas[i]);
		}
		
		rs.last();
		
		tabla = new String [rs.getRow()][columnas.length];
		
		rs.beforeFirst();
		
		while (rs.next()) {
			
			for (int i=0; i<columnas.length; i++) {
			
				tabla[pos][i] = rs.getString(i+1);
			
			}
			
			pos++;
		
		}
		
	}
	
	public String[] columnas(String consulta) throws SQLException {
		
		rs = rs(consulta);
		
		String [] columnas = new String[rs.getMetaData().getColumnCount()];
		
		for (int i=0; i<columnas.length; i++) {
			
			columnas[i] = rs.getMetaData().getColumnName(i+1);
//			System.out.println(columnas[i]);
		
		}
		
		return columnas;
		
	}
	
	public String[][] tabla(String columnas[], String consulta) throws SQLException, ClassNotFoundException {
		
		Statement stmt = bd.conexionLectura();
		
		rs = rs(consulta);

		rs.last();
		
		String tabla [][] = new String [rs.getRow()][columnas.length];
		
		rs.beforeFirst();
		
		int pos=0;
		
		while (rs.next()) {
			
			for (int i=0; i<columnas.length; i++) {
			
				tabla[pos][i] = rs.getString(i+1);
			
			}
			System.out.println(Arrays.toString(tabla[pos]));
			pos++;
		
		}
		return tabla;
				
	}

	/* ***********************************************************************************
	  
		Metodos de Busqueda de Objetos con retorno en las tablas de interrelacion

	 *********************************************************************************** */
	
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
	
	/* ************************************************************
	  
		Metodos de login y register comunicando con la BBDD

	 ************************************************************ */

	public boolean login (String user, String passw) throws SQLException {
		
		boolean cnd = false;
		
		rs = rs("usuarios where usuario ='" + user + "'");
			
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
	
	/* ************************************************************
	  
		Conexion y cierre de la BBDD

	 ************************************************************ */
	
	public void open() throws SQLException, ClassNotFoundException { // Abrir conexion con la BBDD
		
		bd.conexion();
		
	}
	
	public void openOnlyRead() throws ClassNotFoundException, SQLException {
		
		bd.conexion();
		
	}
	
	public void close() throws SQLException { // Cerrar Conexion con la BBDD
		
		rs.close();
		bd.getStmt().close();
		bd.getConn().close();
		
	}
	
}
