package baas;
import java.lang.*;

import java.sql.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class inimene{
	public static void main(String[]arg) throws Exception{
		lisamine.lisa();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Connection cn = DriverManager.getConnection("jdbc:mysql://greeny.cs.tlu.ee/if17_klaaeger_4?user=if17&password=if17");
		Statement st1 = cn.createStatement();
		ResultSet rs1 = st1.executeQuery("SELECT id, nimi, vanus, elukoht FROM inimene");
		while (rs1.next()){
			System.out.println(rs1.getString("nimi")+" "+rs1.getInt("vanus")+" "+rs1.getString("elukoht"));
		}
	}
}