package controllers;

public class ControllerFiles {

	private String iconoBlack, logoBlack, iconoWhite, LogoWhite;
	
	public ControllerFiles() {
		
		iconoBlack = "/img/icono-apimusic-black.png";
		logoBlack = "/img/logo-apimusic-250px-black.png";
		iconoWhite = "/img/";
		LogoWhite = "/img/logo-apimusic-250px-white.png";
		
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

	public String getLogoWhite() {
		return LogoWhite;
	}

	public void setLogoWhite(String logoWhite) {
		LogoWhite = logoWhite;
	}
	
}
