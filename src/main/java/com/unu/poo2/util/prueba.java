package com.unu.poo2.util;

import com.unu.poo2.model.Conexion;

public class prueba {
	public static void main(String[] args) {

		Conexion conexion = new Conexion();
		conexion.abrirConexion();
		conexion.cerrarConexion();

	}
}
