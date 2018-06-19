
import java.sql.*;
public class BaasTEST{
    
    
    //MySQL Workbenchis on local instance, user:root pass: XXX, port 3306, baas: test1, tabel:nimi
    
    public static void main(String[] arg) throws Exception{        
       // System.out.println("Proovin sisse logida:");
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(
             "jdbc:mysql://localhost:3306/test1","root","b1m2w3");              //ühendun baasiga
                if(conn!=null){
                    System.out.println("Connection established!");              //annab teada, et on ühendatud
                    Statement st=conn.createStatement();                        //saadan päringu
                    ResultSet rs=st.executeQuery("SELECT nimi FROM nimed");     //küsin tabelist nime
                    while(rs.next()){                                           //kui on nimi olemas
                        System.out.println("Tabelis olev nimi: "+rs.getString("nimi"));                   //annab mulle siin nime kätte
                    }
                    
                }
        } catch (Exception e){
            System.out.println("NOT connected!");
            }
     System.out.println(conn);    
   }
}
       
/*-   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -
run:
Connection established!
Tabelis olev nimi: Juku
Tabelis olev nimi: Miku
com.mysql.jdbc.JDBC4Connection@6f2b958e
BUILD SUCCESSFUL (total time: 1 second)
*/

/*  -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   
SQL käsklused

CREATE TABLE nimed (nimi VARCHAR(10));
INSERT INTO nimed (nimi) VALUES ("Juku");
INSERT INTO nimed (nimi) VALUES ("Miku");

*/