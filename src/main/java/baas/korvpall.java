package baas;
import java.lang.*;

import java.sql.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class korvpall{
	public static void main(String[]arg) throws Exception{
		Lisamine.lisa();
		Kustutamine.kustuta();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Connection cn = DriverManager.getConnection("jdbc:mysql://greeny.cs.tlu.ee/if17_martandr?user=if17&password=if17");
		Statement st1 = cn.createStatement();
		ResultSet rs1 = st1.executeQuery("SELECT id, nimi, pikkus, mass FROM korvpall");
		while (rs1.next()){
			System.out.println(rs1.getString("nimi")+" "+rs1.getString("pikkus")+" "+rs1.getInt("mass"));
		}
	}
}