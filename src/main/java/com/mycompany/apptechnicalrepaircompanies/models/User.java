package com.mycompany.apptechnicalrepaircompanies.models;

public class User {
   
    private Integer id;
    private String name;
    private String email;
    private String phone;
    private String username;
    private String password;
    private String type;
    private String status;
    private String register_by;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public User(Integer id, String name, String email, String phone, String username, String password, String type, String status, String register_by) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.type = type;
        this.status = status;
        this.register_by = register_by;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRegister_by() {
        return register_by;
    }

    public void setRegister_by(String register_by) {
        this.register_by = register_by;
    }
}