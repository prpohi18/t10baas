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
    private kassDAO KassDao;
	
	@RequestMapping("/tervitus")
	public String tervita(String eesnimi) {
		return "Tere, "+eesnimi;
	}
	
	@RequestMapping("/loetelu")
    public Iterable<kass> loetelu(){
        return KassDao.findAll();    
    }
	
	@RequestMapping("/lisa")
    public String lisa(String nimi, int aasta){
		kass k=new kass();
		k.nimi=nimi;
		k.aasta=aasta;
        KassDao.save(k);
		return "Lisati "+nimi;
    }
	
	@RequestMapping("/muuda")
    public String lisa(int id, String nimi, int aasta){
		kass k=KassDao.findOne(id);
		if(k==null){return "Kass nr "+id+" puudub";}
		k.nimi=nimi;
		k.aasta=aasta;
        KassDao.save(k);
		return "Muudeti "+nimi+" numbriga "+id;
    }
	
	@RequestMapping("/kustuta")
    public String kustuta(int id){
		kass k=KassDao.findOne(id);
		if(k==null){return "Kass nr "+id+" puudub.";}
		KassDao.delete(k);
		return "Kustutati kass numbriga "+id;
    }
	
	public static void main(String[] args) {
		SpringApplication.run(Rakendus.class, args);
	}
}

//mvn pavkage
//java -jar -Dserver.port=10619 target/baas1-1.jar
//http://greeny.cs.tlu.ee:10619/tervitus?eesnimi=Juku