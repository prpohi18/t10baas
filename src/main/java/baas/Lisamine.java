package baas;
import java.sql.*;
import java.lang.Double;

public class Lisamine{
	public static void lisa(Connection cn, String eesnimi, String perekonnanimi, String tiim, String rahvus) throws Exception{
		PreparedStatement st = cn.prepareStatement("INSERT INTO vormel VALUES(DEFAULT, ?, ?, ?, ?)");
		st.setString(1, eesnimi);
		st.setString(2, perekonnanimi);
		st.setString(3, tiim);
		st.setString(4, rahvus);
		st.executeUpdate();
	}	
}