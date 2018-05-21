package baas;

import java.sql.*;

public class Lisamine {
    public static void lisa(Connection cn, String eesnimi, String perenimi, int vanus) throws Exception {
        PreparedStatement st = cn.prepareStatement("INSERT INTO inimesed VALUES(DEFAULT, ?, ?, ?)");
        st.setString(1, eesnimi);
        st.setString(2, perenimi);
        st.setInt(3, vanus);
        st.executeUpdate();
    }
}