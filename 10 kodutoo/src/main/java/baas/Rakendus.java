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
    private AutodDAO autodDao;
   
   @RequestMapping("/tervitus")
   public String terevita(String eesnimi){
   		return "Tere, "+ eesnimi;

   }

   @RequestMapping("/loetelu")
   public Iterable<Autod> loetelu(){
   		return autodDao.findAll();
   }

   @RequestMapping("/lisa")
   public String lisa(String nimi, int aasta){
   		Autod k = new Autod();
   		k.nimi= nimi;
   		k.aasta=aasta;
   		autodDao.save(k);
   		return "Lisati "+nimi;

   }
      @RequestMapping("/muuda")
   public String lisa(int id, String nimi, int aasta){
   		Autod k =autodDao.findOne(id);
   		if(k==null){return "Auto nr "+id+" puudub";}
   		k.nimi= nimi;
   		k.aasta=aasta;
   		autodDao.save(k);
   		return "Muudeti "+nimi+" numbriga "+id;

   }
       @RequestMapping("/kustuta")
    public String kustuta(int id){
        Autod k=autodDao.findOne(id);
        if(k==null){return id+" puudub";}
        autodDao.delete(id);
        return id+" kustutatud";
    }



   public static void main(String[] args){
   		SpringApplication.run(Rakendus.class, args);

   		}
   }
