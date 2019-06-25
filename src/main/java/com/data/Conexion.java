
package com.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    
    private Connection jdbcConenection;
    private String jdbcUrl;
    private String jdbcUsername;
    private String jdbcPassword;
    private String jdbcServer;
    private String jdbcDataBase;

    public Conexion(Connection jdbcConenection, String jdbcUrl, String jdbcUsername) {
        this.jdbcConenection = jdbcConenection;
        this.jdbcUrl = jdbcUrl;
        this.jdbcUsername = jdbcUsername;
    }

    public Conexion() {
        this.jdbcServer="localhost";
        this.jdbcDataBase="cds_test";
        this.jdbcUrl="jdbc:mysql://localhost:3306/cds_test";
        this.jdbcUsername="root";
        this.jdbcPassword="";
    }
    
    public void conectar() throws SQLException {
        if (jdbcConenection == null || jdbcConenection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                 System.out.println("No Conectado a la BD...");
                throw new SQLException(e);
            }
            jdbcConenection = DriverManager.getConnection(
                    jdbcUrl, jdbcUsername, jdbcPassword);
            System.out.println("Conectado a la BD...");
        }
      
    }

    public void desconectar() throws SQLException {
        if (jdbcConenection != null && !jdbcConenection.isClosed()) {
            jdbcConenection.close();
        }
    }

    public Connection getJdbcConnection() {
        return jdbcConenection;
    }
        
}
