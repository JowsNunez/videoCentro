<%-- 
    Created on : Nov 14, 2021, 4:10:00 AM
    Author     : utiakcovarrubias
--%>
<%--
    despliegaVideojuego.jsp
    
    Esta página JSP despliega los datos de un videojuego. Forma parte de 
    la aplicación videocentro.
--%>

<!DOCTYPE html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="css/estilos.css" />
        <link href="css/estilos2.css" rel="stylesheet" type="text/css"/>
        <title>Despliega Videojuego</title>
    </head>

    <body>
        <%-- Incluye el encabezado de la pagina --%>
        <%@include file="jspf/titulo.jspf"%>

        <%-- Incluye el menu videojuegos --%>
        <%@include file="jspf/menuVideojuegos.jspf"%>

        <main>
            <h1>Videojuego Existente</h1>

            <%-- Despliega los datos del videojuego. Los datos se encuentran
                 en el bean videojuego guardados en el objeto request por el
                 servlet obtenVideojuego. --%>
            <table class="centrada">
                <tr>
                  <td class="derecha">Num. de catálogo</td>
                  <td class="gris">${videojuego.numCatalogo}</td>
                <tr>
                    <td class="derecha">T&iacute;tulo</td>
                  <td class="gris">${videojuego.titulo}</td>
                </tr>
                <tr>
                    <td class="derecha">G&eacute;nero</td>
                  <td class="gris">${videojuego.genero}</td>
                </tr>
                <tr>
                  <td class="derecha">Clasificaci&oacute;n</td>
                  <td class="gris">${videojuego.clasificacion}</td>
                </tr>
                <tr>
                    <td class="derecha">Consola</td>
                  <td class="gris">${videojuego.consola}</td>
                </tr>
                <tr>
                  <td class="derecha">Fabricante</td>
                  <td class="gris">${videojuego.fabricante}</td>
                </tr>
                <tr>
                    <td class="derecha">Versi&oacute;n</td>
                  <td class="gris">${videojuego.version}</td>
                </tr>
            </table>
        </main>
    </body>
</html>
