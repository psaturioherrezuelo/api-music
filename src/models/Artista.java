package models;

public class Artista {
	
	private int id;
	private String nombre;
	private long visualizaciones;
	
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

}
