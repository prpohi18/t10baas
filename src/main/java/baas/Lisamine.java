package baas;
import java.sql.*;
import java.io.*;
import java.lang.*;

public class Lisamine{
	public static void lisa() throws Exception{
		Connection cn = DriverManager.getConnection("jdbc:mysql://greeny.cs.tlu.ee/if17_martandr?user=if17&password=if17");
		PreparedStatement st = cn.prepareStatement("INSERT INTO korvpall VALUES(DEFAULT, ?, ?, ?)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Sisesta korvpalluri nimi: ");
		String name = br.readLine();
		st.setString(1, name);
		System.out.println("Sisesta korvpalluri pikkus: ");
		double height = Double.parseDouble(br.readLine());
		st.setDouble(2, height);
		System.out.println("Sisesta korvpalluri mass: ");
		double weight = Double.parseDouble(br.readLine());
		st.setDouble(3, weight);
		st.executeUpdate();
	}
} 

