package kymnes;
import java.sql.*;
import java.lang.Double;

public class Lisamine {
    public static void lisa(Connection cn, String toode, Double hind, String saadavus) throws Exception {
        PreparedStatement st = cn.prepareStatement("INSERT INTO t10_ladu VALUES(DEFAULT, ?, ?, ?)");
        st.setString(1, toode);
        st.setDouble(2, hind);
        st.setString(3, saadavus);
        st.executeUpdate();
    }
} 