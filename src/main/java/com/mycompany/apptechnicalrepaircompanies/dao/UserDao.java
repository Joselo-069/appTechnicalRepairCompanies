package com.mycompany.apptechnicalrepaircompanies.dao;

import com.mycompany.apptechnicalrepaircompanies.emuns.EstatusUser;
import com.mycompany.apptechnicalrepaircompanies.models.User;
import com.mycompany.apptechnicalrepaircompanies.utils.Conexion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class UserDao implements IUserDao{
     
    Conexion base = Conexion.getInstance();
    User user = new User();

    @Override
    public User getUserByUsernamePassword(String userName, String pass) {
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
    public User getUserByUsername(String userName) {
        try {
            
            base.prest = base.conec.prepareStatement(SQL_USER_DETAIL_USERNAME);
            base.prest.setString(1, userName);
            
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
            }

        } catch (Exception e) {
            System.err.println("Error en conexion admnistrador");
        }
        
        return user;
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
            base.prest.setString(8, EstatusUser.Activo.name());
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

    @Override
    public User getUserByUsernameUpdate(String userName, int idUser) {
        try {

            base.prest = base.conec.prepareStatement(SQL_USER_DETAIL_UPDATE);
            base.prest.setString(1, userName);
            base.prest.setInt(2, idUser);

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
            }

        } catch (Exception e) {
            System.err.println("Error en conexion admnistrador");
        }

        return user;
    }

    @Override
    public void updateUser(int idUser, String nombre, String email, String telefono, String username, String permisos_string, String estatus_string) {
        try {
            
            base.prest = base.conec.prepareStatement(SQL_USER_UPDATE);

            base.prest.setString(1, nombre);
            base.prest.setString(2, email);
            base.prest.setString(3, telefono);
            base.prest.setString(4, username);
            base.prest.setString(5, permisos_string);
            base.prest.setString(6, estatus_string);
            base.prest.setInt(7, idUser);

            base.prest.executeUpdate();

            JOptionPane.showMessageDialog(null, "Usuario Modificado");

        } catch (SQLException e) {
            System.err.println("Error al actualizar " + e);
        }
    }

    @Override
    public void updatePasswordUser(String psw, String username) {
        try {
            
            base.prest = base.conec.prepareStatement(SQL_USER_UPDATE_PASSWORD);

            base.prest.setString(1, psw);
            base.prest.setString(2, username);

            base.prest.executeUpdate();

            JOptionPane.showMessageDialog(null, "Contraseña Modificada");

        } catch (SQLException e) {
            System.err.println("Error al actualizar " + e);
        }
    }
}