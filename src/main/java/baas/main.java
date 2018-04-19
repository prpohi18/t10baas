package baas;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@SpringBootApplication

public class main{
    @Autowired
    private telefonDAO telefonDao;
    
    @RequestMapping("/add")
    public String addNew(String mudel, String tootja){
        telefon telo = new telefon();
        telo.mudel = mudel;
        telo.tootja = tootja;
        telefonDao.save(telo);
        return mudel +" save successful";
    }

    @RequestMapping("/delete")
    public String delete(int id){
        telefon telo = telefonDao.findOne(id);
        if(telo==null){return "No record with that id found";}
		telefonDao.delete(telo);
		return id+" successfully deleted";
    }
    
    @RequestMapping("/list")
    public Iterable<telefon> list(){
        return telefonDao.findAll();
    }
    
    public static void main(String[] arg){
        SpringApplication.run(main.class, arg);
    }
}


//mvn package
//java -jar -Dserver.port=43256 target/baas1-1.jar
//http://greeny.cs.tlu.ee:43256/tervitus?eesnimi=Juku
