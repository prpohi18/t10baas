package baas;
import java.sql.*;
import java.util.Scanner;
public class Lisamine{
	public static void lisa() throws Exception{
		int arv1, arv3, arv4;
		String arv2;
		String vastus1;
		String vastus2;
		Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/if17_lahtsten?user=if17&password=if17");
		PreparedStatement st =cn.prepareStatement("INSERT INTO jooksjad VALUES(?, ?, ?, ?)");
		Scanner input= new Scanner (System.in);
		System.out.println("Lisa jooksjate telefoninumber, eesnimi, sünniaasta ja tulemus sekundites");
		arv1 = input.nextInt();
		arv2 = input.next();
		arv3 = input.nextInt();
		arv4 = input.nextInt();
		st.setInt(1, arv1);
		st.setString(2, arv2);
		st.setInt(3, arv3);
		st.setInt(4, arv4);
		st.executeUpdate();
		input= new Scanner (System.in);
		System.out.println("Kas soovid tabelist kellegi andmeid kustutada?");
		vastus1 = input.next();
		if (vastus1.equals("jah")){
			System.out.println("Kelle andmeid soovid kustutada? Sisesta eesnimi");
			input= new Scanner (System.in);
			vastus2 = input.next();
			input.close();
			PreparedStatement stm =cn.prepareStatement("DELETE FROM jooksjad WHERE eesnimi = ?");
			stm.setString(1, vastus2);
			stm.executeUpdate();
			System.out.println("Kustutatud!")
			System.out.println("Head aega!");
		} else{
			System.out.println("Head aega!");
			
		}
			
		
		
	}
}