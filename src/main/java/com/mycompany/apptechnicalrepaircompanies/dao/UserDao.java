package com.mycompany.apptechnicalrepaircompanies.dao;

import com.mycompany.apptechnicalrepaircompanies.models.User;
import com.mycompany.apptechnicalrepaircompanies.utils.Conexion;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UserDao implements IUserDao{
     
    Conexion base = Conexion.getInstance();
    
    @Override
    public User getUserByUsernamePassword(String userName, String pass) {
        try {
            base.prest = base.conec.prepareStatement(SQL_USER_DETAIL_LOGIN);
            base.prest.setString(1, userName);
            base.prest.setString(2, pass);
            
            base.rt = base.prest.executeQuery();

            if (base.rt.next()) {

                User user = new User(
                        base.rt.getInt("id_usuario"),
                        base.rt.getString("nombre_usuario"),
                        base.rt.getString("email"),
                        base.rt.getString("telefono"),
                        base.rt.getString("username"),
                        base.rt.getString("password"),
                        base.rt.getString("tipo_nivel"),
                        base.rt.getString("estatus"),
                        base.rt.getString("registrado_por"));
                
                return user;

            } else {
                JOptionPane.showMessageDialog(null, "Datos de acceso incorrecto");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al iniciar sesion, conectate al administrador");
        }
        return null;
    }

    @Override
    public String getUserByUsername(String userName) {
        try {
            
            base.prest = base.conec.prepareStatement(SQL_USER_DETAIL_USERNAME);
            base.prest.setString(1, userName);
            
            base.rt = base.prest.executeQuery();

            if (base.rt.next()) {
                User user = new User(base.rt.getString("nombre_usuario"));
                System.out.println("dao " + user);
                return user.getNombre_usuario();
            }

        } catch (Exception e) {
            System.err.println("Error en conexion admnistrador");
        }
        
        return null;
    }
    
}