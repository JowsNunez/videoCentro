<%-- 
    Document   : capturaEditarVideojuego
    Created on : 15/11/2021, 11:47:23 PM
    Author     : andre
--%>

<%@page import="objetosNegocio.Videojuego"%>
<%@page import="persistencia.PersistenciaBD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
                
        <article>
            <h1> ¡Edita tu videojuego!</h1>
          
            <form action="ActualizarVideojuego" method="put">
                <ul>
                    <li><label for="numCatalago">No. Catalago</label></li>
                    <li><input type="text" name="numCatalogo" id="numCatalogo" readonly="readonly" value="${videojuego.numCatalogo}"/></li>
                    <li><label for="titulo"> Titulo</label></li>
                    <li><input type="text"d="titulo" name="titulo"  value="${param.titulo}${videojuego.titulo}"/> </li>
                    <li><label for="genero"> Genero</label></li>
                    <li><input type="text" id="genero" name="genero"  value="$${param.genero}${videojuego.genero}"/> </li>
                    <li><label for="clasif"> Clasificación</label></li>
                    <li><input type="text" id="clasif" name="clasificacion"  value="${param.clasificacion}${videojuego.clasificacion}"/> </li>
                    <li><label for="consola"> Consola</label></li>
                    <li><input type="text" id="consola" name="consola"  value="$${param.consola}${videojuego.consola}"/> </li>
                    <li><label for="fabricante"> Fabricante</label></li>
                    <li><input type="text" id="fabricante" name="fabricante"  value="$${param.fabricante}${videojuego.fabricante}"/> </li>
                    <li><label for="version"> Versión</label></li>
                    <li><input type="number" id="version" name="version"  value="${param.version}${videojuego.version}"/> </li>
                    
                   
                    
                    <li><input type="submit" value ="Editar Videojuego" />
                </ul>
                
            </form>
            
        </article>
                   
    </body>
</html>
