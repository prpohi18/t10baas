package kymnes;

import java.sql.*;
import java.lang.Double;

public class Vaatamine {
    public static void vaata(Connection cn, int id) throws Exception {
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery("SELECT id, eesnimi, perenimi, vanus FROM people WHERE id=" + id + ";");
        while (rs.next()) {
            System.out.println(rs.getInt("id") + " " + rs.getString("eesnimi") + " " + rs.getString("perenimi") + " " + rs.getInt("vanus"));
        }
    }
}