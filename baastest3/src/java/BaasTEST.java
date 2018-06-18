
import java.sql.*;
public class BaasTEST{
    
    
    //MySQL Workbenchis on local instance, user:root pass: XXX, port 3306
    
    public static void main(String[] arg) throws Exception{        
       // System.out.println("Proovin sisse logida:");
        Connection conn = null;
        try{
            DriverManager.getConnection(
             "jdbc:mysql://localhost:3306/test1","root","b1m2w3");
                if(conn !=null){
                    System.out.println("Connected!");   
                    Statement st=conn.createStatement();
                    ResultSet rs=st.executeQuery("SELECT nimi FROM nimed");
                    while(rs.next()){
                    System.out.println(rs.getString("nimi"));
                    }
                    
                }
        }
            
        catch(Exception e){
            System.out.println("NOT connected!");
            }
    }
        
}
       
