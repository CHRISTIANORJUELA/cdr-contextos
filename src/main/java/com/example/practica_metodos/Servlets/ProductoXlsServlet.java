package com.example.practica_metodos.Servlets;

import com.example.practica_metodos.models.Producto;
import com.example.practica_metodos.services.ProductoService;
import com.example.practica_metodos.services.ProductoServiceImpl;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import java.util.List;
@WebServlet(name = "Producto-servlet",value = {"/productos.xls", "/productos.html", "/productos"})
public class ProductoXlsServlet extends HttpServlet {
    @Inject
    @Named("productoServiceImpl")
    ProductoService productoService;
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Producto> productos = productoService.listar();
        resp.setContentType("text/html;charset=UTF-8");
        String servletPath = req.getServletPath();
        boolean esXls = servletPath.endsWith(".xls");
        if (esXls) {
            resp.setContentType("application/vnd.ms-excel");
            resp.setHeader("Content-Disposition",

                    "attachment;filename=productos.xls");
        }
        try (PrintWriter out = resp.getWriter()) {
            if(!esXls) {
                System.out.println("Entro");
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println(" <head>");
                out.println(" <meta charset=\"UTF-8\">");
                out.println(" <title>Listado de Productos</title>");
                out.println(" </head>");
                out.println(" <body>");
                out.println(" <h1>Listado de Productos!</h1>");
                out.println("<p><a href=\"" + req.getContextPath() +
                        "/productos.xls" + "\">exportar a xls</a></p>");
                out.println("<p><a href=\"" + req.getContextPath() +
                        "/productos.json" + "\">mostrar json</a></p>");
            }
            out.println("<table>");
            out.println("<tr>");
            out.println("<th>id</th>");
            out.println("<th>nombre</th>");
            out.println("<th>tipo</th>");
            out.println("<th>precio</th>");
            out.println("</tr>");
            productos.forEach(p ->{
                out.println("<tr>");
                out.println("<td>" + p.getId() + "</td>");
                out.println("<td>" + p.getName() + "</td>");
                out.println("<td>" + p.getType() + "</td>");
                out.println("<td>" + p.getPrecio() + "</td>");
                out.println("</tr>");
            });
            out.println("</table>");
            if(!esXls) {
                out.println(" </body>");
                out.println("</html>");
            }
        }
    }
}

