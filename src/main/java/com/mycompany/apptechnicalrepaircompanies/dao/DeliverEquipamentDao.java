package com.mycompany.apptechnicalrepaircompanies.dao;

import com.mycompany.apptechnicalrepaircompanies.emuns.StatusDeliver;
import com.mycompany.apptechnicalrepaircompanies.models.DeliverEquipment;
import com.mycompany.apptechnicalrepaircompanies.utils.Conexion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DeliverEquipamentDao implements IDeliverEquipament{
    
    Conexion base = Conexion.getInstance();
    List<DeliverEquipment> deliverEquipaments = new ArrayList<>();
    DeliverEquipment deliver = new DeliverEquipment();

    @Override
    public List<DeliverEquipment> getListDeliverEquipament() {
        try {
            base.prest = base.conec.prepareStatement(SQL_LIST_DELIVER_EQUIPAMENT);
            base.rt = base.prest.executeQuery();

            while (base.rt.next()) {
                deliver = new DeliverEquipment(
                        base.rt.getInt("id"),
                        base.rt.getString("fullname"),
                        base.rt.getString("type"),
                        base.rt.getString("model"),
                        base.rt.getString("brand"),
                        base.rt.getString("serial_number"),
                        base.rt.getString("technical_comments"),
                        base.rt.getString("since_date"),
                        base.rt.getString("technical_price"),
                        base.rt.getString("technical_review_by"),
                        base.rt.getString("status")
                );

                deliverEquipaments.add(deliver);
            }
            
            return deliverEquipaments;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar la informacion");
        }
        return deliverEquipaments;
    }

    @Override
    public void registerDeliverEquipament(int review_id, String technical_price, String technical_review_by) {
        try {
            base.prest = base.conec.prepareStatement(SQL_REGISTER_DELIVER_EQUIPAMENT);

            base.prest.setInt(1, review_id);
            base.prest.setString(2, technical_price);
            base.prest.setString(3, technical_review_by);
            base.prest.setString(4, StatusDeliver.noentregado.name());

            base.prest.executeUpdate();

            //JOptionPane.showMessageDialog(null, "Equipo Reparado Registrado Exitosamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar equipo" + e);
        }
    }
}