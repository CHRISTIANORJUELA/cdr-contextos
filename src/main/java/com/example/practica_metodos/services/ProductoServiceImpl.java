package com.example.practica_metodos.services;

import com.example.practica_metodos.models.Producto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.util.Arrays;
import java.util.List;


@ApplicationScoped
@Named("productoServiceImpl")
public class ProductoServiceImpl implements ProductoService{
    @Override
    public List<Producto> listar() {
        return Arrays.asList(new Producto(1L, "Manzana", "Fruta", 3000),
                             new Producto(2L, "Yogur", "Lacteo", 1500),
                             new Producto(3L, "Agua", "Bebida", 2000));

    }
}
