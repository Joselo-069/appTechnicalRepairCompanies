package com.mycompany.apptechnicalrepaircompanies.models;

public class User {
   
    private Integer id_usuario;
    private String nombre_usuario;
    private String email;
    private String telefono;
    private String username;
    private String password;
    private String tipo_nivel;
    private String estatus;
    private String registrado_por;

    public User() {
    }
    
    public User(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public User(Integer id_usuario, String nombre_usuario, String email, String telefono, String username, String password, String tipo_nivel, String estatus, String registrado_por) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.email = email;
        this.telefono = telefono;
        this.username = username;
        this.password = password;
        this.tipo_nivel = tipo_nivel;
        this.estatus = estatus;
        this.registrado_por = registrado_por;
    }
    
    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

    public String getTipo_nivel() {
        return tipo_nivel;
    }

    public void setTipo_nivel(String tipo_nivel) {
        this.tipo_nivel = tipo_nivel;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getRegistrado_por() {
        return registrado_por;
    }

    public void setRegistrado_por(String registrado_por) {
        this.registrado_por = registrado_por;
    }
}