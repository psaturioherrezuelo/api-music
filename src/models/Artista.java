package models;

public class Artista {
	
	private int id;
	private String nombre;
	private long visualizaciones;
	private int tcanciones;
	
	public Artista (int id, String nombre, long visualizaciones, int tcanciones) {
		
		this.id = id;
		this.nombre = nombre;
		this.visualizaciones = visualizaciones;
		this.tcanciones = tcanciones;
	
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public long getVisualizaciones() {
		return visualizaciones;
	}
	public void setVisualizaciones(long visualizaciones) {
		this.visualizaciones = visualizaciones;
	}
	public int getTcanciones() {
		return tcanciones;
	}
	public void setTcanciones(int tcanciones) {
		this.tcanciones = tcanciones;
	}

	@Override
	public String toString() {
		return "Artista: " + id + ". - Artista: " + nombre + "\n"
				+ "Visualizaciones totales: " + visualizaciones + "\n"
				+ "Total Canciones: " + tcanciones;
	}
	

}
