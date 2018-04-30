package Kevin.kodutoo10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@SpringBootApplication

public class main {
    @Autowired
    private telekasDAO telekasDao;
    
    @RequestMapping("/add")
    public String addNew(int diagonaal, int hind) {
        telekas tv = new telekas();
        tv.diagonaal = diagonaal;
        tv.hind = hind;
        telekasDao.save(tv);
        return "Telekas daigonaaliga " + diagonaal + " edukalt salvestatud.";
    }
    
    public static void main(String[] arg) {
        SpringApplication.run(main.class, arg);
    }
}
