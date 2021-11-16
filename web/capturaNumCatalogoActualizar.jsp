<%-- 
    Created on : Nov 14, 2021, 4:10:00 AM
    Author     : utiakcovarrubias
--%>

<%-- 
    capturaNumCatalogo.jsp

    Esta página JSP permite capturar la clave de un videojuego a buscar
    dentro del catálogo de videojuegos. Forma parte de la aplicación videocentro
--%>

<!DOCTYPE html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta charset="utf-8">
        <title>Captura Num. Cat&aacute;logo</title>
        <link rel="stylesheet" type="text/css" href="css/estilos.css" />
        <link href="css/estilos2.css" rel="stylesheet" type="text/css"/>
    </head>

    <body>
        <%-- Incluye el encabezado de la pagina --%>
        <%@include file="jspf/titulo.jspf"%>

        <%-- Incluye el menu videojuegos --%>
        <%@include file="jspf/menuVideojuegos.jspf"%>

        <main>
            <h1>Videojuego a buscar</h1>
            <%-- Formulario para capturar el num. de catálogo de un videojuego.
                 La clave se envía al servlet obtenVideojuego para
                 obtener el videojuego de la BD --%>
            <form action="obtenVideojuegoActualizar" method="post" name="capturaNumCatalogoActualizar" >
                <%-- Los mensajes de validación del lado del servidor se
                     encuentran en el bean mensajes, almacenado en el
                     objeto request por el servlet obtenVideojuego. --%>
                <div class="tabla">
                    <div class="fila">
                        <div class="celda"><label for="claveId" >Num. de catálogo</label></div>
                        <div class="celda">
                            <input type="text" id="claveId" name="clave" 
                                   value="${param.clave}" size="7" pattern="^[A-Z]{3}[0-9]{4}$" 
                                   title="Tres letras may&uacute;sculas seguidas de 4 d&iacute;gitos"
                                   placeholder="ABC1234" required />
                        </div>
                        <div id="msjClave" class="celda ${mensajes.clave.claseMensaje}">
                            ${mensajes.clave.mensaje}
                        </div>
                    </div>
                </div>
                <br />
                <div class="tabla" >
                    <div class="fila">
                        <%-- Boton enviar --%>
                        <div class="celda">
                            <input type="submit" name="boton" value="Continuar" />
                        </div>
                        <%-- Botón limpiar --%>
                        <div class="celda">
                            <input type="reset" value="Limpiar" />
                        </div>
                    </div>
                </div>
            </form>
        </main>
    </body>
</html>
