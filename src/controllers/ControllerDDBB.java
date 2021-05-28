package controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

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
		
	}
	
	/* ************************************************************
	  
		 ResultSet general para todos los metodos

	 ************************************************************ */
	
	private ResultSet rs(String tabla) throws SQLException {
	
		String consulta;
		
		tabla = tabla.toLowerCase();
		
		if(tabla.equalsIgnoreCase("Relacionar")) {
			
			consulta = "select id_cancion,titulo,id_artista,artista from canciones natural join lanzamientos natural join artistas order by id_cancion;";
			
		} else if(tabla.equalsIgnoreCase("Contratos")) {
			
			consulta = "select id_cancion,titulo,id_discografica,discografica from canciones natural join contratos natural join discograficas order by id_cancion;";
			
		} else if (tabla.equalsIgnoreCase("Ceos")){
			
			consulta = "select id_ceo,ceo,id_discografica,discografica from ceos natural join discograficas;";
			
		} else {
			
			consulta = "select * from " + tabla + ";";
		
		}
		
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
	
	
	
	public String[] columnas(String consulta) throws SQLException {
		
		rs = rs(consulta);
		
		String [] columnas = new String[rs.getMetaData().getColumnCount()];
		
		for (int i=0; i<columnas.length; i++) {
			
			columnas[i] = rs.getMetaData().getColumnName(i+1);
		
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
			
		str = bd.getConn().prepareStatement("INSERT INTO usuarios (usuario,password,nombre,apellidos,email,direccion,fregistro,administrador) VALUES (?,?,?,?,?,?,?,?);");	
			
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
	  
		Insertar en la BBDD

	 ************************************************************ */
	
	public void insertar(String cancion,String genero,LocalDate lanzamiento,long visualizaciones,float precio,boolean explicito,String artista[],String discografica[]) throws SQLException {
		
		PreparedStatement str = null;
		bd.getConn().setAutoCommit(false);
		
		str = bd.getConn().prepareStatement("INSERT INTO canciones (titulo,genero,lanzamiento,visualizaciones,precio,explicito) VALUES (?,?,?,?,?,?);");
		str.setString(1, cancion);
		str.setString(2, genero);
		str.setString(3, lanzamiento + "");
		str.setLong(4, visualizaciones);
		str.setFloat(5, precio);
		str.setBoolean(6, explicito);
		str.executeUpdate();
		
		for(String a : artista) {
			
			str = bd.getConn().prepareStatement("call comprobar_artista(?);");
			str.setString(1, a);
			str.executeUpdate();
			str = bd.getConn().prepareStatement("call ins_lanzamientos(?,?);");
			str.setString(1, cancion);
			str.setString(2, a);
			str.executeUpdate();
			
		}
		
		for(String d : discografica) {
			
			str = bd.getConn().prepareStatement("call comprobar_discografica(?);");
			str.setString(1, d);
			str.executeUpdate();
			str = bd.getConn().prepareStatement("call ins_contratos(?,?);");
			str.setString(1, cancion);
			str.setString(2, d);
			System.out.println(d);
			str.executeUpdate();
			
		}
		
		bd.getConn().commit();
		
	}
	
	public void insertar(String tabla, String a, String b) throws SQLException {
		
		PreparedStatement str = null;
		bd.getConn().setAutoCommit(false);
		str = bd.getConn().prepareStatement("call ins_"+ tabla+"(?,?);");
		str.setString(1, a);
		str.setString(2, b);
		str.executeUpdate();
		System.out.println(str);
		bd.getConn().commit();
		
	}
	
	public void borrar(String consulta,int id1,int id2) throws SQLException {
		
		PreparedStatement str = null;
		bd.getConn().setAutoCommit(false);
		String campo = "";
		consulta = consulta.toLowerCase();
		
		if(consulta.equalsIgnoreCase("Canciones")) {
			campo = "id_cancion";
		} else if(consulta.equalsIgnoreCase("Artistas")) {
			campo = "id_artista";
		} else if(consulta.equalsIgnoreCase("Discograficas")) {
			campo = "id_discografica";
		} else if(consulta.equalsIgnoreCase("Ceos")) {
			campo = "id_ceo";
		} else if(consulta.equalsIgnoreCase("Relacionar")) {
			campo = "id_cancion = ? AND id_artista";
		} else if(consulta.equalsIgnoreCase("Contratos")) {
			campo = "id_cancion = ? AND id_discografica";
		} 
		
		str = bd.getConn().prepareStatement("DELETE FROM " + consulta + " WHERE " + campo + " = ?;");
		
		if(consulta.equalsIgnoreCase("Relacionar") || consulta.equalsIgnoreCase("Contratos")) {
			
			str.setInt(1, id1);
			str.setInt(2, id2);
			
		} else {
			
			str.setInt(1, id1);
			
		}
		
		str.executeUpdate();
		
		bd.getConn().commit();
		
	}
	
	public void actualizar(String tabla, int id1, int id2,String columnas[],String fila[]) throws SQLException {

		PreparedStatement str = null;
		bd.getConn().setAutoCommit(false);
		String set = "SET ",campo = "", consulta="",update="UPDATE ";
		
		tabla = tabla.toLowerCase();
		update += tabla + " ";
		
		if(tabla.equalsIgnoreCase("Canciones")) {
			
			consulta += columnas[1] + " = ?," + columnas[2] + "= ?," + columnas[3] + "= ?," + columnas[4] + "= ?," + columnas[5] + "=?," + columnas[6] + "=?";
			campo += "id_cancion = " + id1 + ";";
		
		} else if(tabla.equalsIgnoreCase("Artistas")) {
		
			consulta += columnas[1] + " = ?";
			campo = "id_artista = " + id1 + ";";
		
		} else if(tabla.equalsIgnoreCase("Discograficas")) {
		
			consulta += columnas[1] + " = ?";
			campo = "id_discografica = " + id1 + ";";
		
		} else if(tabla.equalsIgnoreCase("Ceos")) {
		
			consulta += columnas[1] + " = ?";
			campo = "id_ceo = " + id1 + ";";
		
		} else if(tabla.equalsIgnoreCase("Relacionar")) {
		
			consulta += columnas[0] + " = ?," + columnas[2] + " =?";
			campo = "id_cancion = " + id1 + " AND id_artista = " + id2 + ";";
		
		} else if(tabla.equalsIgnoreCase("Contratos")) {
		
			consulta += columnas[0] + " = ?," + columnas[2] + " =?";
			campo = "id_cancion = " + id1 + " AND id_discografica = " + id2 + ";";
		
		} 
		
		str = bd.getConn().prepareStatement(update + set + consulta + " WHERE " + campo);
		
		if(tabla.equalsIgnoreCase("Canciones")) {
		
			str.setString(1, fila[1]);
			str.setString(2, fila[2]);
			str.setString(3, fila[3]);
			str.setLong(4, Long.parseLong(fila[4]));
			str.setFloat(5, Float.parseFloat(fila[5]));
			
			if(fila[6].equals("1")) {
				str.setBoolean(6, true);	
			} else {
				str.setBoolean(6, false);
			}
			
			
		} else if(tabla.equalsIgnoreCase("Artistas") || tabla.equalsIgnoreCase("Discograficas") || tabla.equalsIgnoreCase("ceos")) {
			
			str.setString(1, fila[1]);
			
		} else if(tabla.equalsIgnoreCase("Relacionar") || tabla.equalsIgnoreCase("Contratos")) {
			//Arreglar esto
			str.setInt(1, Integer.parseInt(fila[0]));
			str.setInt(2, Integer.parseInt(fila[2]));
		
		} 
		
//		System.out.println(str);
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
		
		bd.getStmt().close();
		bd.getConn().close();
		
	}

	
}
