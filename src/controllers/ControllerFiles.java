package controllers;

public class ControllerFiles {

	private String iconoBlack, logoBlack, iconoWhite, logoWhite, background;
	
	public ControllerFiles() {
		
		iconoBlack = "/img/icono-apimusic-black.png";
		logoBlack = "/img/logo-apimusic-250px-black.png";
		iconoWhite = "/img/";
		logoWhite = "/img/logo-apimusic-250px-white.png";
		background = "/img/background1.jpg";
		
	}

	public String getIconoBlack() {
		return iconoBlack;
	}

	public void setIconoBlack(String icono) {
		this.iconoBlack = icono;
	}

	public String getLogoBlack() {
		return logoBlack;
	}

	public void setLogoBlack(String logo) {
		this.logoBlack = logo;
	}

	public String getIconoWhite() {
		return iconoWhite;
	}

	public void setIconoWhite(String iconoWhite) {
		this.iconoWhite = iconoWhite;
	}

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public String getLogoWhite() {
		return logoWhite;
	}

	public void setLogoWhite(String logoWhite) {
		this.logoWhite = logoWhite;
	}
	
}