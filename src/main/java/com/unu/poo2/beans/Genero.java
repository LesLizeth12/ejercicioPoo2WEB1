package com.unu.poo2.beans;

public class Genero {
	private int idGenero;
	private String descripcion;
	private String nombre;
	public int getIdGenero() {
		return idGenero;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setIdGenero(int idGenero) {
		this.idGenero = idGenero;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Genero() {
		this (0,"","");
	}
	public Genero(int idGenero, String nombre, String descripcion) {
		this.idGenero = idGenero;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
}
