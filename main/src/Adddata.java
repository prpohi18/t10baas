import java.sql.*;

public class Adddata{
    public static void add(Connection cn, String[] arg) throws Exception{
        PreparedStatement st=cn.prepareStatement("INSERT INTO new_schema.bmitable VALUES(DEFAULT, ?, ?)");
        st.setDouble(1, Double.parseDouble(arg[0]));
        st.setDouble(2, Double.parseDouble(arg[1]));
        st.executeUpdate();
    }
}