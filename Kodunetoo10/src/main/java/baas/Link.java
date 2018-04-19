package Kodunetoo10;
import javax.persistence.*;

@Entity
@Table(name="lingid")
public class Link{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int id;
    public String lkNimi;
    public String url;    
}