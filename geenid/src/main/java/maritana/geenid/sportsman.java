package maritana.geenid;

import javax.persistence.*;
// import jdk.nashorn.internal.ir.annotations.Immutable;

@Entity
@Table (name="sportsman")

public class sportsman {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public int id;
    public String name;
    public String email;
    public int birthyear;
    public int competitions;

    @Override
    public String toString(){
        return "sportlane " +name+ "e-mail: " +email + "sünniaastal: " + birthyear + "võistlustearv: " + competitions;
    }
}
