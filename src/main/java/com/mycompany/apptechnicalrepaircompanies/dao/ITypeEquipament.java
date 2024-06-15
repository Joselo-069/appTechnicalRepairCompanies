package com.mycompany.apptechnicalrepaircompanies.dao;

import com.mycompany.apptechnicalrepaircompanies.models.TypeEquipment;
import java.util.List;

public interface ITypeEquipament {
    
    /******** ATRIBUTOS ******/
    final String SQL_LIST_TYPES = "SELECT * FROM type_equipaments"; 
    final String SQL_REGISTER_TYPE = "INSERT INTO type_equipaments VALUES (?,1)";
    final String SQL_UPDATE_TYPE = "UPDATE type_equipaments SET name=? WHERE id = ?";
    final String SQL_TYPE_ID = "SELECT * FROM type_equipaments WHERE id= ?";
    final String SQL_DELTE_TYPE = "UPDATE type_equipaments SET status=0 WHERE id = ?";

    /******** METODOS ******/
    TypeEquipment getTypeId(int id);
    List<TypeEquipment> getListTypes();
    void registerType(String name);
    void updateType(int id, String name);    
    void deleteType(int id);
}
