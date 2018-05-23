package baas;

import javax.persistence.*;
@Entity
@Table(name="Kassid")
public class kass{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int id;
	public String nimi;
	public int aasta;
}