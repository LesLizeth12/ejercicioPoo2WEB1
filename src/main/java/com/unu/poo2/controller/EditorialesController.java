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
import com.unu.poo2.beans.Editorial;
import com.unu.poo2.model.EditorialesModel;

/**
 * Servlet implementation class EditorialesController
 */
public class EditorialesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
EditorialesModel modelo=new EditorialesModel();
	
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
				request.getRequestDispatcher("/editoriales/nuevoEditorial.jsp").forward(request, response);
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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditorialesController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    private void listar(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setAttribute("listaEditoriales", modelo.listarEditoriales()); 
			request.getRequestDispatcher("/editoriales/listaEditoriales.jsp").forward(request, response);
		} catch (ServletException | IOException ex) {
			Logger.getLogger(AutoresController.class.getName()).log(Level.SEVERE, null,ex);
		}
	}

    private void insertar(HttpServletRequest request, HttpServletResponse response) {
    	try {
    		Editorial miEditorial= new Editorial();
    		miEditorial.setNombre(request.getParameter("nombre"));
    		miEditorial.setContacto(request.getParameter("contacto"));
    		miEditorial.setTelefono(request.getParameter("telefono"));
    		if(modelo.insertarEditorial(miEditorial)>0) {
    			request.getSession().setAttribute("exito", "editorial registrado exitosamente");
    		}
    		else {
    			request.getSession().setAttribute("fracaso", "editorial no registrado");
    		}
    		response.sendRedirect(request.getContextPath()+"/EditorialesController?op=listar");
    		
    	}catch (Exception ex) {
			ex.getStackTrace();
		}
    }
    
    private void obtener(HttpServletRequest request, HttpServletResponse response) {
    	try {
			String id=request.getParameter("id");
			System.out.println("ID:"+id);
			Editorial miEditorial=modelo.obtenerEditorial(Integer.parseInt(id));
			System.out.println("MIeditorial:"+miEditorial);
			if(miEditorial!=null) {
				request.setAttribute("editorial", miEditorial);
				request.getRequestDispatcher("/editoriales/editarEditorial.jsp").forward(request, response);
			}else {
				response.sendRedirect(request.getContextPath()+"/error404.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    private void modificar(HttpServletRequest request, HttpServletResponse response) {
    	try {
    		Editorial miEditorial= new Editorial();
    		miEditorial.setIdEditorial(Integer.parseInt(request.getParameter("id")) );
    		miEditorial.setNombre(request.getParameter("nombre"));
    		miEditorial.setContacto(request.getParameter("contacto"));
    		miEditorial.setTelefono(request.getParameter("telefono"));
    		if(modelo.modificarEditorial(miEditorial)>0) {
    			request.getSession().setAttribute("exito", "editorial editado exitosamente");
    			//response.sendRedirect(request.getContextPath()+"/AutoresController?op=listar");
    		}
    		else {
    			request.getSession().setAttribute("fracaso", "editorial no editado");
    			//response.sendRedirect(request.getContextPath()+"/AutoresController?op=listar");
    		}
    		response.sendRedirect(request.getContextPath()+"/EditorialesController?op=listar");
    		
    	}catch (Exception ex) {
			ex.getStackTrace();
		}
    }
    
    private void eliminar(HttpServletRequest request, HttpServletResponse response) {
    	try {
    		int ideditorial=Integer.parseInt(request.getParameter("id"));
    		if(modelo.eliminarEditorial(ideditorial)>0) {
    			request.getSession().setAttribute("exito", "editorial eliminado exitosamente");
    			//response.sendRedirect(request.getContextPath()+"/AutoresController?op=listar");
    		}
    		else {
    			request.getSession().setAttribute("fracaso", "editorial no eliminado");
    			//response.sendRedirect(request.getContextPath()+"/AutoresController?op=listar");
    		}
    		response.sendRedirect(request.getContextPath()+"/EditorialesController?op=listar");
    		
    	}catch (Exception ex) {
			ex.getStackTrace();
		}
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
