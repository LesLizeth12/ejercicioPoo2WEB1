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

import com.unu.poo2.beans.Autor;
import com.unu.poo2.beans.Libro;
import com.unu.poo2.model.LibrosModel;

/**
 * Servlet implementation class LibrosController
 */
public class LibrosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
LibrosModel modelo=new LibrosModel();
	
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
				request.getRequestDispatcher("/libros/nuevoLibro.jsp").forward(request, response);
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
				//eliminar(request, response);
				break;
			}
		} 
	}
	
    public LibrosController() {
        super();
        // TODO Auto-generated constructor stub
    }

    private void listar(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setAttribute("listaLibros", modelo.listarLibros()); 
			request.getRequestDispatcher("/libros/listaLibros.jsp").forward(request, response);
		} catch (ServletException | IOException ex) {
			Logger.getLogger(AutoresController.class.getName()).log(Level.SEVERE, null,ex);
		}
	}
    
    private void insertar(HttpServletRequest request, HttpServletResponse response) {
    	System.out.println("Entrando a método insertar");
    	String valor = request.getParameter("existencia"); // Asegúrate de usar el nombre correcto del parámetro
		try {
		    int numero = Integer.parseInt(valor);
		    // Continúa con la lógica usando 'numero'
		} catch (NumberFormatException e) {
		    System.out.println("El valor ingresado no es un número: " + valor);
		    // Maneja el error o establece un valor predeterminado
		}
    	try {
    		Libro miLibro= new Libro();
    		miLibro.setNombre(request.getParameter("nombre"));
    		miLibro.setExistencia(request.getParameter("existencia"));
    		miLibro.setPrecio(request.getParameter("precio"));
    		miLibro.setDescripcion(request.getParameter("descripcion"));
    		miLibro.setAutor(request.getParameter("autor"));
    		miLibro.setEditorial(request.getParameter("editorial"));
    		miLibro.setGenero(request.getParameter("genero"));
    		
    		
    		
    		System.out.println("NOMBRE AUTOR:"+miLibro.getAutor());
    		if(modelo.insertarLibro(miLibro)>0) {
    			System.out.println("AGREGADO");
    			request.getSession().setAttribute("exito", "libro registrado exitosamente");
    		}
    		else {
    			System.out.println("NO AGREGADO");
    			request.getSession().setAttribute("fracaso", "libro no registrado");
    		}
    		response.sendRedirect(request.getContextPath()+"/LibrosController?op=listar");
    		
    	}catch (Exception ex) {
    		ex.printStackTrace();
		}
    }
    
    private void obtener(HttpServletRequest request, HttpServletResponse response) {
    	try {
			String id=request.getParameter("id");
			System.out.println("ID:"+id);
			Libro miLibro=modelo.obtenerLibro(Integer.parseInt(id));
			System.out.println("MImiLibro:"+miLibro);
			if(miLibro!=null) {
				request.setAttribute("libro", miLibro);
				request.getRequestDispatcher("/libros/editarLibro.jsp").forward(request, response);
			}else {
				response.sendRedirect(request.getContextPath()+"/error404.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    private void modificar(HttpServletRequest request, HttpServletResponse response) {
    	try {
    		Libro miLibro= new Libro();
    		miLibro.setIdLibro(Integer.parseInt(request.getParameter("id")) );
    		miLibro.setNombre(request.getParameter("nombre"));
    		miLibro.setExistencia(request.getParameter("existencia"));
    		miLibro.setPrecio(request.getParameter("precio"));
    		miLibro.setDescripcion(request.getParameter("descripcion"));
    		miLibro.setAutor(request.getParameter("autor"));
    		miLibro.setEditorial(request.getParameter("editorial"));
    		miLibro.setGenero(request.getParameter("genero"));
    		if(modelo.modificarLibro(miLibro)>0) {
    			request.getSession().setAttribute("exito", "libro editado exitosamente");
    		}
    		else {
    			request.getSession().setAttribute("fracaso", "libro no editado");
    		}
    		response.sendRedirect(request.getContextPath()+"/LibrosController?op=listar");
    		
    	}catch (Exception ex) {
			ex.getStackTrace();
		}
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
