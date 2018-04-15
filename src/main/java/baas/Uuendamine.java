package baasKodutoo;
import java.sql.*;
public class Uuendamine{
    public static void uuenda(Connection cn, String[] arg) throws Exception{
		int vanus;
		double pikkus;
		double kaal;
		int id;
        PreparedStatement st=cn.prepareStatement("UPDATE inimesed SET vanus=(?), pikkus=(?), kaal=(?) WHERE ID =(?)");
        st.setInt(1, Integer.parseInt(arg[0]));
        st.setDouble(2, Double.parseDouble(arg[1]));
        st.setDouble(3, Double.parseDouble(arg[2]));
        st.setInt(4, Integer.parseInt(arg[3]));
        st.executeUpdate();
    }
}

// uuendamiseks
// java -jar target/boot3-1.0-SNAPSHOT.jar vanus pikkus kaal ID
// java -jar target/boot3-1.0-SNAPSHOT.jar 30 180.1 90.3 2

/*
Argumente: 3
1 26 185.0 96.0
2 30 190.0 77.0
3 25 185.5 87.3

java -jar target/boot3-1.0-SNAPSHOT.jar 30 180.1 90.3 3
Argumente: 4
1 26 185.0 96.0
2 30 190.0 77.0
3 30 180.1 90.3
*/



