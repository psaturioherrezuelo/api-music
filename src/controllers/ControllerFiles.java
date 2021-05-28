package controllers;

public class ControllerFiles {

	private String iconoBlack, iconoBlue, logoBlack, iconoWhite, logoWhite, logoBlue, background;

	public ControllerFiles() {
		
		iconoBlack = "/images/icono-apimusic-black.png";
		iconoBlue = "/images/iconoBlue.png";
		logoBlack = "/images/logo-apimusic-250px-black.png";
		iconoWhite = "/images/";
		logoWhite = "/images/logo-apimusic-250px-white.png";
//		background = "/images/background1.jpg";
		background = "/images/bg-filtrado.png";
		logoBlue = "/images/logo-apimusic-250px-blue.png";
		
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
	
	public String getLogoBlue() {
		return logoBlue;
	}

	public void setLogoBlue(String logoBlue) {
		this.logoBlue = logoBlue;
	}

	public String getIconoBlue() {
		return iconoBlue;
	}

	public void setIconoBlue(String iconoBlue) {
		this.iconoBlue = iconoBlue;
	}
	
}
