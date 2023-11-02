<%-- 
    Document   : list
    Created on : 12 oct 2023, 18:55:57
    Author     : Santino
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administración de Empleados</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <link rel="stylesheet" href="styles.css"/>
    </head>
    <body>
        <div class="container-md">
            <div class="navbar">
                <a href="EmpleadoController?accion=nuevo" class="btn btn-secondary btn-lg">Nuevo empleado</a>
                <form action="EmpleadoController" class="d-flex" method="GET" role="search">
                    <input type="search" name="txtBuscar" class="form-control me-2" id="search" aria-label="Search">
                    <input type="submit" name="accion" value="Buscar" class="btn btn-success">
                </form>
            </div>

            <div class="">
                <table border="1" class="table table-dark table-striped table-bordered table-hover">
                    <thead>
                        <tr class="text-center text-uppercase">
                            <th scope="col">id</th>
                            <th scope="col">nombre</th>
                            <th scope="col">departamento</th>
                            <th scope="col">acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="empleado" items="${list}">
                            <tr>
                                <td class="text-center"><c:out value="${empleado.id}"></c:out></td>
                                <td><c:out value="${empleado.nombre}"></c:out></td>
                                <td><c:out value="${empleado.depto}"></c:out></td>
                                <td class="text-center"><a href="EmpleadoController?accion=edit&id=<c:out value="${empleado.id}"></c:out>" class="btn btn-warning">Actualizar</a>  <a href="EmpleadoController?accion=delete&id=<c:out value="${empleado.id}"></c:out>" class="btn btn-danger">Eliminar</a></td>
                                </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    </body>
</html>
