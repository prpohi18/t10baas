package Kevin.kodutoo10;

import javax.persistence.*;

@Entity
@Table(name="telekad")

public class telekas {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int id;
    public int diagonaal;
    public int hind;
}
