
package com.idao;


import com.modelos.Estudiantes;
import java.util.List;

public interface IEstudianteDao {
    
    //METODOS PARA OBTENER REGISTROS
    public List<Estudiantes> listar();
    public Estudiantes obtenerPorId(Integer id);
    
    //METODOS PARA OPERACIONES IMPORTANTES PARA EL CRUD
    public Boolean guardar(Estudiantes estudiante);
    public Boolean modificar(Estudiantes estudiante);
    public Boolean eliminar(Estudiantes estudiante);
}
