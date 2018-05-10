package baas;

import javax.persistence.*;
@Entity
@Table(name="koerad")
public class koer{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int id;
	public String koeranimi;
	public int synniaasta;
}