package datos;

import dominio.Persona;
import java.sql.*;
import java.util.*;

public class PersonaDaoJDBC {
    private static final String GET_ALL = "SELECT IdPersona, Nombre, ApellidoPaterno, ApellidoMaterno, Edad, Sexo "
            + "FROM persona";
    private static final String GET_BY_ID = "SELECT IdPersona, Nombre, ApellidoPaterno, ApellidoMaterno, Edad, Sexo "
            + "FROM persona WHERE IdPersona = ?";
    private static final String ADD = "INSERT INTO persona (Nombre, ApellidoPaterno, ApellidoMaterno, Edad, Sexo) "
            + "VALUES (?,?,?,?,?)";
    private static final String UPDATE = "UPDATE persona SET Nombre = ?, ApellidoPaterno = ?, ApellidoMaterno = ?, "
            + "Edad = ?, Sexo = ? WHERE IdPersona = ?";
    private static final String DELETE = "DELETE FROM Persona WHERE IdPersona = ?";
    
    public List<Persona> GetAll() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<>();
        
        try {
            conn = Conexion.getConnection(); //obtiene una conexion
            stmt = conn.prepareStatement(GET_ALL); //prepara el query
            rs = stmt.executeQuery(); //ejecuta el query
            
            //el ciclo se ejecutara si se encontraron resultados 
            while (rs.next()) {
                int idPersona = rs.getInt(1);
                String nombre = rs.getString(2);
                String apellidoPaterno = rs.getString(3);
                String apellidoMaterno = rs.getString(4);
                int edad = rs.getInt(5);
                char sexo = rs.getString(6).charAt(0);
                
                persona = new Persona(idPersona, nombre, apellidoPaterno, apellidoMaterno, edad, sexo);
                personas.add(persona);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            //cierra los objetos
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);            
        }
        
        return personas;
    } 
}
