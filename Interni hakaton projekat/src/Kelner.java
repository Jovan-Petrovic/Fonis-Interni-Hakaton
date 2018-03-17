
// Nasledjivanje (upotrebom rezervisane reci extends)

public class Kelner extends Zaposleni{
	 
	public Kelner(String ime, String prezime, String jmbg) {
		// Poziva se konstruktor nadklase koriscenjem reci "super"
		super(ime, prezime, jmbg);
	}
	
	void ispisi() {
		// Pozivanje metode "ispisi" nadklase (klase Osoba) koja ce da uradi ispis prva tri
		// podatka: ime, prezime, jmbg. Na ovaj nacin kod se ne ponavlja
		System.out.println("\nGlavni kelner");
		super.ispisi();
	}

	@Override
	public void izracunajPlatu(int brojSati) {
		plata = 150 * brojSati;
		System.out.println("Plata: " + plata);
	}
	
}

