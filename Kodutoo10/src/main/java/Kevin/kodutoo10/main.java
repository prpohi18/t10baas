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
    
    @RequestMapping("/delete")
    public String delete(int id) {
        telekas tv = telekasDao.findOne(id);
        if (tv == null) {
            return "Sellise id-ga pole.";
        }
        telekasDao.delete(tv);
        return "Telekas id-ga: " + id + " edukalt kustutatud.";
    }
    
    @RequestMapping("/list")
    public Iterable<telekas> list() {
        return telekasDao.findAll();
    }
    
    public static void main(String[] arg) {
        SpringApplication.run(main.class, arg);
    }
}
