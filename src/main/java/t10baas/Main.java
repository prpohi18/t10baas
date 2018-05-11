package t10baas;
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)throws Exception {
        String mode;
        Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/t10baas?user=javatest&password=test");
        Scanner sc = new Scanner(System.in);
        System.out.print("Vali reziim - s (sisestamine), k (kustutamine), v (vaatamine), m (muutmine)");
        mode = sc.nextLine();
        System.out.println(mode);
        if (mode.equalsIgnoreCase("s")) {
            System.out.println("Palju õnne võistluse lõpetamise puhul!");
            System.out.print("Sisesta nimi: ");
            String name = sc.nextLine();
            System.out.print("Sisesta aeg: ");
            float time = sc.nextFloat();
            PreparedStatement st = cn.prepareStatement("INSERT INTO competitors VALUES (DEFAULT, ?, ?)");
            st.setString(1, name);
            st.setFloat(2, time);
            st.executeUpdate();
        } else if (mode.equalsIgnoreCase("k")){
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM competitors");
            while (rs.next()){
                System.out.println(rs.getInt("id") + " | " + rs.getString("name") + " | " + rs.getFloat("time"));
            }
            PreparedStatement pst = cn.prepareStatement("DELETE FROM competitors WHERE id = ?");
            System.out.print("Millist soovid kustutada? ");
            int selectedId = sc.nextInt();
            pst.setInt(1, selectedId);
            pst.executeUpdate();
            Statement lst = cn.createStatement();
            ResultSet lrs = lst.executeQuery("SELECT * FROM competitors");
            while (lrs.next()){
                System.out.println(rs.getInt("id") + " | " + rs.getString("name") + " | " + rs.getFloat("time"));
            }
        } else if (mode.equalsIgnoreCase("v")){
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM competitors ORDER BY time ASC");
            while (rs.next()){
                System.out.println(rs.getInt("id") + " | " + rs.getString("name") + " | " + rs.getFloat("time"));
            }
        } else if (mode.equalsIgnoreCase("m")){
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM competitors");
            while (rs.next()){
                System.out.println(rs.getInt("id") + " | " + rs.getString("name") + " | " + rs.getFloat("time"));
            }
            PreparedStatement pst = cn.prepareStatement("UPDATE competitors SET ?=? WHERE id = ?");
            System.out.print("Millist soovid muuta? ");
            int selectedId = sc.nextInt();
            pst.setInt(3, selectedId);
            System.out.print("Mida soovid muuta? ");
            String selectedCol = sc.next();
            pst.setString(1, selectedCol);
            System.out.print("Sisesta uus väärtus: ");
            if(selectedCol == "name"){
                String newVal = sc.next();
                pst.setString(2, newVal);
            } else if (selectedCol == "time"){
                float newVal = sc.nextFloat();
                pst.setFloat(2, newVal);
            }
            pst.executeUpdate();
            Statement lst = cn.createStatement();
            ResultSet lrs = lst.executeQuery("SELECT * FROM competitors");
            while (lrs.next()){
                System.out.println(rs.getInt("id") + " | " + rs.getString("name") + " | " + rs.getFloat("time"));
            }
        }
    }
}
