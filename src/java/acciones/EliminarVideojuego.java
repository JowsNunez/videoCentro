
package acciones;


import objetosNegocio.Videojuego;
import persistencia.PersistenciaBD;
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
import objetosTransferencia.Mensaje;
import utils.Validaciones;

/**
 * Este servlet elimina una videojuego a la tabla videojuegos de la base de datos
 * videocentro. El servlet obtiene del objeto request la clave del videojuego y
 * verifica que exista en la base de datos, si existe lo elimina.
 * 
 * @author Andrea Borboa Ramírez
 */
@WebServlet(name = "EliminarVideojuego", urlPatterns = {"/EliminarVideojuego"})
public class EliminarVideojuego extends HttpServlet{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            // Crea el objeto persistencia para acceder a la base de datos.
            PersistenciaBD crud = new PersistenciaBD();
            //Crea la lista de videojuegos.
            List<Videojuego> lista = crud.consultarVideojuegos();
           //Crea un nuevo videojuego y le añade el parametro numCatalago de el 
           //objeto request.
            Videojuego videojuego = new Videojuego(request.getParameter("numCatalogo"));
            //crea un objeto de tipo videojuego
            Videojuego game = null;
            //compara el objeto juego con el parametro getNumCatalago de el
            //objeto videojuego de la lista
            for (Videojuego juego : lista) {

                if (juego.getNumCatalogo().equalsIgnoreCase(videojuego.getNumCatalogo())) {
                    //si son iguales entonces añade el juego de la lista al 
                    //objeto game anteriormente creado.
                    game = juego;
                    break;
                }

            }

            try {
                //Elimina el juego almacenado en el objeto "game"
                crud.eliminar(game);
                //redirige al usuario a la pagina eliminado.
                response.sendRedirect("eliminado.html");
            } catch (Exception e) {
                
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
