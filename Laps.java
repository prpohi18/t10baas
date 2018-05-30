
package krislyn.andmebaas;
import javax.persistence.*;

@Entity
@Table(name="lapsed")
public class Laps{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int id;
    public String lapsenimi;
    public int synniaasta;    
}