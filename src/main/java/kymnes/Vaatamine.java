package kymnes;
import java.sql.*;
import java.lang.Double;

public class Vaatamine {
    public static void vaata(Connection cn, int id) throws Exception {
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery("SELECT id, toode, hind, saadavus FROM t10_ladu WHERE id=" + id + ";");
        while (rs.next()) {
            System.out.println(rs.getInt("id") + " " + rs.getString("toode") + " " + rs.getDouble("hind") + " " + rs.getString("saadavus"));
        }
    }
}