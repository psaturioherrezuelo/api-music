package models;

public class Discografica {
	
	private int id;
	private String discografica;
	private long visualizaciones;
	private int tcanciones;
	
	public Discografica(int id, String discografica, long visualizaciones, int tcanciones) {
		
		this.id = id;
		this.discografica = discografica;
		this.visualizaciones = visualizaciones;
		this.tcanciones = tcanciones;
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDiscografica() {
		return discografica;
	}
	public void setDiscografica(String discografica) {
		this.discografica = discografica;
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
		return "Discografica: " + id + ". - " + discografica + "\n"
				+ "Visualizaciones totales: " + visualizaciones + "\n"
				+ "Total canciones: " + tcanciones;
	}
	

}
