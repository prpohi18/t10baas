package baas;
import javax.persistence.*;

@Entity
@Table(name="raamatud")
public class Raamat{
    @Id
    public String pealkiri;
    public String autor;
    public int laenutatud;    
}