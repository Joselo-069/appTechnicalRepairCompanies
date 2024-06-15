package com.mycompany.apptechnicalrepaircompanies.dao;

import com.mycompany.apptechnicalrepaircompanies.models.Equipament;
import com.mycompany.apptechnicalrepaircompanies.utils.Conexion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class EquipamentDao implements IEquipamentDao {

    Conexion base = Conexion.getInstance();
    Equipament equipament = new Equipament();
    List<Equipament> equipaments = new ArrayList<>();

    @Override
    public List<Equipament> getListEquipament() {
        try {
            base.prest = base.conec.prepareStatement(SQL_LIST_EQUIPAMENT);
            base.rt = base.prest.executeQuery();

            while (base.rt.next()) {
                equipament = new Equipament(
                        base.rt.getInt("id"),
                        base.rt.getString("model"),
                        base.rt.getString("type"),
                        base.rt.getString("brand"));
                
                equipaments.add(equipament);
            }

            return equipaments;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar la informacion");
        }
        return equipaments;
    }

    @Override
    public Equipament getEquipamentId(int id) {
        try {

            base.prest = base.conec.prepareStatement(SQL_DETAIL_EQUIPAMENT);
            base.prest.setInt(1, id);

            base.rt = base.prest.executeQuery();

            if (base.rt.next()) {
                equipament = new Equipament(
                        base.rt.getInt("id"),
                        base.rt.getString("model"),
                        base.rt.getString("type"),
                        base.rt.getString("brand"));
                return equipament;
            }

        } catch (Exception e) {
            System.err.println("Error en conexion admnistrador");
        }

        return equipament;
    }

    @Override
    public void registerEquipament(String model, int type_id, int brand_id) {
        try {
            base.prest = base.conec.prepareStatement(SQL_REGISTER_EQUIPAMENT);

            base.prest.setString(1, model);
            base.prest.setInt(2, type_id);
            base.prest.setInt(3, brand_id);
            
            base.prest.executeUpdate();

            JOptionPane.showMessageDialog(null, "Equipo Registrado Exitosamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar equipo" + e);
        }
    }

    @Override
    public void updateEquipament(int id, String model, int type_id, int brand_id) {
        try {

            base.prest = base.conec.prepareStatement(SQL_UPDATE_EQUIPAMENT);

            base.prest.setString(1, model);
            base.prest.setInt(2, type_id);
            base.prest.setInt(3, brand_id);
            base.prest.setInt(4, id);

            base.prest.executeUpdate();

            JOptionPane.showMessageDialog(null, "Equipo Modificado");

        } catch (SQLException e) {
            System.err.println("Error al actualizar " + e);
        }
    }

    @Override
    public void deleteEquipament(int id) {
        try {

            base.prest = base.conec.prepareStatement(SQL_DELTE_EQUIPAMENT);

            base.prest.setInt(1, id);

            base.prest.executeUpdate();

            JOptionPane.showMessageDialog(null, "Equipo Modificado");

        } catch (SQLException e) {
            System.err.println("Error al actualizar " + e);
        }    
    }

}
