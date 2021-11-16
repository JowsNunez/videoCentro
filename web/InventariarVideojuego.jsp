<%-- 
    Document   : inventariarVideojuego
    Created on : 15/11/2021, 01:54:37 PM
    Author     : Emilio, Andrea
--%>
<%-- 
    capturaVideojuegoInventariar.jsp

    Esta página JSP permite capturar los parametros de un Videojuego para 
    añadirlo al inventario.
--%>

<%@page import="objetosNegocio.Videojuego"%>
<%@page import="persistencia.PersistenciaBD"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>


<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<html>
    <head>
        <meta charset="utf-8">
        <title>Captura Videojuego a Inventariar</title>
        <link rel="stylesheet" type="text/css" href="css/estilos.css" />
        <link href="css/estilos2.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%-- Incluye el encabezado de la pagina --%>
        <%@include file="jspf/titulo.jspf"%>

        <%-- Incluye el menu videojuegos --%>
        <%@include file="jspf/menuInventario.jspf"%>

        <main>
            <h1>Inventaria Videojuego</h1>

            <%-- Formulario para capturar los atributos de un videojuego.
                 Los datos se envían al servlet inventariaVideojuego para
                 inventariarlos en la BD --%>
            <form action="InventariarVideojuego" method="post" name="InventariarVideojuego" >
                <div class="tabla">

                    <%-- Num. de catálogo --%>
                    <div class="fila">
                        <div class="celda derecha">
                            <label for="claveId" >Núm. de catálogo</label>
                        </div>
                        <div class="celda">
                            <input type="text" id="claveId" name="clave"
                                   value="${param.clave}" size="7" maxlength="7" required
                                   placeholder="N&uacute;m de cat&aacute;logo" />
                        </div>
                        <div id="msjClave" class=" celda ${mensajes.clave.claseMensaje}">
                            ${mensajes.clave.mensaje}
                        </div>
                    </div>

                
                

                    <%-- Versión --%> 
                    <div class="fila">
                        <div class="celda derecha">
                            <label for="versionId" >cantidad</label>
                        </div>
                        <div class="celda">
                            <input type="text" id="versionId" name="cantidad"
                                   value="${param.cantidad}" size="5" maxlength="5"
                                   placeholder="Cantidad"/>
                        </div>
                        <div id="msjVersion" class="celda ${mensajes.cantidad.claseMensaje}">
                            ${mensajes.cantidad.mensaje}
                        </div>
                    </div>

                </div>
                <br/>
                <div class="tabla" >
                    <div class="fila">
                        <%-- Boton enviar --%>
                        <div class="celda">
                            <input type="submit" name="boton" value="Continuar" />
                        </div>
                        <%-- Boton limpiar --%>
                        <div class="celda">
                            <input type="reset" value="Limpiar" />
                        </div>
                    </div>
                </div>
            </form>
        </main>
    </body>                
</html>
