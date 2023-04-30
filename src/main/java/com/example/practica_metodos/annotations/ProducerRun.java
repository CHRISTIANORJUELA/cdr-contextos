package com.example.practica_metodos.annotations;

import com.example.practica_metodos.enums.TypeClass;
import com.example.practica_metodos.services.ProductoService;
import com.example.practica_metodos.services.ProductoServiceImpl;
import jakarta.enterprise.inject.Produces;

import java.io.Serializable;

public class ProducerRun implements Serializable {
    private TypeClass typeClass;

    @Produces
    @Qualifierun(getValue = TypeClass.PRODUCT)
    public ProductoService getTypeClassProduct(){
        return new ProductoServiceImpl();
    }
}
