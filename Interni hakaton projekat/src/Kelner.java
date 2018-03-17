
// Nasledjivanje (upotrebom rezervisane reci extends)

public class Kelner extends Osoba{
	
	int plata; 
	
	public Kelner(String ime, String prezime, String jmbg, int plata) {
		// Poziva se konstruktor nadklase koriscenjem reci "super"
		super(ime, prezime, jmbg);
		this.plata = plata;
	}
	
	void ispisi() {
		// Pozivanje metode "ispisi" nadklase (klase Osoba) koja ce da uradi ispis prva tri
		// podatka: ime, prezime, jmbg. Na ovaj nacin kod se ne ponavlja
		super.ispisi();
		System.out.println("Plata: " + plata);
	}
}
