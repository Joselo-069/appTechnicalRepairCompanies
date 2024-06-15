package com.mycompany.apptechnicalrepaircompanies.dao;

import com.mycompany.apptechnicalrepaircompanies.models.Review;
import java.util.List;

public interface IReviewDao {
    /*** ****** ATRIBUTOS ******/
    final String SQL_REGISTER_REVIEW = "INSERT INTO reviews VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
    //final String SQL_LIST_REVIEW = "SELECT id, type, brand, status FROM reviews";
    final String SQL_LIST_REVIEW = "SELECT r.id, t.name, b.name, r.status FROM reviews r INNER JOIN equipments e INNER JOIN type_equipaments t ON e.type_id = t.id INNER JOIN brands b ON e.brand_id = b.id";
    final String SQL_REVIEW_ID = "SELECT * FROM reviews WHERE id = ?";
    final String SQL_LIST_REVIEW_SEARCH = "SELECT id, type, brand, status FROM reviews WHERE status LIKE ?";
    final String SQL_REVIEW_CLIENT_ID = "SELECT id_equipo, tipo_equipo, marca, estatus FROM equipos WHERE id_cliente = ?";
    final String SQL_UPDATE_REVIEW = "UPDATE equipos set tipo_equipo=?, marca=?, modelo=?, num_serie=?, observaciones=?, estatus=?, ultima_modificacion=? WHERE id_equipo = ?";
    final String SQL_UPDATE_REVIEW_TENCICO = "UPDATE equipos SET estatus=?, comentarios_tecnicos=?, revision_tecnica_de=? WHERE id_equipo = ?";
    
    final String SQL_GROUP_BY_STATUS = "SELECT status, count(status) as CountStatus FROM reviews GROUP BY status";
    final String SQL_GROUP_BY_MARCA = "SELECT marca, count(marca) as CountBrand FROM equipos GROUP BY marca";
            
    /*** ****** METODOS ******/
    void registerReview(int idCliente, String tipo_equipo, String marca, String modelo, String num_serie, String dia_ingreso, String mes_ingreso, String annio_ingreso, String observaciones, String estatus, String user);
    List<Review> getListEquipaments();
    Review getDetailEquipament(int idEquipament);
    List<Review> getListEquipamentsSearch(String estatus);
    List<Review> getEquimanentId(int idClient);
    void updateEquipament(int idEquipo,String tipo_equipo, String marca, String modelo, String num_serie, String observaciones, String estatus, String user);
    void updateEquipamentTecnico(int idEquipo, String estatus, String comentarios_tecnicos, String revision_tecnica_de);
    void drawEstatus();
    void drawMarcas();
}
