
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <title>Eliminar estudiante</title>
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
            <h1 class="text-center"><span class="fas fa-user"></span> Eliminar Registro  </h1>
            <hr>
            <form action="Estudiante?action=eliminar" method="Post">
                <div class="form-group">
                    <label for="id" class="fas fa-plus"> Id:</label>
                    <input value="${item.id}" class="form-control" type="number" name="id" placeholder="Digite su id..." readonly="readonly">
                </div>  
                <div class="form-group">
                    <label for="nombre" class="fas fa-plus"> Nombre:</label>
                    <input disabled value="${item.nombre}" class="form-control" type="text" name="nombre" placeholder="Digite sus nombres..." readonly="readonly">
                </div>   

                <div class="form-group">
                    <label for="edad" class="fas fa-plus"> Edad:</label>
                    <input disabled value="${item.edad}" class="form-control" type="number" name="edad" placeholder="Digite su edad..." readonly="readonly">
                </div>   
                <div class="form-group ">
                    <label for="direcicon" class="fas fa-plus"> Direccion:</label>
                    <textarea disabled  class="form-control" placeholder="Digite su direccion..." name="direccion" rows="8" readonly="readonly" >${item.direccion}
                    </textarea>
                </div>
                <div class="form-group">
                    <label for="genero" class="fas fa-plus"> Genero:</label>
                    <select  name="genero" class="form-control" disabled>
                        <c:if test="${item.genero=='masculino'}" >
                            <option selected value="masculino">Masculino</option>
                            <option value="femenino">Femenino</option>
                        </c:if>
                        <c:if test="${item.genero=='femenino'}" >
                            <option  value="masculino">Masculino</option>
                             <option selected value="femenino">Femenino</option>
                        </c:if>
                    </select>
                </div> 
                <button class="btn btn-warning mt-2" type="submit"><span class="fas fa-save"></span> Eliminar</button>
                <a class="btn btn-danger mt-2" href="/CRUD_DAO_MVC/Estudiante"><span class="fas fa-minus-circle"></span> Cancelar</a>
            </form>

        </div>
    </body>
</html>
