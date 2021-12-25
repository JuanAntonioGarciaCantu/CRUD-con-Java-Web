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

//direccion del serveletController
@WebServlet("/PersonaServletController")
public class PersonaServletController extends HttpServlet {

    //peticiones GET, se deve mandar un parametro indicando que accion debe realizar
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //recupera el parametro de accion
        String accion = request.getParameter("accion"); 

        //valida la accion a realizar
        if (accion == null || accion.isEmpty()) {
            
            GetAll(request, response);
            
        } else if("insert".equals(accion)) {
            
            response.sendRedirect("form.jsp");
            
        } else if("update".equals(accion)) {
            
            GetById(request,response); 
            
        } else if("delete".equals(accion)) {
            
            Delete(request, response);
            
        }

    }
    
    //peticiones POST, recibe un parametro para saber que accion realizara
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        //recupera el parametro de idPersona
        int idPersona = Integer.parseInt(request.getParameter("idPersona"));
        
        //valida el parametro
        if (idPersona == 0) { //insertar nuevo registro
            
            Insert(request, response);
            
        } else if (idPersona > 0) { //actualizar registro
            
            Update(request, response);
            
        }
    }
    
    //acciones del CRUD que manejan las peticiones
    private void GetAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //realiza un GetAll
            List<Persona> personas = new PersonaDaoJDBC().GetAll();

            //compartir el resultado en un alcance (request)
            request.setAttribute("personas", personas);

            //redirigir a la vista
            request.getRequestDispatcher("personas.jsp").forward(request, response);            
    }
    
    private void Insert(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //recuperar los datos
        String nombre = request.getParameter("nombre");
        String apellidoPaterno = request.getParameter("apellidoPaterno");
        String apellidoMaterno = request.getParameter("apellidoMaterno");
        int edad =  Integer.parseInt(request.getParameter("edad"));
        char sexo = request.getParameter("sexo").charAt(0);
        
        //crear modelo
        Persona persona = new Persona(nombre, apellidoPaterno, apellidoMaterno, edad, sexo);
        
        //insertar los datos
        boolean insertPersona = new PersonaDaoJDBC().Add(persona);
        
        //regresar la vista
        response.sendRedirect("PersonaServletController");
    }
    
    private void GetById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idPersona = Integer.parseInt(request.getParameter("id"));
        
        Persona persona = new PersonaDaoJDBC().GetById(idPersona);
        
        request.setAttribute("persona", persona);
        
        request.getRequestDispatcher("form.jsp").forward(request, response);
    }
    
    private void Update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Persona persona = new Persona();
        persona.setIdPersona(Integer.parseInt(request.getParameter("idPersona")));
        persona.setNombre(request.getParameter("nombre"));
        persona.setApellidoPaterno(request.getParameter("apellidoPaterno"));
        persona.setApellidoMaterno(request.getParameter("apellidoMaterno"));
        persona.setEdad(Integer.parseInt(request.getParameter("edad")));
        persona.setSexo(request.getParameter("sexo").charAt(0));
        
        int updatePersona = new PersonaDaoJDBC().Update(persona);
        
        response.sendRedirect("PersonaServletController");
    }
    
    private void Delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idPersona = Integer.parseInt(request.getParameter("id"));
        
        boolean deletePersona = new PersonaDaoJDBC().Delete(idPersona);
        
        response.sendRedirect("PersonaServletController");
    }
}
