package Kodunetoo10;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@SpringBootApplication
public class Rakendus{
    @Autowired
    private LinkDAO linkDao;
    
    
    
    @RequestMapping("/loetelu")
    public Iterable<Link> loetelu(){
        return linkDao.findAll();
    }
    
    @RequestMapping("/lisa")
    public String lisa(String lkNimi, String url){
        Link l=new Link();
        l.lkNimi=lkNimi;
        l.url=url;
        linkDao.save(l);
        return "Lisati "+lkNimi;
    }
    
  
    @RequestMapping("/muuda")
    public String lisa(int id, String lkNimi, String url){
        Link l=linkDao.findOne(id);
        if(l==null){return "Link nr "+id+" puudub";}
        l.lkNimi=lkNimi;
        l.url=url;
        linkDao.save(l);
        return "muudeti "+lkNimi+" numbriga "+id;
    }
    
    

    @RequestMapping("/kustuta")
    public String kustuta(int id){
        Link l=linkDao.findOne(id);
        if(l==null){return "Link nr "+id+" puudub";}
        linkDao.delete(l);
        return "kustutati link "+id;
    }
    
   
    
    public static void main(String[] args){
        SpringApplication.run(Rakendus.class, args);
    }
}


