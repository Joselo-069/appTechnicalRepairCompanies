package com.mycompany.apptechnicalrepaircompanies.dao;

import com.mycompany.apptechnicalrepaircompanies.models.User;
import java.util.List;

public interface IUserDao {
    
    /******** ATRIBUTOS ******/
    final String SQL_USER_DETAIL_LOGIN = "SELECT * FROM usuarios WHERE username = ? AND password = sha1(?)";
    final String SQL_USER_DETAIL_USERNAME = "SELECT * FROM usuarios WHERE username = ?";
    final String SQL_USER_DETAIL_UPDATE = "SELECT * FROM usuarios WHERE username = ? AND NOT id_usuario = ?";
    final String SQL_USER_REGISTER = "INSERT INTO usuarios VALUES (?,?,?,?,?,sha1(?),?,?,?)";
    final String SQL_LIST_USER = "SELECT * FROM usuarios ORDER BY id_usuario DESC;";
    final String SQL_USER_UPDATE = "UPDATE usuarios SET nombre_usuario=?, email=?, telefono=?, username=?, tipo_nivel=?, estatus=? WHERE id_usuario= ?";
    final String SQL_USER_UPDATE_PASSWORD = "UPDATE usuarios SET password = sha1(?) WHERE username = ?";
    
    /******** METODOS ******/
    User getUserByUsernamePassword(String userName, String pass);
    User getUserByUsername(String userName);
    User getUserByUsernameUpdate(String userName, int idUser);
    void registerUser(String nombre, String email, String telefono, String username, String pass, String permisos_string, String user);
    void updateUser(int idUser, String nombre, String email, String telefono, String username, String permisos_string, String estatus_string);
    void updatePasswordUser(String psw, String username);
    List<User> getListUsers();
}
