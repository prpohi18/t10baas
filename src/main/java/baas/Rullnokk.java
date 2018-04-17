package baas;
import javax.persistence.*;

@Entity
@Table(name="rullnokad")
public class Rullnokk{
    @Id
    public String nimi;
    public String mark;
    public String numbrimark;    
}