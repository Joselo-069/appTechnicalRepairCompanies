package com.mycompany.apptechnicalrepaircompanies.dao;

import com.mycompany.apptechnicalrepaircompanies.models.Brand;
import java.util.List;
import java.util.Map;

public interface IBrandDao {
    
    /******** ATRIBUTOS ******/
    final String SQL_LIST_BRANDS = "SELECT * FROM brands"; 
    final String SQL_REGISTER_BRAND = "INSERT INTO brands VALUES (?,1)";
    final String SQL_UPDATE_BRAND = "UPDATE brands SET name=? WHERE id = ?";
    final String SQL_DETAIL_BRAND = "SELECT * FROM brands WHERE id= ?";
    final String SQL_DETAIL_BRAND_NAME = "SELECT * FROM brands WHERE name= ?";
    final String SQL_DELTE_BRAND = "UPDATE brands SET status=0 WHERE id = ?";
    final String SQL_GROUP_BY_MARCA = "SELECT b.name, COUNT(b.name) as countBrand \n"
            + "FROM reviews r \n"
            + "INNER JOIN equipments e ON e.id = r.equipament_id\n"
            + "INNER JOIN type_equipaments t ON e.type_id = t.id \n"
            + "INNER JOIN brands b ON e.brand_id = b.id \n"
            + "GROUP BY b.name;";
    
    /******** METODOS ******/
    List<Brand> getListBrands();
    Brand getBrandId(int id);
    Brand getBrandIName(String name);
    void registerBrand(String name);
    void updateBrand(int id, String name);
    void deleteBrand(int id);
    Map<String, String> getReportBrand();
}
