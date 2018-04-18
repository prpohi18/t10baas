package ufc_baas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@SpringBootApplication
public class Ufcapp {
	@Autowired
	private UfcDAO ufcDao;
	
	public static void main(String[] args) {
		SpringApplication.run(Ufcapp.class, args);
	}

	@RequestMapping("/mitu")
	public long mitu() {
		long palju = ufcDao.count();
		return palju;
	}

	@RequestMapping("/voitlejad")
	public Iterable<Ufc> nimed() {
		return ufcDao.findAll();
	}
	
	@RequestMapping("/lisa") 
	public String lisa(String nimi, String riik, int vanus, float pikkus, float kaal, int voidud) {
		Ufc voitleja = new Ufc();
		voitleja.nimi = nimi;
        voitleja.riik = riik;
		voitleja.vanus = vanus;
        voitleja.pikkus = pikkus;
        voitleja.kaal = kaal;
        voitleja.v6ite = voidud;
		ufcDao.save(voitleja);
		return "Lisati " + voitleja.nimi;
	}
	
	@RequestMapping("/muuda")
	public String lisa(int id, int vanus) {
		Ufc voitleja = ufcDao.findById(id);
		if (voitleja == null) {return "ID-ga " + id + " võitleja puudub";}
		voitleja.vanus = vanus;
		ufcDao.save(voitleja);
		return "Muudeti " + voitleja.nimi + " vanus";
	}
	
	@RequestMapping("/kustuta")
	public String delete(int id) {
		Ufc voitleja = ufcDao.findById(id);
		if (voitleja == null) {return "ID-ga " + id + " võitleja puudub";}
		ufcDao.deleteById(id);
		return "Tabelist kustutati võitleja " + id + ": " + voitleja.nimi;
	}

	@RequestMapping("/kustutakoik")
	public String deleteAll() {
		if (ufcDao == null) {return "Tabel on juba tühi!";}
		ufcDao.deleteAll();
		return "Tabel on tühjendatud!";
	}
}