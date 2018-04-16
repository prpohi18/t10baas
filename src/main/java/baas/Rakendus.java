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
    private ElanikDAO elanikDao;
    
    @RequestMapping("/elanikud")
    public String lisa(String nimi, int korter, double kommunaalid, String tasumine){
        Elanik isik=new Elanik();
        isik.nimi = nimi;
        isik.korter = korter;
        isik.kommunaalid = kommunaalid;
        isik.tasumine = tasumine;
        elanikDao.save(isik);
        return nimi +" salvestatud";

    }

    @RequestMapping("/kustuta")
    public String kustuta(String nimi){
        Elanik isik=elanikDao.findOne(nimi);
        if(isik==null){return nimi+"puudub";}
		elanikDao.delete(isik);
		return nimi+" kustutatud";
    }
    
    @RequestMapping("/loetelu")
    public Iterable<Elanik> loetelu(){
        return elanikDao.findAll();
    }
    
    public static void main(String[] arg){
        SpringApplication.run(Rakendus.class, arg);
    }

    //http://greeny.cs.tlu.ee:36770/ElanikeLeht.html
}