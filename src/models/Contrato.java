package models;

public class Contrato {

	private Cancion cancion;
	private Discografica disco;
	
	public Contrato(Cancion cancion, Discografica disco) {
		
		this.cancion=cancion;
		this.disco=disco;
		
	}

	public Cancion getCancion() {
		return cancion;
	}

	public void setCancion(Cancion cancion) {
		this.cancion = cancion;
	}

	public Discografica getDisco() {
		return disco;
	}

	public void setDisco(Discografica disco) {
		this.disco = disco;
	}

	@Override
	public String toString() {
		return "Cancion: " + cancion.getTitulo() + "\nDiscografica: " + disco.getDiscografica() + ".\n";
	}
	
	
	
}
