package com.unu.poo2.model;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.unu.poo2.beans.Autor;

public class AutoresModel extends Conexion{
	
	CallableStatement cs;
	ResultSet rs;
	
	public List<Autor> listarAutores(){
		
		try {
			List<Autor> lista = new ArrayList<>();
			String sql = "CALL sp_listarAutor()";
			this.abrirConexion();
			cs = conexion.prepareCall(sql);
			rs = cs.executeQuery();
			while(rs.next()) {
				Autor autor = new Autor();
				autor.setIdAutor(rs.getInt("idAutor"));
				autor.setNombre(rs.getString("nombre"));
				autor.setNacionalidad(rs.getString("nacionalidad"));
				lista.add(autor);
			}
			
			this.cerrarConexion();
			return lista;
		} catch (Exception e) {
			this.cerrarConexion();
			return null;
		}
		
		/*ArrayList<Autor> autores=new ArrayList<>();
		
		autores.add(new Autor(1,"Garcia Marquez","Colombia"));
		autores.add(new Autor(2, "Vargas Losa", "Peru"));
		autores.add(new Autor(3, "Allende", "Chilena"));
		
		return autores;*/
		
	}
}
