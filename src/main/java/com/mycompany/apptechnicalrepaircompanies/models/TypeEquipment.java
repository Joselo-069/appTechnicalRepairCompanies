package com.mycompany.apptechnicalrepaircompanies.models;

public class TypeEquipment {
    
    private Integer id;
    private String name;
    private String status;

    public TypeEquipment() {
    }
    
    public TypeEquipment(Integer id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }
   
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }    
}
