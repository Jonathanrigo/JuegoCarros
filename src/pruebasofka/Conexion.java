package pruebasofka;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Conexion {
    public Connection con;
// metodo de conexion a la base de datos    
    public Conexion() {
    // se debe colocar el nombre de la base de datos, usuario y contraseña para la conexion
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/juegocarrera", "root", "");
        } catch (Exception e) {
            System.out.println("Error:" + e);
        }
    }
    // metodo para retornar el valor de la conexion
    public java.sql.Connection getConnection(){
        return con;
    }
}