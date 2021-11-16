
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
 * Este servlet agrega una canción a la tabla videojuegos de la base de datos
 * videocentro. El servlet obtiene del objeto request los atributos del videojuego. 
 * El servlet verifica que los atributos del videojuego sean válidas.
 * 
 * @author utiakcovarrubias
 */
public class AgregaVideojuego extends HttpServlet {

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
        Validaciones validaciones = new Validaciones();
        
        // valida los datos del ideojuego
        Map<String, Mensaje> mensajes = validaciones.validaVideojuego(request);

        // Si la validación falla
        if (!mensajes.isEmpty()) {
            // Crea la variable de solicitud mensajes, con los mensajes de error
            request.setAttribute("mensajes", mensajes);

            // Establece que la página siguiente es capturaVideojuego.jsp
            rd = request.getRequestDispatcher("agregaVideojuego.jsp");
        } else {
            // En este bean de tipo Videojuego, se almacenan los atributos de un
            //  videojuego enviada por la página capturaVideojuego.jsp.
            Videojuego videojuego = new Videojuego();
            String campo;
            
           

            // Obtiene de la solicitud los datos de una videojuego y los guarda al bean videojuego
            videojuego.setNumCatalogo((String) request.getParameter("clave"));
            videojuego.setTitulo((String) request.getParameter("titulo"));
            videojuego.setGenero((String) request.getParameter("genero"));
            videojuego.setClasificacion((String) request.getParameter("clasificacion"));
            videojuego.setConsola((String) request.getParameter("consola"));
            videojuego.setFabricante((String) request.getParameter("fabricante"));
            campo = request.getParameter("version");
             System.out.println(videojuego);
            if(!campo.equals("")){
                videojuego.setVersion(campo);
            } else  {
                videojuego.setVersion(null);
            }
            
            // Crea el objeto para acceder a la base de datos
            IPersistencia fachada = new PersistenciaBD();

            // Agrega el nuevo videojuego al catálogo de videojuegos
            fachada.agregar(videojuego);

            // Obten el objeto session que contiene a las variables con ámbito de sesion
            HttpSession session = request.getSession();

            // Guarda en la variable de sesión tareaSel, la tarea arealizar
            session.setAttribute("tareaSel", "listarVideojuegos");

            // Establece la página JSP o servlet siguiente
            rd = request.getRequestDispatcher("obtenVideojuegos");
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
     * @throws IOException if an I/O error occurs
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
        return "Servlet que agrega un videojuego al catalogo de videojuegos";
    }// </editor-fold>
}
