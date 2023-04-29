package com.example.practica_metodos.controllers;

import com.example.practica_metodos.models.Producto;
import com.example.practica_metodos.services.Instances;
import com.example.practica_metodos.services.ModelFactoryService;

import java.util.List;

public class ModelFactoryController implements ModelFactoryService {

    Instances instances;
    private static class SingletonHolder {
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }
    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    public ModelFactoryController() {
        instances = new Instances();
    }

    //***********************-----------------**************************
    public List<Producto> listar(){
      return instances.getProductoService().listar();
    }
}
