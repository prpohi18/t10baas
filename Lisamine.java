
package ttaevik.baas;


import java.sql.*;

public class Lisamine{
    public static void lisa(Connection cn, String[] arg) throws Exception{
		int vanus;
		double pikkus;
		double kaal;
        PreparedStatement st=cn.prepareStatement("INSERT INTO inimesed VALUES(DEFAULT, ?, ?, ?)");
        st.setDouble(1, Integer.parseInt(arg[0]));
        st.setDouble(2, Double.parseDouble(arg[1]));
        st.setDouble(3, Double.parseDouble(arg[2]));
        st.executeUpdate();
    }
}

