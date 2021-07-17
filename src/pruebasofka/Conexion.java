package pruebasofka;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Conexion {
    public Connection con;
    public Conexion() {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/juegocarrera", "root", "");
        } catch (Exception e) {
            System.out.println("Error:" + e);
        }
    }
    public java.sql.Connection getConnection(){
        return con;
    }
}