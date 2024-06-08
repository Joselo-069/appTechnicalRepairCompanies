package com.mycompany.apptechnicalrepaircompanies.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Conexion {
    
    public static Connection conec = null; 
    public PreparedStatement prest = null;
    public Statement st = null;
    public ResultSet rt = null;
    
    public static String bd = "bd_ds";
    public static String user = "root";
    public static String pass = "";
    public static String host = "localhost";
    public static String port = "3306";
    
    private static Conexion instance = null;
    
    public static Conexion getInstance() {
        if (instance == null) {
            instance = new Conexion();
            conection();
        }
        try {
            if (conec.isClosed()) {
                conection();
            }
        } catch (SQLException ex) {
            System.out.println("Error de conexion" + ex);
        }
        return instance;
    }
    
    public static void conection() {
        try {
            String url = "jdbc:mysql://" + host + ":" + port + "/" + bd;
            conec = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Ha ocurrido un error al realizar la conexión al servidor de base de datos.\n"
                    + "Verifique los parámetros de conexión.\n\nDetalle de error:\n\n" + e
                    + "", "Error de conexión", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
}