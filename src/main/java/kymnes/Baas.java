package kymnes;

import java.sql.*;
import java.lang.Double;

public class Baas {
    public static void main(String args[]) throws Exception {
        String url = "jdbc:mysql://localhost/if17_pukkdais?user=if17&password=if17";
        Connection cn = DriverManager.getConnection(url);
        
        if (args[0].equals("lisamine")) {
            String eesnimi = args[1];
            String perenimi = args[2];
            int vanus = Integer.parseInt(args[3]);
            
            Lisamine.lisa(cn, eesnimi, perenimi, vanus);
        } else if (args[0].equals("kustutamine")) {
            int id = Integer.parseInt(args[1]);
            Kustutamine.kustuta(cn, id);
        } else if (args[0].equals("vaatamine")) {
            int id = Integer.parseInt(args[1]);
            Vaatamine.vaata(cn, id);
        } else {
            System.out.println("Command not found.");
        }
    }
}