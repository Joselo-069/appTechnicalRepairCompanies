package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    public static Connection conection(){
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_ds", "root", "");
            return cn;
        } catch (SQLException e) {
            System.out.println("Error de conexcion" + e);
        }
        
        return (null);
    }
}
