package baas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@SpringBootApplication
public class Rakendus{
    @Autowired
    private KoerDAO koerDao;

    @RequestMapping("/lisa")
    public String lisa(String koeranimi, int vanus, String sugu, String omanik){
        Koer loom=new Koer();
        loom.koeranimi=koeranimi;
        loom.vanus=vanus;
        loom.sugu=sugu;
        loom.omanik=omanik;
        koerDao.save(loom);
        return koeranimi+" salvestatud";
    }

    @RequestMapping("/loetelu")
    public Iterable<Koer> loetelu(){
        return koerDao.findAll();
    }

    @RequestMapping("/kustuta")
    public String kustuta(String koeranimi){
        Koer loom=koerDao.findOne(koeranimi);
        if(loom==null){return koeranimi+" puudub";}
        koerDao.delete(loom);
        return koeranimi+" kustutatud";
    }

    public static void main(String[] arg){
        SpringApplication.run(Rakendus.class, arg);
    }
}