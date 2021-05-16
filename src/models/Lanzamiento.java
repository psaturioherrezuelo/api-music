package models;

public class Lanzamiento {
	
	private Cancion cancion;
	private Artista artista;
	
	public Lanzamiento(Cancion cancion, Artista artista) {
		
		this.cancion = cancion;
		this.artista = artista;
	}

	public Cancion getCancion() {
		return cancion;
	}

	public void setCancion(Cancion cancion) {
		this.cancion = cancion;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}
	
	@Override
	public String toString() {
		return "Cancion: " + cancion.getTitulo() + "\nArtista: " + artista.getNombre() + ".\n";
	}

}
