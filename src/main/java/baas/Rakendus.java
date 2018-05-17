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
  private RegistreerunudDAO registreerunudDao;

  @RequestMapping("/tervitus")
  public String tervita(String eesnimi){
    return "Tere, "+ eesnimi;
  }

  @RequestMapping("/loetelu")
  public Iterable<Registreerunud> loetelu(){
    return registreerunudDao.findAll();
  }

  @RequestMapping("/lisa")
  public String lisa(String nimi, String perekonnanimi, String email){
    Registreerunud k = new Registreerunud();
    k.nimi= nimi;
    k.perekonnanimi= perekonnanimi;
    k.email=email;
    registreerunudDao.save(k);
    return "Registreeriti" + nimi + " " + perekonnanimi;
  }

  @RequestMapping("/muuda")
  public String lisa(int id, String nimi, String perekonnanimi, String email){
    Registreerunud k =registreerunudDao.findOne(id);
    if(k==null){return "registreerunu "+id+" puudub";}
    k.nimi= nimi;
    k.perekonnanimi=perekonnanimi;
    k.email=email;
    registreerunudDao.save(k);
    return "Muudeti registreerunu "+nimi+" numbriga "+id;
  }

  @RequestMapping("/kustuta")
  public String kustuta(int id){
    Registreerunud k=registreerunudDao.findOne(id);
    if(k==null){return id+" puudub";}
    registreerunudDao.delete(id);
    return id+" kustutatud";
  }



  public static void main(String[] args){
    SpringApplication.run(Rakendus.class, args);
  }
}