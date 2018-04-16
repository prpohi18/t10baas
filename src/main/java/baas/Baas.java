package baas;
import java.sql.*;
import java.util.Scanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;
@RestController
@SpringBootApplication
public class Baas {
    @RequestMapping("/")
    String rootFolder(){
        return "page!";
    }

    @RequestMapping("/baasins")
    String baasins(String mac)throws Exception{
        if ((mac.length()==17 || mac.length()==8) && mac.substring(2,3).equals(":") && mac.substring(5,6).equals(":")){
            putDB(mac);
            return macConvert(mac);
        }
        return "Sisesta andmed õigesti";
    }
    @RequestMapping("/baasget")
    String baasget()throws Exception{
        return getDB();
    }
 
    public static void main(String[] args) {
        SpringApplication.run(Baas.class, args);
    }
    public String macConvert(String macVendor){
        String aadress = macVendor.substring(0, 8);
        String vastus = "Andmed puuduvad";
        String[] aadressid={"00:e0:4c","00:23:DF","00:16:6B"};
        String[] vendor={"Realtek Semiconductor corp.", "Apple inc.", "Samsung Electronics"};
        for (int i=0; i < 3;i++ ) {
          if (aadress.equalsIgnoreCase(aadressid[i])) {
            vastus = vendor[i];
          }
        }
        return vastus;
      }

    public String getDB()throws Exception{
        Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/if17_timjaan?user=if17&password=if17");
    
        //Lisamine.lisa(kapsaRaadius, kapsaMass);
        String last = "?";
        Statement st=cn.createStatement();
        ResultSet rs=st.executeQuery("SELECT id, mac FROM macaddr;");
        while (rs.next()) {
            last = (rs.getString("mac"));
        }
        return last;
    }
    public boolean checkDB(String mac)throws Exception{
        Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/if17_timjaan?user=if17&password=if17");
        Statement st=cn.createStatement();
        ResultSet rs=st.executeQuery("SELECT id, mac FROM macaddr;");
        while (rs.next()) {
            if(rs.getString("mac").equals(mac)){
                return false;
            }
        }
        return true;
    }

    public boolean putDB(String mac)throws Exception{
        Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/if17_timjaan?user=if17&password=if17");
        PreparedStatement st=cn.prepareStatement("INSERT INTO macaddr VALUES (DEFAULT, ?)");
        st.setString(1, mac);
        st.executeUpdate();
        return true;

    }
}

//java -jar -Dserver.port=8008 target/boot3-1.0-SNAPSHOT.jar



