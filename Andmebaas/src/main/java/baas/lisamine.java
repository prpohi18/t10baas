package baas;
import java.sql.*;
import java.io.*;
import java.lang.*;

public class lisamine{
	public static void lisa() throws Exception{
		Connection cn = DriverManager.getConnection("jdbc:mysql://greeny.cs.tlu.ee/if17_klaaeger_4?user=if17&password=if17");
		PreparedStatement st = cn.prepareStatement("INSERT INTO inimene VALUES(DEFAULT, ?, ?, ?)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Sisesta nimi: ");
		String name = br.readLine();
		st.setString(1, name);
		System.out.println("Sisesta vanus: ");
		double age = Double.parseDouble(br.readLine());
		st.setDouble(2, age);
		System.out.println("Sisesta elukoht: ");
		String where = br.readLine();
		st.setString(3, where);
		st.executeUpdate();
	}
}