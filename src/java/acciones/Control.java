/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author utiakcovarrubias, Andrea Borboa
 */
public class Control extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obten de la solicitud, la tarea seleccionada del menú de canciones
        String tareaSel = request.getParameter("tarea");
        // Obten el objeto session que contiene a las variables con ámbito de sesion
        HttpSession session = request.getSession();
        RequestDispatcher rd;
        String siguiente = null;
        
        // Guarda en la variable de sesion tareaSel, la tarea seleccionada
        session.setAttribute("tareaSel", tareaSel);
        
        // establece la pagina JSP o servlet que inicia el caso de uso seleccionado
        switch (tareaSel) {
            case "agregarVideojuego":
                siguiente = "capturaVideojuego.jsp";
                break;
            case "actualizarVideojuego":
                siguiente = "capturaNumCatalogoActualizar.jsp";
                break;
            case "eliminarVideojuegos":
                siguiente = "EliminarVideojuegos.jsp";
                break; 
            case "listarVideojuegos":
                siguiente = "despliegaVideojuegos.jsp";
                break;
            case "buscarVideojuego":
                siguiente = "capturaNumCatalogo.jsp";
                break;
            case "obtenerInventariar":
                siguiente="InventariarVideojuego.jsp"; 
                break;
            case "obtenerDesinventariar":
                siguiente= "DesinventariarVideojuegos.jsp";
                break;
            case "obtenerInventario":
                siguiente="ObtenInventarioVideojuegos.jsp";          
            default:
                break;
        }
        
        // Obten el objeto RequestDispatcher
        rd = request.getRequestDispatcher(siguiente);
        
        // Redirecciona a la página JSP siguiente
        rd.forward(request, response);
    }
    
    /** 
    * Maneja el método HTTP: GET. 
    * @param request Objeto request del servlet 
    * @param response Objeto response del servlet 
    * @throws ServletException Si ocuurre un error especifico del servlet.
    * @throws IOException Si ocurre un error de E/S 
    **/
    @Override 
    protected void doGet(HttpServletRequest request, 
        HttpServletResponse response) 
        throws ServletException, IOException { 
        processRequest(request, response); 
    }
    
    /** 
    * Maneja el método HTTP: POST. 
    * Maneja el método HTTP: GET. 
    * @param request Objeto request del servlet 
    * @param response Objeto response del servlet 
    * @throws ServletException Si ocuurre un error especifico del servlet. 
    * @throws IOException Si ocurre un error de E/S 
    */ 
    @Override 
    protected void doPost(HttpServletRequest request, 
        HttpServletResponse response) 
        throws ServletException, IOException { 
        processRequest(request, response); 
    }
    
    /** 
    * Regresa una descripción corta del servlet. 
    * @return Descripción corta del servlet. 
    */ 
    @Override 
    public String getServletInfo() { 
        return "Servlet de control"; 
    }

}
