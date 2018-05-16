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
    private MntJalgrattadDAO mntJalgrattadDao;
    
    @RequestMapping("/loetelu")
    public Iterable<Maanteejalgrattad> loetelu(){
        return mntJalgrattadDao.findAll();
		//http://greeny.cs.tlu.ee:20222/loetelu
    }
    
    @RequestMapping("/lisa")
    public String lisa(String mudel, int aasta){
        Maanteejalgrattad m=new Maanteejalgrattad();
        m.mudel=mudel;
        m.aasta=aasta;
        mntJalgrattadDao.save(m);
        return "Lisati "+mudel;
		//http://greeny.cs.tlu.ee:20222/lisa?mudel=Canyon_Aerod_SL&aasta=2018
    }
    
    
    @RequestMapping("/muuda")
    public String lisa(int id, String mudel, int aasta){
        Maanteejalgrattad m=mntJalgrattadDao.findOne(id);
        if(m==null){return "Maanteejalgratta nr "+id+" puudub";}
        m.mudel=mudel;
        m.aasta=aasta;
        mntJalgrattadDao.save(m);
        return "muudeti "+mudel+" numbriga "+id;
		//http://greeny.cs.tlu.ee:20222/muuda?id=2&mudel=Canyon_Endurace_SL&aasta=2018
    }

    @RequestMapping("/kustuta")
    public String kustuta(int id){
        Maanteejalgrattad m=mntJalgrattadDao.findOne(id);
        if(m==null){return "Koer nr "+id+" puudub";}
        mntJalgrattadDao.delete(m);
        return "kustutati maantejalgrattas "+id;
		//http://greeny.cs.tlu.ee:20222/kustuta?id=2
    }
    
   
    
    public static void main(String[] args){
        SpringApplication.run(Rakendus.class, args);
    }
}

//mvn package
//java -jar -Dserver.port=43256 target/baas1-1.jar
//http://greeny.cs.tlu.ee:20222/rataleht.html