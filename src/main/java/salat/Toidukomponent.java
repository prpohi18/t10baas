package salat;

/*public class Toidukomponent{
	Toiduaine toiduaine;
	double kogus;
	double rasvakogusearvutaja(){
		return(kogus*toiduaine.rasvadeprotsent)/100;
	}
}
*/
public class Toidukomponent{
    double kogus;
    Toiduaine sisu;
    public Toidukomponent(double kogus, Toiduaine sisu) {
        this.kogus = kogus;
        this.sisu = sisu;
    }
    public double rasvakogus() {
        return (kogus * (sisu.rasvadeprotsent / 100));
    }
    @Override
    public String toString() {
        return "kogus: " + kogus + " g" +", sisu: " + sisu + ", rasvakogus: " + rasvakogus();
    }
}