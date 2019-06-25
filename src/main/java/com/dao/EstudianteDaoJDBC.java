
package com.dao;

import com.data.Conexion;
import com.idao.IEstudianteDao;
import com.modelos.Estudiantes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class EstudianteDaoJDBC implements IEstudianteDao{

    Conexion con;
    Connection mcon;
    
    public EstudianteDaoJDBC() {
        con=new Conexion();
    }
    
    
    
    @Override
    public List<Estudiantes> listar() {
        
       List<Estudiantes> lista=new ArrayList<Estudiantes>();
       
       String sql="select * from estudiantes";
       
        try {
            con.conectar();
            mcon=con.getJdbcConnection();
            
            Statement st= mcon.createStatement();
           
            ResultSet r=st.executeQuery(sql);
            
            //se recorre el result set, que es como
            //una pequeña base de datos
            while (r.next()) {                
                Estudiantes e=new Estudiantes();
                e.setId(r.getInt("id"));
                e.setNombre(r.getString("nombre"));
                e.setEdad(r.getInt("edad"));
                e.setDireccion(r.getString("direccion"));
                e.setGenero(r.getString("genero"));
                
                //se agrega a la lista el estudiante
                lista.add(e);
            }
            
            con.desconectar();
            mcon.close();
            
            return lista;
        } catch (Exception e) {
            return null;
        }
       
    }

  
    public Estudiantes obtenerPorId(Integer id) {
       Estudiantes e=new Estudiantes();
       
       String sql="select * from estudiantes where id=?";
       
        try {
            con.conectar();
            mcon=con.getJdbcConnection();
            
            PreparedStatement pst= mcon.prepareStatement(sql);
            pst.setInt(1, id);
           
            
            ResultSet r=pst.executeQuery();
            
            //se recorre el result set, que es como
            //una pequeña base de datos
            if(r.next()) {                
             
                e.setId(r.getInt("id"));
                e.setNombre(r.getString("nombre"));
                e.setEdad(r.getInt("edad"));
                e.setDireccion(r.getString("direccion"));
                e.setGenero(r.getString("genero"));
            }
            
            con.desconectar();
            mcon.close();
            
            return e;
        } catch (SQLException ex) {
            return null;
        }
        
    }

    @Override
    public Boolean guardar(Estudiantes estudiante) {
        String sql="Insert into estudiantes(nombre,edad,direccion,genero) values(?,?,?,?)";
        
        try {
            con.conectar();
            mcon=con.getJdbcConnection();
            
            PreparedStatement pst= mcon.prepareStatement(sql);
            //paso de valores a la SQL
            pst.setString(1, estudiante.getNombre());
            pst.setInt(2, estudiante.getEdad());
            pst.setString(3, estudiante.getDireccion());
            pst.setString(4, estudiante.getGenero());
            
            Boolean filasAfectadas=pst.executeUpdate()>0;    
            
            pst.close();
            con.desconectar();
            mcon.close();
            
            System.out.println("registro guardado");
            
            return filasAfectadas; 
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean modificar(Estudiantes estudiante) {
         String sql="Update estudiantes set nombre=?,edad=?,direccion=?,genero=? where id=?";
        
        try {
            con.conectar();
            mcon=con.getJdbcConnection();
            
            PreparedStatement pst= mcon.prepareStatement(sql);
            //paso de valores a la SQL
            pst.setString(1, estudiante.getNombre());
            pst.setInt(2, estudiante.getEdad());
            pst.setString(3, estudiante.getDireccion());
            pst.setString(4, estudiante.getGenero());
            pst.setInt(5, estudiante.getId());
            
            Boolean filasAfectadas=pst.executeUpdate()>0;    
            
            pst.close();
            con.desconectar();
            mcon.close();
            
            System.out.println("registro modificado");
            
            return filasAfectadas; 
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean eliminar(Estudiantes estudiante) {
        String sql="delete from estudiantes where id=?";
        
        try {
            con.conectar();
            mcon=con.getJdbcConnection();
            
            PreparedStatement pst= mcon.prepareStatement(sql);
            //paso de valores a la SQL
          
            pst.setInt(1, estudiante.getId());
            
            Boolean filasAfectadas=pst.executeUpdate()>0;    
            
            pst.close();
            con.desconectar();
            mcon.close();
            
            System.out.println("registro eliminado");
            
            return filasAfectadas; 
        } catch (Exception e) {
            return false;
        }   
    }
    
}
