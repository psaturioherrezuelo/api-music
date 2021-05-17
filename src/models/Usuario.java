package models;

import java.time.LocalDate;

public class Usuario {

	private String user, password, nombre, apellidos, email, direccion;
	LocalDate fregistro;
	private boolean admin;
	
	public Usuario() {
		
		user = "";
		password = "";
		nombre = "";
		apellidos = "";
		email = "";
		direccion = "";
		fregistro = LocalDate.now();
		admin = false;

	}
	
	public Usuario(String user, String password) {
		
		this.user = user;
		this.password = password;
		nombre = "";
		apellidos = "";
		email = "";
		direccion = "";
		fregistro = LocalDate.now();
		admin = false;
		
	}
	
	

	public Usuario(String user, String password, String nombre, String apellidos, String email, String direccion) {
		
		this.user = user;
		this.password = password;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.direccion = direccion;
		fregistro = LocalDate.now();
		admin = false;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public LocalDate getFregistro() {
		return fregistro;
	}

	public void setFregistro(LocalDate fregistro) {
		this.fregistro = fregistro;
	}

}
