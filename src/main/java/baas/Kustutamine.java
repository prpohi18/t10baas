package baas;
import java.sql.*;
public class Kustutamine{
	public static void kustuta(String number) throws Exception{
		Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/if17_riho_4?user=if17&password=if17");
		PreparedStatement st = cn.prepareStatement("DELETE FROM autod WHERE numbrim2rk=?");
		st.setString(1, number);
		st.executeUpdate();
	}
}