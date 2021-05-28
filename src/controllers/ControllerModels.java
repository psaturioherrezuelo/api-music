package controllers;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.table.DefaultTableModel;

import models.Artista;
import models.Cancion;
import models.Ceo;
import models.Contrato;
import models.Discografica;
import models.Lanzamiento;

/* ************************************************************

			Clase encargada de controlar los modelos

************************************************************ */

public class ControllerModels {
	
	private ArrayList<Artista> listaArtistas = new ArrayList<Artista>();
	private ArrayList<Cancion> listaCanciones = new ArrayList<Cancion>();
	private ArrayList<Discografica> listaDiscograficas = new ArrayList<Discografica>();
	private ArrayList<Ceo> listaCeos = new ArrayList<Ceo>();
	
	private ArrayList<Contrato> listaContratos = new ArrayList<Contrato>();
	private ArrayList<Lanzamiento> listaLanzamientos = new ArrayList<Lanzamiento>();
	
	private String columnas[], datos[][];
	
	private ControllerDDBB bdc = new ControllerDDBB();
	private MD5 encriptador = new MD5();
	
	/* ********************************************************************************

			Metodo para añadir todos los registros de la BBDD a listas de objetos

	 ******************************************************************************** */
	
	public void cargaModelos() throws ClassNotFoundException, SQLException {
		
		bdc.open();
		
		bdc.leerCanciones(listaCanciones);
		bdc.leerArtistas(listaArtistas);
		bdc.leerDiscograficas(listaDiscograficas);
		bdc.leerCeos(listaCeos);
		bdc.leerContratos(listaCanciones, listaDiscograficas, listaContratos);
		bdc.leerLanzamientos(listaCanciones, listaArtistas, listaLanzamientos);
		
		bdc.close();
		
	}
	
	public DefaultTableModel tabla(String consulta) throws ClassNotFoundException, SQLException {
		
		bdc.openOnlyRead();
		columnas = bdc.columnas(consulta);
		datos = bdc.tabla(columnas,consulta);
		
		DefaultTableModel modelo = new DefaultTableModel(datos,columnas);
		bdc.close();
		return modelo;
		
	}
	
	public String[] cancs() throws SQLException, ClassNotFoundException {
		
		bdc.open();
		bdc.leerCanciones(listaCanciones);
		bdc.close();
		String canciones[] = new String[listaCanciones.size()];
		int cont = 0;
		for(Cancion c : listaCanciones) {
			canciones[cont] = c.getTitulo();
			cont++;
		}
		
		return canciones;
	}
	
	public String[] arts() throws SQLException, ClassNotFoundException {
		
		bdc.open();
		bdc.leerArtistas(listaArtistas);
		bdc.close();
		String arts[] = new String[listaArtistas.size()];
		int cont = 0;
		for(Artista a : listaArtistas) {
			arts[cont] = a.getNombre();
			cont++;
		}
		
		return arts;
	}
	
	/* ********************************************************************************

					Metodos para buscar e insertar en la BBDD

	 ******************************************************************************** */
	
	public boolean login (String user, String passw) throws ClassNotFoundException, SQLException {

		bdc.open();
		Boolean cnd = bdc.login(user,encriptador.codificarPass(passw));
		
		bdc.close();
		
		return cnd;
		
	}
	
	public void register(String user, String passw, String nombre, String apellidos, String email, String direccion) throws ClassNotFoundException, SQLException {
		
		bdc.open();
		bdc.register(user,encriptador.codificarPass(passw), nombre, apellidos, email, direccion);
		bdc.close();
		
	}
	
	public void insert(String cancion,String genero,LocalDate lanzamiento,long visualizaciones,float precio,boolean explicito,String artista[],String discografica[]) throws ClassNotFoundException, SQLException {
		
		bdc.open();
		
		bdc.insertar(cancion, genero, lanzamiento, visualizaciones, precio, explicito, artista, discografica);
		bdc.close();
		
	}
	
	public void delete(String consulta,int id1,int id2) throws ClassNotFoundException, SQLException {
		
		bdc.open();
		bdc.borrar(consulta, id1, id2);
		bdc.close();
		
	}
	
	public void update(String consulta, int id1, int id2,String fila[]) throws ClassNotFoundException, SQLException {
		
		bdc.open();
		bdc.actualizar(consulta, id1, id2, columnas, fila);
		bdc.close();
		
	}
	
	
	
	/* ********************************************************************************

			Metodo unicamente para comprobar la carga durante la fase de pruebas

	 ******************************************************************************** */
	
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
