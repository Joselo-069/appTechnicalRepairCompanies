package com.mycompany.apptechnicalrepaircompanies.dao;

import com.mycompany.apptechnicalrepaircompanies.models.DeliverEquipment;
import java.util.List;

public interface IDeliverEquipament {
    
    /******** ATRIBUTOS ******/
    final String SQL_LIST_DELIVER_EQUIPAMENT = "SELECT d.id, CONCAT_WS(' ', c.name, c.email) AS fullname, t.name AS type, e.model AS model, b.name AS brand, r.serial_number, r.technical_comments, d.since_date, d.technical_price, d.technical_review_by, d.status\n"
            + "FROM deliver_equipments d\n"
            + "INNER JOIN reviews r ON d.review_id = r.id\n"
            + "INNER JOIN clients c ON c.id = r.client_id\n"
            + "INNER JOIN equipments e ON e.id = r.equipament_id\n"
            + "INNER JOIN type_equipaments t ON e.type_id = t.id \n"
            + "INNER JOIN brands b ON e.brand_id = b.id\n"
            + "ORDER BY d.since_date DESC";
   
    final String SQL_REGISTER_DELIVER_EQUIPAMENT = "INSERT INTO deliver_equipments (review_id, since_date, technical_price, technical_review_by, status) \n"
            + "VALUES (?, CURDATE(), ?, ?, ?);";
    
    /******** METODOS ******/
    List<DeliverEquipment> getListDeliverEquipament();
    void registerDeliverEquipament(int review_id, String technical_price, String technical_review_by);
}
