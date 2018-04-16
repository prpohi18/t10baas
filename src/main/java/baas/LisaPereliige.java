package baas;
import java.sql.*;
public class LisaPereliige{
	public static void lisa(String eesnimi, String perenimi, Int pikkus, Int kaal) throws Exception{
		Connection cn = DriverManager.getConnection("jdbc:mysql://greeny.cs.tlu.ee/if17_heinmark?user=if17&password=if17");
		PreparedStatement st = cn.prepareStatement("INSERT INTO pereliige VALUES(?, ?, ?, ?)");
		st.setString(1, eesnimi);
		st.setString(2, perenimi);
		st.setInt(3, pikkus);
		st.setInt(4, kaal);
		st.executeUpdate();
	}
}