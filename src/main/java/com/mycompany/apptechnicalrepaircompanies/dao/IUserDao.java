package com.mycompany.apptechnicalrepaircompanies.dao;

import com.mycompany.apptechnicalrepaircompanies.models.User;

public interface IUserDao {
    
    final String SQL_USER_DETAIL_LOGIN = "SELECT * FROM usuarios WHERE username = ? AND password = ?";
    final String SQL_USER_DETAIL_USERNAME = "SELECT * FROM usuarios WHERE username = ?";
    final String SQL_USER_REGISTER = "INSERT INTO usuarios VALUES (?,?,?,?,?,?,?,?,?)";
    
    User getUserByUsernamePassword(String userName, String pass);
    String getUserByUsername(String userName);
}
