package com.mycompany.apptechnicalrepaircompanies.dao;

import com.mycompany.apptechnicalrepaircompanies.models.User;
import java.util.List;

public interface IUserDao {
    
    /******** ATRIBUTOS ******/
    final String SQL_USER_DETAIL_LOGIN = "SELECT * FROM users WHERE username = ? AND password = sha1(?)";
    final String SQL_USER_DETAIL_USERNAME = "SELECT * FROM users WHERE username = ?";
    final String SQL_USER_DETAIL_UPDATE = "SELECT * FROM users WHERE username = ? AND NOT id = ?";
    final String SQL_USER_REGISTER = "INSERT INTO users VALUES (?,?,?,?,?,sha1(?),?,?,?)";
    final String SQL_LIST_USER = "SELECT * FROM users ORDER BY id DESC;";
    final String SQL_USER_UPDATE = "UPDATE users SET name=?, email=?, phone=?, username=?, type=?, status=? WHERE id= ?";
    final String SQL_USER_UPDATE_PASSWORD = "UPDATE users SET password = sha1(?) WHERE username = ?";
    
    /******** METODOS ******/
    User getUserByUsernamePassword(String userName, String pass); 
    User getUserByUsername(String userName);
    User getUserByUsernameUpdate(String userName, int idUser);
    void registerUser(String name, String email, String phone, String username, String pass, String type, String user);
    void updateUser(int idUser, String name, String email, String phone, String username, String type, String status);
    void updatePasswordUser(String psw, String username);
    List<User> getListUsers();
}
