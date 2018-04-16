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
    private Raamatud raamatud;
    
    @RequestMapping("/tervitus")
    String tervita(String eesnimi){
        return "Tere, "+eesnimi;
    }
	
	@RequestMapping("/lisa")
	public String lisa(String pealkiri, String autor){
		Raamat uus=new Raamat();
		uus.pealkiri=pealkiri;
		uus.autor=autor;
		uus.laenutatud=1;
		raamatud.save(uus);
		return pealkiri+" salvestatud";
	}
	
	@RequestMapping("/loetelu")
	public Iterable <Raamat> loetelu(){
		return raamatud.findAll();
	}
	
	@RequestMapping("/kustuta")
    public String kustuta(String pealkiri){
        Raamat uus=raamatud.findOne(pealkiri);
        if(uus==null){return pealkiri+" puudub";}
        raamatud.delete(uus);
        return pealkiri+" kustutatud";
    }
	
    public static void main(String[] arg){
        SpringApplication.run(Rakendus.class, arg);
    }    
}
