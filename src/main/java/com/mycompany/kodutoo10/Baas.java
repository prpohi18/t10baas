package com.mycompany.kodutoo10;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@SpringBootApplication

public class Baas{
    @Autowired
    private AutoDAO autoDAO;
    
    @RequestMapping("/add")
    public String addNew(String mark, String mudel, int aasta){
        Auto auto = new Auto();
        auto.mark = mark;
        auto.mudel = mudel;
        auto.aasta = aasta;
        autoDAO.save(auto);
        return mark +" save successful";
    }

    @RequestMapping("/delete")
    public String delete(int id){
        Auto auto = autoDAO.findOne(id);
        if(auto==null){return "No record with that id found";}
		autoDAO.delete(auto);
		return id+" successfully deleted";
    }
    
    @RequestMapping("/list")
    public Iterable<Auto> list(){
        return autoDAO.findAll();
    }
    
    public static void main(String[] arg){
        SpringApplication.run(Baas.class, arg);
    }
}
