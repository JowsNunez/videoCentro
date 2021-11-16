/*
 * Validaciones.java
 */
package utils;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import objetosTransferencia.Mensaje;

/**
 * Esta clase contiene métodos que validan los diferentes campos de entrada de
 * los formularios de la aplicacion VideoCentro
 *
 * @author utiakcovarrubias
 */
public class Validaciones {

    /**
     * Este método permite validar una clave de un videojuego del formulario de la
     * página capturaClave.jsp. La validación se hace en el servlet ObtenVideojuego
     *
     * @param request La solicitud HTTP que se está procesando.
     * @return Regresa un mapa de los errores de validaciones
     */
    public Map<String, Mensaje> validaClaveVideojuego(HttpServletRequest request) {
        Map<String, Mensaje> mensajes = new HashMap<>();
        Valida valida = new Valida();
        Mensaje mensaje;

        String clave = request.getParameter("clave");

        // Si no hay clave
        if (valida.cadenaVacia(clave)) {
            // crea mensaje de error
            mensaje = new Mensaje("Error!: Se requiere un valor", "msjError");
            // Agrega el mensaje de error a la lista de errores
            mensajes.put("clave", mensaje);
        } // Si la clave no es valida
        else if (!valida.validaClave(clave)) {
            // crea mensaje de error
            mensaje = new Mensaje("Error!: Clave no valida", "msjError");

            // Agrega el mensaje de error a la lista de errores
            mensajes.put("clave", mensaje);
        }
        return mensajes;
    }

    /**
     * Este método permite validar un videojuego de los formularios de las páginas
     * capturaVideojuego.jsp y editaVideojuego.jsp. Las validaciones se hacen en los
     * servlets AgregaVideojuego y actualizaVideojuego, respectivamente.
     *
     * @param request La solicitud HTTP que se está procesando.
     * @return Regresa un mapa de los errores de validaciones
     */
    public Map<String, Mensaje> validaVideojuego(HttpServletRequest request) {
        Map<String, Mensaje> mensajes = new HashMap<>();
        Valida valida = new Valida();
        Mensaje mensaje;

        String titulo = request.getParameter("titulo");

        // Si no hay titulo
        if (valida.cadenaVacia(titulo)) {
            // crea mensaje de error
            mensaje = new Mensaje("Error!: Se requiere un valor", "msjError");
            // Agrega el mensaje de error a la lista de errores
            mensajes.put("titulo", mensaje);
        } // Si el titulo es muy largo
        else if (!valida.validaCadena(35, titulo)) {
            // crea mensaje de error
            mensaje = new Mensaje("Error!: Cadena muy larga", "msjError");
            // Agrega el mensaje de error a la lista de errores
            mensajes.put("titulo", mensaje);
        }

        String genero = request.getParameter("genero");

        // Si no hay genero
        if (valida.cadenaVacia(genero)) {
            // crea mensaje de error
            mensaje = new Mensaje("Error!: Se requiere un valor", "msjError");
            // Agrega el mensaje de error a la lista de errores
            mensajes.put("genero", mensaje);
        } // Si el genero es muy largo
        else if (!valida.validaCadena(20, genero)) {
            // crea mensaje de error
            mensaje = new Mensaje("Error!: Cadena muy larga", "msjError");
            // Agrega el mensaje de error a la lista de errores
            mensajes.put("genero", mensaje);
        }

        String clasificacion = request.getParameter("clasificacion");

        // Si no hay clasificacion
        if (valida.cadenaVacia(clasificacion)) {
            // crea mensaje de error
            mensaje = new Mensaje("Error!: Se requiere un valor", "msjError");
            // Agrega el mensaje de error a la lista de errores
            mensajes.put("clasificacion", mensaje);
        } // Si la clasificacion es muy largo
        else if (!valida.validaCadena(20, clasificacion)) {
            // crea mensaje de error
            mensaje = new Mensaje("Error!: Cadena muy larga", "msjError");
            // Agrega el mensaje de error a la lista de errores
            mensajes.put("clasificacion", mensaje);
        }

        String consola = request.getParameter("consola");

        // Si no hay consola
        if (valida.cadenaVacia(consola)) {
            // crea mensaje de error
            mensaje = new Mensaje("Error!: Se requiere un valor", "msjError");
            // Agrega el mensaje de error a la lista de errores
            mensajes.put("consola", mensaje);
        } // Si la consola es muy largo
        else if (!valida.validaCadena(20, consola)) {
            // crea mensaje de error
            mensaje = new Mensaje("Error!: Cadena muy larga", "msjError");
            // Agrega el mensaje de error a la lista de errores
            mensajes.put("consola", mensaje);
        }

        String fabricante = request.getParameter("fabricante");

        // Si no hay fabricante
        if (valida.cadenaVacia(fabricante)) {
            // crea mensaje de error
            mensaje = new Mensaje("Error!: Se requiere un valor", "msjError");
            // Agrega el mensaje de error a la lista de errores
            mensajes.put("fabricante", mensaje);
        } // Si el fabricante es muy largo
        else if (!valida.validaCadena(35, fabricante)) {
            // crea mensaje de error
            mensaje = new Mensaje("Error!: Cadena muy larga", "msjError");
            // Agrega el mensaje de error a la lista de errores
            mensajes.put("fabricante", mensaje);
        }
        
        String version = request.getParameter("version");

        // Si hay version
        if (!valida.cadenaVacia(version)) {
            // Si la version es muy largo 
            if (!valida.validaCadena(5, version)) {
                // crea mensaje de error
                mensaje = new Mensaje("Error!: Cadena muy larga", "msjError");
                // Agrega el mensaje de error a la lista de errores
                mensajes.put("version", mensaje);
            }
        }

        return mensajes;
    }
}
