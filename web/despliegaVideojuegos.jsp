<%-- 
    Created on : Nov 14, 2021, 4:10:00 AM
    Author     : utiakcovarrubias
--%>
<%@page import="persistencia.PersistenciaBD"%>
<%@page import="java.util.ArrayList"%>
<%@page import="interfaces.IPersistencia"%>
<%--
    despliegaVideojuegos.jsp
    
    Esta página JSP despliega una tabla con la lista de videojuegos del catálogo 
    de videojuegos. Forma parte de la aplicación videocentro.
--%>

<!DOCTYPE html>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<%@ page import="objetosNegocio.*" %>

<html>
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="css/estilos.css" />
        <link href="css/estilos2.css" rel="stylesheet" type="text/css"/>
        <title>Despliega Videojuegos</title>
    </head>

    <body>
        <%-- Incluye el encabezado de la pagina --%>
        <%@include file="jspf/titulo.jspf"%>

        <%-- Incluye el menu canciones --%>
        <%@include file="jspf/menuVideojuegos.jspf"%>

        <main>
              <%-- Div para centrar   --%>
             <div style="width: 400px; margin: 0 auto; display: flex; flex-direction: column; align-items: center;">
            <%-- Despliega los datos de todas las videojuegos. Los datos
                 se encuentran en el bean listaVideojuegos guardados en
                 el objeto session por el servlet obtenVideojuegos o en 
                 el objeto request por los servlets obtenVideojuegosGenero
                 u obtenVideojuegosPeriodo. 
            --%>
            <table class="bicolor" >
                <%// Crea el objeto para acceder a la base de datos
        IPersistencia fachada = new PersistenciaBD();

        // Obtiene la lista de videojuegos del catalogo de videojuegos
        ArrayList<Videojuego> lista = fachada.consultarVideojuegos();
        Videojuego v=new Videojuego();
%>

                <%-- Título de la tabla --%>
                <caption>
                   tablas
                </caption>
                  <%-- Crea tabla apartir de la lista  --%>
                 <%
                out.println("<table border=1>");
                out.println("<tr>"
                        + "<th> No. Catalogo </th>"
                        + "<th> Titulo </th>"
                        + "<th> Genero </th>"
                        + "<th> Consola </th>"
                        + "<th> Fabricante </th>"
                        + "<th> Version </th>"
                        + "</tr>");
                for (int i = 0; i < lista.size(); i++) {
                    v = (Videojuego) lista.get(i);
                    out.println("<tr>"
                            + "<td>" + v.getNumCatalogo() + "</td>"
                            + "<td>" + v.getTitulo() + "</td>"
                            + "<td>" + v.getGenero() + "</td>"
                            + "<td>" + v.getConsola() + "</td>"
                            + "<td>" + v.getFabricante() + "</td>"
                            + "<td>" + v.getVersion() + "</td>" + "</tr>");
                }
                out.println("</table>");
            %>
            </table>
             </div>
        </main>
    </body>
</html>
