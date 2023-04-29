package com.example.practica_metodos.Servlets;

import com.example.practica_metodos.controllers.ModelFactoryController;
import com.example.practica_metodos.models.Producto;
import com.example.practica_metodos.services.LoginService;
import com.example.practica_metodos.services.LoginServiceImpl;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

@WebServlet(name="Login",value = {"/login","/login.html"})
public class LoginServlet extends HttpServlet {
    private final String userName = "Maria";
    private final String password = "5";

    ModelFactoryController mfc = ModelFactoryController.getInstance();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
     String userName = req.getParameter("username");
     String passWord = req.getParameter("password");
     if (this.userName.equalsIgnoreCase(userName) && this.password.equalsIgnoreCase(passWord)){
         resp.setContentType("text/html;charset=UTF-8");
         try (PrintWriter out = resp.getWriter()){
             /* Punto anterior
             out.println("<!DOCTYPE html>");
             out.println("<!DOCTYPE html>");
             out.println("<html>");
             out.println(" <head>");
             out.println(" <meta charset=\"UTF-8\">");
             out.println(" <title>Login correcto</title>");
             out.println(" </head>");
             out.println(" <body>");
             out.println(" <h1>Login correcto!</h1>");
             out.println(" <h3>Hola "+ userName + " has iniciado sesión con éxito!</h3>");
             out.println(" </body>");
             out.println("</html>");
              */

             Cookie cookie = new Cookie("username",userName);
             ServletContext servletContext = getServletContext();
             servletContext.setAttribute("username",userName);
             resp.addCookie(cookie);
             resp.sendRedirect("login.html");
         }catch (IOException e){
             e.printStackTrace();
         }
     }else {
         try {
             resp.sendError(HttpServletResponse.SC_UNAUTHORIZED,"lo sentimos pero no estas autorizado para continuar");
         }catch (IOException e){
             e.printStackTrace();
         }
     }
    }

    //<a href="/login.html">login</a>
    @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException  , IOException {
            LoginService auth = new LoginServiceImpl();
            List<Producto> list;
            ServletContext servletContext = getServletContext();
            Optional<String> cookieOptional = auth.getUsername(req);
            System.out.println(cookieOptional.get() != null ? cookieOptional.get() :"no existe");
            if (cookieOptional.isPresent()) {
                resp.setContentType("text/html;charset=UTF-8");
                try (PrintWriter out = resp.getWriter()) {
                    list = mfc.listar();
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println(" <head>");
                    out.println(" <meta charset=\"UTF-8\">");
                    out.println(" <title>Hola " + cookieOptional.get()  +
                            "swef4gg</title>");
                    out.println(" </head>");
                    out.println(" <body>");
                    out.println(" <h1>Hola " + cookieOptional.get()+ " has iniciado sesión con éxito!</h1>");
                    out.println("<p><a href='" + req.getContextPath() +
                            "/index.html'>volver</a></p>");
                    out.println("<p><a href='" + req.getContextPath() +
                            "/logout'>cerrar sesión</a></p>");
                    list.forEach(x->{
                        out.println("<h3>id: "+x.getId()+"</h3>");
                        out.println("<h3>nombre: "+x.getName()+"</h3>");
                        out.println("<h3>tipo: "+x.getType()+"</h3>");
                        out.println("<h3>precio: "+x.getPrecio()+"</h3>");
                    });
                    out.println(" </body>");
                    out.println("</html>");
                }
            } else {
                getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
            }
        }

    }

