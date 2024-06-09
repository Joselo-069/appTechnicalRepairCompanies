package com.mycompany.apptechnicalrepaircompanies.dao;

import com.mycompany.apptechnicalrepaircompanies.models.User;
import java.util.List;

public interface IUserDao {
    
    final String SQL_USER_DETAIL_LOGIN = "SELECT * FROM usuarios WHERE username = ? AND password = sha1(?)";
    final String SQL_USER_DETAIL_USERNAME = "SELECT * FROM usuarios WHERE username = ?";
    final String SQL_USER_REGISTER = "INSERT INTO usuarios VALUES (?,?,?,?,?,sha1(?),?,?,?)";
    final String SQL_LIST_USER = "SELECT * FROM usuarios ORDER BY id_usuario DESC;";
    
    User getUserByUsernamePassword(String userName, String pass);
    String getUserByUsername(String userName);
    void registerUser(String nombre, String email, String telefono, String username, String pass, String permisos_string, String user);
    List<User> getListUsers();
}
