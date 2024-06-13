package com.mycompany.apptechnicalrepaircompanies.dao;

import com.mycompany.apptechnicalrepaircompanies.models.Client;
import java.util.List;


public interface IClientDao {
    /******** ATRIBUTOS ******/
    final String SQL_LIST_CLIENTS = "SELECT * FROM clients"; 
    final String SQL_REGISTER_CLIENT = "INSERT INTO clients VALUES (?,?,?,?,?,?)";
    final String SQL_UPDATE_CLIENT = "UPDATE clients SET name=?, email=?, phone=?, address=?, last_update=? WHERE id = ?";
    final String SQL_CLIENT_ID = "SELECT * FROM clients WHERE id= ?";
    /******** METODOS ******/
    Client getClientId(int id);
    List<Client> getListClients();
    void registerClient(String name, String email, String phone, String address, String user);
    void updateClient(int id, String name, String email, String phone, String address, String user);
}
