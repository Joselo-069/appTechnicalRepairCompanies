
package com.mycompany.apptechnicalrepaircompanies.models;

public class Review {
    
    private Integer id;
    private String type;
    private String brand;
    private String model;
    private String serial_number;
    private String day;
    private String month;
    private String year;
    private String observations;
    private String status;
    private String last_update;
    private String technical_comments;
    private String technical_review;

    public Review() {
    }

    public Review(Integer id, String type, String brand, String model, String serial_number, String day, String month, String year, String observations, String status, String last_update, String technical_comments, String technical_review) {
        this.id = id;
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.serial_number = serial_number;
        this.day = day;
        this.month = month;
        this.year = year;
        this.observations = observations;
        this.status = status;
        this.last_update = last_update;
        this.technical_comments = technical_comments;
        this.technical_review = technical_review;
    }

    public Review(Integer id, String type, String brand, String model, String status) {
        this.id = id;
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.status = status;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLast_update() {
        return last_update;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }

    public String getTechnical_comments() {
        return technical_comments;
    }

    public void setTechnical_comments(String technical_comments) {
        this.technical_comments = technical_comments;
    }

    public String getTechnical_review() {
        return technical_review;
    }

    public void setTechnical_review(String technical_review) {
        this.technical_review = technical_review;
    }
    
    
}
