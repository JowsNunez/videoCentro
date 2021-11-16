/*
 * ObtenVideojuego.java
 */
package acciones;

import interfaces.IPersistencia;
import java.io.IOException;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import objetosNegocio.Videojuego;
import objetosTransferencia.Mensaje;
import persistencia.PersistenciaBD;
import utils.Validaciones;

/**
 * Este servlet busca un videojuego con una clave dada en la tabla videojuego
 * de la base de datos videocentro. El servlet obtiene del objeto request la 
 * clave del videojuego a buscar. El servlet verifica que la clave sea válida.
 * 
 * @author utiakcovarrubias
 */
public class ObtenVideojuego extends HttpServlet {

    /** 
     * Procesa las solicitudes para ambos metodos HTTP: GET y POST.
     * 
     * @param request Objeto request del servlet
     * @param response Objeto response del servlet
     * @throws ServletException Si ocuurre un error especifico del servlet.
     * @throws IOException Si ocuurre un error de E/S
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd;
        String siguiente = "";
        Validaciones validaciones = new Validaciones();

        // valida la clave del videojuego
        Map<String, Mensaje> mensajes = validaciones.validaClaveVideojuego(request);

        // Si la validación falla
        if (!mensajes.isEmpty()) {
            // Crea la variable de solicitud mensajes, con los mensajes de error
            request.setAttribute("mensajes", mensajes);

            // Establece que la página siguiente es capturaNumCatalogo.jsp
            rd = request.getRequestDispatcher("capturaNumCatalogo.jsp");
        } else {

            // Obten el objeto session que contiene a las variables con ámbito de sesion
            HttpSession session = request.getSession();
            
            // Obten de la variable de sesion tareasel, la tarea seleccionada
            String tareaSel = (String) session.getAttribute("tareaSel");

            // Obten la clave de la videojuego enviada por la página capturaNumCatalogo.jsp
            // o por la página seleccionaVideojuegoEditar.jsp
            String numCatalogo = (String) request.getParameter("clave");

            // Crea el objeto para acceder a la base de datos
            IPersistencia fachada = new PersistenciaBD();

            // Busca el videojuego en el catálogo de videojuegos
            Videojuego videojuego = fachada.obten(new Videojuego(numCatalogo));

            // Si el videojuego existe en el catálogo de videojuegos
            if (videojuego != null) {
                // Crea la variable de solicitud videojuego, con la videojuego existente
                request.setAttribute("videojuego", videojuego);

                siguiente = "despliegaVideojuego.jsp";
            }
            
            // Establece la página JSP o servlet siguiente
            rd = request.getRequestDispatcher(siguiente);
        }
        // Redirecciona a la página JSP o servlet siguiente
        rd.forward(request, response);
    }
// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Maneja el método HTTP: GET.
     * 
     * @param request Objeto request del servlet
     * @param response Objeto response del servlet
     * @throws ServletException Si ocuurre un error especifico del servlet.
     * @throws IOException Si ocuurre un error de E/S
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,
            IOException {
        processRequest(request, response);
    }

    /**
     * Maneja el método HTTP: POST.
     * 
     * @param request Objeto request del servlet
     * @param response Objeto response del servlet
     * @throws ServletException Si ocuurre un error especifico del servlet.
     * @throws IOException Si ocuurre un error de E/S
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,
            IOException {
        processRequest(request, response);
    }

    /**
     * Regresa una descripcion breve del servlet.
     * 
     * @return Descripcion breve del servlet.
     */
    @Override
    public String getServletInfo() {
        return "Servlet que obtiene un videojuego del catálogo de videojuego";
    }// </editor-fold>
}