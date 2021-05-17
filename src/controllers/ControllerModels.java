package controllers;

import java.sql.SQLException;
import java.util.ArrayList;

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
	
	private ControllerDDBB bdc = new ControllerDDBB();
	
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
	
	/* ********************************************************************************

					Metodos para buscar e insertar usuarios a la BBDD

	 ******************************************************************************** */
	
	public boolean login (String user, String passw) throws ClassNotFoundException, SQLException {

		bdc.open();
		Boolean cnd = bdc.login(user,passw);
		
		bdc.close();
		
		return cnd;
		
	}
	
	public void register(String user, String passw, String nombre, String apellidos, String email, String direccion) throws ClassNotFoundException, SQLException {
		
		bdc.open();
		bdc.register(user, passw, nombre, apellidos, email, direccion);
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
