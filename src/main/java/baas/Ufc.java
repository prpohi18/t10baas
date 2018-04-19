package ufc_baas;
import javax.persistence.*;

@Entity
@Table(name="ufc")
public class Ufc{
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    public int id;
    public String nimi;
    public String riik;
    public int vanus;
    public float pikkus;
    public float kaal;
    public int v6ite;
}
