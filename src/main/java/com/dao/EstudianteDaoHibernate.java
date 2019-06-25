/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.data.HibernateUtil;
import com.idao.IEstudianteDao;
import com.modelos.Estudiantes;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author daniel.hidalgofgkah
 */
public class EstudianteDaoHibernate implements IEstudianteDao{
    
    Session session;
    SessionFactory sessionFactory;

    public EstudianteDaoHibernate() {
        sessionFactory = HibernateUtil.getSessionFactory();
        
    }
    
    

    @Override
    public List<Estudiantes> listar() {
        List<Estudiantes> lista = new ArrayList<Estudiantes>();
        
        
        session = sessionFactory.openSession();
         try {
            
             session.beginTransaction();
             lista = session.createNamedQuery("Estudiantes.findAll").list();
             
             return lista;
        } catch (Exception e) {
            session.getTransaction().rollback();
            return null;
        }
        
    }

    @Override
    public Estudiantes obtenerPorId(Integer id) {
        Estudiantes e = null;
        session = sessionFactory.openSession();
        session.beginTransaction();
        
        try {
            e = session.get(Estudiantes.class, id);
            session.getTransaction().commit();
            session.close();
            return e;
        } catch (Exception ex) {
            session.getTransaction().rollback();
            session.clear();
            session.close();
            return null;
        }
    }

    @Override
    public Boolean guardar(Estudiantes estudiante) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        
        try {
            Estudiantes e = new Estudiantes();
            e.setNombre(estudiante.getNombre());
            e.setEdad(estudiante.getEdad());
            e.setDireccion(estudiante.getDireccion());
            e.setGenero(estudiante.getGenero());
            
            session.save(e);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.clear();
            session.close();
            return false;
        }
    }

    @Override
    public Boolean modificar(Estudiantes estudiante) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        
        try {
            session.update(estudiante);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.clear();
            session.close();
            return false;
        }
    }

    @Override
    public Boolean eliminar(Estudiantes estudiante) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        
        try {
            session.remove(estudiante);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            session.clear();
            session.close();
            return false;
        }
    }
    
}
