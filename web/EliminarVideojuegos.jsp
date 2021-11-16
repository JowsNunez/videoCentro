<%-- 
    Document   : EliminarVideojuegos
    Created on : 15/11/2021, 09:17:45 AM
    Author     : Andrea Borboa 
--%>

<%-- 
    EliminarVideojuegos.jsp

    Esta página JSP permite capturar las claves de los videojuegos a eliminar dentro
    del catalago de videojuegos para posteriormente eliminarlos. 
--%>

<%@page import="objetosNegocio.Videojuego"%>
<%@page import="persistencia.PersistenciaBD"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/estilos.css" />
        <link href="css/estilos2.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar Videojuego</title>
    </head>
    <body>
        
        <%-- Incluye el encabezado de la pagina --%>
        <%@include file="jspf/titulo.jspf"%>

        <%-- Incluye el menu videojuegos --%>
        <%@include file="jspf/menuVideojuegos.jspf"%>


        <article>
            <%
                PersistenciaBD crud = new PersistenciaBD();
                List lista = crud.consultarVideojuegos();
                Videojuego v;
            %>
            <h1> ¡Ingresa la clave de tu videojuego a eliminar!</h1>
            <%-- Formulario para capturar el num. de catálogo de los videojuegos.
                 La clave se envía al servlet EliminarVideojuegos para
                 obtener y eliminar la lsta de videojuegos capturados. --%>
            <div style="width: 400px; margin: 0 auto; display: flex; flex-direction: column; align-items: center;">
            <form action="EliminarVideojuego" method="post" name="EliminarVideojuego" >
                <ul>
                    <li><input type="text" name="numCatalogo" placeholder="Num. Catálogo" required min="1" style="width: 200px" max="9999999999999999999"/></li>
                    <li><input type="submit" value ="Capturar id"  />
                </ul>
            </form>
            
            <%-- Añade los videojuegos a la lista y los regresa como tabla.--%>
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
</div>
        </article>
    </body>
</html>