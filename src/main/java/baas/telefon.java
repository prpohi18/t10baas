package baas;
import javax.persistence.*;

@Entity
@Table(name="telefonid")
public class telefon{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int id;
    public String tootja;
    public String mudel;    
}