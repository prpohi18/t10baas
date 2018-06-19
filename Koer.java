package baas;

import javax.persistence.*;

@Entity 
@Table (name="koerad")
public class Koer {
  @Id
  public String koeranimi;
  public int vanus;
  public String sugu;
  public String omanik;
}