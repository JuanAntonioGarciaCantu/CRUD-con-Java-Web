package controlador;

import datos.PersonaDaoJDBC;
import dominio.Persona;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PersonaServletController")
public class PersonaServletController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //realiza un GetAll
        List<Persona> personas = new PersonaDaoJDBC().GetAll();        
        
        //compartir el resultado en un alcance
        request.setAttribute("personas", personas);
        
        //redirigir a la vista
        request.getRequestDispatcher("personas.jsp").forward(request, response);               
    }
        
}
