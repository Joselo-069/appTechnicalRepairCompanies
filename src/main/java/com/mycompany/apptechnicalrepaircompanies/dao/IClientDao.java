package com.mycompany.apptechnicalrepaircompanies.dao;

import com.mycompany.apptechnicalrepaircompanies.models.Client;
import java.util.List;


public interface IClientDao {
    /******** ATRIBUTOS ******/
    final String SQL_LIST_CLIENTS = "SELECT * FROM clientes"; 
    final String SQL_REGISTER_CLIENT = "INSERT INTO clientes VALUES (?,?,?,?,?,?)";
    final String SQL_UPDATE_CLIENT = "UPDATE clientes SET nombre_cliente=?, mail_cliente=?, tel_cliente=?, dir_cliente=?, ultima_modificacion=? WHERE id_cliente = ?";
    final String SQL_CLIENT_ID = "SELECT * FROM clientes WHERE id_cliente = ?";
    /******** METODOS ******/
    Client getClientId(int id);
    List<Client> getListClients();
    void registerClient(String nombre, String email, String telefono, String direccion, String user);
    void updateClient(int id, String nombre, String email, String telefono, String direccion, String user);
}
