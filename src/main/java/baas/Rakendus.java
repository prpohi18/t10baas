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
    private Tudengid tudengid;
    
    @RequestMapping("/tervitus")
    String tervita(String eesnimi){
        return "Tere, "+eesnimi;
    }
	
	@RequestMapping("/lisa")
	public String lisa(String nimi, int id){
		Tudeng uus=new Tudeng();
		uus.nimi=nimi;
		uus.id=id;
		uus.kursus=1;
		tudengid.save(uus);
		return nimi+" salvestatud";
	}
	
	@RequestMapping("/loetelu")
	public Iterable <Tudeng> loetelu(){
		return tudengid.findAll();
	}
	
	@RequestMapping("/kustuta")
    public String kustuta(String nimi){
        Tudeng uus=tudengid.findOne(nimi);
        if(uus==null){return nimi+" puudub";}
        tudengid.delete(uus);
        return nimi+" kustutatud";
    }
	
    public static void main(String[] arg){
        SpringApplication.run(Rakendus.class, arg);
    }    
}