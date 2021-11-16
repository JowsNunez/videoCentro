<%-- 
    Document   : inventariarVideojuego
    Created on : 15/11/2021, 01:54:37 PM
    Author     : Andrea Borboa y Emilio.
--%>
<%-- 
    capturaVideojuegoDesinventariar.jsp

    Esta página JSP permite capturar los parametros de un videojuego para 
    desiventariarlo.
--%>

<%@page import="objetosNegocio.VideojuegoED"%>
<%@page import="persistencia.PersistenciaBD"%>
<%@page import="java.util.List"%>


<!DOCTYPE html>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<html>
    <head>
        <meta charset="utf-8">
        <title>INVENTARIO</title>
    </head>
    <body>
        <header>DESINVENTARIAR INVENTARIO</header>


        <nav>
            <button type="button" name="back" onclick="history.back()"></button>
            <ul>

                <li><a href="control?tarea=inventarear">Inventarear</a></li>
                <li><a href="control?tarea=desinventarear">Desinventarear</a></li>
                <li><a href="control?tarea=consultarInventario">Consultar inventario de videojuego</a></li>

            </ul>

        </nav>

        <article>
            
            <%
                PersistenciaBD crud = new PersistenciaBD();
                List<VideojuegoED> lista = crud.consultarInventarioVideojuegos();
                for (VideojuegoED elem : lista) {
                    if (elem.getVideojuego().getNumCatalogo().equals(session.getAttribute("numCatalogo"))) {
                        
                        session.setAttribute("existenciaMax", elem.getDisponibilidad());
                    }
                }
            %>
            
            <h1> ¡Ingresa la cantidad de existencia a quitar del videojuego!</h1>
            <form action="DesinventariarVideojuego" method="post" name="DesinventariarVideojuego" >
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
                            <label for="versionId" >Cantidad</label>
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
        </article>
    </body>
</html>
