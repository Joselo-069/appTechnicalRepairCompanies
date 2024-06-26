package com.mycompany.apptechnicalrepaircompanies.dao;

import com.mycompany.apptechnicalrepaircompanies.models.Equipament;
import java.util.List;

public interface IEquipamentDao {
    
    /******** ATRIBUTOS ******/
    final String SQL_LIST_EQUIPAMENT = "SELECT e.id, model, t.name AS type, b.name AS brand FROM equipments e INNER JOIN brands b ON e.brand_id=b.id INNER JOIN type_equipaments t ON t.id = e.type_id"; 
    final String SQL_REGISTER_EQUIPAMENT = "INSERT INTO equipments (model, type_id, brand_id, status) VALUES (?,?,?,1)";
    final String SQL_UPDATE_EQUIPAMENT = "UPDATE equipments SET model=?, type_id=?, brand_id=? WHERE id = ?";
    final String SQL_DETAIL_EQUIPAMENT = "SELECT e.id, model, t.name AS type, b.name AS brand FROM equipments e INNER JOIN brands b ON e.brand_id=b.id INNER JOIN type_equipaments t ON t.id = e.type_id WHERE e.id = ?";
    final String SQL_DETAIL_EQUIPAMENT_BRAND_AND_TYPE = "SELECT e.id, model, t.name AS TYPE, b.name AS brand\n"
            + "FROM equipments e\n"
            + "INNER JOIN brands b ON e.brand_id=b.id\n"
            + "INNER JOIN type_equipaments t ON t.id = e.type_id \n"
            + "WHERE b.name = ? AND t.name = ? AND e.model = ?";
    final String SQL_DELTE_EQUIPAMENT = "UPDATE equipments SET status=0 WHERE id = ?";
   
    /******** METODOS ******/
    List<Equipament> getListEquipament();
    Equipament getEquipamentId(int id);
    Equipament getEquipamentBrandType(String model, String brand, String type);
    void registerEquipament(String model, int type_id, int brand_id);
    void updateEquipament(int id, String model, int type_id, int brand_id);
    void deleteEquipament(int id);
}
