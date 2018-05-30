package baas;

import java.sql.*;
import java.lang.Double;

public class Lisamine{
    public static void lisa(Connection cn, double a, double b, double c, double x1, double x2) throws Exception{
        PreparedStatement st = cn.prepareStatement("INSERT INTO ruutvorrand VALUES(DEFAULT, ?, ?, ?, ?, ?)");
        st.setDouble(1, a);
        st.setDouble(2, b);
        st.setDouble(3, c);
        st.setDouble(4, x1);
        st.setDouble(5, x2);
        st.executeUpdate();
    }
}