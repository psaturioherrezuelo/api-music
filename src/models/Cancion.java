package models;

import java.time.LocalDate;

public class Cancion {
	
	private int id;
	private String titulo, genero;
	private LocalDate lanzamiento;
	private long visualizaciones;
	private float precio;
	private boolean explicito;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public LocalDate getLanzamiento() {
		return lanzamiento;
	}
	public void setLanzamiento(LocalDate lanzamiento) {
		this.lanzamiento = lanzamiento;
	}
	public long getVisualizaciones() {
		return visualizaciones;
	}
	public void setVisualizaciones(long visualizaciones) {
		this.visualizaciones = visualizaciones;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public boolean isExplicito() {
		return explicito;
	}
	public void setExplicito(boolean explicito) {
		this.explicito = explicito;
	}
	
}
