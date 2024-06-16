package com.mycompany.apptechnicalrepaircompanies.dao;

import com.mycompany.apptechnicalrepaircompanies.models.Equipament;
import java.util.List;

public interface IDeliverEquipament {
    
    /******** ATRIBUTOS ******/
    final String SQL_LIST_DELIVER_EQUIPAMENT = "SELECT\n"
            + "c.name, t.name, e.model, b.name, r.serial_number, r.technical_comments, d.since_date, d.technical_price, d.technical_review_by, d.status\n"
            + "FROM deliver_equipments d\n"
            + "INNER JOIN reviews r ON d.review_id = r.id\n"
            + "INNER JOIN clients c ON c.id = r.client_id\n"
            + "INNER JOIN equipments e ON e.id = r.equipament_id\n"
            + "INNER JOIN type_equipaments t ON e.type_id = t.id \n"
            + "INNER JOIN brands b ON e.brand_id = b.id";
   
    /*final String SQL_REGISTER_EQUIPAMENT = "INSERT INTO equipments VALUES (?,?,?,1)";
    final String SQL_UPDATE_EQUIPAMENT = "UPDATE equipments SET model=?, type_id=?, brand_id=? WHERE id = ?";
    final String SQL_DETAIL_EQUIPAMENT = "SELECT e.id, model, t.name AS type, b.name AS brand FROM equipments e INNER JOIN brands b ON e.brand_id=b.id INNER JOIN type_equipaments t ON t.id = e.type_id WHERE e.id = ?";
    final String SQL_DELTE_EQUIPAMENT = "UPDATE equipments SET status=0 WHERE id = ?";
    */
    /******** METODOS ******/
    List<Equipament> getListDeliverEquipament();
    /*
    void registerEquipament(String model, int type_id, int brand_id);
    Equipament getEquipamentId(int id);
    void registerEquipament(String model, int type_id, int brand_id);
    void updateEquipament(int id, String model, int type_id, int brand_id);
    void deleteEquipament(int id);*/
}
