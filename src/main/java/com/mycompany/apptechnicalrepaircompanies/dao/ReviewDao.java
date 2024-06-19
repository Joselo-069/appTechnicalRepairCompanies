package com.mycompany.apptechnicalrepaircompanies.dao;

import com.mycompany.apptechnicalrepaircompanies.models.Equipament;
import com.mycompany.apptechnicalrepaircompanies.models.Review;
import com.mycompany.apptechnicalrepaircompanies.utils.Conexion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ReviewDao implements IReviewDao {

    Equipament equipament = new Equipament();
    Conexion base = Conexion.getInstance();
    List<Equipament> equipaments = new ArrayList<>();
    
    Review review = new Review();
    List<Review> reviews = new ArrayList<>();
    
    /*@Override
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
    public void registerReview(int idClient, int idEquipament, String image, String numSerie, String day, String month, String year, String observations, String status, String last_update) {
        try {
            base.prest = base.conec.prepareStatement(SQL_REGISTER_REVIEW);

            base.prest.setInt(1, idClient);
            base.prest.setInt(2, idEquipament);
            base.prest.setString(3, image);
            base.prest.setString(4, numSerie);
            base.prest.setString(5, day);
            base.prest.setString(6, month);
            base.prest.setString(7, year);
            base.prest.setString(8, observations);
            base.prest.setString(9, status);
            base.prest.setString(10, last_update);
            base.prest.setString(11, ""); // Comentarios técnicos vacíos
            base.prest.setString(12, "");
            
            base.prest.executeUpdate();

            JOptionPane.showMessageDialog(null, "Equipo Registrado Exitosamente");
        } catch (SQLException e) {
            System.err.println("Error al registrar usuario" + e);
            JOptionPane.showMessageDialog(null, "Error al registrar usuario");
        }
    }

    @Override
    public List<Review> getListReviews() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Review getDetailReview(int idEquipament) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Review> getListReviewsSearch(String estatus) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Review> getReviewClientId(int idClient) {
        try {

            base.prest = base.conec.prepareStatement(SQL_REVIEW_CLIENT_ID);
            base.prest.setInt(1, idClient);

            base.rt = base.prest.executeQuery();

            while (base.rt.next()) {
                review = new Review(
                        base.rt.getInt("id"),
                        base.rt.getString("model"),
                        base.rt.getString("type"),
                        base.rt.getString("brand"),
                        base.rt.getString("status"));
                      
                reviews.add(review);
            }

            return reviews;

        } catch (Exception e) {
            System.err.println("Error en conexion admnistrador");
        }

        return reviews;
    }

    @Override
    public void updateReview(int idEquipo, String tipo_equipo, String marca, String modelo, String num_serie, String observaciones, String estatus, String user) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateReviewTechnical(int idEquipo, String estatus, String comentarios_tecnicos, String revision_tecnica_de) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void reportStatus() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void reportBrands() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
