package com.example.practica_metodos.Servlets;

import java.io.*;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Este metodo devuelve el tipo de metodo usado en este caso GET
        String metodoHttp = request.getMethod();
        //Este metodo nos devuelve sin el cpntext path /Practica_metodos_war_exploded/hello-servlet
        String requestUri = request.getRequestURI();
        //Este metodo nos devuelve toda ruta http://localhost:8080/Practica_metodos_war_exploded/hello-servlet
        String requestUrl = request.getRequestURL().toString();
        // Este metodo nos devuelve el context path /Practica_metodos_war_exploded
        String contexPath = request.getContextPath();
        //Este metodo nos devuelve el path del servlet /hello-servlet
        String servletPath = request.getServletPath();
        // Nos devuelve la direccion interna que enruta al sistema local 0:0:0:0:0:0:0:1
        String ipCliente = request.getRemoteAddr();
        // Nos devuelve la direccion local  0:0:0:0:0:0:0:1
        String ip = request.getLocalAddr();
        // Nos devuelve el puerto en el que se levanto la conexion
        int port = request.getLocalPort();
        // Nos devuelve el nombre del protocolo de transferencia de hipertexto seguro http
        String scheme = request.getScheme();
        //Nos devuelve el host completo con nombre y numero de puerto ( el Valor del encabezado de solicitud especificado como un archivo String)
        String host = request.getHeader("host");
        // Formamos una Url
        String url = scheme + "://" + host + contexPath + servletPath;
        // Formamos una url un poco distinta a la primera
        String url2 = scheme + "://" + ip + ":" + port + contexPath + servletPath;

        //Punto 9:
        /*
        SendRedirect: Nos sirve para redireccionar el Usuario a un jsp o un Servlet
        RequestDispatcher: Nos sirve para pasar redireccionar los objetos Request y Response al nuevo servlet
        o un Jsp ya sea el mismo que envio la peticion o uno nuevo
        tiene dos metodos muy utiles:
        forward: Sirve para pasarle todoo el control al nuevo servlet enviandole los objetos request y response
        por lo tanto el nuevo servlet sera el que dara la respuesta.

        Si es hacia un Jsp (actual o nuevo) podemos volver a apuntar hacia ese Jsp pero este ya no
        nos dara una respuesta

        Include: Pasa de forma temporal el control al nuevo servlet,Una vez acabado la logica en
        el nuevo servlet nos devolvera el control y la clase que llamo al nuevo servlet sera
        la que dara la respuestaa

        SendRedirect:
        si desea transferir la solicitud a un nuevo servidor o fuera del contexto, y una solicitud se trata como
        completamente nueva, vaya a sendRedirect.
        En el caso de sendRedirect, pasar datos no es fácil, tenemos que almacenar los datos en la sesión o pasarlos junto con la URL.

        SendRedirect no es seguro al enviar datos que se muestran en la URL.
        Despachador de solicitudes:
        si desea reenviar o incluir la solicitud o las respuestas en el mismo servidor, vaya a Despachador de solicitudes.
        Cuando redirigimos usando adelante, podemos pasar fácilmente los datos usando request.setAttribute() ya que tenemos un objeto de solicitud disponible.

        Punto 10:

        De lo que yo lei me llamo mucho la atencion los siguientes codigos porque creo que para empezar los voy a usar mucho:
        200 Ok
        201 Created
        400 BadRequest
        401 Unauthorized
        404 Not Found

        Punto 16:
        Que es una Sesión:
        Una sesión es una serie de comunicaciones entre un cliente y un servidor
        en la que se realiza un intercambio de información. Por medio de una sesión
        se puede hacer un seguimiento de un usuario a través de la aplicación.
        El tiempo de vida de una sesión comienza cuando un usuario se conecta por primera vez
        a un sitio web pero su finalización puede estar relacionada con tres circunstancias

        Diferencia de Sesión y cookie:

        #Las cookies permiten a una aplicación web acceder a información desde cualquiera de las distintas páginas que presenta.

        #Las sessions de igual forma. Pero las cookies se guardan en el lado del cliente, y las sesiones, en el lado del servidor.

        #Las cookies se almacenan del lado cliente osea en el navegador

        #Las secciones por lo general se trabajan del lado del servidor

        #Se puede guardar una sesion dentro de una cookiee guardando su identificador de sesión en el navegador del cliente

        #Lo normal es guardar datos sensibles en sesiones y datos de personalización en Cookiees

        # Las cookies tienen la desventaje de ser cambiadas por el cliente en el navegador

        # Las sesiones son mas seguras porque el cliente no tiene acceso a ellas

        #Las cookies pueden duras meses o hasta años

        #Las sesiones tienen un periodo de vida mas corto como ej hasta que el usuario cierre el navegador
         */


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration<String> enumeration = req.getParameterNames();
        String named = "";
        while (enumeration.hasMoreElements()){
            named = enumeration.nextElement();
            break;
        }
        switch (named){
            case "btn-verificar":
                resp.sendRedirect("login.jsp");
                break;
            case "btn-buscar":
                resp.sendRedirect("buscarProducto.jsp");
                break;
            default:
                break;
        }
    }

    public void destroy() {
    }
}