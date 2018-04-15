package poenimekiri;
import java.sql.*;
import java.io.*;
public class Poenimekiri1{
	public static void main(String[] arg) throws Exception{
		BufferedReader sisse= new BufferedReader(new InputStreamReader(System.in));
		Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/if17_maisjuli_2?user=if17&password=if17");
		
		int summa=0;
		
		String vastus3="k";
		
		String looTabel = "CREATE TABLE IF NOT EXISTS poenimekiri(kaup VARCHAR(30), kogus INT, hind INT);";
		PreparedStatement loo=cn.prepareStatement(looTabel);
		loo.executeUpdate();
		
		System.out.println("Lisad midagi? [+/-]");
		String vastus1 = sisse.readLine();
		
		while(vastus1.equals("+")){
		PreparedStatement sisesta=cn.prepareStatement("INSERT INTO poenimekiri VALUES (?, ?, ?)");
			
		System.out.println("Sisesta kaup:");
		String kaup = sisse.readLine();
		
		System.out.println("Sisesta kogus:");
		String Kogus = sisse.readLine();
		int kogus =Integer.parseInt(Kogus);
		
		System.out.println("Sisesta hind:");
		String Hind = sisse.readLine();
		int hind =Integer.parseInt(Hind);
		
		sisesta.setString(1, kaup);
		sisesta.setInt(2, kogus);
		sisesta.setInt(3, hind);
		sisesta.executeUpdate();
		
		System.out.println("Lisad veel? [+/-]");
		vastus1 = sisse.readLine();
		}
		
		ResultSet rs=loo.executeQuery("SELECT * FROM poenimekiri;");
		System.out.println("Poenimekiri:");
		while(rs.next()){
			System.out.println(rs.getString("kaup")+" "+rs.getInt("kogus")+" "+rs.getInt("hind"));
			summa+=rs.getInt("kogus")*rs.getInt("hind");
		}
		System.out.println("Võta kaasa vähemalt: "+summa+"eurot.");
		while(vastus3.equals("k") || vastus3.equals("m")){
			System.out.println("Kas midagi vaja kustutada[k], muuta[m] või mitte[-]?");
			vastus3 = sisse.readLine();
			String vastus2="+";
			if(vastus3.equals("k")){
				while(vastus2.equals("+")){
					System.out.println("Mida kustutad?");
					String kustutada = sisse.readLine();
					String kustutamine = "DELETE FROM poenimekiri WHERE kaup='"+kustutada+"'";
					PreparedStatement kustuta=cn.prepareStatement(kustutamine);
					kustuta.executeUpdate();
					
					System.out.println("Kustutad veel? [+/-]");
					vastus2 = sisse.readLine();
				}
			}
			if(vastus3.equals("m")){
				while(vastus2.equals("+")){
					System.out.println("Mida muudad?");
					String muuta = sisse.readLine();
					System.out.println("Uus kaup:");
					String uusKaup = sisse.readLine();
					System.out.println("Uus kogus:");
					String UusKogus = sisse.readLine();
					int uusKogus =Integer.parseInt(UusKogus);
					System.out.println("Uus hind:");
					String UusHind = sisse.readLine();
					int uusHind =Integer.parseInt(UusHind);
					String muutmine = "UPDATE poenimekiri SET kaup='"+uusKaup+"', kogus="+uusKogus+", hind="+uusHind+" WHERE kaup='"+muuta+"';";
					PreparedStatement asenda=cn.prepareStatement(muutmine);
					asenda.executeUpdate();
					
					System.out.println("Muudad veel? [+/-]");
					vastus2 = sisse.readLine();
				}
			}
		}
		summa=0;
		ResultSet rs2=loo.executeQuery("SELECT * FROM poenimekiri;");
		System.out.println("Lõplik poenimekiri:");
		System.out.println("--------------------");
		while(rs2.next()){
			System.out.println(rs2.getString("kaup")+" "+rs2.getInt("kogus")+" "+rs2.getInt("hind"));
			summa+=rs2.getInt("kogus")*rs2.getInt("hind");
		}
		System.out.println("Võta kaasa vähemalt "+summa+"eurot.");
		System.out.println("--------------------");
		

	}
}
//java -jar target/boot3-1.jar poenimekiri.Poenimekiri1