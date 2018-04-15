package baasKodutoo;
import java.sql.*;
public class Kustutamine{
    public static void kustuta(Connection cn, String[] arg) throws Exception{
		int id;
        PreparedStatement st=cn.prepareStatement("DELETE FROM inimesed WHERE ID=(?)");
        st.setDouble(1, Integer.parseInt(arg[0]));
        st.executeUpdate();
    }
}

// kustutamiseks
// java -jar target/boot3-1.0-SNAPSHOT.jar ID
// java -jar target/boot3-1.0-SNAPSHOT.jar 2

/*
java -jar target/boot3-1.0-SNAPSHOT.jar 2
Argumente: 1
1 26 185.0 96.0
3 30 180.1 90.3
*/