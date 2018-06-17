package dBase;
import java.sql.*;
public class DatabaseQuerys{
	public static void addPlayer(String Name, int Number, String Team, int Goals, int Assists) throws Exception {
		Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/if17_seppcasp?user=if17&password=if17");
		PreparedStatement st = cn.prepareStatement("INSERT INTO Players VALUES(Default, ?, ?, ?, ?, ?)");
		st.setString(1, Name);
		st.setInt(2, Number);
		st.setString(3, Team);
		st.setInt(4, Goals);
		st.setInt(5, Assists);
		st.executeUpdate();
	}
	
}
