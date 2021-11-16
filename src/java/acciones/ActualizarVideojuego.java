package acciones;
import interfaces.IPersistencia;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import objetosNegocio.Videojuego;
import objetosTransferencia.Mensaje;
import persistencia.PersistenciaBD;
import utils.Validaciones;

/**
 * Este servlet actualiza un videojuego a la tabla videojuegos de la base de datos
 * videocentro. El servlet obtiene del objeto request los atributos del videojuego. 
 * El servlet verifica que los atributos del videojuego sean válidas.
 * 
 * @author AndreaBorboa
 */
@WebServlet(name = "ActualizarVideojuego", urlPatterns = {"/ActualizarVideojuego"})
public class ActualizarVideojuego extends HttpServlet{
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
            /* TODO output your page here. You may use following sample code. */
            
            PersistenciaBD crud = new PersistenciaBD();
            
            List<Videojuego> lista = crud.consultarVideojuegos();
            Videojuego videojuego = new Videojuego(request.getParameter("numCatalogo"));
            String campo;
             videojuego.setTitulo((String) request.getParameter("titulo"));
            videojuego.setGenero((String) request.getParameter("genero"));
            videojuego.setClasificacion((String) request.getParameter("clasificacion"));
            videojuego.setConsola((String) request.getParameter("consola"));
            videojuego.setFabricante((String) request.getParameter("fabricante"));
            campo = request.getParameter("version");
             System.out.println("ESELEEE:\t" + videojuego);
             
                // Crea el objeto para acceder a la base de datos
            IPersistencia fachada = new PersistenciaBD();

            // Agrega el nuevo videojuego al catálogo de videojuegos
            fachada.actualizar(videojuego);
     
            
            
               response.sendRedirect("eliminado.html");
           
            
            
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
