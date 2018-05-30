package krislyn.andmebaas;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@SpringBootApplication
public class Rakendus{
    @Autowired
    private lapsDAO lapsDao;
    

    @RequestMapping("/loetelu")
    public Iterable<Laps> loetelu(){
        return lapsDao.findAll();
    }
    
    @RequestMapping("/lisa")
    public String lisa(String lapsenimi, int synniaasta){
        Laps l=new Laps();
        l.lapsenimi=lapsenimi;
        l.synniaasta=synniaasta;
        lapsDao.save(l);
        return "Lisati "+lapsenimi;
    }
    
    @RequestMapping("/muuda")
    public String lisa(int id, String lapsenimi, int synniaasta){
        Laps l=lapsDao.findOne(id);
        if(l==null){return "Laps järjekorranumbriga "+id+" puudub";}
        l.lapsenimi=lapsenimi;
        l.synniaasta=synniaasta;
        lapsDao.save(l);
        return "Muudeti "+lapsenimi+" järjekorranumbriga "+id;
    }


    @RequestMapping("/kustuta")
    public String kustuta(int id){
        Laps l=lapsDao.findOne(id);
        if(l==null){return "Laps järjekorranumbriga "+id+" puudub";}
        lapsDao.delete(l);
        return "Kustutati laps "+id;
    }
    
   
    
    public static void main(String[] args){
        SpringApplication.run(Rakendus.class, args);
    }
}