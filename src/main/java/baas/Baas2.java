package baasKodutoo;
import java.sql.*;
public class Baas2{
    public static void main(String[] arg) throws Exception{        
        System.out.println("Argumente: "+arg.length);
        Connection cn=DriverManager.getConnection(
             "jdbc:mysql://localhost/if17_kerttamm_2?user=if17&password=if17");
        if(arg.length==3){
          Lisamine.lisa(cn, arg);
        }
		if(arg.length==4){
          Uuendamine.uuenda(cn, arg);
        }
		if(arg.length==1){
          Kustutamine.kustuta(cn, arg);
        }
        Statement st=cn.createStatement();
        ResultSet rs=st.executeQuery("SELECT id, vanus, pikkus, kaal FROM inimesed");
        while(rs.next()){
            System.out.println(rs.getInt("id")+" "+rs.getInt("vanus")+" "+rs.getDouble("pikkus")+" "+rs.getDouble("kaal"));
        }
    }
}

