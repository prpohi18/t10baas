package baas;
import java.sql.*;
import java.lang.Double;

public class Kustutamine{
	public static void kustuta(Connection cn, int id) throws Exception{
		PreparedStatement st = cn.prepareStatement("DELETE FROM vormel WHERE id=" + id + ";");
		st.executeUpdate();
	}	
}