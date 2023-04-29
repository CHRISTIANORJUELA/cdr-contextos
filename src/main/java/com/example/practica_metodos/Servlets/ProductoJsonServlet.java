package com.example.practica_metodos.Servlets;

import com.example.practica_metodos.models.Producto;
import com.example.practica_metodos.services.ProductoService;
import com.example.practica_metodos.services.ProductoServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/productos.json")
public class ProductoJsonServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ServletInputStream jsonStream = req.getInputStream();
        ObjectMapper mapper = new ObjectMapper();
        Producto producto = mapper.readValue(jsonStream, Producto.class);
        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("    <head>");
            out.println("        <meta charset=\"UTF-8\">");
            out.println("        <title>Detalle de producto desde json</title>");
            out.println("    </head>");
            out.println("    <body>");
            out.println("        <h1>Detalle de producto desde json!</h1>");
            out.println("<ul>");
            out.println("<li>Id: "+ producto.getId() + "</li>");
            out.println("<li>Nombre: " + producto.getName() + "</li>");
            out.println("<li>Tipo: " + producto.getType() + "</li>");
            out.println("<li>Precio: " + producto.getPrecio() + "</li>");
            out.println("</ul>");
            out.println("    </body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        ProductoService service = new ProductoServiceImpl();
        List<Producto> productos = service.listar();
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(productos);
        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("json",json);
        resp.sendRedirect("SawJson.jsp");
    }
}
