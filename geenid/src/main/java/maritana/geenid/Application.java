package maritana.geenid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@SpringBootApplication
public class Application {

    @Autowired
    private sportsmanDAO sportsmanDAO;

    @RequestMapping("/lisa")
    public String add(String name, String email, int birthyear, int competitions){
        sportsman man=new sportsman();
        man.name = name;
        man.email=email;
        man.birthyear=birthyear;
        man.competitions=competitions;
        sportsmanDAO.save(man);
        return email+" salvestatud";
    }

    /*@RequestMapping("/Otsi")
    public String findGene(String name) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (GenesDB gene : GenesDAO.findAll()) {
            if (gene.name.equals(name)) {
                sb.
                    append("<tr>").
                    append("<td>"+gene.id+"</td>").
                    append("<td class=\"name\">"+gene.name+"</td>").
                    append("<td class=\"allele-1\">"+gene.allele1+"</td>").
                    append("<td class=\"allele-2\">"+gene.allele2+"</td>").
                    append("<td><input type=\"checkbox\"/></td>").
                    append("</tr>");
                i++;
            }
        }
        return sb.toString();
    }*/


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
