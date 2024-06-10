package com.mycompany.apptechnicalrepaircompanies.dao;

import com.mycompany.apptechnicalrepaircompanies.models.Client;

public interface IEquipamentDao {

    /*** ****** ATRIBUTOS ******/
    final String SQL_EQUIPAMENTS_ID = "SELECT * FROM equipos WHERE id_cliente = ?";
    
    /*** ****** METODOS ******/
    Client getClientId(int id);

}
