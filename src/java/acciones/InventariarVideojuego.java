package acciones;


import objetosNegocio.Videojuego;
import persistencia.PersistenciaBD;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Este servlet Inventaría un videojuego a la tabla videojuegos de la base de datos
 * videocentro. 
 * @author Andrea Borboa Ramírez, Emilio.
 */
@WebServlet(name = "InventariarVideojuego", urlPatterns = {"/InventariarVideojuego"})
public class InventariarVideojuego extends HttpServlet {
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            PersistenciaBD crud = new PersistenciaBD();
            
            Videojuego videojuego = new Videojuego(request.getParameter("clave"));
            
          if( crud.obten(videojuego)!=null){
               crud.inventariar(videojuego,Integer.valueOf(request.getParameter("cantidad")));
                response.sendRedirect("ObtenInventarioVideojuegos.jsp");
          }else{
          
            out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Lo lamento</title>");
                out.println("</head>");
                out.println("<header>¡Oh no!</header>");
                out.println("<nav>");
                out.println("<a href=\"Bienvenido_JSP.jsp\"><button type=\"button\"></button></a>");
                out.println("</nav>");
                out.println("<body>");
                out.println("<article>");
                out.println("<h1>El articulo que has introducido no existe :c<h1>");
                out.println("</article>");
                out.println("</body>");
                out.println("</html>");
        }
              
          }
            
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

  