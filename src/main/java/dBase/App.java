package dBase;
import java.sql.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class App{
	public static void main(String[] arg) throws Exception {
		//System.getProperties().put("server.port", 40305);
		Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/if17_seppcasp?user=if17&password=if17");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Sisesta 1, et vaadata mängijate nimekirja, Sisesta 2, et lisada mängija, Sisesta 3, et kustutada mängija: ");
		String s = br.readLine();
		String Name = "";
		int Number = 0;
		String Team = "";
		int Goals = 0;
		int Assists = 0;
		if (s == "1") {
			ArrayList<Player> Players = new ArrayList<Player>();
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("Select Name, Number, Team, Goals, Assists FROM Players");
			while(rs.next()){
				Player p = new Player (rs.getString(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
				Players.add(p);
			}
			int index = 0;
			for(Player p: Players) {
				System.out.println(Players.get(index));
				index++;
			}
		} else {
			System.out.println("Mingi probleem?");

		}

	}
	
}