package baas;
import java.sql.*;
import java.io.*;
import java.lang.*;

public class Kustutamine{
	public static void kustuta() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Connection cn = DriverManager.getConnection("jdbc:mysql://greeny.cs.tlu.ee/if17_martandr?user=if17&password=if17");
		PreparedStatement st = cn.prepareStatement("DELETE FROM korvpall WHERE nimi=?");
		System.out.println("Sisesta korvpalluri nimi kustutamiseks: ");
		String inimene = br.readLine();
		st.setString(1, inimene);
		st.executeUpdate();
	}
} 