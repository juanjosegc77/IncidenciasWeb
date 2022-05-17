package Configuracion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author    : M.Sc. Juan José Guzmán Cruz
 * Created on : Jan 25, 2020
 *
 */

public class ConexionBD {
    Connection conn;
    
    // Variables para conectar a servidor
    //final String ruta = "jdbc:mysql://localhost/Incidencias_web?zeroDateTimeBehavior=convertToNull";
    final String ruta = "jdbc:mysql://localhost/Incidencias_web?useUnicode=true&characterEncoding=utf8&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
    final String usuario = "Incidencias";
    final String contraseña = "pass";
    
    /**
     * Método para conectar a una base de datos utilizando el Driver jdbc.
     * @return Variable de tipo Connection.
     */
    public Connection Conectar(){
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(ruta, usuario, contraseña);
        } catch (Exception e) {
            System.out.println("Error desde ConexionDB.Conectar() : " + e);
        }
        return conn;
    }

}
