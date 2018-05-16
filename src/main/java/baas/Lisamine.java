package baas;
import java.lang.*;
import java.io.*;
import java.sql.*;
public class Lisamine{
    public static void Lisa() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/if17_sulgdenn?user=if17&password=if17");
        PreparedStatement st=cn.prepareStatement("INSERT INTO kontserttrass VALUES (DEFAULT, ?, ?, ?)");

        System.out.println("Mida soovid teha? (lisada/muuta/n2ita):");
        String p2ring = br.readLine();
        
        if(p2ring.equals("muuta")){
            /*System.out.println("Millist tulpa muuta soovid? (tootja, trassityyp, kogus)");
            String muutuvTulp = br.readLine();
            System.out.println("Milline väärtus tulbas <<"+muutuvTulp+">>?");
            String lahtriV22rtus = br.readLine();
            System.out.println("Mis tuleb " + muutuvTulp + " tulba väärtuse <<"+lahtriV22rtus+">> asemele?");*/
            System.out.println("Millist lahtrit muuta soovid(tootja, trassityyp, kogus)?");
			String muudetavLahter = br.readLine();
			
			System.out.println("Millise v22rtuse lahtrisse kirjutada soovid?");
			String muudetavV22rtus = br.readLine();
			
			System.out.println("Millist lahtri j2rgi muuta soovid(tootja, trassityyp, kogus)?");
			String otsitavLahter = br.readLine();
			
			System.out.println("Millise v22rtuse j2rgi muuta soovid?"); 
			String otsitavV22rtus = br.readLine();

            String k2skMuuta = "UPDATE kontserttrass SET "+muudetavLahter+"='"+muudetavV22rtus+"' WHERE "+otsitavLahter+"='"+otsitavV22rtus+"'";
            PreparedStatement st4=cn.prepareStatement(k2skMuuta);
            st4.executeUpdate();

        }else if(p2ring.equals("lisada")){
            System.out.println("Sisesta tootja: ");
            String tootja = br.readLine(); //<-Syntax +
            System.out.println("Sisesta trassityyp: ");
            String trassityyp = br.readLine(); 
            System.out.println("Sisesta kogus: ");
            int kogus = Integer.parseInt(br.readLine());
            st.setString(1, trassityyp); //<-Syntax +
            st.setString(2, tootja);
            st.setInt(3, kogus); //<-Syntax +
            st.executeUpdate();            
        }
        else if (p2ring.equals("n2ita")){
            ResultSet rs=st.executeQuery("SELECT trassityyp, tootja, kogus FROM kontserttrass;");
			while(rs.next()){
                //System.out.println(rs.getString("trassityyp")+" "+rs.getString("tootja")+" "+rs.getInt("kogus"));
                System.out.println(rs.getString("tootja")+" "+rs.getString("trassityyp")+" trass "+rs.getInt("kogus")+" tükki");
			}
        }

    }
}

//mysql -uif17 -pif17 if17_sulgdenn
//mvn package
//java -jar target/boot3-1.0-SNAPSHOT.jar baas.kontserttrass
