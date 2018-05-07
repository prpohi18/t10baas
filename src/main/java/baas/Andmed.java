package baas;
import java.sql.*;
import java.lang.Double;

public class Andmed{
	public static void main(String args[]) throws Exception{
		String url = "jdbc:mysql://localhost/if17_rootkris?user=if17&password=if17";
		Connection cn = DriverManager.getConnection(url);
		
		if (args[0].equals("lisamine")){
			String eesnimi = args[1];
			String perekonnanimi = args[2];
			String tiim = args[3];
			String rahvus = args[4];
			
			Lisamine.lisa(cn, eesnimi, perekonnanimi, tiim, rahvus);
		} else if (args[0].equals("kustutamine")){
			int id = Integer.parseInt(args[1]);
			Kustutamine.kustuta(cn, id);
		} else if (args[0].equals("vaatamine")){
			int id = Integer.parseInt(args[1]);
			Vaatamine.vaata(cn, id);
		}
	}	
}