package dBase;
import java.sql.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class App{
	public static void main(String[] arg) throws Exception {
		Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/if17_marek?user=if17&password=if17");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Sisesta 1, et vaadata mängijate nimekirja, Sisesta 2, et lisada mängija, Sisesta 3, et kustutada mängija: ");
		String s = br.readLine();
		String Name = "";
		int Number = 0;
		String Team = "";
		double Points = 0;
		int Games = 0;
		double Minutes = 0;
		int Salary = 0;
		if (s == "1") {
			ArrayList<Player> Players = new ArrayList<Player>();
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("Select Name, Number, Team, Points, Games, Minutes, Salary FROM Players");
			while(rs.next()){
				Player p = new Player (rs.getString(1), rs.getInt(2), rs.getString(3), rs.getDouble(4), rs.getInt(5), rs.getDouble(6), rs.getInt(7));
				Players.add(p);
			}
			int index = 0;
			for(Player p: Players) {
				System.out.println(Players.get(index));
				index++;
			}
		} else {
			System.out.println("Meh");

		}

	}
	
}