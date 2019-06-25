<%--
    Document   : index
    Created on : 06-19-2019, 09:13:49 AM
    Author     : daniel.hidalgofgkah
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Estudiantes</title>
        <%@include file="../componentes/assets.jspf" %>
    </head>
    <body>
        <%@include file="../componentes/navBar.jspf" %>

        <h1 class="text-center container">Registros <span class="fas fa-file-alt"></span> </h1>
        <br>
        <div class="container">
            <a class="btn btn-primary" href="http://localhost:8080/CRUD_DAO_MVC/Estudiante?action=nuevo"><span class="fas fa-plus"></span> Nuevo</a>
            <br>        

            <table id="table_id" class="table">
                <br>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>NOMBRE</th>
                        <th>EDAD</th>
                        <th>DIRECCION</th>
                        <th>GENERO</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <tbody>

                    <c:forEach var="item" items="${listado}">
                        <tr>
                            <td><c:out value="${item.id}"></c:out></td>
                            <td><c:out value="${item.nombre}"></c:out></td>
                            <td><c:out value="${item.edad}"></c:out></td>
                            <td><c:out value="${item.direccion}"></c:out></td>
                            <td><c:out value="${item.genero}"></c:out></td>
                                <td>
                                    <a class="btn btn-warning fas fa-edit" href="http://localhost:8080/CRUD_DAO_MVC/Estudiante?action=mostrarModificar&id=${item.id}"></a>
                                    <a class="btn btn-danger fas fa-trash" href="http://localhost:8080/CRUD_DAO_MVC/Estudiante?action=mostrarEliminar&id=${item.id}"></a>
                                </td>
                        </tr>
                    </c:forEach>    
                </tbody>
            </table>
        </div>
        <script>
            $(document).ready(function () {
            $('#table_id').DataTable();
            });
        </script>
    </body>

</html>
