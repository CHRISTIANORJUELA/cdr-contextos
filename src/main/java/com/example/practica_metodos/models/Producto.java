package com.example.practica_metodos.models;

import jakarta.enterprise.context.SessionScoped;

import java.io.Serializable;
@SessionScoped
public class Producto implements Serializable {
    private float id;
    private String name;
    private String type;
    private float precio;

    public Producto(float id, String name, String type, float precio) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.precio = precio;
    }

    public Producto() {
    }

    public float getId() {
        return id;
    }

    public void setId(float id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", precio=" + precio +
                '}';
    }
}
