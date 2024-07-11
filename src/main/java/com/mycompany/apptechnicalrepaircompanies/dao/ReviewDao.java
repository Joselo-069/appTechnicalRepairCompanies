package com.mycompany.apptechnicalrepaircompanies.dao;

import com.mycompany.apptechnicalrepaircompanies.models.Equipament;
import com.mycompany.apptechnicalrepaircompanies.models.Review;
import com.mycompany.apptechnicalrepaircompanies.utils.Conexion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

public class ReviewDao implements IReviewDao {

    Equipament equipament = new Equipament();
    Conexion base = Conexion.getInstance();
    List<Equipament> equipaments = new ArrayList<>();
    
    Review review = new Review();
    List<Review> reviews = new ArrayList<>();
    
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
            base.prest.setString(12, last_update);
            
            base.prest.executeUpdate();

            JOptionPane.showMessageDialog(null, "Equipo Registrado Exitosamente");
        } catch (SQLException e) {
            System.err.println("Error al registrar usuario" + e);
            JOptionPane.showMessageDialog(null, "Error al registrar usuario");
        }
    }

    @Override
    public List<Review> getListReviews() {
        
            try {
                base.prest = base.conec.prepareStatement(SQL_LIST_REVIEW);
                base.rt = base.prest.executeQuery();

            while (base.rt.next()) {
                review = new Review(
                        base.rt.getInt("id"),
                        base.rt.getString("type"),
                        base.rt.getString("brand"),
                        base.rt.getString("model"),
                        base.rt.getString("status"));

                reviews.add(review);
            }

            return reviews;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar la informacion");
        }
        return reviews;
    }

    @Override
    public Review getDetailReview(int idEquipament) {
        try {

            base.prest = base.conec.prepareStatement(SQL_REVIEW_ID);
            base.prest.setInt(1, idEquipament);

            base.rt = base.prest.executeQuery();
            
            if (base.rt.next()) {

                review = new Review(
                        base.rt.getInt("id"),
                        base.rt.getString("type"),
                        base.rt.getString("brand"),
                        base.rt.getString("model"),
                        base.rt.getString("serial_number"),
                        base.rt.getString("day"),
                        base.rt.getString("month"),
                        base.rt.getString("year"),
                        base.rt.getString("observations"),
                        base.rt.getString("status"),
                        base.rt.getString("last_update"),
                        base.rt.getString("technical_comments"),
                        base.rt.getString("technical_review_by"),
                        base.rt.getString("name"),
                        base.rt.getString("email"));
                return review;
            }
        } catch (SQLException e) {
            System.err.println("Error en conexion admnistrador " + e);
        }

        return review;
    }
    
    @Override
    public List<Review> getListReviewsSearch(String estatus) {
          List<Review> reviews = new ArrayList<>();
        try {
            base.prest = base.conec.prepareStatement(SQL_LIST_REVIEW_SEARCH);
            base.prest.setString(1, "%" + estatus + "%");
            base.rt = base.prest.executeQuery();

            while (base.rt.next()) {
                review = new Review(
                        base.rt.getInt("id"),
                        base.rt.getString("type"),
                        base.rt.getString("brand"),
                        base.rt.getString("model"),
                        base.rt.getString("status"));

                reviews.add(review);
            }

            return reviews;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar la informacion");
        }
        return reviews;
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
    public void updateReviewTechnical(int id, String status, String coment_technical, String review_technical_by) {
        try {

            base.prest = base.conec.prepareStatement(SQL_UPDATE_REVIEW_TECHNICAL);

            base.prest.setString(1, status);
            base.prest.setString(2, coment_technical);
            base.prest.setString(3, review_technical_by);
            base.prest.setInt(4, id);

            base.prest.executeUpdate();

            JOptionPane.showMessageDialog(null, "Equipo Modificado");

        } catch (SQLException e) {
            System.err.println("Error al actualizar " + e);
        }
    }
    
    @Override
    public Map<String, Integer> getReportStatus() {
        
        Map<String, Integer> listReport = new HashMap<>();
        
        try {
            base.prest = base.conec.prepareStatement(SQL_GROUP_BY_STATUS);
            base.rt = base.prest.executeQuery();
            
            while (base.rt.next()) {
                listReport.put(base.rt.getString("status"), base.rt.getInt("countStatus"));
            }

        } catch (Exception e) {
            System.err.println("Error en conexion admnistrador");
        }

        return listReport;
    }

    @Override
    public void updateReview(int idEquipament, String image, String serial_number, String observations, String status, String last_update, int idReview) {
       try {

            base.prest = base.conec.prepareStatement(SQL_UPDATE_REVIEW);

            base.prest.setInt(1, idEquipament);
            base.prest.setString(2, image);
            base.prest.setString(3, serial_number);
            base.prest.setString(4, observations);
            base.prest.setString(5, status);
            base.prest.setString(6, last_update);
            base.prest.setInt(7, idReview);

            base.prest.executeUpdate();

            JOptionPane.showMessageDialog(null, "Equipo Modificado");

        } catch (SQLException e) {
            System.err.println("Error al actualizar " + e);
        }    
    }
}
