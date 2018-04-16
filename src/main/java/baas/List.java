package baas;
import javax.persistence.*;

@Entity
@Table(name="listid")
public class List{
    @Id
    public String ylesanne;
    public String aine;
    public int olek;
}