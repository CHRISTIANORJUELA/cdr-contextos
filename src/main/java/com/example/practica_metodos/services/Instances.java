package com.example.practica_metodos.services;

public class Instances {
    ProductoServiceImpl productoService;
    public Instances(){
        productoService = new ProductoServiceImpl();
    }
    public ProductoServiceImpl getProductoService(){
        return productoService;
    }
}
