package com.mycompany.apptechnicalrepaircompanies.dao;

import com.mycompany.apptechnicalrepaircompanies.models.Equipament;
import java.util.List;

public interface IEquipamentDao {

    /*** ****** ATRIBUTOS ******/
    final String SQL_REGISTER_EQUIPAMENT = "INSERT INTO equipos VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    final String SQL_LIST_EQUIPAMENT = "SELECT id_equipo, tipo_equipo, marca, estatus FROM equipos";
    final String SQL_EQUIPAMENT_ID = "SELECT * FROM equipos WHERE id_equipo = ?";
    final String SQL_LIST_EQUIPAMENT_SEARCH = "SELECT id_equipo, tipo_equipo, marca, estatus FROM equipos WHERE estatus LIKE ?";
    final String SQL_EQUIPAMENTS_CLIENT_ID = "SELECT id_equipo, tipo_equipo, marca, estatus FROM equipos WHERE id_cliente = ?";
    final String SQL_UPDATE_EQUIPAMENT = "UPDATE equipos set tipo_equipo=?, marca=?, modelo=?, num_serie=?, observaciones=?, estatus=?, ultima_modificacion=? WHERE id_equipo = ?";
    final String SQL_UPDATE_EQUIPAMENT_TENCICO = "UPDATE equipos SET estatus=?, comentarios_tecnicos=?, revision_tecnica_de=? WHERE id_equipo = ?";
    final String SQL_GROUP_BY_STATUS = "SELECT estatus, count(estatus) as Marcas FROM equipos GROUP BY estatus";
    final String SQL_GROUP_BY_MARCA = "SELECT marca, count(marca) as Marcas FROM equipos GROUP BY marca";
            
    /*** ****** METODOS ******/
    void registerEquipament(int idCliente, String tipo_equipo, String marca, String modelo, String num_serie, String dia_ingreso, String mes_ingreso, String annio_ingreso, String observaciones, String estatus, String user);
    List<Equipament> getListEquipaments();
    Equipament getDetailEquipament(int idEquipament);
    List<Equipament> getListEquipamentsSearch(String estatus);
    List<Equipament> getEquimanentId(int idClient);
    void updateEquipament(int idEquipo,String tipo_equipo, String marca, String modelo, String num_serie, String observaciones, String estatus, String user);
    void updateEquipamentTecnico(int idEquipo, String estatus, String comentarios_tecnicos, String revision_tecnica_de);
    void drawEstatus();
    void drawMarcas();
}
