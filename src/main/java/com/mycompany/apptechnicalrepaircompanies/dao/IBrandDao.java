package com.mycompany.apptechnicalrepaircompanies.dao;

import com.mycompany.apptechnicalrepaircompanies.models.Brand;
import java.util.List;

public interface IBrandDao {
    
    /******** ATRIBUTOS ******/
    final String SQL_LIST_BRANDS = "SELECT * FROM brands"; 
    final String SQL_REGISTER_BRAND = "INSERT INTO brands VALUES (?,1)";
    final String SQL_UPDATE_BRAND = "UPDATE brands SET name=? WHERE id = ?";
    final String SQL_DETAIL_BRAND = "SELECT * FROM brands WHERE id= ?";
    final String SQL_DETAIL_BRAND_NAME = "SELECT * FROM brands WHERE name= ?";
    final String SQL_DELTE_BRAND = "UPDATE brands SET status=0 WHERE id = ?";
    
    /******** METODOS ******/
    List<Brand> getListBrands();
    Brand getBrandId(int id);
    Brand getBrandIName(String name);
    void registerBrand(String name);
    void updateBrand(int id, String name);
    void deleteBrand(int id);
}
