<%-- 
    Document   : form-empleado
    Created on : 12 oct 2023, 18:56:10
    Author     : Santino
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <link rel="stylesheet" href="styles.css"/>
    </head>
    <body>
        <div class="container-md">

            <h3 class="link-light">Formulario Empleado</h3>

            <form action="EmpleadoController" method="post">
                <p>
                    <label for="nombreEmpleado" class="form-label">Nombre:</label>
                    <input id="nombreEmpleado" type="text" class="form-control" name="nombre" value="<c:out value="${empleado.nombre}"></c:out>">
                    </p>
                    <p>
                        <label for="deptoEmpleado" class="form-label">Departamento:</label>
                        <input id="deptoEmpleado" type="text" class="form-control" name="depto" value="<c:out value="${empleado.depto}"></c:out>">
                    </p>
                    <input type="hidden" name="id" value="<c:out value="${empleado.id}"></c:out>">
                <input type="submit" value="Guardar" class="btn btn-outline-light btn-dark">
            </form>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>          
    </body>
</html>