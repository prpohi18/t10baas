package baas;
import javax.persistence.*;

@Entity
@Table(name="tudengid")
public class Tudeng{
    @Id
    public String nimi;
    public int id;
    public int kursus;    
}