package cl.awakelab.jeemvc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/***
 * Clase Conexion, implementa el patrón Singleton
 */
public class Conexion {

    private static Connection con = null;

    private Conexion(){
        try {
          Class.forName("oracle.jdbc.driver.OracleDriver");
          con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "OT", "kupita");

        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }

    public static Connection getInstance(){
        if (con == null){
            new Conexion();
        }


        return con;
    }
}
