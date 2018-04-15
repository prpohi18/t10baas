package baas;
import java.sql.*;
public class Baas1{
	public static void main(String[] arg) throws Exception{
		Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/if17_lahtsten?user=if17&password=if17");
		Lisamine.lisa();
		Statement st =cn.createStatement();
		ResultSet rs =st.executeQuery("SELECT * FROM jooksjad");
		while(rs.next()){
			System.out.println(rs.getInt("telefon")+" "+rs.getString("eesnimi")+" "+rs.getInt("synniaasta")+" "+rs.getInt("aegsek"));
		}
	}
}