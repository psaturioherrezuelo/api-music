package models;

public class Usuario {

	private String user, password;
	private boolean admin;
	
	public Usuario() {
		
		user = null;
		password = null;
		admin = false;

	}
	
	public Usuario(String user, String password, Boolean admin) {
		
		this.user = user;
		this.password = password;
		this.admin = admin;
		
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

}
