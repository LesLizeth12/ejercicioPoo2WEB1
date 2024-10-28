package com.unu.poo2.beans;

public class Editorial {
	private int idEditorial;
	private String nombre;
	private String contacto;
	private String telefono;
	public int getIdEditorial() {
		return idEditorial;
	}
	public String getNombre() {
		return nombre;
	}
	public String getContacto() {
		return contacto;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setIdEditorial(int idEditorial) {
		this.idEditorial = idEditorial;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	
	public Editorial(int idEditorial, String nombre, String contacto, String telefono) {
		this.idEditorial = idEditorial;
		this.nombre = nombre;
		this.contacto = contacto;
		this.telefono = telefono;
	}
	public Editorial() {
		this(0,"","","");
	}
	
	
	
	
}
