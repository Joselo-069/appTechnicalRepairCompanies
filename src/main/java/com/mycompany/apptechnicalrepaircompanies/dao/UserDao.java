package com.mycompany.apptechnicalrepaircompanies.dao;

import com.mycompany.apptechnicalrepaircompanies.models.User;
import com.mycompany.apptechnicalrepaircompanies.utils.Conexion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class UserDao implements IUserDao{
     
    Conexion base = Conexion.getInstance();
    
    @Override
    public User getUserByUsernamePassword(String userName, String pass) {
        User user = new User();
        try {
            base.prest = base.conec.prepareStatement(SQL_USER_DETAIL_LOGIN);
            base.prest.setString(1, userName);
            base.prest.setString(2, pass);
            
            base.rt = base.prest.executeQuery();

            if (base.rt.next()) {

                user = new User(
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
        return user;
    }

    @Override
    public String getUserByUsername(String userName) {
        try {
            
            base.prest = base.conec.prepareStatement(SQL_USER_DETAIL_USERNAME);
            base.prest.setString(1, userName);
            
            base.rt = base.prest.executeQuery();

            if (base.rt.next()) {
                User user = new User(base.rt.getString("nombre_usuario"));
                return user.getNombre_usuario();
            }

        } catch (Exception e) {
            System.err.println("Error en conexion admnistrador");
        }
        
        return "";
    }

    @Override
    public void registerUser(String nombre, String email, String telefono, String username, String pass, String permisos_string, String user) {
        try {

            base.prest = base.conec.prepareStatement(SQL_USER_REGISTER);
            
            base.prest.setInt(1, 0);
            base.prest.setString(2, nombre);
            base.prest.setString(3, email);
            base.prest.setString(4, telefono);
            base.prest.setString(5, username);
            base.prest.setString(6, pass);
            base.prest.setString(7, permisos_string);
            base.prest.setString(8, "Activo");
            base.prest.setString(9, user);

            base.prest.executeUpdate();

            JOptionPane.showMessageDialog(null, "Registro Exitoso");
        } catch (SQLException e) {
            System.err.println("Error al registrar usuario" + e);
            JOptionPane.showMessageDialog(null, "Error al registrar usuario");
        }
    }

    @Override
    public List<User> getListUsers() {
            List<User> users = new ArrayList<>();
        try {
            base.prest = base.conec.prepareStatement(SQL_LIST_USER);
            base.rt = base.prest.executeQuery();
            
            while (base.rt.next()) {
                User user = new User(
                    base.rt.getInt("id_usuario"),
                    base.rt.getString("nombre_usuario"),
                    base.rt.getString("email"),
                    base.rt.getString("telefono"),
                    base.rt.getString("username"),
                    base.rt.getString("password"),
                    base.rt.getString("tipo_nivel"),
                    base.rt.getString("estatus"),
                    base.rt.getString("registrado_por")
                );

                users.add(user);
            }
            
            return users;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar la informacion");
        }
        return users;
    }
}