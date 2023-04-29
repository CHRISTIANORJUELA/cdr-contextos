package com.example.practica_metodos.Servlets;

import com.example.practica_metodos.models.Producto;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "postman",value = {"/servlet-postman"})
public class ServletPostMan extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.setHeader("refresh", "1");
        LocalTime hora = LocalTime.now();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("hh:mm:ss");
        int saldo = (int)(Math.random()*100000+1);
        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println(" <head>");
            out.println(" <meta charset=\"UTF-8\">");
            out.println(" <title>Hora del día</title>");
            out.println(" </head>");
            out.println(" <body>");
            out.println(" <h1>A las :</h1>");
            out.println("<h3>"+ hora.format(df) + "</h3>");
            out.println("<h2>Tienes "+saldo+" saldo hoy </h2>");
            out.println(" </body>");
            out.println("</html>");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.setHeader("refresh", "1");
        Producto producto = new Producto(2l,"camion","transporte",5490288l);
        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println(" <head>");
            out.println(" <meta charset=\"UTF-8\">");
            out.println(" <title>Ver paquete</title>");
            out.println(" </head>");
            out.println(" <body>");
            out.println(" <h1>Aqui esta tu paquete</h1>");
            out.println("<h3> id : "+producto.getId()+"</h3>");
            out.println("<h3> nombre : "+producto.getName()+"</h3>");
            out.println("<h3> Tipo : "+producto.getType()+"</h3>");
            out.println("<h3> Precio : "+producto.getPrecio()+"</h3>");
            out.println(" </body>");
            out.println("</html>");
        }
    }
}
