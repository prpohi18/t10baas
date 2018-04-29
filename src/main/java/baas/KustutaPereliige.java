package baas;
import java.sql.*;

public class KustutaPereliige{
	public static void kustuta(String pereliige) throws Exception{
		Connection cn = DriverManager.getConnection("jdbc:mysql://greeny.cs.tlu.ee/if17_heinmark?user=if17&password=if17");
		PreparedStatement st = cn.prepareStatement("DELETE FROM pereliige WHERE eesnimi=?");
		st.setString(1, pereliige);
		st.executeUpdate();
	}
}