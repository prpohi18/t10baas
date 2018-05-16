package baas;
import java.sql.*;
import java.io.*;
public class T66tajad{
	public static void main(String[] arg) throws Exception{
		BufferedReader sisse=new BufferedReader(new InputStreamReader(System.in));
		Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/if17_kukltane?user=if17&password=if17");
		
		String tabeliTegemisek2sk = "CREATE TABLE IF NOT EXISTS t66tajad(eesnimi VARCHAR(30), perekonnanimi VARCHAR(30), "+
		"sugu VARCHAR(5), vanus INT, palk INT);";
		PreparedStatement st1=cn.prepareStatement(tabeliTegemisek2sk);
		st1.executeUpdate();
		
		System.out.println("Sisesta toiming (lisamine/kustutamine/muutmine/n2itamine):");
		String toiming = sisse.readLine();
		
		if(toiming.equals("lisamine")){		
			PreparedStatement st2=cn.prepareStatement("INSERT INTO t66tajad VALUES (?, ?, ?, ?, ?)");
			
			System.out.println("Sisesta t66taja eesnimi:");
			String eesnimi = sisse.readLine();
			
			System.out.println("Sisesta t66taja perekonnanimi:");
			String perekonnanimi = sisse.readLine();
			
			System.out.println("Sisesta t66taja sugu:");
			String sugu = sisse.readLine();
			
			System.out.println("Sisesta t66taja vanus:");
			String Vanus = sisse.readLine();
			int vanus =Integer.parseInt(Vanus);
			
			System.out.println("Sisesta t66taja palk:");
			String Palk = sisse.readLine();
			int palk =Integer.parseInt(Palk);
			
			st2.setString(1, eesnimi);
			st2.setString(2, perekonnanimi);
			st2.setString(3, sugu);
			st2.setInt(4, vanus);
			st2.setInt(5, palk);
			st2.executeUpdate();
		}else if(toiming.equals("kustutamine")){	
			System.out.println("Millise muutuja j2rgi kustutada soovid(eesnimi/perekonnanimi/sugu/vanus/palk)?");
			String muutuja = sisse.readLine();
			
			System.out.println("Millist v22rtuse j2rgi kustutada soovid?");
			String v22rtus = sisse.readLine();
			
			if(muutuja.equals("eesnimi") || muutuja.equals("perekonnanimi") || muutuja.equals("sugu")){
				String kustutamiseK2sk = "DELETE FROM t66tajad WHERE "+muutuja+" ='"+v22rtus+"'";
				PreparedStatement st3=cn.prepareStatement(kustutamiseK2sk);
				st3.executeUpdate();
			}else if(muutuja.equals("vanus") || muutuja.equals("palk")){				
				String kustutamiseK2sk = "DELETE FROM t66tajad WHERE "+muutuja+"="+v22rtus;
				PreparedStatement st3=cn.prepareStatement(kustutamiseK2sk);
				st3.executeUpdate();
			}
		}else if(toiming.equals("muutmine")){
			System.out.println("Millist lahtrit muuta soovid(eesnimi/perekonnanimi/sugu/vanus/palk)?");
			String muudetavLahter = sisse.readLine();
			
			System.out.println("Millise v22rtuse lahtrisse kirjutada soovid?");
			String muudetavV22rtus = sisse.readLine();
			
			System.out.println("Millist lahtri j2rgi muuta soovid(eesnimi/perekonnanimi/sugu/vanus/palk)?");
			String otsitavLahter = sisse.readLine();
			
			System.out.println("Millise v22rtuse j2rgi muuta soovid?");
			String otsitavV22rtus = sisse.readLine();
			
			if((muudetavLahter.equals("eesnimi") || muudetavLahter.equals("perekonnanimi") || muudetavLahter.equals("sugu")) &&
			(otsitavLahter.equals("eesnimi") || otsitavLahter.equals("perekonnanimi") || otsitavLahter.equals("sugu"))){
				String muutmiseK2sk = "UPDATE t66tajad SET "+muudetavLahter+"='"+muudetavV22rtus+"' WHERE "+otsitavLahter+"='"+otsitavV22rtus+"'";
				PreparedStatement st4=cn.prepareStatement(muutmiseK2sk);
				st4.executeUpdate();
			}else if((muudetavLahter.equals("eesnimi") || muudetavLahter.equals("perekonnanimi") || muudetavLahter.equals("sugu")) &&
			(otsitavLahter.equals("vanus") || otsitavLahter.equals("palk"))){
				String muutmiseK2sk = "UPDATE t66tajad SET "+muudetavLahter+"='"+muudetavV22rtus+"' WHERE "+otsitavLahter+"="+otsitavV22rtus;
				PreparedStatement st4=cn.prepareStatement(muutmiseK2sk);
				st4.executeUpdate();
			}else if((muudetavLahter.equals("vanus") || muudetavLahter.equals("palk")) &&
			(otsitavLahter.equals("eesnimi") || otsitavLahter.equals("perekonnanimi") || otsitavLahter.equals("sugu"))){
				String muutmiseK2sk = "UPDATE t66tajad SET "+muudetavLahter+"="+muudetavV22rtus+" WHERE "+otsitavLahter+"='"+otsitavV22rtus+"'";
				PreparedStatement st4=cn.prepareStatement(muutmiseK2sk);
				st4.executeUpdate();
			}else if((muudetavLahter.equals("vanus") || muudetavLahter.equals("palk")) &&
			(otsitavLahter.equals("vanus") || otsitavLahter.equals("palk"))){
				String muutmiseK2sk = "UPDATE t66tajad SET "+muudetavLahter+"="+muudetavV22rtus+" WHERE "+otsitavLahter+"="+otsitavV22rtus;
				PreparedStatement st4=cn.prepareStatement(muutmiseK2sk);
				st4.executeUpdate();
			}
		}else if(toiming.equals("n2itamine")){
			ResultSet rs=st1.executeQuery("SELECT eesnimi, perekonnanimi, sugu, vanus, palk FROM t66tajad;");
			while(rs.next()){
				System.out.println(rs.getString("eesnimi")+" "+rs.getString("perekonnanimi")+" "+rs.getString("sugu")+
				" "+rs.getInt("vanus")+" "+rs.getInt("palk"));
			}
		}
	}
}

//java -jar target/boot3-1.0-SNAPSHOT.jar baas.T66tajad
//mysql -uif17 -pif17 if17_kukltane
//mvn package