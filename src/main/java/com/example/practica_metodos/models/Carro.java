package com.example.practica_metodos.models;

import jakarta.enterprise.context.SessionScoped;

import java.io.Serializable;

@SessionScoped
public class Carro implements Serializable {
    private String color;
    private String type;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "color='" + color + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
