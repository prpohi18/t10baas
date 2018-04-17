//http://greeny.cs.tlu.ee:42534/tervitus?eesnimi=Mati
//java -jar -Dserver.port=42534 target/baas1-1.jar
//ctrl+c

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
    private RullnokkDAO rullnokkDao;
    
    @RequestMapping("/tervitus")
    String tervita(String eesnimi){
        return "Tere, "+eesnimi;
    }
	@RequestMapping("/lisa")
	public String lisa(String nimi, String mark, String numbrimark){
		Rullnokk isik=new Rullnokk();
		isik.nimi=nimi;
		isik.mark=mark;
		isik.numbrimark=numbrimark;
		rullnokkDao.save(isik);
		return nimi+" salvestatud";
	}
	
	@RequestMapping("/loetelu")
	public Iterable<Rullnokk> loetelu(){
		return rullnokkDao.findAll();
	}
	
	@RequestMapping("/kustuta")
	public String kustuta(String nimi){
		Rullnokk isik=rullnokkDao.findOne(nimi);
		if(isik==null){return nimi+" puudub";}
		rullnokkDao.delete(isik);
		return nimi+" kustuta";
	}
    
	public static void main(String[] arg){
        SpringApplication.run(Rakendus.class, arg);
    }    
}