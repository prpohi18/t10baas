package baas;
import java.sql.*;
public class Lisamine{
	public static void lisa(String number, String mark, String mudel) throws Exception{
		Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/if17_riho_4?user=if17&password=if17");
		PreparedStatement st = cn.prepareStatement("INSERT INTO autod VALUES(DEFAULT, ?, ?, ?)");
		st.setString(1, number);
		st.setString(2, mark);
		st.setString(3, mudel);
		st.executeUpdate();
	}
}