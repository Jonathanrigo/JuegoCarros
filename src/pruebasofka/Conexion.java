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
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/autoscarrera", "root", "");
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
            rs = st.executeQuery("select * from usuario");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("user"));
            }
            cn.con.close();
        } catch (Exception e) {
        }
    }
}
