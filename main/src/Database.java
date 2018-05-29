import java.sql.*;

public class Database{
    public static void main(String[] arg) throws Exception{
        System.out.println("Argumente: "+arg.length);
        Connection cn=DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mysql?user=kasutaja&password=parool123");
        if(arg.length==2){
            Adddata.add(cn, arg);
        }
        Statement st=cn.createStatement();
        ResultSet rs=st.executeQuery("SELECT id, weight, length from new_schema.bmitable");
        while(rs.next()){
            System.out.println(rs.getInt("id")+" "+rs.getInt("weight")+" "+rs.getDouble("length"));
        }
    }
}