package com.unu.poo2.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	private String url = "jdbc:mysql://localhost/bibliotecapoo2";
	private String user = "root";
	private String pass = "123456";
	protected Connection conexion = null;
	
	public void abrirConexion() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection(url, user, pass);
			if(conexion!=null) {
				System.out.println("Exitosa");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void cerrarConexion() {
		try {
			if(conexion!=null && !conexion.isClosed()) {
				conexion.close();
				System.out.println("Conexion cerrada");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
