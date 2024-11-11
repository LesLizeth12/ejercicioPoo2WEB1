package com.unu.poo2.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.unu.poo2.beans.Genero;
import com.unu.poo2.model.GenerosModel;

/**
 * Servlet implementation class GenerosController
 */
public class GenerosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
GenerosModel modelo=new GenerosModel();
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try (PrintWriter out =response.getWriter()){
			if(request.getParameter("op")==null) {
				listar(request,response);
				return;
			}
			String operacion=request.getParameter("op");
			switch (operacion) {
			case "listar": 
				listar(request, response);
				break;
			case "nuevo":
				request.getRequestDispatcher("/generos/nuevoGenero.jsp").forward(request, response);
				break;
			case "insertar":
				insertar(request, response);
				break;
			case "obtener":
				obtener(request, response);
				break;
			case "modificar":
				modificar(request, response);
				break;
			case "eliminar":
				eliminar(request, response);
				break;
			}
		} 
	}
	
    public GenerosController() {
        super();
        // TODO Auto-generated constructor stub
    }

    private void listar(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setAttribute("listaGeneros", modelo.listarGeneros()); 
			request.getRequestDispatcher("/generos/listaGeneros.jsp").forward(request, response);
		} catch (ServletException | IOException ex) {
			Logger.getLogger(GenerosController.class.getName()).log(Level.SEVERE, null,ex);
		}
	}
    
    private void insertar(HttpServletRequest request, HttpServletResponse response) {
    	try {
    		Genero miGenero= new Genero();
    		miGenero.setNombre(request.getParameter("nombre"));
    		miGenero.setDescripcion(request.getParameter("descripcion"));
    		if(modelo.insertarGenero(miGenero)>0) {
    			request.getSession().setAttribute("exito", "Genero registrado exitosamente");
    		}
    		else {
    			request.getSession().setAttribute("fracaso", "Genero no registrado");
    		}
    		response.sendRedirect(request.getContextPath()+"/GenerosController?op=listar");
    		
    	}catch (Exception ex) {
			ex.getStackTrace();
		}
    }
    
    private void obtener(HttpServletRequest request, HttpServletResponse response) {
    	try {
			String id=request.getParameter("id");
			System.out.println("ID:"+id);
			Genero miGenero=modelo.obtenerGenero(Integer.parseInt(id));
			System.out.println("MIGenero:"+miGenero);
			if(miGenero!=null) {
				request.setAttribute("genero", miGenero);
				request.getRequestDispatcher("/generos/editarGenero.jsp").forward(request, response);
			}else {
				response.sendRedirect(request.getContextPath()+"/error404.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    private void modificar(HttpServletRequest request, HttpServletResponse response) {
    	try {
    		Genero miGenero= new Genero();
    		miGenero.setIdGenero(Integer.parseInt(request.getParameter("id")) );
    		miGenero.setNombre(request.getParameter("nombre"));
    		miGenero.setDescripcion(request.getParameter("descripcion"));
    		if(modelo.modificarGenero(miGenero)>0) {
    			request.getSession().setAttribute("exito", "Genero editado exitosamente");
    		}
    		else {
    			request.getSession().setAttribute("fracaso", "Genero no editado");
    		}
    		response.sendRedirect(request.getContextPath()+"/GenerosController?op=listar");
    		
    	}catch (Exception ex) {
			ex.getStackTrace();
		}
    }
    
    private void eliminar(HttpServletRequest request, HttpServletResponse response) {
    	try {
    		int idGenero=Integer.parseInt(request.getParameter("id"));
    		if(modelo.eliminarGenero(idGenero)>0) {
    			request.getSession().setAttribute("exito", "Genero eliminado exitosamente");
    		}
    		else {
    			request.getSession().setAttribute("fracaso", "Genero no eliminado");
    		}
    		response.sendRedirect(request.getContextPath()+"/GenerosController?op=listar");
    		
    	}catch (Exception ex) {
			ex.getStackTrace();
		}
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
