
package ttaevik.baas;

import java.sql.*;
public class Uuendamine{
    public static void uuenda(Connection cn, String[] arg) throws Exception{
		int vanus;
		double pikkus;
		double kaal;
		int id;
        PreparedStatement st=cn.prepareStatement("UPDATE inimesed SET vanus=(?), pikkus=(?), kaal=(?) WHERE ID =(?)");
        st.setInt(1, Integer.parseInt(arg[0]));
        st.setDouble(2, Double.parseDouble(arg[1]));
        st.setDouble(3, Double.parseDouble(arg[2]));
        st.setInt(4, Integer.parseInt(arg[3]));
        st.executeUpdate();
    }
}
