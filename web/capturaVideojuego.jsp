<%-- 
    Created on : Nov 14, 2021, 4:10:00 AM
    Author     : utiakcovarrubias
--%>
<%--
    capturaVideojuego.jsp
    
    Esta página JSP permite capturar los datos de un videojuego. Forma parte de 
    la aplicación VideoCentro.
--%>

<!DOCTYPE html>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<html>
    <head>
        <meta charset="utf-8">
        <title>Captura Videojuego</title>
        <link rel="stylesheet" type="text/css" href="css/estilos.css" />
        <link href="css/estilos2.css" rel="stylesheet" type="text/css"/>
    </head>

    <body>
        <%-- Incluye el encabezado de la pagina --%>
        <%@include file="jspf/titulo.jspf"%>

        <%-- Incluye el menu videojuegos --%>
        <%@include file="jspf/menuVideojuegos.jspf"%>

        <main>
            <h1>Captura Videojuego</h1>

            <%-- Formulario para capturar los atributos de un videojuego.
                 Los datos se envían al servlet agregaVideojuego para
                 guardarlos en la BD --%>
            <form action="agregaVideojuego" method="post" name="capturaVideojuego" >

                <%-- Los mensajes de validación del lado del servidor se
                     encuentran en el bean mensajes, almacenado en el
                     objeto request por el servlet agregaVideojuego. --%>
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
                    
                    <%-- Título --%>
                    <div class="fila">
                        <div class="celda derecha">
                            <label for="tituloId" >Titulo</label>
                        </div>
                        <div class="celda">
                            <input type="text" id="tituloId" name="titulo" 
                                   value="${param.titulo}" size="35" maxlength="35" required
                                   placeholder="T&iacute;tulo del videojuego" />
                        </div>
                        <div id="msjTitulo" class=" celda ${mensajes.titulo.claseMensaje}">
                            ${mensajes.titulo.mensaje}
                        </div>
                    </div>
                        
                    <%-- Género --%>
                    <div class="fila">
                        <div class="celda derecha">
                            <label for="generoId" >Género</label>
                        </div>
                        <div class="celda">
                            <input type="text" id="generoId" name="genero" 
                                   value="${param.genero}" size="20" maxlength="20" required
                                   placeholder="G&eacute;nero del videojuego"/>
                        </div>
                        <div id="msjGenero" class=" celda ${mensajes.genero.claseMensaje}">
                            ${mensajes.genero.mensaje}
                        </div>
                    </div>
                    
                    <%-- Clasificación --%>  
                    <div class="fila">
                        <div class="celda derecha">
                            <label for="clasificacionId" >Clasificación</label>
                        </div>
                        <div class="celda">
                            <input type="text" id="clasificacionId" name="clasificacion" 
                                   value="${param.clasificacion}" size="20" maxlength="20"
                                   placeholder="Clasificaci&oacute;n del videojuego"/>
                        </div>
                        <div id="msjClasificacion" class="celda ${mensajes.clasificacion.claseMensaje}">
                            ${mensajes.clasificacion.mensaje}
                        </div>
                    </div>
                    
                    <%-- Consola --%>      
                    <div class="fila">
                        <div class="celda derecha">
                            <label for="consolaId" >Consola</label>
                        </div>
                        <div class="celda">
                            <input type="text" id="consolaId" name="consola" 
                                   value="${param.consola}" size="20" maxlength="20"
                                   placeholder="Consola del videojuego"/>
                        </div>
                        <div id="msjConsola" class="celda ${mensajes.consola.claseMensaje}">
                            ${mensajes.consola.mensaje}
                        </div>
                    </div>
                    
                    <%-- Fabricante --%> 
                    <div class="fila">
                        <div class="celda derecha">
                            <label for="fabricanteId" >Fabricante</label>
                        </div>
                        <div class="celda">
                            <input type="text" id="fabricanteId" name="fabricante"
                                    value="${param.fabricante}" size="35" maxlength="35"
                                    placeholder="Fabricante del videojuego"/>
                        </div>
                        <div id="msjFabricante" class="celda ${mensajes.fabricante.claseMensaje}">
                            ${mensajes.fabricante.mensaje}
                        </div>
                    </div>
                        
                    <%-- Versión --%> 
                    <div class="fila">
                        <div class="celda derecha">
                            <label for="versionId" >Versión</label>
                        </div>
                        <div class="celda">
                            <input type="text" id="versionId" name="version"
                                    value="${param.version}" size="5" maxlength="5"
                                    placeholder="Versi&oacute;n del videojuego"/>
                        </div>
                        <div id="msjVersion" class="celda ${mensajes.version.claseMensaje}">
                            ${mensajes.version.mensaje}
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
