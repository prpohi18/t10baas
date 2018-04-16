package kymnes;

import java.sql.*;
import java.lang.Double;

public class Lisamine {
    public static void lisa(Connection cn, String eesnimi, String perenimi, String klass, double keskminehinne) throws Exception {
        PreparedStatement st = cn.prepareStatement("INSERT INTO opilased VALUES(DEFAULT, ?, ?, ?, ?)");
        st.setString(1, eesnimi);
        st.setString(2, perenimi);
        st.setString(3, klass);
        st.setDouble(4, keskminehinne);
        st.executeUpdate();
    }
}