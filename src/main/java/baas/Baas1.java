package baas;

import java.sql.*;
import java.lang.Double;

public class Baas1{
    public static void main(String[] arg) throws Exception{
        System.out.println("Argumente: "+arg.length);
        String url = "jdbc:mysql://localhost/if17_veli_4?user=if17&password=if17";
        Connection cn = DriverManager.getConnection(url);
        double a = Double.parseDouble(arg[0]);
        double b = Double.parseDouble(arg[1]);
        double c = Double.parseDouble(arg[2]);
        double x1 = (-b + Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / 2 * a;
        double x2 = (-b - Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / 2 * a;
        if(arg.length==3){
            Lisamine.lisa(cn, a, b, c, x1, x2);
        }
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery("SELECT id, a, b, c, x1, x2 FROM ruutvorrand");
        while(rs.next()){
            System.out.println(rs.getInt("id") + " " + rs.getDouble("a") + " " + rs.getDouble("b") + " " + rs.getDouble("c") 
            + " " + rs.getDouble("x1") + " " + rs.getDouble("x2"));
        }
    }
}