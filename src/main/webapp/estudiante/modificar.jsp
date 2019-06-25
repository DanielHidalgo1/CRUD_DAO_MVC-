
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <title>modificar estudiante</title>
        <%@include file="../componentes/assets.jspf" %>

    </head>
    <body>
        <%@include file="../componentes/navBar.jspf" %>

        <style>
            #contenedor{
                margin:2% 10%;
            }
        </style>

        <div id="contenedor">
            <h1 class="text-center"><span class="fas fa-user"></span> Modificar Registro  </h1>
            <hr>
            <form action="Estudiante?action=modificar" method="Post">
                <div class="form-group">
                    <label for="id" class="fas fa-plus"> Id:</label>
                    <input value="${item.id}" class="form-control" type="number" name="id" placeholder="Digite su id..." readonly="readonly">
                </div>  
                <div class="form-group">
                    <label for="nombre" class="fas fa-plus"> Nombre:</label>
                    <input value="${item.nombre}" class="form-control" type="text" name="nombre" placeholder="Digite sus nombres...">
                </div>   

                <div class="form-group">
                    <label for="edad" class="fas fa-plus"> Edad:</label>
                    <input value="${item.edad}" class="form-control" type="number" name="edad" placeholder="Digite su edad...">
                </div>   
                <div class="form-group ">
                    <label for="direcicon" class="fas fa-plus"> Direccion:</label>
                    <textarea  class="form-control" placeholder="Digite su direccion..." name="direccion" rows="8" >${item.direccion}
                    </textarea>
                </div>
                <div class="form-group">
                    <label for="genero" class="fas fa-plus"> Genero:</label>
                    <select  name="genero" class="form-control">
                        <c:if test="${item.genero=='Masculino'}" >
                            <option selected value="Masculino">Masculino</option>
                            <option value="Femenino">Femenino</option>
                            <option value="Estrella de Mar">Estrella de Mar</option>
                            <option value="Esponja">Esponja</option>
                        </c:if>
                        <c:if test="${item.genero=='Estrella de mar'}" >
                            <option value="Masculino">Masculino</option>
                            <option value="Femenino">Femenino</option>
                            <option selected value="Estrella de Mar">Estrella de Mar</option>
                            <option value="Esponja">Esponja</option>
                        </c:if>
                        <c:if test="${item.genero=='Femenino'}" >
                            <option value="Masculino">Masculino</option>
                            <option selected value="Femenino">Femenino</option>
                            <option value="Estrella de Mar">Estrella de Mar</option>
                            <option value="Esponja">Esponja</option>
                        </c:if>
                        <c:if test="${item.genero=='Esponja'}" >
                            <option value="Masculino">Masculino</option>
                            <option value="Femenino">Femenino</option>
                            <option value="Estrella de Mar">Estrella de Mar</option>
                            <option selected value="Esponja">Esponja</option>
                        </c:if>

                    </select>
                </div> 
                <button class="btn btn-success mt-2" type="submit"><span class="fas fa-save"></span> Modificar</button>
                <a class="btn btn-danger mt-2" href="/CRUD_DAO_MVC/Estudiante"><span class="fas fa-minus-circle"></span> Cancelar</a>
            </form>

        </div>
    </body>
</html>
