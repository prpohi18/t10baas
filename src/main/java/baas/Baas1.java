package baas;
import java.sql.*;
import java.util.Scanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;
@RestController
@SpringBootApplication
public class Baas1 {
	@RequestMapping("/algus")
    String tervitusfunktsioon() {
        return "Ahoi!";
    }
    
    @RequestMapping("/tervitus")
    String tervitus2(String eesnimi){
        return "Tere, "+eesnimi;
    }
    @RequestMapping("/korrutis")
    int korrutis(int arv1, int arv2){
        return arv1 * arv2;
    }
    @RequestMapping("/new")
    String BMI(Double height, Double weight)throws Exception{
            addNew(BMIfind(height, weight));
            return BMIfind(height, weight);
    }
    
    @RequestMapping("/getlatest")
    String baasget()throws Exception{
    return getLatest();
    }
 
    public static void main(String[] args) {
		//System.getProperties().put("server.port", 40305);
        SpringApplication.run(Baas1.class, args);
    }

    public String BMIfind(Double Height, Double Weight){
        String answer = "Fail";
        String[] answers={"Alakaal","Normaalkaal","Ülekaal","Rasvumine"};
        Double BMI = (Weight/((Height/100)*(Height/100)));
        answer=Double.toString(BMI);
        if(BMI<18.5){
            answer=answers[0];
        }else if(BMI>=18.5 && BMI<=25){
            answer=answers[1];
        }else if(BMI>25 && BMI<29.9){
            answer=answers[2];
        }else if(BMI>30){
            answer=answers[3];
        }
        return answer;
    }

    public String getLatest()throws Exception{
        String url = "jdbc:mysql://localhost/if17_kellrasm?user=if17&password=if17";
        Connection conn = DriverManager.getConnection(url);

        String last = "?";
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("SELECT id, value FROM bmi;");
        while (rs.next()) {
            last = (rs.getString("value"));
        }
        return last;
    }

    public boolean addNew(String BMI)throws Exception{
        String url = "jdbc:mysql://localhost/if17_kellrasm?user=if17&password=if17";
        Connection conn = DriverManager.getConnection(url);
        PreparedStatement st=conn.prepareStatement("INSERT INTO bmi VALUES (DEFAULT, ?)");
        st.setString(1, String.valueOf(BMI));
        st.executeUpdate();
        return true;
    }
}
