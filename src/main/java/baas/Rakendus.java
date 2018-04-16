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
    private ListDAO listDao;
    
    @RequestMapping("/tervitus")
    String tervita(String eesnimi){
        return "Tere, "+eesnimi;
	}
	
	@RequestMapping("/loetelu")
	public Iterable<List> loetelu(){
		return listDao.findAll();
	}

	@RequestMapping("/lisa")
	public String lisa(String ylesanne, String aine){
		List l=new List();
		l.ylesanne=ylesanne;
		l.aine=aine;
		l.olek=0;
		listDao.save(l);
		return ylesanne+" salvestatud";
	}

	@RequestMapping("/muuda")
    public String lisa(String ylesanne, String aine, int olek){
        List l=listDao.findOne(aine);
        if(l==null){return "Aine: "+aine+" Ülesanded puuduvad!";}
        l.ylesanne=ylesanne;
		l.aine=aine;
		l.olek=olek;
        listDao.save(l);
        return "Aine: "+aine+" olek on muudetud"+olek;
    }

	@RequestMapping("/kustuta")
	public String kustuta(String ylesanne){
		List l=listDao.findOne(ylesanne);
		if(l==null) {return ylesanne+" puudub";}
		listDao.delete(l);
		return ylesanne+" kustutatud";
	}
    public static void main(String[] arg){
        SpringApplication.run(Rakendus.class, arg);
    }    
}

//mvn package
//java -jar -Dserver.port=42087 target/baas1-1.jar
//http://greeny.cs.tlu.ee:42087/tervitus?eesnimi=Liisa