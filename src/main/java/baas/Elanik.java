package baas;
import javax.persistence.*;

@Entity
@Table(name="elanikud")
public class Elanik{
    @Id
    public String nimi;
    public int korter;
    public double kommunaalid;
    public String tasumine;
}
