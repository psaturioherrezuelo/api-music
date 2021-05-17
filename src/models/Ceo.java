package models;

/* ************************************************************

					Modelo de Ceos

************************************************************ */

public class Ceo {

	private int id, idDiscografica;
	private String nombre;

	public Ceo(int id, String nombre, int idDiscografica) {
		
		this.id = id;
		this.nombre = nombre;
		this.idDiscografica = idDiscografica;
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdDiscografica() {
		return idDiscografica;
	}

	public void setIdDiscografica(int idDiscografica) {
		this.idDiscografica = idDiscografica;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Ceo: " + id + ". - " + nombre + "\n"
				+ "Dirige la discografica: " + idDiscografica;
	}
	
	
	
}
