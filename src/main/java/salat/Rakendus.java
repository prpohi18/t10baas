package salat;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.sql.*;
import java.lang.Double;
import java.sql.PreparedStatement;

@RestController
@SpringBootApplication
public class Rakendus{
	//private final TabeliHaldur tabeliHaldur;
	//@Autowired
	//public Rakendus(TabeliHaldur tabeliHaldur){
	//	this.tabeliHaldur = tabeliHaldur;
	//}
	// SAAB TOIDUAINET LISADA
	@RequestMapping("/lisa")
	String lisa(String toiduainenimetus, Double valkudeprotsent, Double rasvadeprotsent, Double sysivesikuteprotsent) throws Exception{
		
		String vastus = "test";
        String url = "jdbc:mysql://localhost/if17_piksar_2?user=if17&password=if17";
        Connection cn = DriverManager.getConnection(url);
        PreparedStatement pst = cn.prepareStatement("INSERT INTO kt2 VALUES(DEFAULT, ?, ?, ?, ?)");
		pst.setString(1, toiduainenimetus);
        pst.setDouble(2, valkudeprotsent);
        pst.setDouble(3, rasvadeprotsent);
        pst.setDouble(4, sysivesikuteprotsent);
        pst.executeUpdate();
		
		vastus = toiduainenimetus + " on andmebaasi salvestatud!";
        
        return vastus;

		//Toiduained toiduained = new Toiduained();
		//toiduained.toiduainenimetus = toiduainenimetus;
		//toiduained.valkudeprotsent = valkudeprotsent;
		//toiduained.rasvadeprotsent = rasvadeprotsent;
		//toiduained.sysivesikuteprotsent = sysivesikuteprotsent;
		
	//http://greeny.cs.tlu.ee:40310/lisa?toiduainenimetus=kala&valkudeprotsent=1&rasvadeprotsent=2&sysivesikuteprotsent=3
	//http://localhost:5556/lisa?toiduainenimetus=kala&valkudeprotsent=1&rasvadeprotsent=2&sysivesikuteprotsent=3
		
	/*	if((valkudeprotsent + rasvadeprotsent + sysivesikuteprotsent) > 100){
			return "Valkude-, rasvade- ja süsivesikute protsent ei saa olla suurem kui 100(%).";
		} else {
			tabeliHaldur.save(toiduained);
			return "Lisatud: " + toiduainenimetus + valkudeprotsent + rasvadeprotsent + sysivesikuteprotsent;
		}*/
	}
	//SAAB TOIDUAINET KUSTUTADA NIMETUSE JÄRGI.
	//http://localhost:5556/kustuta?toiduainenimetus=kala
	//greeny.cs.tlu.ee:40310/kustuta?toiduainenimetus=kala
	@RequestMapping("/kustuta")
    String kustuta(String toiduainenimetus) throws Exception{
        String vastus = "test";
        String url = "jdbc:mysql://localhost/if17_piksar_2?user=if17&password=if17";
        Connection cn = DriverManager.getConnection(url);
        PreparedStatement pst = cn.prepareStatement("DELETE FROM kt2 WHERE toiduainenimetus = ?");
        pst.setString(1, toiduainenimetus);
        pst.executeUpdate();

        if (toiduainenimetus != null) {
            vastus = toiduainenimetus + " kustutati andmebaasist.";
        } else {
            vastus = "Sellist toiduainet ei ole andmebaasis!";
        }

        return vastus;
    }
	
	// SAAB OTSIDA TOIDUAINET RASVASISALDUSE JÄRGI
	@RequestMapping("/otsi")
    String otsi(double alates, double kuni) throws Exception{
        String vastus = "test";
        String url = "jdbc:mysql://localhost/if17_piksar_2?user=if17&password=if17";
        Connection cn = DriverManager.getConnection(url);
        PreparedStatement pst = cn.prepareStatement("SELECT * from kt2 WHERE rasvadeprotsent >= ? AND rasvadeprotsent <= ?");
        pst.setDouble(1, alates);
        pst.setDouble(2, kuni);
        ResultSet rs = pst.executeQuery();

        while(rs.next()){
            vastus = vastus + "(" + rs.getInt("id") + ") " + rs.getString("toiduainenimetus") + " " + rs.getDouble("valkudeprotsent") 
            + " " + rs.getDouble("rasvadeprotsent") + " " + rs.getDouble("sysivesikuteprotsent") + " || ";
        }
		
        return vastus;
    }
	
	//SAAB OTSIDA TOIDUAINE NIMETUSE JÄRGI TOIDUAINET, KUS NÄEB RASVADE-,VALKUDE- JA SÜSIVESIKUTE PROTSENTI
	
	//http://localhost:5556/vaatakoiki?toiduainenimetus=kala
	//greeny.cs.tlu.ee:40310/vaatakoiki?toiduainenimetus=kala
	
