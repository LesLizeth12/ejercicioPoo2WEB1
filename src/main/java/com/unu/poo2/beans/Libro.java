package com.unu.poo2.beans;

public class Libro {
	private int idLibro;
	private String nombre;
	private String existencia;
	private String precio;
	private String descripcion;
	private String autor;
	private String editorial;
	private String genero;
	
	public int getIdLibro() {
		return idLibro;
	}
	public String getNombre() {
		return nombre;
	}
	public String getExistencia() {
		return existencia;
	}
	public String getPrecio() {
		return precio;
	}
	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setExistencia(String existencia) {
		this.existencia = existencia;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public Libro(int idLibro, String nombre, String existencia, String precio,String descripcion,String autor,String editorial,String genero) {
		this.idLibro = idLibro;
		this.nombre = nombre;
		this.existencia = existencia;
		this.precio = precio;
		this.descripcion=descripcion;
		this.autor=autor;
		this.editorial=editorial;
		this.genero=genero;
	}
	public Libro(String nombre, String existencia, String precio,String descripcion,String autor,String editorial,String genero) {
		this.nombre = nombre;
		this.existencia = existencia;
		this.precio = precio;
		this.descripcion=descripcion;
		this.autor=autor;
		this.editorial=editorial;
		this.genero=genero;
	}
	public Libro() {
		this(0,"","","","","","","");
	}
}
