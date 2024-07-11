package com.mycompany.apptechnicalrepaircompanies.dao;

import com.mycompany.apptechnicalrepaircompanies.models.TypeEquipment;
import com.mycompany.apptechnicalrepaircompanies.utils.Conexion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class TypeEquipamentDao implements ITypeEquipament{

    Conexion base = Conexion.getInstance();
    TypeEquipment type = new TypeEquipment();
    List<TypeEquipment> types = new ArrayList<>();
    
    @Override
    public TypeEquipment getTypeId(int id) {
        try {

            base.prest = base.conec.prepareStatement(SQL_TYPE_ID);
            base.prest.setInt(1, id);

            base.rt = base.prest.executeQuery();

            if (base.rt.next()) {
                type = new TypeEquipment(
                        base.rt.getInt("id"),
                        base.rt.getString("name"),
                        base.rt.getString("status"));
                return type;
            }

        } catch (Exception e) {
            System.err.println("Error en conexion admnistrador");
        }

        return type;
    }

    @Override
    public List<TypeEquipment> getListTypes() {
        try {
            base.prest = base.conec.prepareStatement(SQL_LIST_TYPES);
            base.rt = base.prest.executeQuery();

            while (base.rt.next()) {
                type = new TypeEquipment(
                        base.rt.getInt("id"),
                        base.rt.getString("name"),
                        base.rt.getString("status"));

                types.add(type);
            }

            return types;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar la informacion");
        }
        return types;
    }

    @Override
    public void registerType(String name) {
        try {
            base.prest = base.conec.prepareStatement(SQL_REGISTER_TYPE);
            base.prest.setString(1, name);
            
            base.prest.executeUpdate();

            JOptionPane.showMessageDialog(null, "Tipo de equipo Registrado Exitosamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al tipo equipo" + e);
        }    
    }

    @Override
    public void updateType(int id, String name) {
        try {

            base.prest = base.conec.prepareStatement(SQL_UPDATE_TYPE);

            base.prest.setString(1, name);
            base.prest.setInt(2, id);

            base.prest.executeUpdate();

            JOptionPane.showMessageDialog(null, "Tipo equipo Modificado");

        } catch (SQLException e) {
            System.err.println("Error al actualizar " + e);
        }
    }

    @Override
    public void deleteType(int id) {
        try {

            base.prest = base.conec.prepareStatement(SQL_DELTE_TYPE);

            base.prest.setInt(1, id);

            base.prest.executeUpdate();

            JOptionPane.showMessageDialog(null, "Tipo equipo Modificado");

        } catch (SQLException e) {
            System.err.println("Error al actualizar " + e);
        }
    }

    @Override
    public TypeEquipment getTypeName(String name) {
        try {

            base.prest = base.conec.prepareStatement(SQL_TYPE_NAME);
            base.prest.setString(1, name);

            base.rt = base.prest.executeQuery();

            if (base.rt.next()) {
                type = new TypeEquipment(
                        base.rt.getInt("id"),
                        base.rt.getString("name"),
                        base.rt.getString("status"));
                return type;
            }

        } catch (Exception e) {
            System.err.println("Error en conexion admnistrador");
        }

        return type;
    }

}
