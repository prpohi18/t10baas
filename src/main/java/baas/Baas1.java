package baas;
import java.sql.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Baas1{
	public static void main(String[]arg) throws Exception{
		Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/if17_riho_4?user=if17&password=if17");
		Statement st1 = cn.createStatement();
		ResultSet rs1 = st1.executeQuery("SELECT id, numbrim2rk, mark, mudel FROM autod;");
		while (rs1.next()){
			System.out.println(rs1.getInt("id")+" "+rs1.getString("numbrim2rk")+" "+rs1.getString("mark")+" "+rs1.getString("mudel"));
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		/*
		System.out.println("Mis on auto numbrimärk? ");
		String a1 = br.readLine();
		System.out.println("Mis on auto mark? ");
		String a2 = br.readLine();
		System.out.println("Mis on auto mudel? ");
		String a3 = br.readLine();
		Lisamine.lisa(a1, a2, a3);
		*/
		/*
		System.out.println("Mis numbrimärki soovid kustutada? ");
		String kustuta = br.readLine();
		Kustutamine.kustuta(kustuta);
		*/
		Statement st = cn.createStatement();
		ResultSet rs = st.executeQuery("SELECT id, numbrim2rk, mark, mudel FROM autod;");
		while (rs.next()){
			System.out.println(rs.getInt("id")+" "+rs.getString("numbrim2rk")+" "+rs.getString("mark")+" "+rs.getString("mudel"));
		}
	}
}