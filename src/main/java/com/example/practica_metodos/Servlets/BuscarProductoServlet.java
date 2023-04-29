package com.example.practica_metodos.Servlets;

import com.example.practica_metodos.controllers.ModelFactoryController;
import com.example.practica_metodos.exeptions.ServiceJdbcException;
import com.example.practica_metodos.models.Producto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/buscarProducto")
public class BuscarProductoServlet extends HttpServlet {
    ModelFactoryController mfc = ModelFactoryController.getInstance();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("idproducto"));
        Optional<Producto> obj = mfc.listar().stream().filter(x-> x.getId()==id).findFirst();
        obj.ifPresentOrElse( x -> {
               System.out.println(x);
               req.setAttribute("obj",x);
            try {
                req.getRequestDispatcher("/buscarProducto.jsp").forward(req,resp);
            } catch (IOException | ServletException e) {
                throw new ServiceJdbcException("Error en devolver el producto");
            }
        },()-> {
            try {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND,"Lo sentimos pero el producto que buscaste con ese Id not existe");
            } catch (IOException e) {
                throw new ServiceJdbcException("Error en imprimir mensaje de error");
            }
        });
    }
}
