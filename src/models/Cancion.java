package models;

import java.time.LocalDate;

/* ************************************************************

					Modelo de Canciones

************************************************************ */

public class Cancion {
	
	private int id;
	private String titulo, genero;
	private LocalDate lanzamiento;
	private long visualizaciones;
	private float precio;
	private boolean explicito;
	
	public Cancion(int id, String titulo, String genero, LocalDate lanzamiento, long visualizaciones, float precio, boolean explicito) {
		
		this.id = id;
		this.titulo = titulo;
		this.genero = genero;
		this.lanzamiento = lanzamiento;
		this.visualizaciones = visualizaciones;
		this.precio = precio;
		this.explicito = explicito;
		
	}
	
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

	@Override
	public String toString() {
		
		String expl;
		
		if(explicito==true) {
			expl = "Si";
		} else {
			expl = "No";
		}
		
		return "Cancion: " + id + ". - " + titulo + "\n"
				+ "Genero: " + genero + "\n"
				+ "Lanzamiento: " + lanzamiento + "\n"
				+ "Visualizaciones: " + visualizaciones + "\n"
				+ "Precio=" + precio + ", Explicito " + expl;
	}
	
}
