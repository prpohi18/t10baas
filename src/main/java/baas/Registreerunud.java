package baas;
import javax.persistence.*;

@Entity
@Table (name="registreerunud")
public class Registreerunud{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  public int id;
  public String nimi;
  public String perekonnanimi;
  public String email;
} 