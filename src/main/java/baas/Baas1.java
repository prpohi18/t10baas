package baas;
import java.sql.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baas1{
	public static void main(String[]arg) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Connection cn = DriverManager.getConnection("jdbc:mysql://greeny.cs.tlu.ee/if17_heinmark?user=if17&password=if17");
		Statement st1 = cn.createStatement();
		ResultSet rs1 = st1.executeQuery("SELECT eesnimi, perenimi, pikkus, kaal FROM pereliige;");
		while (rs1.next()){
			System.out.println(rs1.getString("eesnimi")+" "+rs1.getString("perenimi")+" "+rs1.getInt("pikkus")+" "+rs1.getInt("kaal"));
		}
	}
}
