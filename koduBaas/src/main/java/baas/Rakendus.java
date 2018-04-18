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
    private PlaneetDAO PlaneetDAO;
	
	@RequestMapping("/tervitus")
    String tervita(String eesnimi){
        return "Tere, "+eesnimi;
    }
	
	@RequestMapping("/loetelu")
    public Iterable<Planeet> loetelu(){
        return PlaneetDAO.findAll();    
    }
	
	@RequestMapping("/lisa")
    public String lisa(String nimetus, int tihedus, int diameeter){
          Planeet p = new Planeet();
		  p.nimetus= nimetus;
		  p.tihedus= tihedus;
		  p.diameeter= diameeter;
		  PlaneetDAO.save(p);
		  return "Lisati " + nimetus;
    }
	
	@RequestMapping("/muuda")
    public String lisa(int id, String nimetus, int tihedus, int diameeter){
			Planeet p = PlaneetDAO.findOne(id);
			if(p==null){
				return "Planeet nr " +id+ " puudub";
			} else{
				p.nimetus= nimetus;
				p.tihedus= tihedus;
			 	p.diameeter= diameeter;
				PlaneetDAO.save(p);
				return "Muudeti " + nimetus+ " numbriga: " +id;
			}
			
    }
	
	@RequestMapping("/kustuta")
    public String kustuta(int id){
        Planeet p = PlaneetDAO.findOne(id);
        if(p==null){return "Planeet numbriga: "+id+" puudub";}
        PlaneetDAO.delete(p);
        return id+" kustutatud";
    }
    
    
	public static void main(String[] arg){
        SpringApplication.run(Rakendus.class, arg);
    } 
    
       
}