package baas;
import java.lang.*;

import java.sql.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class auto{
	public static void main(String[]arg) throws Exception{
		lisamine.lisa();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Connection cn = DriverManager.getConnection("jdbc:mysql://greeny.cs.tlu.ee/if17_kaugsilv?user=if17&password=if17");
		Statement st1 = cn.createStatement();
		ResultSet rs1 = st1.executeQuery("SELECT id, AutoMark, Mudel, KusRiigisArvel FROM auto");
		while (rs1.next()){
			System.out.println(rs1.getString("AutoMark")+" "+rs1.getInt("Mudel")+" "+rs1.getString("KusRiigisArvel"));
		}
	}
}