	@RequestMapping("/vaatakoiki")
    String vaata(String toiduainenimetus) throws Exception{
        String vastus = "test";
        String url = "jdbc:mysql://localhost/if17_piksar_2?user=if17&password=if17";
        Connection cn = DriverManager.getConnection(url);
        PreparedStatement pst = cn.prepareStatement("SELECT * from kt2 WHERE toiduainenimetus = ?");
        pst.setString(1, toiduainenimetus);
        ResultSet rs = pst.executeQuery();

        while(rs.next()){
            vastus = "(" + rs.getInt(" id ") + ") " + rs.getString(" toiduainenimetus ") + " " + rs.getDouble(" valkudeprotsent ") 
            + " " + rs.getDouble(" rasvadeprotsent ") + " " + rs.getDouble(" sysivesikuteprotsent ");
        }

		
        return vastus;
    }
	
	/*
	
	//NÄIDISRETSEPTI kartulisalat loomine
	@RequestMapping("/kartuliSalat")
	//String, kuhu küsitakse sisse vajalik_kogus
	public String kartuliSalat(double vajalik_kogus) throws Exception {
		String vastus = "test";
        String url = "jdbc:mysql://localhost/if17_piksar_2?user=if17&password=if17";
		//Loob uue objekti kartul ja annab objektile omadused
		Toiduained kartul = new Toiduained(1, "kartul", 50, 8, 10);
		Toiduained hapukoor = new Toiduained(2, "hapukoor", 15, 50, 20);
		Toiduained vorst = new Toiduained(3, "vorst", 43, 30, 10);
		//Toiduained muna = new Toiduained(4, "muna", 10, 20, 32);
		//Toiduained juust = new Toiduained(5, "juust", 12, 30, 40);

	//Loob uue objekti Toidukomponent kartulid ja annab sellele kartuli omadused ja lisaks selle kartuli koguse
	//Loon retsepti
		Toidukomponendid kartulid = new Toidukomponendid();
		kartulid.toiduaine = kartul;
		kartulid.kogus = 34;

		Toidukomponendid hapukoored = new Toidukomponendid();
		hapukoored.toiduaine = hapukoor;
		hapukoored.kogus = 10;

		Toidukomponendid vorstid = new Toidukomponendid();
		vorstid.toiduaine = vorst;
		vorstid.kogus = 7;

		//Toidukomponendid munad = new Toidukomponendid();
		//munad.toiduaine = muna;
		//munad.kogus = 10;

		//Toidukomponendid juustud = new Toidukomponendid();
		//juustud.toiduaine = juust;
		//juustud.kogus = 15;

		Salat kartuliSalat = new Salat();
		kartuliSalat.nimetus = "kartulisalat";
	//Toidukomponentid lisab listi toiduKomponendidList
		kartuliSalat.toiduKomponendidList.add(kartulid);
		kartuliSalat.toiduKomponendidList.add(hapukoored);
		kartuliSalat.toiduKomponendidList.add(vorstid);
		//kartuliSalat.toiduKomponendidList.add(munad);
		//kartuliSalat.toiduKomponendidList.add(juustud);

	//Saadab salati komponentide vajaliku koguse arvutamiseks info arvutamisemeetodisse
		return kartuliSalat.vajalikKogus(vajalik_kogus);
		}
		
	//SALATI LOOMINE
	@RequestMapping("/salat")
		public String toiduKomponent() {
				Toiduained kartul = new Toiduained(1, "kartul", 50, 8, 10);
				Toiduained hapukoor = new Toiduained(2, "hapukoor", 15, 50, 20);
				//Toiduained vorst = new Toiduained(3, "vorst", 43, 30, 10);
				//Toiduained muna = new Toiduained(4, "muna", 10, 20, 32);
				//Toiduained juust = new Toiduained(5, "juust", 12, 30, 40);


				Toidukomponendid kartulid = new Toidukomponendid();
				kartulid.toiduaine = kartul;
				kartulid.kogus = 34;

				Toidukomponendid hapukoored = new Toidukomponendid();
				hapukoored.toiduaine = hapukoor;
				hapukoored.kogus = 10;

				Toidukomponendid vorstid = new Toidukomponendid();
				vorstid.toiduaine = vorst;
				vorstid.kogus = 7;

				//Toidukomponendid munad = new Toidukomponendid();
				//munad.toiduaine = muna;
				//munad.kogus = 10;

				//Toidukomponendid juustud = new Toidukomponendid();
				//juustud.toiduaine = juust;
				//juustud.kogus = 15;

				Salat kartuliSalat = new Salat();
				kartuliSalat.nimetus = "kartulisalat";
				kartuliSalat.toiduKomponendidList.add(kartulid);
				kartuliSalat.toiduKomponendidList.add(hapukoored);
				kartuliSalat.toiduKomponendidList.add(vorstid);
				//kartuliSalat.toiduKomponendidList.add(munad);
				//kartuliSalat.toiduKomponendidList.add(juustud);

				return kartuliSalat.toString();
		}
	
*/
	
	public static void main(String[] args) {
        SpringApplication.run(Rakendus.class, args);
    }
	
}