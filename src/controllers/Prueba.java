package controllers;

import models.Artista;
import models.Cancion;
import models.Discografica;

public class Prueba {
	
	private Artista artista;
	private Cancion cancion;
	private Discografica disco;
	
	public Prueba () {
		
		artista = null;
		cancion = null;
		disco = null;
		
	}
	
	public Prueba (Artista artista, Cancion cancion, Discografica disco) {
		
		this.artista = artista;
		this.cancion = cancion;
		this.disco = disco;
		
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
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

	public void setDisco(Discografica discografica) {
		this.disco = discografica;
	}

}
