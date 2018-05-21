package baas;

import java.sql.*;

public class Kustutamine {
    public static void kustuta(Connection cn, int id) throws Exception {
        PreparedStatement st = cn.prepareStatement("DELETE FROM inimesed WHERE id=" + id + ";");
        st.executeUpdate();
    }
}