package com.unu.poo2.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
//import java.lang.System.Logger;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.unu.poo2.beans.Autor;
//import com.mysql.cj.x.protobuf.MysqlxNotice.Warning.Level;
import com.unu.poo2.model.AutoresModel;
import java.util.List.*;

/**
 * Servlet implementation class AutoresController
 */
public class AutoresController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	AutoresModel modelo=new AutoresModel();
	
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
				request.getRequestDispatcher("/autores/nuevoAutor.jsp").forward(request, response);
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
    public AutoresController() {
        super();
    }
    
    private void listar(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setAttribute("listaAutores", modelo.listarAutores()); 
			
			Iterator<Autor> it=modelo.listarAutores().iterator(); //LISTA
			while(it.hasNext()) { //RECORRIDO DE LA LISTA
				Autor a=it.next();
				System.out.println(a.getIdAutor()+" "+a.getNombre()+" "+a.getNacionalidad());
			}
			
			request.getRequestDispatcher("/autores/listaAutores.jsp").forward(request, response);
		} catch (ServletException | IOException ex) {
			Logger.getLogger(AutoresController.class.getName()).log(Level.SEVERE, null,ex);
		}
	}
    
    private void insertar(HttpServletRequest request, HttpServletResponse response) {
    	try {
    		if(!validar(request, response)) {
    			Autor miAutor= new Autor();
        		miAutor.setNombre(request.getParameter("nombre"));
        		miAutor.setNacionalidad(request.getParameter("nacionalidad"));
        		if(modelo.insertarAutor(miAutor)>0) {
        			request.getSession().setAttribute("exito", "autor registrado exitosamente");
        			//response.sendRedirect(request.getContextPath()+"/AutoresController?op=listar");
        		}
        		else {
        			request.getSession().setAttribute("fracaso", "autor no registrado");
        			//response.sendRedirect(request.getContextPath()+"/AutoresController?op=listar");
        		}
        		
        		response.sendRedirect(request.getContextPath()+"/AutoresController?op=listar");
    		}else {
    			request.getRequestDispatcher("/autores/nuevoAutor.jsp").forward(request, response);
    		}
    		
    		
    		
    		
    		
    		
    		
    	}catch (Exception ex) {
			ex.getStackTrace();
		}
    }
    
    private void obtener(HttpServletRequest request, HttpServletResponse response) {
    	try {
			String id=request.getParameter("id");
			System.out.println("ID:"+id);
			Autor miAutor=modelo.obtenerAutor(Integer.parseInt(id));
			System.out.println("MIautor:"+miAutor);
			if(miAutor!=null) {
				request.setAttribute("autor", miAutor);
				request.getRequestDispatcher("/autores/editarAutor.jsp").forward(request, response);
			}else {
				response.sendRedirect(request.getContextPath()+"/error404.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    private void modificar(HttpServletRequest request, HttpServletResponse response) {
    	try {
    		Autor miAutor= new Autor();
    		miAutor.setIdAutor(Integer.parseInt(request.getParameter("id")) );
    		miAutor.setNombre(request.getParameter("nombre"));
    		miAutor.setNacionalidad(request.getParameter("nacionalidad"));
    		if(modelo.modificarAutor(miAutor)>0) {
    			request.getSession().setAttribute("exito", "autor editado exitosamente");
    			//response.sendRedirect(request.getContextPath()+"/AutoresController?op=listar");
    		}
    		else {
    			request.getSession().setAttribute("fracaso", "autor no editado");
    			//response.sendRedirect(request.getContextPath()+"/AutoresController?op=listar");
    		}
    		response.sendRedirect(request.getContextPath()+"/AutoresController?op=listar");
    		
    	}catch (Exception ex) {
			ex.getStackTrace();
		}
    }
    
    private void eliminar(HttpServletRequest request, HttpServletResponse response) {
    	try {
    		int idautor=Integer.parseInt(request.getParameter("id"));
    		if(modelo.eliminarAutor(idautor)>0) {
    			request.getSession().setAttribute("exito", "autor eliminado exitosamente");
    			//response.sendRedirect(request.getContextPath()+"/AutoresController?op=listar");
    		}
    		else {
    			request.getSession().setAttribute("fracaso", "autor no eliminado");
    			//response.sendRedirect(request.getContextPath()+"/AutoresController?op=listar");
    		}
    		response.sendRedirect(request.getContextPath()+"/AutoresController?op=listar");
    		
    	}catch (Exception ex) {
			ex.getStackTrace();
		}
    }
    
    private boolean validar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	boolean res=false;
    	List<String> listError=new ArrayList<>();
    	try {
			if(request.getParameter("nombre").equals("")) {
				res=true;
				listError.add("Ingrese el nombre del autor");
			}
			if(request.getParameter("nacionalidad").equals("")) {
				res=true;
				listError.add("Ingrese la nacionalidad del autor");
			}
			request.setAttribute("respuesta", res);
			request.setAttribute("listaError", listError);
		} catch (Exception e) {
			e.getStackTrace();
		}
    	return res;
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { //ENVIAR DATOS A TRAVES DE LA URL
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { //ENVIAR DATOS DE MANERA OCULTA
		// TODO Auto-generated method stub
		//doGet(request, response);
		processRequest(request, response);
	}
}
