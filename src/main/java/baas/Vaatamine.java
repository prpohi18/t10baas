package baas;

import java.sql.*;

public class Vaatamine {
    public static void vaata(Connection cn, int id) throws Exception {
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery("SELECT id, eesnimi, perenimi, vanus FROM inimesed WHERE id=" + id + ";");
        while (rs.next()) {
            System.out.println(rs.getInt("id") + " " + rs.getString("eesnimi") + " " + rs.getString("perenimi") + " " + rs.getInt("vanus"));
        }
    }
}