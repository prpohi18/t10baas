package dBase;
import java.sql.*;
public class DatabaseQuerys{
	public static void addPlayer(String Name, int Number, String Team, double Points, int Games, double Minutes, int Salary) throws Exception {
		Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/if17_marek?user=if17&password=if17");
		PreparedStatement st = cn.prepareStatement("INSERT INTO Players VALUES(Default, ?, ?, ?, ?, ?, ?, ?)");
		st.setString(1, Name);
		st.setInt(2, Number);
		st.setString(3, Team);
		st.setDouble(4, Points);
		st.setInt(5, Games);
		st.setDouble(6, Minutes);
		st.setInt(7, Salary);
		st.executeUpdate();
	}
	
}
