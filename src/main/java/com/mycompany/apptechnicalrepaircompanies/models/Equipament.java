package com.mycompany.apptechnicalrepaircompanies.models;

public class Equipament {
    
    private Integer id;
    private String model;
    private String type;
    private String brand;

    public Equipament() {
    }

    public Equipament(Integer id, String model, String type, String brand) {
        this.id = id;
        this.model = model;
        this.type = type;
        this.brand = brand;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    
    
}