package salat;

public class Toiduaine{
	public String toiduainenimetus;
	public double valkudeprotsent; //%
	public double rasvadeprotsent; //%
	public double sysivesikuteprotsent; //%
	
	public Toiduaine(String toiduainenimetus, double valkudeprotsent, double rasvadeprotsent, double sysivesikuteprotsent){
			this.toiduainenimetus=toiduainenimetus;
			this.valkudeprotsent=valkudeprotsent;
			this.rasvadeprotsent=rasvadeprotsent;
			this.sysivesikuteprotsent=sysivesikuteprotsent;	
	}	
	@Override
    public String toString() {
        if ((rasvadeprotsent + sysivesikuteprotsent) > 100) {
            return "Protsent ei saa olla üle saja!";
        } else {
            return toiduainenimetus + ", " + valkudeprotsent + " g, " + rasvadeprotsent + " %, " + sysivesikuteprotsent + " %";
        }
    }
	
}