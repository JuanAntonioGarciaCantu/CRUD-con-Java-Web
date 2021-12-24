package datos;

import java.sql.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/persona?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "admin";
    
    //realiza un pool de conexiones
    public static DataSource getDataSource(){
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(JDBC_URL);
        ds.setUsername(JDBC_USER);
        ds.setPassword(JDBC_PASSWORD);
        ds.setInitialSize(50); // numero de conexiones que se pueden realizar
        
        return ds;
    }
    
    // obtiene la conexion 
    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }
    
    //cierra el objeto ResultSet
    public static void close (ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }  
    
    //cierra el objeto PreparedStatement
    public static void close (PreparedStatement stmt) {
        try {
            stmt.close();
        } catch(SQLException ex) {
            ex.printStackTrace(System.out);
        }        
    }
    
    //cierra el objeto Connection
    public static void close (Connection cn) {
        try {
            cn.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
