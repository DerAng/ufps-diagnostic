package co.ufps.edu.model;

public class ModuloC {

	private int id;
	private String sobrenombre;
	private String email;
	private int cantidad;
	
	
	public ModuloC() {
		
	}
	
	public ModuloC(int id, String sobrenombre, String email, int cantidad) {
		this.id = id;
		this.sobrenombre=sobrenombre;
		this.email=email;
		this.cantidad=cantidad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSobrenombre() {
		return sobrenombre;
	}

	public void setSobrenombre(String sobrenombre) {
		this.sobrenombre = sobrenombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	
	
	
	
}
