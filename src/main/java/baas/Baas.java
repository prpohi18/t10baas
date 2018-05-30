package baas;
import java.sql.*;
public class Baas{
    public static void main(String[] arg) throws Exception{
        Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/if17_sulgdenn?user=if17&password=if17");
        Lisamine.Lisa();
        /*Statement st=cn.createStatement();
        ResultSet rs=st.executeQuery("SELECT id, trassityyp, tootja, kogus FROM kontserttrass");
        while(rs.next()){
            System.out.println(rs.getInt("id")+" "+rs.getString("tootja")+" "+rs.getString("trassityyp")+" trass "+rs.getInt("kogus")+" tükki"); //<-Syntax +
            //{id} Hiina kolmnurk trass 6 tükki
        }*/
    }
}