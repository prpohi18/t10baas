package baas;
import javax.persistence.*;

@Entity
@Table(name="maanteejalgrattad")
public class Maanteejalgrattad{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int id;
    public String mudel;
    public int aasta;    
}