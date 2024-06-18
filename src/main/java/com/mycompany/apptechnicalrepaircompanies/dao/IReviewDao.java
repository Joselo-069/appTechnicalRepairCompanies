package com.mycompany.apptechnicalrepaircompanies.dao;

import com.mycompany.apptechnicalrepaircompanies.models.Review;
import java.util.List;

public interface IReviewDao {
    /*** ****** ATRIBUTOS ******/
    final String SQL_REGISTER_REVIEW = "INSERT INTO reviews VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
    //final String SQL_LIST_REVIEW = "SELECT id, type, brand, status FROM reviews";
    final String SQL_LIST_REVIEW = "SELECT r.id, t.name, b.name, r.status FROM reviews r INNER JOIN equipments e INNER JOIN type_equipaments t ON e.type_id = t.id INNER JOIN brands b ON e.brand_id = b.id";
    final String SQL_REVIEW_ID = "SELECT * FROM reviews WHERE id = ?";
    //final String SQL_LIST_REVIEW_SEARCH = "SELECT id, type, brand, status FROM reviews WHERE status LIKE ?";
    final String SQL_LIST_REVIEW_SEARCH = "SELECT r.id, t.name, b.name, r.status FROM reviews r INNER JOIN equipments e INNER JOIN type_equipaments t ON e.type_id = t.id INNER JOIN brands b ON e.brand_id = b.id WHERE status LIKE ?";
    //final String SQL_REVIEW_CLIENT_ID = "SELECT id_equipo AS id, tipo_equipo AS type, marca AS brand, estatus FROM equipos WHERE id_cliente = ?";
    final String SQL_REVIEW_CLIENT_ID = "SELECT r.id AS id, e.model AS model, t.name AS TYPE, b.name AS brand, r.status AS STATUS\n" +
                                        "FROM reviews r\n" +
                                        "INNER JOIN equipments e ON e.id = r.equipament_id\n" +
                                        "INNER JOIN type_equipaments t ON e.type_id = t.id\n" +
                                        "INNER JOIN brands b ON e.brand_id = b.id\n" +
                                        "WHERE client_id = ?";
    
    //final String SQL_UPDATE_REVIEW = "UPDATE reviews set tipo_equipo=?, marca=?, modelo=?, num_serie=?, observaciones=?, estatus=?, ultima_modificacion=? WHERE id_equipo = ?";
    final String SQL_UPDATE_REVIEW = "UPDATE reviews set equipament_id=?, image=?, serial_number=?, observations=?, status=?, last_update=? WHERE id = ?";
    // final String SQL_UPDATE_REVIEW_TENCICO = "UPDATE equipos SET estatus=?, comentarios_tecnicos=?, revision_tecnica_de=? WHERE id_equipo = ?";
    final String SQL_UPDATE_REVIEW_TENCICO = "UPDATE reviews SET status=?, technical_comments=?, technical_review_by=? WHERE id = ?";
    final String SQL_GROUP_BY_STATUS = "SELECT status, count(status) as CountStatus FROM reviews GROUP BY status";
    final String SQL_GROUP_BY_MARCA = "SELECT b.name, COUNT(b.name) as CountBrand FROM reviews r INNER JOIN equipments e INNER JOIN type_equipaments t ON e.type_id = t.id INNER JOIN brands b ON e.brand_id = b.id GROUP BY b.name";
            
    /*** ****** METODOS ******/
    void registerReview(int idCliente, String tipo_equipo, String marca, String modelo, String num_serie, String dia_ingreso, String mes_ingreso, String annio_ingreso, String observaciones, String estatus, String user);
    List<Review> getListReviews();
    Review getDetailReview(int idEquipament);
    List<Review> getListReviewsSearch(String status);
    List<Review> getReviewClientId(int idClient);
    void updateReview(int idEquipo,String tipo_equipo, String marca, String modelo, String num_serie, String observaciones, String estatus, String user);
    void updateReviewTechnical(int idEquipo, String estatus, String comentarios_tecnicos, String revision_tecnica_de);
    void reportStatus();
    void reportBrands();
}
