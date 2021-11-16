<%-- 
    Document   : ObtenerInventario
    Created on : 15/11/2021, 05:16:40 PM
    Author     : Andrea Borboa Ramírez
--%>


<%@page import="objetosNegocio.VideojuegoED"%>
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
        <title>INVENTARIO</title>
    </head>
    <body>
        <header><h1>CONSULTAR INVENTARIO</h1></header>


        <nav>
            <button type="button" name="back" onclick="history.back()"></button>
            <ul>

                <li><a href="control?tarea=obtenerInventariar">Inventarear</a></li>
                <li><a href="control?tarea=obtenerDesinventariar">Desinventarear</a></li>
                <li><a href="control?tarea=obtenerInventario">Consultar inventario de videojuego</a></li>

            </ul>

        </nav>

        <article>
             <div style="width: 400px; margin: 40px auto; z-index: 10000; display: flex; flex-direction: column; align-items: center;">
            
            <h1> ¡Ingresa la clave de tu videojuego al cual deseas consultar su inventario!</h1>
            <form action="obtenerInventario">
                <ul>
                    <li><input type="text" name="numCatalogo" placeholder="Num. Catálogo" required min="0"/></li>
                    <li><input type="submit" value ="Capturar id" />
                </ul>
            </form>

            <%
                PersistenciaBD crud = new PersistenciaBD();
                List lista = crud.consultarInventarioVideojuegos();
                VideojuegoED v;
                out.println("<table border=1>");
                out.println("<tr>"
                            + "<th>" + "Núm.Catalago"+ "</th>"
                            + "<th>" + "Cantidad" + "</th>"
                            + "<th>" + "Existencia" + "</th>"
                      );
                
                for (int i = 0; i < lista.size(); i++) {
                    v = (VideojuegoED) lista.get(i);
                    out.println("<tr>"
                            + "<td>" + v.getVideojuego().getNumCatalogo()+ "</td>"
                            + "<td>" + v.getDisponibilidad()+ "</td>"
                            + "<td>" + v.getExistencia()+ "</td>"
                           );
                }
                out.println("</table>");
            
            %>
            </div>
        </article>
    </body>
</html>