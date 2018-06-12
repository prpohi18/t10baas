package kymnes;
import java.sql.*;
import java.lang.Double;

public class Ladu{
    public static void main(String args[]) throws Exception{
        String url = "jdbc:mysql://localhost/if17_Kalmer?user=if17&password=if17";
        Connection cn = DriverManager.getConnection(url);
    
        if(args[0].equals("lisamine")){
            String toode = args[1];
            Double hind = Double.parseDouble(args[2]);
            String saadavus = args[3];
            Lisamine.lisa(cn, toode, hind, saadavus);
        } else if (args[0].equals("kustutamine")){
            int id = Integer.parseInt(args[1]);
            Kustutamine.kustuta(cn, id);
        } else if (args[0].equals("vaatamine")){
            int id = Integer.parseInt(args[1]);
            Vaatamine.vaata(cn, id);
        } else {
            System.out.println("Käsklust ei leitud");
        }
    
    
    }
}