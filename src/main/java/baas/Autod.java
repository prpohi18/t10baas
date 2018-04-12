package baas;

import javax.persistence.*;

@Entity
@Table (name="autod")
public class Autod{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int id;
	public String nimi;
	public int aasta;
}