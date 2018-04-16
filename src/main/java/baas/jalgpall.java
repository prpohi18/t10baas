package baas;

import javax.persistence.*;

@Entity
@Table (name="jalgpall")
public class jalgpall{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int id;
	public String nimi;
	public int vanus;
}