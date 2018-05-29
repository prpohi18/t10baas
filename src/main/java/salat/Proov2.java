package salat;

/*public class Proov1{
	public static void main(String[] arg){
		Toiduaine toiduaine1 = new Toiduaine("Kartul", 5.0, 10.0, 45.0); //valgud, rasvad, süsivesikud (%)
		Toiduaine toiduaine2 = new Toiduaine("Hapukoor", 10.0, 30.0, 40.0);
		Toiduaine toiduaine3 = new Toiduaine("Vorst", 15.0, 20.0, 35.0);
		
		Toidukomponent komponent1 = new Toidukomponent();
		Toidukomponent komponent2 = new Toidukomponent();
		Toidukomponent komponent3 = new Toidukomponent();
		
		komponent1.toiduaine = toiduaine1;
		komponent2.toiduaine = toiduaine2;
		komponent3.toiduaine = toiduaine3;
		
		komponent1.kogus = 100.0; //kartuleid grammides
		komponent2.kogus = 30.0; //hapukoort grammides
		komponent3.kogus = 50.0; //vorsti grammides
		
		//Kõigi komponendite rasvakoguse arvutamine
		System.out.println(komponent1.rasvakogusearvutaja());
		System.out.println(komponent2.rasvakogusearvutaja());
		System.out.println(komponent3.rasvakogusearvutaja());
	}
	
}

*/

public class Proov2{
    public static void main(String[] args) {
        Toiduaine t1 = new Toiduaine("kartul", 1.71, 15.3, 20.01);
        Toiduaine t2 = new Toiduaine("hapukoor", 2.9, 30, 10.2);
        Toiduaine t3 = new Toiduaine("vorst", 1.02, 27, 5.8);
        Toidukomponent k1 = new Toidukomponent(100, t1);
        Toidukomponent k2 = new Toidukomponent(30, t2);
        Toidukomponent k3 = new Toidukomponent(50, t3);
        System.out.println(k1);
        System.out.println(k2);
        System.out.println(k3);
    }
}