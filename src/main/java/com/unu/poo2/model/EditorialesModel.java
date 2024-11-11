package com.unu.poo2.model;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.unu.poo2.beans.Editorial;

public class EditorialesModel extends Conexion{

	CallableStatement cs;
	ResultSet rs;
	public List<Editorial> listarEditoriales() {

		try {
			List<Editorial> lista = new ArrayList<>();
			String sql = "CALL sp_listarEditorial()";
			this.abrirConexion();
			cs = conexion.prepareCall(sql);
			rs = cs.executeQuery();
			while (rs.next()) {
				Editorial editorial = new Editorial();
				editorial.setIdEditorial(rs.getInt("ideditorial"));
				editorial.setNombre(rs.getString("nombre"));
				editorial.setContacto(rs.getString("contacto"));
				editorial.setTelefono(rs.getString("telefono"));
				lista.add(editorial);
			}
			this.cerrarConexion();
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
			this.cerrarConexion();
			return null;
		}
	}

	public int insertarEditorial(Editorial editorial) throws SQLException {
		try {
			int filasAfectadas = 0;
			String sql = "CALL sp_insertarEditorial(?,?,?)";
			this.abrirConexion();
			cs = conexion.prepareCall(sql);
			cs.setString(1, editorial.getNombre());
			cs.setString(2, editorial.getContacto());
			cs.setString(3, editorial.getTelefono());
			filasAfectadas = cs.executeUpdate();
			this.cerrarConexion();
			return filasAfectadas;
		} catch (Exception e) {
			this.cerrarConexion();
			return 0;
		}
	}

	public Editorial obtenerEditorial(int ideditorial) {
		Editorial editorial = new Editorial();
		try {
			String sql = "CALL sp_obtenerEditorial(?)";
			this.abrirConexion();
			cs = conexion.prepareCall(sql);
			System.out.println("IDEDITORIAL:" + ideditorial);
			cs.setInt(1, ideditorial);
			rs = cs.executeQuery();
			if (rs.next()) {
				editorial.setIdEditorial(rs.getInt("ideditorial"));
				editorial.setNombre(rs.getString("nombre"));
				editorial.setContacto(rs.getString("contacto"));
				editorial.setTelefono(rs.getString("telefono"));
				this.cerrarConexion();
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.cerrarConexion();
			return null;
		}
		return editorial;
	}

	public int modificarEditorial(Editorial editorial) throws SQLException {
		try {
			int filasAfectadas = 0;
			String sql = "CALL sp_modificarEditorial(?,?,?,?)";
			this.abrirConexion();
			cs = conexion.prepareCall(sql);
			cs.setInt(1, editorial.getIdEditorial());
			cs.setString(2, editorial.getNombre());
			cs.setString(3, editorial.getContacto());
			cs.setString(4, editorial.getTelefono());
			filasAfectadas = cs.executeUpdate();
			this.cerrarConexion();
			return filasAfectadas;
		} catch (Exception e) {
			this.cerrarConexion();
			return 0;
		}
	}

	public int eliminarEditorial(int ideditorial) throws SQLException {
		try {
			int filasAfectadas = 0;
			String sql = "CALL sp_eliminarEditorial(?)";
			this.abrirConexion();
			cs = conexion.prepareCall(sql);
			cs.setInt(1, ideditorial);
			filasAfectadas = cs.executeUpdate();
			this.cerrarConexion();
			return filasAfectadas;
		} catch (Exception e) {
			this.cerrarConexion();
			return 0;
		}
	}
}
