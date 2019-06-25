/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author daniel.hidalgofgkah
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
            Configuration cfg = new Configuration();
            cfg.configure("hibernate.cfg.xml");
            sessionFactory = cfg.buildSessionFactory();
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Problemas con la seccion: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
