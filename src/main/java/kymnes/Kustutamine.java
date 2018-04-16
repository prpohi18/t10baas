package kymnes;

import java.sql.*;
import java.lang.Double;

public class Kustutamine {
    public static void kustuta(Connection cn, int id) throws Exception {
        PreparedStatement st = cn.prepareStatement("DELETE FROM opilased WHERE id=" + id + ";");
        st.executeUpdate();
    }
}