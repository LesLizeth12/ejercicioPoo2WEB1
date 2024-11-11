package com.unu.poo2.model;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.unu.poo2.beans.Libro;

public class LibrosModel extends Conexion{
	CallableStatement cs;
	ResultSet rs;

	public List<Libro> listarLibros() {

		try {
			List<Libro> lista = new ArrayList<>();
			String sql = "CALL sp_listarLibro()";
			this.abrirConexion();
			cs = conexion.prepareCall(sql);
			rs = cs.executeQuery();
			while (rs.next()) {
				Libro libro = new Libro();
				libro.setIdLibro(rs.getInt("idlibro"));
				libro.setNombre(rs.getString("nombre"));
				libro.setExistencia(rs.getString("existencia"));
				libro.setPrecio(rs.getString("precio"));
				libro.setDescripcion(rs.getString("descripcion"));
				libro.setAutor(rs.getString("autor"));
				libro.setEditorial(rs.getString("editorial"));
				libro.setGenero(rs.getString("genero"));
				lista.add(libro);
			}

			this.cerrarConexion();
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
			this.cerrarConexion();
			return null;
		}
	}

	
	public int insertarLibro(Libro libro) throws SQLException {
		try {
			int filasAfectadas = 0;
			String sql = "CALL sp_insertarLibro(?,?,?,?,?,?,?)";
			this.abrirConexion();
			cs = conexion.prepareCall(sql);
			cs.setString(1, libro.getNombre());
			cs.setString(2, libro.getExistencia());
			cs.setString(3, libro.getPrecio());
			cs.setString(4, libro.getDescripcion());
			cs.setString(5, libro.getAutor());
			cs.setString(6, libro.getEditorial());
			cs.setString(7, libro.getGenero());
			filasAfectadas = cs.executeUpdate();
			this.cerrarConexion();
			return filasAfectadas;
		} catch (Exception e) {
			e.printStackTrace();
			this.cerrarConexion();
			return 0;
		}
	}


	public Libro obtenerLibro(int idLibro) {
		Libro libro = new Libro();
		try {
			String sql = "CALL sp_obtenerLibro(?)";
			this.abrirConexion();
			cs = conexion.prepareCall(sql);
			System.out.println("IDLibro:" + idLibro);
			cs.setInt(1, idLibro);
			rs = cs.executeQuery();
			if (rs.next()) {
				libro.setIdLibro(rs.getInt("idLibro"));
				libro.setNombre(rs.getString("nombre"));
				libro.setExistencia(rs.getString("Existencia"));
				libro.setPrecio(rs.getString("precio"));
				libro.setDescripcion(rs.getString("descripcion"));
				libro.setAutor(rs.getString("autor"));
				libro.setEditorial(rs.getString("editorial"));
				libro.setGenero(rs.getString("genero"));
				this.cerrarConexion();
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.cerrarConexion();
			return null;
		}
		return libro;
	}

	public int modificarLibro(Libro libro) throws SQLException {
		try {
			int filasAfectadas = 0;
			String sql = "CALL sp_modificarLibro(?,?,?,?,?,?,?,?)";
			this.abrirConexion();
			cs = conexion.prepareCall(sql);
			cs.setInt(1, libro.getIdLibro());
			cs.setString(2, libro.getNombre());
			cs.setString(3, libro.getExistencia());
			cs.setString(4, libro.getPrecio());
			cs.setString(5, libro.getDescripcion());
			cs.setString(6, libro.getAutor());
			cs.setString(7, libro.getEditorial());
			cs.setString(8, libro.getGenero());
			filasAfectadas = cs.executeUpdate();
			this.cerrarConexion();
			return filasAfectadas;
		} catch (Exception e) {
			this.cerrarConexion();
			return 0;
		}
	}

	/*
	public int eliminarLibro(int idLibro) throws SQLException {
		try {
			int filasAfectadas = 0;
			String sql = "CALL sp_eliminarLibro(?)";
			this.abrirConexion();
			cs = conexion.prepareCall(sql);
			cs.setInt(1, idLibro);
			filasAfectadas = cs.executeUpdate();
			this.cerrarConexion();
			return filasAfectadas;
		} catch (Exception e) {
			this.cerrarConexion();
			return 0;
		}
	}}*/
}
