package com.mycompany.apptechnicalrepaircompanies.dao;

import com.mycompany.apptechnicalrepaircompanies.models.Equipament;
import com.mycompany.apptechnicalrepaircompanies.models.Review;
import com.mycompany.apptechnicalrepaircompanies.utils.Conexion;
import java.util.List;

public class ReviewDao implements IReviewDao {

    Equipament equipament = new Equipament();
    Conexion base = Conexion.getInstance();
    /*
    @Override
    public List<Equipament> getEquimanentId(int idClient) {
        
        List<Equipament> equipaments = new ArrayList<>();
        
        try {

            base.prest = base.conec.prepareStatement(SQL_EQUIPAMENTS_CLIENT_ID);
            base.prest.setInt(1, idClient);

            base.rt = base.prest.executeQuery();

            while (base.rt.next()) {
                equipament = new Equipament(
                        base.rt.getInt("id_equipo"),
                        base.rt.getString("tipo_equipo"),
                        base.rt.getString("marca"),
                        base.rt.getString("estatus"));

                equipaments.add(equipament);
            }

            return equipaments;

        } catch (Exception e) {
            System.err.println("Error en conexion admnistrador");
        }

        return equipaments;
    }

    @Override
    public void registerEquipament(int idCliente, String tipoEquipo, String marca, String modelo, String numSerie, String diaIngreso, String mesIngreso, String annioIngreso, String observaciones, String estatus, String user) {
        try {
            base.prest = base.conec.prepareStatement(SQL_REGISTER_EQUIPAMENT);

            base.prest.setInt(1, 0);
            base.prest.setInt(2, idCliente);
            base.prest.setString(3, tipoEquipo);
            base.prest.setString(4, marca);
            base.prest.setString(5, modelo);
            base.prest.setString(6, numSerie);s
            base.prest.setString(7, diaIngreso);
            base.prest.setString(8, mesIngreso);
            base.prest.setString(9, annioIngreso);
            base.prest.setString(10, observaciones);
            base.prest.setString(11, estatus);
            base.prest.setString(12, user);
            base.prest.setString(13, "");
            base.prest.setString(14, "");
            
            base.prest.executeUpdate();

            JOptionPane.showMessageDialog(null, "Equipo Registrado Exitosamente");
        } catch (SQLException e) {
            System.err.println("Error al registrar usuario" + e);
            JOptionPane.showMessageDialog(null, "Error al registrar usuario");
        }
    }

    @Override
    public void updateEquipament(int idEquipo, String tipo_equipo, String marca, String modelo, String num_serie, String observaciones, String estatus, String user) {
        try {

            base.prest = base.conec.prepareStatement(SQL_UPDATE_EQUIPAMENT);

            base.prest.setString(1, tipo_equipo);
            base.prest.setString(2, marca);
            base.prest.setString(3, modelo);
            base.prest.setString(4, num_serie);
            base.prest.setString(5, observaciones);
            base.prest.setString(6, estatus);
            base.prest.setString(7, user);
            base.prest.setInt(8, idEquipo);

            base.prest.executeUpdate();

            JOptionPane.showMessageDialog(null, "Equipo Modificado");

        } catch (SQLException e) {
            System.err.println("Error al actualizar " + e);
        }
    }

    @Override
    public List<Equipament> getListEquipaments() {
        List<Equipament> equipaments = new ArrayList<>();
        try {
            base.prest = base.conec.prepareStatement(SQL_LIST_EQUIPAMENT);
            base.rt = base.prest.executeQuery();

            while (base.rt.next()) {
                equipament = new Equipament(
                        base.rt.getInt("id_equipo"),
                        base.rt.getString("tipo_equipo"),
                        base.rt.getString("marca"),
                        base.rt.getString("estatus"));

                equipaments.add(equipament);
            }

            return equipaments;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar la informacion");
        }
        return equipaments;
    }

    @Override
    public List<Equipament> getListEquipamentsSearch(String estatus) {
        List<Equipament> equipaments = new ArrayList<>();
        try {
            base.prest = base.conec.prepareStatement(SQL_LIST_EQUIPAMENT_SEARCH);
            base.prest.setString(1, "%" + estatus + "%");
            base.rt = base.prest.executeQuery();

            while (base.rt.next()) {
                equipament = new Equipament(
                        base.rt.getInt("id_equipo"),
                        base.rt.getString("tipo_equipo"),
                        base.rt.getString("marca"),
                        base.rt.getString("estatus"));

                equipaments.add(equipament);
            }

            return equipaments;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar la informacion");
        }
        return equipaments;
    }

    @Override
    public Equipament getDetailEquipament(int idEquipament) {
        try {

            base.prest = base.conec.prepareStatement(SQL_EQUIPAMENT_ID);
            base.prest.setInt(1, idEquipament);

            base.rt = base.prest.executeQuery();

            if (base.rt.next()) {
                equipament = new Equipament(
                        base.rt.getInt("id_equipo"),
                        base.rt.getInt("id_cliente"),
                        base.rt.getString("tipo_equipo"),
                        base.rt.getString("marca"),
                        base.rt.getString("modelo"),
                        base.rt.getString("num_serie"),
                        base.rt.getString("dia_ingreso"),
                        base.rt.getString("mes_ingreso"),
                        base.rt.getString("annio_ingreso"),
                        base.rt.getString("observaciones"),
                        base.rt.getString("estatus"),
                        base.rt.getString("ultima_modificacion"),
                        base.rt.getString("comentarios_tecnicos"),
                        base.rt.getString("revision_tecnica_de")
                );

                return equipament;
            }

        } catch (Exception e) {
            System.err.println("Error en conexion admnistrador");
        }

        return equipament;
    }

    @Override
    public void updateEquipamentTecnico(int idEquipo, String estatus, String comentarios_tecnicos, String revision_tecnica_de) {
        try {

            base.prest = base.conec.prepareStatement(SQL_UPDATE_EQUIPAMENT_TENCICO);

            base.prest.setString(1, estatus);
            base.prest.setString(2, comentarios_tecnicos);
            base.prest.setString(3, revision_tecnica_de);
            base.prest.setInt(4, idEquipo);

            base.prest.executeUpdate();

            JOptionPane.showMessageDialog(null, "Equipo Modificado");

        } catch (SQLException e) {
            System.err.println("Error al actualizar " + e);
        }
    }

    @Override
    public void drawEstatus() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void drawMarcas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    */

    @Override
    public void registerReview(int idCliente, String tipo_equipo, String marca, String modelo, String num_serie, String dia_ingreso, String mes_ingreso, String annio_ingreso, String observaciones, String estatus, String user) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Review> getListEquipaments() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Review getDetailEquipament(int idEquipament) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Review> getListEquipamentsSearch(String estatus) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Review> getEquimanentId(int idClient) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateEquipament(int idEquipo, String tipo_equipo, String marca, String modelo, String num_serie, String observaciones, String estatus, String user) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateEquipamentTecnico(int idEquipo, String estatus, String comentarios_tecnicos, String revision_tecnica_de) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void drawEstatus() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void drawMarcas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}