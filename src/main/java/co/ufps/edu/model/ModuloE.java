package co.ufps.edu.model;

public class ModuloE {
	
	private int id;
	private String nombre;
	private int gramaje;
	private String descripcion;
	
	
	public ModuloE() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ModuloE(int id, String nombre, int gramaje, String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.gramaje = gramaje;
		this.descripcion = descripcion;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getGramaje() {
		return gramaje;
	}


	public void setGramaje(int gramaje) {
		this.gramaje = gramaje;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	

}
