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
    private koerDAO KoerDao;
	
	@RequestMapping("/tervitus")
	public String tervita(String eesnimi) {
		return "Tere, "+eesnimi;
	}
	
	@RequestMapping("/loetelu")
    public Iterable<koer> loetelu(){
        return KoerDao.findAll();    
    }
	
	@RequestMapping("/lisa")
    public String lisa(String koeranimi, int synniaasta){
		koer k=new koer();
		k.koeranimi=koeranimi;
		k.synniaasta=synniaasta;
        KoerDao.save(k);
		return "Lisati "+koeranimi;
    }
	
	@RequestMapping("/muuda")
    public String lisa(int id, String koeranimi, int synniaasta){
		koer k=KoerDao.findOne(id);
		if(k==null){return "Koer nr "+id+" puudub";}
		k.koeranimi=koeranimi;
		k.synniaasta=synniaasta;
        KoerDao.save(k);
		return "Muudeti "+koeranimi+" numbriga "+id;
    }
	
	@RequestMapping("/kustuta")
    public String kustuta(int id){
		koer k=KoerDao.findOne(id);
		if(k==null){return "Koer nr "+id+" puudub.";}
		KoerDao.delete(k);
		return "Kustutati koer numbriga "+id;
    }
	
	public static void main(String[] args) {
		SpringApplication.run(Rakendus.class, args);
	}
}

//mvn pavkage
//java -jar -Dserver.port=10619 target/baas1-1.jar
//http://greeny.cs.tlu.ee:10619/tervitus?eesnimi=Juku