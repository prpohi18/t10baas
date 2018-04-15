package baasKodutoo;
import java.sql.*;
import java.io.*;
public class Lisamine{
    public static void lisa(Connection cn, String[] arg) throws Exception{
		int vanus;
		double pikkus;
		double kaal;
        PreparedStatement st=cn.prepareStatement("INSERT INTO inimesed VALUES(DEFAULT, ?, ?, ?)");
        st.setDouble(1, Integer.parseInt(arg[0]));
        st.setDouble(2, Double.parseDouble(arg[1]));
        st.setDouble(3, Double.parseDouble(arg[2]));
        st.executeUpdate();
    }
}

// lisamiseks
// java -jar target/boot3-1.0-SNAPSHOT.jar vanus pikkus kaal
// java -jar target/boot3-1.0-SNAPSHOT.jar 25 185.5 87.3

/*
java -jar target/boot3-1.0-SNAPSHOT.jar 25 185.5 87.3;
Argumente: 3
1 26 185.0 96.0
2 30 190.0 77.0
3 25 185.5 87.3
*/