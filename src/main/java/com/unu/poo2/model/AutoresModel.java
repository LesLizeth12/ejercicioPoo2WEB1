package com.unu.poo2.model;

import java.util.ArrayList;
import java.util.List;

import com.unu.poo2.beans.Autor;

public class AutoresModel {
public List<Autor> listarAutores(){
		
		ArrayList<Autor> autores=new ArrayList<>();
		
		autores.add(new Autor(1,"Garcia Marquez","Colombia"));
		autores.add(new Autor(2, "Vargas Losa", "Peru"));
		autores.add(new Autor(3, "Allende", "Chilena"));
		
		return autores;
		
	}
}