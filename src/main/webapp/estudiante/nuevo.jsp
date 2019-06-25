<%-- 
    Document   : nuevo
    Created on : 06-19-2019, 10:30:58 AM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <title>nuevo estudiante</title>
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
            <h1 class="text-center"><span class="fas fa-user"></span> Nuevo Registro  </h1>
            <hr>

            <form action="Estudiante?action=guardar" method="Post">
                <div class="form-group">
                    <label for="nombre" class="fas fa-plus"> Nombre:</label>
                    <input class="form-control" type="text" name="nombre" placeholder="Digite sus nombres...">
                </div>   

                <div class="form-group">
                    <label for="edad" class="fas fa-plus"> Edad:</label>
                    <input class="form-control" type="number" name="edad" placeholder="Digite su edad...">
                </div>   
                <div class="form-group ">
                    <label for="direcicon" class="fas fa-plus"> Direccion:</label>
                    <textarea class="form-control" placeholder="Digite su direccion..." name="direccion" rows="8" ></textarea>
                </div>
                <div class="form-group">
                    <label for="genero" class="fas fa-plus"> Genero:</label>
                    <select name="genero" class="form-control">
                        <option value="Masculino">Masculino</option>
                        <option value="Femenino">Femenino</option>
                        <option value="Estrella de Mar">Estrella de Mar</option>
                        <option value="Esponja">Esponja</option>
                    </select>
                </div> 
                <button class="btn btn-primary mt-2" type="submit"><span class="fas fa-save"></span> Guardar</button>
                <a class="btn btn-danger mt-2" href="/CRUD_DAO_MVC/Estudiante"><span class="fas fa-minus-circle"></span> Cancelar</a>
            </form>

        </div>
    </body>
</html>
