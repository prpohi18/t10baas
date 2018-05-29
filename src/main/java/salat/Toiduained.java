package salat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "toiduained")

public class Toiduained{
	
	@Id
	@GeneratedValue
	
	Integer id;
	String toiduainenimetus;
	Double valkudeprotsent;
	Double rasvadeprotsent;
	Double sysivesikuteprotsent;
		

	@Override
    public String toString() {
        return "<tr><td>" + id + "</td><td>" + toiduainenimetus + "</td><td>" + valkudeprotsent + "</td><td>" + rasvadeprotsent +
		"</td><td>" + sysivesikuteprotsent + "</td><td>";
    }
}