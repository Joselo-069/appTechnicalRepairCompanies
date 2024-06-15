package com.mycompany.apptechnicalrepaircompanies.models;

public class DeliverEquipment {
    
    private Integer id;
    private String fullname;
    private String type;
    private String model;
    private String brand;
    private String serial_number;
    private String technical_comments;
    private String since_date;
    private String technical_price;
    private String technical_review_by;
    private String status; // entregado, no entregado

    public DeliverEquipment() {
    }

    public DeliverEquipment(Integer id, String fullname, String type, String model, String brand, String serial_number, String technical_comments, String since_date, String technical_price, String technical_review_by, String status) {
        this.id = id;
        this.fullname = fullname;
        this.type = type;
        this.model = model;
        this.brand = brand;
        this.serial_number = serial_number;
        this.technical_comments = technical_comments;
        this.since_date = since_date;
        this.technical_price = technical_price;
        this.technical_review_by = technical_review_by;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }

    public String getTechnical_comments() {
        return technical_comments;
    }

    public void setTechnical_comments(String technical_comments) {
        this.technical_comments = technical_comments;
    }

    public String getSince_date() {
        return since_date;
    }

    public void setSince_date(String since_date) {
        this.since_date = since_date;
    }

    public String getTechnical_price() {
        return technical_price;
    }

    public void setTechnical_price(String technical_price) {
        this.technical_price = technical_price;
    }

    public String getTechnical_review_by() {
        return technical_review_by;
    }

    public void setTechnical_review_by(String technical_review_by) {
        this.technical_review_by = technical_review_by;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
