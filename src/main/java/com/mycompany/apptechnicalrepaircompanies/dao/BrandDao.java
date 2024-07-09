
package com.mycompany.apptechnicalrepaircompanies.dao;

import com.mycompany.apptechnicalrepaircompanies.models.Brand;
import com.mycompany.apptechnicalrepaircompanies.utils.Conexion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

public class BrandDao implements IBrandDao{

    Conexion base = Conexion.getInstance();
    Brand brand = new Brand();
    List<Brand> brands = new ArrayList<>();
    
    @Override
    public List<Brand> getListBrands() {
        try {
            base.prest = base.conec.prepareStatement(SQL_LIST_BRANDS);
            base.rt = base.prest.executeQuery();

            while (base.rt.next()) {
                brand = new Brand(base.rt.getInt("id"), base.rt.getString("name"), base.rt.getString("status"));
                
                if (brand.getStatus().equals("1")) { brands.add(brand); }
            }

            return brands;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar la informacion");
        }
        return brands;
    }

    @Override
    public Brand getBrandId(int id) {
        try {

            base.prest = base.conec.prepareStatement(SQL_DETAIL_BRAND);
            base.prest.setInt(1, id);

            base.rt = base.prest.executeQuery();

            if (base.rt.next()) {
                brand = new Brand(
                        base.rt.getInt("id"),
                        base.rt.getString("name"),
                        base.rt.getString("status"));
                return brand;
            }

        } catch (Exception e) {
            System.err.println("Error en conexion admnistrador");
        }

        return brand;
    }

    @Override
    public void registerBrand(String name) {
        try {
            base.prest = base.conec.prepareStatement(SQL_REGISTER_BRAND);

            base.prest.setString(1, name);

            base.prest.executeUpdate();

            JOptionPane.showMessageDialog(null, "Marca Registrado Exitosamente");
        } catch (SQLException e) {
            System.err.println("Error al registrar usuario" + e);
            JOptionPane.showMessageDialog(null, "Error al registrar Marca");
        }
    }

    @Override
    public void updateBrand(int id, String name) {
        try {

            base.prest = base.conec.prepareStatement(SQL_UPDATE_BRAND);

            base.prest.setString(1, name);
            base.prest.setInt(2, id);

            base.prest.executeUpdate();

            JOptionPane.showMessageDialog(null, "Marca Modificado");

        } catch (SQLException e) {
            System.err.println("Error al actualizar " + e);
        }
    }

    @Override
    public void deleteBrand(int id) {
        try {

            base.prest = base.conec.prepareStatement(SQL_UPDATE_BRAND);

            base.prest.setInt(1, id);

            base.prest.executeUpdate();

            JOptionPane.showMessageDialog(null, "Marca Modificado");

        } catch (SQLException e) {
            System.err.println("Error al actualizar " + e);
        }
    }

    @Override
    public Brand getBrandIName(String name) {
        try {

            base.prest = base.conec.prepareStatement(SQL_DETAIL_BRAND_NAME);
            base.prest.setString(1, name);

            base.rt = base.prest.executeQuery();

            if (base.rt.next()) {
                brand = new Brand(
                        base.rt.getInt("id"),
                        base.rt.getString("name"),
                        base.rt.getString("status"));
                return brand;
            }

        } catch (Exception e) {
            System.err.println("Error en conexion admnistrador");
        }

        return brand;
    }

    @Override
    public Map<String, String> getReportBrand() {
        Map<String, String> listReport = new HashMap<>();
        
        try {
            base.prest = base.conec.prepareStatement(SQL_GROUP_BY_MARCA);
            base.rt = base.prest.executeQuery();
            
            while (base.rt.next()) {
                listReport.put(base.rt.getString("name"), base.rt.getString("countBrand"));
            }

        } catch (Exception e) {
            System.err.println("Error en conexion admnistrador");
        }

        return listReport;
    }
}
