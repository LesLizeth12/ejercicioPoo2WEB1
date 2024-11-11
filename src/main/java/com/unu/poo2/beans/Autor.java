package com.unu.poo2.beans;

public class Autor {
	private int idAutor;
	private String nacionalidad;
	private String nombre;
	public int getIdAutor() {
		return idAutor;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Autor() {
		this (0,"","");
	}
	public Autor(int idAutor, String nombre, String nacionalidad) {
		this.idAutor = idAutor;
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
	}
}
