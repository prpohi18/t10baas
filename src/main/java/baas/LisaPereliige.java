package baas;
import java.sql.*;
import java.util.Scanner;

public class LisaPereliige{
	public static void lisa(String eesnimi, String perenimi, Int pikkus, Int kaal) throws Exception{
		Connection cn = DriverManager.getConnection("jdbc:mysql://greeny.cs.tlu.ee/if17_heinmark?user=if17&password=if17");
		PreparedStatement st = cn.prepareStatement("INSERT INTO pereliige VALUES(?, ?, ?, ?)");
		Scanner reader = new Scanner(System.in);
		System.out.println("Sisesta pereliikme eesnimi: ");
		double eesnimi = reader.nextDouble();
		st.setDouble(1, eesnimi);
		System.out.println("Sisesta pereliikme perenimi: ");
		double perenimi = reader.nextDouble();
		st.setDouble(2, perenimi);
		System.out.println("Sisesta pereliikme pikkus: ");
		double pikkus = reader.nextDouble();
		st.setDouble(3, pikkus);
		System.out.println("Sisesta pereliikme kaal: ");
		double kaal = reader.nextDouble();
		st.setDouble(4, kaal)
		st.executeUpdate(); 
		reader.close();
	}
}