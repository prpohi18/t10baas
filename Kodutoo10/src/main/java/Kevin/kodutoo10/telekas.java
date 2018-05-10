package Kevin.kodutoo10;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="telekad")

public class telekas implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int id;
    public int diagonaal;
    public int hind;
}
