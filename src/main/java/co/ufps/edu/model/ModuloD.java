package co.ufps.edu.model;

public class ModuloD {

	private int id;
	private String actividad;
	private String localidad;
	private String sabor;
	
	
	public ModuloD() {
	}


	public ModuloD(int id, String actividad, String localidad, String sabor) {
		super();
		this.id = id;
		this.actividad = actividad;
		this.localidad = localidad;
		this.sabor = sabor;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getActividad() {
		return actividad;
	}


	public void setActividad(String actividad) {
		this.actividad = actividad;
	}


	public String getLocalidad() {
		return localidad;
	}


	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}


	public String getSabor() {
		return sabor;
	}


	public void setSabor(String sabor) {
		this.sabor = sabor;
	}
	
	
	
}
