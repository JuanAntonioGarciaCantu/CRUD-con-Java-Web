package datos;

import dominio.Persona;
import java.sql.*;
import java.util.*;

public class PersonaDaoJDBC {
    //constantes de los querys que se realizaran
    private static final String GET_ALL = "SELECT IdPersona, Nombre, ApellidoPaterno, ApellidoMaterno, Edad, Sexo "
            + "FROM persona";
    private static final String GET_BY_ID = "SELECT IdPersona, Nombre, ApellidoPaterno, ApellidoMaterno, Edad, Sexo "
            + "FROM persona WHERE IdPersona = ?";
    private static final String ADD = "INSERT INTO persona (Nombre, ApellidoPaterno, ApellidoMaterno, Edad, Sexo) "
            + "VALUES (?,?,?,?,?)";
    private static final String UPDATE = "UPDATE persona SET Nombre = ?, ApellidoPaterno = ?, ApellidoMaterno = ?, "
            + "Edad = ?, Sexo = ? WHERE IdPersona = ?";
    private static final String DELETE = "DELETE FROM Persona WHERE IdPersona = ?";
    
    //metodos que realizan la accion del query en la base de datos
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
                int idPersona = rs.getInt("IdPersona");
                String nombre = rs.getString("Nombre");
                String apellidoPaterno = rs.getString("ApellidoPaterno");
                String apellidoMaterno = rs.getString("ApellidoMaterno");
                int edad = rs.getInt("Edad");
                char sexo = rs.getString("Sexo").charAt(0);
                
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
    
    public boolean Add(Persona persona) {        
        boolean resultQuery = true;
        
        Connection con = null;
        PreparedStatement stm = null;        
        
        try {
            con = Conexion.getConnection();
            stm = con.prepareStatement(ADD);
            
            stm.setString(1, persona.getNombre());
            stm.setString(2, persona.getApellidoPaterno());
            stm.setString(3, persona.getApellidoMaterno());
            stm.setInt(4, persona.getEdad());
            stm.setString(5, String.valueOf(persona.getSexo()));
            
            resultQuery = stm.execute();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {            
            Conexion.close(stm);
            Conexion.close(con);
        }
        
        return resultQuery;
    }
    
    public Persona GetById(int idPersona) {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Persona persona = null;
        
        try {
            con = Conexion.getConnection();
            stm = con.prepareStatement(GET_BY_ID);
            
            stm.setInt(1, idPersona);
            
            rs = stm.executeQuery();
            
            if(rs.next()) {
                persona = new Persona();
                persona.setIdPersona(rs.getInt("IdPersona"));
                persona.setNombre(rs.getString("Nombre"));
                persona.setApellidoPaterno(rs.getString("ApellidoPaterno"));
                persona.setApellidoMaterno(rs.getString("ApellidoMaterno"));
                persona.setEdad(rs.getInt("Edad"));
                persona.setSexo(rs.getString("Sexo").charAt(0));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stm);
            Conexion.close(con);
        }
        
        return persona;
    }
    
    public int Update(Persona persona) {
        Connection con = null;
        PreparedStatement stm = null;
        int resultQuery = 0; 
        
        try {
            con = Conexion.getConnection();
            stm = con.prepareStatement(UPDATE);
            
            stm.setInt(6, persona.getIdPersona());
            stm.setString(1, persona.getNombre());
            stm.setString(2, persona.getApellidoPaterno());
            stm.setString(3, persona.getApellidoMaterno());
            stm.setInt(4, persona.getEdad());
            stm.setString(5, String.valueOf(persona.getSexo()));
            
            resultQuery = stm.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stm);
            Conexion.close(con);
        }
        
        return resultQuery;
    }
    
    public boolean Delete(int idPersona) {
        Connection con = null;
        PreparedStatement stm = null;
        boolean resultQuery = true;        
        
        try {
          con = Conexion.getConnection();
          stm = con.prepareStatement(DELETE);
          
          stm.setInt(1, idPersona);
          
          resultQuery = stm.execute();                    
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);                        
        } finally {
            Conexion.close(stm);
            Conexion.close(con);
        }
        
        return resultQuery;
    }
}
