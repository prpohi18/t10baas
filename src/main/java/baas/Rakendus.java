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
    private jalgpallDAO jalgpallDao;
   
   @RequestMapping("/tervitus")
   public String tervita(String eesnimi){
   		return "Tere, "+ eesnimi;

   }

   @RequestMapping("/loetelu")
   public Iterable<jalgpall> loetelu(){
   		return jalgpallDao.findAll();
   }

   @RequestMapping("/lisa")
   public String lisa(String nimi, int vanus){
   		jalgpall k = new jalgpall();
   		k.nimi= nimi;
   		k.vanus=vanus;
   		jalgpallDao.save(k);
   		return "Lisati "+nimi;

   }
      @RequestMapping("/muuda")
   public String lisa(int id, String nimi, int vanus){
   		jalgpall k =jalgpallDao.findOne(id);
   		if(k==null){return "nr "+id+" puudub";}
   		k.nimi=nimi;
   		k.vanus=vanus;
   		jalgpallDao.save(k);
   		return "Muudeti "+nimi+" numbriga "+id;

   }
       @RequestMapping("/kustuta")
    public String kustuta(int id){
        jalgpall k=jalgpallDao.findOne(id);
        if(k==null){return id+" puudub";}
        jalgpallDao.delete(id);
        return id+" kustutatud";
    }



   public static void main(String[] args){
   		SpringApplication.run(Rakendus.class, args);

   		}
   }


