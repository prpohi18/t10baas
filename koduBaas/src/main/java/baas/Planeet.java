package baas;
import javax.persistence.*;

@Entity
@Table(name="planeedid")
public class Planeet{
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int id;
	public String nimetus;
	public int tihedus; // g/cm3
	public int diameeter; // km
}