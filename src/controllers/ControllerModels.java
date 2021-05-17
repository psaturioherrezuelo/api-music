package controllers;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import models.Artista;
import models.Cancion;
import models.Ceo;
import models.Contrato;
import models.Discografica;
import models.Lanzamiento;

public class ControllerModels {
	
	private ArrayList<Artista> listaArtistas = new ArrayList<Artista>();
	private ArrayList<Cancion> listaCanciones = new ArrayList<Cancion>();
	private ArrayList<Discografica> listaDiscograficas = new ArrayList<Discografica>();
	private ArrayList<Ceo> listaCeos = new ArrayList<Ceo>();
	
	private ArrayList<Contrato> listaContratos = new ArrayList<Contrato>();
	private ArrayList<Lanzamiento> listaLanzamientos = new ArrayList<Lanzamiento>();
	
	private ControllerDDBB bdc = new ControllerDDBB();
	
	public void cargaModelos() throws ClassNotFoundException {
		
		try {
			
			bdc.open();
			
			bdc.leerCanciones(listaCanciones);
			bdc.leerArtistas(listaArtistas);
			bdc.leerDiscograficas(listaDiscograficas);
			bdc.leerCeos(listaCeos);
			bdc.leerContratos(listaCanciones, listaDiscograficas, listaContratos);
			bdc.leerLanzamientos(listaCanciones, listaArtistas, listaLanzamientos);
			
			bdc.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
//	private Cancion getCancion(int id) {
//		
//		Cancion get = null;
//		
//		for(Cancion c : listaCanciones) {
//			
//			if(c.getId()==id) {
//				get = c;
//				break;
//			}
//			
//		}
//		
//		return get;
//		
//	}
	
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
