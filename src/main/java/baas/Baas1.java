package baas;
import java.sql.*;
import java.util.Scanner;
public class Baas1{
    public static boolean Lisamine(int tubade_arv, double ruutmeetrit, int hind, Connection cn )throws Exception{


    PreparedStatement st=cn.prepareStatement("INSERT INTO korterid VALUES(DEFAULT, ?, ?, ?)");
    st.setInt(1, tubade_arv);
    st.setDouble(2, ruutmeetrit);
    st.setInt(3, hind);
    st.executeUpdate();
    return true;
    }

    public static void main(String[] arg) throws Exception{
      Scanner scanner = new Scanner(System.in);
      System.out.print("Palun sisesta korteri tubade arv: ");
      int tubade_arv = Integer.parseInt(scanner.next());
      System.out.print("Palun sisesta korteri pindala: ");
      double ruutmeetrit = Double.parseDouble(scanner.next());
      System.out.print("Palun sisesta korteri hind: ");
      int hind = Integer.parseInt(scanner.next());



      Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/if17_kogejaro?user=if17&password=if17");
      Lisamine(tubade_arv, ruutmeetrit, hind, cn);
      Statement st=cn.createStatement();
      ResultSet rs=st.executeQuery("SELECT tubade_arv, ruutmeetrit, hind FROM korterid ");
      while(rs.next()){
          System.out.println(rs.getInt("tubade_arv")+" "+rs.getDouble("ruutmeetrit")+" "+rs.getInt("hind"));
      }


  }
}
