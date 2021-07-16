package pruebasofka;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {

    Connection con;

    public Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/juegocarrera", "root", "");
        } catch (Exception e) {
            System.out.println("Error:" + e);
        }
    }

    public static void main(String[] args) {
        Conexion cn = new Conexion();
        Statement st;
        ResultSet rs;
        try {
            st = cn.con.createStatement();
            rs = st.executeQuery("select * from Conductores");
            while (rs.next()) {
                System.out.println(rs.getInt("IdConductor") + " " + rs.getString("NombreConductor"));
            }
            cn.con.close();
        } catch (Exception e) {
        }
    }
}
